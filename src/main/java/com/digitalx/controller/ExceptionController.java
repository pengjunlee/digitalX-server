package com.digitalx.controller;

import com.digitalx.domain.BaseResponse;
import org.apache.shiro.ShiroException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 * @author pengjunlee
 * @create 2019-09-03 10:49
 */
@RestControllerAdvice

public class ExceptionController {

    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public Object handleShiroException(ShiroException e) {
        BaseResponse<Object> ret = new BaseResponse<Object>();
        ret.setCode(401);
        ret.setMsg(e.getMessage());
        return ret;
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public Object globalException(HttpServletRequest request, Throwable ex) {
        BaseResponse<Object> ret = new BaseResponse<Object>();
        ret.setCode(500);
        ret.setMsg(ex.getMessage());
        return ret;
    }
}
