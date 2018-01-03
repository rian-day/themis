package betahouse.controller;

import betahouse.controller.constant.InfoConstant;
import betahouse.core.base.BaseController;
import betahouse.model.po.*;
import betahouse.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Component
@CrossOrigin
@Controller
@RequestMapping(value = {"/insert","/majorLeader"})
@ResponseBody
public class InsertController extends BaseController{

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

    @ApiOperation(value = "新增用户Activity")
    @RequestMapping(value = "insertUserActivity")
    public String insertUserActivity(UserActivity userActivity){
        return toJSONString(userActivityService.InsertUserActivity(userActivity),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "新增用户寝室分")
    @RequestMapping(value = "insertUserClean")
    public String insertUserClean(UserClean userClean){
        return toJSONString(userCleanService.insertUserClean(userClean),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "新增用户荣誉分")
    @RequestMapping(value = "insertUserHonor")
    public String insertUserHonor(UserHonor userHonor){
        return toJSONString(userHonorService.InsertUserHonor(userHonor),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "新增用户任职情况")
    @RequestMapping(value = "insertUserOffice")
    public String insertUserOffice(UserOffice userOffice){
        return toJSONString(userOfficeService.InsertUserOffice(userOffice), InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "新增用户Practice情况")
    @RequestMapping(value = "insertUserPractice")
    public String insertUserPractice(UserPractice userPractice){
        return toJSONString(userPracticeService.InsertUserPractice(userPractice),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "新增用户reserve")
    @RequestMapping(value = "insertUserReserve")
    public String insertUserReserve(UserReserve userReserve){
        return toJSONString(userReserveService.InsertUserReserve(userReserve),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "新增用户技能分")
    @RequestMapping(value = "insertUserSkill")
    public String insertUserReserve(UserSkill userSkill){
        return toJSONString(userSkillService.InsertUserSkill(userSkill),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "新增用户志愿情况")
    @RequestMapping(value = "insertUserVolunteer")
    public String insertUserVolunteer(UserVolunteer userVolunteer){
        return toJSONString(userVolunteerService.InsertUserVolunteer(userVolunteer),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
}
