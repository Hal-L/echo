package KnowledgePoints.mycollection.math;
/*
Math 类:
    成员变量:
          static double PI  比任何其他值都更接近 pi（即圆的周长与直径之比）的 double 值。
    成员方法:
        public static double abs(double a) ：返回 double 值的绝对值。
        public static double ceil(double a) ：返回大于等于参数的最小的整数  3.3 --> 4.0
        public static double floor(double a) ：返回小于等于参数最大的整数。 3.3 ---> 3.0
        public static long round(double a) ：返回最接近参数的 long。(相当于四舍五入方法)   3.3-->3  3.6-->4
        static double max(double a, double b)  返回两个 double 值中较大的一个。
        static double min(double a, double b)  返回两个 double 值中较小的一个。

 */
public class DemoMath {
    public static void main(String[] args) {
        /*
              练习 :请使用Math 相关的API，计算在 -10.8  到5.9  之间，绝对值大于6  或者小于2.1 的整数有多少个？
              2 1 0 -1 -2  -7 -8 -9 -10
         */
//        0.定义一个变量,用来记录符合条件的整数个数
        int count = 0;

//        1.拿到-10.8到5.9之间的所有整数
        for(double i = Math.ceil(-10.8);i<=5.9;i++){
//           2.拿到整数之后,就去判断该整数的绝对值是否大于6或者小于2.1,如果满足,就计数
            double iAbs = Math.abs(i);// 获取该数的绝对值
            if(iAbs > 6 || iAbs < 2.1){
                System.out.println(i);
                count++;
            }
        }

        System.out.println("总共有"+count+"个数");




    }

    private static void method01() {
        double d5 = 3.4;
        double d6 = 3.7;
        double max = Math.max(d5,d6);
        double min = Math.min(d5,d6);
        System.out.println("最大值是:"+max);//3.7
        System.out.println("最小值是:"+min);//3.4


        // round(double a) ：返回最接近参数的 long。(相当于四舍五入方法)
//        long l = Math.round(3.3);
//        System.out.println(l);//3
//
//        long l2 = Math.round(3.6);
//        System.out.println(l2);//4


        // floor(double a) ：返回小于等于参数最大的整数
//        double d3 = Math.floor(3.3);
//        System.out.println(d3);//3.0


        // ceil(double a); 返回大于等于参数的最小的整数
//        double d2 = Math.ceil(3.3);
//        System.out.println(d2);//4.0

        // abs()方法是取一个数的绝对值
//        double d1 = Math.abs(-3.4);
//        System.out.println(d1);


//        double pi = Math.PI;
//        System.out.println(pi);
    }
}
