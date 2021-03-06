package betahouse.service.Impl;

import betahouse.model.mapper.UserSkillMapper;
import betahouse.model.po.UserSkill;
import betahouse.service.UserSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserSkillServiceImpl implements UserSkillService {
    @Autowired
    UserSkillMapper userSkillMapper;
    @Override
    public Integer UpdateUserSkill(UserSkill userSkill) {
        return userSkillMapper.updateByPrimaryKey(userSkill);
    }

    @Override
    public Integer InsertUserSkill(UserSkill userSkill) {
        return userSkillMapper.insert(userSkill);
    }

    @Override
    public Integer DeleteUserSkill(Integer userSkillId) {
        return userSkillMapper.deleteByPrimaryKey(userSkillId);
    }

    @Override
    public List<UserSkill> SelectUserSkillByUserId(Integer userId) {
        return userSkillMapper.selectByUserId(userId);
    }

    @Override
    public List<UserSkill> SelectUserSkillByUserIdAndTerm(Integer userId, Integer term) {
        if(term!=000000)
            return userSkillMapper.selectByUserIdAndTerm(userId,term);
        return userSkillMapper.selectByUserId(userId);
    }
}
