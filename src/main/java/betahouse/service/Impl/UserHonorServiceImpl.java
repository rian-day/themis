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
        userHonorMapper.insert(userHonor);
        return 1;
    }

    @Override
    public Integer DeleteUserHonor(Integer userHonorId) {
        userHonorMapper.deleteByPrimaryKey(userHonorId);
        return 1;
    }

    @Override
    public List<UserHonor> SelectUserHonorByUserId(Integer userId) {

        return userHonorMapper.selectByUserId(userId);
    }

    @Override
    public List<UserHonor> SelectUserHonorByUserIdAndTerm(Integer userId, Integer term) {
        return userHonorMapper.selectByUserIdAndTerm(userId,term);
    }
}
