package cn.lu.generator.common;

/**
 * @author lutiehua
 * @date 2018/3/2
 */
public class MissingKeyFieldException extends Exception {

    public MissingKeyFieldException(String tableName) {
        super("表" + tableName + "缺少主键");
    }

}
