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

import cn.lu.cup.dto.UniversityQueryDTO;
import cn.lu.cup.entity.University;
import cn.lu.cup.vo.UniversityVO;
import cn.lu.cup.mapper.UniversityMapper;
import cn.lu.cup.dto.UniversityDTO;
import cn.lu.cup.service.UniversityService;

/**
 * 服务实现类
 *
 * @author waterlu
 * @date 2018-04-10
 */
@Service
public class UniversityServiceImpl implements UniversityService {

    private final Logger logger = LoggerFactory.getLogger(UniversityServiceImpl.class);

    @Autowired
    private UniversityMapper universityMapper;

    /**
     * 持久化到数据库
     *
     * @param university
     * @throws BusinessException
     */
    @Override
    public int save(University university) throws BusinessException {
        return universityMapper.insertSelective(university);
    }

    /**
     * 批量持久化到数据库
     *
     * @param universityList
     * @throws BusinessException
     */
    @Override
    public int save(List<University> universityList) throws BusinessException {
        return universityMapper.insertList(universityList);
    }

    /**
     * 更新数据库（根据主键更新）
     *
     * @param university
     */
    @Override
    public int update(University university) throws BusinessException {
        return universityMapper.updateByPrimaryKeySelective(university);
    }

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    @Override
    public University get(Long id) {
        return universityMapper.selectByPrimaryKey(id);
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
        University university = new University();
        university.setUniversityId(id);
        university.setDeleteFlag(1);
        return universityMapper.updateByPrimaryKeySelective(university);
    }

    /**
     * 根据相等条件进行查询
     *
     * @param queryParam 查询参数
     * @return
     */
    @Override
    public ListResponseResult<UniversityVO> query(UniversityQueryDTO queryParam) {

        // 这里需要指定实体类
        Example condition = new Example(University.class);

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
        List<University> list = universityMapper.selectByExampleAndRowBounds(condition, rowBounds);
        PageInfo pageInfo = new PageInfo(list);
        String jsonString = JSON.toJSONString(list);
        List<UniversityVO> voList = JSON.parseArray(jsonString, UniversityVO.class);

        ListResultVO<UniversityVO> resultVO = new ListResultVO();
        resultVO.setCount(pageInfo.getTotal());
        resultVO.setPageCount(pageInfo.getPages());
        resultVO.setPageNum(pageInfo.getPageNum());
        resultVO.setPageSize(pageInfo.getPageSize());
        resultVO.setList(voList);

        ListResponseResult<UniversityVO> result = new ListResponseResult();
        result.setData(resultVO);
        return result;
    }
}