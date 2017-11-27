package betahouse.model.mapper;

import betahouse.model.po.Dormitory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DormitoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dormitory record);

    Dormitory selectByPrimaryKey(Integer id);

    List<Dormitory> selectAll();

    int updateByPrimaryKey(Dormitory record);
}