package cn.lu.generator.common;

/**
 * 生成代码的表类型
 * 注：目前只支持Single
 *
 * @author lutiehua
 * @date 2018/3/1
 */
public interface TableType {

    /**
     * 单表
     */
    String TABLE_TYPE_SINGLE = "Single";

    /**
     * 主表
     */
    String TABLE_TYPE_MAIN = "Main";

    /**
     * 子表
     */
    String TABLE_TYPE_SUB = "Sub";

}
