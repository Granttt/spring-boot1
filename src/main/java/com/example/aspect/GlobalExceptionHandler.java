package com.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author GXY
 * @Package com.example.aspect
 * @date 2020/11/10 17:03
 * @Copyright © 2020-2021 新流通
 * @Description: 4 全局异常处理类
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     * @param e
     * @return AjaxResult
     */
    @ExceptionHandler(value = BusinessException.class)
    public AjaxResult bizExceptionHandler(BusinessException e){
        log.info("我启动了...");
        log.error(e.getMessage(),e);
        return AjaxResult.defineError(e);
    }

    /**
     * 处理其他异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public AjaxResult exceptionHandler(Exception e){
        log.error(e.getMessage(),e);
        return AjaxResult.otherError(ErrorEnum.INTERNAL_SERVER_ERROR);
    }
}
