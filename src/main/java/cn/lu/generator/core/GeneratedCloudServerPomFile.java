package cn.lu.generator.core;


import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.model.DataModel;
import cn.lu.generator.model.PomModel;

/**
 * Spring Cloud 的 POM 文件，包含两个module
 *
 * @author lutiehua
 * @date 2018/01/23
 */
public class GeneratedCloudServerPomFile extends AbstractGeneratedFile {

    private PomModel model;

    private String fileName;

    public GeneratedCloudServerPomFile(GeneratorParam generatorParam) {
        super(generatorParam);

        model = new PomModel();
        model.setProjectInfo(generatorParam.getProjectInfo());
        model.setDependencies(generatorParam.getDependencies());

        String rootDir = generatorParam.getPackageInfo().getProjectPath();
        fileName = rootDir + "/" + "pom.xml";

        model.setProjectType(generatorParam.getProjectInfo().getProjectType());
    }

    /**
     * 模板
     *
     * @return
     */
    @Override
    public String getTemplateName() {
        return "cloud/pom-cloud-server.ftl";
    }

    /**
     * 变量数据
     *
     * @return
     */
    @Override
    public DataModel getDataModel() {
        return model;
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
