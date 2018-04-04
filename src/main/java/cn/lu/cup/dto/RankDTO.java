package cn.lu.cup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.zjhf.kingold.cloud.common.dto.ParamDTO;
import cn.zjhf.kingold.cloud.common.validation.InsertGroup;
import cn.zjhf.kingold.cloud.common.validation.UpdateGroup;

import javax.validation.constraints.NotNull;
import java.lang.Integer;
import io.swagger.annotations.ApiModelProperty;

/**
 * 参数对象
 *
 * @author waterlu
 * @date 2018-04-03
 */
@Getter
@Setter
@ToString
public class RankDTO extends ParamDTO {

    /**
     * 
     *
     */
    @NotNull(groups = {InsertGroup.class})
    @ApiModelProperty(value = "", required = false)
    private Integer rankCategory;

    /**
     * 
     *
     */
    @NotNull(groups = {InsertGroup.class})
    @ApiModelProperty(value = "", required = false)
    private Integer rankLevel;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer universityCode;

}