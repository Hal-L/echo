#### 昨日反馈

```
***	老师，有IDEA快捷键的md资料吗
***	老师，可不可以抽一点时间出来讲讲ServerSocket和Socket的底层以及继承结构，上课可以多聊点代码的底层，深挖一下
***	感受到栋哥的用心,栋哥加油!有时间可以整一些综合性的需求题目,SE马上结束了,想多通过综合性的题来多练习
```

#### 昨日回顾

```
三要素 
UDP原理: 把数据分成一个个的数据包发送,有可能会出现丢包或者乱序
TCP原理:底层是IO流,建立了一个管道,比较安全
使用场景:
三次握手
四次挥手
```

#### 类加载器

##### 1.概念

```
负责将.class文件加载到内存中,并生成与之对应的Class对象
```

##### 2.分类

```
启动类加载器（Bootstrap ClassLoader）：虚拟机内置的类加载器。
平台类加载器（Platform Classloader）：负责加载JDK中一些特殊的模块。
系统类加载器（System Classloader）：负责加载用户类路径上所指定的类库。

作用
	他们每个都有自己的分工,最终目的,就是加载字节码文件到内存
```

##### 3.方法

```
public static ClassLoader getSystemClassLoader()  获取系统类加载器
public InputStream getResourceAsStream(String name) 加载某一个资源文件

InputStream pis = ClassLoader.getSystemClassLoader().getResourceAsStream("user.properties");
```

​     

#### day17类加载

##### 1.概念

```
当程序要用到某个类的时候,如果这个类还没有被加载到内存中,则系统会通过加载,连接,初始化这三步将这个类加载到内存中,这个过程就叫类加载
```

##### 2.加载时机

```
1,创建类的实例
2,访问类的静态方法 Math.ceil()
3,访问类的静态变量或者为静态变量赋值 Math.PI
4,使用反射获取Class对象
5,初始化某个类的子类 
6,直接使用java命令来运行某个主类

总结:用到就加载
```

##### 3,加载过程

```
加载
	就是将class文件读到内存中,并为之创建一个Class对象.任何类被使用的时候,系统都会为之创建一个Class对象
	
连接
	验证:是否有正确的内部结构
	准备:负责为类的静态成员分配内存,并设置默认初始化
	解析:将类的二进制数据中的符号引用替换成直接引用

初始化
	给静态变量赋值以及初始化其他资源
```

##### 4. 双亲委派

```
"双亲委派模型"中，除了顶层的启动类加载器外，其余的类加载器都应当有自己的"父级类加载器"。
		    这种关系不是通过"继承"实现的，通常是通过"组合"实现的。通过"组合"来表示父级类加载器。
"双亲委派模型"的工作过程：
	某个"类加载器"收到类加载的请求，它首先不会尝试自己去加载这个类，而是把请求交给父级类加载器。
	因此，所有的类加载的请求最终都会传送到顶层的"启动类加载器"中。
	如果"父级类加载器"无法加载这个类，然后子级类加载器再去加载。
	
好处
	双亲委派机制的一个显而易见的好处是：Java的类随着它的类加载器一起具备了一种带有优先级的层次关系。例如：java.lang.Object。它存放在rt.jar中。无论哪一个类加载器要加载这个类，最终都是委派
给处于顶端的"启动类加载器"进行加载，因此java.lang.Object类在程序的各种类加载器环境中都是同一个类。

相反，如果没有"双亲委派机制"，如果用户自己编写了一个java.lang.Object，那么当我们编写其它类时，这种隐式的继承使用的将会是用户自己编写的java.lang.Object类，那将变得一片混乱
```



#### 反射

##### 1.概念

```
反向获取  
在运行的时候,去获取一个类的变量或者方法信息然后通过获取到的信息来反向的创建对象,调用方法的一种机制.
```

##### 2.应用

```
应用在一些通用性比较高的代码 
在框架中都是基于配置文件开发,在配置文件中配置了类,就可以通过反射得到类中的所有信息,在运行的时候让类中的某个方法执行

类中的所有信息:属性,无参构造方法,带参构造方法,普通方法
```

##### 3.前提

```
获取Class对象
	对象.getClass()
	类名.class
	Class.forName("全路径")
```

##### 4.使用

###### 获取构造器

```
作用:
	反向创建对象
怎么拿到
	 getConstructor(类<?>... parameterTypes) 返回一个 Constructor对象，  
	 getConstructors()  返回一个 Constructor对象数组  
拿到之后怎么用
	newInstance(Object... initargs) 反向创建对象
```

###### 获取File字段对象

```
作用:
	反向给成员变量赋值或者取值
怎么拿到
	Field getField(String name) 返回一个 Field对象 
	Field[] getFields() 返回一个包含Field对象数组 
	Field getDeclaredField(String name) 返回一个 Field对象,可以获取私有对象
拿到之后怎么用
	void set(Object obj, Object value) 反向为对象的属性赋值
	Object get(Object obj) 反向获取对象属性的值
```

###### 获取Method方法对象

```
作用:
	反向调用方法
怎么拿到
	Method getMethod(String name, 类<?>... parameterTypes) 返回一个 方法对象 
拿到之后怎么用
	Object invoke(Object obj, Object... args) 反向调用方法

```

##### 5. 应用场景

```
1,创建一个ArrayList<Integer>的对象,在这个集合中添加一个"abc",如何实现(泛型只在编译的时候有效,运行的时候失效)

2,有如下的类
public class Cat{
	public void eat(){
	System.out.println("吃");
	}
}
使用配置文件配置全类名和方法名,然后加载配置文件,反射执行eat方法
```

#### JavaBean

##### 概念

```
实体类,主要用于封装数据
```

##### 作用

```
为什么要使用JavaBean封装数据?
   首先这是一个编程思想，也就是所谓‘面向对象’的问题。javabean本身是一个java对象，
他对数据进行的封装。我们需要访问数据的时候只要访问这个对象就可以了。(因为数据就存在这个对象里面)

   其次，如果你的方法参数比较少还好，如果多一些，比如10个,你要定义一个具有10个参数的方法吗？
还是定义一个只有一个javabean做参数的方法简单？并且用javabean做参数调用的时候也很方便,直接传一个对象
就可以了,数据都存在对象里面,想用的话直接从里面拿
```

##### 规范

```
类使用公共进行修饰
提供私有修饰的成员变量
为成员变量提供公共getter和setter方法
提供公共无参的构造
```

#### BeanUtils

##### 概念

```
Apache commons提供的一个组件,专门操作javaBean的工具类,简化我们对javaBean的操作
```

##### 方法

```
static void	setProperty(Object bean, String name, Object value)给指定的javaBean对象的属性赋值
static String	getProperty(Object bean, String name) 获取指定的javaBean对象的属性的值
static void	populate(Object bean, Map properties) 批量的为对象的属性赋值
```

##### 使用

```
1,在模块下创建一个libs文件夹,将两个jar包拖进去
	commons-logging-1.1.1.jar 和 commons-beanutils-1.8.3.jar包
2,选中libs文件夹,右键,add-as-Library,在弹框中选择Moduls Library,添加到构建路径

1,构造私有
2,方法全是静态
```
