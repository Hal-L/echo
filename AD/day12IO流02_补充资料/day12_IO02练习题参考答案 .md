## 练习题

### 第一题

+ 要求

  缓冲流BufferedReader,BufferedWriter复制文本文件

  按照读写文本一行的形式赋值

  数据源文件为copy.txt 复制后的数据目的文件为copy_copy.txt

+ 参考代码

  ```java
  public class Test01{
    	public static void main(String[] args) throws IOException{
  		BufferedReader bfr = new BufferedReader(new FileReader("c:\\copy.txt"));
  		BufferedWriter bfw = new BufferedWriter(new FileWriter("d:\\copy.txt"));
  		String line = null;
  		while((line = bfr.readLine())!=null){
  			bfw.write(line);
  			bfw.newLine();
  		    bfw.flush();
  	    }
  		bfw.close();
  		bfr.close();
  	} 
  }
  ```

### 第二题

+ 要求

    1. 定义一个学员类，有以下属性：姓名、性别、年龄、分数、无参、全参构造方法，get/set方法

    2. 定义main()方法，定义一个存储Student的集合，并初始化一些数据：

       List<D5.DemoTostring.Student> stuList = new ArrayList<>();

       stuList.add(new D5.DemoTostring.Student("迪丽热巴","女",18,99));

       stuList.add(new D5.DemoTostring.Student("古力娜扎","女",19,98));

       stuList.add(new D5.DemoTostring.Student("周杰伦","男",20,88));

       stuList.add(new D5.DemoTostring.Student("蔡徐坤","男",19,78));

    3. 定义一个字符缓冲输出流BufferedWriter，将学员信息写入到”test2_1.txt”中，

       每个学员信息占一行，每个字段之间用,符号隔开，例如：

       迪丽热巴,女,18,99

       古力娜扎,女,19,98

       周杰伦,男,20,88

       蔡徐坤,男,19,78

+ 参考代码

  ```java
  // 学生类
  public class D5.DemoTostring.Student {
      // 定义一个学员类，有以下属性：姓名、性别、年龄、分数、无参、全参构造方法，get/set方法
      private String name;
      private String gender;
      private int age;
      private int score;

      public D5.DemoTostring.Student() {
      }

      public D5.DemoTostring.Student(String name, String gender, int age, int score) {
          this.name = name;
          this.gender = gender;
          this.age = age;
          this.score = score;
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public String getGender() {
          return gender;
      }

      public void setGender(String gender) {
          this.gender = gender;
      }

      public int getAge() {
          return age;
      }

      public void setAge(int age) {
          this.age = age;
      }

      public int getScore() {
          return score;
      }

      public void setScore(int score) {
          this.score = score;
      }
  }
  // 测试类
  public class Test02 {
      public static void main(String[] args) throws IOException {
          // 定义一个存储Student的集合，并初始化一些数据：
          List<D5.DemoTostring.Student> stuList = new ArrayList<>();
          stuList.add(new D5.DemoTostring.Student("迪丽热巴","女",18,99));
          stuList.add(new D5.DemoTostring.Student("古力娜扎","女",19,98));
          stuList.add(new D5.DemoTostring.Student("周杰伦","男",20,88));
          stuList.add(new D5.DemoTostring.Student("蔡徐坤","男",19,78));
          // 定义一个字符缓冲输出流BufferedWriter，将学员信息写入到”test2_1.txt”中
          BufferedWriter bw = new BufferedWriter(new FileWriter("myCode\\test2_1.txt"));
          for (D5.DemoTostring.Student student : stuList) {
              // 每个学员信息占一行，每个字段之间用,符号隔开
              bw.write(student.getName()+","+student.getGender()+","+student.getAge()+","+student.getScore());
              bw.newLine();
              bw.flush();
          }
          // 关流,释放资源
          bw.close();
      }
  }
  ```

### 第三题

+ 要求一

    1. 定义一个学生类，包含姓名，年龄，性别等成员变量，提供setters和getters方法以及构造方法。
    2. 在测试类中创建一个学生对象，给学生对象的三个成员变量赋值。然后将该对象保存到当前项目根目录下的stu.txt文件中。

+ 要求二

  将上一要求保存到stu.txt文件中的学生对象读取出来。

+ 参考代码

  ```java
  // 学生类
  class D5.DemoTostring.Student implements Serializable {
      private static final long serialVersionUID = 4983659706961705248L;
      private String name;
      private int age;
      private String gender;

      public D5.DemoTostring.Student() {
      }
      public D5.DemoTostring.Student(String name, int age, String gender) {
          this.name = name;
          this.age = age;
          this.gender = gender;
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
      public String getGender() {
          return gender;
      }
      public void setGender(String gender) {
          this.gender = gender;
      }
  }
  // 要求一
  public class Test0301 {
      public static void main(String[] args) throws IOException {
          // 创建学生对象
          D5.DemoTostring.Student s = new D5.DemoTostring.Student("jack",20,"男");
          // 创建对象输出流对象
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stu.txt"));
          // 将学生对象保存文件中
          oos.writeObject(s);
          // 关闭流并释放资源
          oos.close();
      }
  }
  // 要求二
  public class Test0302 {
      public static void main(String[] args) throws IOException {
          // 创建字节输入流对象并关联文件
          FileInputStream fis = new FileInputStream("stu.txt");
          // 创建对象输入流对象
          ObjectInputStream ois = new ObjectInputStream(fis);
          // 读取学生对象
          D5.DemoTostring.Student s = (D5.DemoTostring.Student) ois.readObject();
          System.out.println(s);
          // 关闭流
          ois.close();
      }
  }
  ```





