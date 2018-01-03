package betahouse.service.Impl;

import betahouse.model.mapper.Power1Mapper;
import betahouse.model.po.Power1;
import betahouse.service.Power1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Power1ServiceImpl implements Power1Service {
    @Autowired
    Power1Mapper power1Mapper;
    @Override
    public List<Power1> selectByAdminId(Integer adminId) {
        return power1Mapper.selectByAdminId(adminId);
    }

}
