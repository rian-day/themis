package betahouse.model.mapper;

import betahouse.model.po.Dormitory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DormitoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dormitory record);

    Dormitory selectByPrimaryKey(Integer id);
    Dormitory selectByBuildingAndFloorAndRoom(Integer building,Integer floor,Integer room);

    List<Dormitory> selectAll();

    int updateByPrimaryKey(Dormitory record);
}