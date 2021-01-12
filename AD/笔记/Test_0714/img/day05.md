## 课堂知识点

### 一、方法

#### 1.什么是方法

- 方法概念
    - 方法就是具备独立功能的一个代码块。
- 使用方法的两个步骤
    - 定义方法
    - 调用方法

#### 2.定义方法和调用方法-【无参数无返回值】

- 定义方法格式

```java
public static void 方法名(){
    //方法体;
}
```

- 方法调用格式

```java
方法名();
```

- 示例代码

```java
public class MethodDemo {
    public static void main(String[] args) {
        System.out.println("开始");

        //调用方法
        isEvenNumber();

        System.out.println("结束");
    }

    //需求：定义一个方法，在方法中定义一个变量，判断该数据是否是偶数
    public static void isEvenNumber() {
        //定义变量
        int number = 10;
        number = 9;

        //判断该数据是否是偶数
        if(number%2 == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
```

#### 3.方法调用过程图解

![01](img\01.png)

#### 4.方法的练习-打印两个数中的较大值

```java
public class MethodTest {
    public static void main(String[] args) {
        //在main()方法中调用定义好的方法
        getMax();
    }

    //定义一个方法，用于打印两个数字中的较大数，例如getMax()
    public static void getMax() {
        //方法中定义两个变量，用于保存两个数字
        int a = 10;
        int b = 20;

        //使用分支语句分两种情况对两个数字的大小关系进行处理
        if(a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }
}
```

#### 5.方法的练习-打印两个数是否相等

```java
public class Demo01 {
    public static void main(String[] args) {
        //调用方法
        isEquals();
    }

    //定义一个方法
    public static void isEquals(){
        //打印两个数据是否相等
        int num1 = 20;
        int num2 = 20;

        if(num1 == num2) {
            System.out.println("相等");
        }else {
            System.out.println("不相等");
        }
    }
}
```

#### 6.定义方法和调用方法-【有参数无返回值】

- 定义方法

```java
public static void 方法名(参数列表) {
    //方法体
}
```

- 调用方法

```java
方法名(参数);
```

- 示例代码

```java
public class MethodDemo {
    public static void main(String[] args) {
        //常量值的调用
        isEvenNumber(11);

        //变量的调用
        int number = 10;
        isEvenNumber(number);
    }

    //需求：定义一个方法，该方法接收一个参数，判断该数据是否是偶数
    public static void isEvenNumber(int number) {
        if(number%2 == 0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

}
```

#### 7.带有参数的方法调用过程图解

![02](img\02.png)

#### 8.形参和实参

- 形式参数
    - 在定义方法的小括号中。给定参数的数据类型和数量！形式参数用来约束调用方法时，传递的实际参数
- 实际参数
    - 在调用方法时，给定的具体的参数

#### 9.方法的练习-方法接收两个数据，打印较大值

```java
public class MethodTest {
    public static void main(String[] args) {
        //在main()方法中调用定义好的方法（使用常量）
        getMax(10,20);
        //调用方法的时候，人家要几个，你就给几个，人家要什么类型的，你就给什么类型的

        //在main()方法中调用定义好的方法（使用变量）
        int aa = 10;
        int bb = 20;
        getMax(aa, bb);
    }

    //定义一个方法，用于打印两个数字中的较大数，例如getMax()
    //为方法定义两个参数，用于接收两个数字
    public static void getMax(int a, int b) {
        //使用分支语句分两种情况对两个数字的大小关系进行处理
        if(a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

}
```

#### 10.方法的练习-方法接收两个数据，打印除法运算后的结果

```java
public class Demo02 {
    public static void main(String[] args) {
        int num1 = 5;
        double num2 = 2.0;
        div(num1,num2);
    }

    //定义一个方法。接收int类型数据和double类型数据
    public static void div(int a,double b) {
        //方法中完成相除结果输出
        double result = a / b;
        System.out.println("相除后的结果是：" + result);
    }
}
```

#### 11.定义方法和调用方法-【有参数有返回值】

- 定义格式

