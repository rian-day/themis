package betahouse.model.mapper;

import betahouse.model.po.UserReserve;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserReserveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserReserve record);

    UserReserve selectByPrimaryKey(Integer id);
    List<UserReserve> selectByUserId(Integer userId);
    List<UserReserve> selectByUserIdAndTerm(Integer userId,Integer term);
    List<UserReserve> selectAll();

    int updateByPrimaryKey(UserReserve record);

}