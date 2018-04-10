package cn.lu.cup.service;

import cn.lu.common.exception.BusinessException;
import cn.lu.common.web.ListResponseResult;
import java.util.List;

import cn.lu.cup.dto.UniversitySubjectLevelQueryDTO;
import cn.lu.cup.dto.UniversitySubjectLevelDTO;
import cn.lu.cup.service.UniversitySubjectLevelService;
import cn.lu.cup.vo.UniversitySubjectLevelVO;
import cn.lu.cup.mapper.UniversitySubjectLevelMapper;
import cn.lu.cup.entity.UniversitySubjectLevel;

/**
 * 服务接口类
 *
 * @author waterlu
 * @date 2018-04-10
 */
public interface UniversitySubjectLevelService {

    int generateAll() throws BusinessException;

    /**
     * 持久化到数据库
     *
     * @param universitySubjectLevel
     * @return
     * @throws BusinessException
     */
    int save(UniversitySubjectLevel universitySubjectLevel) throws BusinessException;

    /**
     * 批量持久化到数据库
     *
     * @param universitySubjectLevelList
     * @return
     * @throws BusinessException
     */
    int save(List<UniversitySubjectLevel> universitySubjectLevelList) throws BusinessException;

    /**
     * 更新数据库（根据主键更新）
     *
     * @param universitySubjectLevel
     * @return
     * @throws BusinessException
     */
    int update(UniversitySubjectLevel universitySubjectLevel) throws BusinessException;

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    UniversitySubjectLevel get(Long id);

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
    ListResponseResult<UniversitySubjectLevelVO> query(UniversitySubjectLevelQueryDTO queryParam);
}