package betahouse.service;

import betahouse.model.po.Major;
import betahouse.model.po.Power2;

import java.util.List;

public interface MajorService {


    public Integer updateUserMajor(Major major);

    public List<Major> selectAll();
    public List<Major> selectClassesByPower2(List<Power2> power1List);
    public Major selectByMajorId(Integer id);
}
