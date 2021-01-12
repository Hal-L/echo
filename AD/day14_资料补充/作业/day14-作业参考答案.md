

### 题目1

使用线程池,分别开启三条线程,生成10个1到100的随机数,然后计算他们的平均数, 最后计算这三个平均数的平 均数.(使用Callable)

#### 训练目标

线程池

#### 训练提示

1、定义线程，工作：生成10个1--100的随机数，并计算平均数；

2、由于要启动三个线程，最后需要获取三个平均数，再计算平均数，所以需要线程返回值，因此，需要线程实现Callable接口。

#### 参考方案

使用Callable实现线程。

#### 操作步骤

1、自定义类，实现Callable线程，类型定义为：Double类型，重写call()方法，返回值为Double类型。

2、在call()方法中实现：生成10个1--100的随机数，计算平均值并返回；

3、编写main()方法，获取一个线程池对象。

4、在main()中创建一个自定义类对象；

5、使用线程池分别运行3次线程对象，并获取返回值。

6、计算三个返回值的平均值。

#### 参考答案

~~~java
class AvgCallable implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        // 生成10个1-100的随机数,然后计算他们的平均数,
        // 创建随机对象
        Random r = new Random();
        // 随机数个数
        int count = 10;
        // 声明变量累加随机数的和
        double sum = 0;
        // 循环生成10个随机数
        for (int i = 0; i < count; i++) {
            // 生成随机数
            sum += r.nextInt(100) + 1;
        }
        // 求平均数
        double avg = sum / count;
        System.out.println(Thread.currentThread().getName() + "生成的随机数平均值为：" + avg);
        return avg;
    }
}
public class Demo {

    public static void main(String[] args){
        // 创建线程池对象
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        // 提交线程任务
        Future<Double> f1 = threadPool.submit(new AvgCallable());
        Future<Double> f2 = threadPool.submit(new AvgCallable());
        Future<Double> f3 = threadPool.submit(new AvgCallable());

        try {
            double result = (f1.get() + f2.get() + f3.get()) / 3;
            // %d 整数
            // %s 字符串
            // System.out.println(result);
            System.out.println(String.format("三个数的平均数为：%.2f",result));

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        // 关闭线程池
        threadPool.shutdown();
    }
}

~~~

### 题目2

使用线程池创建多线程。模拟同学找老师学习Java。

1. 创建线程池对象，包含2个线程。从线程池中获取线程对象，然后调用MyRunnable中的run()。
2. 在MyRunnable实现类中，首先在控制台打印需求，“我需要一个老师”。模拟需要2秒钟时间老师可以过来指导学生，并在控制台打印老师的姓名。最后，在控制台打印“教我java,教完后，老师回到了办公室”；

#### 训练目标

线程安全

#### 训练提示

1、按要求自定义类MyRunnable。

2、创建线程池对象，执行两个线程。

#### 参考方案

使用线程池实现。

#### 操作步骤

1、自定义类实现Runnable接口，模拟学生。

2、在测试方法中创建线程池对象，能容纳2个核心线程。

3、线程池分两次执行自定义类，模拟两个老师为两个学生辅导。

#### 参考答案

~~~java
public class MyRunnable implements Runnable {
    @Override
    public void run() {
      System.out.println("我要一个老师");
      try {
         Thread.sleep(2000);
       } catch (InterruptedException e) {
         e.printStackTrace();
       }
       System.out.println("老师来了"+Thread.currentThread().getName());
       System.out.println("教我java,教完后，老师回到了办公室");
    }
}
public class ThreadPoolDemo {
    public static void main(String[] args) {
      // 创建线程池对象
      ExecutorService service = Executors.newFixedThreadPool(2);//包含2个线程对象
      // 创建Runnable实例对象
      MyRunnable r = new MyRunnable();
     //自己创建线程对象的方式
     // Thread t = new Thread(r);
     // t.start(); ‐‐‐>调用MyRunnable中的run()
     // 从线程池中获取线程对象,然后调用MyRunnable中的run()
     service.submit(r);
     // 再获取个线程对象，调用MyRunnable中的run()
     service.submit(r);
     service.submit(r);
     // 注意：submit方法调用结束后，程序并不终止，是因为线程池控制了线程的关闭。
    // 将使用完的线程又归还到了线程池中
    // 关闭线程池
   //service.shutdown();
  }
}

~~~

#### 

### 2.1

请使用ConcurrentHashMap定义一个线程安全的Map，使用两个线程访问它：

​	第一个线程：向集合中添加键、值都是：1--10000的数字；

​	第二个线程：向集合中添加键、值都是：10001--20000的数字；

​	确保两个线程全部操作集合完毕，然后打印集合的每个元素，测试期准确性。

```java
public class H33 {
    public static void main(String[] args) throws InterruptedException {
//        Map<Integer,Integer> map = new ConcurrentHashMap<>(); // 没有 HashMap 的问题
        Map<Integer,Integer> map = new HashMap<>(); // 有可能出现最后个数不足 20000
        Thread t1 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i <= 10000; i++) {
                    map.put(i, i);
                }
            }
        };
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 10001; i <= 20000; i++) {
                    map.put(i, i);
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());// 正确结果应当是 20000
    }
}
```



### 2.2

​	请使用CountDownLatch编写一个程序，实现以下效果：

​	线程A打印：”开始计算”

​	线程B：计算1--100所有数的累加和，并打印结果。

​	线程A打印：”计算完毕”

```java
public class H34 {
	public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始计算");
                try {
                    // Thread-0进入阻塞，等计数减为0
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"计算完毕");
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for (int i = 0; i <= 100; i++) {
                    sum+=i;
                }
                System.out.println(Thread.currentThread().getName()
                                   +"进行计算，结果为："+sum);
                // 计数减为0，可以让那边阻塞的 Thread-0 恢复运行
                latch.countDown();
            }
        }.start();
    }
}
```





### 2.3

请使用Semaphore编写一个程序，实现以下效果：有10名游客要参观展览室，而“展览室”同时只允许最多“三个游客”参观，每个游客参观时间2秒。



```java
public class H36 {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 10; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        // 获得参观权
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"开始参观"+new Date());
                        // 参观 2s
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // 释放参观权
                        semaphore.release();
                    }
                }
            }.start();
        }
    }
}
```



