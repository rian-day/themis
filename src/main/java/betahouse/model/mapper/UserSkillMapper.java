package betahouse.model.mapper;

import betahouse.model.po.UserSkill;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserSkillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSkill record);

    UserSkill selectByPrimaryKey(Integer id);
    List<UserSkill> selectByUserId(Integer userId);
    List<UserSkill> selectByUserIdAndTerm(Integer userId,Integer term);
    List<UserSkill> selectAll();

    int updateByPrimaryKey(UserSkill record);
}