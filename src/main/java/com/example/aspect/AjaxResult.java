package com.example.aspect;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GXY
 * @Package com.example.aspect
 * @date 2020/11/10 16:18
 * @Copyright © 2020-2021 新流通
 * @Description: 1.封装统一返回结果类
 * https://www.toutiao.com/i6878184496945070604/
 */
@Data
@NoArgsConstructor
public class AjaxResult {

    //是否成功
    private Boolean success;
    //状态码
    private Integer code;
    //提示信息
    private String msg;
    //数据
    private Object data;

    //自定义返回结果的构造方法
    public AjaxResult(Boolean success,Integer code, String msg,Object data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    //自定义异常返回的结果
    public static AjaxResult defineError(BusinessException de){
        AjaxResult result = new AjaxResult();
        result.setSuccess(false);
        result.setCode(de.getErrorCode());
        result.setMsg(de.getErrorMsg());
        result.setData(null);
        return result;
    }
    //其他异常处理方法返回的结果
    public static AjaxResult otherError(ErrorEnum errorEnum){
        AjaxResult result = new AjaxResult();
        result.setMsg(errorEnum.getErrorMsg());
        result.setCode(errorEnum.getErrorCode());
        result.setSuccess(false);
        result.setData(null);
        return result;
    }
}
