package betahouse.service;

import betahouse.model.po.UserVolunteer;

import java.util.List;

public interface UserVolunteerService {
    public int UpdateUserVolunteer(UserVolunteer userVolunteer);
    public int InsertUserVolunteer(UserVolunteer userVolunteer);
    public int DeleteUserVolunteer(Integer userVolunteerId);
    public List<UserVolunteer> SelectUserVolunteerByUserId(Integer userId);
    public List<UserVolunteer> SelectUserVolunteerByUserIdAndTerm(Integer userId, Integer term);
}
