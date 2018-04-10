package cn.lu.common.doc;

import cn.zjhf.kingold.cloud.common.doc.model.DataModel;
import cn.zjhf.kingold.cloud.common.doc.model.InterfaceModel;
import cn.zjhf.kingold.cloud.common.doc.model.RequestModel;
import cn.zjhf.kingold.cloud.common.doc.model.ResponseModel;
import cn.zjhf.kingold.cloud.common.vo.ListResultVO;
import cn.zjhf.kingold.cloud.common.web.ResponseResult;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import io.swagger.models.*;
import io.swagger.models.parameters.BodyParameter;
import io.swagger.models.parameters.Parameter;
import io.swagger.models.parameters.QueryParameter;
import io.swagger.models.properties.Property;
import io.swagger.models.properties.RefProperty;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiaody
 * @description
 * @date create in 17/11/15
 */
@Slf4j
public class GeneratedDocFile {

    private final static Splitter SPLITTER = Splitter.on("Using");

    private final static String RESPONSE_OK = "200";

    private final static String RESPONSE_NOTE = "list";

    private final static String SIMPLE_RESULT_VO = "SimpleResultVO";

    private final static String RESPONSE_RESULT = "ResponseResult";

    private String filePath;

    private String templateName = "doc.ftl";

    public GeneratedDocFile(String filePath) {
        this.filePath = filePath;
    }


    /**
     * 生成文件
     *
     * @return
     * @throws Exception
     */
    public void generateFile(Map<String, Path> paths, Map<String, List<DataModel>> dataModels) throws Exception {
        log.info("begin generate doc file");
        paths.forEach((k, v) ->
                v.getOperations().forEach(i -> {
                    try {
                        generateFile(buildInterfaceModel(k, i, dataModels));
                    } catch (Exception e) {
                        e.printStackTrace();
                        log.error(e.getMessage());
                    }
                }));
    }

    /**
     * 构建接口模型
     *
     * @param key
     * @param operation
     * @param dataModels
     * @return
     */
    private InterfaceModel buildInterfaceModel(String key, Operation operation, Map<String, List<DataModel>> dataModels) {
        InterfaceModel model = new InterfaceModel();
        model.setName(operation.getSummary());
        model.setDesc(operation.getSummary());
        model.setUrl(key);
        List<String> split = SPLITTER.splitToList(operation.getOperationId());
        model.setMethod(split.get(split.size() - 1).split("_")[0]);
        model.setRequest(buildRequestModel(operation, dataModels, model));
        model.setResponse(buildResponseModel(operation, dataModels));
        return model;
    }


    /**
     * 构建请求的RequestModel
     *
     * @param operation
     * @param dataModels
     * @return
     */
    private RequestModel buildRequestModel(Operation operation, Map<String, List<DataModel>> dataModels, InterfaceModel interfaceModel) {
        RequestModel requestModel = new RequestModel();
        List<DataModel> params = new ArrayList<>();
        List<DataModel> paramsFilter = new ArrayList<>();
        List<Parameter> parameters = operation.getParameters();
        parameters.forEach(i -> {
            //RequestBody 参数
            if (i instanceof BodyParameter) {
                Model model = ((BodyParameter) i).getSchema();
                if (model instanceof RefModel) {
                    params.addAll(dataModels.get(((RefModel) model).getSimpleRef()));
                } else if (model instanceof ModelImpl) {
                    params.add(new DataModel(i.getName(), i.getRequired(), i.getIn(), i.getDescription()));
                }
            } else if (i instanceof QueryParameter) {
                // RequestParam 参数
                params.add(new DataModel(i.getName(), i.getRequired(), ((QueryParameter) i).getType(), i.getDescription()));
            }
        });

        paramsFilter.addAll(params.stream().filter(item -> !(Objects.equals(item.getName(), "callSystemID")
                || Objects.equals(item.getName(), "traceID"))).collect(Collectors.toList()));
        requestModel.setParams(paramsFilter);
        requestModel.setSample(buildRequestSample(interfaceModel, params));
        return requestModel;
    }


