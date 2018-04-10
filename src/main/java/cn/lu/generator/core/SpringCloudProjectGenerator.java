package cn.lu.generator.core;

import cn.lu.generator.common.KeyType;
import cn.lu.generator.dto.GeneratorParam;
import cn.lu.generator.dto.TableInfo;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成SpringCloud项目文件
 *
 * @author lutiehua
 * @date 2017/11/10
 */
@Component
public class SpringCloudProjectGenerator implements Generator {

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

        /**
         * 最外层的项目文件
         */

        // POM.xml
        generatedFileList.add(new GeneratedCloudPomFile(generatorParam));

        // Git ignore
        generatedFileList.add(new GeneratedGitIgnoreFile(generatorParam));

        String rootDir = generatorParam.getPackageInfo().getProjectPath();
        String projectName = generatorParam.getProjectInfo().getArtifactId();

        /**
         * 接口项目文件
         */
        String jsonString = JSON.toJSONString(generatorParam);
        GeneratorParam facadeParam = JSON.parseObject(jsonString, GeneratorParam.class);

        // 修改根目录
        String projectDir = rootDir + "/" + projectName + "-facade";
        facadeParam.getPackageInfo().setProjectPath(projectDir);

        // 接口项目的pom.xml
        generatedFileList.add(new GeneratedCloudFacadePomFile(facadeParam));

        // 遍历每个表生成对应的接口类文件
        generateFacadeByTable(generatedFileList, facadeParam);

        // FeignConfig
        generatedFileList.add(new GeneratedJavaFeignConfigClass(facadeParam, null));

        /**
         * 服务项目文件
         */

        GeneratorParam serverParam = JSON.parseObject(jsonString, GeneratorParam.class);

        // 修改根目录
        projectDir = rootDir + "/" + projectName + "-server";
        serverParam.getPackageInfo().setProjectPath(projectDir);

        // 接口项目的pom.xml
        generatedFileList.add(new GeneratedCloudServerPomFile(serverParam));

        // Application
        generatedFileList.add(new GeneratedJavaAppClass(serverParam));

        // ApplicationTest
        generatedFileList.add(new GeneratedJavaAppTestClass(serverParam));

        // application.properties
        generatedFileList.add(new GeneratedAppPropFile(serverParam));

        // application-dev.properties
        generatedFileList.add(new GeneratedAppDevPropFile(serverParam));

        // application-test1.properties
        generatedFileList.add(new GeneratedAppTestPropFile(serverParam));

        // application-test2.properties
        generatedFileList.add(new GeneratedAppTest2PropFile(serverParam));

        // application-local.properties
        generatedFileList.add(new GeneratedAppLocalPropFile(serverParam));

        // boot.properties
        generatedFileList.add(new GeneratedBootPropFile(serverParam));

        // log4j2
        generatedFileList.add(new GeneratedLog4j2File(serverParam));

        // WebConfig
        generatedFileList.add(new GeneratedJavaConfigClass(serverParam, null));

        // 遍历每个表生成对应的服务类文件
        generateServerByTable(generatedFileList, serverParam);

        // generator-config.json
        GeneratedConfigFile generatedConfigFile = new GeneratedConfigFile(generatorParam);
        String fileDir = serverParam.getPackageInfo().getProjectPath() + "/" + serverParam.getPackageInfo().getResourcePath();
        generatedConfigFile.setFileDir(fileDir);
        generatedFileList.add(generatedConfigFile);

        /**
         * 统一生成文件
         */

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

        String rootDir = generatorParam.getPackageInfo().getProjectPath();
        String projectName = generatorParam.getProjectInfo().getArtifactId();

        /**
         * 接口项目代码
         */
        // 修改根目录
        String projectDir = rootDir + "/" + projectName + "-facade";
        generatorParam.getPackageInfo().setProjectPath(projectDir);

        // 遍历每个表生成对应的接口类文件
        generateFacadeByTable(generatedFileList, generatorParam);

        /**
         * 服务项目文件
         */
        // 修改根目录
        projectDir = rootDir + "/" + projectName + "-server";
        generatorParam.getPackageInfo().setProjectPath(projectDir);

        // 遍历每个表生成对应的服务类文件
        generateServerByTable(generatedFileList, generatorParam);

        /**
         * 统一生成文件
         */

        // 生成代码
        for (GeneratedFile generatedFile : generatedFileList) {
            generatedFile.generateFile();
        }
    }

    private void generateFacadeByTable(List<GeneratedFile> generatedFileList, GeneratorParam generatorParam) throws Exception {
        for (TableInfo tableInfo : generatorParam.getTables()) {
            // DTO
            generatedFileList.add(new GeneratedJavaDTOClass(generatorParam, tableInfo));

            // QueryParamDTO
            generatedFileList.add(new GeneratedJavaQueryClass(generatorParam, tableInfo));

            // VO
            generatedFileList.add(new GeneratedJavaVOClass(generatorParam, tableInfo));

            // Client
            generatedFileList.add(new GeneratedJavaControllerFacadeClass(generatorParam, tableInfo));

            // Fallback
            generatedFileList.add(new GeneratedJavaControllerFacadeFallbackClass(generatorParam, tableInfo));
        }
    }

    private void generateServerByTable(List<GeneratedFile> generatedFileList, GeneratorParam generatorParam) throws Exception {
        for (TableInfo tableInfo : generatorParam.getTables()) {
            // Controller
            generatedFileList.add(new GeneratedJavaControllerImplClass(generatorParam, tableInfo));

            // Service
            generatedFileList.add(new GeneratedJavaServiceClass(generatorParam, tableInfo));

            // ServiceImpl
            generatedFileList.add(new GeneratedJavaServiceImplClass(generatorParam, tableInfo));

            // InsertListMapper
            if (KeyType.KEY_TYPE_ID.equalsIgnoreCase(tableInfo.getKeyType())) {
                generatedFileList.add(new GeneratedJavaInsertListMapperClass(generatorParam, tableInfo));
            }

            // 生成实体类对象
            mybatisGenerator.generateModelAndMapper(generatorParam, tableInfo);
        }
    }
}
