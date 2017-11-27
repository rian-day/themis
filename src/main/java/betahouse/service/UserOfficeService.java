package betahouse.service;

import betahouse.model.po.UserOffice;

public interface UserOfficeService {
    public int UpdateUserOffice(UserOffice userOffice);
    public int InsertUserOffice(UserOffice userOffice);
    public int DeleteUserOffice(Integer userofficeId);
}
