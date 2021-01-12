## 练习题

### 第一题

+ 要求

  请按标准格式定义一个“手机类”，它有三个属性：品牌(String)、颜色(String)、价格(double)
  请编写测试类，创建两个“手机对象”并为它们的属性赋值，并能直接打印手机对象的属性信息。

+ 参考代码

  ```java
  /**
   * 手机
   */
  public class Phone {

      //成员变量
      private String brand;   //品牌
      private String color;   //颜色
      private double price;   //价格

      //空参构造
      public Phone() {
      }

      //全参构造
      public Phone(String brand, String color, double price) {
          this.brand = brand;
          this.color = color;
          this.price = price;
      }

      //toString
      @Override
      public String toString() {
          return "Phone{" +
                  "brand='" + brand + '\'' +
                  ", color='" + color + '\'' +
                  ", price=" + price +
                  '}';
      }

      //getter & setter 略
  }
  // 测试类
  public class Demo {

      public static void main(String[] args) {
          //创建对象
          Phone p1 = new Phone("小米", "黑色", 1999);
          Phone p2 = new Phone("华为", "白色", 2999);

          //打印对象
          System.out.println(p1);
          System.out.println(p2);
      }
  }
  ```

### 第二题

+ 要求

  请按标准格式定义一个“学生类”，它有三个属性：姓名、性别、年龄 请编写测试类，创建两个“学生对象”并为它们的属性赋值，并能比较两个对象的所有属性值是否完全相等。

+ 参考代码

  ```java
  /**
   * 学生
   */
  public class D5.DemoTostring.Student {

      //成员变量
      private String name;    //姓名
      private String gender;  //性别
      private int age;        //年龄

      //空参构造
      public D5.DemoTostring.Student() {
      }

      //全参构造
      public D5.DemoTostring.Student(String name, String gender, int age) {
          this.name = name;
          this.gender = gender;
          this.age = age;
      }

      //equals
      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;
          D5.DemoTostring.Student student = (D5.DemoTostring.Student) o;
          return age == student.age &&
                  Objects.equals(name, student.name) &&
                  Objects.equals(gender, student.gender);
      }

      //getter & setter 略
  }
  // 测试类
  public class Demo {

      public static void main(String[] args) {
          //创建两个学生对象
          D5.DemoTostring.Student stu1 = new D5.DemoTostring.Student("张三", "男", 18);
          D5.DemoTostring.Student stu2 = new D5.DemoTostring.Student("张三", "男", 18);

          //打印结果
          System.out.println(stu1.equals(stu2));
      }
  }
  ```

### 第三题

+ 要求

  请编程进行以下运算： ​ 请计算3的5次幂 ​ 请计算3.2向上取整的结果 ​ 请计算5.6四舍五入取整的结果

+ 参考代码

  ```java
  public class Demo {

      public static void main(String[] args) {
          //3的5次幂
          System.out.println(Math.pow(3, 5));

          //3.2 向上取整
          System.out.println(Math.ceil(3.2));

          //3.8 向下取整
          System.out.println(Math.floor(3.8));

          //5.6四舍五入
          System.out.println(Math.round(5.6));
      }
  }
  ```

  ​

