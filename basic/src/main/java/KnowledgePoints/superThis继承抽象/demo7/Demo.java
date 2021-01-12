package KnowledgePoints.superThis继承抽象.demo7;
/*
    super 关键字的三种用法:
        访问父类的成员变量: super.成员变量名
        访问父类的成员方法: super.成员方法名();
        方法父类的构造方法: 必须在第一行
                super()
                super(参数)

    this  关键字的三种用法
         访问本类的成员变量: this.成员变量名
         访问本类的成员方法: this.成员方法名()
         访问本类的构造方法:  必须在第一行
                    this()
                    this(参数)
 */
public class Demo {
    public static void main(String[] args) {
//       Dog dog = new Dog("旺财");// 调用有参构造方法
//       dog.show();

        Dog dog = new Dog();
    }
}
