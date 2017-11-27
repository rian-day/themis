package betahouse.service;

import betahouse.model.po.UserReserve;

import java.util.List;

public interface UserReserveService {
    public Integer UpdateUserReserve(UserReserve userReserve);
    public Integer InsertUserReserve(UserReserve userReserve);
    public Integer DeleteUserReserveById(Integer userReserveId);
    public List<UserReserve> SelectUserReserveByUserId(Integer userId);
    public List<UserReserve> SelectUserReserveByUserIdAndTerm(Integer userId, Integer term);
}
