package betahouse.controller;

import betahouse.controller.constant.InfoConstant;
import betahouse.core.base.BaseController;
import betahouse.exception.ExcelException;
import betahouse.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RequestMapping(value = "extra")
@Controller
@ResponseBody
public class ExtraController extends BaseController {
    @Autowired
    ExcelService excelService;

    @RequestMapping(value = "exprotSingleUser")
    public String exprotSingleUser(Integer userId ,HttpServletResponse response){
        excelService.outPutSingleUser(userId,response);
        return toJSONString(null,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @RequestMapping(value = "improtUser")
    public String importUser(@RequestParam(value = "excelFile") MultipartFile excelFile){
        if(null == excelFile){
            return toJSONString("文件为空", InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        String path = "demo";
        //容错处理
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = excelFile.getOriginalFilename();//report.xls
        String fileName2 = excelFile.getName();//excelFile
        try {
            excelService.inPutUser(excelFile.getInputStream());
        }catch (ExcelException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }catch (IOException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        return toJSONString(null,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @RequestMapping(value = "improtUserOffice")
    public String improtUserOffice(@RequestParam(value = "excelFile") MultipartFile excelFile){
        if(null == excelFile){
            return toJSONString("文件为空", InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        String path = "demo";
        //容错处理
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = excelFile.getOriginalFilename();//report.xls
        String fileName2 = excelFile.getName();//excelFile
        try {
            excelService.inPutOffice(excelFile.getInputStream());
        }catch (ExcelException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }catch (IOException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        return toJSONString(null,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @RequestMapping(value = "improtUserActivity")
    public String improtUserActivity(@RequestParam(value = "excelFile") MultipartFile excelFile){
        if(null == excelFile){
            return toJSONString("文件为空", InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        String path = "demo";
        //容错处理
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = excelFile.getOriginalFilename();//report.xls
        String fileName2 = excelFile.getName();//excelFile
        try {
            excelService.inPutActivity(excelFile.getInputStream());
        }catch (ExcelException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }catch (IOException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        return toJSONString(null,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @RequestMapping(value = "improtUserPractice")
    public String improtUserPractice(@RequestParam(value = "excelFile") MultipartFile excelFile){
        if(null == excelFile){
            return toJSONString("文件为空", InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        String path = "demo";
        //容错处理
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = excelFile.getOriginalFilename();//report.xls
        String fileName2 = excelFile.getName();//excelFile
        try {
            excelService.inPutPractice(excelFile.getInputStream());
        }catch (ExcelException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }catch (IOException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        return toJSONString(null,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @RequestMapping(value = "improtUserClean")
    public String improtUserClean(@RequestParam(value = "excelFile") MultipartFile excelFile){
        if(null == excelFile){
            return toJSONString("文件为空", InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        String path = "demo";
        //容错处理
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = excelFile.getOriginalFilename();//report.xls
        String fileName2 = excelFile.getName();//excelFile
        try {
            excelService.inPutUserClean(excelFile.getInputStream());
        }catch (ExcelException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }catch (IOException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        return toJSONString(null,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }

    @RequestMapping(value = "improtUserVolunteer")
    public String improtUserVolunteer(@RequestParam(value = "excelFile") MultipartFile excelFile){
        if(null == excelFile){
            return toJSONString("文件为空", InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        String path = "demo";
        //容错处理
        File dir = new File(path);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = excelFile.getOriginalFilename();//report.xls
        String fileName2 = excelFile.getName();//excelFile
        try {
            excelService.inPutVolunteer(excelFile.getInputStream());
        }catch (ExcelException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }catch (IOException e){
            return toJSONString(e.getMessage(),InfoConstant.FAILED,InfoConstant.FAILED_CODE);
        }
        return toJSONString(null,InfoConstant.SUCCESS,InfoConstant.SUCCESS_CODE);
    }
}
