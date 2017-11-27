package betahouse.service;

import betahouse.model.po.Admin;

public interface AdminService {
    public Admin checkLogin(String email, String password);
    public Admin selectAdminInfo(Integer adminId);
}
