## 课堂知识点

### 一、Idea项目组成部分

#### 1.idea组成部分图解

![01](img\01.png)

#### 2.idea常用快捷键

| 快捷键             | 说明                                   |
| ------------------ | -------------------------------------- |
| Ctrl+Y             | 删除光标所在行                         |
| Ctrl+D             | 复制光标所在行的内容，插入光标位置下面 |
| Ctrl+Alt+L         | 格式化代码                             |
| Ctrl+/             | 单行注释                               |
| Ctrl+Shift+/       | 选中代码注释，多行注释，再按取消注释   |
| Alt+Shift+上下箭头 | 移动当前代码行                         |
| psvm               | 快速生成main方法                       |
| sout               | 快速生成输出语句                       |

### 二、数组

#### 1.什么是数组

- 数组就是一个容器。用于保存多个相同数据类型的数据！

#### 2.数组动态初始化

- 动态初始化：创建数组时，没有具体的数据。只给定数组的长度！
- 格式：数据类型[] 数组名 = new 数据类型[长度];
- 示例代码：

```java
//创建一个int类型的数组，长度为3
int[] arr1 = new int[3];
//创建一个double类型的数组，长度为5
double[] arr2 = new double[5];
```

#### 3.使用数组

- 数组名代表的是数组在内存中的地址，记录的是数组的内存地址值
- 如何访问数组中的元素：数组名[索引]
- 索引：就是数组中的元素的编号，编号从0开始的
- 默认初始化值：
    - 整数类型：0
    - 浮点类型：0.0
    - 字符类型：\u0000
    - 布尔类型：false
    - 引用数据类型：null
- 示例代码

```java
public class Demo01 {
    public static void main(String[] args) {
        int[] arr = new int[3];

        //输出数组名
        System.out.println(arr);    // [I@75412c2f

        //访问数组中的元素   数组名[索引]
        System.out.println(arr[0]); // 0
        System.out.println(arr[1]); // 0
        System.out.println(arr[2]); // 0

        //为数组中的元素进行赋值
        arr[0] = 12;
        arr[1] = 22;
        arr[2] = 33;

        System.out.println("----------------");

        System.out.println(arr[0]); // 12
        System.out.println(arr[1]); // 22
        System.out.println(arr[2]); // 33

    }
}
```

#### 4.java中的内存分配

- 栈内存：用于执行方法的。存储局部变量的！
- 堆内存：用于存储new出来的对象！
- 方法区：用于加载编译后的字节码文件.class文件！

#### 5.一个数组的内存图解

![02](img\02.png)

#### 6.两个数组的内存图解

![03](img\03.png)

#### 7.多个数组指向同一个对象

![04](img\04.png)

#### 8.数组静态初始化

- 静态初始化：创建数组的时候直接将数据指定。由系统来确定数组的长度！
- 格式：
    - 完整格式：数据类型[] 数组名 = new 数据类型[]{元素1,元素2,...};
    - 省略格式：数据类型[] 数组名 = {元素1,元素2,...};
- 示例代码

```java
public class ArrayDemo {
    public static void main(String[] args) {
        //定义数组
        int[] arr = new int[]{1, 2, 3};

        //输出数组名
        System.out.println(arr);

        //输出数组中的元素
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
```

#### 9.操作数组常见的问题

- 数组索引越界异常：ArrayIndexOutOfBoundsException
    - 出现原因：访问了不存在的索引
    - 解决方式：修改为正确的索引范围即可
- 空指针异常：NullPointerException
    - 出现原因：当一个对象的引用为null时，再访问对象时就会出现空指针异常
    - 解决方式：重新赋值一个正确的对象引用即可
- 示例代码

```java
/*
    索引越界：访问了数组中不存在的索引对应的元素，造成索引越界问题
        ArrayIndexOutOfBoundsException

    空指针异常：访问的数组已经不再指向堆内存的数据，造成空指针异常
        NullPointerException

    null：空值，引用数据类型的默认值，表示不指向任何有效对象
 */
public class ArrayDemo {
    public static void main(String[] args) {
        int[] arr = new int[3];

        //System.out.println(arr[3]);
        //System.out.println(arr[2]);

        //把null赋值给数组
        arr = null;
        System.out.println(arr[0]);
    }
}
```

#### 10.数组最值获取

