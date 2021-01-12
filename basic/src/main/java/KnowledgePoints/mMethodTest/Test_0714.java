package KnowledgePoints.mMethodTest;

/*methond  把重复功能的代码块(代码块)放在公共代码区域   直接调用   提高复用性
一段具有独立功能的代码块，不调用就不执行，需要先定义才能调用
方法体：真正要执行的代码

public static void 方法名() {
    //方法体：方法真正要执行的逻辑代码
}
方法调用
    格式：方法名();
    方法与方法之间是平级关系，不能嵌套定义

方法调用过程
    方法没有被调用的时候，都在方法区中的字节码文件(.class)存储
    方法被调用的时候，需要进入到栈内存中运行

带参数方法定义
    格式 ：public static void 方法名(参数){... ...}

    格式(单个参数):public static void 方法名{数据类型 变量名}{...}
    范例(单个参数)： public static void method(int number){...}

    格式(多个参数):public static void 方法名{数据类型 变量名1,数据类型 变量名2,数据类型 变量名3}{...}
    范例(多个参数)： public static void method(int number1,int number2,int number3){...}

注意：
    方法定义时，参数中的数据类型与变量名都不能缺少，缺少任意一个程序将报错
    方法定义时，多个参数之间使用逗号(,)分隔

带参数方法调用
    格式：      方法名(参数)；
    格式(单个参数)：方法名(变量名/常量值)；
    范例(单个参数)：method(5);
    格式(多个参数)：方法名(变量名1/常量值1，变量名2/常量值2，变量名3/常量值3)；
    范例(多个参数)：method(5,6,7);

注意：
    方法调用时，参数的数量与类型必须与方法定义中的设置相匹配，否则程序将报错

形参和实参
    形参：全称形式参数，是指方法'定义'中的参数       public static void num(int a)
    实参：全称实际参数，方法'调用'中的参数          int a = 10;

#带返回值方法定义
    格式：  public static 返回值的数据类型  方法名(参数){
        //  上面的返回值数据类型 为return数据的数值类型
                return数据；
            }

    范例1： public static boolean isEuenNumber(int number){
                return true;
            }

    范例2： public static in getMax(int a,int b){
                return 100;
            }

注意：
        方法定义时return后面的返回值与方法定义上的数据类型要匹配，否则程序将报错

带返回值方法调用
    格式1：方法名(参数)；
    范例： isEvenNumber(5);

    格式2：返回值数据类型 变量名 = 方法名(参数)；
    范例： boolean flag = isEvenNumber(5);

方法的调用格式
            直接调用
            赋值调用
            打印调用

return:结束方法并且返回结果
            return 数据;return;(返回值为void )

方法的通用格式
    格式： public static 返回值类型 方法名(参数){
                方法体；
                return数据；
    }
定义方法时，要做到两个明确
    明确参数：主要是明确参数的类型和数量
    明确返回值类型：主要是明确方法操作完毕之后是否有数据返回，如果没有，写void；如果有，写对应的数据类型
调用方法时
    非void类型的方法，直接调用即可
    非void类型的方法，推荐用变量接受调用
public static 修饰符，目前先记住这个格式
返回值类型 方法操作完毕之后返回的结果数据，所对应的数据类型(如果方法操作完毕，没有数据返回， 这里写void，而且方法体中一般不写return)
方法的返回值类型为void，表示该方法没有返回值，没有返回值的方法可以省略return语句不写，如果要编写return，后面不能跟具体的数据。
return语句下面，不能编写代码，因为永远执行不到，属于无效代码
方法名      调用方法时候使用的标识
参数        由数据类型和变量名组成，多个参数之间用逗号隔开(理解：方法运行之前所需要的材料)
方法体      完成功能的代码块
return      如果方法操作完毕，有数据返回，用于把数据返回给调用者

方法重载
    方法重载概述
    在同一个类中，定义了多个同名的方法，但每个方法具有不同参数类型或参数个数，这些同名的方法，就构成了重载关系。
    调用方法的时候，Java虚拟机会通过参数的不同来区分同名的方法
    简单记：同一个类中，方法名相同，参数不同的方法
            参数不同：个数不同、类型不同、顺序不同

注意事项：
    方法名相同，参数也完全相同，方法的重复定义是一种冲突性的错误。
    识别方法之间是否是重载关系，同类下只看方法名和参数(类型、个数、顺序)，跟返回值无关。

方法传递为基本数据类型:传入方法中的,是具体的数值
方法传递为引用数据类型:传入方法中的,是内存地址


*/
public class Test_0714 {
    public static void main(String[] args) {
        // 在main方法中调用print方法，传入两个实际参数
        print(11, 20);
        int num = add(10, 20);
        System.out.println("add:" + num);
        int result = getMax(10, 20);
        System.out.println("getmax方法，最大值:" + result);
        // 使用一个变量接受返回数据，还可以使用变量进行其他逻辑
        System.out.println("getmax方法，最大值:" + getMax(10, 20)); // 输出调用
        int number = 100;
        System.out.println("调用change方法前:" + number);
        change(number);
        System.out.println("调用change方法后:" + number);
    }

    public static void change(int number) {
        number = 200;
    }

    // 定义方法，名称为print
    // 为方法添加两个int类型的形参，准备接受调用者传递过来的实参
    public static void print(int n, int m) {
        if (m < n) {
            System.out.println("您输入的数据有误，请检查");
            // return;可以用于结束方法，也就是将方法从栈内存中弹出去，该过程称之为方法的弹栈
            return;
        }
        System.out.println("print方法，从" + n + "到" + m + "之间的奇数为");
        // 方法中设计for循环，循环从n开始，到m结束
        for (int i = n; i <= m; i++) {
            // 循环中加入if判断，时奇数，则打印
            if (i % 2 == 1) {
                System.out.println(i);
            }
        }
    }

    /*
     * 带返回值的“定义”格式： public static 数据类型 方法名(参数){ return 数据； }
     * 方法定义时return后面返回值的数据类型与方法定义上的数据类型要匹配，否则程序将报错
     */

    public static int add(int a, int b) {
        int c = a + b;
        return c;
    }

    // ①定义一个方法，声明两个形参接受计算的数值，求出结果并返回
    public static int getMax(int a, int b) {
        // ②使用if语句得出a和b之间的最大值，根据情况return具体结果
        if (a > b) {
            return a;
        } else {
            return b;
        }
        // ③ 在main()方法中调用定义好的方法并使用变量保存，否则返回值毫无意义

    }
}
