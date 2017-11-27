package betahouse.model.mapper;

import betahouse.model.po.Admin;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    Admin selectByUserName(String userName);

    Admin selectByUserEmail(String email);

    int insert(Admin record);

    Admin selectByPrimaryKey(Integer id);

    List<Admin> selectAll();

    int updateByPrimaryKey(Admin record);
}