```java
public class Demo01 {
    public static void main(String[] args) {
        //1.定义一个数组
        int[] arr = {5,20,15,40,10000};
        
        //2.定义一个变量max  用来保存最大值
        int max = arr[0];
        
        //3.遍历数组，拿到每一个元素
        for (int i = 1; i < arr.length; i++) {
            //4.判断当前的元素是否大于max中的值
            if(arr[i] > max) {
                //如果大于：将当前元素赋值给max
                max = arr[i];
            }
        }

        System.out.println("最大值是：" + max);
    }
}
```

#### 11.数组元素求和

```java
/*
    需求：对数组元素进行求和

    分析：
        1.定义一个数组
        2.定义一个求和变量
        3.遍历数组，拿到每一个元素
        4.用元素和求和变量累加
        5.输出结果
 */
public class Demo02 {
    public static void main(String[] args) {
        //1.定义一个数组
        int[] arr = {10,20,30,40,50};
        
        //2.定义一个求和变量
        int sum = 0;
        
        //3.遍历数组，拿到每一个元素
        for (int i = 0; i < arr.length; i++) {
            //4.用元素和求和变量累加
            sum += arr[i];
        }

        //5.输出结果
        System.out.println("总和是：" + sum);
    }
}
```

#### 12.数组元素求平均值

```java
/*
    需求：求数组元素的平均值

    分析：
        1.定义一个数组
        2.定义一个求和变量
        3.遍历数组，拿到每一个元素
        4.用元素和求和变量累加
        5.用总和除以数组的长度得出平均值
        6.输出结果
 */
public class Demo03 {
    public static void main(String[] args) {
        //1.定义一个数组
        int[] arr = {10,20,30,40,50,60,70,80,90,100};

        //2.定义一个求和变量
        int sum = 0;

        //3.遍历数组，拿到每一个元素
        for (int i = 0; i < arr.length; i++) {
            //4.用元素和求和变量累加
            sum += arr[i];
        }

        //5.用总和除以数组的长度得出平均值
        int avg = sum / arr.length;

        // 6.输出结果
        System.out.println("平均值是：" + avg);
    }
}
```

#### 13.键盘录入为数组元素赋值

```java
/*
    需求：
        1.定义一个长度为5的int类型数组
        2.通过键盘录入为数组元素赋值

    分析：
        1.定义一个长度为5的int类型数组
        2.创建Scanner对象
        3.接收数字，为数组元素赋值
 */
public class Demo04 {
    public static void main(String[] args) {
        //1.定义一个长度为5的int类型数组
        int[] arr = new int[5];

        //2.创建Scanner对象
        Scanner sc = new Scanner(System.in);

        //3.接收数字，为数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+(i+1)+"个数字：");
            arr[i] = sc.nextInt();
        }

        //4.遍历数组
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```

#### 14.生成随机数为数组元素赋值

```java
/*
    需求：
        1.定义一个长度为5的int类型数组
        2.通过生成随机数为数组元素赋值，随机数范围1~100

    分析：
        1.定义一个长度为5的int类型数组
        2.创建Random对象
        3.遍历数组，通过生成随机数为数组元素赋值
        4.遍历数组，查看结果
 */
public class Demo05 {
    public static void main(String[] args) {
        //1.定义一个长度为5的int类型数组
        int[] arr = new int[5];

        //2.创建Random对象
        Random r = new Random();

        //3.遍历数组，通过生成随机数为数组元素赋值
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100)+1;
        }

        //4.遍历数组，查看结果
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
```

## 练习题

1. 过一遍笔记 √
2. 练习idea中的快捷键 √
3. 练习数组的动态初始化
4. 练习数组的静态初始化
5. 练习数组的案例

## 面试题

- 什么是数组？

  数组就是一个储存多个相同类型的数据的容器

- 数组的初始化有几种方式？

  动态初始化：

  ```java
  int [] arr=new int [3];
  ```

静态初始化：

  ```java
  int [] arr = new int[]{1,2,3,}
  ```

- 使用数组的两个小问题的出现原因和解决方式？

  索引越界：修改正确范围的索引

  空指针异常：修改正确的引用对象

- java中的内存划分

  目前有：栈内存：用于执行方法的，储存局部变量，使用完成后自动立即删除

  ​ 堆内存：用去储存new出的对象，使用完成后，在回收站空闲时自动删除

  ​ 方法区：用于加载编译后的字节码文件，就是.class文件

