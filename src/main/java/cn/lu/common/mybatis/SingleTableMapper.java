package cn.lu.common.mybatis;

import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.RowBoundsMapper;

/**
 * 单表Mapper的基类
 * <p>提供了基础的单表CRUD方法</p>
 *
 * @author lutiehua
 * @date 2018/01/31
 */
public interface SingleTableMapper<T> extends BaseMapper<T>, RowBoundsMapper<T> {

}