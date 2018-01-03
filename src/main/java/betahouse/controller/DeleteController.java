package betahouse.controller;

import betahouse.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping(value = {"/delete","majorLeader"})
@ResponseBody
public class DeleteController {

    @Autowired
    UserReserveService userReserveService;
    @Autowired
    UserHonorService userHonorService;
    @Autowired
    UserSkillService userSkillService;
    @Autowired
    UserOfficeService userOfficeService;
    @Autowired
    UserActivityService userActivityService;
    @Autowired
    UserCleanService userCleanService;
    @Autowired
    UserPracticeService userPracticeService;
    @Autowired
    UserVolunteerService userVolunteerService;

    @ApiOperation(value = "删除用户Activity", notes = "通过reserveId")
    @RequestMapping(value = "deleteUserActivity")
    public Integer deleteUserActivity(Integer userActivityId){
        return userActivityService.DeleteUserActivity(userActivityId);
    }

    @ApiOperation(value = "删除用户reserve", notes = "通过reserveId")
    @RequestMapping(value = "deleteUserReserve")
    public Integer deleteUserReserve(Integer userReserveId){
        return userReserveService.DeleteUserReserveById(userReserveId);
    }

    @ApiOperation(value = "删除用户Honor", notes = "根据honorId")
    @RequestMapping(value = "deleteUserHonor")
    public Integer deleteUserHonor(Integer userHonorId){
        return userHonorService.DeleteUserHonor(userHonorId);
    }

    @ApiOperation(value = "删除用户技能分")
    @RequestMapping(value = "deleteUserSkill")
    public Integer deleteUserSkill(Integer userSkillId){
        return userSkillService.DeleteUserSkill(userSkillId);
    }

    @ApiOperation(value = "删除用户Clean", notes = "通过reserveId")
    @RequestMapping(value = "deleteUserClean")
    public Integer deleteUserClean(Integer userCleanId){
        return userCleanService.deleteUserClean(userCleanId);
    }

    @ApiOperation(value = "删除用户Office", notes = "通过reserveId")
    @RequestMapping(value = "deleteUserOffice")
    public Integer deleteUserOffice(Integer userOfficeId){
        return userOfficeService.DeleteUserOffice(userOfficeId);
    }

    @ApiOperation(value = "删除用户Practice", notes = "通过reserveId")
    @RequestMapping(value = "deleteUserPractice")
    public Integer deleteUserPractice(Integer userPracticeId){
        return userPracticeService.DeleteUserPractice(userPracticeId);
    }

    @ApiOperation(value = "删除用户Volunteer", notes = "通过reserveId")
    @RequestMapping(value = "deleteUserVolunteer")
    public Integer deleteUserVolunteer(Integer userVolunteerId){
        return userVolunteerService.DeleteUserVolunteer(userVolunteerId);
    }
}
