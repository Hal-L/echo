#### 昨日反馈

```
老师，视频里的内容您没必要再敲一遍，视频可以开加速模式，练习的时间可以稍微多一点。

给老师几点建议,希望采纳: 1. 每一小节视频的总结中,提炼核心就好,不用往后面铺垫,不然听着很懵 2. 总结后,希望能给我们几分钟的练习时间,不然好几节累积下来再让我们练,有时会没思路,效果很差 3. 希望在早上第三节上课之前和下午第三节上课之前,能抽出五分钟来给我们做个眼保健操,毕竟保护视力是很重要的

广播声音稍微再小一点!
重点用红色字体体现一下

付栋老师你好，我觉得你的教学内容很好，非常适合我们这个阶段的学习，对学习帮助很大，但是有几点小意见希望能得到回复： 1.开车虽然很能提高同学们的注意力，但是希望别太快了，班级里还有女生； 2.知识点的讲解希望不要在课堂上做MD文件的笔记了，可以提前做好，上课给我们讲解一下就好，如果希望加深印象，让我们自己做笔记也可以，因为老师在做课堂笔记的时候会有些地方反而分散注意力； 其他的内容都挺好，包括课前的一些小视频，也比较放松心情

栋哥,上课过程中,视频中已经演示过的代码,可以适当少点演示,以便可以留点时间,让我们自己敲一敲!谢谢

内容有点多，还没有掌握好，希望增加上课练习的时间
付老师 课上练习的时间能多给一点么; 速度太快了 我有点受不了 脑子跟上了 身体跟不上;
```

#### 昨日回顾

```
实现线程的3种方式  
线程的安全问题及解决   
	同步代码块和同步方法的区别
            同步代码块可以锁住指定代码, 同步方法是锁住方法当中所有代码
            同步代码块可以指定锁对象, 同步方法不能指定锁对象
等待唤醒  
	wait()   
	notify() 
   注意 
	这几个方法都是属于Object类的方法,必须要由同一个锁对象调用,必须要在同步代码块或者同步方法中调用
	
加锁的目的:保证正在执行的线程不会被其他线程夺取执行权,也就是同一时间内只有一个线程执行     
使用wait和notify的目的:是为了让线程有规律的交替执行

生产者和消费者
    1,实现最基本的功能
        死循环打印厨师生产汉堡包和吃货消费汉堡包
    2,实现数量的控制
        定义一个共享的变量.然后用这个变量控制线程执行的次数
    3,保证每个线程在执行的时候,不要被其他线程抢去执行权
        加锁
    4,实现线程有规律的执行
    	使用wait和notify,及标记
```

#### 线程状态

##### 1. 六种状态

```
new 新建状态				创建出线程对象的时候
Runnable 就绪,可运行状态	  调用了start()方法
Blocked 锁阻塞状态		    在等待锁的时候
waiting 无限等待状态		   在调用wait()的时候
Timed waiting 计时等待状态   在调用sleep()的时候
Terminated  死亡状态   		 在run()执行之后
```

##### 2 状态演示

```java
public static void main(String[] args) throws InterruptedException {

	Thread t = new Thread(()->{
		System.out.println("2:创建的t线程,执行start方法后,线程的状态:"+Thread.currentThread().getState());

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("4:创建的t线程执行sleep方法后,线程的状态:"+Thread.currentThread().getState());
	});

	System.out.println("1:创建了t线程,但是没有调用start方法的线程的状态:"+t.getState());
	t.start();

	Thread.sleep(50);//主线程休眠50毫秒

	System.out.println("3:创建的t线程在执行sleep方法的时候,线程的状态:"+t.getState());

	Thread.sleep(200);//主线程休眠200毫秒

	System.out.println("5:创建的t线程在执行完毕之后的时候,线程的状态:"+t.getState());
	
}
```

#### <font color='red'>线程池</font>

##### <font color='red'>1. 线程池的思想</font>

```
就是一个存储线程的池子(容器),用的时候去池子中取,用完归还给池子
核心思想: 以空间换时间
```

##### 2. 线程池的好处

```
第一：降低资源消耗，通过重复利用已创建的线程降低线程创建和销毁造成的消耗
第二：提高响应速度，当任务到达时任务不需要等到线程创建就能立即执行
第三：提高线程的可管理性，使用线程池进行统一的分配，调优和监控
```

##### <font color='red'>3.  线程池的使用</font>

```
1,创建线程池
	newCachedThreadPool();创建一个默认的
	
2,提交任务并执行
	submit(Runnable的实现类对象)
	
3,关闭线程池
	shutdown()
	
注意:如果任务有返回值,那么需要传入一个Callable的实现类对象
```

##### <font color='red'>4 .三种池的创建</font>

```
1,创建一个默认的线程池
	Executors.newCachedThreadPool()
	
2,创建一个指定线程数量上限的线程池
	Executors.newFixedThreadPool(int n)
	
3,自定义一个线程池对象
	new ThreadPoolExecutor(核心线程数量,最大线程数量,空闲线程最大存活时间,任务队列,创建线程工厂,任务的拒绝策略);
	
使用场景
newCachedThreadPool：
	用来创建一个可以无限扩大的线程池，如果线程池中的线程数量过大，它可以有效的回收多余的线程，如果线程数不足，那么它可以创建新的线程,虽然可以根据业务场景自动的扩展线程数来处理我们的业务，但是最多需要多少个线程同时处理缺是我们无法控制的,适用于服务器负载较轻，执行很多短期异步任务。
newFixedThreadPool：
	创建一个固定大小的线程池，不会回收线程资源,但是线程数是可以进行控制的，因此我们可以通过控制最大线程来使我们的服务器达到最大的使用率，同时又可以保证即使流量突然增大也不会占用服务器过多的资源,适用于可以预测线程数量的业务中，或者服务器负载较重，对当前线程数量进行限制。
```

