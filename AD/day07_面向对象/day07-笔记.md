## 课堂知识点

### 一、面向对象

#### 1.类和对象的关系

- 什么是类
    - 具有相同属性和行为的对象的集合
    - 类就是一种抽象的广泛的概念。例如：水果类、动物类
    - 类的组成部分：
        - 属性(成员变量)：就是类中有哪些描述信息
        - 行为(成员方法)：就是类可以做哪些事情
- 什么是对象
    - 对象就是某一个类事物中的具体的体现
    - 例如：水果类-苹果、动物类-狗
- 类和对象的关系
    - 对象是根据类来创建出来的！

#### 2.定义类

- 明确类的名字
    - 见名知意
- 明确类中有哪些属性
    - 属性-成员变量
    - 数据类型 变量名;
- 明确类中有哪些行为
    - 行为-成员方法
    - 和之前的方法定义完全一致。去掉static

- 示例代码

```java
public class Phone {
    //成员变量
    String brand;
    int price;

    //成员方法
    public void call() {
        System.out.println("打电话");
    }

    public void sendMessage() {
        System.out.println("发短信");
    }
}
```

#### 3.创建对象并使用

- 创建对象的格式
    - 类名 对象名 = new 类名();
- 如何使用成员变量
    - 对象名.成员变量名
- 如何使用成员方法
    - 对象名.成员方法名();
- 示例代码

```java
public class PhoneDemo {
    public static void main(String[] args) {
        //创建对象
        Phone p = new Phone();

        //使用成员变量
        System.out.println(p.brand);
        System.out.println(p.price);

        p.brand = "小米";
        p.price = 2999;

        System.out.println(p.brand);
        System.out.println(p.price);

        //使用成员方法
        p.call();
        p.sendMessage();
    }
}
```

#### 4.学生类的定义和使用

- 学生类

```java
public class D5.DemoTostring.Student {
    //成员变量
    String name;
    int age;

    //成员方法
    public void study() {
        System.out.println("好好学习，天天向上");
    }

    public void doHomework() {
        System.out.println("键盘敲烂，月薪过万");
    }
}
```

- 测试类

```java
public class StudentDemo {
    public static void main(String[] args) {
        //创建对象
        D5.DemoTostring.Student s = new D5.DemoTostring.Student();

        //使用对象
        System.out.println(s.name + "," + s.age);

        s.name = "林青霞";
        s.age = 30;

        System.out.println(s.name + "," + s.age);

        s.study();
        s.doHomework();
    }
}
```

### 二、对象的内存图

#### 1.单个对象的内存图

![01](img\01.png)

#### 2.两个对象的内存图

![02](img\02.png)

#### 3.多个对象指向同一个内存空间

![03](img\03.png)

#### 4.成员变量和局部变量的区别

- 定义位置区别
    - 成员变量：定义在类中方法外
    - 局部变量：定义在方法内部或方法声明上
- 默认初始化值区别
    - 成员变量：有默认初始化值
    - 局部变量：没有默认初始化值。使用之前，必须赋值
- 内存位置区别
    - 成员变量：在堆内存中
    - 局部变量：在栈内存中
- 生命周期区别
    - 成员变量：随着对象的创建而创建，随着对象的消失而消失
    - 局部变量：随着方法的调用而创建，随着方法的消失而消失

### 三、封装

#### 1.private关键字

- 作用：权限修饰符(私有)。被private修饰的成员，只能在本类中访问

- 示例代码

    - 学生类

  ```java
  public class D5.DemoTostring.Student {
      //成员变量
      private String name;    // "林青霞"
      private int age;        // 30
  
      //get/set方法
      public void setName(String n) { // String n = "林青霞"
          name = n;
      }
  
      public String getName() {
          return name;
      }
  
      public void setAge(int a) { // int a = 30
          age = a;
      }
  
      public int getAge() {
          return age;
      }
  
      public void show() {
          System.out.println(name + "," + age);
      }
  }
  ```

    - 测试类

  ```java
  public class StudentDemo {
      public static void main(String[] args) {
          //创建对象
          D5.DemoTostring.Student s = new D5.DemoTostring.Student();
  
          //使用set方法给成员变量赋值
          s.setName("林青霞");
          s.setAge(30);
  
          s.show();
  
          //使用get方法获取成员变量的值
          System.out.println(s.getName() + "---" + s.getAge());
          System.out.println(s.getName() + "," + s.getAge());
  
      }
  }
  ```

