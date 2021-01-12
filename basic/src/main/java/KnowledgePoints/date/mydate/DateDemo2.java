package KnowledgePoints.date.mydate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo2 {
    public static void main(String[] args) throws ParseException {
//        public long getTime()			获取时间对象的毫秒值
//        public void setTime(long time)		设置时间，传递毫秒值

        method1();
        method2();

        //        public Date()		创建一个Date对象，表示默认时间
//public Date(long date)	创建一个Date对象，表示指定时间

        //那么这个时间就表示电脑中的当前时间。
        Date date = new Date();
        System.out.println(date);

        //从计算机的时间原点开始，过了指定毫秒的那个时间。
        Date date2 = new Date(0L);
        System.out.println(date2);//Thu Jan 01 08:00:00 CST 1970
        //从时间原点开始，过了0毫秒。
        //因为我们是在中国，我们是在东八区需要+8小时。

        //1970年1月1日 上午的9点
        Date date3 = new Date(3600L * 1000);
        System.out.println(date3);

        String s = "2048-01-01";

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        SimpleDateFormat sdfp = new SimpleDateFormat("yyyy-MM-dd");

        Date datep = sdfp.parse(s);

        System.out.println(date);

        //创建了一个日期格式。
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");    //2021年01月04日 16:41:03
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日"); //2021年01月04日
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  //2021-01-04


        String result1 = sdf.format(date);
        System.out.println(result1);

    }

    private static void method1() {
        Date date1 = new Date();
        System.out.println(date1);
        date1.setTime(1509748743534L);
        System.out.println(date1);
    }

    private static void method2() {
        //把当前时间封装成一个date对象
        Date date1 = new Date();
        //获取这个date对象的毫秒值 --- 获取当前时间的毫秒值
        long time = date1.getTime();
        System.out.println(time);

        long time2 = System.currentTimeMillis();
        System.out.println(time2);
    }
}
