package betahouse.service;

import betahouse.model.po.UserActivity;

public interface UserActivityService {
    public int UpdateUserActivity(UserActivity userActivity);
    public int InsertUserActivity(UserActivity userActivity);
    public int DeleteUserActivity(Integer userActivityId);

}
