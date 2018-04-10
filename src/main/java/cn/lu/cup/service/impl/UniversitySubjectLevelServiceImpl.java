package cn.lu.cup.service.impl;

import java.util.*;

import cn.lu.cup.entity.*;
import cn.lu.cup.mapper.*;
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

import cn.lu.cup.dto.UniversitySubjectLevelQueryDTO;
import cn.lu.cup.dto.UniversitySubjectLevelDTO;
import cn.lu.cup.service.UniversitySubjectLevelService;
import cn.lu.cup.vo.UniversitySubjectLevelVO;
import cn.lu.cup.mapper.UniversitySubjectLevelMapper;
import cn.lu.cup.entity.UniversitySubjectLevel;

/**
 * 服务实现类
 *
 * @author waterlu
 * @date 2018-04-10
 */
@Service
public class UniversitySubjectLevelServiceImpl implements UniversitySubjectLevelService {

    private final Logger logger = LoggerFactory.getLogger(UniversitySubjectLevelServiceImpl.class);

    @Autowired
    private UniversityMapper universityMapper;

    @Autowired
    private UniversityLevelMapper universityLevelMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Autowired
    private SubjectLevelMapper subjectLevelMapper;

    @Autowired
    private UniversitySubjectLevelMapper universitySubjectLevelMapper;

    @Override
    public int generateAll() throws BusinessException {
        Map<String, University> universityMap = new HashMap<>(256);
        Map<String, Subject> subjectMap = new HashMap<>(64);

        List<University> universityList = universityMapper.selectAll();
        for (University university : universityList) {
            universityMap.put(university.getUniversityCode(), university);
        }

        List<Subject> subjectList = subjectMapper.selectAll();
        for (Subject subject : subjectList) {
            subjectMap.put(subject.getSubjectCode(), subject);
        }

        int [] categoryArray = new int[] {1, 2, 3, 4};
        int row = 0;

        for (int i=0; i<categoryArray.length; i++) {
            List<UniversitySubjectLevel> levelList = new ArrayList<>();
            int category = categoryArray[i];

            Example condition = new Example(UniversityLevel.class);
            Example.Criteria criteria = condition.createCriteria();
            criteria = criteria.andEqualTo("universityCategory", category);
            condition.setOrderByClause("university_level asc");
            RowBounds rowBounds = new RowBounds(0, 100);
            List<UniversityLevel> universityLevelList = universityLevelMapper.selectByExampleAndRowBounds(condition, rowBounds);

            Example condition2 = new Example(SubjectLevel.class);
            Example.Criteria criteria2 = condition2.createCriteria();
            criteria2 = criteria2.andEqualTo("subjectCategory", category);
            condition2.setOrderByClause("subject_level asc");
            List<SubjectLevel> subjectLevelList = subjectLevelMapper.selectByExampleAndRowBounds(condition2, rowBounds);
            int subjectCount = subjectLevelList.size();

            for (UniversityLevel universityLevel : universityLevelList) {
                int baseLevel = universityLevel.getUniversityLevel();
                int total = universityLevel.getUndergraduateNumber();

                for (SubjectLevel subjectLevel : subjectLevelList) {
                    int level = baseLevel + subjectLevel.getSubjectLevel() - 1;
                    String universityCode = universityLevel.getUniversityCode();
                    String subjectCode = subjectLevel.getSubjectCode();
                    int number = total / subjectCount;

                    UniversitySubjectLevel usLevel = new UniversitySubjectLevel();
                    usLevel.setCategory(category);
                    usLevel.setLevel(level);
                    usLevel.setUniversityCode(universityCode);
                    usLevel.setSubjectCode(subjectCode);
                    usLevel.setNumber(number);
                    usLevel.setDeleteFlag(0);
                    levelList.add(usLevel);
                }
            }

            row += universitySubjectLevelMapper.insertList(levelList);
        }

        return row;
    }

    /**
     * 持久化到数据库
     *
     * @param universitySubjectLevel
     * @throws BusinessException
     */
    @Override
    public int save(UniversitySubjectLevel universitySubjectLevel) throws BusinessException {
        return universitySubjectLevelMapper.insertSelective(universitySubjectLevel);
    }

    /**
     * 批量持久化到数据库
     *
     * @param universitySubjectLevelList
     * @throws BusinessException
     */
    @Override
    public int save(List<UniversitySubjectLevel> universitySubjectLevelList) throws BusinessException {
        return universitySubjectLevelMapper.insertList(universitySubjectLevelList);
    }

    /**
     * 更新数据库（根据主键更新）
     *
     * @param universitySubjectLevel
     */
    @Override
    public int update(UniversitySubjectLevel universitySubjectLevel) throws BusinessException {
        return universitySubjectLevelMapper.updateByPrimaryKeySelective(universitySubjectLevel);
    }

    /**
     * 通过主鍵查找
     *
     * @param id
     * @return
     */
    @Override
    public UniversitySubjectLevel get(Long id) {
        return universitySubjectLevelMapper.selectByPrimaryKey(id);
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
        UniversitySubjectLevel universitySubjectLevel = new UniversitySubjectLevel();
        universitySubjectLevel.setUniversitySubjectLevelId(id);
        universitySubjectLevel.setDeleteFlag(1);
        return universitySubjectLevelMapper.updateByPrimaryKeySelective(universitySubjectLevel);
    }

    /**
     * 根据相等条件进行查询
     *
     * @param queryParam 查询参数
     * @return
     */
    @Override
    public ListResponseResult<UniversitySubjectLevelVO> query(UniversitySubjectLevelQueryDTO queryParam) {

        // 这里需要指定实体类
        Example condition = new Example(UniversitySubjectLevel.class);

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
        List<UniversitySubjectLevel> list = universitySubjectLevelMapper.selectByExampleAndRowBounds(condition, rowBounds);
        PageInfo pageInfo = new PageInfo(list);
        String jsonString = JSON.toJSONString(list);
        List<UniversitySubjectLevelVO> voList = JSON.parseArray(jsonString, UniversitySubjectLevelVO.class);

        ListResultVO<UniversitySubjectLevelVO> resultVO = new ListResultVO();
        resultVO.setCount(pageInfo.getTotal());
        resultVO.setPageCount(pageInfo.getPages());
        resultVO.setPageNum(pageInfo.getPageNum());
        resultVO.setPageSize(pageInfo.getPageSize());
        resultVO.setList(voList);

        ListResponseResult<UniversitySubjectLevelVO> result = new ListResponseResult();
        result.setData(resultVO);
        return result;
    }
}