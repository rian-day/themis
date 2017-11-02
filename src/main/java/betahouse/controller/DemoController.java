package betahouse.controller;

import betahouse.core.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Yxm on 2017/11/2.
 */
@Controller
public class DemoController extends BaseController{
    @RequestMapping(value = {"", "/", "/index", "view"})
    public String view(HttpServletRequest request, HttpServletResponse response, Model model){
        model.addAttribute("str","hello world");
        return "demo";
    }
    @RequestMapping(value = {"ajax"})
    public String ajax(HttpServletRequest request, HttpServletResponse response, Model model){
        return ajaxReturn(response,"this is ajaxReturn");
    }
}
