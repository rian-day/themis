package betahouse.core.base;

import betahouse.controller.constant.AdminConstant;
import betahouse.model.po.Admin;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Yxm on 2017/11/2.
 */
public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    public BaseController(){

    }
    protected static String ajaxReturn(HttpServletResponse response, Object data) {
        render(response, JSON.toJSONString(data));
        return null;
    }

    protected static String ajaxReturn(HttpServletResponse response, Object data, int resultCode, String resultMsg) {
        Map<String, Object> jsonData = new HashMap();
        jsonData.put("data", data);
        jsonData.put("resultMsg", resultMsg);
        jsonData.put("resultCode", resultCode);
        render(response, JSON.toJSONString(jsonData));
        return null;
    }

    private static void render(HttpServletResponse response, String text) {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0L);
        PrintWriter pw = null;

        try{
            pw = response.getWriter();
            pw.write(text);
        } catch (IOException var8) {
            var8.printStackTrace();
        } finally {
            pw.close();
        }

    }

    protected static String toJSONString(Object object,String resultMsg,Integer resultCode){
        Map map = new HashMap();
        map.put("data",object);
        map.put("resultMsg", resultMsg);
        map.put("resultCode", resultCode);
        return JSON.toJSONString(map);
    }



    protected HttpSession getHttpSession(HttpServletRequest request) {

        return request.getSession();

    }



    protected Admin getCurrentUser(HttpServletRequest request) {

        Admin adminDTO = (Admin) getHttpSession(request).getAttribute(AdminConstant.SESSION_CURRENT_ADMIN);

        return adminDTO;

    }


}