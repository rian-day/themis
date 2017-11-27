package betahouse.model.vo;

import java.util.HashMap;
import java.util.Map;

public class AdminVo {
    private Integer uid;
    private String token;
    private Integer power;
    private Map permissions;
    private String email;
    public AdminVo(){
        this.uid = (int)Math.random()*1000;
        this.token = "betahouse";
        this.permissions = new HashMap();
        this.permissions.put("/index/personalInfo",true);
        this.permissions.put("/errorpage/401",false);
        this.permissions.put("/errorpage/404",false);
        this.permissions.put("/studentsManage/studentAdd",true);
        this.permissions.put("/studentsManage/studentUpdate",true);
        this.permissions.put("/studentsManage/studentList",true);
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Map getPermissions() {
        return permissions;
    }

    public void setPermissions(Map permissions) {
        this.permissions = permissions;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
