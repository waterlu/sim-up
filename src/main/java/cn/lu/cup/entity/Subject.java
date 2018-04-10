package cn.lu.cup.entity;

import javax.persistence.*;

@Table(name = "subject")
public class Subject {
    /**
     * 自增ID
     */
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(generator = "JDBC")
    private Long subjectId;

    /**
     * 学科编码
     */
    @Column(name = "subject_code")
    private String subjectCode;

    /**
     * 学科名称
     */
    @Column(name = "subject_name")
    private String subjectName;

    /**
     * 学科中文名称
     */
    @Column(name = "subject_cn_name")
    private String subjectCnName;

    /**
     * 删除标记
     */
    @Column(name = "delete_flag")
    private Integer deleteFlag;

    /**
     * 获取自增ID
     *
     * @return subject_id - 自增ID
     */
    public Long getSubjectId() {
        return subjectId;
    }

    /**
     * 设置自增ID
     *
     * @param subjectId 自增ID
     */
    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    /**
     * 获取学科编码
     *
     * @return subject_code - 学科编码
     */
    public String getSubjectCode() {
        return subjectCode;
    }

    /**
     * 设置学科编码
     *
     * @param subjectCode 学科编码
     */
    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * 获取学科名称
     *
     * @return subject_name - 学科名称
     */
    public String getSubjectName() {
        return subjectName;
    }

    /**
     * 设置学科名称
     *
     * @param subjectName 学科名称
     */
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /**
     * 获取学科中文名称
     *
     * @return subject_cn_name - 学科中文名称
     */
    public String getSubjectCnName() {
        return subjectCnName;
    }

    /**
     * 设置学科中文名称
     *
     * @param subjectCnName 学科中文名称
     */
    public void setSubjectCnName(String subjectCnName) {
        this.subjectCnName = subjectCnName;
    }

    /**
     * 获取删除标记
     *
     * @return delete_flag - 删除标记
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除标记
     *
     * @param deleteFlag 删除标记
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}