package betahouse.service;

import betahouse.model.po.UserHonor;

import java.util.List;

public interface UserHonorService {
    public Integer UpdateUserHonor(UserHonor userHonor);
    public Integer InsertUserHonor(UserHonor userHonor);
    public Integer DeleteUserHonor(Integer userHonorId);
    public List<UserHonor> SelectUserHonorByUserId(Integer userId);
    public List<UserHonor> SelectUserHonorByUserIdAndTerm(Integer userId, Integer term);
}
