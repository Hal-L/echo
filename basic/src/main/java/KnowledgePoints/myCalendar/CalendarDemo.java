package Day04ImgThrowable.myCalendar;

import java.util.Calendar;
import java.util.Scanner;
/*
    Calendar 为特定瞬间与一组日历字段之间的转换提供了一些方法，并为操作日历字段提供了一些方法

    Calendar 提供了一个类方法 getInstance 用于获取这种类型的一般有用的对象，该方法返回一个 Calendar 对象，
    其日历字段已使用当前日期和时间初始化：Calendar rightNow = Calendar.getInstance();
 */

/*
    public abstract void add​(int field, int amount):根据日历的规则，将指定的时间量添加或减去给定的日历字段
    public final void set​(int year,int month,int date):设置当前日历的年月日
 */
public class CalendarDemo {
    public static void main(String[] args) {
        //日历字段已使用当前日期和时间初始化
        //获取日历类对象
        Calendar c = Calendar.getInstance();

        //public int get​(int field):返回给定日历字段的值
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + date + "日");

        //public abstract void add​(int field, int amount):根据日历的规则，将指定的时间量添加或减去给定的日历字段
        //需求1:3年前的今天
//        c.add(Calendar.YEAR,-3);
//        year = c.get(Calendar.YEAR);
//        month = c.get(Calendar.MONTH) + 1;
//        date = c.get(Calendar.DATE);
//        System.out.println(year + "年" + month + "月" + date + "日");

        //需求2:10年后的10天前
//        c.add(Calendar.YEAR,10);
//        c.add(Calendar.DATE,-10);
//        year = c.get(Calendar.YEAR);
//        month = c.get(Calendar.MONTH) + 1;
//        date = c.get(Calendar.DATE);
//        System.out.println(year + "年" + month + "月" + date + "日");

        //public final void set​(int year,int month,int date):设置当前日历的年月日
        c.set(2050, 10, 10);
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH) + 1;
        date = c.get(Calendar.DATE);
        System.out.println(year + "年" + month + "月" + date + "日");


        extracted();
    }
    
    /*
    需求：
        获取任意一年的二月有多少天

    思路：
        1:键盘录入任意的年份
        2:设置日历对象的年、月、日
            年：来自于键盘录入
            月：设置为3月，月份是从0开始的，所以设置的值是2
            日：设置为1日
        3:3月1日往前推一天，就是2月的最后一天
        4:获取这一天输出即可
 */

    private static void extracted() {
        //键盘录入任意的年份
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = sc.nextInt();

        //设置日历对象的年、月、日
        Calendar c = Calendar.getInstance();
        c.set(year, 2, 1);

        //3月1日往前推一天，就是2月的最后一天
        c.add(Calendar.DATE, -1);

        //获取这一天输出即可
        int date = c.get(Calendar.DATE);
        System.out.println(year + "年的2月份有" + date + "天");
    }
}
