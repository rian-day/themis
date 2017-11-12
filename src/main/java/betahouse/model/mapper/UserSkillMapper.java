package betahouse.model.mapper;

import betahouse.model.po.UserSkill;
import java.util.List;

public interface UserSkillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserSkill record);

    UserSkill selectByPrimaryKey(Integer id);

    List<UserSkill> selectAll();

    int updateByPrimaryKey(UserSkill record);
}