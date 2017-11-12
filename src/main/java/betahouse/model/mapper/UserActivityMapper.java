package betahouse.model.mapper;

import betahouse.model.po.UserActivity;
import java.util.List;

public interface UserActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserActivity record);

    UserActivity selectByPrimaryKey(Integer id);

    List<UserActivity> selectAll();

    int updateByPrimaryKey(UserActivity record);
}