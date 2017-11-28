package betahouse.service;

import betahouse.model.po.Major;
import betahouse.model.po.User;
import betahouse.model.vo.UserVo;
import com.github.pagehelper.PageInfo;
import betahouse.model.po.Class;

import java.util.List;

public interface UserService {
    public Integer updateUserInfo(UserVo userVo);
    public User selectUserById(Integer id);
    public UserVo selectUserVoById(Integer id);
    public UserVo selectUserVoBySchoolId(Integer schoolId);

    public PageInfo<UserVo> selectAllUserVoInPage(Integer pageNum, Integer pageSize);
    public PageInfo<UserVo> selectAllUserVoByClassInPage(Integer pageNum, Integer pageSize , List<Class> classList);
    public PageInfo<UserVo> selectAllUserVoByMajorInPage(Integer pageNum, Integer pageSize , List<Major> majorList);

    public PageInfo<UserVo> selectAlluserInPage(Integer currentPage,Integer pageSize);

    public Integer updateUserPolitical(Integer userId ,String political);

}
