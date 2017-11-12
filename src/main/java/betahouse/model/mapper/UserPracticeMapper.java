package betahouse.model.mapper;

import betahouse.model.po.UserPractice;
import java.util.List;

public interface UserPracticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPractice record);

    UserPractice selectByPrimaryKey(Integer id);

    List<UserPractice> selectAll();

    int updateByPrimaryKey(UserPractice record);
}