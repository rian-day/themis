package betahouse.service;

import betahouse.model.po.UserReserve;
import betahouse.model.vo.UserVo;

public interface ClassAdminService {
    
    public void UpdateUserPolitical();

    public void UpdateUserReserve();
    public void InsertUserReserve();
    public void DeleteUserReserve();

    public void UpdateUserHonor();
    public void InsertUserHonor();
    public void DeleteUserHonor();

    public void UpdateUserSkill();
    public void InsertUserSkill();
    public void DeleteUserSkill();
}
