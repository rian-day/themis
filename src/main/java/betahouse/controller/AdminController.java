package betahouse.controller;

import betahouse.core.base.BaseController;
import betahouse.model.po.Admin;
import betahouse.model.vo.UserVo;
import betahouse.service.AdminService;
import betahouse.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = {"/admin"})
public class AdminController extends BaseController{
    public static Admin cur_admin;
    @Autowired
    UserService userService;
    @Autowired
    AdminService adminService;
    @PostMapping(value = "selectAllUserVoInPage")
    public String selectAllUser(HttpServletRequest request, HttpServletResponse response, Model model,
                                Integer pageNum, Integer pageSize
    ){
        PageInfo<UserVo> pageInfo=userService.selectAllUserVoInPage(pageNum,pageSize);
        return ajaxReturn(response,pageInfo);
    }
    @RequestMapping(value = "/login")
    @ResponseBody
    @CrossOrigin
    public String adminLogin(HttpServletRequest request, HttpServletResponse response, Model model,
                              String email, String password){
        Admin admin=adminService.checkLogin(email, password);
        if(null!=admin){
            //request.getSession().setAttribute(AdminConstant.SESSION_CURRENT_ADMIN, admin);
            //this.getCurrentUser(request)
            /*AdminVo adminVo = new AdminVo();
            adminVo.setPower(admin.getPower());
            adminVo.setEmail(admin.getEmail());*/
            cur_admin=admin;
            Map map1 = new HashMap();
            map1.put("token","betahouse");
            map1.put("uid",admin.getId());
            Map map = new HashMap();
            map.put("resultCode",1);
            map.put("data",map1);
            map.put("resultMsg",null);
            //response.setHeader("Access-Control-Allow-Origin","*");
            return ajaxReturn(response,map);
        }
        return null;
    }
    @RequestMapping(value = "/selectAdminInfo")
    @ResponseBody
    @CrossOrigin

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
            Map map = new HashMap();
            map.put("resultCode",1);
            map.put("data",permissions);
            return ajaxReturn(response, map);
    }
        return "1";
    }
    /*@RequestMapping(value = "/updateUser")
    public Integer updateUser(User user){
        userService.
    }*/
}
