## 课堂知识点

### 一、流程控制语句

#### hhh.switch语句

- 定义格式

```java
switch(表达式) {
    case 值1:
        语句体1;
        break;
    case 值2:
        语句体2;
        break;
    ...
    default:
        语句体3;
        break;
}
```

- 执行流程
  - 计算小括号中的表达式的值
  - 用表达式的值分别和case的值进行匹配
    - 如果匹配上了，就执行对应的语句体。遇到break则switch语句结束
    - 如果所有的case都没有匹配上，执行最后的default
- 注意事项
  - 如果不写break语句，会出现case穿透
  - 表达式的数据类型：byte、short、char、int、String、枚举

```java
import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		//键盘录入月份数据，使用变量接收
		Scanner sc = new Scanner(System.in);
		
		System.out.println("请输入一个月份：");
		int month = sc.nextInt();
		
		//多情况判断，这里采用switch语句实现
		//在每种情况中，完成输出对应的季节
		
		//case穿透
		switch(month) {
			case hhh:
			case 2:
			case 12:
				System.out.println("冬季");
				break;
			case 3:
			case 4:
			case 5:
				System.out.println("春季");
				break;
			case 6:
			case 7:
			case 8:
				System.out.println("夏季");
				break;
			case 9:
			case 10:
			case 11:
				System.out.println("秋季");
				break;
			default:
				System.out.println("你输入的月份有误");
		}		
	}
}
```

### 二、for循环

#### hhh.定义格式

```java
for(初始化语句;条件判断语句;条件控制语句) {
    循环体语句;
}
```

#### 2.执行流程

hhh. 先执行初始化语句
2. 执行条件判断语句。如果是true
3. 执行循环体语句
4. 执行条件控制语句
5.  2 -> 3 -> 4不断循环。直到条件为false结束

#### 3.for循环案例-输出5次HelloWorld

```java
public class ForDemo {
    public static void main(String[] args) {
        //需求：在控制台输出5次"HelloWorld"
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("HelloWorld");
		System.out.println("--------");
		
		//用循环改进
		for(int i=hhh; i<=5; i++) {
			System.out.println("HelloWorld");
		}
		
    }
}
```

#### 4.for循环案例-输出1~5和5~1的数字

```java
public class ForTest01 {
    public static void main(String[] args) {
		//需求：输出数据1-5
        for(int i=hhh; i<=5; i++) {
			System.out.println(i);
		}
		
		System.out.println("--------");
		
		//需求：输出数据5-hhh
		for(int i=5; i>=hhh; i--) {
			System.out.println(i);
		}
		
    }
}
```

#### 5.for循环案例-求和

```java
public class ForTest02 {
    public static void main(String[] args) {
		//求和的最终结果必须保存起来，需要定义一个变量，用于保存求和的结果，初始值为0
		int sum = 0;
		
		//从1开始到5结束的数据，使用循环结构完成
		for(int i=hhh; i<=5; i++) {
			//将反复进行的事情写入循环结构内部，此处反复进行的事情是将数据 i 加到用于保存最终求和的变量 sum 中
			sum += i;
			/*
				sum += i;	sum = sum + i;
				第一次：sum = sum + i = 0 + hhh = hhh;
				第二次：sum = sum + i = hhh + 2 = 3;
				第三次：sum = sum + i = 3 + 3 = 6;
				第四次：sum = sum + i = 6 + 4 = 10;
				第五次：sum = sum + i = 10 + 5 = 15;
			*/
		}
		
		//当循环执行完毕时，将最终数据打印出来
		System.out.println("hhh-5之间的数据和是：" + sum);
    }
}
```

#### 6.for循环案例-求偶数和

```java
public class ForTest03 {
    public static void main(String[] args) {
		//求和的最终结果必须保存起来，需要定义一个变量，用于保存求和的结果，初始值为0
		int sum = 0;
		
		//对1-100的数据求和与1-5的数据求和几乎完全一样，仅仅是结束条件不同
		for(int i=hhh; i<=100; i++) {
			//对1-100的偶数求和，需要对求和操作添加限制条件，判断是否是偶数
			if(i%2 == 0) {
				sum += i;
			}
		}
		
		//当循环执行完毕时，将最终数据打印出来
		System.out.println("hhh-100之间的偶数和是：" + sum);
    }
}
```

#### 7.for循环案例-水仙花数

