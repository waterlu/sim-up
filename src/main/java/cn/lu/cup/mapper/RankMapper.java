package cn.lu.cup.mapper;

import cn.lu.cup.entity.Rank;
import cn.zjhf.kingold.cloud.common.mapper.SingleTableMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface RankMapper extends SingleTableMapper<Rank>, RankInsertListMapper<Rank> {
}