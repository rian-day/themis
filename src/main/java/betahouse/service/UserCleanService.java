package betahouse.service;

import betahouse.model.po.UserClean;

import java.util.List;

public interface UserCleanService {
    public Integer insertUserClean(UserClean userClean);
    public Integer insertUserCleanList(List<UserClean> userCleans);
    public Integer updateUserClean(UserClean userClean);
    public Integer deleteUserClean(Integer userCleanId);
    public List<UserClean> SelectUserCleanByUserId(Integer userId);
    public List<UserClean> SelectUserCleanByUserIdAndTerm(Integer userId, Integer term);
}
