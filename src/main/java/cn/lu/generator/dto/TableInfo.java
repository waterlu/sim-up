package cn.lu.generator.dto;

import cn.lu.generator.common.TableType;
import cn.lu.generator.entity.DBField;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * 数据库表信息
 *
 * @author lutiehua
 * @date 2017/11/9.
 */
@Data
public class TableInfo {

    /**
     * 表的名称
     */
    @NotBlank
    private String name;

    /**
     * 表的注释
     */
    private String remark;

    /**
     * 表的类型
     *
     * Single：独立表
     * Main: 主表
     * Sub：子表
     */
    @NotBlank
    private String type = TableType.TABLE_TYPE_SINGLE;

    /**
     * 主键字段名称
     */
    private String key;

    /**
     * 主键类型
     *
     * ID：主键是自增ID（Long）
     * UUID：主键是UUID（String）
     *
     */
    private String keyType;

    /**
     * 连接表（Single不用）
     */
    private String main;

    /**
     * 连接字段（Single不用）
     */
    private String join;

    /**
     * 查询字段（选填）
     */
    private List<String> query;

    /**
     * 字段列表
     */
    List<DBField> fieldList;
}
