package KnowledgePoints.myFinal.demo6;
/*
匿名内部类
 */
public class Demo1 {
    public static void main(String[] args) {
      // 需求: 想调用MyInterA接口中的method 方法
        /*
            1.创建一个实现类,实现该接口
            2.重写接口中的抽象方法
            3.创建实现类的对象
            4.使用该对象调用method方法
         */
        MyImpA mia = new MyImpA();
        mia.method();


        new MyImpA().method();//         MyImpA类的         匿名对象调用method方法
                            // 实现了MyInterA接口的实现类的   匿名对象调用method方法

        // 匿名内部类: 代表接口的对象
        /*
            匿名内部类的本质: 实现了接口的实现类的 匿名对象
               new 接口名(){
                    实现接口中的抽象方法
               }

               匿名内部类可以作为抽象类的匿名对象,也可以作为接口的匿名对象
         */
        new MyInterA(){
            @Override
            public void method() {
                System.out.println("匿名内部类中的method方法");
            }
        }.method();


    }

    private static void method01() {
        // 需求: 想调用Animal类中的eat方法
        /*
        现有知识,思路如下:
            1.创建一个子类,继承Animal类
            2.实现Animal类中的eat方法
            3.创建子类的对象
            4.使用该子类对象调用eat方法
         */
        Dog dog = new Dog();
        dog.eat();// 名字为dog的对象调用了eat方法

        // 匿名对象: 没有名字的对象
//        new Dog();// 匿名对象
        new Dog().eat();//      Dog类           的匿名对象  调用eat方法
        // 继承了Animal类的子类   的匿名对象  调用eat方法
        // 现在调用eat方法,我们使用的就是继承了Animal类的子类的匿名对象
        // 想要得到 继承了Animal类的子类的匿名对象 需要3步  麻烦  有没有简单的方式呢? 有--->匿名内部类

        /*
            匿名内部类
                本质:继承了一个类的子类(实现了一个接口的实现类)  的匿名对象
                    继承了一个类的匿名子类的对象
                格式:
                    new 类名\接口名(){
                         实现抽象方法
                    }
         */
        // 写一个Animal类的匿名内部类
        new Animal(){
            public void eat(){
                System.out.println("匿名内部类中的eat方法");
            }
        }.eat();
    }
}
