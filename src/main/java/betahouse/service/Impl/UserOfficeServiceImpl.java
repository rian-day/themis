package betahouse.service.Impl;

import betahouse.core.base.MybatisUtil;
import betahouse.model.mapper.UserOfficeMapper;
import betahouse.model.po.UserOffice;
import betahouse.service.UserOfficeService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserOfficeServiceImpl implements UserOfficeService{
    @Autowired
    UserOfficeMapper userOfficeMapper;
    @Override
    public int UpdateUserOffice(UserOffice userOffice) {
        return userOfficeMapper.updateByPrimaryKey(userOffice);
    }

    @Override
    public int UpdateUserOfficeInList(List<UserOffice> userOfficeList) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserOfficeMapper userOfficeMapper1 = sqlSession.getMapper(UserOfficeMapper.class);
        for(int i=0;i<userOfficeList.size();i++){
            userOfficeMapper1.updateByPrimaryKey(userOfficeList.get(i));
        }
        sqlSession.close();
        return 1;
    }

    @Override
    public int InsertUserOffice(UserOffice userOffice) {
        return userOfficeMapper.insert(userOffice);
    }

    @Override
    public int InsertUserOfficeList(List<UserOffice> userOffices) {
        return userOfficeMapper.insertList(userOffices);
    }

    @Override
    public int DeleteUserOffice(Integer userofficeId) {
        return userOfficeMapper.deleteByPrimaryKey(userofficeId);
    }

    @Override
    public List<UserOffice> SelectUserOfficeByUserIdAndTerm(Integer userId, Integer term) {
        if(term!=000000){
           return userOfficeMapper.selectByUserIdAndTerm(userId,term);
        }
        return userOfficeMapper.selectByUserId(userId);
    }

    @Override
    public List<UserOffice> SelectUserOfficeByUserId(Integer userId) {
        return userOfficeMapper.selectByUserId(userId);
    }

}
