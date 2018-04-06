package cn.lu.cup.entity;

import cn.lu.cup.common.util.RandomUtil;

/**
 * @author lutiehua
 * @date 2018/4/3
 */
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

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getLeader() {
        return leader;
    }

    public void setLeader(Integer leader) {
        this.leader = leader;
    }

    public Integer getMq() {
        return mq;
    }

    public void setMq(Integer mq) {
        this.mq = mq;
    }

    public Integer getIq() {
        return iq;
    }

    public void setIq(Integer iq) {
        this.iq = iq;
    }

    public Integer getEq() {
        return eq;
    }

    public void setEq(Integer eq) {
        this.eq = eq;
    }

    public Integer getArt() {
        return art;
    }

    public void setArt(Integer art) {
        this.art = art;
    }

    public Integer getLogic() {
        return logic;
    }

    public void setLogic(Integer logic) {
        this.logic = logic;
    }

    public Integer getLanguage() {
        return language;
    }

    public void setLanguage(Integer language) {
        this.language = language;
    }

    public Integer getTheory() {
        return theory;
    }

    public void setTheory(Integer theory) {
        this.theory = theory;
    }

    public Integer getPractice() {
        return practice;
    }

    public void setPractice(Integer practice) {
        this.practice = practice;
    }

    public Integer getImagination() {
        return imagination;
    }

    public void setImagination(Integer imagination) {
        this.imagination = imagination;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
    }

    public Integer getScore3() {
        return score3;
    }

    public void setScore3(Integer score3) {
        this.score3 = score3;
    }

    public Integer getScore4() {
        return score4;
    }

    public void setScore4(Integer score4) {
        this.score4 = score4;
    }

    @Override
    public String toString() {
        return "Person{" +
                "health=" + health +
                ", mq=" + mq +
                ", iq=" + iq +
                ", score=" + score +
                '}';
    }
}
