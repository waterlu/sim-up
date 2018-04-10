package cn.lu.cup.mapper;

import cn.lu.common.mybatis.SingleTableMapper;
import cn.lu.cup.entity.SubjectLevel;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectLevelMapper extends SingleTableMapper<SubjectLevel>, SubjectLevelInsertListMapper<SubjectLevel> {
}