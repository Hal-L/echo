package KnowledgePoints.date.jdk8date;

import java.time.*;

public class JDK8Date {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 11, 11, 20);
        System.out.println(localDateTime);

        //public LocalDate toLocalDate ()    转换成为一个LocalDate对象
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        //public LocalTime toLocalTime ()    转换成为一个LocalTime对象
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);



        //public int getYear()           获取年
        int year = localDateTime.getYear();
        System.out.println("年为" +year);
        //public int getMonthValue()     获取月份（1-12）
        int month = localDateTime.getMonthValue();
        System.out.println("月份为" + month);

        Month month1 = localDateTime.getMonth();
//        System.out.println(month1);

        //public int getDayOfMonth()     获取月份中的第几天（1-31）
        int day = localDateTime.getDayOfMonth();
        System.out.println("日期为" + day);


        //public int getDayOfYear()      获取一年中的第几天（1-366）
        int dayOfYear = localDateTime.getDayOfYear();
        System.out.println("这是一年中的第" + dayOfYear + "天");


        //public DayOfWeek getDayOfWeek()获取星期
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
        System.out.println("星期为" + dayOfWeek);


        //public int getMinute()        获取分钟
        int minute = localDateTime.getMinute();
        System.out.println("分钟为" + minute);
        //public int getHour()           获取小时

        int hour = localDateTime.getHour();
        System.out.println("小时为" + hour);



    }
}
