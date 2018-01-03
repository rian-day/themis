package betahouse.model.po;

import betahouse.model.xo.UserCleanXo;

public class UserClean {
    private Integer id;

    private Integer userId;

    private String checkDate;

    private Double score;

    private Integer term;

    public UserClean(UserCleanXo userCleanXo){
        this.checkDate = userCleanXo.getCheckDate();
        this.score = userCleanXo.getScore();
        this.term = userCleanXo.getTerm();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate == null ? null : checkDate.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}