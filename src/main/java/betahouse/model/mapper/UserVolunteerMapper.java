package betahouse.model.mapper;

import betahouse.model.po.UserVolunteer;
import java.util.List;

public interface UserVolunteerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVolunteer record);

    UserVolunteer selectByPrimaryKey(Integer id);

    List<UserVolunteer> selectAll();

    int updateByPrimaryKey(UserVolunteer record);
}