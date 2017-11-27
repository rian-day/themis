package betahouse.service;

import betahouse.model.po.UserVolunteer;

public interface UserVolunteerService {
    public int UpdateUserVolunteer(UserVolunteer userVolunteer);
    public int InsertUserVolunteer(UserVolunteer userVolunteer);
    public int DeleteUserVolunteer(Integer userVolunteerId);
}
