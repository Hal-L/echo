package KnowledgePoints.myInterface.demo3;


/*
接口:
    1.概述:就是一种公共规范标准
    2.定义接口:
        public interface 接口名{

        }

    3.实现接口:
        1.创建一个类
        2.实现该接口
            public class 类名 implements 接口名{

            }
    4.接口中的成员
        jdk1.7及其以前只能写:
            常量
                默认修饰符: public static final
                1.接口中的常量可以供接口直接使用
                2.接口中的常量可以供子类和子类对象使用
            抽象方法

        jdk1.8额外添加了:
            默认方法
            静态方法

        jdk1.9额外添加了:
            私有的方法
            私有静态方法


    注意:
        1.接口也是一种引用数据类型
        2.接口编译之后也会有.class文件
        3.接口中不能有构造方法,只能通过其实现类(子类)来创建
 */
public class Demo {
    public static void main(String[] args) {
        // 如何声明一个变量? ---> 数据类型 变量名;
        MyImpA miA =new MyImpA();// 定义一个MyImpA接口类型的变量,变量名为miA
        miA.method();//10

        System.out.println(MyInterfacA.num);//10

        System.out.println(miA.num);//10

        MyImpB mib = new MyImpB();// 创建实现类对象

        mib.method();// 使用实现类对象调用抽象方法
          }
}
