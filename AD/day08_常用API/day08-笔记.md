## 课堂知识点

### 一、API

#### 1.帮助文档使用步骤

略~

### 二、String类

#### 1.String类介绍

- String类代表的是字符串的对象
- String字符串内容不可改变
- 虽然内容不可改变，但是可以被共享使用

#### 2.String类构造方法

- 方法分类

| 方法名             | 说明                           |
| ------------------ | ------------------------------ |
| String()           | 创建一个内容为空的字符串对象   |
| String(char[] arr) | 根据字符数组创建一个字符串对象 |
| String(byte[] arr) | 根据字节数组创建一个字符串对象 |
| String s = "abc";  | 快速定义字符串对象的方式       |

- 示例代码

```java
public class StringDemo01 {
    public static void main(String[] args) {
        //public String()：创建一个空白字符串对象，不含有任何内容
        String s1 = new String();
        System.out.println("s1:" + s1);

        //public String(char[] chs)：根据字符数组的内容，来创建字符串对象
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);
        System.out.println("s2:" + s2);

        //public String(byte[] bys)：根据字节数组的内容，来创建字符串对象
        byte[] bys = {97, 98, 99};
        String s3 = new String(bys);
        System.out.println("s3:" + s3);

        //String s = “abc”;	直接赋值的方式创建字符串对象，内容就是abc
        String s4 = "abc";
        System.out.println("s4:" + s4);
    }
}
```

#### 3.String类的特点

- 如果是new的方式创建字符串对象，保存的是堆内存中的对象的地址值
- 如果是直接赋值的方式创建字符串对象，保存的是常量池中的对象的地址值
- 图解

![01](img\01.png)

#### 4.String类的成员方法-equals()

- ==号
    - 如果比较的基本数据类型，比较的是具体的值
    - 如果比较的是引用数据类型，比较的是地址值
- equals方法：比较字符串的内容是否相同，区分大小写 （PS:构造方法 String s=new String(),()中只允许写一个字符串吗？怎么做才可以写多个？）

```java
public class Demo01 {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = new String("abc");

        System.out.println(s1 == s2);   // false

        String s3 = "abc";
        String s4 = "abc";

        System.out.println(s3 == s4);   // true
        System.out.println(s1 == s3);   // false

        System.out.println("----------------");

        System.out.println(s1.equals(s2));  // true
        System.out.println(s3.equals(s4));  // true
        System.out.println(s1.equals(s3));  // true

        System.out.println("-----------------");

        String s5 = "ABC";
        System.out.println(s4.equals(s5));  //false
    }
}
```

#### 5.String类案例-用户登录

```java
public class StringTest01 {
    public static void main(String[] args) {
        //已知用户名和密码，定义两个字符串表示即可
        String username = "KnowledgePoints.myInterface.interFalse";
        String password = "czbk";

        //键盘录入要登录的用户名和密码，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        //用循环实现多次机会，这里的次数明确，采用for循环实现，并在登录成功的时候，使用break结束循环
        for(int i=0; i<3; i++) {
            
            System.out.println("请输入用户名：");
            String name = sc.nextLine();

            System.out.println("请输入密码：");
            String pwd = sc.nextLine();

            //拿键盘录入的用户名、密码和已知的用户名、密码进行比较，给出相应的提示。字符串的内容比较，用equals() 方法实现
            if (name.equals(username) && pwd.equals(password)) {
                System.out.println("登录成功");
                break;
            } else {
                if(2-i == 0) {
                    System.out.println("你的账户被锁定，请与管理员联系");
                } else {
                    System.out.println("登录失败，你还有" + (2 - i) + "次机会");
                }
            }
        }
    }
}
```

#### 6.String类的成员方法-charAt()和length()

- char charAt(int index)       获取指定索引上的字符
- int length()                          获取字符串的长度
- 遍历字符串

```java
public class StringTest02 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //遍历字符串，首先要能够获取到字符串中的每一个字符    字符串索引越界异常：StringIndexOutOfBoundsException
        for(int i = 0; i < line.length(); i++) {
            System.out.println(line.charAt(i));
        }

    }
}
```

#### 7.String类案例-统计字符个数

```java
public class StringTest03 {
    public static void main(String[] args) {
        //键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();

        //要统计三种类型的字符个数，需定义三个统计变量，初始值都为0
        int bigCount = 0;
        int smallCount = 0;
        int numberCount = 0;
        int otherCount = 0;

        //遍历字符串，得到每一个字符
        for(int i=0; i<line.length(); i++) {
            char ch = line.charAt(i);

            //判断该字符属于哪种类型，然后对应类型的统计变量+1
            if(ch>='A' && ch<='Z') {
                bigCount++;
            } else if(ch>='a' && ch<='z') {
                smallCount++;
            } else if(ch>='0' && ch<='9') {
                numberCount++;
            } else {
                otherCount++;
            }
        }

        //输出三种类型的字符个数
        System.out.println("大写字母：" + bigCount + "个");
        System.out.println("小写字母：" + smallCount + "个");
        System.out.println("数字：" + numberCount + "个");
        System.out.println("其他字符：" + otherCount + "个");

    }
}
```

#### 8.String类案例-拼接数组元素

```java
public class StringTest04 {
    public static void main(String[] args) {
        //定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};

        //调用方法，用一个变量接收结果
        String s = arrayToString(arr);

        //输出结果
        System.out.println("s:" + s);
    }

    //定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
    /*
        两个明确：
            返回值类型：String
            参数：int[] arr
     */
    public static String arrayToString(int[] arr) {
        //在方法中遍历数组，按照要求进行拼接
        String s = "";

        s += "[";

        for(int i=0; i<arr.length; i++) {
            if(i==arr.length-1) {
                s += arr[i];
            } else {
                s += arr[i];
                s += ", ";
            }
        }

        s += "]";

        return s;
    }
}
```

