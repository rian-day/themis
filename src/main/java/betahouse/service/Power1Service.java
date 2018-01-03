package betahouse.service;

import betahouse.model.po.Power1;

import java.util.List;

public interface Power1Service {
    public List<Power1> selectByAdminId(Integer adminId);

}
