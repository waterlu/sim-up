package cn.lu.generator.core;

import cn.lu.generator.dto.GeneratorParam;

/**
 * Created by lutiehua on 2017/11/10.
 */
public class GeneratedAppDevPropFile extends AbstractGeneratedPropFile {

    private String fileName;

    public GeneratedAppDevPropFile(GeneratorParam generatorParam) {
        super(generatorParam);

        String rootDir = generatorParam.getPackageInfo().getProjectPath();
        String resourcePath = generatorParam.getPackageInfo().getResourcePath();
        fileName = rootDir + "/" + resourcePath + "/" + "application-dev.properties";
    }

    /**
     * 模板
     *
     * @return
     */
    @Override
    public String getTemplateName() {
        return "app-dev-properties.ftl";
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
