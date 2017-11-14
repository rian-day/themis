package betahouse.model.po;

import java.util.List;

public class User {
    private Integer id;

    private String realName;

    private String schoolId;

    private String gender;

    //private Integer majorId;
    private Major major; //majorId

    //private Integer classId;
    private Class uclass;

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



    //get set


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
        this.realName = realName == null ? null : realName.trim();
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId == null ? null : schoolId.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getEntranceTime() {
        return entranceTime;
    }

    public void setEntranceTime(String entranceTime) {
        this.entranceTime = entranceTime == null ? null : entranceTime.trim();
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political == null ? null : political.trim();
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Class getUclass() {
        return uclass;
    }

    public void setUclass(Class uclass) {
        this.uclass = uclass;
    }

    public Dormitory getDormitory() {
        return dormitory;
    }

    public void setDormitory(Dormitory dormitory) {
        this.dormitory = dormitory;
    }
}