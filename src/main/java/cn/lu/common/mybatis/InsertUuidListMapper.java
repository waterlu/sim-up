package cn.lu.common.mybatis;


import org.apache.ibatis.annotations.InsertProvider;

import java.util.List;

/**
 * 批量Insert（表主键是UUID：需要自己赋值）
 * <p>需要批量写入功能时继承这个接口</p>
 *
 * @author lutiehua
 * @date 2018/02/01
 */
public interface InsertUuidListMapper<T> {

    /**
     * 批量写入（主键非自动生成）
     *
     * @param recordList
     * @return
     */
    @InsertProvider(type = KingoldProvider.class, method = "dynamicSQL")
    int insertUuidList(List<T> recordList);
}