package betahouse.controller;

import betahouse.controller.constant.AdminConstant;
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

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = {"/select","/classLeader"})
@ResponseBody
public class SelectController extends BaseController{

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

    @ApiOperation(value = "查找用户活动记录Activity")
    @RequestMapping(value = "selectUserActivityByUserIdAndTerm")
    public String selectUserActivityByUserIdAndTerm(
            Integer userId, Integer term
    ){
        List<UserActivity> userActivityList = userActivityService.SelectUserActivityByUserIdAndTerm(userId, term);
        return toJSONString(userActivityList, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "查找用户卫生情况Clean", notes = "根据用户Id和学期")
    @RequestMapping(value = "selectUserCleanByUserIdAndTerm")
    public String selectUserCleanByUserIdAndTerm(
            Integer userId, Integer term
    ){
        List<UserClean> userCleanList = userCleanService.SelectUserCleanByUserIdAndTerm(userId, term);
        return toJSONString(userCleanList, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "查找用户Honor", notes = "根据用户Id和学期")
    @RequestMapping(value = "selectUserHonorByUserIdAndTerm")
    public String selectUserHonorByUserId(
            Integer userId, Integer term
    ){
        List<UserHonor> userHonors = userHonorService.SelectUserHonorByUserIdAndTerm(userId,term);
        return toJSONString(userHonors, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }

    /**
     * 根据用户Id和学期查找用户任职记录
     * @param userId
     * @param term
     * @return
     */
    @ApiOperation(value = "根据用户Id和学期查找用户任职记录")
    @RequestMapping(value = "selectUserOfficeByUserIdAndTerm")
    public String selectUserOfficeByUserIdAndTerm(
            Integer userId, Integer term
    ){
        List<UserOffice> userOfficeList=userOfficeService.SelectUserOfficeByUserIdAndTerm(userId,term);
        return toJSONString(userOfficeList, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "查找用户Practice")
    @RequestMapping(value = "selectUserPracticeByUserIdAndTerm")
    public String selectUserPracticeByUserIdAndTerm(
            Integer userId, Integer term
    ){
        List<UserPractice> userPracticeList=userPracticeService.SelectUserPracticeByUserIdAndTerm(userId,term);
        return toJSONString(userPracticeList, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }

    /**
     * 查找对应用户的额外加分按学期
     * @param response
     * @param session
     * @param userId
     * @param term
     * @return
     */
    @ApiOperation(value = "查找对应用户的额外加分按学期")
    @RequestMapping(value = "selectUserReserveByUserIdAndTerm")
    public String selectUserReserveByUserIdAndTerm(HttpServletResponse response, HttpSession session,
                                                   Integer userId, Integer term){
        Admin admin = (Admin)session.getAttribute(AdminConstant.SESSION_CURRENT_ADMIN);
        List<UserReserve> userReserves = userReserveService.SelectUserReserveByUserIdAndTerm(userId, term);
        return toJSONString(userReserves, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }


    /**
     * 用户技能分管理
     * @param response
     * @param userId
     * @return
     */
    @ApiOperation(value = "查找用户技能分", notes = "根据用户Id和学期")
    @RequestMapping(value = "selectUserSkillByUserIdAndTerm")
    public String selectUserSkillByUserId(HttpServletResponse response,
                                          Integer userId, Integer term){
        List<UserSkill> userSkills = userSkillService.SelectUserSkillByUserIdAndTerm(userId, term);
        return toJSONString(userSkills, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "查找用户志愿活动Volunteer")
    @RequestMapping(value = "selectUserVolunteerByUserIdAndTerm")
    public String selectUserVolunteerByUserIdAndTerm(
            Integer userId, Integer term
    ){
        List<UserVolunteer> userVolunteerList=userVolunteerService.SelectUserVolunteerByUserIdAndTerm(userId,term);
        return toJSONString(userVolunteerList, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }
}
