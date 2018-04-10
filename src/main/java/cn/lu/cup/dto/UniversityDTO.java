package cn.lu.cup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.lu.common.dto.ParamDTO;
import cn.lu.common.validation.InsertGroup;
import cn.lu.common.validation.UpdateGroup;

import javax.validation.constraints.Size;
import java.lang.String;
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
public class UniversityDTO extends ParamDTO {

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
    @Size(max = 64)
    @ApiModelProperty(value = "", required = false)
    private String universityName;

    /**
     * 
     *
     */
    @Size(max = 32)
    @ApiModelProperty(value = "", required = false)
    private String universityCnName;

    /**
     * 
     *
     */
    @Size(max = 8)
    @ApiModelProperty(value = "", required = false)
    private String universityNameAbbr;

    /**
     * 
     *
     */
    @Size(max = 4)
    @ApiModelProperty(value = "", required = false)
    private String universityType;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer rank20052015;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer rankMe;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer rank2017;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer universityLocation;

}