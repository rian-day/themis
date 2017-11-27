package betahouse.service;

import betahouse.model.po.User;
import betahouse.model.vo.UserVo;
import com.github.pagehelper.PageInfo;

public interface UserService {
    public User selectUserById(Integer id);
    public UserVo selectUserVoById(Integer id);
    public UserVo selectUserVoBySchoolId(Integer schoolId);

    public PageInfo<UserVo> selectAllUserVoInPage(Integer pageNum, Integer pageSize);

    public PageInfo<UserVo> selectAlluserInPage(Integer currentPage,Integer pageSize);

    public Integer updateUserPolitical(Integer userId ,String political);

}
