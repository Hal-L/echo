package KnowledgePoints.myStatic.demo7;




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
                // 接口中的抽象方法的默认修饰符: public abstract
                    public abstract void method();
                    public          void method1();
                           abstract void method2();
                                    void method3();

                1.如果实现类是普通类,就必须实现接口中的所有抽象方法
                2.如果实现类是抽象类,就可以不实现接口中的抽象方法

        jdk1.8额外添加了:
            默认方法:需要加default
                格式:
                    public default 返回值类型 方法名(参数列表){

                    }

                1.接口中的默认方法可以供子类对象调用
                2.接口中的默认方法可以供子类重写,但是重写的时候不需要加 default

            静态方法
                public static 返回值类型 方法名(参数列表){

                }

            1.静态方法只能供接口直接使用,实现类不能使用

        jdk1.9额外添加了:
            私有的方法
                private 返回值类型 方法名(参数列表){

                }

                私有方法只能供接口中的默认方法使用

            私有静态方法
                private static 返回值类型 方法名(参数列表){

                }

                私有静态只能供接口中的默认方法\私有方法\静态方法使用


    注意:
        1.接口也是一种引用数据类型
        2.接口编译之后也会有.class文件
        3.接口中不能有构造方法,只能通过其实现类(子类)来创建
 */
public class Demo {
    public static void main(String[] args) {





    }
}
