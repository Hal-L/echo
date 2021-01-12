package KnowledgePoints.内部类;
/*
 - 内部类可以直接访问外部类的成员，包括私有成员。
 - 外部类要访问内部类的成员，必须要建立内部类的对象
 */
public class Body {

    private int num = 10;

    // 心脏类  定义在类中方法外的类。
    public class Heart{// 心脏内部类

        public int num2 = 20;

        public int num = 30;

        public void method(){
            int num = 40;
            System.out.println("内部类中method方法的局部变量num:"+num);//40
            System.out.println("内部类中的成员变量num:"+this.num);//30
            System.out.println("外部类中的成员变量num:"+Body.this.num);//10
        }

        public void heartMethod(){
            System.out.println("内部类中的method方法访问外部类的成员变量:"+num);
            bodyMethod();// 调用外部类的方法
        }
    }

    public void bodyMethod(){
        // 要创建一个内部类的对象
        // 格式: 外部类名.内部类名  对象名 = new 外部类名().new 内部类名();
        Body.Heart bh = new Body().new Heart();// 创建一个内部类对象
        System.out.println("外部类中的method方法访问内部类的成员变量:"+bh.num2);
//        bh.heartMethod();// 调用内部类的 heartMethod 方法

        System.out.println("外部类的method方法");
    }

}
