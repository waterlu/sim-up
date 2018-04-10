package cn.lu.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 请求参数的基类
 *
 * @author lutiehua
 * @date 2017/11/13
 */
@Setter
@Getter
@ToString
public class ParamDTO {

    /**
     * 请求来源标识
     */
    @ApiModelProperty(value = "请求来源标识", required = true, example = "1001")
    private String callSystemID;

    /**
     * 请求追踪标识
     */
    @ApiModelProperty(value = "请求追踪标识", required = true, example = "930c1710-c0fd-11e7-a55b-00163e32c6dd")
    private String traceID;
}