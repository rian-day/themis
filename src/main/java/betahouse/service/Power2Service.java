package betahouse.service;

import betahouse.model.po.Power2;

import java.util.List;

public interface Power2Service {
    public List<Power2> selectByAdminId(Integer adminId);
}
