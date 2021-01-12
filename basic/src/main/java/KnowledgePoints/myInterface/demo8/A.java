package KnowledgePoints.myInterface.demo8;

public interface A {

    void method1();

    void method3();

    public default void method4(){
        System.out.println("A 接口中的method4默认方法");
    }

    public default void method6(){
        System.out.println("A 接口中的method6默认方法");
    }

    public default void method7(){
        System.out.println("A 接口中的method6默认方法");
    }
}
