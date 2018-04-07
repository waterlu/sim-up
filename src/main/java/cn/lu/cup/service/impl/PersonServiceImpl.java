package cn.lu.cup.service.impl;

import cn.lu.cup.common.util.RandomUtil;
import cn.lu.cup.entity.Person;
import cn.lu.cup.service.PersonService;
import org.springframework.stereotype.Service;

/**
 * @author lutiehua
 * @date 2018/4/3
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person createRandom() {
        Person person = new Person();

        // [40, 100)    70
        int health = 0;
        for (int i=0; i<5; i++) {
            health += RandomUtil.getRandomNum(8, 20);
        }
        person.setHealth(health);


        // [20, 80)     50
        int mq = 0;
        for (int i=0; i<4; i++) {
            mq += RandomUtil.getRandomNum(5, 20);
        }
        person.setMq(mq);

        // [60, 150)    105
        int iq = 0;
        for (int i=0; i<3; i++) {
            iq += RandomUtil.getRandomNum(20, 50);
        }
        person.setIq(iq);

        // [0, 10)    0
        person.setArt(RandomUtil.getRandomNum(0, 20));

        // [0, 10)    0
        person.setLogic(RandomUtil.getRandomNum(0, 20));

        // [0, 10)    0
        person.setLanguage(RandomUtil.getRandomNum(0, 20));

        // [0, 40)    0
        person.setBusiness(RandomUtil.getRandomNum(0, 40));

        // [0, 40)    0
        person.setLiterature(RandomUtil.getRandomNum(0, 40));

        // [0, 40)    0
        person.setScience(RandomUtil.getRandomNum(0, 40));

        // [0, 40)    0
        person.setEngineer(RandomUtil.getRandomNum(0, 40));

        return person;
    }
}
