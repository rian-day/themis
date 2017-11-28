package betahouse.aspect;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;

@Component
@Aspect
public class WebControllerAop {

    private final static Logger logger = LoggerFactory.getLogger(ClassLeaderAop.class);

    //匹配com.zkn.learnspringboot.web.controller包及其子包下的所有类的所有方法
    @Pointcut("execution(* betahouse.controller..*.*(..))")
    public void executeService(){}

    @Pointcut("execution(* betahouse.controller.ClassLeaderController.*(..))")
    public void classLeaderRoot(){}


    @Before("executeService()")
    public void doBeforeAdvice(JoinPoint joinPoint){
        logger.debug("前置通知!!!");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        //AOP代理类的信息
        joinPoint.getThis();
        //代理的目标对象
        joinPoint.getTarget();
        //用的最多 通知的签名
        Signature signature = joinPoint.getSignature();
        //代理的是哪一个方法
        logger.debug("代理方法名:"+signature.getName());
        //AOP代理类的名字
        logger.debug("代理类名:"+signature.getDeclaringTypeName());
        //AOP代理类的类（class）信息
        signature.getDeclaringType();
        //获取RequestAttributes
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        //从获取RequestAttributes中获取HttpServletRequest的信息
        HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
        //如果要获取Session信息的话，可以这样写：
        //HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        Enumeration<String> enumeration = request.getParameterNames();
        Map<String,String> parameterMap = Maps.newHashMap();
        while (enumeration.hasMoreElements()){
            String parameter = enumeration.nextElement();
            parameterMap.put(parameter,request.getParameter(parameter));
        }
        String str = JSON.toJSONString(parameterMap);
        if(obj.length > 0) {
            logger.debug("请求的参数信息为："+str);
        }
    }

    /**
      * 后置返回通知
      * 这里需要注意的是:
      * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
      * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
      * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
      * @param joinPoint
      * @param keys
      */
    @AfterReturning(value = "executeService()",returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint,Object keys){

        logger.debug("第一个后置返回通知的返回值："+keys);
    }

    @AfterReturning(value = "executeService()",returning = "keys",argNames = "keys")
    public void doAfterReturningAdvice2(String keys){

        logger.debug("第二个后置返回通知的返回值："+keys);
    }

    /**
      * 后置异常通知
      * 定义一个名字，该名字用于匹配通知实现方法的一个参数名，当目标方法抛出异常返回后，将把目标方法抛出的异常传给通知方法；
      * throwing 限定了只有目标方法抛出的异常与通知方法相应参数异常类型时才能执行后置异常通知，否则不执行，
      * 对于throwing对应的通知方法参数为Throwable类型将匹配任何异常。
      * @param joinPoint
      * @param exception
      */
    @AfterThrowing(value = "executeService()",throwing = "exception")
    public void doAfterThrowingAdvice(JoinPoint joinPoint,Throwable exception){
        //目标方法名：
        logger.error(joinPoint.getSignature().getName());
        if(exception instanceof NullPointerException){
            logger.error("发生了空指针异常!!!!!");
        }
    }
    @Around(value = "executeService()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint){
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.info("请求开始, 各个参数, url: {}, method: {}, uri: {}, params: {}");

        logger.info(" url: "+url);
        logger.info("method: "+method);
        logger.info("uri: "+uri);
        logger.info("queryString: "+queryString);

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
