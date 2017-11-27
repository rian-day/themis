package betahouse.model.mapper;

import betahouse.model.po.UserPractice;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserPracticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPractice record);

    UserPractice selectByPrimaryKey(Integer id);
    List<UserPractice> selectByUserId(Integer userId);

    List<UserPractice> selectAll();

    int updateByPrimaryKey(UserPractice record);
}