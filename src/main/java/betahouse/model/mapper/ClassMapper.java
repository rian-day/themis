package betahouse.model.mapper;

import betahouse.model.po.Class;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface ClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Class record);

    Class selectByPrimaryKey(Integer id);

    List<Class> selectPrimaryKeyInArr(Integer []arr);

    List<Class> selectAll();

    int updateByPrimaryKey(Class record);
}