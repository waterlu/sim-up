package cn.lu.cup.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import cn.lu.common.dto.QueryParam;
import javax.validation.constraints.Size;
import java.lang.String;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询参数对象
 *
 * @author waterlu
 * @date 2018-04-10
 */
@Getter
@Setter
@ToString
public class SubjectQueryDTO extends QueryParam {

    /**
     * 学科编码
     *
     */
    @Size(max = 4)
    @ApiModelProperty(value = "学科编码", required = false)
    private String subjectCode;


}