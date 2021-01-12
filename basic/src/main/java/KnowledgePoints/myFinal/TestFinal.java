package KnowledgePoints.myFinal;

public class TestFinal {
    /*
        final修饰变量:

            基本数据类型变量: 其值不能被更改

            引用数据类型变量: 地址值不能被更改, 但是可以修改对象的属性值



    final : 终态的意思  不可变
    修饰类:
        格式:
            public final class 类名{

            }

            例子: public final class String

            被final修饰的类,就不能被子类继承

    修饰方法:
        格式:
            修饰符 final 返回值类型 方法名(参数类型 参数名,...){

            }

            被final修饰的方法不能被子类重写

    修饰变量:
        局部变量: 被final修饰的局部变量会变成一个常量,只能赋值一次
            格式:
                final 数据类型 变量名 = 值;
                final 数据类型 变量名;  变量名 = 值;

        成员变量:被final修饰的成员变量会变成一个常量,只能赋值一次

            显示赋值: final 数据类型 变量名 = 值;
            构造方法赋值: 必须保证所有构造方法都会给该常量赋值

        常量规范: 一般常量名都是全部大写

     */
    public static void main(String[] args) {
        // 常量的命名规范: 如果是一个单词, 所有字母大写, 如果是多个单词, 所有字母大写, 但是中间需要使用_分隔
        final int A = 10;
        // a = 10;
        final int MAX = 10;
        final int MAX_VALUE = 20;

        final Student stu = new Student();
        stu.setName("张三");
        stu.setName("李四");

        // stu = new D5.DemoTostring.Student();
    }
}

class Student {
    // final修饰成员变量 初始化时机
    // 1. 在创建的时候, 直接给值
    // 2. 在构造方法结束之前, 完成赋值
    final int a = 10;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

/*final class Fu {

}

class Zi extends Fu {

}*/
