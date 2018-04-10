package cn.lu.generator.core;

import cn.lu.generator.dto.GeneratorParam;

/**
 * 通用接口
 *
 * @author lutiehua
 * @date 2017/11/10
 */
public interface Generator {

    /**
     * 自动生成工程和代码
     *
     * @param generatorParam
     * @throws Exception
     */
    void generateProject(GeneratorParam generatorParam) throws Exception;

    /**
     * 自动生成代码
     *
     * @param generatorParam
     * @throws Exception
     */
    void generateCode(GeneratorParam generatorParam) throws Exception;
}
