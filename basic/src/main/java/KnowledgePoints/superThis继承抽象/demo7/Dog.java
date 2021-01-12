package KnowledgePoints.superThis继承抽象.demo7;

public class Dog extends Animal{
    public String name;

    public int age;

    public Dog(){
//        super(); // 访问父类的空参构造
//        System.out.println("Dog 类的空参构造方法");
        this("wangcai");
    }

    public Dog(String name){
//        super(name);// 访问父类的有参构造
//        this();
        System.out.println("Dog 类的有参构造方法");
    }

    public void show(){
        System.out.println(super.name);// 访问父类的成员变量   旺财
        super.run();// 访问父类的成员方法  Animal 类中的run方法
    }

    public void method(){
       /* int age = 10;
        System.out.println(age);
        System.out.println(this.age);// 访问本类中的成员变量
        show();*/
        this.show();// 访问本类中的show方法
    }

}
