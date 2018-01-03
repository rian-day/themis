package betahouse.service.Impl;

import betahouse.model.mapper.UserReserveMapper;
import betahouse.model.po.UserReserve;
import betahouse.service.UserReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserReserveServiceImpl implements UserReserveService {
    @Autowired
    UserReserveMapper userReserveMapper;
    @Override
    public Integer UpdateUserReserve(UserReserve userReserve) {
        return userReserveMapper.updateByPrimaryKey(userReserve);
    }

    @Override
    public Integer InsertUserReserve(UserReserve userReserve) {
        return userReserveMapper.insert(userReserve);
    }

    @Override
    public Integer DeleteUserReserveById(Integer userReserveId) {
        return userReserveMapper.deleteByPrimaryKey(userReserveId);
    }

    @Override
    public List<UserReserve> SelectUserReserveByUserId(Integer userId) {
        return userReserveMapper.selectByUserId(userId);
    }

    @Override
    public List<UserReserve> SelectUserReserveByUserIdAndTerm(Integer userId, Integer term) {
        if(term!=000000){
            return userReserveMapper.selectByUserIdAndTerm(userId, term);
        }
        return userReserveMapper.selectByUserId(userId);
    }
}
