package betahouse.service;

import betahouse.model.po.UserClean;

public interface UserCleanService {
    public Integer insertUserClean(UserClean userClean);
    public Integer updateUserClean(UserClean userClean);
    public Integer deleteUserClean(Integer userCleanId);
}
