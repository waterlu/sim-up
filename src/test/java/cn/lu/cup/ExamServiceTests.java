package cn.lu.cup;

import cn.lu.cup.entity.Person;
import cn.lu.cup.entity.UniversitySubjectLevel;
import cn.lu.cup.service.PersonService;
import cn.lu.cup.service.UniversitySubjectLevelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lutiehua
 * @date 2018/4/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExamServiceTests {

    @Autowired
    private PersonService personService;

    @Autowired
    private UniversitySubjectLevelService levelService;

    @Test
    public void enterTest() {
        int [][] coefficient = new int[4][8];
        List<UniversitySubjectLevel> levelList = levelService.selectAll();
        for (UniversitySubjectLevel usLevel : levelList) {
            int category = usLevel.getCategory();
            int level = usLevel.getLevel();
            int number = usLevel.getNumber();
            coefficient[category-1][level-1] += number;
        }

        int [][] rank = new int[4][8];
        for (int i=0; i<coefficient.length; i++) {
            for (int j=0; j<coefficient[i].length; j++) {
                if (j == 0) {
                    int number = (int)(coefficient[i][j] * 1.25);
                    rank[i][j] = number;
                } else {
                    int number = (int)(coefficient[i][j] * 1.25);
                    rank[i][j] = number + rank[i][j-1];
                }
            }
        }

        List<Person> businessList = new ArrayList<>();
        List<Person> literatureList = new ArrayList<>();
        List<Person> scienceList = new ArrayList<>();
        List<Person> engineerList = new ArrayList<>();

        for (int i=0; i<500; i++) {
            Person person = personService.createRandom();
            person.setName(String.format("E2021BJ%05d", i + 1));
            person.exam();
            if (person.getCategory() == 1) {
                businessList.add(person);
            } else if (person.getCategory() == 2) {
                literatureList.add(person);
            } else if (person.getCategory() == 3) {
                scienceList.add(person);
            } else if (person.getCategory() == 4) {
                engineerList.add(person);
            } else {
                System.out.println("unexpected category " + person.getCategory());
            }
        }

        enroll(businessList, rank[0]);
        enroll(literatureList, rank[1]);
        enroll(scienceList, rank[2]);
        enroll(engineerList, rank[3]);
    }

    private void enroll(List<Person> personList, int [] rank) {
        // 排序
        Collections.sort(personList, (p1, p2) -> p2.getScore() - p1.getScore());

        int count = 0;
        int pointer = 0;
        int range = rank[pointer];
        for (Person person : personList) {
            count++;
            if (count > range) {
                pointer++;
                if (pointer >= rank.length) {
                    break;
                }
                range = rank[pointer];
            }

        }
    }

    //  36659

    // 204  205705
    // 300  188899
    // 400  148986
    // 500   88318
    // 600   21651
    // 650    4924
    // 700     168

    // 525   69567  33%
}
