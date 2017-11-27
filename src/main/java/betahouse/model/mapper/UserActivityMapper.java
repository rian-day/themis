package betahouse.model.mapper;

import betahouse.model.po.UserActivity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserActivityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserActivity record);

    UserActivity selectByPrimaryKey(Integer id);

    List<UserActivity> selectByUserId(Integer userId);

    List<UserActivity> selectAll();

    int updateByPrimaryKey(UserActivity record);
}