```java
public static 数据类型(返回值) 方法名(参数列表) {
    //方法体
    return 结果;
}
```

- 调用格式

```java
//第一种：赋值调用
数据类型 变量名 = 方法名(参数);

//第二种：输出调用
System.out.println(方法名(参数));
```

- 示例代码

```java
public class MethodDemo {
    public static void main(String[] args) {
        //1:数据类型 变量名 = 方法名(参数);
        boolean flag = isEvenNumber(10);
        //boolean flag = true;
        System.out.println(flag);

        //2.输出调用
        System.out.println(isEvenNumber(11));
    }

    //需求：定义一个方法，该方法接收一个参数，判断该数据是否是偶数，并返回真假值
    public static boolean isEvenNumber(int number) {
        if(number%2 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
```

#### 12.有返回值类型的方法调用过程图解

![03](img\03.png)

#### 13.方法的练习-定义一个方法，获取两个数据的较大值

```java
public class MethodTest {
    public static void main(String[] args) {
        //在main()方法中调用定义好的方法并使用变量保存
        int result = getMax(10,20);
        System.out.println(result);

        //在main()方法中调用定义好的方法并直接打印结果
        System.out.println(getMax(10,20));
    }

    //定义一个方法，用于获取两个数字中的较大数
    public static int getMax(int a, int b) {
        //使用分支语句分两种情况对两个数字的大小关系进行处理
        //根据题设分别设置两种情况下对应的返回结果
        if(a > b) {
            return a;
        } else {
            return b;
        }
    }
}
```

#### 14.方法的注意事项

- 方法和方法之间是平级关系。不能嵌套定义
- return语句
    - 如果是有返回值类型的方法，必须要有return语句
    - 如果是没有返回值类型的方法，可以写return语句。也可以不写！

#### 15.方法的通用格式

- 定义格式

```java
修饰符 返回值类型 方法名(参数列表) {
    //方法体;
    return 结果;
}
```

- 修饰符：public static
- 返回值类型：方法结束后，返回的结果的数据类型的约束。没有返回值要写void
- 方法名：标识符，见名知意
- 参数列表：方法完成功能所需要的参数
- 方法体：完成功能的代码
- return：返回结果。结束方法

- 示例代码

```java
public class Demo03 {
    public static void main(String[] args) {
        printHelloWorld();

        isEquals(10,20);

        getSum(2.3,6.7);

        int result = getSum2(10,20,30);
        System.out.println(result);
    }

    //定义一个方法。在方法中打印5次HelloWorld
    /*
        两个明确：根据方法要完成的功能来进行明确
            明确参数列表：无
            明确返回值类型：void
     */
    public static void printHelloWorld() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("HelloWorld");
        }
    }


    //定义一个方法。接收两个int类型的整数，打印两个整数是否相等
    /*
        两个明确：
            明确参数列表：int num1,int num2
            明确返回值类型：void
     */
    public static void isEquals(int num1,int num2) {
        if(num1 == num2) {
            System.out.println("相等");
        }else {
            System.out.println("不相等");
        }
    }

    //定义一个方法。接收两个double类型的小数，打印求和结果
    /*
        两个明确：
            明确参数列表：double d1,double d2
            明确返回值类型：void
     */
    public static void getSum(double d1,double d2) {
        double sum = d1 + d2;
        System.out.println(sum);
    }

    //定义一个方法。接收三个int类型的整数，获取求和结果
    /*
        两个明确：
            明确参数列表：int num1,int num2,int num3
            明确返回值类型：int
     */
    public static int getSum2(int num1,int num2,int num3) {
        int sum = num1 + num2 + num3;
        return sum;
    }
}
```

### 二、方法重载

#### 1.什么是方法的重载

- 什么是重载
    - 在同一个类中，有多个重名的方法。
- 组成规则
    - 必须在同一个类中
    - 方法名必须相同
    - 参数列表必须不同
        - 参数的数据类型不同
        - 参数的数量不同
        - 参数的顺序不同
    - 与返回值类型无关
- 示例代码

