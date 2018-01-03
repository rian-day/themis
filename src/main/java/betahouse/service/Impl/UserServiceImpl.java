package betahouse.service.Impl;

import betahouse.model.mapper.ClassMapper;
import betahouse.model.mapper.DormitoryMapper;
import betahouse.model.mapper.MajorMapper;
import betahouse.model.mapper.UserMapper;
import betahouse.model.po.Class;
import betahouse.model.po.Major;
import betahouse.model.po.User;
import betahouse.model.vo.UserVo;
import betahouse.service.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    MajorService majorService;
    @Autowired
    ClassService classService;
    @Autowired
    DormitoryMapper dormitoryMapper;
    @Autowired
    UserReserveService userReserveService;
    @Autowired
    UserHonorService userHonorService;
    @Autowired
    UserSkillService userSkillService;
    @Autowired
    UserOfficeService userOfficeService;
    @Autowired
    UserActivityService userActivityService;
    @Autowired
    UserCleanService userCleanService;
    @Autowired
    UserPracticeService userPracticeService;
    @Autowired
    UserVolunteerService userVolunteerService;

    @Transactional
    @Override
    public User selectUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     *  通过用户Id查找用户所有信息
     * @param id
     * @return
     */
    @Override
    public UserVo selectUserVoById(Integer id) {
        return userMapper.selectAllInfoByPrimaryKey(id);
    }
    @Override
    public User selectUserBySchoolId(String schoolId) {
        return userMapper.selectByShcoolId(schoolId);
    }

    @Override
    public List<User> selectUserByDormitoryId(Integer dormitoryId) {
        return userMapper.selectByDormitoryId(dormitoryId);
    }

    @Override
    public UserVo selectUserVoBySchoolId(Integer schoolId) {
        return userMapper.selectAllInfoBySchoolId(schoolId);
    }

    /**
     * 分页查找所有用户
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Transactional
    @Override
    public PageInfo<UserVo> selectAllUserVoInPage(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<User> users=userMapper.selectAll();
        PageInfo pageInfo = new PageInfo<>(users);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            list.add(userVo);
        }
        setUserBaseInfo(list);
        setUserExtraInfo(list);
        pageInfo.setList(list);
        return pageInfo;
    }

    /**
     * 通过班级查找所有用户
     * @param pageNum
     * @param pageSize
     * @param classList
     * @return
     */
    @Transactional
    @Override
    public PageInfo<UserVo> selectAllUserVoByClassInPage(Integer pageNum, Integer pageSize, List<Class> classList) {
        Integer classes[] = new Integer[classList.size()];
        for(int i=0;i<classList.size();i++){
            classes[i]=classList.get(i).getId();
        }
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectByClasses(classes);
        PageInfo pageInfo = new PageInfo(users);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            list.add(userVo);
        }
        setUserBaseInfo(list);
        pageInfo.setList(list);
        return pageInfo;
    }

    @Transactional
    @Override
    public List<UserVo> selectAllUserVoByClass(List<Class> classList) {
        Integer classes[] = new Integer[classList.size()];
        for(int i=0;i<classList.size();i++){
            classes[i]=classList.get(i).getId();
        }
        List<User> users = userMapper.selectByClasses(classes);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            list.add(userVo);
        }
        setUserBaseInfo(list);
        return list;
    }

    @Transactional
    @Override
    public List<UserVo> selectAllUserVoByMajor(List<Major> majorList) {
        Integer majors[] = new Integer[majorList.size()];
        for(int i=0;i<majorList.size();i++){
            majors[i]=majorList.get(i).getId();
        }
        List<User> users = userMapper.selectByMajors(majors);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            list.add(userVo);
        }
        setUserBaseInfo(list);
        return list;
    }

    /**
     * 通过专业查找所有用户
     * @param pageNum
     * @param pageSize
     * @param majorList
     * @return
     */
    @Transactional
    @Override
    public PageInfo<UserVo> selectAllUserVoByMajorInPage(Integer pageNum, Integer pageSize, List<Major> majorList) {
        Integer majors[] = new Integer[majorList.size()];
        for(int i=0;i<majorList.size();i++){
            majors[i]=majorList.get(i).getId();
        }
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.selectByMajors(majors);
        PageInfo pageInfo = new PageInfo(users);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            list.add(userVo);
        }
        setUserBaseInfo(list);
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public Integer checkUserBySchoolId(String schoolId, String realName) {
        User user = userMapper.selectByShcoolId(schoolId);
        if(user.getRealName().equals(realName))
            return 1;
        return 0;
    }

    @Transactional
    @Override
    public Integer updateUserPolitical(Integer userId, String political){
        User user=userMapper.selectByPrimaryKey(userId);
        user.setPolitical(political);
        userMapper.updateByPrimaryKey(user);
        return 1;
    }

    /**
     *  查找所有用户
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Transactional
    @Override
    public PageInfo<UserVo> selectAlluserInPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> users=userMapper.selectAll();
        PageInfo pageInfo = new PageInfo(users);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            list.add(userVo);
        }
        setUserBaseInfo(list);
        //setUserExtraInfo(list);
        pageInfo.setList(list);
        return pageInfo;
    }

    @Transactional
    @Override
    public Integer updateUserInfo(UserVo userVo) {
        User user = new User(userVo);
        return userMapper.updateByPrimaryKey(user);
    }

    @Transactional
    @Override
    public List<User> selectAllUser() {
        return userMapper.selectAll();
    }

    @Transactional
    @Override
    public List<User> selectAllUserInShoolIds(String[] schoolIds) {
        return userMapper.selectUserInSchoolIds(schoolIds);
    }

    @Transactional
    @Override
    public List<UserVo> selectAllUserVo() {
        return userMapper.selectAllUserVo();
    }

    /**
     *  查找所有用户信息
     * @param term
     * @return
     */
    @Transactional
    @Override
    public List<UserVo> selectAllUserVoByTerm(Integer term) {
        List<User> users = userMapper.selectAll();
        List<UserVo> result = new ArrayList<>();
        for(int i=0;i<users.size();i++){
            UserVo userVo = new UserVo(users.get(i));
            userVo.setUserActivities(userActivityService.SelectUserActivityByUserIdAndTerm(userVo.getId(),term));
            userVo.setUserCleans(userCleanService.SelectUserCleanByUserIdAndTerm(userVo.getId(),term));
            userVo.setUserHonors(userHonorService.SelectUserHonorByUserIdAndTerm(userVo.getId(),term));
            userVo.setUserOffices(userOfficeService.SelectUserOfficeByUserIdAndTerm(userVo.getId(),term));
            userVo.setUserPractices(userPracticeService.SelectUserPracticeByUserIdAndTerm(userVo.getId(),term));
            userVo.setUserReserves(userReserveService.SelectUserReserveByUserIdAndTerm(userVo.getId(),term));
            userVo.setUserSkills(userSkillService.SelectUserSkillByUserIdAndTerm(userVo.getId(),term));
            userVo.setUserVolunteers(userVolunteerService.SelectUserVolunteerByUserIdAndTerm(userVo.getId(),term));
            result.add(userVo);
        }
        setUserBaseInfo(result);
        return result;
    }

    @Override
    public Integer insertUserInfoWithGroup(List<User> userList) {
        return userMapper.insertList(userList);
    }

    public void setUserBaseInfo(List<UserVo> userVos){
        for(int i=0;i<userVos.size();i++) {
            UserVo userVo = userVos.get(i);
            //设置专业
            userVo.setMajor(majorService.selectByMajorId(userVo.getMajorId()));
            //设置班级
            userVo.setUclass(classService.selectClassByClassId(userVo.getClassId()));
            //设置寝室
            userVo.setDormitory(dormitoryMapper.selectByPrimaryKey(userVo.getDormitoryId()));
        }
    }
    public void setUserExtraInfo(List<UserVo> userVos){
        for(int i=0;i<userVos.size();i++) {
            UserVo userVo = userVos.get(i);
            userVo.setUserActivities(userActivityService.SelectUserActivityByUserId(userVo.getId()));
            userVo.setUserCleans(userCleanService.SelectUserCleanByUserId(userVo.getId()));
            userVo.setUserHonors(userHonorService.SelectUserHonorByUserId(userVo.getId()));
            userVo.setUserOffices(userOfficeService.SelectUserOfficeByUserId(userVo.getId()));
            userVo.setUserPractices(userPracticeService.SelectUserPracticeByUserId(userVo.getId()));
            userVo.setUserReserves(userReserveService.SelectUserReserveByUserId(userVo.getId()));
            userVo.setUserSkills(userSkillService.SelectUserSkillByUserId(userVo.getId()));
            userVo.setUserVolunteers(userVolunteerService.SelectUserVolunteerByUserId(userVo.getId()));
        }
    }


}
