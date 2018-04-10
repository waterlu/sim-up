package cn.lu.cup.mapper;

import cn.lu.common.mybatis.SingleTableMapper;
import cn.lu.common.mybatis.UniversitySubjectLevelInsertListMapper;
import cn.lu.cup.entity.UniversitySubjectLevel;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversitySubjectLevelMapper extends SingleTableMapper<UniversitySubjectLevel>,
    UniversitySubjectLevelInsertListMapper<UniversitySubjectLevel> {

}