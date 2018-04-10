package cn.lu.generator.core;


import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.model.DataModel;
import cn.lu.generator.model.PomModel;

/**
 * Created by lutiehua on 2017/11/10.
 */
public class GeneratedPomFile extends AbstractGeneratedFile {

    private PomModel model;

    private String fileName;

    public GeneratedPomFile(GeneratorParam generatorParam) {
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
        return "pom.ftl";
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
