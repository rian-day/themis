package betahouse.service.Impl;

import betahouse.model.mapper.UserCleanMapper;
import betahouse.model.po.UserClean;
import betahouse.service.UserCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCleanServiceImpl implements UserCleanService {
    @Autowired
    UserCleanMapper userCleanMapper;
    @Override
    public Integer insertUserClean(UserClean userClean) {
        return userCleanMapper.insert(userClean);
    }


    @Override
    public Integer insertUserCleanList(List<UserClean> userCleans) {
        return userCleanMapper.insertList(userCleans);
    }

    @Override
    public Integer updateUserClean(UserClean userClean) {
        return userCleanMapper.updateByPrimaryKey(userClean);
    }

    @Override
    public Integer deleteUserClean(Integer userCleanId) {
        return userCleanMapper.deleteByPrimaryKey(userCleanId);
    }

    @Override
    public List<UserClean> SelectUserCleanByUserId(Integer userId) {

        return userCleanMapper.selectByUserId(userId);
    }

    @Override
    public List<UserClean> SelectUserCleanByUserIdAndTerm(Integer userId, Integer term) {
        if(term!=000000)
            return userCleanMapper.selectByUserIdAndTerm(userId,term);

        return userCleanMapper.selectByUserId(userId);
    }
}
