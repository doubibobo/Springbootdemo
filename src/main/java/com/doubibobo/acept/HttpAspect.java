package com.doubibobo.acept;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhuch on 2018/2/2.
 */
@Aspect
@Component
public class HttpAspect {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 拦截相应的请求，如果是拦截所有的请求，则用*替代之
     * .. 表示的是所有的参数，只是拦截，并不阻碍操作，emm
     */
    @Pointcut("execution(public * com.doubibobo.controller.GirlController.*(..))")
    public void log () {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

//        获取url方法
        logger.info("url = {}", request.getRequestURL());

//        获取method
        logger.info("method = {}", request.getMethod());

//        获取IP地址
        logger.info("ip = {}", request.getRemoteAddr());

//        类方法
        logger.info("classMethod = {}", joinPoint.getSignature() + "." + joinPoint.getSignature().getName());

//        获取参数
        logger.info("args = {}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("the after");
    }

    @AfterReturning(returning ="object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("reponse = {}", object);
    }
}
