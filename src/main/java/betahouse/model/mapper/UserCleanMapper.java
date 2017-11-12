package betahouse.model.mapper;

import betahouse.model.po.UserClean;
import java.util.List;

public interface UserCleanMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserClean record);

    UserClean selectByPrimaryKey(Integer id);

    List<UserClean> selectAll();

    int updateByPrimaryKey(UserClean record);
}