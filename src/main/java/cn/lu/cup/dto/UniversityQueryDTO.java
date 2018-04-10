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
public class UniversityQueryDTO extends QueryParam {

    /**
     * 
     *
     */
    @Size(max = 5)
    @ApiModelProperty(value = "", required = false)
    private String universityCode;


}