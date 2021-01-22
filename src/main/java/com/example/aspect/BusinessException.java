package com.example.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GXY
 * @Package com.example.aspect
 * @date 2020/11/10 16:22
 * @Copyright © 2020-2021 新流通
 * @Description: 2 自定义异常封装类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    /**
     * 错误状态码
     */
    protected Integer errorCode;
    /**
     * 错误提示
     */
    protected String errorMsg;
}
