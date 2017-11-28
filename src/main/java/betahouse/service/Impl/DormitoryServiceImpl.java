package betahouse.service.Impl;

import betahouse.model.mapper.DormitoryMapper;
import betahouse.model.po.Dormitory;
import betahouse.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormitoryServiceImpl implements DormitoryService {
    @Autowired
    DormitoryMapper dormitoryMapper;
    @Override
    public Integer updateUserDormitory(Dormitory dormitory) {
        return dormitoryMapper.updateByPrimaryKey(dormitory);
    }
}
