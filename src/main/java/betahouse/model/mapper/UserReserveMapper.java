package betahouse.model.mapper;

import betahouse.model.po.UserReserve;
import java.util.List;

public interface UserReserveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserReserve record);

    UserReserve selectByPrimaryKey(Integer id);

    List<UserReserve> selectAll();

    int updateByPrimaryKey(UserReserve record);
}