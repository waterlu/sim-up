package cn.lu.cup.service;

import cn.lu.common.exception.BusinessException;
import cn.lu.common.web.ListResponseResult;
import java.util.List;

import cn.lu.cup.service.UniversityLevelService;
import cn.lu.cup.mapper.UniversityLevelMapper;
import cn.lu.cup.vo.UniversityLevelVO;
import cn.lu.cup.dto.UniversityLevelQueryDTO;
import cn.lu.cup.dto.UniversityLevelDTO;
import cn.lu.cup.entity.UniversityLevel;

/**
 * 服务接口类
 *
 * @author waterlu
 * @date 2018-04-10
 */
public interface UniversityLevelService {

    /**
     * 持久化到数据库
     *
     * @param universityLevel
     * @return
     * @throws BusinessException
     */
    int save(UniversityLevel universityLevel) throws BusinessException;

    /**
     * 批量持久化到数据库
     *
     * @param universityLevelList
     * @return
     * @throws BusinessException
     */
    int save(List<UniversityLevel> universityLevelList) throws BusinessException;

    /**
     * 更新数据库（根据主键更新）
     *
     * @param universityLevel
     * @return
     * @throws BusinessException
     */
    int update(UniversityLevel universityLevel) throws BusinessException;

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    UniversityLevel get(Long id);

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
    ListResponseResult<UniversityLevelVO> query(UniversityLevelQueryDTO queryParam);
}