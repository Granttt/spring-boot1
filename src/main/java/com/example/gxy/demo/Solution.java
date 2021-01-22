package com.example.gxy.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author GXY
 * @Package com.example.gxy.demo
 * @date 2020/11/25 12:01
 * @Copyright © 2020-2021 新流通
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {

    }
    public int daysBetweenDates(String smdate, String bdate) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();

        long abs= 0;
        try {
            cal.setTime(sdf.parse(smdate));

            long time1 = cal.getTimeInMillis();

            cal.setTime(sdf.parse(bdate));

            long time2 = cal.getTimeInMillis();

            long between_days = (time2-time1)/(1000*3600*24);
            //求绝对值，这样就不必判断两个时期的大小顺序问题
            abs = Math.abs(between_days);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Integer.parseInt(String.valueOf(abs));

    }
}
