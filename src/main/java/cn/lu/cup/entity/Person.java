package cn.lu.cup.entity;

import cn.lu.common.util.RandUtil;

/**
 * @author lutiehua
 * @date 2018/4/3
 */
public class Person {

    private String name;

    private Integer health;

    private Integer leader;

    private Integer mq;

    private Integer iq;

    private Integer eq;

    /**
     * 语
     */
    private Integer art;

    /**
     * 数
     */
    private Integer logic;

    /**
     * 外
     */
    private Integer language;

    /**
     * 商
     */
    private Integer business;

    /**
     * 文
     */
    private Integer literature;

    /**
     * 理
     */
    private Integer science;

    /**
     * 工
     */
    private Integer engineer;

    private Integer score;

    private Integer score1;

    private Integer score2;

    private Integer score3;

    private Integer score4;

    /**
     *
     */
    private Integer category;

    public void exam() {
        // art
        score1 = exam1(art);

        // logic
        score2 = exam1(logic);

        // language
        score3 = exam1(language);

        // theory
        int temp[] = new int[4];
        temp[0] = exam2(business);
        temp[1] = exam2(literature);
        temp[2] = exam2(science);
        temp[3] = exam2(engineer);

        int max = 0;
        for (int i=0; i<temp.length; i++) {
            int value = temp[i] / 10;
            if (value > max) {
                max = value;
                category = i;
            } else if (value == max) {
                int replace = RandUtil.getRandomNum(0, 2);
                if (replace > 0) {
                    max = value;
                    category = i;
                }
            }
        }

        score4 = temp[category];
        category = category + 1;

        score = score1 + score2 + score3 + score4;
    }

    public int exam1(int subject) {
        int max = 0;
        int min = 0;
        max = iq + subject;
        if (max > 150) {
            max = 150;
        }
        min = max * mq / 100;
        return RandUtil.getRandomNum(min, max);
    }

    public int exam2(int subject) {
        int max = 0;
        int min = 0;
        max = iq * 2 + subject;
        if (max > 300) {
            max = 300;
        }
        min = max * mq / 100;
        return RandUtil.getRandomNum(min, max);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public Integer getLiterature() {
        return literature;
    }

    public void setLiterature(Integer literature) {
        this.literature = literature;
    }

    public Integer getScience() {
        return science;
    }

    public void setScience(Integer science) {
        this.science = science;
    }

    public Integer getEngineer() {
        return engineer;
    }

    public void setEngineer(Integer engineer) {
        this.engineer = engineer;
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
