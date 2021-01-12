package KnowledgePoints.myInterface.demo10;

public interface MyInterA {



    public default void method(){
        System.out.println("实现的接口中的method方法");
    }
}
