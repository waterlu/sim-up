package cn.lu.cup.common.util;

import java.util.Random;

/**
 * @author lutiehua
 * @date 2018/4/3
 */
public class RandomUtil {

    private static Random rand = new Random();

    public RandomUtil() {
    }

    public static int getRandomNum(int min, int max) {
        int range = max - min;
        int random = rand.nextInt(range);
        return min + random;
    }

    public static String getFormatRandomNum(int digit) {
        int min = 0;
        double maxValue = Math.pow(10.0D, (double)digit);
        int max = (int)maxValue;
        int randomNumber = getRandomNum(min, max);
        String format = "%0" + digit + "d";
        return String.format(format, new Object[]{Integer.valueOf(randomNumber)});
    }

}
