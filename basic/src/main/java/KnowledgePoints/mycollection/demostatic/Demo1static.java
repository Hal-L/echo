package KnowledgePoints.mycollection.demostatic;
/*
static : 静态的意思
    1.static是一个静态修饰符关键字
    2.static可以用来修饰成员变量和成员方法
        修饰成员变量:
            1.格式: static 数据类型 成员变量名;
            2.被static修饰的成员变量会变成一个静态变量,而静态变量会被该类的所有对象共享,也就是说该类的所有对象使用的是同一份数据
            3.
                对象名.成员变量名
                类名.成员变量名
        修饰成员方法:
            1.格式
                 在方法的返回值类型前面加一个static
            2.被static修饰的方法会变成静态方法
                通过 类名.方法名(参数) 调用
        静态方法注意:
            1.静态方法可以使用类名.方法名()的形式调用,也可以通过对象名.方法名()形式调用
            2.非静态方法中可以直接调用静态方法
            3.静态方法中不能直接调用非静态成员方法
            4.静态方法中不能直接访问非静态只能直接访问静态成员(静态成员变量和静态成员方法)
            6.静态方法中不能有成员变量
            5.静态方法中this

被修饰的成员是属于类的，而不是单单是属于某个对象的。也就是说，既然属于类，就可以不靠创建对象来调用了,可以通过类名来调用

静态成员是随着类的加载而加载,只会加载一次



静态代码块：定义在成员位置，使用static修饰的代码块{ }。

        1. 位置：类中方法外。

        2. 格式:
            static {
                    // 静态代码块
            }

        3. 执行：随着类的加载而执行且执行一次，优先于构造方法的执行。


 */
public class Demo1static {
    public static void main(String[] args) {


        Person p = new Person();
        Person p2 = new Person();
















//        Person.method04();

//        Person p1 = new Person();
//        p1.method01();

//        Person.method03();// 通过类名调用静态方法
//        p1.method03();

    }

    private static void method01() {
        // 一个类可以创建多个对象,多个对象之间是相互独立的

        Person.country = "中国";

        Person p1 = new Person();
        p1.name = "冰冰";
        p1.age = 20;
//        p1.country = "中国";
        System.out.println(p1.name+","+p1.age+","+p1.country);


        Person p2 = new Person();
        p2.name = "苍老师";
        p2.age = 18;
        System.out.println(p2.name+","+p2.age+","+p2.country);

        Person p3 = new Person();
        System.out.println(p3.country);
    }
}
