package com.example.gxy.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author GXY
 * @Package com.example.gxy.demo
 * @date 2020/12/31 18:01
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class GenericExtends {

    static void copy(List<? super Father> dest, List<? extends Father> src){
        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    public static void main(String[] args) {
        Father father = new Father();
        Son son = new Son();
        List<Son> srcFatherList = new ArrayList<Son>();
//        List<Father> srcFatherList = new ArrayList<Father>();
        srcFatherList.add(son);
        List<Father> destFatherList = new ArrayList<Father>();

        copy(destFatherList,srcFatherList);
        System.out.println(destFatherList.size());
    }
}
class Father{}
class Son extends Father{}
