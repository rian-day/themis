package betahouse.model.mapper;

import betahouse.model.po.Dormitory;
import java.util.List;

public interface DormitoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dormitory record);

    Dormitory selectByPrimaryKey(Integer id);

    List<Dormitory> selectAll();

    int updateByPrimaryKey(Dormitory record);
}