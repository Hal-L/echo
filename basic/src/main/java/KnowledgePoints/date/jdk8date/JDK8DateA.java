package KnowledgePoints.date.jdk8date;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * JDK8 时间类添加或者减去时间的方法
 */
public class JDK8DateA {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
        //public LocalDateTime minusYears (long years)  减去或者添加年
        //LocalDateTime newLocalDateTime = localDateTime.minusYears(1);
        //System.out.println(newLocalDateTime);

        LocalDateTime newLocalDateTime = localDateTime.minusYears(-1);
        System.out.println(newLocalDateTime);


        //public LocalDateTime plusYears (long years)   添加或者减去年

        LocalDateTime newLocalDateTime1 = localDateTime.plusYears(1);
        System.out.println(newLocalDateTime1);

        LocalDateTime newLocalDateTime2 = localDateTime.plusYears(-1);
        System.out.println(newLocalDateTime2);


        //public LocalDateTime withYear(int year)   修改年
         LocalDateTime newLocalDateTime6 = localDateTime.withYear(2048);
         System.out.println("年"+newLocalDateTime6);

        LocalDateTime newLocalDateTime5 = localDateTime.withMonth(12);
        System.out.println("月"+newLocalDateTime5);


        //public static Period between(开始时间,结束时间)  计算两个"时间"的间隔

        LocalDate localDate1 = LocalDate.of(2020, 1, 1);
        LocalDate localDate2 = LocalDate.of(2048, 12, 12);
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);//P28Y11M11D

        //public int getYears()         获得这段时间的年数
        System.out.println(period.getYears());//28
        //public int getMonths()        获得此期间的月数
        System.out.println(period.getMonths());//11
        //public int getDays()          获得此期间的天数
        System.out.println(period.getDays());//11

        //public long toTotalMonths()   获取此期间的总月数
        System.out.println(period.toTotalMonths());//347



        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 1, 2, 11, 12, 13);
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 1, 1, 13, 14, 15);
        //public static Duration between(开始时间,结束时间)  计算两个“时间"的间隔

        Duration duration = Duration.between(localDateTime1, localDateTime2);
        System.out.println(duration);//PT21H57M58S
        //public long toSeconds()	       获得此时间间隔的秒
        //System.out.println(duration.toSeconds());//79078
        //public int toMillis()	           获得此时间间隔的毫秒
        System.out.println(duration.toMillis());//79078000
        //public int toNanos()             获得此时间间隔的纳秒
        System.out.println(duration.toNanos());//79078000000000
    }
}
