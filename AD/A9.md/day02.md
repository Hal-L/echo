## 课堂知识点

### 一、运算符
-运算符：对[常量]或[变量]进行操作的符号

#### hhh.算数运算符

- +加法
- -减法
- *乘法
- /除法(整数相除，只能得到整数的结果。要想得到小数，参与运算必须有一方是小数)
- %(取模):取余数

```java
public class OperatorDemo01 {
	public static void main(String[] args) {
		//定义两个变量
		int a = 6;
		int b = 4;
		
		System.out.println(a + b);
		System.out.println(a - b);
		System.out.println(a * b);
		System.out.println(a / b);
		System.out.println(a % b);
		//除法得到的是商，取余得到是余数
		
		//整数相除只能得到整数，要想得到小数，必须有浮点数的参与
		System.out.println(6.0 / 4);
	}
}
```

- ++自增   变量自身+hhh

- --自减   变量自身-hhh

  - 单独使用：++和--放在变量的前面和后面都是一样的效果。都是让变量自增或自减

  - 参与运算使用：

    - 如果++或--放在变量的前面，是先对该变量做自增(++)或者自减(--)然后再拿变量参与操作
    - 如果++或--放在变量的后面，先将该变量原本的值，取出来参与操作，随后再进行自增(++)，自减(--)。
    - 示例代码

    ```java
    public class Demo03{
    	public static void main(String[] args) {
    		int num = 10;
    		num++;
    		System.out.println(num);	// 11
    		++num;
    		System.out.println(num);	// 12
    		--num;
    		System.out.println(num);	// 11
    		num--;
    		System.out.println(num);	// 10
    		
    		int i = 10; // 10
    		//  sum =  10   +  10   +  100
    		int sum = (i++) + (--i) + (i*10);
    		System.out.println("i:" + i);		// 10
    		System.out.println("sum:" + sum);	// 120
    	}
    }
    ```

#### 2.字符参与+号运算

- 字符参与运算时，会使用对应的码表值来运算
- 'A' 65     'a' 97    '0' 48
- 不同数据类型在参与运算时，数据类型转换规则
  - byte、short、char->int->long->float->double
- 示例代码

```java
public class OperatorDemo02 {
	public static void main(String[] args) {
		//定义两个变量
		int i = 10;
		char c = 'A'; //'A'的值是65
		c = 'a'; //'a'的值是97
		c = '0'; //'0'的值是48
		System.out.println(i + c);
		
		//char ch = i + c;
		//char类型会被自动提升为int类型
		int j = i + c;
		System.out.println(j);
		
		//int k = 10 + 13.14;
		double d = 10 + 13.14;
	}
}
```

#### 3.字符串参与+号运算

- 字符串和任何数据类型用+号连接，都会组成一个新的字符串
- 当 + 操作中出现字符串时，这个 + 是[字符串连接符]，而不是算术运算。
- 字符串在前面，做的是字符串连续拼接
- 字符串在后面，先做前面的运算，然后再和字符串拼接
- 字符串可以使用 +号, 跟[任意数据类型]拼接
- 示例代码

```java
public class OperatorDemo03 {
	public static void main(String[] args) {
		System.out.println("it" + "heima");
		System.out.println("KnowledgePoints.myInterface.interFalse" + 666);
		System.out.println(666 + "KnowledgePoints.myInterface.interFalse");
		
		System.out.println("黑马" + 6 + 66);
		System.out.println(hhh + 99 + "年黑马");
	}
}
```

#### 4.赋值运算符

- = 赋值   将符号右侧的数据, 赋值给左边
- +=  将符号左右两边的数据, 做加法运算, 结果赋值给左边
- -=  进行减法运算，然后赋值
- *= 进行乘法运算，然后赋值
- /= 进行除法运算，然后赋值
- %= 进行取余，然后赋值
- 示例代码

```java
public class Demo02{
	public static void main(String[] args) {
		int i1 = 10;
		int i2 = 20;
		i1 += i2;
		System.out.println("i1:" + i1);	// 30
		
		byte b1 = 5;
		int i3 = 10;
		b1 += i3;
		System.out.println("b1:" + b1);	// 15
		
		short s1 = 3;
		byte b2 = 6;
		s1 = (short)(s1 + b2);
		System.out.println("s1:" + s1);	// 9
		
		//常量优化机制。会判断值是否超出取值范围。
		byte bb = 6 + 4;
		System.out.println("bb:" + bb);	// 10
		
		short ss = 3 + 2;
		System.out.println("ss:" + ss);	// 5
	}
}
```

#### 5.比较(关系)运算符

- 大于    >
- 小于    <
- 大于等于   >=
- 小于等于    <=
- 相等       ==
- 不等于    !=
- 示例代码

