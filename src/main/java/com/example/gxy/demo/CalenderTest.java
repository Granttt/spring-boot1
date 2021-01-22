package com.example.gxy.demo;

import java.util.Calendar;

/**
 * @author GXY
 * @Package com.example.gxy.demo
 * @date 2020/11/19 18:33
 * @Copyright © 2020-2021 新流通
 * @Description:JAVA Calender 获取当前月的第一周
 * https://blog.csdn.net/zj420964597/article/details/79856063
 */
public class CalenderTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        int weekYear = calendar.get(Calendar.YEAR);
        String weekId=weekYear + "." + calendar.get(Calendar.WEEK_OF_YEAR);
        String[] weekIdInfo = weekId.split("\\.");
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setFirstDayOfWeek(Calendar.MONDAY);
        calendar2.setWeekDate(Integer.valueOf(weekIdInfo[0]), Integer.valueOf(weekIdInfo[1]), Calendar.MONDAY);

        StringBuilder sb = new StringBuilder();
        sb.append(calendar2.get(Calendar.YEAR)).append("-");
        sb.append(calendar2.get(Calendar.MONTH) + 1).append("-");//月是从0开始
        sb.append(calendar2.get(Calendar.DAY_OF_MONTH));
        System.out.println(sb.toString());
    }
}
