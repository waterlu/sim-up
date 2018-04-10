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
public class UniversitySubjectLevelDTO extends ParamDTO {

    /**
     * 
     *
     */
    @NotNull(groups = {InsertGroup.class})
    @ApiModelProperty(value = "", required = false)
    private Integer category;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer level;

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
    @NotBlank(groups = {InsertGroup.class})
    @Size(max = 4)
    @ApiModelProperty(value = "", required = false)
    private String subjectCode;

    /**
     * 
     *
     */
    @NotNull(groups = {InsertGroup.class})
    @ApiModelProperty(value = "", required = false)
    private Integer number;

}