package betahouse.model.po;

import betahouse.model.xo.UserVolunteerXo;

public class UserVolunteer {
    private Integer id;

    private Integer userId;

    private String volunteerName;

    private String volunteerDate;

    private Double volunteerTime;

    private String comment;

    private Integer term;

    public UserVolunteer(){

    }
    public UserVolunteer(UserVolunteerXo userVolunteerXo){
        this.volunteerName = userVolunteerXo.getVolunteerName();
        this.volunteerDate = userVolunteerXo.getVolunteerDate();
        this.volunteerTime = userVolunteerXo.getVolunteerTime();
        this.comment = userVolunteerXo.getComment();
        this.term = userVolunteerXo.getTerm();
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

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName == null ? null : volunteerName.trim();
    }

    public String getVolunteerDate() {
        return volunteerDate;
    }

    public void setVolunteerDate(String volunteerDate) {
        this.volunteerDate = volunteerDate == null ? null : volunteerDate.trim();
    }

    public Double getVolunteerTime() {
        return volunteerTime;
    }

    public void setVolunteerTime(Double volunteerTime) {
        this.volunteerTime = volunteerTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }
}