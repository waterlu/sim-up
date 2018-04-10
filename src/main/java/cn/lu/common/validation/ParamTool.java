package cn.lu.common.validation;

import cn.lu.common.exception.ParamException;
import com.alibaba.fastjson.JSON;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Map;
import java.util.Set;

/**
 * 参数校验工具类
 *
 * @author lutiehua
 * @date 2018/02/08
 */
public class ParamTool {

    /**
     * 把MAP转换为DTO对象，同时做参数校验，校验成功返回对象，校验失败抛出异常
     *
     * @param param 入参的MAP
     * @param className 对应的DTO类名
     * @param <T>
     * @return
     * @throws ParamException
     */
    public static <T> T map2Object(Map<String, Object> param, Class<T> className) throws ParamException {
        // 先转为JSON串，再转为对象
        String jsonString = JSON.toJSONString(param);
        T object = JSON.parseObject(jsonString, className);

        // 参数合法性校验
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object, Default.class);
        if (constraintViolations.size() == 0) {
            // 校验成功，返回对象
            return object;
        }

        // 输入参数错误，抛出异常
        StringBuffer buffer = new StringBuffer();
        for (ConstraintViolation<T> constraintViolation : constraintViolations) {
            buffer.append(constraintViolation.getPropertyPath().toString());
            buffer.append(constraintViolation.getMessage());
            buffer.append("; ");
        }

        // 抛出异常
        throw new ParamException(buffer.toString());
    }

}
