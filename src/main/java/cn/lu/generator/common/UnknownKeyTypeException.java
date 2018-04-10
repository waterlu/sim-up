package cn.lu.generator.common;

/**
 * @author lutiehua
 * @date 2018/3/2
 */
public class UnknownKeyTypeException extends Exception {

    public UnknownKeyTypeException(String tableName) {
        super("表" + tableName + "不能自动识别主键类型");
    }
}
