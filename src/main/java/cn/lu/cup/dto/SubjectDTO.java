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
public class SubjectDTO extends ParamDTO {

    /**
     * 学科编码
     *
     */
    @NotBlank(groups = {InsertGroup.class})
    @Size(max = 4)
    @ApiModelProperty(value = "学科编码", required = false)
    private String subjectCode;

    /**
     * 学科名称
     *
     */
    @NotBlank(groups = {InsertGroup.class})
    @Size(max = 32)
    @ApiModelProperty(value = "学科名称", required = false)
    private String subjectName;

    /**
     * 学科中文名称
     *
     */
    @Size(max = 16)
    @ApiModelProperty(value = "学科中文名称", required = false)
    private String subjectCnName;

}