package betahouse.service.Impl;

import betahouse.core.base.MybatisUtil;
import betahouse.model.mapper.*;
import betahouse.model.po.Class;
import betahouse.model.po.Major;
import betahouse.model.po.User;
import betahouse.model.vo.ClassVo;
import betahouse.model.vo.UserVo;
import betahouse.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

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
    public UserVo selectUserVoBySchoolId(Integer schoolId) {
        return userMapper.selectAllInfoBySchoolId(schoolId);
    }

    @Override
    public PageInfo<UserVo> selectAllUserVoInPage(Integer pageNum, Integer pageSize) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(pageNum,pageSize);
        List<User> users=userMapper1.selectAll();
        PageInfo pageInfo = new PageInfo<>(users);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            //设置专业
            userVo.setMajor(sqlSession.getMapper(MajorMapper.class).selectByPrimaryKey(user.getMajorId()));
            //设置班级
            Class uclass= sqlSession.getMapper(ClassMapper.class).selectByPrimaryKey(user.getClassId());
            ClassVo classVo = new ClassVo(uclass);
            classVo.setMajor(userVo.getMajor());
            userVo.setUclass(classVo);
            //设置寝室
            DormitoryMapper dormitoryMapper = sqlSession.getMapper(DormitoryMapper.class);
            userVo.setDormitory(dormitoryMapper.selectByPrimaryKey(user.getDormitoryId()));

            userVo.setUserActivities(sqlSession.getMapper(UserActivityMapper.class).selectByUserId(userVo.getId()));
            userVo.setUserCleans(sqlSession.getMapper(UserCleanMapper.class).selectByUserId(userVo.getId()));
            userVo.setUserHonors(sqlSession.getMapper(UserHonorMapper.class).selectByUserId(userVo.getId()));
            userVo.setUserOffices(sqlSession.getMapper(UserOfficeMapper.class).selectByUserId(userVo.getId()));
            userVo.setUserPractices(sqlSession.getMapper(UserPracticeMapper.class).selectByUserId(userVo.getId()));
            userVo.setUserReserves(sqlSession.getMapper(UserReserveMapper.class).selectByUserId(userVo.getId()));
            userVo.setUserSkills(sqlSession.getMapper(UserSkillMapper.class).selectByUserId(userVo.getId()));
            userVo.setUserVolunteers(sqlSession.getMapper(UserVolunteerMapper.class).selectByUserId(userVo.getId()));
            list.add(userVo);
        }
        sqlSession.close();
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo<UserVo> selectAllUserVoByClassInPage(Integer pageNum, Integer pageSize, List<Class> classList) {
        Integer classes[] = new Integer[classList.size()];
        for(int i=0;i<classList.size();i++){
            classes[i]=classList.get(i).getId();
        }
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper1.selectByClasses(classes);
        PageInfo pageInfo = new PageInfo(users);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            //设置专业
            userVo.setMajor(sqlSession.getMapper(MajorMapper.class).selectByPrimaryKey(user.getMajorId()));
            sqlSession.commit();
            //设置班级
            Class uclass= sqlSession.getMapper(ClassMapper.class).selectByPrimaryKey(user.getClassId());
            ClassVo classVo = new ClassVo(uclass);
            classVo.setMajor(userVo.getMajor());
            userVo.setUclass(classVo);
            sqlSession.commit();
            //设置寝室
            DormitoryMapper dormitoryMapper = sqlSession.getMapper(DormitoryMapper.class);
            userVo.setDormitory(dormitoryMapper.selectByPrimaryKey(user.getDormitoryId()));
            sqlSession.commit();
            list.add(userVo);
        }
        sqlSession.close();
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public PageInfo<UserVo> selectAllUserVoByMajorInPage(Integer pageNum, Integer pageSize, List<Major> majorList) {
        Integer majors[] = new Integer[majorList.size()];
        for(int i=0;i<majorList.size();i++){
            majors[i]=majorList.get(i).getId();
        }
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper1.selectByMajors(majors);
        PageInfo pageInfo = new PageInfo(users);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            //设置专业
            userVo.setMajor(sqlSession.getMapper(MajorMapper.class).selectByPrimaryKey(user.getMajorId()));
            sqlSession.commit();
            //设置班级
            Class uclass= sqlSession.getMapper(ClassMapper.class).selectByPrimaryKey(user.getClassId());
            ClassVo classVo = new ClassVo(uclass);
            classVo.setMajor(userVo.getMajor());
            userVo.setUclass(classVo);
            sqlSession.commit();
            //设置寝室
            DormitoryMapper dormitoryMapper = sqlSession.getMapper(DormitoryMapper.class);
            userVo.setDormitory(dormitoryMapper.selectByPrimaryKey(user.getDormitoryId()));
            sqlSession.commit();
            list.add(userVo);
        }
        sqlSession.close();
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public Integer updateUserPolitical(Integer userId, String political){
        User user=userMapper.selectByPrimaryKey(userId);
        user.setPolitical(political);
        userMapper.updateByPrimaryKey(user);
        return 1;
    }

    @Override
    public PageInfo<UserVo> selectAlluserInPage(Integer currentPage, Integer pageSize) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(currentPage,pageSize);
        List<User> users=userMapper.selectTest();
        PageInfo pageInfo = new PageInfo(users);
        sqlSession.commit();
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            //设置专业
            userVo.setMajor(sqlSession.getMapper(MajorMapper.class).selectByPrimaryKey(user.getMajorId()));
            sqlSession.commit();
            //设置班级
            Class uclass= sqlSession.getMapper(ClassMapper.class).selectByPrimaryKey(user.getClassId());
            ClassVo classVo = new ClassVo(uclass);
            classVo.setMajor(userVo.getMajor());
            userVo.setUclass(classVo);
            sqlSession.commit();
            //设置寝室
            DormitoryMapper dormitoryMapper = sqlSession.getMapper(DormitoryMapper.class);
            userVo.setDormitory(dormitoryMapper.selectByPrimaryKey(user.getDormitoryId()));
            sqlSession.commit();
            list.add(userVo);
        }
        sqlSession.close();
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public Integer updateUserInfo(UserVo userVo) {
        User user = new User(userVo);
        return userMapper.updateByPrimaryKey(user);
    }
}
