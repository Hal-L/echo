package KnowledgePoints.superThis继承抽象.demo7;

public class Zi extends Fu {
    int num = 20;
    @Override
    public void method() {
        super.method();
        System.out.println("Zi 类中的method方法");
    }

    public void show(){
        int num = 30;
        System.out.println(num);// 30
        System.out.println(this.num);//20
        System.out.println(super.num);//10
    }
}
