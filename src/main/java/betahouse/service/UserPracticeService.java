package betahouse.service;

import betahouse.model.po.UserPractice;

public interface UserPracticeService {
    public int UpdateUserPractice(UserPractice userPractice);
    public int InsertUserPractice(UserPractice userPractice);
    public int DeleteUserPractice(Integer userPracticeId);
}
