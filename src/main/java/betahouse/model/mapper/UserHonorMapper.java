package betahouse.model.mapper;

import betahouse.model.po.UserHonor;
import java.util.List;

public interface UserHonorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserHonor record);

    UserHonor selectByPrimaryKey(Integer id);

    List<UserHonor> selectAll();

    int updateByPrimaryKey(UserHonor record);
}