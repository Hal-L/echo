### 1.1

请使用继承Thread类的方式定义一个线程类，在run()方法中使用循环变量i遍历1--1000所有的数字。

定义main()方法，启动这个线程，然后再使用循环变量k遍历1--1000所有的数字。

请观察控制台打印，i和k交叉打印的情况

```java
public class H11 {
    public static void main(String[] args) {
        // 启动自定义线程
        new H11Thread().start();

        // 主线程输出
        for (int k = 0; k < 1000; k++) {
            System.out.println("main:"+k);
        }
    }
}

class H11Thread extends Thread{
    @Override
    public void run() {
        // 自定义线程输出
        for (int i = 0; i < 1000; i++) {
            System.out.println("h11:"+i);
        }
    }
}
```

### 1.2

请使用实现Runnable接口的方式定义一个类，在run()方法中使用循环变量i遍历1--1000所有的数字。

定义main()方法，启动这个线程，然后再使用循环变量k遍历1--1000所有的数字。

请观察控制台打印，i和k交叉打印的情况。

```java
public class H12 {
    public static void main(String[] args) {
        // 启动自定义线程
        new Thread(new H12Task()).start();

        // 主线程输出
        for (int k = 0; k < 1000; k++) {
            System.out.println("main:" + k);
        }
    }
}

class H12Task implements Runnable {
    @Override
    public void run() {
        // 自定义线程输出
        for (int i = 0; i < 1000; i++) {
            System.out.println("h11:" + i);
        }
    }
}
```

### 1.3

请使用继承Thread类的方式定义一个线程类，在run()方法中循环10次，每1秒循环1次，每次循环按“yyyy-MM-dd HH:mm:ss”的格式打印当前系统时间。

请定义测试类，并定义main()方法，启动此线程，观察控制台打印。

```java
public class H13 {
    public static void main(String[] args) {
        new H13Thread().start();
    }
}

class H13Thread extends Thread {
    // 注意 SimpleDateFormat 不是线程安全，现在是一个线程使用它因此没有并发问题
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // 间隔 1s
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 按格式输出当前时间
            System.out.println(sdf.format(new Date()));
        }
    }
}
```



### 1.4

请使用继承Thread类的方式定义两个线程，一个线程可以计算1--100所有数字的累加和，另一个线程可以计算1--1000所有数字的累加和，每个线程计算完毕后各自打印计算结果，格式例如：”xxx线程计算1--100的累加和，结果：xxxx”

请定义测试类，并定义main()方法，启动两个线程，观察控制台打印结果。

```java
public class H14 {
    public static void main(String[] args) {
        new H14ThreadSum100().start();
        new H14ThreadSum1000().start();
    }
}

class H14ThreadSum100 extends Thread {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + "线程计算1--100的累加和，结果：" + sum);
    }
}

class H14ThreadSum1000 extends Thread {
    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 1000; i++) {
            sum += i;
        }
        System.out.println(Thread.currentThread().getName() + "线程计算1--1000的累加和，结果：" + sum);
    }
}
```



### 2.1

请使用“匿名Thread”子类的方式实现线程，线程中计算1--100所有数字的累加和，并打印计算结果。

```java
public class H21 {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }
                System.out.println(sum);
            }
        }.start();
    }
}
```



### 2.2

请使用“匿名Runnable”子类的方式实现线程，线程中计算1--500所有数字的累加和，并打印计算结果

```java
public class H22 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }
                System.out.println(sum);
            }
        }).start();
    }
}
```

### 题目3（加强训练）

模拟实现一个定时器，每隔1秒输出一下表示当前时间的字符串

#### 训练目标

能够正确使用线程状态中睡眠sleep方法

#### 训练提示

因为要每隔1秒都输出一个表示当前时间的字符串，所以需要使用循环；

因为每隔一秒才输出一次，所以要在循环中使用线程休眠技术，让线程休眠1秒；

因为要输出一个表示当前时间的字符串，所以需要使用到时间日期类技术

#### 参考方案

使用Thread中的sleep方法

#### 操作步骤

1.创建SimpleDateFormat对象，确定日期被格式化的格式

2.使用循环，在循环中调用Thread的sleep方法，让线程休眠1s后打印当前时间的字符串

