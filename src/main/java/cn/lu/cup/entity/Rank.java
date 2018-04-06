//package cn.lu.cup.entity;
//
//import javax.persistence.*;
//
//@Table(name = "rank")
//public class Rank {
//    @Id
//    @Column(name = "rank_id")
//    @GeneratedValue(generator = "JDBC")
//    private Long rankId;
//
//    @Column(name = "rank_category")
//    private Integer rankCategory;
//
//    @Column(name = "rank_level")
//    private Integer rankLevel;
//
//    @Column(name = "university_code")
//    private Integer universityCode;
//
//    /**
//     * @return rank_id
//     */
//    public Long getRankId() {
//        return rankId;
//    }
//
//    /**
//     * @param rankId
//     */
//    public void setRankId(Long rankId) {
//        this.rankId = rankId;
//    }
//
//    /**
//     * @return rank_category
//     */
//    public Integer getRankCategory() {
//        return rankCategory;
//    }
//
//    /**
//     * @param rankCategory
//     */
//    public void setRankCategory(Integer rankCategory) {
//        this.rankCategory = rankCategory;
//    }
//
//    /**
//     * @return rank_level
//     */
//    public Integer getRankLevel() {
//        return rankLevel;
//    }
//
//    /**
//     * @param rankLevel
//     */
//    public void setRankLevel(Integer rankLevel) {
//        this.rankLevel = rankLevel;
//    }
//
//    /**
//     * @return university_code
//     */
//    public Integer getUniversityCode() {
//        return universityCode;
//    }
//
//    /**
//     * @param universityCode
//     */
//    public void setUniversityCode(Integer universityCode) {
//        this.universityCode = universityCode;
//    }
//}