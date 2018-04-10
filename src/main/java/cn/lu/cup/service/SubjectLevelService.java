package cn.lu.cup.service;

import cn.lu.common.exception.BusinessException;
import cn.lu.common.web.ListResponseResult;
import java.util.List;

import cn.lu.cup.mapper.SubjectLevelMapper;
import cn.lu.cup.vo.SubjectLevelVO;
import cn.lu.cup.service.SubjectLevelService;
import cn.lu.cup.dto.SubjectLevelDTO;
import cn.lu.cup.entity.SubjectLevel;
import cn.lu.cup.dto.SubjectLevelQueryDTO;

/**
 * 服务接口类
 *
 * @author waterlu
 * @date 2018-04-10
 */
public interface SubjectLevelService {

    /**
     * 持久化到数据库
     *
     * @param subjectLevel
     * @return
     * @throws BusinessException
     */
    int save(SubjectLevel subjectLevel) throws BusinessException;

    /**
     * 批量持久化到数据库
     *
     * @param subjectLevelList
     * @return
     * @throws BusinessException
     */
    int save(List<SubjectLevel> subjectLevelList) throws BusinessException;

    /**
     * 更新数据库（根据主键更新）
     *
     * @param subjectLevel
     * @return
     * @throws BusinessException
     */
    int update(SubjectLevel subjectLevel) throws BusinessException;

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    SubjectLevel get(Long id);

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
    ListResponseResult<SubjectLevelVO> query(SubjectLevelQueryDTO queryParam);
}