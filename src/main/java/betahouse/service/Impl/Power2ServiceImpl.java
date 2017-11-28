package betahouse.service.Impl;

import betahouse.model.mapper.Power2Mapper;
import betahouse.model.po.Power2;
import betahouse.service.Power2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Power2ServiceImpl implements Power2Service{
    @Autowired
    Power2Mapper power2Mapper;
    @Override
    public List<Power2> selectByAdminId(Integer adminId) {
        return power2Mapper.selectByAdminId(adminId);
    }
}
