package cn.lu.cup.mapper;

import cn.lu.common.mybatis.SingleTableMapper;
import cn.lu.cup.entity.UniversityLevel;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityLevelMapper extends SingleTableMapper<UniversityLevel>, UniversityLevelInsertListMapper<UniversityLevel> {
}