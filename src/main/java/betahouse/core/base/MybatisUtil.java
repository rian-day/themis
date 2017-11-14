package betahouse.core.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;

import jdk.internal.util.xml.impl.Input;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<>();
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            try (InputStream in = Resources.getResourceAsStream("mybatis-config.xml")) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 禁止外界通过new方法创建
     */
    private MybatisUtil(){}

    /**
     * 获取SqlSession
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=threadLocal.get();
        if(sqlSession==null){
            sqlSession=sqlSessionFactory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    //关闭SqlSession
    public static void closeSqlSession(){
        SqlSession sqlSession=threadLocal.get();
        if(sqlSession!=null){
            sqlSession.close();
            threadLocal.remove();
        }
    }

    public static void main(String[] args) {
        Connection conn=MybatisUtil.getSqlSession().getConnection();
        System.out.println(conn!=null?"连接成功":"连接失败");
    }

}