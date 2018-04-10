package cn.lu.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 业务工具类
 *
 * @author lutiehua
 * @date 2017/12/7
 */
public class BizUtil {

    /**
     * 生成单据编号
     *
     * @param prefix
     * @return
     */
    public static String generateBillCode(String prefix) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date now = new Date();
        String timeString = dateFormat.format(now);
        String postfix = RandUtil.getFormatRandomNum(4);
        String billCode = prefix + timeString + postfix;
        return billCode;
    }

}
