package betahouse.service.Impl;

import betahouse.model.mapper.AdminMapper;
import betahouse.model.po.Admin;
import betahouse.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin checkLogin(String email, String password) {
        Admin admin=adminMapper.selectByUserEmail(email);
        if(null!=admin&&admin.getPassword().equals(password)){
            return admin;
        }
        return null;
    }

    @Override
    public Admin selectAdminInfo(Integer adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }
}
