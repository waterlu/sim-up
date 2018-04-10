package cn.lu.cup.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import com.alibaba.fastjson.JSON;
import cn.lu.common.exception.BusinessException;
import cn.lu.common.exception.MybatisException;
import cn.lu.common.validation.InsertGroup;
import cn.lu.common.validation.ParamTool;
import cn.lu.common.validation.UpdateGroup;
import cn.lu.common.web.ResponseResult;
import cn.lu.common.web.SimpleResponseResult;
import cn.lu.common.web.ListResponseResult;
import cn.lu.common.util.UuidUtil;
import cn.lu.common.vo.ListResultVO;

import cn.lu.cup.service.UniversityLevelService;
import cn.lu.cup.mapper.UniversityLevelMapper;
import cn.lu.cup.vo.UniversityLevelVO;
import cn.lu.cup.dto.UniversityLevelQueryDTO;
import cn.lu.cup.dto.UniversityLevelDTO;
import cn.lu.cup.entity.UniversityLevel;

/**
 * 接口
 *
 * @author waterlu
 * @date 2018-04-10
 */
@RestController
@RequestMapping(value = "/universityLevel")
public class UniversityLevelController {

    private final Logger logger = LoggerFactory.getLogger(UniversityLevelController.class);

    @Autowired
    private UniversityLevelService universityLevelService;

    /**
     * 创建
     *
     * @return
     * @throws BusinessException
     */
    @PostMapping(value = "")
    @ApiOperation(value = "创建接口", response = UniversityLevelVO.class)
    public ResponseResult<UniversityLevelVO> create(@RequestBody @ApiParam @Validated({InsertGroup.class}) UniversityLevelDTO param) throws BusinessException {
        // UniversityLevelDTO 用来接收请求参数
        String jsonString = JSON.toJSONString(param);

        // 转换为UniversityLevel传给业务层处理
        UniversityLevel universityLevel = JSON.parseObject(jsonString, UniversityLevel.class);

        // 持久化到数据库
        int row = universityLevelService.save(universityLevel);
        if (row > 0) {
            ResponseResult responseResult = new ResponseResult();
            jsonString = JSON.toJSONString(universityLevel);
            UniversityLevelVO universityLevelVO = JSON.parseObject(jsonString, UniversityLevelVO.class);
            responseResult.setData(universityLevelVO);
            return responseResult;
        } else {
            throw new MybatisException();
        }
    }

    /**
     * 查询
     *
     * @return
     * @throws BusinessException
     */
    @GetMapping("/query")
    @ApiOperation(value = "查询接口", response = UniversityLevelVO.class, notes = "list")
    public ResponseResult<ListResultVO<UniversityLevelVO>> query(@ApiParam @Validated UniversityLevelQueryDTO queryParam) throws BusinessException {
        // 由于需要处理PageInfo，所以直接在Service中处理返回结果
        return universityLevelService.query(queryParam);
    }

    /**
     * 详情
     *
     * @return
     * @throws BusinessException
     */
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "获取详情接口", response = UniversityLevelVO.class)
    public ResponseResult<UniversityLevelVO> get(@PathVariable Long id) throws BusinessException {
        // Service层返回的是与数据库表对应的实体类对象
        UniversityLevel universityLevel = universityLevelService.get(id);

        // 转换为返回值对象
        String jsonString = JSON.toJSONString(universityLevel);
        UniversityLevelVO universityLevelVO = JSON.parseObject(jsonString, UniversityLevelVO.class);

        // 返回数据
        ResponseResult responseResult = new ResponseResult();
        responseResult.setData(universityLevelVO);
        return responseResult;
    }

    /**
     * 更新
     *
     * @return
     * @throws BusinessException
     */
    @PutMapping(value = "/{id}")
    @ApiOperation(value = "更新接口")
    public SimpleResponseResult update(@PathVariable Long id, @RequestBody @ApiParam @Validated({UpdateGroup.class}) UniversityLevelDTO param) throws BusinessException {
        // UniversityLevelDTO 用来接收请求参数
        String jsonString = JSON.toJSONString(param);
        UniversityLevel universityLevel = JSON.parseObject(jsonString, UniversityLevel.class);
        universityLevel.setUniversityLevelId(id);

        // 转换为UniversityLevel传给业务层处理
        // 此处根据实际情况判断row=0是否需要抛出异常
        int row = universityLevelService.update(universityLevel);

        // 返回影响的行数，正常情况为1
        SimpleResponseResult responseResult = new SimpleResponseResult(Integer.toString(row));
        return responseResult;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     * @throws BusinessException
     */
    @DeleteMapping(value = "/{id}")
    @ApiOperation(value = "删除接口")
    public SimpleResponseResult delete(@PathVariable Long id) throws BusinessException {
        // 此处根据实际情况判断row=0是否需要抛出异常
        int row = universityLevelService.delete(id);

        // 返回影响的行数，正常情况为1
        SimpleResponseResult responseResult = new SimpleResponseResult(Integer.toString(row));
        return responseResult;
    }
}