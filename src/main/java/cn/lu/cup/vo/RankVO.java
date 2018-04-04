package cn.lu.cup.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.zjhf.kingold.cloud.common.vo.ResultVO;
import java.lang.Long;
import java.lang.Integer;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回值对象
 *
 * @author waterlu
 * @date 2018-04-03
 */
@Getter
@Setter
@ToString
public class RankVO extends ResultVO {

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Long rankId;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer rankCategory;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer rankLevel;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer universityCode;


}