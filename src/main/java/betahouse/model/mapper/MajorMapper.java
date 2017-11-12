package betahouse.model.mapper;

import betahouse.model.po.Major;
import java.util.List;

public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    Major selectByPrimaryKey(Integer id);

    List<Major> selectAll();

    int updateByPrimaryKey(Major record);
}