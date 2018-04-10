package cn.lu.cup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.lu.common.dto.ParamDTO;
import cn.lu.common.validation.InsertGroup;
import cn.lu.common.validation.UpdateGroup;

import javax.validation.constraints.Size;
import java.lang.String;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import java.lang.Integer;
import io.swagger.annotations.ApiModelProperty;

/**
 * 参数对象
 *
 * @author waterlu
 * @date 2018-04-10
 */
@Getter
@Setter
@ToString
public class UniversityLevelDTO extends ParamDTO {

    /**
     * 
     *
     */
    @NotNull(groups = {InsertGroup.class})
    @ApiModelProperty(value = "", required = false)
    private Integer universityCategory;

    /**
     * 
     *
     */
    @NotNull(groups = {InsertGroup.class})
    @ApiModelProperty(value = "", required = false)
    private Integer universityLevel;

    /**
     * 
     *
     */
    @NotBlank(groups = {InsertGroup.class})
    @Size(max = 5)
    @ApiModelProperty(value = "", required = false)
    private String universityCode;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer undergraduateNumber;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer graduateNumber;

}