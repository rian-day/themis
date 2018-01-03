package betahouse.service.Impl;

import betahouse.model.mapper.UserPracticeMapper;
import betahouse.model.po.UserPractice;
import betahouse.service.UserPracticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPracticeServiceImpl implements UserPracticeService{
    @Autowired
    UserPracticeMapper userPracticeMapper;

    @Override
    public int UpdateUserPractice(UserPractice userPractice) {
        return userPracticeMapper.updateByPrimaryKey(userPractice);
    }

    @Override
    public int InsertUserPractice(UserPractice userPractice) {
        return userPracticeMapper.insert(userPractice);
    }

    @Override
    public int DeleteUserPractice(Integer userPracticeId) {
        return userPracticeMapper.deleteByPrimaryKey(userPracticeId);
    }

    @Override
    public List<UserPractice> SelectUserPracticeByUserId(Integer userId) {

        return userPracticeMapper.selectByUserId(userId);
    }

    @Override
    public List<UserPractice> SelectUserPracticeByUserIdAndTerm(Integer userId, Integer term) {
        if(term!=000000)
            return userPracticeMapper.selectByUserIdAndTerm(userId,term);

        return userPracticeMapper.selectByUserId(userId);
    }
}
