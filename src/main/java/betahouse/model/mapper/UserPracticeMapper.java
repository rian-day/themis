package betahouse.model.mapper;

import betahouse.model.po.UserOffice;
import betahouse.model.po.UserPractice;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserPracticeMapper {

    UserPractice selectByPrimaryKey(Integer id);
    List<UserPractice> selectByUserId(Integer userId);
    List<UserPractice> selectByUserIdAndTerm(Integer userId, Integer term);
    List<UserPractice> selectAll();

    int updateByPrimaryKey(UserPractice record);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPractice record);
    int insertList(List<UserPractice> userPractices);
}