package betahouse.aspect;

import betahouse.controller.constant.AdminConstant;
import betahouse.model.cod.AdminCod;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Component
@Aspect
public class ClassLeaderAop {
    private final static Logger logger = LoggerFactory.getLogger(ClassLeaderAop.class);

    @Pointcut("execution(* betahouse.controller.ClassLeaderController.*(..))")
    public void classLeaderRoot(){}


    //@Around(value = "classLeaderRoot()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        HttpSession session = request.getSession();
        AdminCod adminCod = (AdminCod) session.getAttribute(AdminConstant.SESSION_CURRENT_ADMIN);
        if(null==adminCod){
            return "未登录";
        }
        if(adminCod.getPower()==-1){
            return "无权限";
        }
        System.out.println("admin`s power"+adminCod.getPower());
        if(null!=adminCod.getClasses()){
            logger.debug("admin`s control classnum: "+adminCod.getClasses().size());
        }
        if(null!=adminCod.getMajors()){
            logger.debug("admin`s control majornum: "+adminCod.getMajors().size());
        }

        // result的值就是被拦截方法的返回值
        Object result=null;
        try {
            result = proceedingJoinPoint.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return result;

    }
}
