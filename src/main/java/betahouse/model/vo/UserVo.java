package betahouse.model.vo;

import betahouse.model.po.*;
import betahouse.model.po.Class;

import java.util.List;

public class UserVo {
    private Integer id;
    //名字
    private String realName;
    //学号
    private String schoolId;
    //性别
    private String gender;

    //private Integer majorId;
    private Major major; //majorId

    //private Integer classId;
    private ClassVo uclass;

    private String photo;

    private String entranceTime;

    //private Integer dormitoryId;
    private Dormitory dormitory;

    private String political;

    private List<UserActivity> userActivities;

    private List<UserClean> userCleans;

    private List<UserHonor> userHonors;

    private List<UserOffice> userOffices;

    private List<UserPractice> userPractices;

    private List<UserReserve> userReserves;

    private List<UserSkill> userSkills;

    private List<UserVolunteer> userVolunteers;

    public UserVo(User user){
        this.id=user.getId();
        this.realName=user.getRealName();
        this.schoolId=user.getSchoolId();
        this.gender=user.getGender();
        this.photo=user.getPhoto();
        this.entranceTime=user.getEntranceTime();
        this.political=user.getPolitical();
    }

    public UserVo(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public ClassVo getUclass() {
        return uclass;
    }

    public void setUclass(ClassVo uclass) {
        this.uclass = uclass;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public List<UserActivity> getUserActivities() {
        return userActivities;
    }

    public void setUserActivities(List<UserActivity> userActivities) {
        this.userActivities = userActivities;
    }

    public List<UserClean> getUserCleans() {
        return userCleans;
    }

    public void setUserCleans(List<UserClean> userCleans) {
        this.userCleans = userCleans;
    }

    public List<UserHonor> getUserHonors() {
        return userHonors;
    }

    public void setUserHonors(List<UserHonor> userHonors) {
        this.userHonors = userHonors;
    }

    public List<UserOffice> getUserOffices() {
        return userOffices;
    }

    public void setUserOffices(List<UserOffice> userOffices) {
        this.userOffices = userOffices;
    }

    public List<UserPractice> getUserPractices() {
        return userPractices;
    }

    public void setUserPractices(List<UserPractice> userPractices) {
        this.userPractices = userPractices;
    }

    public List<UserReserve> getUserReserves() {
        return userReserves;
    }

    public void setUserReserves(List<UserReserve> userReserves) {
        this.userReserves = userReserves;
    }

    public List<UserSkill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(List<UserSkill> userSkills) {
        this.userSkills = userSkills;
    }

    public List<UserVolunteer> getUserVolunteers() {
        return userVolunteers;
    }

    public void setUserVolunteers(List<UserVolunteer> userVolunteers) {
        this.userVolunteers = userVolunteers;
    }

}
