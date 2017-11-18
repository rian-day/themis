package betahouse.model.mapper;

import betahouse.model.vo.UserVo;
import betahouse.model.po.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    UserVo selectAllInfoByPrimaryKey(Integer id);

    UserVo selectAllInfoBySchoolId(String schoolId);
}