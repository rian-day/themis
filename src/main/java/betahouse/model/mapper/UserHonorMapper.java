package betahouse.model.mapper;

import betahouse.model.po.UserHonor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserHonorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserHonor record);

    UserHonor selectByPrimaryKey(Integer id);
    List<UserHonor> selectByUserId(Integer userId);
    List<UserHonor> selectByUserIdAndTerm(Integer userId,Integer term);

    List<UserHonor> selectAll();

    int updateByPrimaryKey(UserHonor record);

}