package cn.lu.cup.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.github.pagehelper.PageInfo;
import tk.mybatis.mapper.entity.Example;
import cn.lu.common.exception.BusinessException;
import cn.lu.common.web.ListResponseResult;
import cn.lu.common.vo.ListResultVO;

import cn.lu.cup.service.UniversityLevelService;
import cn.lu.cup.mapper.UniversityLevelMapper;
import cn.lu.cup.vo.UniversityLevelVO;
import cn.lu.cup.dto.UniversityLevelQueryDTO;
import cn.lu.cup.dto.UniversityLevelDTO;
import cn.lu.cup.entity.UniversityLevel;

/**
 * 服务实现类
 *
 * @author waterlu
 * @date 2018-04-10
 */
@Service
public class UniversityLevelServiceImpl implements UniversityLevelService {

    private final Logger logger = LoggerFactory.getLogger(UniversityLevelServiceImpl.class);

    @Autowired
    private UniversityLevelMapper universityLevelMapper;

    /**
     * 持久化到数据库
     *
     * @param universityLevel
     * @throws BusinessException
     */
    @Override
    public int save(UniversityLevel universityLevel) throws BusinessException {
        return universityLevelMapper.insertSelective(universityLevel);
    }

    /**
     * 批量持久化到数据库
     *
     * @param universityLevelList
     * @throws BusinessException
     */
    @Override
    public int save(List<UniversityLevel> universityLevelList) throws BusinessException {
        return universityLevelMapper.insertList(universityLevelList);
    }

    /**
     * 更新数据库（根据主键更新）
     *
     * @param universityLevel
     */
    @Override
    public int update(UniversityLevel universityLevel) throws BusinessException {
        return universityLevelMapper.updateByPrimaryKeySelective(universityLevel);
    }

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    @Override
    public UniversityLevel get(Long id) {
        return universityLevelMapper.selectByPrimaryKey(id);
    }

    /**
     * 通过主鍵进行逻辑刪除
     *
     * @param id
     */
    @Override
    public int delete(Long id) {
        // 物理删除
        // return coinMapper.deleteByPrimaryKey(id);

        // 逻辑删除
        UniversityLevel universityLevel = new UniversityLevel();
        universityLevel.setUniversityLevelId(id);
        universityLevel.setDeleteFlag(1);
        return universityLevelMapper.updateByPrimaryKeySelective(universityLevel);
    }

    /**
     * 根据相等条件进行查询
     *
     * @param queryParam 查询参数
     * @return
     */
    @Override
    public ListResponseResult<UniversityLevelVO> query(UniversityLevelQueryDTO queryParam) {

        // 这里需要指定实体类
        Example condition = new Example(UniversityLevel.class);

        // 创建查询条件
        Example.Criteria criteria = condition.createCriteria();

        // 拼接查询条件，支持链式调用，使用实体类的属性名称

        // 此处仅为示例，将对象转为Map可以完成通用的相等判断
        // criteria = criteria.andEqualTo("accountType", "21");
        // criteria = criteria.andEqualTo("accountStatus", 1);

        String paramString = JSON.toJSONString(queryParam);
        Map<String, Object> queryMap = JSON.parseObject(paramString, new TypeReference<HashMap<String, Object>>() {});
        for (Map.Entry<String, Object> entry : queryMap.entrySet()) {
            String property = entry.getKey();
            Object value = entry.getValue();
            // 跳过startRow和pageSize
            if ("startRow".equalsIgnoreCase(property) || "pageSize".equalsIgnoreCase(property)) {
                continue;
            }
            criteria = criteria.andEqualTo(property, value);
        }

        // 分页
        // pagehelper.offset-as-page-num=false，默认false，表示offset,limit，true表示pageNum,pageSize
        // pagehelper.row-bounds-with-count=true，表示先select count()，默认false，不查询count
        int startRow = queryParam.getStartRow();
        int pageSize = queryParam.getPageSize();
        if (startRow < 0) {
            startRow = 0;
        }
        if (pageSize <= 0) {
            pageSize = 20;
        }
        RowBounds rowBounds = new RowBounds(startRow, pageSize);

        // 排序，使用表的字段名称
        // condition.setOrderByClause("create_time desc");

        // 封装ListResultVO
        List<UniversityLevel> list = universityLevelMapper.selectByExampleAndRowBounds(condition, rowBounds);
        PageInfo pageInfo = new PageInfo(list);
        String jsonString = JSON.toJSONString(list);
        List<UniversityLevelVO> voList = JSON.parseArray(jsonString, UniversityLevelVO.class);

        ListResultVO<UniversityLevelVO> resultVO = new ListResultVO();
        resultVO.setCount(pageInfo.getTotal());
        resultVO.setPageCount(pageInfo.getPages());
        resultVO.setPageNum(pageInfo.getPageNum());
        resultVO.setPageSize(pageInfo.getPageSize());
        resultVO.setList(voList);

        ListResponseResult<UniversityLevelVO> result = new ListResponseResult();
        result.setData(resultVO);
        return result;
    }
}