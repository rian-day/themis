package betahouse.service.Impl;

import betahouse.model.mapper.UserHonorMapper;
import betahouse.model.po.UserHonor;
import betahouse.service.UserHonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserHonorServiceImpl implements UserHonorService {
    @Autowired
    UserHonorMapper userHonorMapper;
    @Override
    public Integer UpdateUserHonor(UserHonor userHonor) {
        userHonorMapper.updateByPrimaryKey(userHonor);
        return 1;
    }

    @Override
    public Integer InsertUserHonor(UserHonor userHonor) {
        return userHonorMapper.insert(userHonor);
    }

    @Override
    public Integer DeleteUserHonor(Integer userHonorId) {
        return userHonorMapper.deleteByPrimaryKey(userHonorId);
    }

    @Override
    public List<UserHonor> SelectUserHonorByUserId(Integer userId) {

        return userHonorMapper.selectByUserId(userId);
    }

    @Override
    public List<UserHonor> SelectUserHonorByUserIdAndTerm(Integer userId, Integer term) {
        if(term!=000000)
            return userHonorMapper.selectByUserIdAndTerm(userId,term);

        return userHonorMapper.selectByUserId(userId);
    }
}
