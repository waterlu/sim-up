package cn.lu.common.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 返回列表数据
 *
 * @author lutiehua
 * @date 2017/11/13
 */
@Getter
@Setter
@ToString
public class ListResultVO<T> extends ResultVO {

    /**
     * 数据总条数
     */
    @ApiModelProperty(value = "列表数据总条数", required = true)
    private Long count;

    /**
     * 当前页数据列表
     */
    @ApiModelProperty(value = "列表当前页数据", required = true)
    private List<T> list;

    /**
     * 数据总页数
     */
    @ApiModelProperty(value = "数据总页数", required = true)
    private Integer pageCount;

    /**
     * 每页最大数据条数
     */
    @ApiModelProperty(value = "每页最大数据条数", required = true)
    private Integer pageSize;

    /**
     * 当前是第几页
     */
    @ApiModelProperty(value = "当前是第几页", required = true)
    private Integer pageNum;
}