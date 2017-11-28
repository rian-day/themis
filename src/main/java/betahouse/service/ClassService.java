package betahouse.service;

import betahouse.model.po.Class;
import betahouse.model.po.Power1;

import java.util.List;

public interface ClassService {

    public Integer updateUserClass(Class uclass);

    public List<Class> selectClassesByPower1(List<Power1> power1List);
}
