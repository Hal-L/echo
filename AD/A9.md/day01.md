## 课堂知识点

### 一、Java语言概念

#### hhh.java语言所属公司

- 美国的Sun公司
- 已经被oracle公司收购  

#### 2.java语言的创始人

- 詹姆斯·高斯林

#### 3.java语言发展历程

- 1995年推出了java语言
- 1996年正式推出了JDK1.0版本
- 2004年推出了JDK5.0版本
- 2014年推出了JDK8.0版本

### 二、java语言的好处

#### hhh.java语言跨平台性

- 平台：操作系统
  - windows
  - linux
  - unix
  - mac
- 跨平台原理
  - java程序是运行在虚拟机中。只需要在不同的操作系统中安装虚拟机即可！
- 图解

![01](img\01.png)

### 三、JDK和JRE

#### hhh.JDK作用

- 开发工具包。包含了JRE

#### 2.JRE作用

- 运行环境。包含了JVM虚拟机

#### 3.JVM虚拟机

- 可以保证程序的运行和跨平台性

#### 4.包含关系

- JDK包含JRE
- JRE包含JVM

### 四、开发环境的配置

#### hhh.JDK如何下载

去oracle官网：www.oracle.com

#### 2.JDK如何安装

双击安装即可。下一步大法！注意：安装路径不建议有中文和空格

#### 3.环境变量如何配置

- 我的电脑->鼠标右键->点击属性->点击高级系统设置->高级->环境变量
- 在系统变量中：
  - 点击新建：
    - 变量名：JAVA_HOME
    - 变量值：jdk所在目录
  - 找到Path变量，点击编辑
    - 在最前面加入：%JAVA_HOME%\bin;

### 五、常用的DOS命令

#### hhh.命令行窗口如何打开

win + r 快捷键，在弹出的窗口中输入：cmd  敲回车

#### 2.常用的DOS命令

- 切换盘符        盘符:
- 查看当前路径下的内容        dir
- 进入单级目录      cd 目录名
- 进入多级目录      cd 目录名1\目录名2...
- 回退单级目录      cd ..
- 回退多级目录      cd ..\..
- 清除屏幕              cls
- 退出窗口              exit
- 查看ip地址            ipconfig
- 测试连接                ping ip地址|域名

### 六、入门案例HelloWorld

#### hhh.编写程序

- 创建一个文件：HelloWorld.java
- 在文件中写代码

```java
public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("HelloWorld");
	}
}
```

#### 2.编译程序

- 打开命令行窗口：win + r    输入cmd
- 在命令行窗口中：javac HelloWorld.java

#### 3.运行程序

- java HelloWorld

#### 4.解决问题

- 单词问题：单词大小写是否正确。多个单词之间是否有空格
- 标点符号问题：全部都是英文状态下的

### 七、Java基础语法

#### hhh.java中的注释

- 作用：对程序进行解释说明的。给人看的！
- 分类：
  - 单行注释：// 注释的内容
  - 多行注释：/* 注释的内容 */
  - 文档注释：/** 注释的内容 */
- 注意事项
  - 单行注释可以嵌套单行注释
  - 多行注释中可以嵌套单行注释，但是不能嵌套多行注释
- 示例代码

```java
/*
	这是我的第一个入门程序。很开心啊~
	佛祖保佑，永无BUG
*/
//这是通过class定义了一个类。类名叫：HelloWorld
public class HelloWorld {
	//main方法是程序执行主入口，main方法，也称之为主方法，如果程序没有编写主方法，将在运行的使用出现错误
	public static void main(String[] args) {
		//这是一条输出语句。在控制台打印双引号中所包裹的内容
		System.out.println("hello");
	}
}
```

#### 2.java中的关键字

- 什么是关键字
  - 被java语言赋予了特殊含义的单词
  - 举例：class 代表一个类    public代表权限为公共的
- 关键字特点
  - 关键字的单词全部小写
  - 一些高级编辑器会有颜色高亮显示
- 常见的关键字
  - public class static void true false null 

#### 3.java中的常量（Constant）

- 什么是常量
  - 在程序运行过程中，其值不会发生改变
- 常量的分类
  - 字符串常量            被双引号所包裹的内容   "Hello"   "你好"     "100"
  - 整数常量              所有整数    10    -89
  - 小数常量              所有小数    6.6   -9.87
  - 字符常量              被单引号包裹的内容，里面只能存放单个字符  'a'   '5'     '中'
  - 布尔常量                true真    false假
  - 空常量                 null  注意：null空常量不能直接打印
- 示例代码

