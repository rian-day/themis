package betahouse.model.po;

public class UserHonor {
    private Integer id;

    private Integer userId;

    private String honorName;

    private Double honorScore;

    private Integer honorLv;

    private Integer term;

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

    public String getHonorName() {
        return honorName;
    }

    public void setHonorName(String honorName) {
        this.honorName = honorName == null ? null : honorName.trim();
    }

    public Double getHonorScore() {
        return honorScore;
    }

    public void setHonorScore(Double honorScore) {
        this.honorScore = honorScore;
    }

    public Integer getHonorLv() {
        return honorLv;
    }

    public void setHonorLv(Integer honorLv) {
        this.honorLv = honorLv;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}