package betahouse.model.xo;

public class UserVolunteerXo {
    private String schoolId;
    private String userName;
    private String volunteerName;
    private String volunteerDate;
    private Double volunteerTime;
    private Integer term;
    private String comment;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getVolunteerDate() {
        return volunteerDate;
    }

    public void setVolunteerDate(String volunteerDate) {
        this.volunteerDate = volunteerDate;
    }

    public Double getVolunteerTime() {
        return volunteerTime;
    }

    public void setVolunteerTime(Double volunteerTime) {
        this.volunteerTime = volunteerTime;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
