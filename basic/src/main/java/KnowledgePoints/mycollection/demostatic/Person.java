package KnowledgePoints.mycollection.demostatic;

public class Person {

    String name;// 姓名

    int age;// 年龄

    static String country;// 国籍

    static {
        System.out.println("这是静态代码块语句~");
    }

    public Person(){
        System.out.println("这是空参构造方法");
    }

    // 非静态方法
    public void method01(){
        System.out.println("method01方法");
        method02();
        method03();
        this.name = "jack";
    }

    public void method02(){
        System.out.println(name+":method02方法");
    }

    // 静态方法
    public static void method03(){
//        method02();错误的,静态方法中不能直接调用静态方法
        System.out.println(country+":method03方法");
        method04();
    }

    public static void method04(){
//        this.name = "jack";错误的,静态方法中不能使用this
        System.out.println("method04方法");
    }

}