    private String buildRequestSample(InterfaceModel model, List<DataModel> params) {
        String sample;
        Map<String, Object> paramsMap = buildMockData(params);
        if (Objects.equals(model.getMethod(), HttpMethod.GET.name())) {
            final String[] paramStr = {""};
            paramsMap.forEach((k, v) -> paramStr[0] += k + "=" + v + "&");
            if (!Strings.isNullOrEmpty(paramStr[0])) {
                sample = model.getUrl() + "?" + paramStr[0].substring(0, paramStr[0].length() - 1);
            } else {
                sample = model.getUrl();
            }
        } else {
            sample = model.getUrl() + "\n\nrequest body:\n" + format(JSON.toJSONString(paramsMap));
        }
        return sample;
    }

    /**
     * 构建响应的ResponseModel
     *
     * @param operation
     * @param dataModels
     * @return
     */
    private ResponseModel buildResponseModel(Operation operation, Map<String, List<DataModel>> dataModels) {
        ResponseModel responseModel = new ResponseModel();
        Map<String, Response> responses = operation.getResponses();
        responses.forEach((k, v) -> {
            if (Objects.equals(k, RESPONSE_OK)) {
                Property schema = v.getSchema();
                ResponseResult result = new ResponseResult();
                if (schema instanceof RefProperty) {
                    RefProperty refProperty = (RefProperty) schema;
                    if (Objects.equals(refProperty.getSimpleRef(), SIMPLE_RESULT_VO)) {
                        result.setData("uuid or id");
                    } else if (!Objects.equals(refProperty.getSimpleRef(), RESPONSE_RESULT)) {
                        responseModel.setResult(dataModels.get(refProperty.getSimpleRef()));
                        Map<String, Object> resultVO = buildMockData(dataModels.get(refProperty.getSimpleRef()));
                        if (Objects.equals(RESPONSE_NOTE, operation.getDescription())) {
                            ListResultVO<Map<String, Object>> listResultVO = new ListResultVO<>();
                            listResultVO.setCount(1L);
                            listResultVO.setList(Lists.newArrayList(resultVO));
                            result.setData(listResultVO);
                        } else {
                            result.setData(resultVO);
                        }
                    }
                }
                responseModel.setSample(format(JSON.toJSONString(result)));
            }
        });
        return responseModel;
    }

    /**
     * 生成mock响应数据
     *
     * @param dataModels
     * @return
     */
    private Map<String, Object> buildMockData(List<DataModel> dataModels) {
        Map<String, Object> mockResult = new HashMap<>(16);
        dataModels.forEach(i -> mockResult.put(i.getName(), buildMockDataByType(i.getType())));
        return mockResult;
    }

    /**
     * 根据字段类型生成mock数据
     *
     * @param type
     * @return
     */
    private Object buildMockDataByType(String type) {
        switch (type) {
            case "string":
                return "string";
            case "integer":
                return 0;
            case "number":
                return 0;
            case "date":
                return "2017-11-16";
            default:
                return "";
        }
    }


    /**
     * 将文件通过模版生成出来
     *
     * @param model
     * @throws Exception
     */
    private void generateFile(InterfaceModel model) throws Exception {
        // 读取模板
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        cfg.setClassForTemplateLoading(this.getClass(), "/templates/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template template = cfg.getTemplate(this.templateName);

        // 创建空文件
        String fileName = model.getUrl().replaceAll("/", "-").substring(1) + "-" + model.getMethod() + ".md";

        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        File file = new File(filePath + File.separator + fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        // 根据模板生成文件
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
        template.process(model, writer);
        writer.flush();
        writer.close();
        log.info("generate {} finished", fileName);
    }

    public String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for (int i = 0; i < jsonStr.length(); i++) {
            char c = jsonStr.charAt(i);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }

        return jsonForMatStr.toString();
    }

    private String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }
}
