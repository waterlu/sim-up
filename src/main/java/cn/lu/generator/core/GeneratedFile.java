package cn.lu.generator.core;

/**
 * 自动生成文件的抽象接口
 *
 * @author lutiehua
 * @date 2018/2/28
 */
public interface GeneratedFile {

    /**
     * 生成文件
     *
     * @return
     * @throws Exception
     */
    boolean generateFile() throws Exception;
}
