package betahouse.model.mapper;

import betahouse.model.vo.UserVo;
import betahouse.model.po.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectByClasses(Integer []classId);
    List<User> selectByMajors(Integer []majorId);

    List<User> selectAll();

    Integer updateByPrimaryKey(User record);

    UserVo selectAllInfoByPrimaryKey(Integer id);

    UserVo selectAllInfoBySchoolId(Integer schoolId);

    List<UserVo> selectAllInfoListPage();

    List<User> selectTest();
}