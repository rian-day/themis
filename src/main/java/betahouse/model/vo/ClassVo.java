package betahouse.model.vo;

import betahouse.model.po.Major;
import betahouse.model.po.Class;

public class ClassVo {
    private Integer id;

    private Integer classNum;

    private Major major;

    private String className;

    public ClassVo(Class ucalss){
        this.id = ucalss.getId();
        this.className = ucalss.getClassName();
        this.classNum = ucalss.getClassNum();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassNum() {
        return classNum;
    }

    public void setClassNum(Integer classNum) {
        this.classNum = classNum;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
