## 课堂知识点

### 一、对象数组

#### 1.创建Student数组并保存对象

- 对象数组：数组中保存的是对象的内存地址值

- 示例代码

    - Student类

  ```java
  public class D5.DemoTostring.Student {
      private String name;
      private int age;
  
      public D5.DemoTostring.Student() {
      }
  
      public D5.DemoTostring.Student(String name, int age) {
          this.name = name;
          this.age = age;
      }
  
      public String getName() {
          return name;
      }
  
      public void setName(String name) {
          this.name = name;
      }
  
      public int getAge() {
          return age;
      }
  
      public void setAge(int age) {
          this.age = age;
      }
  
      public void show() {
          System.out.println("姓名是：" + name + "，年龄是：" + age);
      }
  }
  ```

    - 测试类

  ```java
  public class Demo01 {
      public static void main(String[] args) {
          //定义一个Student数组，长度为3
          D5.DemoTostring.Student[] arr = new D5.DemoTostring.Student[3];
  
          //创建3个Student对象，将这3个对象保存到数组中
          D5.DemoTostring.Student s1 = new D5.DemoTostring.Student("张三",23);
          D5.DemoTostring.Student s2 = new D5.DemoTostring.Student("李四",24);
          D5.DemoTostring.Student s3 = new D5.DemoTostring.Student("王五",25);
  
          arr[0] = s1;
          arr[1] = s2;
          arr[2] = s3;
  
          //遍历数组，获取每一个对象。调用show()显示数据
          for (int i = 0; i < arr.length; i++) {
              D5.DemoTostring.Student stu = arr[i];
              stu.show();
          }
      }
  }
  ```

- 对象数组内存图解

![01](img\01.png)

### 二、ArrayList集合

#### 1.ArrayList集合介绍

- 集合也是一种容器。可以保存多个相同数据类型的元素
- 集合是长度可变的。所以比数组更加灵活
- ArrayList<E>  集合的泛型
- 泛型：指的是一种广泛的数据类型，在定义类的时候，没有给出明确的数据类型。在我们创建集合对象的时候，可以来指定想存储数据的数据类型！例如：ArrayList<String>    ArrayList<D5.DemoTostring.Student>

#### 2.ArrayList构造方法

- ArrayList()                创建一个集合对象

#### 3.ArrayList成员方法

- 方法分类

| 方法名                  | 说明                                     |
| ----------------------- | ---------------------------------------- |
| boolean add(E e)        | 添加元素                                 |
| void add(int index,E e) | 向指定索引处添加元素                     |
| boolean remove(E e)     | 通过指定元素来删除                       |
| E remove(int index)     | 通过索引来删除指定元素。返回被删除的元素 |
| E set(int index,E e)    | 修改指定索引处的元素，返回被修改的元素   |
| E get(int index)        | 通过索引来获取元素                       |
| int size()              | 获取集合的长度                           |

- 示例代码

```java
public class ArrayListDemo02 {
    public static void main(String[] args) {
        //创建集合
        ArrayList<String> array = new ArrayList<String>();

        //添加元素
        array.add("hello");
        array.add("world");
        array.add("java");

        //public boolean remove(Object o)：删除指定的元素，返回删除是否成功
//        System.out.println(array.remove("world"));
//        System.out.println(array.remove("javaee"));

        //public E remove(int index)：删除指定索引处的元素，返回被删除的元素
//        System.out.println(array.remove(1));

        //IndexOutOfBoundsException
//        System.out.println(array.remove(3));

        //public E set(int index,E element)：修改指定索引处的元素，返回被修改的元素
//        System.out.println(array.set(1,"javaee"));

        //IndexOutOfBoundsException
//        System.out.println(array.set(3,"javaee"));

        //public E get(int index)：返回指定索引处的元素
//        System.out.println(array.get(0));
//        System.out.println(array.get(1));
//        System.out.println(array.get(2));
        //System.out.println(array.get(3)); //？？？？？？ 自己测试

        //public int size()：返回集合中的元素的个数
        System.out.println(array.size());

        //输出集合
        System.out.println("array:" + array);
    }
}
```

#### 4.基本数据类型包装类

```java
/*
    数组和集合的区别：
        数组是长度固定的。
        集合是长度可变的。

        数组既可以保存基本数据类型的数据，也可以保存引用数据类型的数据
        集合只能保存引用数据类型的数据。如果想存储基本数据类型，需要使用基本数据类型的包装类

    包装类：
        byte        Byte
        short       Short
        int         Integer
        long        Long
        float       Float
        double      Double
        char        Character
        boolean     Boolean
 */
public class Demo {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        System.out.println(list);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        System.out.println(list2);

        ArrayList<Double> list3 = new ArrayList<Double>();
        list3.add(5.5);
        System.out.println(list3);

    }
}
```

#### 5.ArrayList案例-存储字符串并遍历

```java
public class ArrayListTest01 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<String> array = new ArrayList<String>();

        //往集合中添加字符串对象
        array.add("刘正风");
        array.add("左冷禅");
        array.add("风清扬");

        /*
            数组长度：数组名.length
            字符串长度：变量名.length()
            集合长度：集合名.size()
         */

        //遍历集合的通用格式
        for(int i=0; i<array.size(); i++) {
            String s = array.get(i);
            System.out.println(s);
        }
    }
}
```

#### 6.ArrayList案例-存储学生对象并遍历

```java
public class ArrayListTest02 {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<D5.DemoTostring.Student> array = new ArrayList<>();

        //创建学生对象
        D5.DemoTostring.Student s1 = new D5.DemoTostring.Student("林青霞", 30);
        D5.DemoTostring.Student s2 = new D5.DemoTostring.Student("风清扬", 33);
        D5.DemoTostring.Student s3 = new D5.DemoTostring.Student("张曼玉", 18);

        //添加学生对象到集合中
        array.add(s1);
        array.add(s2);
        array.add(s3);

        //遍历集合，采用通用遍历格式实现
        for (int i = 0; i < array.size(); i++) {
            D5.DemoTostring.Student s = array.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }
    }
}
```

#### 7.ArrayList案例-存储学生对象并遍历优化版

```java
public class ArrayListTest {
    public static void main(String[] args) {
        //创建集合对象
        ArrayList<D5.DemoTostring.Student> array = new ArrayList<D5.DemoTostring.Student>();

        //为了提高代码的复用性，我们用方法来改进程序
        addStudent(array);
        addStudent(array);
        addStudent(array);

        //遍历集合，采用通用遍历格式实现
        for (int i = 0; i < array.size(); i++) {
            D5.DemoTostring.Student s = array.get(i);
            System.out.println(s.getName() + "," + s.getAge());
        }

    }

    /*
        两个明确：
            返回值类型：void
            参数：ArrayList<D5.DemoTostring.Student> array
     */
    public static void addStudent(ArrayList<D5.DemoTostring.Student> array) {
        //键盘录入学生对象所需要的数据
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生姓名:");
        String name = sc.nextLine();

        System.out.println("请输入学生年龄:");
        String age = sc.nextLine();

        //创建学生对象，把键盘录入的数据赋值给学生对象的成员变量
        D5.DemoTostring.Student s = new D5.DemoTostring.Student();
        s.setName(name);
        s.setAge(age);

        //往集合中添加学生对象
        array.add(s);
    }
}
```

