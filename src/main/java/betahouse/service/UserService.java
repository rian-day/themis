package betahouse.service;

import betahouse.model.po.Major;
import betahouse.model.po.User;
import betahouse.model.vo.UserVo;
import com.github.pagehelper.PageInfo;
import betahouse.model.po.Class;

import java.util.List;

public interface UserService {
    public Integer updateUserInfo(UserVo userVo);

    public Integer insertUserInfoWithGroup(List<User> userList);

    public User selectUserById(Integer id);
    public UserVo selectUserVoById(Integer id);
    public User selectUserBySchoolId(String schoolId);
    public List<User> selectUserByDormitoryId(Integer dormitoryId);
    public UserVo selectUserVoBySchoolId(Integer schoolId);
    public List<UserVo> selectAllUserVo();
    public PageInfo<UserVo> selectAllUserVoInPage(Integer pageNum, Integer pageSize);
    public PageInfo<UserVo> selectAllUserVoByClassInPage(Integer pageNum, Integer pageSize , List<Class> classList);
    public List<UserVo> selectAllUserVoByClass(List<Class> classList);
    public PageInfo<UserVo> selectAllUserVoByMajorInPage(Integer pageNum, Integer pageSize , List<Major> majorList);
    public List<UserVo> selectAllUserVoByMajor(List<Major> majorList);
    public List<UserVo> selectAllUserVoByTerm(Integer term);
    public PageInfo<UserVo> selectAlluserInPage(Integer currentPage,Integer pageSize);
    public List<User> selectAllUser();
    public List<User> selectAllUserInShoolIds(String[] schoolIds);
    public Integer checkUserBySchoolId(String schoolId,String realName);

    public Integer updateUserPolitical(Integer userId ,String political);

}