```java
public class OperatorDemo {
	public static void main(String[] args) {
		//定义变量
		int i = 10;
		int j = 20;
		int k = 10;
		
		//==
		System.out.println(i == j);
		System.out.println(i == k);
		System.out.println("--------");
		
		//!=
		System.out.println(i != j);
		System.out.println(i != k);
		System.out.println("--------");

		//>
		System.out.println(i > j);
		System.out.println(i > k);
		System.out.println("--------");
		
		//>=
		System.out.println(i >= j);
		System.out.println(i >= k);
		System.out.println("--------");
		
		//不小心把==写成了=
		//把j的值赋值给了i，然后输出i的值
		System.out.println(i = j);
	}
}
```

#### 6.逻辑运算符

- &(与)  并且, 遇false则false, 只有符号左右两边同时为true, 结果才为true.
- |(或)  或者, 遇true则true, 只有符号左边两边同时为false, 结果才为false
- ^(异或)   相同为false，不同为true    ^
- !(非)     取反 
- &&(短路与)：  如果左边是false，右边就不执行了
- ||(短路或)：  如果左边是true，右边就不执行了

& : 无论符号左边是true还是false, 右边都要继续执行

&& : 具有短路效果, 符号左边为false的时候, 右边就不执行了.如果符号左边为true, 右边要继续执行.

- 示例代码

```java
public class Demo05{
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 20;
		
		/*
		boolean b1 = (++num1 > 15) && (num2++ > 15);
		System.out.println("num1:" + num1);	// 11
		System.out.println("num2:" + num2);	// 20
		System.out.println("b1:" + b1);		// false
		*/
		
		/*
		boolean b2 = (++num1 > 10) || (num2++ > 15);
		System.out.println("num1:" + num1);	// 11
		System.out.println("num2:" + num2);	// 20
		System.out.println("b2:" + b2);		// true
		*/
		
		System.out.println((++num1 > 10));	// true
		System.out.println(!(++num1 > 10));	// false
	}
}
```

#### 7.三元运算符

- 定义格式
  - (关系表达式) ? 表达式1 : 表达式2;
- 执行流程
  - 首先计算关系表达式的值 则取表达式1的值
  - 如果结果为true，取表达式1的值
  - 如果值为false，取表达式2的值
- 示例代码

```java
public class Demo06{
	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;
		
		//int result = (num1 > num2) ? num1 : num2;
		//System.out.println(result);
		
		boolean result = (num1 == num2) ? true : false;
		System.out.println(result);	
	}
}
```

### 二、键盘录入

- 导包：需要写在class的上面  import java.util.Scanner;
- 创建对象：Scanner sc = new Scanner(System.in);只有sc可以改变, 其他属于固定格式
- 接收数据：使用变量接受数据 int i = sc.nextInt();只有i变量可以改变, 其他属于固定格式
- 示例代码

```java
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		//创建对象
		Scanner sc = new Scanner(System.in);
		
		//使用变量接收数据
		int x = sc.nextInt();
		
		//输出数据
		System.out.println("x:" + x);
	}
}
```

- 案例：键盘输入三个数据，获取最大值

```java
//hhh.导包
import java.util.Scanner;
public class Demo07{
	public static void main(String[] args) {
		//2.创建对象
		Scanner sc = new Scanner(System.in);
		
		//3.接收数字
		System.out.println("请输入第一个数字：");
		int num1 = sc.nextInt();
		System.out.println("请输入第二个数字：");
		int num2 = sc.nextInt();
		System.out.println("请输入第三个数字：");
		int num3 = sc.nextInt();
		
		//4.获取最大值
		int temp = (num1 > num2) ? num1 : num2;
		int max = (temp > num3) ? temp : num3;
		
		//5.输出结果
		System.out.println("最大值是：" + max);
	}
}
```

### 三、流程控制语句

#### hhh.顺序结构

- 顺序结构就是按照我们定义的顺序来执行

#### 2.if语句

- 定义格式

```java
if(关系表达式) {
    语句体;
}
```

- 执行流程
  - 首先计算关系表达式的值
  - 如果关系表达式的值为true就执行语句体
  - 如果关系表达式的值为false就不执行语句体
  - 继续执行后面的语句内容
- 案例-判断是否成年

```java
public class Demo08{
	public static void main(String[] args) {
		
		//定义一个年龄变量
		int age = 17;
		
		System.out.println("今天天气不错啊，正在压马路~");
		
		if(age >= 18) {
			System.out.println("突然发现一个快乐的地方：网吧");
			System.out.println("进去开黑~~");
			System.out.println("遇到了一帮猪队友,很生气。下机");
		}
		
		System.out.println("回家吃饭");
	}
}
```

