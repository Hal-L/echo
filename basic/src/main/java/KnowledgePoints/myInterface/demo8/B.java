package KnowledgePoints.myInterface.demo8;

public interface B {
    void method2();

    void method3();

    public default void method5(){
        System.out.println("B 接口中的method5默认方法");
    }

    public default void method6(){
        System.out.println("B 接口中的method6默认方法");
    }

    /*public default void method7(){
        System.out.println("B 接口中的method7默认方法");
    }*/
}
