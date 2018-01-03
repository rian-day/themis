package betahouse.service;

import betahouse.model.po.UserOffice;

import java.util.List;

public interface UserOfficeService {
    public int UpdateUserOffice(UserOffice userOffice);

    public int UpdateUserOfficeInList(List<UserOffice> userOfficeList);

    public int InsertUserOffice(UserOffice userOffice);
    public int InsertUserOfficeList(List<UserOffice> userOffices);

    public int DeleteUserOffice(Integer userofficeId);

    public List<UserOffice> SelectUserOfficeByUserIdAndTerm(Integer userId, Integer term);

    public List<UserOffice> SelectUserOfficeByUserId(Integer userId);
}
