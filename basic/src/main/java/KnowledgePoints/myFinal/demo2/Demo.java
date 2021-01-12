package KnowledgePoints.myFinal.demo2;
/*
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
public class Demo {
    public static void main(String[] args) {
        final int NUM = 10;// 第一次赋值
//        num = 20;// 第二次赋值 ,错误的

        final int NUM2;// 声明一个num2常量
        NUM2 = 20;// 第一次给num2赋值

//        num2 = 30;错误的,第二次给num2赋值

    }
}
