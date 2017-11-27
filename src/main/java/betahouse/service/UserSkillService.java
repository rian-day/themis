package betahouse.service;

import betahouse.model.po.UserSkill;

import java.util.List;

public interface UserSkillService {
    public Integer UpdateUserSkill(UserSkill userSkill);
    public Integer InsertUserSkill(UserSkill userSkill);
    public Integer DeleteUserSkill(Integer userSkillId);
    public List<UserSkill> SelectUserSkillByUserId(Integer userId);
    public List<UserSkill> SelectUserSkillByUserIdAndTerm(Integer userId, Integer term);
}
