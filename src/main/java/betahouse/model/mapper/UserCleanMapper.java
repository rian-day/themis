package betahouse.model.mapper;

import betahouse.model.po.UserClean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserCleanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserClean record);

    UserClean selectByPrimaryKey(Integer id);
    List<UserClean> selectByUserId(Integer userId);

    List<UserClean> selectAll();

    int updateByPrimaryKey(UserClean record);
}