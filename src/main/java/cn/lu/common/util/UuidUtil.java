package cn.lu.common.util;

import java.util.UUID;

/**
 * UUID工具类
 *
 * @author lutiehua
 * @date 2017/11/24
 */
public class UuidUtil {

    /**
     * 生成32位UUID（不带"-"）
     *
     * @return
     */
    public static String getUuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
