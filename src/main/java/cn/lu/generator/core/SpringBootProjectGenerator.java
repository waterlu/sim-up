package cn.lu.generator.core;

import cn.lu.generator.common.KeyType;
import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.dto.TableInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成SpringBoot项目文件
 *
 * @author lutiehua
 * @date 2017/11/10
 */
@Component
public class SpringBootProjectGenerator implements Generator {

    private MybatisGenerator mybatisGenerator = new MybatisGenerator();

    /**
     * 自动生成工程和代码
     *
     * @param generatorParam
     * @throws Exception
     */
    @Override
    public void generateProject(GeneratorParam generatorParam) throws Exception {
        // 待生成的文件列表
        List<GeneratedFile> generatedFileList = new ArrayList();

        // POM
        generatedFileList.add(new GeneratedPomFile(generatorParam));

        // Git ignore
        generatedFileList.add(new GeneratedGitIgnoreFile(generatorParam));

        // Application
        generatedFileList.add(new GeneratedJavaAppClass(generatorParam));

        // ApplicationTest
        generatedFileList.add(new GeneratedJavaAppTestClass(generatorParam));

        // application.properties
        generatedFileList.add(new GeneratedAppPropFile(generatorParam));

        // application-dev.properties
        generatedFileList.add(new GeneratedAppDevPropFile(generatorParam));

        // application-test.properties
        generatedFileList.add(new GeneratedAppTestPropFile(generatorParam));

        // application-test2.properties
        generatedFileList.add(new GeneratedAppTest2PropFile(generatorParam));

        // application-local.properties
        generatedFileList.add(new GeneratedAppLocalPropFile(generatorParam));

        // boot.properties
        generatedFileList.add(new GeneratedBootPropFile(generatorParam));

        // log4j2
        generatedFileList.add(new GeneratedLog4j2File(generatorParam));

        // WebConfig
        generatedFileList.add(new GeneratedJavaConfigClass(generatorParam, null));

        // 遍历每个表生成对应的服务类文件  生成Controller/Service/Model
        for (TableInfo tableInfo : generatorParam.getTables()) {
            generateByTable(generatedFileList, generatorParam, tableInfo);
        }

        // generator-config.json
        generatedFileList.add(new GeneratedConfigFile(generatorParam));

        // 生成代码
        for (GeneratedFile generatedFile : generatedFileList) {
            generatedFile.generateFile();
        }
    }

    /**
     * 自动生成代码
     *
     * @param generatorParam
     */
    @Override
    public void generateCode(GeneratorParam generatorParam) throws Exception {

        // 待生成的文件列表
        List<GeneratedFile> generatedFileList = new ArrayList();

        // 遍历每个表生成对应的服务类文件  生成Controller/Service/Model
        for (TableInfo tableInfo : generatorParam.getTables()) {
            generateByTable(generatedFileList, generatorParam, tableInfo);
        }

        // 生成代码
        for (GeneratedFile generatedFile : generatedFileList) {
            generatedFile.generateFile();
        }
    }

    private void generateByTable(List<GeneratedFile> generatedFileList, GeneratorParam generatorParam, TableInfo tableInfo) throws Exception {
        // Controller
        generatedFileList.add(new GeneratedJavaControllerClass(generatorParam, tableInfo));

        // Service
        generatedFileList.add(new GeneratedJavaServiceClass(generatorParam, tableInfo));

        // ServiceImpl
        generatedFileList.add(new GeneratedJavaServiceImplClass(generatorParam, tableInfo));

        // DTO
        generatedFileList.add(new GeneratedJavaDTOClass(generatorParam, tableInfo));

        // QueryParamDTO
        generatedFileList.add(new GeneratedJavaQueryClass(generatorParam, tableInfo));

        // VO
        generatedFileList.add(new GeneratedJavaVOClass(generatorParam, tableInfo));

        // InsertListMapper
        if (KeyType.KEY_TYPE_ID.equalsIgnoreCase(tableInfo.getKeyType())) {
            generatedFileList.add(new GeneratedJavaInsertListMapperClass(generatorParam, tableInfo));
        }

        // 生成实体类对象
        mybatisGenerator.generateModelAndMapper(generatorParam, tableInfo);
    }
}