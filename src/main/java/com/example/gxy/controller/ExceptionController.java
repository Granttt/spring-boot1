package com.example.gxy.controller;

import com.example.aspect.BusinessException;
import com.example.aspect.ErrorEnum;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GXY
 * @Package com.example.gxy.controller
 * @date 2020/11/10 17:19
 * @Copyright © 2020-2021 新流通
 * @Description: 统一异常处理测试类
 */
@RestController
@RequestMapping("/test")
public class ExceptionController {

    @RequestMapping("/query")
    public Object query(){
        throw new BusinessException(ErrorEnum.NO_PERMISSION.getErrorCode(),ErrorEnum.NO_PERMISSION.getErrorMsg());
    }
    @RequestMapping("/query1")
    public Object query1(Integer num){
        return num + 1;
    }

}
