package cn.lu.generator.core;


import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.model.DataModel;

/**
 * Created by lutiehua on 2017/11/10.
 */
public class GeneratedGitIgnoreFile extends AbstractGeneratedFile {

    private String fileName;

    public GeneratedGitIgnoreFile(GeneratorParam generatorParam) {
        super(generatorParam);

        String rootDir = generatorParam.getPackageInfo().getProjectPath();
        fileName = rootDir + "/" + ".gitignore";
    }

    /**
     * 模板
     *
     * @return
     */
    @Override
    public String getTemplateName() {
        return "git-ignore.ftl";
    }

    /**
     * 变量数据
     *
     * @return
     */
    @Override
    public DataModel getDataModel() {
        return new DataModel();
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
