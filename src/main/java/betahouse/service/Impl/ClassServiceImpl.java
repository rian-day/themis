package betahouse.service.Impl;

import betahouse.model.mapper.ClassMapper;
import betahouse.model.po.Class;
import betahouse.model.po.Power1;
import betahouse.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    ClassMapper classMapper;
    @Override
    public Integer updateUserClass(Class uclass) {
        return classMapper.updateByPrimaryKey(uclass);
    }

    @Override
    public List<Class> selectClassesByPower1(List<Power1> power1List) {
        if(power1List.size()==0){
            return null;
        }
        Integer []arr=new Integer[power1List.size()];
        for(int i=0;i<power1List.size();i++){
            arr[i] = power1List.get(i).getClassId();
        }
        return classMapper.selectPrimaryKeyInArr(arr);
    }

    @Override
    public Class selectClassByClassId(Integer id) {
        return classMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Class> selectAll() {
        return classMapper.selectAll();
    }
}
