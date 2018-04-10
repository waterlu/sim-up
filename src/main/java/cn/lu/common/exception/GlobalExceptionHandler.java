package cn.lu.common.exception;

import cn.zjhf.kingold.cloud.common.web.ResponseCode;
import cn.zjhf.kingold.cloud.common.web.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 统一异常处理类
 *
 * @author lutiehua
 * @date 17/03/22
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 业务异常的统一处理
     *
     * @param be
     * @param response
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseResult handleBusinessException(BusinessException be, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        int errorCode = be.getCode();
        String errorMessage = be.getMessage();
        responseResult.setCode(errorCode);
        responseResult.setMsg(errorMessage);
        logger.error("BusinessException: code=[{}] msg=[{}]", errorCode, errorMessage);
        return responseResult;
    }

    /**
     * 参数校验异常的统一处理
     *
     * @param ex
     * @param response
     * @return
     */
    @ExceptionHandler({BindException.class, MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseResult handleValidException(Exception ex, HttpServletResponse response) {
        BindingResult bindingResult = null;

        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException)ex;
            bindingResult = exception.getBindingResult();
        } else if (ex instanceof BindException) {
            BindException exception = (BindException)ex;
            bindingResult = exception.getBindingResult();
        }

        StringBuffer buffer = new StringBuffer("");

        // 拼接所有的参数校验错误信息
        if (null != bindingResult && bindingResult.hasErrors()) {
            for(FieldError error: bindingResult.getFieldErrors()) {
                if (buffer.length() > 0) {
                    buffer.append(",");
                }
                buffer.append(error.getField());
                buffer.append(error.getDefaultMessage());
            }
        }

        String errorMessage = buffer.toString();
        logger.error("BindException: msg=[{}]", errorMessage);
        // 返回400错误码
        ResponseResult responseResult = new ResponseResult(ResponseCode.PARAM_ERROR, errorMessage);
        return responseResult;
    }

    /**
     * 正常不应该走到这里，走到这里说明出现了程序中未处理的异常
     *
     * @param ex
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult handleUnknownException(Exception ex, HttpServletResponse response) {
        ResponseResult responseResult = new ResponseResult();
        int errorCode = ResponseCode.EXCEPTION.code;
        String errorMessage = ex.toString();
        responseResult.setCode(errorCode);
        responseResult.setMsg(ex.toString());
        // 返回500错误码
        logger.error("UnknownException: code=[{}] msg=[{}]]", errorCode, errorMessage);
        return responseResult;
    }
}