#### 参考答案

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        // 因为要每隔1秒都输出一个表示当前时间的字符串，所以需要使用循环；
        // 因为每隔一秒才输出一次，所以要在循环中使用线程休眠技术，让线程休眠1秒；
        // 因为要输出一个表示当前时间的字符串，所以需要使用到时间日期类技术
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日，HH点mm分ss秒");
        while (true) {
            Thread.sleep(1000);
            System.out.println(sdf.format(new Date()));
        }
    }
}
```

#### 

### 题目4（加强训练）

开启三个线程，分别执行以下三个运算，并将运算结果输出到控制台。 

一个线程计算10! 

一个线程计算5! 

一个线程计算8!

注：n!=n*(n-1)*(n-2)*……*1

#### 训练目标

使用3个不同的线程分别计算3个不同数字的阶乘

#### 训练提示

自定义线程，重写run方法，实现需求。在测试类中开启线程，测试结果。

#### 参考方案

1.创建线程类，并重写run()方法，在run()中使用循环，计算参数的阶乘并获取当前线程的名称。

2.在测试类中，开启三个线程，并传入相应的参数。

#### 操作步骤

1.定义线程类CountThread，继承Thread类；

​	a)定义私有属性num，并提供构无参和满参构造方法。

​	b)重写run()方法，在run()方法中：

​		i)定义sum，接受某个数值的阶乘，并赋值为1

​		ii)使用for循环，计算出num的继承并赋值给sum

​		iii)获取当前线程的名字，并在控制台打印当前线程对应的数字的阶乘值。

2.定义测试类，在测试类中，开始3个线程，并分别传入参数10,5,8。

#### 参考答案

```java
public class Test04 {
    public static void main(String[] args) {
        // 创建三个线程分别计算指定数的阶乘
        new CountThread(10).start();
        new CountThread(5).start();
        new CountThread(8).start();
    }
}
class CountThread extends Thread{
    // 接收外面传递的数字
    private int num;

    public CountThread(int num) {
        this.num = num;
    }

    public CountThread() {
    }

    @Override
    public void run() {
        int sum = 1;
        // 计算num的阶乘
        for (int index = num; index >= 1; index--) {
            sum *= index;
        }
        // 获得当前线程
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " 计算 " + num + "的阶乘结果为：" + sum);
    }
}
```

### 题目5（加强训练）

有100个限量版的水杯，但是只能通过实体店和官网才能进行购买，并且分别统计卖了多少。请用线程进行模拟并设置线程名称用来代表售出途径，再将信息打印出来。比如（实体店卖出第1个，总共剩余n个..）

#### 训练目标

线程安全

#### 训练提示

1、实体店和官网分别代表两个线程，共同卖100个水杯。

#### 参考方案

课堂Demo，模拟多线程售票程序

#### 操作步骤

1、自定义类Seller，实现Runnable接口。

2、里面定义成员属性：int  count = 100;，模拟100个水杯；

3、重写run()方法，编写无限循环，模拟给两个线程分发杯子；

4、编写测试类，创建一个Seller类对象。再创建两个线程对象，分别模拟实体店和官网。

​      并将Seller对象传入两个线程。

5、启动两个线程。

#### 参考答案

~~~java
class Seller implements Runnable {
    // 有100个限量版的水杯
    private int count = 100;
    public void run() {
        // 获取当前线程的名字
        String name = Thread.currentThread().getName();
        // 定义变量统计卖出去的个数
        int sellCount = 0;
        // 开启循环卖票
        while(true) {
            synchronized(this) {
                if(count > 0) {
                    // 每卖出一个count-1
                    count--;
                    // 线程每卖出一个把卖出的数量+1
                    sellCount ++;
                    // 卖出第1个，总共剩余n个.
                    System.out.println(name +"卖出第"+sellCount+"个,总共剩余"+count+"个");
                }else{
                    break;
                }
            }

            // 为了更好看到竞争资源,睡一小下
         /*try {
            Thread.sleep(10);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }*/
        }
    }
}
public class Demo02 {
    public static void main(String[] args) {
        // 创建一个卖水杯的Runnable接口实现类
        Seller seller = new Seller();
        // 创建实体店的线程
        Thread t1 = new Thread(seller, "实体店");
        // 创建官网的线程
        Thread t2 = new Thread(seller,"官网");
        // 实体店开始卖水杯
        t1.start();
        // 官网开始卖水杯
        t2.start();
    }
}

~~~
