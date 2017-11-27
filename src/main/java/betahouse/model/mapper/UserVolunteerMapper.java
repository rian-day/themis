package betahouse.model.mapper;

import betahouse.model.po.UserVolunteer;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserVolunteerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserVolunteer record);

    UserVolunteer selectByPrimaryKey(Integer id);
    List<UserVolunteer> selectByUserId(Integer userId);

    List<UserVolunteer> selectAll();

    int updateByPrimaryKey(UserVolunteer record);
}