package cn.lu.common.exception;

import cn.zjhf.kingold.cloud.common.web.ResponseCode;

/**
 * 数据库操作异常
 *
 * @author lutiehua
 * @date 2018/2/8
 */
public class MybatisException extends BusinessException {

    /**
     *
     */
    public MybatisException() {
        super(ResponseCode.DB_FAILED.code, "Database Operation Failed");
    }
}
