package cn.lu.generator.core;

import cn.lu.generator.dto.GeneratorParam;
import com.google.common.base.CaseFormat;
import com.google.common.base.Splitter;

import java.util.List;

/**
 * Created by lutiehua on 2017/9/28.
 */
public class GeneratedJavaAppTestClass extends GeneratedJavaAppClass {

    private String fileName;

    public GeneratedJavaAppTestClass(GeneratorParam generatorParam) {
        super(generatorParam);

        String projectName = generatorParam.getProjectInfo().getName();
        projectName = CaseFormat.LOWER_HYPHEN.to(CaseFormat.UPPER_CAMEL, projectName.toLowerCase());
        String className = projectName + "ApplicationTests";
        String packageName = generatorParam.getPackageInfo().getBasePackage();
        String rootDir = generatorParam.getPackageInfo().getProjectPath();
        String testPath = generatorParam.getPackageInfo().getTestPath();
        List<String> list = Splitter.on(".").splitToList(packageName);
        StringBuffer buffer = new StringBuffer();
        for (String path : list) {
            buffer.append(path);
            buffer.append("/");
        }
        model.setClassName(className);
        String packagePath = buffer.toString();
        fileName = rootDir + "/" + testPath + "/" + packagePath + className + ".java";
    }

    /**
     * 模板
     *
     * @return
     */
    @Override
    public String getTemplateName() {
        return "app-test.ftl";
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
