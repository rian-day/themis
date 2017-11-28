package betahouse.model.po;


import betahouse.model.vo.UserVo;

public class User {
    private Integer id;

    private String realName;

    private String schoolId;

    private String gender;

    private Integer majorId;

    private Integer classId;

    private String photo;

    private String entranceTime;

    private Integer dormitoryId;

    private String political;

    public User(){

    }
    public User(UserVo userVo){
        this.id = userVo.getId();
        this.classId = userVo.getUclass().getId();
        this.majorId = userVo.getMajor().getId();
        this.realName = userVo.getRealName();
        this.schoolId = userVo.getSchoolId();
        this.gender = userVo.getGender();
        this.photo = userVo.getPhoto();
        this.entranceTime = userVo.getEntranceTime();
        this.dormitoryId = userVo.getDormitory().getId();
        this.political = userVo.getPolitical();
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

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
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

    public Integer getDormitoryId() {
        return dormitoryId;
    }

    public void setDormitoryId(Integer dormitoryId) {
        this.dormitoryId = dormitoryId;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }
}