- 案例-判断两个数字是否相等

```java
public class Demo09{
	public static void main(String[] args) {
		int num1 = 20;
		int num2 = 20;
		
		System.out.println("开始");
		
		//如果相同，在控制台输出：相等
		if(num1 == num2) {
			System.out.println("相等");
		}
		
		System.out.println("结束");
	}
}
```

#### 3.if-else语句

- 定义格式

```java
if(关系表达式) {
    语句体1;
}else {
    语句体2;
}
```

- 执行流程
  - 判断关系表达式的值。如果为true，则执行语句体1
  - 如果为false，则执行语句体2
- 案例-判断a的值是否大于b

```java
public class IfDemo02 {
	public static void main(String[] args) {
		System.out.println("开始");
		
		//定义两个变量
		int a = 10;
		int b = 20;
		
		//需求：判断a是否大于b，如果是，在控制台输出：a的值大于b，如果不是，在控制台输出：a的值不大于b
		if(a > b) {
			System.out.println("a的值大于b");
		} else {
			System.out.println("a的值不大于b");
		}
		
		System.out.println("结束");
	}
}
```

- 案例-键盘录入数字判断是奇偶数

```java
import java.util.Scanner;
public class IfTest01 {
	public static void main(String[] args) {
		//为了体现任意给出一个整数，采用键盘录入一个数据。(导包，创建对象，接收数据)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个整数：");
		int number = sc.nextInt();
		
		//判断整数是偶数还是奇数要分两种情况进行判断，使用if..else结构		
		//判断是否偶数需要使用取余运算符实现该功能 number % 2 == 0
		//根据判定情况，在控制台输出对应的内容
		if(number%2 == 0) {
			System.out.println(number + "是偶数");
		} else {
			System.out.println(number + "是奇数");
		}
	}
}
```

#### 4.if-else if语句

- 定义格式

```java
if(关系表达式1) {
    语句体1;
}else if(关系表达式2) {
    语句体2;
}
...
 else {
     语句体n+hhh;
 }
```

- 执行流程
  - 判断关系表达式1的值，如果为true，执行语句体1.如果为false
  - 继续判断关系表达式2的值，如果为true，执行语句体2.如果为false
  - 当所有的关系表达式都不满足的情况下，执行最后的else里面的语句体n+hhh
- 案例-考试奖励

```java
import java.util.Scanner;

public class IfTest02 {
	public static void main(String[] args) {
		//小明的考试成绩未知，可以使用键盘录入的方式获取值
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个分数：");
		int score = sc.nextInt();
		
		//由于奖励种类较多，属于多种判断，采用if...else...if格式实现
		//为每种判断设置对应的条件
		//为每种判断设置对应的奖励
		/*
		if(score>=95 && score<=100) {
			System.out.println("山地自行车一辆");
		} else if(score>=90 && score<=94) {
			System.out.println("游乐场玩一次");
		} else if(score>=80 && score<=89) {
			System.out.println("变形金刚玩具一个");
		} else {
			System.out.println("胖揍一顿");
		}
		*/
		
		//数据测试：正确数据，边界数据，错误数据
		/*if(score>100 || score<0) {
			System.out.println("你输入的分数有误");
		} else if(score>=95 && score<=100) {
			System.out.println("山地自行车一辆");
		} else if(score>=90 && score<=94) {
			System.out.println("游乐场玩一次");
		} else if(score>=80 && score<=89) {
			System.out.println("变形金刚玩具一个");
		} else {
			System.out.println("胖揍一顿");
		}*/
		
		if(score>=95 && score<=100) {
			System.out.println("山地自行车一辆");
		} else if(score>=90 && score<=94) {
			System.out.println("游乐场玩一次");
		} else if(score>=80 && score<=89) {
			System.out.println("变形金刚玩具一个");
		} else if(score >= 0 && score < 80){
			System.out.println("胖揍一顿");
		} else {
			System.out.println("你输入的分数有误");
		}
	}
}
```





## 练习题

hhh. 过一遍笔记  √ 
2. 练习算术运算符  √
3. 练习字符和字符串参与+号使用  √
4. 练习赋值运算符  √
5. 练习关系运算符  √
6. 练习逻辑运算符   √
7. 练习三元运算符 √
8. 练习键盘输入数据
9. 练习if语句三种格式  √



## 面试题

- 算数运算符有哪些？
- 字符参与+号运算底层是什么原理？ 
- 字符串参与+号运算规则？
- 赋值运算有哪些？
- 关系运算符有哪些？
- 逻辑运算符有哪些？
- 三元运算符的定义格式和执行流程是什么？
- 键盘录入数据有几个步骤？
- if语句的定义格式和执行流程是什么？下·下·