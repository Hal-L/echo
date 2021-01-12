package KnowledgePoints.myFinal.demo6;

public class Demo2 {
    public static void main(String[] args) {
        // 如何调用method1方法
        /*
          1.创建一个实现类,实现MyInterfaceB接口
          2.实现接口中的抽象方法
          3.创建一个实现类的对象
          4.调用method1方法,把实现类的对象作为参数传入metho1方法中
         */
        MyImpB mib = new MyImpB();// 创建一个MyImpB实现类的对象
        method1(mib);

        // 直接调用method1方法,把MyInterfaceB接口的匿名对象传入方法中
        MyInterfaceB mib2 =  new MyInterfaceB(){
            @Override
            public void method() {
                System.out.println("匿名内部类中的method方法");
            }
        };

        method1(mib2);
    }
    //   把实现类的对象传入了method01方法中
    public static void method1(MyInterfaceB mib){
        mib.method();
    }
}
