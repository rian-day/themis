package betahouse.model.mapper;

import betahouse.model.po.UserClean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserCleanMapper {

    UserClean selectByPrimaryKey(Integer id);
    List<UserClean> selectByUserId(Integer userId);
    List<UserClean> selectByUserIdAndTerm(Integer userId,Integer term);
    List<UserClean> selectAll();

    int insert(UserClean record);
    int insertList(List<UserClean> userCleans);

    int updateByPrimaryKey(UserClean record);

    int deleteByPrimaryKey(Integer id);
}