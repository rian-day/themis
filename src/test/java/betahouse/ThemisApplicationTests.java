package betahouse;

import betahouse.core.base.MybatisUtil;
import betahouse.model.po.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThemisApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void dbTest(){
		SqlSession sqlSession= MybatisUtil.getSqlSession();
		String statement=
				"betahouse.model.mapper.UserMapper.selectAllInfoByPrimaryKey";
		User user =sqlSession.selectOne(statement,1);
		sqlSession.close();
		System.out.println(user.getMajor().getMajorName());
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
