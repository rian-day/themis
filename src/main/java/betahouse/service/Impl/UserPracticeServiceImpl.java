package betahouse.service.Impl;

import betahouse.model.mapper.UserPracticeMapper;
import betahouse.model.po.UserPractice;
import betahouse.service.UserPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPracticeServiceImpl implements UserPracticeService{
    @Autowired
    UserPracticeMapper userPracticeMapper;

    @Override
    public int UpdateUserPractice(UserPractice userPractice) {
        userPracticeMapper.updateByPrimaryKey(userPractice);
        return 1;
    }

    @Override
    public int InsertUserPractice(UserPractice userPractice) {
        userPracticeMapper.insert(userPractice);
        return 1;
    }

    @Override
    public int DeleteUserPractice(Integer userPracticeId) {
        userPracticeMapper.deleteByPrimaryKey(userPracticeId);
        return 1;
    }
}
