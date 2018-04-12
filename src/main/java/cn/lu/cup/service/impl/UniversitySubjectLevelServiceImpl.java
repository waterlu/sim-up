package cn.lu.cup.service.impl;

import java.util.*;

import cn.lu.common.util.RandUtil;
import cn.lu.cup.entity.*;
import cn.lu.cup.mapper.*;
import cn.lu.cup.model.UniversitySubject;
import cn.lu.cup.service.PersonService;
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

    @Autowired
    private PersonService personService;

    @Override
    public int enroll() throws BusinessException {
        int [][] coefficient = new int[4][8];
        List<UniversitySubjectLevel> levelList = universitySubjectLevelMapper.selectAll();
        for (UniversitySubjectLevel usLevel : levelList) {
            int category = usLevel.getCategory();
            int level = usLevel.getLevel();
            int number = usLevel.getNumber();
            coefficient[category-1][level-1] += number;
        }

        int [][] rank = new int[4][8];
        for (int i=0; i<coefficient.length; i++) {
            for (int j=0; j<coefficient[i].length; j++) {
                if (j == 0) {
                    int number = (int)(coefficient[i][j] * 1.2);
                    rank[i][j] = number;
                } else {
                    int number = (int)(coefficient[i][j] * 1.2);
                    rank[i][j] = number + rank[i][j-1];
                }
            }
        }

        List<Person> [] personList = new ArrayList [4];
        for (int i=0; i<personList.length; i++) {
            personList[i] = new ArrayList<>();
        }

        List<Person> businessList = new ArrayList<>();
        List<Person> literatureList = new ArrayList<>();
        List<Person> scienceList = new ArrayList<>();
        List<Person> engineerList = new ArrayList<>();

        for (int i=0; i<50000; i++) {
            Person person = personService.createRandom();
            person.setName(String.format("E2021BJ%05d", i + 1));
            person.exam();
            personList[person.getCategory()-1].add(person);
        }

        int count = 0;
        for (int i=0; i<personList.length; i++) {
            List<UniversitySubjectLevel> list = new ArrayList<>();
            for (UniversitySubjectLevel usLevel : levelList) {
                if (usLevel.getCategory() == (i + 1)) {
                    list.add(usLevel);
                }
            }
            count += enrollCategory(personList[i], list, rank[i]);
        }

        return count;
    }

    private int enrollCategory(List<Person> personList, List<UniversitySubjectLevel> list, int [] rank) {
        // 准备
        Collections.sort(personList, (p1, p2) -> p2.getScore() - p1.getScore());
        Collections.sort(list, (u1, u2) -> u1.getLevel() - u2.getLevel());

        List<UniversitySubject> [] usList = new ArrayList [rank.length];
        for (int i=0; i<usList.length; i++) {
            usList[i] = new ArrayList<>();
        }

        for (UniversitySubjectLevel usLevel : list) {
            int level = usLevel.getLevel();
            UniversitySubject us = new UniversitySubject();
            us.setUniversityCode(usLevel.getUniversityCode());
            us.setSubjectCode(usLevel.getSubjectCode());
            us.setLevel(level);
            us.setNumber(usLevel.getNumber());
            usList[level-1].add(us);
        }

        // 分配
        int count = 0;
        int pointer = 0;
        int ranking = rank[pointer];
        for (Person person : personList) {
            count++;
            if (count > ranking) {
                pointer++;
                if (pointer >= usList.length) {
                    break;
                }
                ranking = rank[pointer];
            }

            int level = pointer;
//            int levelRandom = RandUtil.getRandomNum(0, 100);
//            if (levelRandom >= 90) {
//                level = level - 1;
//                if (level < 0) {
//                    level = 0;
//                }
//            } else if (levelRandom < 10) {
//                level = level + 1;
//            }
//
//            if (level >= usList.length) {
//                continue;
//            }

            List<UniversitySubject> candidate = usList[level];
            int [] range = new int[candidate.size()];
            for (int i=0; i<range.length; i++) {
                if (i == 0) {
                    range[i] = candidate.get(i).getNumber();
                } else {
                    range[i] = range[i-1] + candidate.get(i).getNumber();
                }
            }
            int max = range[range.length-1];
            int random = RandUtil.getRandomNum(0, max);
            int select = 0;
            for (int i=0; i<range.length; i++) {
                if (random < range[i]) {
                    select = i;
                    break;
                }
            }
            UniversitySubject object = candidate.get(select);
            object.addPerson(person, count);
        }

        for (List<UniversitySubject> list1 : usList) {
            for (UniversitySubject us : list1) {
                if (us.getUniversityCode().equalsIgnoreCase("10001")) {
                    logger.info(us.toString());
                }
            }
        }

        return count;
    }

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

    @Override
    public List<UniversitySubjectLevel> selectAll() throws BusinessException {
        return universitySubjectLevelMapper.selectAll();
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