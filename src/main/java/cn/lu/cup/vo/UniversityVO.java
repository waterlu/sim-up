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
public class UniversityVO extends ResultVO {

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Long universityId;

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
    private String universityName;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private String universityCnName;

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private String universityNameAbbr;

    /**
     * 
     *
     */
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

    /**
     * 
     *
     */
    @ApiModelProperty(value = "", required = false)
    private Integer deleteFlag;


}