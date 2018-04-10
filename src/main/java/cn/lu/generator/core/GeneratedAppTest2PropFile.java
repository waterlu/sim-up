package cn.lu.generator.core;

import cn.lu.generator.dto.GeneratorParam;

/**
 * 测试环境2配置文件
 *
 * @author lutiehua
 * @date 2017/11/10
 */
public class GeneratedAppTest2PropFile extends AbstractGeneratedPropFile {

    private String fileName;

    public GeneratedAppTest2PropFile(GeneratorParam generatorParam) {
        super(generatorParam);

        String rootDir = generatorParam.getPackageInfo().getProjectPath();
        String resourcePath = generatorParam.getPackageInfo().getResourcePath();
        fileName = rootDir + "/" + resourcePath + "/" + "application-test2.properties";
    }

    /**
     * 模板
     *
     * @return
     */
    @Override
    public String getTemplateName() {
        return "app-test2-properties.ftl";
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
