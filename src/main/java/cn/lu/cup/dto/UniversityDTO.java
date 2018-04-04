package cn.lu.cup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.zjhf.kingold.cloud.common.dto.ParamDTO;
import cn.zjhf.kingold.cloud.common.validation.InsertGroup;
import cn.zjhf.kingold.cloud.common.validation.UpdateGroup;

import javax.validation.constraints.Size;
import java.lang.String;
import org.hibernate.validator.constraints.NotBlank;
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
public class UniversityDTO extends ParamDTO {

    /**
     * 
     *
     */
    @NotBlank(groups = {InsertGroup.class})
    @Size(max = 4)
    @ApiModelProperty(value = "", required = false)
    private String universityCode;

    /**
     * 
     *
     */
    @NotBlank(groups = {InsertGroup.class})
    @Size(max = 16)
    @ApiModelProperty(value = "", required = false)
    private String universityName;

    /**
     * 
     *
     */
    @NotBlank(groups = {InsertGroup.class})
    @Size(max = 8)
    @ApiModelProperty(value = "", required = false)
    private String universityNameAbbr;

}