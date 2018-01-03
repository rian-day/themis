package betahouse.controller;

import betahouse.controller.constant.InfoConstant;
import betahouse.core.base.BaseController;
import betahouse.model.po.UserOffice;
import betahouse.model.vo.UserVo;
import betahouse.service.UserOfficeService;
import betahouse.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping(value = "/majorLeader")
@CrossOrigin
public class MajorLeaderController extends BaseController{
    @Autowired
    UserService userService;

    @Autowired
    UserOfficeService userOfficeService;

    @ApiOperation(value = "更新单个用户信息")
    @RequestMapping(value = "/updateUserInfo")
    public String updateUserInfo(@RequestBody UserVo userVo){
        userService.updateUserInfo(userVo);
        return toJSONString(null, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }

    @ApiOperation(value = "批量更改用户任职信息")
    @RequestMapping(value = "updateUserOfficeInList")
    public String updateUserOfficeInList(
            List<UserOffice> userOfficeList
    ){
        userOfficeService.UpdateUserOfficeInList(userOfficeList);
        return toJSONString(null, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }

    /*@ApiOperation(value = "更新用户任职信息")
    @RequestMapping(value = "updateUserOffice")
    public String updateUserOffice(
            UserOffice userOffice
    ){
        userOfficeService.UpdateUserOffice(userOffice);
        return toJSONString(null, InfoConstant.SUCCESS, InfoConstant.SUCCESS_CODE);
    }*/

}
