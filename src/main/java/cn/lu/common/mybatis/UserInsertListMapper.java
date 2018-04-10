package cn.lu.common.mybatis;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import tk.mybatis.mapper.provider.SpecialProvider;

import java.util.List;

/**
 * 这只是一个例子，使用时请定义自己的Mapper
 * <p>需要把keyProperty修改为自己的自增主键字段（例子为userId）</>
 *
 * @author lutiehua
 * @date 2018/01/31
 */
public interface UserInsertListMapper<T> {

    /**
     * 批量写入（自增ID）
     *
     * keyProperty = "userId"，指定自增主键属性名称，其他的都不用修改
     *
     * @param recordList
     * @return
     */
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
    int insertList(List<T> recordList);
}