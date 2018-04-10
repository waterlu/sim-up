package cn.lu.cup.entity;

import javax.persistence.*;

@Table(name = "university_level")
public class UniversityLevel {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "university_level_id")
    @GeneratedValue(generator = "JDBC")
    private Long universityLevelId;

    @Column(name = "university_category")
    private Integer universityCategory;

    @Column(name = "university_level")
    private Integer universityLevel;

    @Column(name = "university_code")
    private String universityCode;

    @Column(name = "undergraduate_number")
    private Integer undergraduateNumber;

    @Column(name = "graduate_number")
    private Integer graduateNumber;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 获取自增ID
     *
     * @return university_level_id - 自增ID
     */
    public Long getUniversityLevelId() {
        return universityLevelId;
    }

    /**
     * 设置自增ID
     *
     * @param universityLevelId 自增ID
     */
    public void setUniversityLevelId(Long universityLevelId) {
        this.universityLevelId = universityLevelId;
    }

    /**
     * @return university_category
     */
    public Integer getUniversityCategory() {
        return universityCategory;
    }

    /**
     * @param universityCategory
     */
    public void setUniversityCategory(Integer universityCategory) {
        this.universityCategory = universityCategory;
    }

    /**
     * @return university_level
     */
    public Integer getUniversityLevel() {
        return universityLevel;
    }

    /**
     * @param universityLevel
     */
    public void setUniversityLevel(Integer universityLevel) {
        this.universityLevel = universityLevel;
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
     * @return undergraduate_number
     */
    public Integer getUndergraduateNumber() {
        return undergraduateNumber;
    }

    /**
     * @param undergraduateNumber
     */
    public void setUndergraduateNumber(Integer undergraduateNumber) {
        this.undergraduateNumber = undergraduateNumber;
    }

    /**
     * @return graduate_number
     */
    public Integer getGraduateNumber() {
        return graduateNumber;
    }

    /**
     * @param graduateNumber
     */
    public void setGraduateNumber(Integer graduateNumber) {
        this.graduateNumber = graduateNumber;
    }

    /**
     * @return delete_flag
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @param deleteFlag
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}