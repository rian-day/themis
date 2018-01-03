package betahouse.model.mapper;

import betahouse.model.vo.UserVo;
import betahouse.model.po.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(User record);
    Integer insertList(List<User> userList);

    User selectByPrimaryKey(Integer id);
    List<User> selectByDormitoryId(Integer dormitoryId);
    User selectByShcoolId(String schoolId);
    List<User> selectByClasses(Integer []classId);
    List<User> selectByMajors(Integer []majorId);
    List<User> selectAll();
    UserVo selectAllInfoByPrimaryKey(Integer id);
    UserVo selectAllInfoBySchoolId(Integer schoolId);
    List<UserVo> selectAllInfoListPage();
    List<User> selectTest();
    List<UserVo> selectAllUserVo();
    List<User> selectUserInSchoolIds(String[] schoolIds);

    Integer updateByPrimaryKey(User record);


}