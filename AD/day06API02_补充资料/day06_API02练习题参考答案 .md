## 练习题

### 第一题

+ 要求

  请编写程序，从控制台接收一个“生日”，格式：yyyy-MM-dd，程序要能够计算并打印他来到世界xx天。

+ 参考代码

  ```java
  public class Demo {

      public static void main(String[] args) throws Exception {
          //创建Scanner对象
          Scanner sc = new Scanner(System.in);

          //接收用户输入
          System.out.println("请输入您的生日（yyyy-MM-dd）");
          String dateStr = sc.nextLine();

          //创建SimpleDateFormat对象
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

          //转换成时间对象
          Date birthday = sdf.parse(dateStr);
          Date now = new Date();
    
          //计算来到世界xx天
          long millisecond = now.getTime() - birthday.getTime();

          long days = millisecond / 1000 / 60 / 60 / 24;
          System.out.println("您已经来到这个世界" + days + "天");
      }
  }
  ```

### 第二题

+ 要求

  请编写程序，从控制台接收一个“日期”，格式：yyyy-MM-dd，程序将其转换为：xxxx年xx月xx日的格式输出到控制台。

+ 参考代码

  ```java
  public class Demo {

      public static void main(String[] args) throws Exception {
          //创建Scanner对象
          Scanner sc = new Scanner(System.in);

          //接收用户输入
          System.out.println("请输入日期（yyyy-MM-dd）");
          String dateStr = sc.nextLine();

          //将字符串日期转换成Date对象
          SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
          Date date = sdf1.parse(dateStr);

          //将Date对象转换成指定格式的字符串
          SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
          String result = sdf2.format(date);

          //打印结果
          System.out.println(result);
      }
  }
  ```

### 第三题

+ 要求

  请定义main()方法，在main()中按以下顺序要求编写代码： ​ 分别从控制台接收两个整数 ​ 计算“第一个数 /第二个数”的结果，并打印； ​ 为了防止第二个数为0导致异常，请在计算时使用异常处理。

  ​ 当出现异常时，向用户打印：第二个数不能为0！！

+ 参考代码

  ```java
  public class Test21 {
      public static void main(String[] args) {
          //分别从控制台接收两个整数
          Scanner scanner = new Scanner(System.in);
          System.out.print("请输入第一个数:");
          int num1 = scanner.nextInt();

          //为了防止第二个数为0导致异常，请在计算时使用异常处理。当出现异常时，向用户打印：第二个数不能为0！！
          System.out.print("请输入第二个数:");
          int num2 = scanner.nextInt();
          //计算“第一个数 / 第二个数”的结果，并打印；
          try {
              int div = num1/num2;
              System.out.println("第一个数/第二个数="+div);
          } catch (ArithmeticException e) {
              if(num2==0) {
                  System.out.println("第二个数不能为0");
              }
          }
      }
  }
  ```

  ​