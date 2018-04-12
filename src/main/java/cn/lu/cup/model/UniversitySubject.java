package cn.lu.cup.model;

import cn.lu.cup.entity.Person;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lutiehua
 * @date 2018/4/11
 */
@Getter
@Setter
@ToString
public class UniversitySubject {

    private String universityCode;

    private String subjectCode;

    private Integer level;

    private Integer number;

    private List<Integer> personList = new ArrayList<>();

    public void addPerson(Person person, int count) {
        personList.add(count);
    }
}
