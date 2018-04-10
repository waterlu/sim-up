package cn.lu.cup.entity;

import javax.persistence.*;

@Table(name = "subject_level")
public class SubjectLevel {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "subject_level_id")
    @GeneratedValue(generator = "JDBC")
    private Long subjectLevelId;

    @Column(name = "subject_category")
    private Integer subjectCategory;

    @Column(name = "subject_level")
    private Integer subjectLevel;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 获取自增ID
     *
     * @return subject_level_id - 自增ID
     */
    public Long getSubjectLevelId() {
        return subjectLevelId;
    }

    /**
     * 设置自增ID
     *
     * @param subjectLevelId 自增ID
     */
    public void setSubjectLevelId(Long subjectLevelId) {
        this.subjectLevelId = subjectLevelId;
    }

    /**
     * @return subject_category
     */
    public Integer getSubjectCategory() {
        return subjectCategory;
    }

    /**
     * @param subjectCategory
     */
    public void setSubjectCategory(Integer subjectCategory) {
        this.subjectCategory = subjectCategory;
    }

    /**
     * @return subject_level
     */
    public Integer getSubjectLevel() {
        return subjectLevel;
    }

    /**
     * @param subjectLevel
     */
    public void setSubjectLevel(Integer subjectLevel) {
        this.subjectLevel = subjectLevel;
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