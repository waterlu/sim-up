package cn.lu.cup.service.impl;

import cn.lu.common.util.RandUtil;
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
            health += RandUtil.getRandomNum(8, 20);
        }
        person.setHealth(health);


        // [20, 80)     50
        int mq = 0;
        for (int i=0; i<4; i++) {
            mq += RandUtil.getRandomNum(5, 20);
        }
        person.setMq(mq);

        // [60, 150)    105
        int iq = 0;
        for (int i=0; i<3; i++) {
            iq += RandUtil.getRandomNum(20, 50);
        }
        person.setIq(iq);

        // [0, 10)    0
        person.setArt(RandUtil.getRandomNum(0, 20));

        // [0, 10)    0
        person.setLogic(RandUtil.getRandomNum(0, 20));

        // [0, 10)    0
        person.setLanguage(RandUtil.getRandomNum(0, 20));

        // [0, 40)    0
        person.setBusiness(RandUtil.getRandomNum(0, 40));

        // [0, 40)    0
        person.setLiterature(RandUtil.getRandomNum(0, 40));

        // [0, 40)    0
        person.setScience(RandUtil.getRandomNum(0, 40));

        // [0, 40)    0
        person.setEngineer(RandUtil.getRandomNum(0, 40));

        return person;
    }
}