#### 2.this关键字

- 作用

    - 可以区分成员变量和局部变量重名的问题！this修饰的是成员变量。
    - this代表当前对象，谁调用我，我就代表谁。

- 示例代码

    - Person类

  ```java
  public class Person {
      //成员变量
      private String name;
      private int age;
  
      //get和set方法
      public void setName(String name) {
          this.name = name;
      }
  
      public String getName(){
          return name;
      }
  
      public void setAge(int age) {
          this.age = age;
      }
  
      public int getAge() {
          return age;
      }
  
      //成员方法
      public void show() {
          System.out.println("姓名：" + name + ",年龄：" + age);
      }
  }
  ```

    - 测试类

  ```java
  public class PersonTest {
      public static void main(String[] args) {
          //创建对象
          Person p1 = new Person();
          //为成员变量赋值
          p1.setName("张三");
          p1.setAge(23);
  
          //调用show方法
          p1.show();
  
          System.out.println("-----------------");
  
          Person p2 = new Person();
          p2.setName("李四");
          p2.setAge(24);
  
          p2.show();
  
          //获取p2对象的年龄
          int age = p2.getAge();
          System.out.println(age);
      }
  }
  ```

#### 3.封装

- 封装思想：将不想对外公开的成员隐藏起来。外界如果想访问的话，提供公共的访问方式！
- 体现一：private关键字。提高代码的安全性！
- 体现二：方法。提高代码的复用性！

### 四、构造方法

#### 1.什么是构造方法

- 构造方法是用于创建对象的。对对象中的成员进行初始化！ ps：（构造方法除了用于创建对象外，还有其他作用吗？类中有构造方法与无构造方法相比，有什么区别呢？）

#### 2.构造方法定义格式

```java
权限修饰符 方法名[类名](){
    
}
```

#### 3.构造方法注意事项

- 如果没有写任何的构造方法，系统会提供一个空参构造方法供我们使用
- 如果我们自己写了任意一个构造方法，那么系统就不再提供默认的空参构造方法了
- 构造方法也是可以重载的

### 五、标准类的定义和使用

#### 1.类的定义

- 类的组成
    - 成员变量：全部private修饰
    - 构造方法：空参的和全部参数的
    - get和set方法
    - 成员方法
- Student类

```java
public class D5.DemoTostring.Student {
    //成员变量
    private String name;
    private int age;

    //构造方法
    public D5.DemoTostring.Student() {

    }

    public D5.DemoTostring.Student(String name,int age) {
        this.name = name;
        this.age = age;
    }

    //get和set方法
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    //成员方法
    public void show() {
        System.out.println("姓名是：" + name + ",年龄是：" + age);
    }

    public void study() {
        System.out.println("学生学习");
    }
}
```

#### 2.类的使用

- 两种创建对象方式
    - 空参构造+set方法赋值
    - 有参构造方法创建对象并赋值 ps：（ 这个有封装效果吗？与get/set/方法比哪个安全性更高，还是一样高，为什么更高，为什么一样高？ ）
- 测试类

```java
public class StudentTest {
    public static void main(String[] args) {
        //空参构造方法+set
        D5.DemoTostring.Student s1 = new D5.DemoTostring.Student();
        //为成员变量赋值
        s1.setName("张三");
        s1.setAge(23);

        //调用成员方法
        s1.show();
        s1.study();

        System.out.println("------------------");

        //有参构造
        D5.DemoTostring.Student s2 = new D5.DemoTostring.Student("李四",24);

        //调用成员方法
        s2.show();
        s2.study();
    }
}
```

## 练习题

1. 过一遍笔记
2. 练习作业题

## 面试题

- 什么是类？什么是对象？类和对象的关系是什么？
- 成员变量和局部变量的区别是什么？
- private关键字的作用是什么？
- 封装的思想是什么？
- 构造方法的定义格式什么？
- 构造方法使用的注意事项有哪些？