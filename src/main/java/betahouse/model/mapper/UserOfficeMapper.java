package betahouse.model.mapper;

import betahouse.model.po.UserOffice;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserOfficeMapper {
    Integer deleteByPrimaryKey(Integer id);

    Integer insert(UserOffice record);
    Integer insertList(List<UserOffice> userOfficeList);

    UserOffice selectByPrimaryKey(Integer id);
    List<UserOffice> selectByUserId(Integer userId);
    List<UserOffice> selectByUserIdAndTerm(Integer userId, Integer term);
    List<UserOffice> selectAll();

    Integer updateByPrimaryKey(UserOffice record);
}