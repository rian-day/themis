package betahouse.controller;

import betahouse.core.base.BaseController;
import betahouse.model.po.UserReserve;
import betahouse.model.vo.UserVo;
import betahouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.HandshakeResponse;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Yxm on 2017/11/2.
 */
@Controller
public class DemoController extends BaseController{
    @Autowired
    public UserService userService;
    @RequestMapping(value = {"index"})
    public String ajax(HttpServletRequest request, HttpServletResponse response, Model model){
        return "elements";
    }
    //TODO 对传过来的SchoolId进行base64解密
    @RequestMapping(value = {"demo"})
    public String index(HttpServletRequest request, HttpServletResponse response, Model model,
                        @RequestParam("SchoolId")Integer SchoolId){
        //deCode(SchoolId)
        UserVo userVo = userService.SelectUserVoBySchoolId(SchoolId);
        model.addAttribute("userVo",userVo);
        //model.addAttribute("enCode",enCode_base64(SchoolId));
        //
//        return "elements";
        return ajaxReturn(response,userVo,null, 0);
    }
    //TODO 对传过来的SchoolId进行base64解密
    @RequestMapping(value = {"getInfo"}, method = POST)
    public String getInfo(HttpServletRequest request, HttpServletResponse response, Model model,
                        @RequestParam("SchoolId")Integer SchoolId){
        //deCode(SchoolId)
        UserVo userVo = userService.SelectUserVoBySchoolId(SchoolId);
        model.addAttribute("userVo",userVo);
        //model.addAttribute("enCode",enCode_base64(SchoolId));
        //
//        return "elements";
        return ajaxReturn(response,userVo,"成功拿到", 0);
    }
    @PostMapping(value = {"updateReserve"})
    public String test(HttpServletRequest request , HandshakeResponse response, UserReserve userReserve){
        return "";
    }
}
