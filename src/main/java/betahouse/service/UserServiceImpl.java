package betahouse.service;

import betahouse.model.vo.UserVo;
import betahouse.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public UserVo SelectUserVoById(Integer id) {
        return userMapper.selectAllInfoByPrimaryKey(id);
    }
}
