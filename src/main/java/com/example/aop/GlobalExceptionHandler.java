package com.example.aop;

import com.example.common.AjaxResult;
import com.example.common.MvcWebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Domg on 2016/11/20.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest request, Exception e) {
        logger.error(request.getRequestURI().toString() + " invoke exception.", e);
        if (MvcWebUtils.isAjax(request)) {
            return new AjaxResult("0", e.getLocalizedMessage(), null);
        } else {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", e.getLocalizedMessage());
            return modelAndView;
        }
    }
}
