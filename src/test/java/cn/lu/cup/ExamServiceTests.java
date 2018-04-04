package cn.lu.cup;

import cn.lu.cup.entity.Person;
import cn.lu.cup.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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

    @Test
    public void enterTest() {

        int coff[] = new int[] {40, 250, 2000, 5000, 10000, 15000, 20000};

        List<Person> personList = new ArrayList<>();
        for (int i=0; i<100000; i++) {
            Person person = personService.createRandom();
            person.exam();
            personList.add(person);
        }

        personList.sort((Person p1, Person p2) -> p2.getScore() - p1.getScore());

        int count = 0;
        for (Person person : personList) {
            count++;
            for (int j=0; j<coff.length; j++) {
                if (count == coff[j]) {
                    System.out.println("" + count + "\t" + person);
                    break;
                }
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
