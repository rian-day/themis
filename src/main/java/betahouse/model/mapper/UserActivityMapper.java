package betahouse.model.mapper;

import betahouse.model.po.UserActivity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserActivityMapper {

    UserActivity selectByPrimaryKey(Integer id);
    List<UserActivity> selectByUserId(Integer userId);
    List<UserActivity> selectByUserIdAndTerm(Integer userId,Integer term);
    List<UserActivity> selectAll();

    int insert(UserActivity record);
    int insertGroup(List<UserActivity> list);

    int updateByPrimaryKey(UserActivity record);

    int deleteByPrimaryKey(Integer id);
}