##### 5. 线程池的参数

```
corePoolSize
	核心线程的最大值，不能小于0
maximumPoolSize
	最大线程数，不能小于等于0，maximumPoolSize >= corePoolSize
keepAliveTime
	空闲线程最大存活时间,不能小于0
unit
	时间单位
workQueue
	任务队列，不能为null
threadFactory
	创建线程工厂,不能为null
handler
	任务的拒绝策略,不能为null
```

##### 6. 任务拒绝策略

```
什么时候拒绝
	当线程池达到最大容量,任务队列也达到最大容量时

ThreadPoolExecutor.AbortPolicy:  丢弃任务并抛出RejectedExecutionException异常。是默认的策略。
ThreadPoolExecutor.DiscardPolicy： 丢弃任务，但是不抛出异常 这是不推荐的做法。
ThreadPoolExecutor.DiscardOldestPolicy： 抛弃队列中等待最久的任务 然后把当前任务加入队列中。
ThreadPoolExecutor.CallerRunsPolicy: 调用任务的run()方法绕过线程池直接执行
```



#### 可见性问题

##### 1. 概念

```
当一个共享的变量被多个线程使用时,其中某一个线程对共享变量进行了修改,对其他线程来说,并不是立即可见的

原因
	每个线程都会一个副本,这个副本就是第一次从共享区中获取的数据,后面再获取数据就从副本中获取
```

##### 2. 解决

```
方式一:
     使用volatile关键字,强制让线程获取数据的时候,先从共享区中获取
方式二:
	 使用同步代码块,强制线程从共享区中获取值
```



#### 原子性问题

##### 1. 概念

```
原子是组成事物的最小单位,不能在被分割了,这里是指,多句代码在执行的时候,会被其他线程所打断
```

##### 2. 解决

```
方式一:
	使用同步代码块,这样线程在执行过程中就不会被其他线程打断
方式二:
	使用原子类实现
```

##### 3. AtomicInteger

```
概述
	可以用原子方式更新的int 值
构造方法
	public AtomicInteger()
		初始化一个默认值为0的原子型Integer
	public AtomicInteger(int initialValue)
		初始化一个指定值的原子型Integer
成员方法
	int get()
		获取值
	int getAndIncrement()
		以原子方式将当前值加1，注意，这里返回的是自增前的值
	int incrementAndGet()
		以原子方式将当前值加1，注意，这里返回的是自增后的值
	int addAndGet(int data)
		以原子方式将输入的数值与实例中的值（AtomicInteger里的value）相加,并返回结果
	int getAndSet(int value)
		以原子方式设置为newValue的值，并返回旧值
```

##### 4. 悲观锁和乐观锁

```
悲观锁
	总是从最坏的角度出发,认为每次获取数据的时候,别人都有可能修改.所以在每次操作共享数据之前,都会上锁
	
乐观锁
	总是从乐观的角度出发,假设每次获取数据别人都不会修改,所以不会上锁.在修改共享数据的时候,会检查一下,别人有没有修改过这个数据.如果别人修改过,我再次获取现在最新的值.如果别人没有修改过,我现在直接修改共享数据的值
```



#### 并发工具类

##### 1. HashMap&HashTable

```
HashMap 是线程不安全的,进行put操作时存在丢失数据
HashTable 是线程安全的,它使用synchronized来锁住整张Hash表来实现线程安全，即每次锁住整张表让线程独占，相当于所有线程进行读写时都去竞争一把锁，导致效率非常低下
```

##### 2. ConcurrentHashMap

```
jdk1.7
	原理
		采用大数组包含小数组的方式实现,只对里面的小数组加锁
	弊端
		ConcurrentHashMap 定位一个元素的过程需要进行两次Hash操作，第一次 Hash 定位到 Segment(大数组)，第二次 Hash 定位到元素所在的链表的头部(小数组)，因此，这一种结构的带来的副作用是 Hash 的过程要比普通的 HashMap 要长,效率比较低
	
jdk1.8
	原理
		1,取消大数组包含小数组的方式，直接采用transient volatile HashEntry<K,V>[] table保存数据，采用table数组元素作为锁，从而实现了对每一行数据进行加锁，并发控制使用Synchronized和CAS来操作
		2,将原先table数组＋单向链表的数据结构，变更为table数组＋单向链表＋红黑树的结构.
```

##### 3. CountDownLatch

```
概述
	让某一条线程等待其他线程执行完毕之后再执行
构造方法
	public CountDownLatch(int count)
		参数传递线程数,表示等待线程数量
成员方法
	void await()
		让当前线程等待,当计数器为0的时候,会自动唤醒
	void countDown() 
		计数器减一,如果减到0的话,等待的线程就会执行
```

##### 4. Semaphore

```
概述
	控制线程的并发数量
构造方法
	public Semaphore(int permits)
		参数传递的是线程数量,表示许可数
成员方法
	void acquire()
		获取一个许可
	void release()
		释放一个许可
```