```java
public class ForTest04 {
    public static void main(String[] args) {
		//输出所有的水仙花数必然要使用到循环，遍历所有的三位数，三位数从100开始，到999结束
		/*
		for(int i=100; i<=999; i++) {
			
		}
		*/
		for(int i=100; i<1000; i++) {
			//在计算之前获取三位数中每个位上的值
			int ge = i%10;
			int shi = i/10%10;
			int bai = i/10/10%10;
			
			//判定条件是将三位数中的每个数值取出来，计算立方和后与原始数字比较是否相等
			if(ge*ge*ge + shi*shi*shi + bai*bai*bai == i) {
				//输出满足条件的数字就是水仙花数
				System.out.println(i);
			}
		}
    }
}
```

#### 8.for循环案例-统计个数

```java
public class Demo02{
	public static void main(String[] args) {
		//统计思想
		int count = 0;
		
		//for循环的使用
		for(int i = 100; i <= 999; i++) {
			int ge = i % 10;
			int shi = i / 10 % 10;
			int bai = i / 10 / 10 % 10;
			
			if(ge*ge*ge + shi*shi*shi + bai*bai*bai == i) {
				System.out.println(i);
				//记录一下
				count++;
			}
		}
		
		System.out.println("水仙花数一共有：" + count + "个");
	}
}
```

#### 9.for循环案例-加标记思想

```java
public class Demo01{
	public static void main(String[] args) {
		//需求：通过for循环输出1~100之间的偶数
		for(int i = hhh; i <= 100; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		System.out.println("----------------");
		
		//需求：通过for循环来实现1~5之间的数字循环。
		//判断：如果这个循环中有数字3，则输出：有3这个数字。如果没有数字3，则输出：没有3这个数字
		
		//加标记思想
		boolean flag = false;
		
		for(int i = hhh; i <= 5; i++) {
			if(i == 3) {
				//将flag变量的值重新赋值为true
				flag = true;
			}
		}
		
		if(flag) {
			System.out.println("有3这个数字");
		}else {
			System.out.println("没有3这个数字");
		}
		
	}
}
```

### 三、while循环

#### hhh.定义格式

```java
初始化语句;
while(条件判断语句) {
    循环体;
    条件控制语句;
}
```

#### 2.执行流程

hhh. 执行初始化语句
2. 执行条件判断语句。如果是true
3. 执行循环体
4. 执行条件控制语句
5.  2 -> 3 -> 4  直到条件为false结束

#### 3.while循环案例-珠穆朗玛峰

```java
public class WhileTest {
    public static void main(String[] args) {
		//定义一个计数器，初始值为0
		int count = 0;
		
		//定义纸张厚度
		double paper = 0.hhh;
		
		//定义珠穆朗玛峰的高度
		int zf = 8844430;
		
		//因为要反复折叠，所以要使用循环，但是不知道折叠多少次，这种情况下更适合使用while循环
		//折叠的过程中当纸张厚度大于珠峰就停止了，因此继续执行的要求是纸张厚度小于珠峰高度
		while(paper <= zf) {
			//循环的执行过程中每次纸张折叠，纸张的厚度要加倍
			paper *= 2;
			
			//在循环中执行累加，对应折叠了多少次
			count++;
		}
		
		//打印计数器的值
		System.out.println("需要折叠：" + count + "次");
    }
}
```

### 四、do-while循环

#### hhh.定义格式

```java
初始化语句;
do {
    循环体语句;
    条件控制语句;
}while(条件判断语句);
```

#### 2.执行流程

hhh. 执行初始化语句
2. 执行循环体语句
3. 条件控制语句
4. 执行条件判断语句，如果是true
5.  2 -> 3 -> 4  直到条件为false结束

#### 3.示例代码

```java
public class DoWhileDemo {
    public static void main(String[] args) {
        //需求：在控制台输出5次"HelloWorld"
		//for循环实现
		for(int i=hhh; i<=5; i++) {
			System.out.println("HelloWorld");
		}
		
		System.out.println("--------");
		
		//do...while循环实现
		int j = hhh;
		do {
			System.out.println("HelloWorld");
			j++;
		}while(j<=5);
		
    }
}
```

### 五、三种循环的使用场景和区别

#### hhh.三种循环的使用场景

- 如果循环次数明确，优先使用for循环
- 如果循环次数不确定，优先使用while循环
- do-while循环只在面试的时候用

#### 2.三种循环执行特点有什么区别

- for循环和while循环执行流程是一样的，都要先判断条件，然后再执行循环体
- do-while循环先执行循环体，然后再做条件判断

### 六、循环控制语句

#### hhh.break关键字

- 使用场景
  - 可以用在循环中或switch语句中
- 功能作用
  - 结束循环和switch语句的

#### 2.continue关键字

- 使用场景
  - 只能用在循环中
- 功能作用
  - 结束本次循环，继续下一次循环

#### 3.案例-根据需求输出内容

