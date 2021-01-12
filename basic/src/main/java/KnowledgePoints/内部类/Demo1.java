package KnowledgePoints.内部类;
/*
内部类:
    概述: 类A中包含类B    类A就是外部类    类B就是内部类

    成员内部类 ：定义在类中方法外的类。
        格式:
            public class 外部类名{
                public class 内部类名{

                }
            }

        访问特点:
            - 内部类可以直接访问外部类的成员，包括私有成员。
            - 外部类要访问内部类的成员，必须要建立内部类的对象

        创建内部类对象的格式:
            外部类名.内部类名  对象名 = new 外部类名().new 内部类名();

        内部类仍然是一个独立的类，在编译之后会内部类会被编译成独立的.class文件，但是前面冠以外部类的类名和$符号 。

 */
public class Demo1 {
    public static void main(String[] args) {

        Body.Heart bh = new Body().new Heart();// 创建一个内部类对象
        bh.method();

/*        Body bd = new Body();
        bd.bodyMethod();// 外部类调用自己的方法

        System.out.println("=====================");
        // 调用内部类的heartMethod方法
        Body.Heart bh = new Body().new Heart();// 创建一个内部类对象
        bh.heartMethod();*/
    }
}
