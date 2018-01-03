package betahouse.model.dto;

import betahouse.model.po.Admin;
import betahouse.model.po.Major;
import betahouse.model.po.Class;

import java.util.List;

public class AdminDto {
    private Integer id;

    private String username;

    private String password;

    private String tel;

    private String email;

    private Integer power;

    private List<Class> classes;

    private List<Major> majors;

    public AdminDto(Admin admin){
        this.id=admin.getId();
        this.username=admin.getUsername();
        this.password=admin.getPassword();
        this.tel=admin.getTel();
        this.email=admin.getEmail();
        this.power=admin.getPower();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public List<Class> getClasses() {
        return classes;
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
    }
}
