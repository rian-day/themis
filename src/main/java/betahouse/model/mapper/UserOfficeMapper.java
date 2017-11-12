package betahouse.model.mapper;

import betahouse.model.po.UserOffice;
import java.util.List;

public interface UserOfficeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserOffice record);

    UserOffice selectByPrimaryKey(Integer id);

    List<UserOffice> selectAll();

    int updateByPrimaryKey(UserOffice record);
}