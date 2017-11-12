package betahouse.model.mapper;

import betahouse.model.po.Power2;
import java.util.List;

public interface Power2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Power2 record);

    Power2 selectByPrimaryKey(Integer id);

    List<Power2> selectAll();

    int updateByPrimaryKey(Power2 record);
}