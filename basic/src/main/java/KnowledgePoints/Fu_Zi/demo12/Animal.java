package KnowledgePoints.Fu_Zi.demo12;

public abstract class Animal {
    int num = 10;// 定义一个成员变量 num num的值是10

    public abstract void eat();// 定义一个抽象方法

    public void method1(){
        System.out.println("Animal类中的method1方法");
    }

    public static void method2(){
        System.out.println("Animal 类中的method2静态方法");
    }


}
