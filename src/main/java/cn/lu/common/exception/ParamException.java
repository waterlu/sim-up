package cn.lu.common.exception;

import cn.lu.common.web.ResponseCode;

/**
 * 参数校验异常
 *
 * @author lutiehua
 * @date 2018/2/8
 */
public class ParamException extends BusinessException {

    /**
     *
     * @param message
     */
    public ParamException(String message) {
        super(ResponseCode.PARAM_ERROR.code, message);
    }
}
