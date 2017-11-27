package betahouse.service.Impl;

import betahouse.model.mapper.UserCleanMapper;
import betahouse.model.po.UserClean;
import betahouse.service.UserCleanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCleanServiceImpl implements UserCleanService {
    @Autowired
    UserCleanMapper userCleanMapper;
    @Override
    public Integer insertUserClean(UserClean userClean) {
        userCleanMapper.insert(userClean);
        return 1;
    }

    @Override
    public Integer updateUserClean(UserClean userClean) {
        return null;
    }

    @Override
    public Integer deleteUserClean(Integer userCleanId) {
        return null;
    }
}
