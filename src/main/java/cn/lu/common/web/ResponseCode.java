package cn.lu.common.web;

/**
 * 公共的响应编码
 *
 * @author lutiehua
 * @date 2017/11/10
 */
public enum ResponseCode {
    // 成功
    SUCCESS(200),
    // 参数解析或者校验失败
    PARAM_ERROR(400),
    // 没有登录或者没有访问权限
    UNAUTHORIZED(401),
    // 访问的接口不存在
    NOT_FOUND(404),
    // 服务器内部错误
    EXCEPTION(500),
    // 服务暂时不可用
    UNAVAILABLE(503),
    // 数据库操作失败
    DB_FAILED(511);

    public int code;

    ResponseCode(int code) {
        this.code = code;
    }
}
