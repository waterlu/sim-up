//package cn.lu.cup.web;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//import com.alibaba.fastjson.JSON;
//import cn.zjhf.kingold.cloud.common.exception.BusinessException;
//import cn.zjhf.kingold.cloud.common.exception.MybatisException;
//import cn.zjhf.kingold.cloud.common.validation.InsertGroup;
//import cn.zjhf.kingold.cloud.common.validation.ParamTool;
//import cn.zjhf.kingold.cloud.common.validation.UpdateGroup;
//import cn.zjhf.kingold.cloud.common.web.ResponseResult;
//import cn.zjhf.kingold.cloud.common.web.SimpleResponseResult;
//import cn.zjhf.kingold.cloud.common.web.ListResponseResult;
//import cn.zjhf.kingold.cloud.common.util.UuidUtil;
//import cn.zjhf.kingold.cloud.common.vo.ListResultVO;
//
//import cn.lu.cup.service.RankService;
//import cn.lu.cup.mapper.RankMapper;
//import cn.lu.cup.dto.RankQueryDTO;
//import cn.lu.cup.vo.RankVO;
//import cn.lu.cup.entity.Rank;
//import cn.lu.cup.dto.RankDTO;
//
///**
// * 接口
// *
// * @author waterlu
// * @date 2018-04-03
// */
//@RestController
//@RequestMapping(value = "/rank")
//public class RankController {
//
//    private final Logger logger = LoggerFactory.getLogger(RankController.class);
//
//    @Autowired
//    private RankService rankService;
//
//    /**
//     * 创建
//     *
//     * @return
//     * @throws BusinessException
//     */
//    @PostMapping(value = "")
//    public ResponseResult<RankVO> create(@RequestBody @ApiParam @Validated({InsertGroup.class}) RankDTO param) throws BusinessException {
//        // RankDTO 用来接收请求参数
//        String jsonString = JSON.toJSONString(param);
//
//        // 转换为Rank传给业务层处理
//        Rank rank = JSON.parseObject(jsonString, Rank.class);
//
//        // 持久化到数据库
//        int row = rankService.save(rank);
//        if (row > 0) {
//            ResponseResult responseResult = new ResponseResult();
//            jsonString = JSON.toJSONString(rank);
//            RankVO rankVO = JSON.parseObject(jsonString, RankVO.class);
//            responseResult.setData(rankVO);
//            return responseResult;
//        } else {
//            throw new MybatisException();
//        }
//    }
//
//    /**
//     * 查询
//     *
//     * @return
//     * @throws BusinessException
//     */
//    @GetMapping("/query")
//    public ResponseResult<ListResultVO<RankVO>> query(@ApiParam @Validated RankQueryDTO queryParam) throws BusinessException {
//        // 由于需要处理PageInfo，所以直接在Service中处理返回结果
//        return rankService.query(queryParam);
//    }
//
//    /**
//     * 详情
//     *
//     * @return
//     * @throws BusinessException
//     */
//    @GetMapping(value = "/{id}")
//    public ResponseResult<RankVO> get(@PathVariable Long id) throws BusinessException {
//        // Service层返回的是与数据库表对应的实体类对象
//        Rank rank = rankService.get(id);
//
//        // 转换为返回值对象
//        String jsonString = JSON.toJSONString(rank);
//        RankVO rankVO = JSON.parseObject(jsonString, RankVO.class);
//
//        // 返回数据
//        ResponseResult responseResult = new ResponseResult();
//        responseResult.setData(rankVO);
//        return responseResult;
//    }
//
//    /**
//     * 更新
//     *
//     * @return
//     * @throws BusinessException
//     */
//    @PutMapping(value = "/{id}")
//    public SimpleResponseResult update(@PathVariable Long id, @RequestBody @ApiParam @Validated({UpdateGroup.class}) RankDTO param) throws BusinessException {
//        // RankDTO 用来接收请求参数
//        String jsonString = JSON.toJSONString(param);
//        Rank rank = JSON.parseObject(jsonString, Rank.class);
//        rank.setRankId(id);
//
//        // 转换为Rank传给业务层处理
//        // 此处根据实际情况判断row=0是否需要抛出异常
//        int row = rankService.update(rank);
//
//        // 返回影响的行数，正常情况为1
//        SimpleResponseResult responseResult = new SimpleResponseResult(Integer.toString(row));
//        return responseResult;
//    }
//
//    /**
//     * 删除
//     *
//     * @param id
//     * @return
//     * @throws BusinessException
//     */
//    @DeleteMapping(value = "/{id}")
//    public SimpleResponseResult delete(@PathVariable Long id) throws BusinessException {
//        // 此处根据实际情况判断row=0是否需要抛出异常
//        int row = rankService.delete(id);
//
//        // 返回影响的行数，正常情况为1
//        SimpleResponseResult responseResult = new SimpleResponseResult(Integer.toString(row));
//        return responseResult;
//    }
//}