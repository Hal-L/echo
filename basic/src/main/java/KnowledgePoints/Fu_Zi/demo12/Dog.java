package KnowledgePoints.Fu_Zi.demo12;

public class Dog extends Animal{

    int num2 = 20;

    int num = 30;

    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }

    public void lookHome(){
        System.out.println("狗正在看家");
    }

    public void method(){
        System.out.println(num2);
        System.out.println(num);
    }

    public void method1(){
        System.out.println("Dog类中的method1方法");
    }

    public static void method2(){
        System.out.println("Dog 类中的method2静态方法");
    }

}
