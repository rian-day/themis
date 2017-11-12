package betahouse.model.mapper;

import betahouse.model.po.Class;
import java.util.List;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    Class selectByPrimaryKey(Integer id);

    List<Class> selectAll();

    int updateByPrimaryKey(Class record);
}