package cn.lu.common.util;

import java.util.Random;

/**
 * 随机数工具类
 *
 * @author lutiehua
 * @date 2017/12/7
 */
public class RandUtil {

    private static Random rand = new Random();

    /**
     * 获取随机数[min, max)
     *
     * @param min >= 最小值
     * @param max < 最大值
     * @return
     */
    public static int getRandomNum(int min, int max) {
        int range = max - min;
        int random = rand.nextInt(range);
        return (min + random);
    }

    /**
     * 获取随机数（固定位数，不足补零）
     *
     * @param digit 位数
     * @return
     */
    public static String getFormatRandomNum(int digit) {
        int min = 0;
        double maxValue = Math.pow(10, digit);
        int max = (int)maxValue;
        int randomNumber = RandUtil.getRandomNum(min, max);
        String format = "%0" + digit + "d";
        return String.format(format, randomNumber);
    }
}