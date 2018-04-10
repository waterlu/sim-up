package cn.lu.generator.core;

import cn.lu.generator.dto.GeneratorParam;

/**
 * 本地环境配置
 *
 * @author lutiehua
 * @date 2018/3/2
 */
public class GeneratedAppLocalPropFile extends AbstractGeneratedPropFile {

    private String fileName;

    public GeneratedAppLocalPropFile(GeneratorParam generatorParam) {
        super(generatorParam);

        String rootDir = generatorParam.getPackageInfo().getProjectPath();
        String resourcePath = generatorParam.getPackageInfo().getResourcePath();
        fileName = rootDir + "/" + resourcePath + "/" + "application-local.properties";
    }

    /**
     * 模板名称
     *
     * @return
     * @throws Exception
     */
    @Override
    public String getTemplateName() throws Exception {
        return "app-local-properties.ftl";
    }

    /**
     * 文件名称
     *
     * @return
     */
    @Override
    public String getFileName() {
        return fileName;
    }
}
