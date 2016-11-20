package com.example.aop;

import com.example.common.AjaxResult;
import com.example.common.MvcWebUtils;
import com.example.domain.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

/**
 * Created by Domg on 2016/11/20.
 */
@Aspect
@Component
public class WebAspect {

    private static final Logger logger = LoggerFactory.getLogger(WebAspect.class);

    @Pointcut(value = "execution(public * com.example.web..*.*(..))")
    public void webAccessPoint() {
    }

    @Around("webAccessPoint()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MDC.put("logId", UUID.randomUUID().toString());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object ret = null;
        logger.info("url:{},method:{},parameter:{} invoke.",
                new Object[]{
                        request.getRequestURI().toString(),
                        request.getMethod(),
                        Arrays.toString(proceedingJoinPoint.getArgs())
                });
        Long start = System.currentTimeMillis();
        ret = proceedingJoinPoint.proceed();
        logger.info("url:{},method:{},invoke done. Times:{}",
                new Object[]{
                        request.getRequestURI().toString(),
                        request.getMethod(),
                        System.currentTimeMillis() - start
                });
        return ret;
    }


}


