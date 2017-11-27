package betahouse.service.Impl;

import betahouse.model.mapper.UserOfficeMapper;
import betahouse.model.po.UserOffice;
import betahouse.service.UserOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserOfficeServiceImpl implements UserOfficeService{
    @Autowired
    UserOfficeMapper userOfficeMapper;
    @Override
    public int UpdateUserOffice(UserOffice userOffice) {
        userOfficeMapper.updateByPrimaryKey(userOffice);
        return 1;
    }

    @Override
    public int InsertUserOffice(UserOffice userOffice) {
        userOfficeMapper.insert(userOffice);
        return 1;
    }

    @Override
    public int DeleteUserOffice(Integer userofficeId) {
        userOfficeMapper.deleteByPrimaryKey(userofficeId);
        return 1;
    }
}
