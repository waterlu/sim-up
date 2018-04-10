package cn.lu.cup.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.lu.common.vo.ResultVO;
import java.lang.Long;
import java.lang.String;
import java.lang.Integer;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回值对象
 *
 * @author waterlu
 * @date 2018-04-10
 */
@Getter
@Setter
@ToString
public class UniversitySubjectLevelVO extends ResultVO {

    /**
     * 自增ID
     *
     */
    @ApiModelProperty(value = "自增ID", required = false)
    private Long universitySubjectLevelId;

    /**
     * 
     *
     */
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
    @ApiModelProperty(value = "", required = false)
    private String universityCode;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private String subjectCode;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer number;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer deleteFlag;


}