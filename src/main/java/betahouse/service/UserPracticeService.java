package betahouse.service;

import betahouse.model.po.UserPractice;

import java.util.List;

public interface UserPracticeService {
    public int UpdateUserPractice(UserPractice userPractice);
    public int InsertUserPractice(UserPractice userPractice);
    public int DeleteUserPractice(Integer userPracticeId);
    public List<UserPractice> SelectUserPracticeByUserId(Integer userId);
    public List<UserPractice> SelectUserPracticeByUserIdAndTerm(Integer userId, Integer term);
}
