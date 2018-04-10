package cn.lu.generator.core;

import cn.lu.generator.dto.GeneratorParam;
import com.alibaba.fastjson.JSON;
import com.google.common.base.Strings;

import java.io.File;
import java.io.FileWriter;

/**
 * 自动生成代码的配置文件
 *
 * @author lutiehua
 * @date 2018/2/28
 */
public class GeneratedConfigFile implements GeneratedFile {

    /**
     * 生成参数
     */
    protected GeneratorParam generatorParam;

    /**
     * 文件目录
     */
    protected String fileDir;

    /**
     * 构造函数
     *
     * @param generatorParam
     */
    public GeneratedConfigFile(GeneratorParam generatorParam) {
        this.generatorParam = generatorParam;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    /**
     * 生成文件
     *
     * @return
     * @throws Exception
     */
    @Override
    public boolean generateFile() throws Exception {
        String fileName = null;

        if (Strings.isNullOrEmpty(fileDir)) {
            // Path信息
            String rootDir = generatorParam.getPackageInfo().getProjectPath();
            String resourcePath = generatorParam.getPackageInfo().getResourcePath();

            // 文件在resources目录下
            fileName = String.format("%s/%s/generator-config.json", rootDir, resourcePath);
        } else {
            fileName = String.format("%s/generator-config.json", fileDir);
        }

        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();

        // 写入配置
        String jsonString = JSON.toJSONString(generatorParam, true);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(jsonString);
        fileWriter.flush();
        fileWriter.close();
        return true;
    }
}
