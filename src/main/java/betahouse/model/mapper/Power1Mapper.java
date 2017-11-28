package betahouse.model.mapper;

import betahouse.model.po.Power1;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface Power1Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Power1 record);

    Power1 selectByPrimaryKey(Integer id);
    List<Power1> selectByAdminId(Integer adminId);

    List<Power1> selectAll();

    int updateByPrimaryKey(Power1 record);
}