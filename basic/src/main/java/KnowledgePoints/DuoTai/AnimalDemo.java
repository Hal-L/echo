package KnowledgePoints.DuoTai;
/*
    多态：
        同一个对象，在不同时刻表现出来的不同形态

    举例：猫
        我们可以说猫是猫：猫 cat = new 猫();
        我们也可以说猫是动物：动物 animal = new 猫();
        这里猫在不同的时刻表现出来了不同的形态，这就是多态

    多态的前提和体现
        有继承/实现关系
        有方法重写
        有父类引用指向子类对象
 */
/*
    向上转型
        从子到父
        父类引用指向子类对象

    向下转型
        从父到子
        父类引用转为子类对象
 */
public class AnimalDemo {
    public static void main(String[] args) {
        //创建猫类对象进行测试
        //向上转型
        Animal a = new Cat();
        a.setName("加菲");
        a.setAge(5);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();

        a = new Cat("加菲", 5);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();

        //向下转型
        Cat c = (Cat) a;
        c.eat();
        c.playGame();

        //向上转型
        a = new Dog();
        a.eat();

        //向下转型
        //ClassCastException 类型转换异常
        Cat cc = (Cat) a;
        cc.eat();
        cc.playGame();

        //创建动物操作类的对象，调用方法
        AnimalOperator ao = new AnimalOperator();
        Cat c2 = new Cat();
        ao.useAnimal(c2);


        Dog d = new Dog();
        ao.useAnimal(d);


        Pig p = new Pig();
        ao.useAnimal(p);
    }
}
