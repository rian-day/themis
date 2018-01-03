package betahouse.service.Impl;

import betahouse.model.mapper.MajorMapper;
import betahouse.model.po.Major;
import betahouse.model.po.Power2;
import betahouse.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MajorServiceImpl implements MajorService {
    @Autowired
    MajorMapper majorMapper;

    @Override
    public Integer updateUserMajor(Major major) {
        return majorMapper.updateByPrimaryKey(major);
    }

    @Override
    public List<Major> selectClassesByPower2(List<Power2> power2List) {
        if(power2List.size()==0){
            return null;
        }
        Integer []arr=new Integer[power2List.size()];
        for(int i=0;i<power2List.size();i++){
            arr[i] = power2List.get(i).getMajorId();
        }
        return majorMapper.selectPrimaryKeyInArr(arr);
    }

    @Override
    public List<Major> selectAll() {
        return majorMapper.selectAll();
    }

    @Override
    public Major selectByMajorId(Integer id) {
        return majorMapper.selectByPrimaryKey(id);
    }
}
