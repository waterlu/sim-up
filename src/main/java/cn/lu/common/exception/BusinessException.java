package cn.lu.common.exception;

import cn.lu.common.web.ResponseCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 业务异常的基类
 *
 * @author lutiehua
 * @date 2018/02/07
 */
@Getter
@Setter
@ToString
public class BusinessException extends RuntimeException {

    /**
     * 错误编码
     */
    private int code = ResponseCode.EXCEPTION.code;

    /**
     * 错误信息
     */
    private String message = "Unknown Exception";

    /**
     * 不指定错误编码和错误信息，默认错误编码500，默认错误信息"Unknown Exception"
     *
     */
    public BusinessException() {
        super();
    }

    /**
     * 构造时指定错误编码和错误信息
     *
     * @param code
     * @param message
     */
    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 不指定错误编码，默认为500
     *
     * @param message
     */
    public BusinessException(String message) {
        this.message = message;
    }
}
