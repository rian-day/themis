package betahouse.aspect;

import betahouse.controller.constant.AdminConstant;
import betahouse.controller.constant.InfoConstant;
import betahouse.core.base.BaseController;
import betahouse.model.dto.AdminDto;
import org.aspectj.lang.ProceedingJoinPoint;
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
public class MajorLeaderAop extends BaseController{
    private final static Logger logger = LoggerFactory.getLogger(MajorLeaderAop.class);

    @Pointcut("execution(* betahouse.controller.MajorLeaderController.*(..))")
    public void majorLeaderRoot(){}

    //@Around(value = "majorLeaderRoot()")
    public Object checkPower(ProceedingJoinPoint proceedingJoinPoint){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        HttpSession session = request.getSession();
        AdminDto adminDto = (AdminDto) session.getAttribute(AdminConstant.SESSION_CURRENT_ADMIN);
        if(null== adminDto){
            return toJSONString(null,"未登录",InfoConstant.FAILED_CODE);
        }
        Integer power = adminDto.getPower();
        if(power==-1||power==1){
            return toJSONString(null,"无权限", InfoConstant.FAILED_CODE);
        }
        logger.info("admin`s power"+power);
        if(null!= adminDto.getClasses()){
            logger.debug("admin`s control classnum: "+ adminDto.getClasses().size());
        }
        if(null!= adminDto.getMajors()){
            logger.debug("admin`s control majornum: "+ adminDto.getMajors().size());
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
