package betahouse.controller;

import betahouse.controller.constant.InfoConstant;
import betahouse.core.base.BaseController;
import betahouse.model.po.*;
import betahouse.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping(value = {"/update","majorLeader"})
@ResponseBody
public class UpdateController extends BaseController{
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


    @ApiOperation(value = "更新用户Activity")
    @RequestMapping(value = "updateUserActivity")
    public String updateUserActivity(UserActivity userActivity){
        return toJSONString(userActivityService.UpdateUserActivity(userActivity),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
    @ApiOperation(value = "更新用户Clean")
    @RequestMapping(value = "updateUserClean")
    public String updateUserClean(UserClean userClean){
        return toJSONString(userCleanService.updateUserClean(userClean),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
    @ApiOperation(value = "更新用户Honor")
    @RequestMapping(value = "updateUserHonor")
    public String updateUserHonor(UserHonor userHonor){
        return toJSONString(userHonorService.UpdateUserHonor(userHonor),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
    @ApiOperation(value = "更新用户Office")
    @RequestMapping(value = "updateUserOffice")
    public String updateUserOffice(UserOffice userOffice){
        return toJSONString(userOfficeService.UpdateUserOffice(userOffice), InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
    @ApiOperation(value = "更新用户reserve")
    @RequestMapping(value = "updateUserPractice")
    public String updateUserPractice(UserPractice userPractice){
        return toJSONString(userPracticeService.UpdateUserPractice(userPractice),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
    @ApiOperation(value = "更新用户reserve")
    @RequestMapping(value = "updateUserReserve")
    public String updateUserReserve(UserReserve userReserve){
        return toJSONString(userReserveService.UpdateUserReserve(userReserve),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
    @ApiOperation(value = "更新用户reserve")
    @RequestMapping(value = "updateUserSkill")
    public String updateUserSkill(UserSkill userSkill){
        return toJSONString(userSkillService.UpdateUserSkill(userSkill),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
    @ApiOperation(value = "更新用户reserve")
    @RequestMapping(value = "updateUserVolunteer")
    public String updateUserVolunteer(UserVolunteer userVolunteer){
        return toJSONString(userVolunteerService.UpdateUserVolunteer(userVolunteer),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
}
