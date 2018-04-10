package cn.lu.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 查询列表参数的基类
 *
 * @author lutiehua
 * @date 2017/11/14
 */
@Getter
@Setter
@NoArgsConstructor
public class QueryParam extends ParamDTO {

    /**
     * 分页开始下标，默认值为0，从第一页开始
     */
    @ApiModelProperty(value = "分页开始下标", required = false, example = "0")
    private Integer startRow = 0;

    /**
     * 每页数量，每页默认显示20条数据
     */
    @ApiModelProperty(value = "每页数量", required = false, example = "20")
    private Integer pageSize = 20;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记", required = true, example = "0")
    private Integer deleteFlag = 0;
}