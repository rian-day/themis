package betahouse.controller;

import betahouse.core.base.BaseController;
import betahouse.model.po.UserReserve;
import betahouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.HandshakeResponse;

/**
 * Created by Yxm on 2017/11/2.
 */
@Controller
public class DemoController extends BaseController{
    @Autowired
    public UserService userService;
    @RequestMapping(value = {"", "/", "/index", "view"})
    public String view(HttpServletRequest request, HttpServletResponse response, Model model){
        model.addAttribute("userVo",userService.SelectUserVoById(1));
        return "demo";
    }
    @RequestMapping(value = {"ajax"})
    public String ajax(HttpServletRequest request, HttpServletResponse response, Model model){
        userService.SelectUserVoById(1);
        return ajaxReturn(response,userService.SelectUserVoById(1));
    }
    @PostMapping(value = {"updateReserve"})
    public String test(HttpServletRequest request , HandshakeResponse response, UserReserve userReserve){
        return "";
    }
}
