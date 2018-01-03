package betahouse.controller;

import betahouse.controller.constant.AdminConstant;
import betahouse.controller.constant.InfoConstant;
import betahouse.core.base.BaseController;
import betahouse.model.dto.AdminDto;
import betahouse.model.po.*;
import betahouse.model.vo.UserVo;
import betahouse.service.*;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = {"/classLeader"})
@CrossOrigin
@ResponseBody
public class ClassLeaderController extends BaseController{
    @Autowired
    UserService userService;
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


    /**
     * 分页查找所有用户基本信息
     * @param request
     * @param response
     * @param model
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ApiOperation(value="分页查找所有用户基本信息", notes="")
    @RequestMapping(value = "/selectAllUserInPage")
    public String selectAllUser(HttpServletRequest request, HttpServletResponse response, Model model,
                                Integer pageNum, Integer pageSize
    ){
        PageInfo<UserVo> pageInfo=userService.selectAlluserInPage(pageNum,pageSize);
        return toJSONString(pageInfo, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }
    @ApiOperation(value = "分页查找所有被当前管理员所管理的用户", notes = "从Session获取,管理员只可以查看和操作自己管理的用户")
    @RequestMapping(value = "/selectAllUserControlledInPage")
    public String selectAllUserControlledInPage(
            HttpSession session, Integer pageNum, Integer pageSize
    ){
        AdminDto adminDto = (AdminDto)session.getAttribute(AdminConstant.SESSION_CURRENT_ADMIN);
        if(null!= adminDto.getClasses()){
            PageInfo<UserVo> userVoList = userService.selectAllUserVoByClassInPage(pageNum, pageSize, adminDto.getClasses());
            return toJSONString(userVoList,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
        }
        if(null!= adminDto.getMajors()){
            PageInfo<UserVo> userVoList = userService.selectAllUserVoByMajorInPage(pageNum, pageSize, adminDto.getMajors());
            return toJSONString(userVoList,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
        }
        return toJSONString(null,"无管理班级",InfoConstant.FAILED_CODE);
    }

    /**
     * 通过用户Id查找出用户的基本信息
     * @param request
     * @param response
     * @param model
     * @param userId
     * @return
     */
    @ApiOperation(value = "通过用户Id查找出用户的基本信息")
    @RequestMapping(value = "selectUserByUserId")
    public String selectUserByUserId(HttpServletRequest request, HttpServletResponse response, Model model,
                                 Integer userId
    ){
        User user = userService.selectUserById(userId);
        AdminDto adminDto = getCurrentUser(request);
        if(null!=adminDto.getClasses()){
            List<UserVo> userVoList = userService.selectAllUserVoByClass(adminDto.getClasses());
            for(int i=0;i<userVoList.size();i++){
                if(userVoList.get(i).getId()==userId){
                    return toJSONString(userVoList.get(i),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
                }
            }
        }
        if(null!=adminDto.getMajors()){
            List<UserVo> userVoList = userService.selectAllUserVoByMajor(adminDto.getMajors());
            for(int i=0;i<userVoList.size();i++){
                if(userVoList.get(i).getId()==userId){
                    return toJSONString(userVoList.get(i),InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
                }
            }
        }
        return toJSONString(null, "无此用户或不在管辖权限内", InfoConstant.FAILED_CODE);
    }

    /**
     * 更新用户的政治面貌
     * @param userId
     * @param political
     * @return
     */
    @ApiOperation(value = "更新用户的政治面貌")
    @RequestMapping(value = "updateUserPolitical")
    public Integer updateUserPolitical(Integer userId,String political){
        return userService.updateUserPolitical(userId,political);
    }




    @ApiOperation(value = "新增用户reserve")
    @RequestMapping(value = "insertUserReserve")
    public Integer insertUserReserve(UserReserve userReserve){
        return userReserveService.InsertUserReserve(userReserve);
    }
    @ApiOperation(value = "更新用户reserve")
    @RequestMapping(value = "updateUserReserve")
    public Integer updateUserReserve(UserReserve userReserve){
        return userReserveService.UpdateUserReserve(userReserve);
    }
    @ApiOperation(value = "删除用户reserve", notes = "通过reserveId")
    @RequestMapping(value = "deleteUserReserve")
    public Integer deleteUserReserve(Integer userReserveId){
        return userReserveService.DeleteUserReserveById(userReserveId);
    }

    @ApiOperation(value = "新增用户荣誉分")
    @RequestMapping(value = "insertUserHonor")
    public Integer insertUserHonor(UserHonor userHonor){
        return userHonorService.InsertUserHonor(userHonor);
    }
    @ApiOperation(value = "更新用户Honor")
    @RequestMapping(value = "updateUserHonor")
    public Integer updateUserHonor(UserHonor userHonor){
        return userHonorService.UpdateUserHonor(userHonor);
    }
    @ApiOperation(value = "删除用户Honor", notes = "根据honorId")
    @RequestMapping(value = "deleteUserHonor")
    public Integer deleteUserHonor(Integer userHonorId){
        return userHonorService.DeleteUserHonor(userHonorId);
    }

    @ApiOperation(value = "新增用户技能分")
    @RequestMapping(value = "insertUserSkill")
    public Integer insertUserReserve(UserSkill userSkill){
        return userSkillService.InsertUserSkill(userSkill);
    }
    @ApiOperation(value = "更新用户技能分")
    @RequestMapping(value = "updateUserSkill")
    public Integer updateUserSkill(UserSkill userSkill){
        return userSkillService.UpdateUserSkill(userSkill);
    }
    @ApiOperation(value = "删除用户技能分")
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
    @ApiOperation(value = "查找出用户的所有信息", notes = "根据用户Id")
    @RequestMapping(value = "selectUserVoByUserId")
    public String selectUserVoById(HttpServletResponse response, Integer userId){
        UserVo userVo = userService.selectUserVoById(userId);
        return toJSONString(userVo, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }
}
