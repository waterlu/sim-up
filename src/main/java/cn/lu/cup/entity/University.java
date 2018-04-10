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

    @Column(name = "university_cn_name")
    private String universityCnName;

    @Column(name = "university_name_abbr")
    private String universityNameAbbr;

    @Column(name = "university_type")
    private String universityType;

    @Column(name = "rank_2005_2015")
    private Integer rank20052015;

    @Column(name = "rank_me")
    private Integer rankMe;

    @Column(name = "rank_2017")
    private Integer rank2017;

    @Column(name = "university_location")
    private Integer universityLocation;

    @Column(name = "delete_flag")
    private Integer deleteFlag;

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
     * @return university_cn_name
     */
    public String getUniversityCnName() {
        return universityCnName;
    }

    /**
     * @param universityCnName
     */
    public void setUniversityCnName(String universityCnName) {
        this.universityCnName = universityCnName;
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

    /**
     * @return university_type
     */
    public String getUniversityType() {
        return universityType;
    }

    /**
     * @param universityType
     */
    public void setUniversityType(String universityType) {
        this.universityType = universityType;
    }

    /**
     * @return rank_2005_2015
     */
    public Integer getRank20052015() {
        return rank20052015;
    }

    /**
     * @param rank20052015
     */
    public void setRank20052015(Integer rank20052015) {
        this.rank20052015 = rank20052015;
    }

    /**
     * @return rank_me
     */
    public Integer getRankMe() {
        return rankMe;
    }

    /**
     * @param rankMe
     */
    public void setRankMe(Integer rankMe) {
        this.rankMe = rankMe;
    }

    /**
     * @return rank_2017
     */
    public Integer getRank2017() {
        return rank2017;
    }

    /**
     * @param rank2017
     */
    public void setRank2017(Integer rank2017) {
        this.rank2017 = rank2017;
    }

    /**
     * @return university_location
     */
    public Integer getUniversityLocation() {
        return universityLocation;
    }

    /**
     * @param universityLocation
     */
    public void setUniversityLocation(Integer universityLocation) {
        this.universityLocation = universityLocation;
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