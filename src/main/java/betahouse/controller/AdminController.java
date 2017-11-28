package betahouse.controller;

import betahouse.controller.constant.AdminConstant;
import betahouse.controller.constant.InfoConstant;
import betahouse.core.base.BaseController;
import betahouse.model.cod.AdminCod;
import betahouse.model.po.Admin;
import betahouse.model.po.Power1;
import betahouse.model.po.Power2;
import betahouse.service.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = {"/admin"})
@CrossOrigin
@ResponseBody
public class AdminController extends BaseController{
    public static Admin cur_admin;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @Autowired
    Power1Service power1Service;
    @Autowired
    Power2Service power2Service;
    @Autowired
    ClassService classService;
    @Autowired
    MajorService majorService;
    /*@PostMapping(value = "selectAllUserVoInPage")
    public String selectAllUser(HttpServletRequest request, HttpServletResponse response, Model model,
                                Integer pageNum, Integer pageSize
    ){
        PageInfo<UserVo> pageInfo=userService.selectAllUserVoInPage(pageNum,pageSize);
        return ajaxReturn(response,pageInfo);
    }*/

    /**
     * 管理员登录
     * @param request
     * @param response
     * @param model
     * @param email
     * @param password
     * @return
     */
    @ApiOperation(value = "管理员登录", notes = "查找管理员所管理的专业或班级并保存到Session，后期通过Aspect去处理用户权限问题")
    @RequestMapping(value = "/login")
    public String adminLogin(HttpServletRequest request, HttpServletResponse response, Model model,
                              String email, String password){
        Admin admin=adminService.checkLogin(email, password);
        if(null!=admin){
            AdminCod adminCod = new AdminCod(admin);
            List<Power1> power1List = power1Service.selectByAdminId(adminCod.getId());
            List<Power2> power2List = power2Service.selectByAdminId(adminCod.getId());
            adminCod.setClasses(classService.selectClassesByPower1(power1List));
            adminCod.setMajors(majorService.selectClassesByPower2(power2List));
            request.getSession().setAttribute(AdminConstant.SESSION_CURRENT_ADMIN, adminCod);
            //this.getCurrentUser(request)
            /*AdminVo adminVo = new AdminVo();
            adminVo.setPower(admin.getPower());
            adminVo.setEmail(admin.getEmail());*/
            cur_admin=admin;
            Map map = new HashMap();
            map.put("token","betahouse");
            map.put("uid",admin.getId());
            //response.setHeader("Access-Control-Allow-Origin","*");
            return toJSONString(map, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
        }
        return "密码错误";
    }

    /**
     *  查找管理员的基本信息
     * @param response
     * @param request
     * @return
     */
    @ApiOperation(value = "查找管理员的基本信息")
    @RequestMapping(value = "/selectAdminInfo")
    public String selectAdminInfo(HttpServletResponse response, HttpServletRequest request){
        //Admin admin = this.getCurrentUser(request);
        Admin admin=cur_admin;
        if(null!=admin){
            Map permissions = new HashMap();
            permissions.put("/index/personalInfo",true);
            permissions.put("/errorpage/401",false);
            permissions.put("/errorpage/404",false);
            permissions.put("/studentsManage/studentAdd",true);
            permissions.put("/studentsManage/studentUpdate",true);
            permissions.put("/studentsManage/studentList",true);
            permissions.put("email",admin.getEmail());
            permissions.put("power",admin.getPower());
            permissions.put("uid",admin.getId());
            permissions.put("token","betahouse");

            return toJSONString(permissions, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
        }
        return toJSONString(null, InfoConstant.FAILED, InfoConstant.FAILED_CODE);
    }
    /*@RequestMapping(value = "/updateUser")
    public Integer updateUser(User user){
        userService.
    }*/
}
