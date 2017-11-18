package betahouse;

import betahouse.core.base.MybatisUtil;
import betahouse.model.mapper.UserMapper;
import betahouse.model.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThemisApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() {
	}

	@Test
	public void dbTest(){
//		SqlSession sqlSession= MybatisUtil.getSqlSession();
//		String statement=
//				"betahouse.model.mapper.UserMapper.selectAllInfoBySchoolId";
//		User user =sqlSession.selectOne(statement,16905413);
//		sqlSession.close();
//		User user=userMapper.selectAllInfoByPrimaryKey(1);
//		System.out.println(user.getMajor().getMajorName());
//		System.out.print(1);
	}

	@Test
	public void test(){
		SqlSession sqlSession= MybatisUtil.getSqlSession();
		String statement=
				"betahouse.model.mapper.UserMapper.selectAll";
		List<User> user =sqlSession.selectList(statement);
		sqlSession.close();
		System.out.println(user.get(0).getRealName());
	}

}