#### 9.String类案例-字符串反转

```java
public static void reverse(String s) {  // s = "abc"

        //定义一个字符串变量
        String ss = "";

        //将这个字符串反转
        for(int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);
            ss += ch;
        }

        //输出结果
        System.out.println(ss);
    }
```

### 三、StringBuilder类

#### 1.StringBuilder类概念

- StringBuilder是一个可变的字符序列
- 来自于java.lang包，所以使用时不需要导包

#### 2.StringBuilder构造方法

- 方法分类

| 方法名                    | 说明                                   |
| ------------------------- | -------------------------------------- |
| StringBuilder()           | 创建一个内容为空的字符串缓冲区对象     |
| StringBuilder(String str) | 根据字符串的内容来创建字符串缓冲区对象 |

- 示例代码

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //public StringBuilder()：创建一个空白可变字符串对象，不含有任何内容
        StringBuilder sb = new StringBuilder();
        System.out.println("sb:" + sb);
        System.out.println("sb.length():" + sb.length());

        //public StringBuilder(String str)：根据字符串的内容，来创建可变字符串对象
        StringBuilder sb2 = new StringBuilder("hello");
        System.out.println("sb2:" + sb2);
        System.out.println("sb2.length():" + sb2.length());
    }
}
```

#### 3.StringBuilder成员方法

- 方法分类

| 方法名                          | 说明                     |
| ------------------------------- | ------------------------ |
| StringBuilder append(任意类型); | 向缓冲区中追加数据       |
| StringBuilder reverse();        | 将缓冲区的内容反转       |
| String toString();              | 将缓冲区的内容转成字符串 |
| int length();                   | 获取缓冲区的长度         |

- 示例代码

```java
public class StringBuilderDemo01 {
    public static void main(String[] args) {
        //创建对象
        StringBuilder sb = new StringBuilder();

        //public StringBuilder append(任意类型)：添加数据，并返回对象本身
        //链式编程
        sb.append("hello").append("world").append("java").append(100);

        System.out.println("sb:" + sb);

        //public StringBuilder reverse()：返回相反的字符序列
        sb.reverse();
        System.out.println("sb:" + sb);

        //int length()   获取缓冲区的长度
        System.out.println(sb.length());

        //String toString()    将缓冲区的内容转为字符串
        String str = sb.toString();
        System.out.println(str);
    }
}
```

#### 4.StringBuilder和String相互转换

- String转成StringBuilder
- StringBuilder转成String
- 示例代码

```java
public class Demo03 {
    public static void main(String[] args) {
        //String转成StringBuilder
        String s1 = "hello";

        //1.通过有参构造
        /*StringBuilder sb = new StringBuilder(s1);
        System.out.println(sb);*/

        //2.append方法追加
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        System.out.println(sb);

        System.out.println("-------------");

        //StringBuilder转成String
        StringBuilder sb2 = new StringBuilder();
        sb2.append("hello").append(",").append("world").append(",").append("java");
        System.out.println(sb2);

        String ss = sb2.toString();
        System.out.println("ss:" + ss);
    }
}
```

#### 5.StringBuilder案例-数组元素拼接

```java
public class StringBuilderTest01 {
    public static void main(String[] args) {
        //定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1, 2, 3};

        //调用方法，用一个变量接收结果
        String s = arrayToString(arr);

        //输出结果
        System.out.println("s:" + s);

    }

    //定义一个方法，用于把 int 数组中的数据按照指定格式拼接成一个字符串返回
    /*
        两个明确：
            返回值类型：String
            参数：int[] arr
     */
    public static String arrayToString(int[] arr) {
        //在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        StringBuilder sb = new StringBuilder();

        sb.append("[");

        for(int i=0; i<arr.length; i++) {
            if(i == arr.length-1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(", ");
            }
        }

        sb.append("]");

        String s = sb.toString();

        return s;
    }
}
```

#### 6.StringBuilder案例-对称字符串

```java
public class Demo04 {
    public static void main(String[] args) {
        String[] arr = {"aa","aba","abcd","大王天天王大","上海自来水来自海上"};

        print(arr);
    }

    public static void print(String[] arr) {
        //完成对数组中的每一个字符串的判断。判断字符串是否是对称的
        /*
            分析：
                1.遍历数组，拿到每一个字符串
                2.通过StringBuilder来完成字符串的反转
                3.用反转后的字符串和原始字符串比较
                    true：是对称的
                    false：不是对称的
         */
        for (int i = 0; i < arr.length; i++) {
            //历数组，拿到每一个字符串
            String str = arr[i];
            //通过StringBuilder来完成字符串的反转
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            String rev = sb.toString();
            //用反转后的字符串和原始字符串比较
            if(rev.equals(str)) {
                System.out.println(str + "是对称的");
            }else {
                System.out.println(str + "不是对称的");
            }
        }
    }
}
```

## 练习题

1. 过一遍笔记 √
2. 练习使用API帮助文档的查看 √
3. 练习String类的构造方法的使用 √
4. 练习String类的成员方法的使用-equals()-charAt()-length() √
5. 练习String类的案例 √
6. 练习StringBuilder类的构造方法的使用 √
7. 练习StringBuilder类的成员方法的使用-append()-reverse()-toString()-length() √
8. 练习StringBuilder和String之间相互转换 √
9. 练习StringBuilder类的案例

## 面试题

- String类有什么特点
- String类通过构造方法创建对象和直接赋值有什么区别
- ==号有什么特点
- StringBuilder类有什么特点
- StringBuilder和String如何相互转换