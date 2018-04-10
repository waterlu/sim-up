package cn.lu.cup.service;

import cn.lu.common.exception.BusinessException;
import cn.lu.common.web.ListResponseResult;
import java.util.List;

import cn.lu.cup.mapper.SubjectMapper;
import cn.lu.cup.vo.SubjectVO;
import cn.lu.cup.service.SubjectService;
import cn.lu.cup.entity.Subject;
import cn.lu.cup.dto.SubjectDTO;
import cn.lu.cup.dto.SubjectQueryDTO;

/**
 * 服务接口类
 *
 * @author waterlu
 * @date 2018-04-10
 */
public interface SubjectService {

    /**
     * 持久化到数据库
     *
     * @param subject
     * @return
     * @throws BusinessException
     */
    int save(Subject subject) throws BusinessException;

    /**
     * 批量持久化到数据库
     *
     * @param subjectList
     * @return
     * @throws BusinessException
     */
    int save(List<Subject> subjectList) throws BusinessException;

    /**
     * 更新数据库（根据主键更新）
     *
     * @param subject
     * @return
     * @throws BusinessException
     */
    int update(Subject subject) throws BusinessException;

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    Subject get(Long id);

    /**
     * 通过主鍵进行逻辑刪除
     *
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 根据相等条件进行查询
     *
     * @param queryParam 查询参数
     * @return
     */
    ListResponseResult<SubjectVO> query(SubjectQueryDTO queryParam);
}