package betahouse.model.mapper;

import betahouse.model.po.UserOffice;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserOfficeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOffice record);

    UserOffice selectByPrimaryKey(Integer id);
    List<UserOffice> selectByUserId(Integer userId);

    List<UserOffice> selectAll();

    int updateByPrimaryKey(UserOffice record);
}