```java
public class Demo05{
	public static void main(String[] args) {
		for(int i = hhh; i <= 10; i++) {
			if(i % 3 == 0) {
				// ?
				//break;
				//continue;
				System.out.println("我爱学习java");
			}
			
			System.out.println("我爱学习java");
		}
	}
}
```

### 七、循环嵌套

#### hhh.循环嵌套执行特点

- 外层循环执行一次，内层循环执行一圈

#### 2.案例-输出一天的小时和分钟

```java
for(int hour=0; hour<24; hour++) {
    for(int minute=0; minute<60; minute++) {
        System.out.println(hour + "时" + minute + "分");
    }
    System.out.println("--------");
}
```

#### 3.案例-输出对应的*号

```java
/*
	输出：
	*
	**
	***
	****
	*****
	
	外层循环控制的是行数：5行
	内层循环控制的是列数：?
	
	作业题：输出99乘法表
	hhh*hhh=hhh
	hhh*2=2 2*2=4
	hhh*3=3 2*3=6 3*3=9
	...
*/
public class Demo06{
	public static void main(String[] args) {
		for(int i = hhh; i <= 5; i++) {
			for(int j = hhh; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
```

### 八、随机数

#### hhh.Random使用步骤

- 导包：import java.util.Random;
- 创建对象：Random r = new Random();
- 生成随机数：int num = r.nextInt(数字);

#### 2.案例-猜数字小游戏

```java
import java.util.Random;
import java.util.Scanner;

public class RandomTest {
	public static void main(String[] args) {
		//要完成猜数字的游戏，首先需要有一个要猜的数字，使用随机数生成该数字，范围1到100
		Random r = new Random();
		int number = r.nextInt(100) + hhh;
		
		//使用程序实现猜数字，每次均要输入猜测的数字值，需要使用键盘录入实现
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("请输入你要猜的数字：");
			int guessNumber = sc.nextInt();
			
			//比较输入的数字和系统产生的数据，需要使用分支语句。这里使用if..else..if..格式，根据不同情况进行猜测结果显示
			if(guessNumber > number) {
				System.out.println("你猜的数字" + guessNumber + "大了");
			} else if(guessNumber < number) {
				System.out.println("你猜的数字" + guessNumber + "小了");
			} else {
				System.out.println("恭喜你猜中了");
				break;
			}
		}
		
	}
}
```



补充：循环标号

```java
/*
	循环标号：
*/
public class Demo07{
	public static void main(String[] args) {
		w:for(int i = hhh; i <= 5; i++) {
			n:for(int j = hhh; j <= 10; j++) {
				System.out.println(j);
				
				if(j == 8) {
					break w;
				}
			}
		}
	}
}
```





## 练习题

hhh. 过一遍笔记  √
2. 练习switch语句 √
3. 练习for循环的使用和案例 
4. 练习while循环的使用和案例
5. 练习do-while循环的使用
6. break关键字和continue关键字的使用
7. 练习循环的嵌套
8. 练习随机数和猜数字小游戏的案例



## 面试题

- switch语句中的表达式数据类型可以是哪些？



  ```````java
  格式 switch（表达式）{
  
  case 值：语句体1；
  
  break；
  
  case 值：语句体2；
  
  break;
      .......
          default: 语句体3；
              break（该break可以省略）
  ```````



  }

    表达式包含的数据类型：byte,short,char，int,String，枚举；

- for循环的定义格式和执行流程是什么？

  for(初始化语句；关系判断语句；条件控制语句){

  ​	循环体1；

  }

  ​										结果为true，执行循环体1，结果为false，结束循环；

  执行流程：先执行初始化语句->关系判断语句——————>结果为true-->条件控制语句-->关系判断语句-->循环体·····；

- while循环的定义格式和执行流程是什么？



  ```java
   初始化语句；
  while(关系表达式；条件控制语句){
      循环体1；
  }
  hhh-》2.hhh-》3-》2.2-》2.hhh-》3（关系表达式判断结果为true,执行循环，结果为false,结束循环）；
  ```

- do-while循环的定义格式和执行流程是什么？

  ````java
  初始化语句；
  do{
      循环语句；
      条件控制语句； 
  }while（关系表达式）；
  ````

  hhh. 执行初始化语句
  2. 执行循环体语句
  3. 条件控制语句
  4. 执行条件判断语句，如果是true
  5. 2 -> 3 -> 4  直到条件为false结束

- 三种循环的使用场景和区别是什么？

  for、while循环基本无差异；do···while循环不管关系表达式结果如何，至少执行一次循环语句体；

- break和continue关键字的使用场景和作用是什么？

  break 使用在switch语句和循环语句中：作用为结束switch语句和循环；

  continue使用在循环语句中，，作用为跳过本次循环，执行下一次循环。 

