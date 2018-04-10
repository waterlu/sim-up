package cn.lu.cup.mapper;

import cn.lu.common.mybatis.SingleTableMapper;
import cn.lu.cup.entity.Subject;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectMapper extends SingleTableMapper<Subject>, SubjectInsertListMapper<Subject> {
}