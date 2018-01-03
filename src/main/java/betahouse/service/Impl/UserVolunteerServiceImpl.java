package betahouse.service.Impl;

import betahouse.model.mapper.UserVolunteerMapper;
import betahouse.model.po.UserVolunteer;
import betahouse.service.UserVolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserVolunteerServiceImpl implements UserVolunteerService{
    @Autowired
    UserVolunteerMapper userVolunteerMapper;

    @Override
    public int UpdateUserVolunteer(UserVolunteer userVolunteer) {
        return userVolunteerMapper.updateByPrimaryKey(userVolunteer);
    }

    @Override
    public int InsertUserVolunteer(UserVolunteer userVolunteer) {
        return userVolunteerMapper.insert(userVolunteer);
    }

    @Override
    public int DeleteUserVolunteer(Integer userVolunteerId) {
        return userVolunteerMapper.deleteByPrimaryKey(userVolunteerId);
    }

    @Override
    public List<UserVolunteer> SelectUserVolunteerByUserId(Integer userId) {

        return userVolunteerMapper.selectByUserId(userId);
    }

    @Override
    public List<UserVolunteer> SelectUserVolunteerByUserIdAndTerm(Integer userId, Integer term) {
        if(term!=000000)
            return userVolunteerMapper.selectByUserIdAndTerm(userId,term);

        return userVolunteerMapper.selectByUserId(userId);
    }

}
