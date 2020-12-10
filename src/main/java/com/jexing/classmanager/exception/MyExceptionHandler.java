package com.jexing.classmanager.exception;

import com.jexing.classmanager.entity.Msg;
import org.apache.shiro.authz.AuthorizationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class MyExceptionHandler {
    /**
     * 处理权限异常问题
     * @param ex
     * @return
     */
    @ExceptionHandler(AuthorizationException.class)
    @ResponseBody
    public String authorizationException(Exception ex) {
        return "<h1>您还没有权限!!</h1>";
    }
}
