package com.example.gxy.entity;

import lombok.Data;

/**
 * @author GXY
 * @Package com.example.gxy.entity
 * @date 2020/11/8 18:24
 * @Copyright © 2020-2021 新流通
 * @Description:用户实体类
 */
@Data
public class UserVO {

    /**
     * 用户名称
     */
    private String name;
    /**
     * 用户年龄
     */
    private int age;

}
