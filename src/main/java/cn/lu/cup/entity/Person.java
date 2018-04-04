package cn.lu.cup.entity;

import cn.lu.cup.common.util.RandomUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author lutiehua
 * @date 2018/4/3
 */
@Getter
@Setter
@ToString
public class Person {

    private Integer health;

    private Integer leader;

    private Integer mq;

    private Integer iq;

    private Integer eq;

    private Integer art;

    private Integer logic;

    private Integer language;

    private Integer theory;

    private Integer practice;

    private Integer imagination;


    private Integer score;

    private Integer score1;

    private Integer score2;

    private Integer score3;

    private Integer score4;

    public void exam() {
        // art
        score1 = exam1(art);

        // logic
        score2 = exam1(logic);

        // language
        score3 = exam1(language);

        // theory
        score4 = exam2(theory);

        // practice
        int temp = exam2(practice);
        if (temp > score4) {
            score4 = temp;
        }

        // imagination
        temp = exam2(imagination);
        if (temp > score4) {
            score4 = temp;
        }

        score = score1 + score2 + score3 +score4;
    }

    public int exam1(int subject) {
        int max = 0;
        int min = 0;
        max = iq + subject;
        if (max > 150) {
            max = 150;
        }
        min = max * mq / 100;
        return RandomUtil.getRandomNum(min, max);
    }

    public int exam2(int subject) {
        int max = 0;
        int min = 0;
        max = iq * 2 + subject;
        if (max > 300) {
            max = 300;
        }
        min = max * mq / 100;
        return RandomUtil.getRandomNum(min, max);
    }

}
