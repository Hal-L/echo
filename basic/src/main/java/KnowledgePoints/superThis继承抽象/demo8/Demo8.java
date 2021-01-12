package KnowledgePoints.superThis继承抽象.demo8;
/*
抽象方法: 没有方法体的方法就是抽象方法,使用abstract关键字修饰
    格式:
        public abstract 返回值类型  方法名(参数类型 参数名,...);
抽象类: 使用abstract修饰的类就是一个抽象类
    格式:
        public abstract class 类名{

        }

     特点:
        1.抽象类中仅仅只是比普通类多了抽象性方法而已
        2.抽象类不能直接创建对象,只能通过创建其子类对象来使用
            普通类作为子类: 必须实现抽象父类中的所有抽象方法
            抽象类作为子类: 就可以不去实现抽象类中的抽象方法
        3.抽象类中的构造方法,其实就是给子类访问父类数据之前给父类的属性进行初始化用的

    注意:
        1.有抽象方法的类,一定是一个抽象类
        2.抽象类中不一定有抽象方法
 */
public class Demo8 {
    public static void main(String[] args) {

        Dog dog = new Dog(10);
        dog.sleep();

    }
}
