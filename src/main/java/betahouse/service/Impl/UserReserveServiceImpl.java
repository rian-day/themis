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
        userReserveMapper.updateByPrimaryKey(userReserve);
        return 1;
    }

    @Override
    public Integer InsertUserReserve(UserReserve userReserve) {
        userReserveMapper.insert(userReserve);
        return 1;
    }

    @Override
    public Integer DeleteUserReserveById(Integer userReserveId) {
        userReserveMapper.deleteByPrimaryKey(userReserveId);
        return 1;
    }

    @Override
    public List<UserReserve> SelectUserReserveByUserId(Integer userId) {
        return userReserveMapper.selectByUserId(userId);
    }

    @Override
    public List<UserReserve> SelectUserReserveByUserIdAndTerm(Integer userId, Integer term) {
        return userReserveMapper.selectByUserIdAndTerm(userId, term);
    }
}
