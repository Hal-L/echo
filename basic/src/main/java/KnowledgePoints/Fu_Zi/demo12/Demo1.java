package KnowledgePoints.Fu_Zi.demo12;

/*
- 多态指的是: 同一种行为,对于不同的事物具有不同的表现形式。 这就叫做多态。
- 程序中的多态:不同的对象      以自己的方式响应    相同名称方法的能力称为多态

    多态的条件:
        1.要有继承\实现
        2.要有方法的重写
        3.要有父类的引用指向子类的对象(接口的引用指向实现类的对象)
            格式:
                父类名 变量名 = new 子类名();

    多态中的成员访问特点:
        成员变量:
                编译看左边,运行看左边
        成员方法:
            非静态方法:
                编译看左边,运行看右边

            静态方法:
                编译看左边,运行看左边

         只要非静态方法是编译看左边,运行看右边,其他的都是看左边

    多态的好处和使用:
        好处:
            实际开发的过程中，父类类型作为方法形式参数，
            传递子类对象给方法，进行方法的调用，更能体现出多态的扩展性与便利。

    向上转型

        - 向上转型：多态本身是子类类型向父类类型向上转换的过程，这个过程是默认的。
        也就是说 当父类引用指向一个子类对象时，便是向上转型。

        使用格式：

            父类类型  变量名 = new 子类类型();
            如：Animal a = new Cat();// 向上转型  自动完成

    向下转型
        - 向下转型：父类类型向子类类型向下转换的过程，这个过程是强制的。

        一个已经向上转型的子类对象，将父类引用转为子类引用，可以使用强制类型转换的格式，便是向下转型。

        使用格式：
            子类类型 变量名 = (子类类型) 父类变量名;

            如:
                Animal a = new Cat();
                Cat c =(Cat) a;


      自动类型转换: 把 范围小的类型 自动转换为 范围大的类型
      强制类型转换: 把 范围大的类型 强制转换为 范围小的类型     范围小的数据类型 变量名 = (范围小的数据类型)范围大的数据\变量;

        为什么要转型
            当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误。
            也就是说，不能调用子类拥有，而父类没有的方法。编译都错误，更别说运行了。
            这也是多态给我们带来的一点"小麻烦"。所以，想要调用子类特有的方法，必须做向下转型。
        翻译: 其实就是父类的引用不能调用子类独有的方法


    类型转换异常: ClassCastException

    instansof 解决:
        变量名 instanceof 数据类型

        如果变量属于该数据类型，返回true。
        如果变量不属于该数据类型，返回false。

 */
public class Demo1 {
    public static void main(String[] args) {

       Dog dog = new Dog();
       invokeEat(dog);

       Cat cat = new Cat();
       invokeEat(cat);
    }

    private static void method02() {
        Animal anl = new Dog();// 向上转型  把子类类型 转换为 父类类型
        anl.eat();

        Dog dog = (Dog)anl;// 向下转型,把父类类型 转换为子类类型 那么就可以调用子类独有的方法
        dog.lookHome();

        Dog dog2 = new Dog();


//       Dog dog = new Dog();
//       invokeEat(dog);// "狗吃骨头"
//
//        Cat cat = new Cat();
//        invokeEat(cat);
//
//        Animal anl = new Dog();// 向上转型  把子类类型 转换为 父类类型
//
//        Dog dog1 = (Dog)anl;// 向下转型(强制) 把父类类型 转换为 子类类型
    }

    // 需求:定义一个方法,可以调用Animal类的子类的eat方法
    public static void invokeEat(Animal anl){// 写父类的引用,只要写了父类的引用,就可以接收所有子类对象   Animal anl =  new Dog(); Animal anl =  new Cat();
        anl.eat();
        //如果想要调用子类特有的方法    必须向下转型  因为编译看左边,左边是父类,父类中没有子类特有的方法,所有编译报错
        // 应该判断一下 anl 指向的对象是狗类型才去转换
        if(anl instanceof Dog){// 判断anl指向对象是否是Dog类型,如果是,返回true,否则返回false
            Dog dog = (Dog)anl;
            dog.lookHome();
        }

        // 如果想要调用猫抓老鼠的方法
        if(anl instanceof Cat){// 判断anl执行的对象是否是Cat类型,如果是,返回true,否则返回false
            Cat cat = (Cat)anl;
            cat.catchMouse();
        }
    }

//    public static void invokeEat(Cat cat){
//
//    }
//
//    public static void invokeEat(Cat cat){
//
//    }
//

    private static void method01() {
        Animal anl1 = new Dog();// 父类的引用指向子类的对象  多态
        anl1.method2();// 编译看左边,也就是Animal类型
        // 运行也是看左边


//        anl1.method1();// 编译成功,因为Animal类中有method方法
        //结果:  Dog类中的method1方法,说明运行看右边,也就是Dog类型

//        anl1.method();// 不可以 编译看左边,左边是Animal类型,没有method方法


//        System.out.println(anl1.num);// 可以  编译看左边,运行看右边,10
//        System.out.println(anl1.num2);// 不可以  编译看左边


//        Animal anl2 = new Cat();// 父类的引用指向子类的对象  多态
    }
}
