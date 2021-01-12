package KnowledgePoints.myStatic;

/*
       1. 被static修饰的成员, 会被该类的所有对象所[共享]
       2. 被static修饰的成员, 会随着类的加载而加载, 优先于对象存在
       3. 多了一种调用方式, 可以通过类名.进行调用
    */
public class Student {
    //非静态成员变量
    private String name = "林青霞";
    //静态成员变量
    private static String university = "传智大学";

    int age;
    static String school;
    //非静态成员方法
    public void show1() {

    }

    //非静态成员方法
    public void show2() {
        System.out.println(name);
        System.out.println(university);
        show1();
        show3();
    }

    //静态成员方法
    public static void show3() {

    }

    //静态成员方法
    public static void show4() {
//        System.out.println(name);
        System.out.println(university);
//        show1();
        show3();
    }
    /*  静态随着类的加载而加载, 优先于对象存在
       非静态需要在创建对象之后,才可以进行使用

       1. 静态方法中, 只能访问静态成员(成员变量, 成员方法)
       2. 非静态方法中, 可以使用静态成员, 也可以使用非静态成员
       3. 静态方法中, 没有this关键字
    */
    public void show() {
        System.out.println(name + "..." + age + "..." + school);
    }

    public static void method(){
        // this: 当前对象的引用
        // this需要在创建对象之后, 才会存在, 静态存在的时候, 对象可能还没有被创建
        // this.name = "张三";
    }
}
