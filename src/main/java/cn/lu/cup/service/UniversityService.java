package cn.lu.cup.service;

import cn.zjhf.kingold.cloud.common.exception.BusinessException;
import cn.zjhf.kingold.cloud.common.web.ListResponseResult;
import java.util.List;

import cn.lu.cup.dto.UniversityQueryDTO;
import cn.lu.cup.entity.University;
import cn.lu.cup.vo.UniversityVO;
import cn.lu.cup.mapper.UniversityMapper;
import cn.lu.cup.dto.UniversityDTO;
import cn.lu.cup.service.UniversityService;

/**
 * 服务接口类
 *
 * @author waterlu
 * @date 2018-04-03
 */
public interface UniversityService {

    /**
     * 持久化到数据库
     *
     * @param university
     * @return
     * @throws BusinessException
     */
    int save(University university) throws BusinessException;

    /**
     * 批量持久化到数据库
     *
     * @param universityList
     * @return
     * @throws BusinessException
     */
    int save(List<University> universityList) throws BusinessException;

    /**
     * 更新数据库（根据主键更新）
     *
     * @param university
     * @return
     * @throws BusinessException
     */
    int update(University university) throws BusinessException;

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    University get(Long id);

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
    ListResponseResult<UniversityVO> query(UniversityQueryDTO queryParam);
}