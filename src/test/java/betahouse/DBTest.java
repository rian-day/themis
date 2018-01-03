package betahouse;

import betahouse.core.base.MybatisUtil;
import betahouse.model.mapper.*;
import betahouse.model.po.*;
import betahouse.model.po.Class;
import betahouse.model.vo.ClassVo;
import betahouse.model.vo.UserVo;
import betahouse.service.UserReserveService;
import betahouse.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DBTest {
    @Autowired
    UserReserveService userReserveService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    public void selectUserReserveByUserId(){
        List<UserReserve> userReserves = userReserveService.SelectUserReserveByUserIdAndTerm(1, 201702);
        System.out.println(1);
    }

    @Test
    public void contextLoads() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(1,2);
        List<User> users=userMapper.selectTest();
        PageInfo pageInfo = new PageInfo<>(users);
        List<UserVo> list = new ArrayList<UserVo>();
        for(int i=0;i<users.size();i++){
            User user = users.get(i);
            UserVo userVo = new UserVo(user);
            //设置专业
            userVo.setMajor(sqlSession.getMapper(MajorMapper.class).selectByPrimaryKey(user.getMajorId()));
            //设置班级
            Class uclass= sqlSession.getMapper(ClassMapper.class).selectByPrimaryKey(user.getClassId());
            userVo.setUclass(uclass);
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

        System.out.println(1);
    }

    @Test
    public void ListUserInsert(){
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setSchoolId("16");
        user.setRealName("组插入1");
        userList.add(user);
        user = new User();
        user.setRealName("组插入2");
        userList.add(user);
        user.setSchoolId("16");
        userMapper.insertList(userList);
    }

    @Test
    public void selectUserInSchoolIds(){
        List<User> result = userMapper.selectUserInSchoolIds(new String[]{"16","16905413"});
        System.out.println(1);
    }

    @Test
    public void transactionalTest(){
        PageHelper.startPage(0, 2);
        List<User> users = userService.selectAllUser();
        PageInfo<User> p=new PageInfo<User>(users);
        System.out.println("1");
    }
}
