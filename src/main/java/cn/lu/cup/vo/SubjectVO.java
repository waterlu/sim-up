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
public class SubjectVO extends ResultVO {

    /**
     * 自增ID
     *
     */
    @ApiModelProperty(value = "自增ID", required = false)
    private Long subjectId;

    /**
     * 学科编码
     *
     */
    @ApiModelProperty(value = "学科编码", required = false)
    private String subjectCode;

    /**
     * 学科名称
     *
     */
    @ApiModelProperty(value = "学科名称", required = false)
    private String subjectName;

    /**
     * 学科中文名称
     *
     */
    @ApiModelProperty(value = "学科中文名称", required = false)
    private String subjectCnName;

    /**
     * 删除标记
     *
     */
    @ApiModelProperty(value = "删除标记", required = false)
    private Integer deleteFlag;


}