```java
public class MethodDemo {
    public static void main(String[] args) {
        //调用方法
        int result = sum(10,20);
        System.out.println(result);

        double result2 = sum(10.0,20.0);
        System.out.println(result2);

        int result3 = sum(10,20,30);
        System.out.println(result3);
    }

    //需求1：求两个int类型数据和的方法
    public static int sum(int a, int b) {
        return a + b;
    }

    //需求2：求两个double类型数据和的方法
    public static double sum(double a, double b) {
        return a + b;
    }

    //需求3：求三个int类型数据和的方法
    public static int sum(int a, int b, int c) {
        return a + b + c;
    }

}
```

#### 2.方法重载的练习-比较不同数据类型整数是否相等

```java
public class MethodTest {
    public static void main(String[] args) {
        //调用方法
        System.out.println(compare(10, 20));
        System.out.println(compare((byte) 10, (byte) 20));
        System.out.println(compare((short) 10, (short) 20));
        System.out.println(compare(10L, 20L));
    }

    //int
    public static boolean compare(int a, int b) {
        System.out.println("int");
        return a == b;
    }

    //byte
    public static boolean compare(byte a, byte b) {
        System.out.println("byte");
        return a == b;
    }

    //short
    public static boolean compare(short a, short b) {
        System.out.println("short");
        return a == b;
    }

    //long
    public static boolean compare(long a, long b) {
        System.out.println("long");
        return a == b;
    }

}
```

### 三、方法参数传递

#### 1.方法参数传递基本数据类型

- 传递的内容
    - 基本数据类型传递的是具体的值
- 特点
    - 方法中的形式参数改变，不会影响实际参数的值
- 图解

![04](img\04.png)

#### 2.方法参数传递引用数据类型

- 传递的内容
    - 引用数据类型作为方法参数传递，传递的是内存地址值
- 特点
    - 形式参数的改变，会影响实际参数
- 图解

![05](img\05.png)

- 注意
    - String虽然是引用数据类型，但是作为方法参数传递的时候，特点是和基本数据类型一样的

### 四、方法案例

#### 1.定义方法，接收数组。遍历数组

```java
public class MethodTest01 {
    public static void main(String[] args) {
        //定义一个数组，用静态初始化完成数组元素初始化
        int[] arr = {11, 22, 33, 44, 55};

        //调用方法
        printArray(arr);
    }

    //定义一个方法，用数组遍历通用格式对数组进行遍历
    /*
        两个明确：
            返回值类型：void
            参数：int[] arr
     */
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int x=0; x<arr.length; x++) {
            if(x == arr.length-1) {
                System.out.print(arr[x]);
            } else {
                System.out.print(arr[x]+", ");
            }
        }
        System.out.println("]");
    }
}
```

#### 2.定义方法，接收数组。获取数组最大值

```java
public class MethodTest02 {
    public static void main(String[] args) {
        //定义一个数组，用静态初始化完成数组元素初始化
        int[] arr = {12, 45, 98, 73, 60};

        //调用获取最大值方法，用变量接收返回结果
        int number = getMax(arr);

        //把结果输出在控制台
        System.out.println("number:" + number);
    }

    //定义一个方法，用来获取数组中的最大值
    /*
        两个明确：
            返回值类型：int
            参数：int[] arr
     */
    public static int getMax(int[] arr) {
        int max = arr[0];

        for(int x=1; x<arr.length; x++) {
            if(arr[x] > max) {
                max = arr[x];
            }
        }

        return max;
    }

}
```

## 练习题

1. 过一遍笔记 √
2. 练习无参数无返回值的方法的定义和使用 √
3. 练习有参数无返回值的方法的定义和使用 √
4. 练习有参数有返回值的方法的定义和使用 √
5. 练习方法重载的使用 √
6. 练习方法案例 √

## 面试题

- 什么是方法？方法有什么好处？

- 方法的定义格式是什么？

- 形参和实参指的是什么？

- 什么是方法重载？有哪些规则？

- 基本数据类型作为方法参数传递时，传递的是什么？特点是什么？

- 引用数据类型作为方法参数传递时，传递的是什么？特点是什么？