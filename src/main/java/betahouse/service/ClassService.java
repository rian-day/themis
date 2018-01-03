package betahouse.service;

import betahouse.model.po.Class;
import betahouse.model.po.Power1;

import java.util.List;

public interface ClassService {
    public List<Class> selectAll();

    public Integer updateUserClass(Class uclass);

    public List<Class> selectClassesByPower1(List<Power1> power1List);
    public Class selectClassByClassId(Integer id);
}
