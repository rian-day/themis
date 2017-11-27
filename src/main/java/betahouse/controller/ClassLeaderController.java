package betahouse.controller;

import betahouse.core.base.BaseController;
import betahouse.model.po.*;
import betahouse.model.vo.UserVo;
import betahouse.service.UserHonorService;
import betahouse.service.UserReserveService;
import betahouse.service.UserService;
import betahouse.service.UserSkillService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/classLeader"})
@CrossOrigin
public class ClassLeaderController extends BaseController{
    @Autowired
    UserService userService;
    @Autowired
    UserReserveService userReserveService;
    @Autowired
    UserHonorService userHonorService;
    @Autowired
    UserSkillService userSkillService;
    /**
     * 分页查找所有用户基本信息
     * @param request
     * @param response
     * @param model
     * @param currentPage
     * @param pageSize
     * @return
     */
    @ApiOperation(value="获取用户列表", notes="")
    @RequestMapping(value = "/selectAllUserInPage")
    public String selectAllUser(HttpServletRequest request, HttpServletResponse response, Model model,
                                Integer currentPage, Integer pageSize
    ){
        PageInfo<UserVo> pageInfo=userService.selectAlluserInPage(currentPage,pageSize);
        return ajaxReturn(response,pageInfo,1,null);
    }

    /**
     * 通过用户Id查找出用户的基本信息
     * @param request
     * @param response
     * @param model
     * @param userId
     * @return
     */
    @RequestMapping(value = "selectUserByUserId")
    public String selectUserByUserId(HttpServletRequest request, HttpServletResponse response, Model model,
                                 Integer userId
    ){
        User user = userService.selectUserById(userId);
        return ajaxReturn(response, user,1,null);
    }

    /**
     * 更新用户的政治面貌
     * @param userId
     * @param political
     * @return
     */
    @RequestMapping(value = "updateUserPolitical")
    @ResponseBody
    public Integer updateUserPolitical(Integer userId,String political){
        return userService.updateUserPolitical(userId,political);
    }

    /**
     * 查找对应用户的额外加分按学期
     * @param response
     * @param userId
     * @return
     */
    @RequestMapping(value = "selectUserReserveByUserId")
    public String selectUserReserveByUserId(HttpServletResponse response, HttpSession session,
                                            Integer userId, Integer term){
        Admin admin = (Admin)session.getAttribute(AdminConstant.SESSION_CURRENT_ADMIN);
        if(null==admin){
            return null;
        }
        if(admin.getPower()==0){
            return null;
        }
        if(term==000000){
            List<UserReserve> userReserves = userReserveService.SelectUserReserveByUserId(userId);
            return ajaxReturn(response, userReserves);
        }
        List<UserReserve> userReserves = userReserveService.SelectUserReserveByUserIdAndTerm(userId, term);
        return ajaxReturn(response, userReserves,1,null);
    }
    @RequestMapping(value = "insertUserReserve")
    public Integer insertUserReserve(UserReserve userReserve){
        return userReserveService.InsertUserReserve(userReserve);
    }
    @RequestMapping(value = "updateUserReserve")
    public Integer updateUserReserve(UserReserve userReserve){
        return userReserveService.UpdateUserReserve(userReserve);
    }
    @RequestMapping(value = "deleteUserReserve")
    public Integer deleteUserReserve(Integer userReserveId){
        return userReserveService.DeleteUserReserveById(userReserveId);
    }

    /**
     * 对用户荣誉的操作
     * @param response
     * @param userId
     * @return
     */
    @RequestMapping(value = "selectUserHonorByUserId")
    public String selectUserHonorByUserId(HttpServletResponse response,
                                          Integer userId, Integer term){
        if(term==000000){
            List<UserHonor> userHonors = userHonorService.SelectUserHonorByUserId(userId);
            return ajaxReturn(response, userHonors);
        }
        List<UserHonor> userHonors = userHonorService.SelectUserHonorByUserIdAndTerm(userId,term);
        return ajaxReturn(response, userHonors);
    }
    @RequestMapping(value = "insertUserHonor")
    public Integer insertUserHonor(UserHonor userHonor){
        return userHonorService.InsertUserHonor(userHonor);
    }
    @RequestMapping(value = "updateUserHonor")
    public Integer updateUserHonor(UserHonor userHonor){
        return userHonorService.UpdateUserHonor(userHonor);
    }
    @RequestMapping(value = "deleteUserHonor")
    public Integer deleteUserHonor(Integer userHonorId){
        return userHonorService.DeleteUserHonor(userHonorId);
    }

    /**
     * 用户技能分管理
     * @param response
     * @param userId
     * @return
     */
    @RequestMapping(value = "selectUserSkillByUserId")
    public String selectUserSkillByUserId(HttpServletResponse response,
                                          Integer userId, Integer term){
        if(term==000000){
            List<UserSkill> userSkills = userSkillService.SelectUserSkillByUserId(userId);
            return ajaxReturn(response, userSkills);
        }
        List<UserSkill> userSkills = userSkillService.SelectUserSkillByUserIdAndTerm(userId, term);
        return ajaxReturn(response, userSkills);
    }
    @RequestMapping(value = "insertUserSkill")
    public Integer insertUserSkill(UserSkill userSkill){
        return userSkillService.InsertUserSkill(userSkill);
    }
    @RequestMapping(value = "updateUserSkill")
    public Integer updateUserSkill(UserSkill userSkill){
        return userSkillService.UpdateUserSkill(userSkill);
    }
    @RequestMapping(value = "deleteUserSkill")
    public Integer deleteUserSkill(Integer userSkillId){
        return userSkillService.DeleteUserSkill(userSkillId);
    }

    /**
     * 通过用户Id查出所有用户信息
     * @param response
     * @param userId
     * @return
     */
    @RequestMapping(value = "selectUserVoByUserId")
    public String selectUserVoById(HttpServletResponse response, Integer userId){
        UserVo userVo = userService.selectUserVoById(userId);
        return ajaxReturn(response, userVo);
    }
}
