package cn.lu.cup.entity;

import javax.persistence.*;

@Table(name = "university_subject_level")
public class UniversitySubjectLevel {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "university_subject_level_id")
    @GeneratedValue(generator = "JDBC")
    private Long universitySubjectLevelId;

    @Column(name = "category")
    private Integer category;

    @Column(name = "level")
    private Integer level;

    @Column(name = "university_code")
    private String universityCode;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "number")
    private Integer number;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 获取自增ID
     *
     * @return university_subject_level_id - 自增ID
     */
    public Long getUniversitySubjectLevelId() {
        return universitySubjectLevelId;
    }

    /**
     * 设置自增ID
     *
     * @param universitySubjectLevelId 自增ID
     */
    public void setUniversitySubjectLevelId(Long universitySubjectLevelId) {
        this.universitySubjectLevelId = universitySubjectLevelId;
    }

    /**
     * @return category
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * @param category
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * @return level
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * @param level
     */
    public void setLevel(Integer level) {
        this.level = level;
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
     * @return subject_code
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * @param subjectCode
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * @return number
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * @param number
     */
    public void setNumber(Integer number) {
        this.number = number;
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