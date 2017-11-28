package betahouse.model.mapper;

import betahouse.model.po.Major;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MajorMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Major record);

    Major selectByPrimaryKey(Integer id);
    List<Major> selectPrimaryKeyInArr(Integer []arr);

    List<Major> selectAll();

    int updateByPrimaryKey(Major record);
}