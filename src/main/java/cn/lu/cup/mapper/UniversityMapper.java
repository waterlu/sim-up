package cn.lu.cup.mapper;

import cn.lu.common.mybatis.SingleTableMapper;
import cn.lu.cup.entity.University;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityMapper extends UniversityInsertListMapper<University>, SingleTableMapper<University> {
}