package cn.lu.cup.service;

import cn.zjhf.kingold.cloud.common.exception.BusinessException;
import cn.zjhf.kingold.cloud.common.web.ListResponseResult;
import java.util.List;

import cn.lu.cup.service.RankService;
import cn.lu.cup.mapper.RankMapper;
import cn.lu.cup.dto.RankQueryDTO;
import cn.lu.cup.vo.RankVO;
import cn.lu.cup.entity.Rank;
import cn.lu.cup.dto.RankDTO;

/**
 * 服务接口类
 *
 * @author waterlu
 * @date 2018-04-03
 */
public interface RankService {

    /**
     * 持久化到数据库
     *
     * @param rank
     * @return
     * @throws BusinessException
     */
    int save(Rank rank) throws BusinessException;

    /**
     * 批量持久化到数据库
     *
     * @param rankList
     * @return
     * @throws BusinessException
     */
    int save(List<Rank> rankList) throws BusinessException;

    /**
     * 更新数据库（根据主键更新）
     *
     * @param rank
     * @return
     * @throws BusinessException
     */
    int update(Rank rank) throws BusinessException;

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    Rank get(Long id);

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
    ListResponseResult<RankVO> query(RankQueryDTO queryParam);
}