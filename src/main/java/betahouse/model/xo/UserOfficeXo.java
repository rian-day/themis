package betahouse.model.xo;

public class UserOfficeXo {
    private String shchoolId;
    private String userName;
    private String officeName;
    private Integer officeLv;
    private String startDate;
    private String endDate;
    private Integer term;
    private Integer result;
    private String comment;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShchoolId() {
        return shchoolId;
    }

    public void setShchoolId(String shchoolId) {
        this.shchoolId = shchoolId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Integer getOfficeLv() {
        return officeLv;
    }

    public void setOfficeLv(Integer officeLv) {
        this.officeLv = officeLv;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}
