package cn.lu.cup.entity;

import javax.persistence.*;

@Table(name = "university")
public class University {
    @Id
    @Column(name = "university_id")
    @GeneratedValue(generator = "JDBC")
    private Long universityId;

    @Column(name = "university_code")
    private String universityCode;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "university_name_abbr")
    private String universityNameAbbr;

    /**
     * @return university_id
     */
    public Long getUniversityId() {
        return universityId;
    }

    /**
     * @param universityId
     */
    public void setUniversityId(Long universityId) {
        this.universityId = universityId;
    }

    /**
     * @return university_code
     */
    public String getUniversityCode() {
        return universityCode;
    }

    /**
     * @param universityCode
     */
    public void setUniversityCode(String universityCode) {
        this.universityCode = universityCode;
    }

    /**
     * @return university_name
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * @param universityName
     */
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    /**
     * @return university_name_abbr
     */
    public String getUniversityNameAbbr() {
        return universityNameAbbr;
    }

    /**
     * @param universityNameAbbr
     */
    public void setUniversityNameAbbr(String universityNameAbbr) {
        this.universityNameAbbr = universityNameAbbr;
    }
}