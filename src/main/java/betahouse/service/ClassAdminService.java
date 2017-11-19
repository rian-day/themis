package betahouse.service;

import betahouse.model.po.User;
import betahouse.model.po.UserReserve;
import betahouse.model.vo.UserVo;

public interface ClassAdminService {

    public Integer UpdateUserReserve(UserReserve reserve);
    public Integer InsertUserReserve(UserReserve reserve);
    public Integer DeleteUserReserveById(Integer UserReserveId);

    public Integer UpdateUserHonor();
    public Integer InsertUserHonor();
    public Integer DeleteUserHonor();

    public Integer UpdateUserSkill();
    public Integer InsertUserSkill();
    public Integer DeleteUserSkill();

    public Integer UpdateUserPolitical(Integer UserId ,String political);
}
