package cn.lu.common.web;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 服务之间调用的返回结果
 *
 * @author lutiehua
 * @date 17/11/10
 */
@Getter
@Setter
@ToString
public class ResponseResult<T> {

    /**
     * 状态码，通用状态码对应ResponseCode
     */
    private int code;

    /**
     * 状态信息，文本信息
     */
    private String msg = "";

    /**
     * 数据,Payload
     */
    private T data;

    /**
     * 追踪用的唯一标识
     */
    private String traceID;

    /**
     * 成功默认返回信息
     */
    private static final String SUCCESS_MESSAGE = "成功";

    /**
     * 服务不可用默认返回信息
     */
    private static final String UNAVAILABLE_MESSAGE = "服务暂时不可用，请稍后再试";

    /**
     * 默认返回200成功
     */
    public ResponseResult() {
        code = ResponseCode.SUCCESS.code;
        msg = SUCCESS_MESSAGE;
    }

    /**
     * 自定义状态码和状态信息
     *
     * @param code 状态码
     * @param msg 状态信息
     */
    public ResponseResult(ResponseCode code, String msg) {
        this.code = code.code;
        this.msg = msg;
    }

    /**
     * 自定义状态码和状态信息
     *
     * @param code 状态码
     * @param msg 状态信息
     */
    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 自定义状态码、状态信息和数据
     *
     * @param code 状态码
     * @param msg 状态信息
     * @param data 数据
     */
    public ResponseResult(ResponseCode code, String msg, T data) {
        this.code = code.code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 自定义状态码、状态信息和数据
     *
     * @param code 状态码
     * @param msg 状态信息
     * @param data 数据
     */
    public ResponseResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 调用是否成功，成功返回Data数据，失败错误信息在msg中
     *
     * @return
     */
    public boolean isSuccessful() {
        return code == ResponseCode.SUCCESS.code;
    }

    /**
     * 成功返回结果
     *
     * @return
     */
    public static ResponseResult getSuccessResult() {
        return new ResponseResult(ResponseCode.SUCCESS, SUCCESS_MESSAGE);
    }

    /**
     * 服务调用失败返回结果
     *
     * @return
     */
    public static ResponseResult getNetworkExceptionResult() {
        return new ResponseResult(ResponseCode.UNAVAILABLE, UNAVAILABLE_MESSAGE);
    }
}
