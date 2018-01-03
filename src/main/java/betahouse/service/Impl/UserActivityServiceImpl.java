package betahouse.service.Impl;

import betahouse.model.mapper.UserActivityMapper;
import betahouse.model.po.UserActivity;
import betahouse.service.UserActivityService;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserActivityServiceImpl implements UserActivityService {
    @Autowired
    UserActivityMapper userActivityMapper;

    @Override
    public int UpdateUserActivity(UserActivity userActivity) {
        return userActivityMapper.updateByPrimaryKey(userActivity);
    }

    @Override
    public int InsertUserActivity(UserActivity userActivity) {
        return userActivityMapper.insert(userActivity);
    }

    @Override
    public int InsertUserActivityGroup(List<UserActivity> list) {
        return userActivityMapper.insertGroup(list);
    }

    @Override
    public int DeleteUserActivity(Integer userActivityId) {
        return userActivityMapper.deleteByPrimaryKey(userActivityId);
    }

    @Override
    public List<UserActivity> SelectUserActivityByUserId(Integer userId) {

        return userActivityMapper.selectByUserId(userId);
    }

    @Override
    public List<UserActivity> SelectUserActivityByUserIdAndTerm(Integer userId, Integer term) {
        if(term!=000000)
            return userActivityMapper.selectByUserIdAndTerm(userId,term);

        return userActivityMapper.selectByUserId(userId);
    }
}
