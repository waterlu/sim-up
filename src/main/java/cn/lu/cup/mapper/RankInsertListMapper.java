//package cn.lu.cup.mapper;
//
//import org.apache.ibatis.annotations.InsertProvider;
//import org.apache.ibatis.annotations.Options;
//import tk.mybatis.mapper.provider.SpecialProvider;
//
//import java.util.List;
//
///**
// * 查询参数对象
// *
// * @author waterlu
// * @date 2018-04-03
// */
//public interface RankInsertListMapper<T> {
//
//    /**
//     * 批量写入（自增ID）
//     *
//     * @param recordList
//     * @return
//     */
//    @Options(useGeneratedKeys = true, keyProperty = "RankId")
//    @InsertProvider(type = SpecialProvider.class, method = "dynamicSQL")
//    int insertList(List<T> recordList);
//}