```java
public class ConstantDemo {
	public static void main(String[] args) {
		//字符串常量
		System.out.println("HelloWorld");
		System.out.println("黑马程序员");
		System.out.println("--------");
		
		//整数常量
		System.out.println(666);
		System.out.println(-88);
		System.out.println("--------");
		
		//小数常量
		System.out.println(13.14);
		System.out.println(-5.21);
		System.out.println("--------");
		
		//字符常量
		System.out.println('A');
		System.out.println('0');
		System.out.println('我');
		System.out.println("--------");
		
		//布尔常量
		System.out.println(true);
		System.out.println(false);
		System.out.println("--------");
		
		//空常量
		//空常量是不能直接输出的
		//System.out.println(null);
	}
}
```

#### 4.数据类型

- 计算机中的存储单位
  - 最小存储单位是字节  B
  - 1B = 8bit
  - 1KB = 1024B
  - 1MB = 1024KB
  - 1GB = 1024MB
  - 1TB = 1024GB
  - 1PB = 1024TB
  - 1EB = 1024PB
  - 1ZB = 1024EB
  - 1YB = 1024ZB
  - 1BB = 1024YB
- 数据类型
  - 基本数据类型
    - 整数类型     字节个数            值的范围
      - byte          hhh                -128 ~ 127
      - short         2
      - int           4                默认的整数类型 
      - long          8                定义long类型时，需要在值的后面加L
    - 浮点类型
      - float         4                定义float类型时，需要在值的后面加F
      - double        8                默认的小数类型
    - 字符类型
      - char          2                0 ~ 65535
    - 布尔类型
      - boolean       hhh                true   false
  - 引用数据类型(后边讲)

#### 5.java中的变量（Variable）

- 什么是变量（Variable）

  - 在程序运行过程中，其值可以发生改变

- 变量的定义格式

  - 数据类型 变量名 = 变量值;
  - 示例代码

  ```java
  public class Demo01 {
  	public static void main(String[] args) {
  		//定义一个商品的价格：99.8
  		double price = 99.8;
  		//输出价格
  		System.out.println(price);
  		
  		//促销活动。将价格调整为66.6
  		price = 66.6;
  		//输出价格
  		System.out.println(price);
  	}
  }
  ```

- 变量的注意事项

  - 变量名不能重复定义
  -  一条语句可以定义多个变量，但需要使用逗号进行分割 一条语句：java当中使用分号作为一条语句的结束.int a = 10, b = 20, c = 30;
  - 定义变量时，需要赋值。如果不赋值则不能使用！使用之前必须赋值
  - 定义long类型变量时，需要在值的后面加L
  - 定义float类型变量时，需要在值的后面加F
  - 变量的作用域 : 只在它所在的大括号中有效，当这个大括号中的代码执行完毕后, 内部所[定义]的变量就会从内存中消失


#### 6.java中的标识符

- 什么是标识符
  - 就是用来起名字的
- 组成部分
  - 大小写英文字母、数字、_、$
- 注意事项
  - 不能以数字开头
  - 不能使用关键字
  - 严格区分大小写
  - 建议起到见名知意   例如：name   age   gender   unit  price  score
- 命名规范
  - 给方法、变量起名字
    - 小驼峰命名法：如果是一个单词，全部小写。如果是多个单词，第一个单词首字母小写，其余单词首字母全部大写
  - 给类、接口起名字
    - 大驼峰命名法：如果是一个单词，首字母大写。如果是多个单词，每个单词首字母都要大写

#### 7.数据类型的转换

- 数据类型大小关系
  - byte -> short - > int -> long - > float - > double
  - char - > int -> long - > float - > double
- 隐式转换(从小到大)：不需要关心。直接写即可
- 强制转换(从大到小)：目标类型 变量名 = (目标类型)被转换的值;
- 示例代码

```java
public class Demo02 {
	public static void main(String[] args) {
		int i = 20;
		//byte b = i;
		byte b = (byte)i;
		System.out.println(b);
		
		short s = 55;
		float f = s;
		System.out.println(f);
	}
}
```







## 练习题

hhh. 过一遍笔记

2. 练习常用的DOS命令

3. 练习HelloWorld入门案例(至少练习10遍)

4. 练习注释的使用

5. 练习常量的输出

6. 练习基本数据类型四类八种的变量的定义和使用

    数据类型：hhh.基本数据类型 整数类型byte short int long /浮点类型float double/字符类型char /布尔类型boolean

   ​			2.引用数据类型

7. 练习数据类型的转换





## 面试题

- java语言的创始人是谁？

- java语言第一个发布的版本在什么时间？

- JDK和JRE的作用是什么？

- java语言的注释的作用和分类？// /* */ /** */

- 什么是关键字？关键字的特点是什么？

- 什么是常量？常量的分类有几种？

- 什么是变量？变量的定义格式是什么？ 数据类型 变量名 = 变量值；

- 

- 数据类型的分类？

- 数据类型的转换有几种方式？隐式转换从小到大  强制转换

  ​										从大到小： 目标类型 变量名 = （目标类型）值

  ​											例如：int a = （int）12.3 