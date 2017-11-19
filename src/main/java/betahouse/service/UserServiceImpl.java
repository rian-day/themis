package betahouse.service;

import betahouse.model.vo.UserVo;
import betahouse.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    /**
     *  通过用户Id查找用户所有信息
     * @param id
     * @return
     */
    @Override
    public UserVo SelectUserVoById(Integer id) {
        return userMapper.selectAllInfoByPrimaryKey(id);
    }

    @Override
    public UserVo SelectUserVoBySchoolId(Integer schoolId) {
        return userMapper.selectAllInfoBySchoolId(schoolId);
    }
}
