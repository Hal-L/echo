package KnowledgePoints.Fu_Zi.demo11;
/*
- 多态指的是: 同一种行为,对于不同的事物具有不同的表现形式。 这就叫做多态。
- 程序中的多态:不同的对象      以自己的方式响应    相同名称方法的能力称为多态

    多态的条件:
        1.要有继承\实现
        2.要有方法的重写
        3.要有父类的引用指向子类的对象(接口的引用指向实现类的对象)
            格式:
                父类名 变量名 = new 子类名();


 */
public class Demo1 {
    public static void main(String[] args) {
        Fu fu = new Zi();// 父类的引用指向子类的对象  多态

        Zi zi = new Zi();

        A a = new ImpA();// 接口的引用指向实现类的对象  多态

    }
}
