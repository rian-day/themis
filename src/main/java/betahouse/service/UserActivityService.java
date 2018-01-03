package betahouse.service;

import betahouse.model.po.UserActivity;

import java.util.List;

public interface UserActivityService {
    public int UpdateUserActivity(UserActivity userActivity);
    public int InsertUserActivity(UserActivity userActivity);
    public int InsertUserActivityGroup(List<UserActivity> list);
    public int DeleteUserActivity(Integer userActivityId);
    public List<UserActivity> SelectUserActivityByUserId(Integer userId);
    public List<UserActivity> SelectUserActivityByUserIdAndTerm(Integer userId, Integer term);
}
