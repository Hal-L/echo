package KnowledgePoints.myInterface.demo10;

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

    接口和类之间的关系:实现关系
            单实现:一个类实现一个接口
            多实现:一个类实现多个接口
             格式:
                public class 类名 implements 接口1,接口2,...{

                }

             1.多个接口中没有重名的抽象方法,实现类需要全部实现所有抽象方法
             2.多个接口中有重名的抽象方法,实现类只需要实现一个抽象方法

             3.多个接口中没有重名的默认方法,实现类就正常使用,不需要重写默认方法
             4.多个接口中有重名的默认方法,实现类必须重写重名的默认方法

             5.静态方法只能供接口直接使用,跟实现类无关,正常使用
             6.私有方法只能供接口的默认方法\私有方法\静态方法使用,跟实现类也无关,正常使用

    接口和接口之间的关系: 继承关系
        单继承:一个接口继承一个接口
        多继承:一个接口同时继承多个接口
        多层继承:一个接口继承另一个接口,而另一个接口又继承另一个接口

            单继承:
                public interface 接口A extends 接口B{

                }

                接口A: 子接口
                接口B:  父接口

           多继承:
                public interface 接口A extends 接口B,接口C,...{

                }
                接口A: 子接口
                接口B\C\...:  父接口

          多层继承:


       类可以继承一个类也可以实现一个接口
            当一个类，既继承一个父类，又实现若干个接口时，
            父类中的成员方法与接口中的默认方法重名，子类就近选择执行父类的成员方法


            格式:
                public class 类名 extends 父类  implements 接口1,接口2,...{

                }

    注意:
        1.接口也是一种引用数据类型
        2.接口编译之后也会有.class文件
        3.接口中不能有构造方法,只能通过其实现类(子类)来创建
 */
public class Demo {
    public static void main(String[] args) {

        ImpClass ic = new ImpClass();// 创建一个实现类对象
        ic.method();




        // 批量修改变量名: shift+fn+f6
       /* ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(12);
        list2.add(12);
        list2.add(12);
        list2.add(12);
        list2.add(12);
        list2.add(12);*/


    }
}
