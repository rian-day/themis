package betahouse.model.po;

import betahouse.model.xo.UserActivityXo;

public class UserActivity {
    private Integer id;

    private Integer userId;

    private String activityName;

    private String activityDate;

    private String comment;

    private Integer term;

    public UserActivity(UserActivityXo userActivityXo){
        this.activityName = userActivityXo.getActivityName();
        this.activityDate = userActivityXo.getActivityDate();
        this.comment = userActivityXo.getComment();
        this.term = userActivityXo.getTerm();
        this.comment = userActivityXo.getComment();
    }
    public UserActivity(){}


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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate == null ? null : activityDate.trim();
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