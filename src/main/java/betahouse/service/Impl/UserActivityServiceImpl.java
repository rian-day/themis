package betahouse.service.Impl;

import betahouse.model.mapper.UserActivityMapper;
import betahouse.model.po.UserActivity;
import betahouse.service.UserActivityService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActivityServiceImpl implements UserActivityService {
    @Autowired
    UserActivityMapper userActivityMapper;

    @Override
    public int UpdateUserActivity(UserActivity userActivity) {
        userActivityMapper.updateByPrimaryKey(userActivity);
        return 1;
    }

    @Override
    public int InsertUserActivity(UserActivity userActivity) {
        userActivityMapper.insert(userActivity);
        return 1;
    }

    @Override
    public int DeleteUserActivity(Integer userActivityId) {
        userActivityMapper.deleteByPrimaryKey(userActivityId);
        return 1;
    }
}
