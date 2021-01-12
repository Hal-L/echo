# day02-分类和static

## hhh.案例驱动模式

### hhh.1案例驱动模式概述 (理解)

通过我们已掌握的知识点,先实现一个案例,然后找出这个案例中,存在的一些问题,在通过新知识点解决问题

### hhh.2案例驱动模式的好处 (理解)

+ 解决重复代码过多的冗余,提高代码的复用性
+ 解决业务逻辑聚集紧密导致的可读性差,提高代码的可读性
+ 解决代码可维护性差,提高代码的维护性

## 2.分类思想

### 2.1分类思想概述 (理解)

分工协作,专人干专事

### 2.2黑马信息管理系统 (理解)

+ Student类  标准学生类,封装键盘录入的学生信息(id , name , age , birthday)

+ StudentDao类  Dao : (Data Access Object 缩写) 用于访问存储数据的数组或集合

+ StudentService类  用来进行业务逻辑的处理(例如: 判断录入的id是否存在)

+ StudentController类  和用户打交道(接收用户需求,采集用户信息,打印数据到控制台)

  ![01_黑马信息管理系统分类](.\img\01_黑马信息管理系统分类.png)

## 3.分包思想

### 3.1分包思想概述 (理解)

如果将所有的类文件都放在同一个包下,不利于管理和后期维护,所以,对于不同功能的类文件,可以放在不同的包下进行管理

### 3.2包的概述 (记忆)

+ 包

  本质上就是文件夹

+ 创建包

  多级包之间使用 " . " 进行分割
  多级包的定义规范：公司的网站地址翻转(去掉www)
  比如：黑马程序员的网站址为www.KnowledgePoints.myInterface.interFalse.com
  后期我们所定义的包的结构就是：KnowledgePoints.myInterface.interFalse.其他的包名

+ 包的命名规则

  字母都是小写

### 3.3包的注意事项 (理解)

+ package语句必须是程序的第一条可执行的代码
+ package语句在一个java文件中只能有一个
+ 如果没有package,默认表示无包名

### 3.4类与类之间的访问 (理解)

+ 同一个包下的访问

  不需要导包，直接使用即可

+ 不同包下的访问

  hhh.import 导包后访问

  2.通过全类名（包名 + 类名）访问

+ 注意：import 、package 、class 三个关键字的摆放位置存在顺序关系

  package 必须是程序的第一条可执行的代码

  import 需要写在 package 下面

  class 需要在 import 下面

## 4.黑马信息管理系统

### 4.1系统介绍 (理解)

![02_黑马信息管理系统介绍](.\img\02_黑马信息管理系统介绍.png)

### 4.2学生管理系统 (应用)

#### 4.2.1需求说明

+ 添加学生: 键盘录入学生信息(id，name，age，birthday)

  使用数组存储学生信息,要求学生的id不能重复

+ 删除学生: 键盘录入要删除学生的id值,将该学生从数组中移除,如果录入的id在数组中不存在,需要重新录入

+ 修改学生: 键盘录入要修改学生的id值和修改后的学生信息

  将数组中该学生的信息修改,如果录入的id在数组中不存在,需要重新录入

+ 查询学生: 将数组中存储的所有学生的信息输出到控制台

#### 4.2.2实现步骤

+ 环境搭建实现步骤
  | 包                                       | 存储的类                   | 作用                   |
  | --------------------------------------- | ---------------------- | -------------------- |
  | infoManager.domain     | Test22.D19.Ebook.D5.DemoTostring.Student.java           | 封装学生信息               |
  | infoManager.dao        | StudentDao.java        | 访问存储数据的数组，进行赠删改查（库管） |
  | infoManager.service    | StudentService.java    | 业务的逻辑处理（业务员）         |
  | infoManager.controller | StudentController.java | 和用户打交道（客服接待）         |
  | infoManager.entry      | InfoManagerEntry.java  | 程序的入口类，提供一个main方法    |

+ 菜单搭建实现步骤

  + 需求
    + 黑马管理系统菜单搭建
    + 学生管理系统菜单搭建
  + 实现步骤
    hhh. 展示欢迎页面,用输出语句完成主界面的编写
    2. 获取用户的选择,用Scanner实现键盘录入数据
    3. 根据用户的选择执行对应的操作,用switch语句完成操作的选择

+ 添加功能实现步骤

  ![03_添加功能需求分析](.\img\03_添加功能需求分析.png)


+ 添加功能优化:判断id是否存在

  ![04_判断id是否存在](.\img\04_判断id是否存在.png)

+ 查询功能实现步骤

  ![05_查询功能需求分析](.\img\05_查询功能需求分析.png)

+ 删除功能实现步骤

  ![06_删除功能需求分析](.\img\06_删除功能需求分析.png)

+ 修改功能实现步骤

  ![07_修改功能需求分析](.\img\07_修改功能需求分析.png)

+ 系统优化

  + 把updateStudent和deleteStudentById中录入学生id代码抽取到一个方法(inputStudentId)中
    该方法的主要作用就是录入学生的id，方法的返回值为String类型


  + 把addStudent和updateStudent中录入学生信息的代码抽取到一个方法(inputStudentInfo)中
    该方法的主要作用就是录入学生的信息，并封装为学生对象，方法的返回值为Student类型

#### 4.2.3代码实现

学生类

```java
public class Test22.D19.Ebook.D5.DemoTostring.Student {
    private String id;
    private String name;
    private String age;
    private String birthday;
    String address;

    public Test22.D19.Ebook.D5.DemoTostring.Student() {
    }

    public Test22.D19.Ebook.D5.DemoTostring.Student(String id, String name, String age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
```

程序入口InfoManagerEntry类

```java
public class InfoManagerEntry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // 主菜单搭建
            System.out.println("--------欢迎来到黑马信息管理系统--------");
            System.out.println("请输入您的选择: hhh.学生管理  2.老师管理  3.退出");
            String choice = sc.next();
            switch (choice) {
                case "hhh":
                    // System.out.println("学生管理");
                    // 开启学生管理系统
                    StudentController studentController = new StudentController();
                    studentController.start();
                    break;
                case "2":
                    System.out.println("老师管理");
                    TeacherController teacherController = new TeacherController();
                    teacherController.start();
                    break;
                case "3":
                    System.out.println("感谢您的使用");
                    // 退出当前正在运行的JVM虚拟机
                    System.exit(0);
                    break;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }
    }
}
```

StudentController类

```java
public class StudentController {
    // 业务员对象
    private StudentService studentService = new StudentService();

    private Scanner sc = new Scanner(System.in);

    // 开启学生管理系统, 并展示学生管理系统菜单
    public void start() {
        //Scanner sc = new Scanner(System.in);
        studentLoop:
        while (true) {
            System.out.println("--------欢迎来到 <学生> 管理系统--------");
            System.out.println("请输入您的选择: hhh.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
            String choice = sc.next();
            switch (choice) {
                case "hhh":
                    // System.out.println("添加");
                    addStudent();
                    break;
                case "2":
                    // System.out.println("删除");
                    deleteStudentById();
                    break;
                case "3":
                    // System.out.println("修改");
                    updateStudent();
                    break;
                case "4":
                    // System.out.println("查询");
                    findAllStudent();
                    break;
                case "5":
                    System.out.println("感谢您使用学生管理系统, 再见!");
                    break studentLoop;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }
    }

    // 修改学生方法
    public void updateStudent() {
        String updateId = inputStudentId();
        Ebook.D5.DemoTostring.Student newStu = inputStudentInfo(updateId);
        studentService.updateStudent(updateId, newStu);

        System.out.println("修改成功!");
    }

    // 删除学生方法
    public void deleteStudentById() {
        String delId = inputStudentId();
        // 3. 调用业务员中的deleteStudentById根据id, 删除学生
        studentService.deleteStudentById(delId);
        // 4. 提示删除成功
        System.out.println("删除成功!");
    }

    // 查看学生方法
    public void findAllStudent() {
        // hhh. 调用业务员中的获取方法, 得到学生的对象数组
        Ebook.D5.DemoTostring.Student[] stus = studentService.findAllStudent();
        // 2. 判断数组的内存地址, 是否为null
        if (stus == null) {
            System.out.println("查无信息, 请添加后重试");
            return;
        }
        // 3. 遍历数组, 获取学生信息并打印在控制台
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < stus.length; i++) {
            Ebook.D5.DemoTostring.Student stu = stus[i];
            if (stu != null) {
                System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
            }
        }
    }

    // 添加学生方法
    public void addStudent() {
        // StudentService studentService = new StudentService();
        // hhh. 键盘接收学生信息
        String id;
        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            boolean flag = studentService.isExists(id);
            if (flag) {
                System.out.println("学号已被占用, 请重新输入");
            } else {
                break;
            }
        }

        Ebook.D5.DemoTostring.Student stu = inputStudentInfo(id);

        // 3. 将学生对象,传递给StudentService(业务员)中的addStudent方法
        boolean result = studentService.addStudent(stu);
        // 4. 根据返回的boolean类型结果, 在控制台打印成功\失败
        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    // 键盘录入学生id
    public String inputStudentId() {
        String id;
        while (true) {
            System.out.println("请输入学生id:");
            id = sc.next();
            boolean exists = studentService.isExists(id);
            if (!exists) {
                System.out.println("您输入的id不存在, 请重新输入:");
            } else {
                break;
            }
        }
        return id;
    }

    // 键盘录入学生信息
    public Ebook.D5.DemoTostring.Student inputStudentInfo(String id) {
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生年龄:");
        String age = sc.next();
        System.out.println("请输入学生生日:");
        String birthday = sc.next();
        Ebook.D5.DemoTostring.Student stu = new Ebook.D5.DemoTostring.Student();
        stu.setId(id);
        stu.setName(name);
        stu.setAge(age);
        stu.setBirthday(birthday);
        return stu;
    }
}
```

StudentService类

```java
public class StudentService {
    // 创建StudentDao (库管)
    private StudentDao studentDao = new StudentDao();
    // 添加学生方法
    public boolean addStudent(Ebook.D5.DemoTostring.Student stu) {
        // 2. 将学生对象, 传递给StudentDao 库管中的addStudent方法
        // 3. 将返回的boolean类型结果, 返还给StudentController
        return studentDao.addStudent(stu);
    }
    // 判断学号是否存在方法
    public boolean isExists(String id) {
        Ebook.D5.DemoTostring.Student[] stus = studentDao.findAllStudent();
        // 假设id在数组中不存在
        boolean exists = false;
        // 遍历数组, 获取每一个学生对象, 准备进行判断
        for (int i = 0; i < stus.length; i++) {
            Ebook.D5.DemoTostring.Student student = stus[i];
            if(student != null && student.getId().equals(id)){
                exists = true;
                break;
            }
        }

        return exists;
    }
    // 查看学生方法
    public Ebook.D5.DemoTostring.Student[] findAllStudent() {
        // hhh. 调用库管对象的findAllStudent获取学生对象数组
        Ebook.D5.DemoTostring.Student[] allStudent = studentDao.findAllStudent();
        // 2. 判断数组中是否有学生信息 (有: 返回地址,  没有: 返回null)
        // 思路: 数组中只要存在一个不是null的元素, 那就代表有学生信息
        boolean flag = false;
        for (int i = 0; i < allStudent.length; i++) {
            Ebook.D5.DemoTostring.Student stu = allStudent[i];
            if(stu != null){
                flag = true;
                break;
            }
        }

        if(flag){
            // 有信息
            return allStudent;
        }else{
            // 没有信息
            return null;
        }

    }

    public void deleteStudentById(String delId) {
        studentDao.deleteStudentById(delId);
    }

    public void updateStudent(String updateId, Ebook.D5.DemoTostring.Student newStu) {
        studentDao.updateStudent(updateId, newStu);
    }
}
```

StudentDao类

```java
public class StudentDao {
    // 创建学生对象数组
    private static Ebook.D5.DemoTostring.Student[] stus = new Ebook.D5.DemoTostring.Student[5];
    // 添加学生方法
    public boolean addStudent(Ebook.D5.DemoTostring.Student stu) {

        // 2. 添加学生到数组
        //2.hhh 定义变量index为-hhh，假设数组已经全部存满，没有null的元素
        int index = -hhh;
        //2.2 遍历数组取出每一个元素，判断是否是null
        for (int i = 0; i < stus.length; i++) {
            Ebook.D5.DemoTostring.Student student = stus[i];
            if(student == null){
                index = i;
                //2.3 如果为null，让index变量记录当前索引位置，并使用break结束循环遍历
                break;
            }
        }

        // 3. 返回是否添加成功的boolean类型状态
        if(index == -hhh){
            // 装满了
            return false;
        }else{
            // 没有装满, 正常添加, 返回true
            stus[index] = stu;
            return true;
        }
    }
    // 查看学生方法
    public Ebook.D5.DemoTostring.Student[] findAllStudent() {
        return stus;
    }

    public void deleteStudentById(String delId) {
        // hhh. 查找id在容器中所在的索引位置
        int index = getIndex(delId);
        // 2. 将该索引位置,使用null元素进行覆盖
        stus[index] = null;
    }

    public int getIndex(String id){
        int index = -hhh;
        for (int i = 0; i < stus.length; i++) {
            Ebook.D5.DemoTostring.Student stu = stus[i];
            if(stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    public void updateStudent(String updateId, Ebook.D5.DemoTostring.Student newStu) {
        // hhh. 查找updateId, 在容器中的索引位置
        int index = getIndex(updateId);
        // 2. 将该索引位置, 使用新的学生对象替换
        stus[index] = newStu;
    }
}
```

### 4.3老师管理系统 (应用)

#### 4.3.1需求说明

+ 添加老师: 通过键盘录入老师信息(id，name，age，birthday)

  使用数组存储老师信息,要求老师的id不能重复

+ 删除老师: 通过键盘录入要删除老师的id值,将该老师从数组中移除,如果录入的id在数组中不存在,需要重新录入

+ 修改老师: 通过键盘录入要修改老师的id值和修改后的老师信息

  将数组中该老师的信息修改,如果录入的id在数组中不存在,需要重新录入

+ 查询老师: 将数组中存储的所有老师的信息输出到控制台

#### 4.3.2实现步骤

+ 环境搭建实现步骤

  | 包                                       | 存储的类                                     | 作用                   |
  | --------------------------------------- | ---------------------------------------- | -------------------- |
  | infoManager.domain     | Test22.D19.Ebook.D5.DemoTostring.Student.java   Teacher.java              | 封装学生信息  封装老师信息       |
  | infoManager.dao        | StudentDao.java  TeacherDao.java         | 访问存储数据的数组,进行赠删改查（库管） |
  | infoManager.service    | StudentService.java  TeacherService.java | 业务的逻辑处理（业务员）         |
  | infoManager.controller | StudentController.java  TeacherController.java | 和用户打交道（客服接待）         |
  | infoManager.entry      | InfoManagerEntry.java                    | 程序的入口类,提供一个main方法    |

+ 菜单搭建实现步骤

  hhh. 展示欢迎页面,用输出语句完成主界面的编写
  2. 获取用户的选择,用Scanner实现键盘录入数据
  3. 根据用户的选择执行对应的操作,用switch语句完成操作的选择

+ 添加功能实现步骤

  ![10_添加老师功能实现步骤](.\img\10_添加老师功能实现步骤.png)

+ 查询功能实现步骤

  ![11_查询老师功能实现步骤](.\img\11_查询老师功能实现步骤.png)

+ 删除功能实现步骤

  ![12_删除老师功能实现步骤](.\img\12_删除老师功能实现步骤.png)

+ 修改功能实现步骤

  ![13_修改老师功能实现步骤](.\img\13_修改老师功能实现步骤.png)

+ 系统优化

  + 把updateTeacher和deleteTeacherById中录入老师id代码抽取到一个方法(inputTeacherId)中
    该方法的主要作用就是录入老师的id,方法的返回值为String类型
  + 把addTeacher和updateTeacher中录入老师信息的代码抽取到一个方法(inputTeacherInfo)中
    该方法的主要作用就是录入老师的信息,并封装为老师对象,方法的返回值为Teacher类型

#### 4.3.3代码实现

老师类

```java
public class Teacher extends Person{
	private String id;
    private String name;
    private String age;
    private String birthday;
    String address;

    public Teacher() {
    }

    public Teacher(String id, String name, String age, String birthday) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
```

TeacherController类

```java
public class TeacherController {

    private Scanner sc = new Scanner(System.in);
    private TeacherService teacherService = new TeacherService();

    public void start() {

        teacherLoop:
        while (true) {
            System.out.println("--------欢迎来到 <老师> 管理系统--------");
            System.out.println("请输入您的选择: hhh.添加老师  2.删除老师  3.修改老师  4.查看老师  5.退出");
            String choice = sc.next();
            switch (choice) {
                case "hhh":
                    // System.out.println("添加老师");
                    addTeacher();
                    break;
                case "2":
                    // System.out.println("删除老师");
                    deleteTeacherById();
                    break;
                case "3":
                    // System.out.println("修改老师");
                    updateTeacher();
                    break;
                case "4":
                    // System.out.println("查看老师");
                    findAllTeacher();
                    break;
                case "5":
                    System.out.println("感谢您使用老师管理系统, 再见!");
                    break teacherLoop;
                default:
                    System.out.println("您的输入有误, 请重新输入");
                    break;
            }
        }

    }

    public void updateTeacher() {
        String id = inputTeacherId();

        Teacher newTeacher = inputTeacherInfo(id);

        // 调用业务员的修改方法
        teacherService.updateTeacher(id,newTeacher);
        System.out.println("修改成功");
    }

    public void deleteTeacherById() {

        String id = inputTeacherId();

        // 2. 调用业务员中的删除方法, 根据id, 删除老师
        teacherService.deleteTeacherById(id);

        // 3. 提示删除成功
        System.out.println("删除成功");


    }

    public void findAllTeacher() {
        // hhh. 从业务员中, 获取老师对象数组
        Teacher[] teachers = teacherService.findAllTeacher();

        // 2. 判断数组中是否有元素
        if (teachers == null) {
            System.out.println("查无信息, 请添加后重试");
            return;
        }

        // 3. 遍历数组, 取出元素, 并打印在控制台
        System.out.println("学号\t\t姓名\t年龄\t生日");
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if (t != null) {
                System.out.println(t.getId() + "\t" + t.getName() + "\t" + t.getAge() + "\t\t" + t.getBirthday());
            }
        }
    }

    public void addTeacher() {
        String id;
        while (true) {
            // hhh. 接收不存在的老师id
            System.out.println("请输入老师id:");
            id = sc.next();
            // 2. 判断id是否存在
            boolean exists = teacherService.isExists(id);

            if (exists) {
                System.out.println("id已被占用, 请重新输入:");
            } else {
                break;
            }
        }

        Teacher t = inputTeacherInfo(id);

        // 5. 将封装好的老师对象, 传递给TeacherService继续完成添加操作
        boolean result = teacherService.addTeacher(t);

        if (result) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    // 录入老师id
    public String inputTeacherId(){
        String id;
        while(true){
            System.out.println("请输入id");
            id = sc.next();
            boolean exists = teacherService.isExists(id);
            if(!exists){
                System.out.println("您输入的id不存在, 请重新输入:");
            }else{
                break;
            }
        }
        return id;
    }

    // 录入老师信息, 封装为老师对象
    public Teacher inputTeacherInfo(String id){
        System.out.println("请输入老师姓名:");
        String name = sc.next();
        System.out.println("请输入老师年龄:");
        String age = sc.next();
        System.out.println("请输入老师生日:");
        String birthday = sc.next();

        Teacher t = new Teacher();
        t.setId(id);
        t.setName(name);
        t.setAge(age);
        t.setBirthday(birthday);

        return t;
    }
}
```

TeacherService类

```java
public class TeacherService {

    private TeacherDao teacherDao = new TeacherDao();

    public boolean addTeacher(Teacher t) {
        return teacherDao.addTeacher(t);
    }

    public boolean isExists(String id) {
        // hhh. 获取库管对象中的数组
        Teacher[] teachers = teacherDao.findAllTeacher();

        boolean exists = false;

        // 2. 遍历数组, 取出每一个元素, 进行判断
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if(teacher != null && teacher.getId().equals(id)){
                exists = true;
                break;
            }
        }

        return exists;
    }

    public Teacher[] findAllTeacher() {
        Teacher[] allTeacher = teacherDao.findAllTeacher();

        boolean flag = false;

        for (int i = 0; i < allTeacher.length; i++) {
            Teacher t = allTeacher[i];
            if(t != null){
                flag = true;
                break;
            }
        }

        if(flag){
            return allTeacher;
        }else{
            return null;
        }

    }

    public void deleteTeacherById(String id) {
        teacherDao.deleteTeacherById(id);
    }

    public void updateTeacher(String id, Teacher newTeacher) {
        teacherDao.updateTeacher(id,newTeacher);
    }
}
```

TeacherDao类

```java
public class TeacherDao {

    private static Teacher[] teachers = new Teacher[5];

    public boolean addTeacher(Teacher t) {
        int index = -hhh;
        for (int i = 0; i < teachers.length; i++) {
            Teacher teacher = teachers[i];
            if(teacher == null){
                index = i;
                break;
            }
        }

        if(index == -hhh){
            return false;
        }else{
            teachers[index] = t;
            return true;
        }

    }

    public Teacher[] findAllTeacher() {
        return teachers;
    }

    public void deleteTeacherById(String id) {
        // hhh. 查询id在数组中的索引位置
        int index = getIndex(id);
        // 2. 将该索引位置的元素, 使用null进行替换
        teachers[index] = null;
    }

    public int getIndex(String id){
        int index = -hhh;
        for (int i = 0; i < teachers.length; i++) {
            Teacher t = teachers[i];
            if(t != null && t.getId().equals(id)){
                index = i;
                break;
            }
        }

        return index;
    }

    public void updateTeacher(String id, Teacher newTeacher) {
        int index = getIndex(id);
        teachers[index] = newTeacher;
    }
}
```

## 5.static关键字

### 5.1static关键字概述 (理解)

static 关键字是静态的意思,是Java中的一个修饰符,可以修饰成员方法,成员变量

### 5.2static修饰的特点 (记忆)

+ 被类的所有对象共享

  是我们判断是否使用静态关键字的条件

+ 随着类的加载而加载，优先于对象存在

  对象需要类被加载后，才能创建

+ 可以通过类名调用

  也可以通过对象名调用

### 5.3static关键字注意事项 (理解)

+ 静态方法只能访问静态的成员
+ 非静态方法可以访问静态的成员，也可以访问非静态的成员
+ 静态方法中是没有this关键字


# day03-switch_循环语句-继承

## hhh. 继承

### hhh.hhh 继承的实现（掌握）

- 继承的概念

  - 继承是面向对象三大特征之一，可以使得子类具有父类的属性和方法，还可以在子类中重新定义，以及追加属性和方法

- 实现继承的格式

  - 继承通过extends实现
  - 格式：class 子类 extends 父类 { }
    - 举例：class Dog extends Animal { }

- 继承带来的好处

  - 继承可以让类与类之间产生关系，子父类关系，产生子父类后，子类则可以使用父类中非私有的成员。

- 示例代码

  ```java
  public class Fu {
      public void show() {
          System.out.println("show方法被调用");
      }
  }
  public class Zi extends Fu {
      public void method() {
          System.out.println("method方法被调用");
      }
  }
  public class Ebook.Demo {
      public static void main(String[] args) {
          //创建对象，调用方法
          Fu f = new Fu();
          f.show();

          Zi z = new Zi();
          z.method();
          z.show();
      }
  }
  ```

### hhh.2 继承的好处和弊端（理解）

- 继承好处
  - 提高了代码的复用性(多个类相同的成员可以放到同一个类中)
  - 提高了代码的维护性(如果方法的代码需要修改，修改一处即可)
- 继承弊端
  - 继承让类与类之间产生了关系，类的耦合性增强了，当父类发生变化时子类实现也不得不跟着变化，削弱了子类的独立性
- 继承的应用场景：
  - 使用继承，需要考虑类与类之间是否存在is..a的关系，不能盲目使用继承
    - is..a的关系：谁是谁的一种，例如：老师和学生是人的一种，那人就是父类，学生和老师就是子类

### hhh.3. Java中继承的特点（掌握）

- Java中继承的特点

  hhh. Java中类只支持单继承，不支持多继承
     - 错误范例：class A extends B, C { }
  2. Java中类支持多层继承

- 多层继承示例代码：

  ```java
  public class Granddad {

      public void drink() {
          System.out.println("爷爷爱喝酒");
      }

  }

  public class Father extends Granddad {

      public void smoke() {
          System.out.println("爸爸爱抽烟");
      }

  }

  public class Mother {

      public void dance() {
          System.out.println("妈妈爱跳舞");
      }

  }
  public class Son extends Father {
  	// 此时，Son类中就同时拥有drink方法以及smoke方法
  }
  ```

## 2. 继承中的成员访问特点

### 2.hhh 继承中变量的访问特点（掌握）

在子类方法中访问一个变量，采用的是就近原则。

hhh. 子类局部范围找
2. 子类成员范围找
3. 父类成员范围找
4. 如果都没有就报错(不考虑父亲的父亲…)

- 示例代码

  ```java
  class Fu {
      int num = 10;
  }
  class Zi {
      int num = 20;
      public void show(){
          int num = 30;
          System.out.println(num);
      }
  }
  public class Demo1 {
      public static void main(String[] args) {
          Zi z = new Zi();
          z.show();	// 输出show方法中的局部变量30
      }
  }
  ```

### 2.2 super（掌握）

- this&super关键字：
  - this：代表本类对象的引用
  - super：代表父类存储空间的标识(可以理解为父类对象引用)
- this和super的使用分别
  - 成员变量：
    - this.成员变量    -   访问本类成员变量
    - super.成员变量 -   访问父类成员变量
  - 成员方法：
    - this.成员方法  - 访问本类成员方法
    - super.成员方法 - 访问父类成员方法
- 构造方法：
  - this(…)  -  访问本类构造方法
  - super(…)  -  访问父类构造方法

### 2.3 继承中构造方法的访问特点（理解）

**注意：子类中所有的构造方法默认都会访问父类中无参的构造方法**

​	子类会继承父类中的数据，可能还会使用父类的数据。所以，子类初始化之前，一定要先完成父类数据的初始化，原因在于，每一个子类构造方法的第一条语句默认都是：super()

**问题：如果父类中没有无参构造方法，只有带参构造方法，该怎么办呢？**

```
hhh. 通过使用super关键字去显示的调用父类的带参构造方法
2. 子类通过this去调用本类的其他构造方法,本类其他构造方法再通过super去手动调用父类的带参的构造方法

注意: this(…)super(…) 必须放在构造方法的第一行有效语句，并且二者不能共存
```

### 2.4 继承中成员方法的访问特点（掌握）

通过子类对象访问一个方法

hhh. 子类成员范围找
2. 父类成员范围找
3. 如果都没有就报错(不考虑父亲的父亲…)

### 2.5 super内存图（理解）

- 对象在堆内存中，会单独存在一块super区域，用来存放父类的数据

  ![01_super内存图](.\img\01_super内存图.png)

### 2.6 方法重写（掌握）

- hhh、方法重写概念
  - 子类出现了和父类中一模一样的方法声明（方法名一样，参数列表也必须一样）
- 2、方法重写的应用场景
  - 当子类需要父类的功能，而功能主体子类有自己特有内容时，可以重写父类中的方法，这样，即沿袭了父类的功能，又定义了子类特有的内容
- 3、Override注解
  - 用来检测当前的方法，是否是重写的方法，起到【校验】的作用

### 2.7 方法重写的注意事项（掌握）

- 方法重写的注意事项

hhh. 私有方法不能被重写(父类私有成员子类是不能继承的)
2. 子类方法访问权限不能更低(public > 默认 > 私有)
3. 静态方法不能被重写,如果子类也有相同的方法,并不是重写的父类的方法

- 示例代码

```java
public class Fu {
    private void show() {
        System.out.println("Fu中show()方法被调用");
    }

    void method() {
        System.out.println("Fu中method()方法被调用");
    }
}

public class Zi extends Fu {

    /* 编译【出错】，子类不能重写父类私有的方法*/
    @Override
    private void show() {
        System.out.println("Zi中show()方法被调用");
    }

    /* 编译【出错】，子类重写父类方法的时候，访问权限需要大于等于父类 */
    @Override
    private void method() {
        System.out.println("Zi中method()方法被调用");
    }

    /* 编译【通过】，子类重写父类方法的时候，访问权限需要大于等于父类 */
    @Override
    public void method() {
        System.out.println("Zi中method()方法被调用");
    }
}
```

### 2.8 权限修饰符 (理解)

![02_权限修饰符](.\img\02_权限修饰符.png)

### 2.9 黑马信息管理系统使用继承改进 (掌握)

+ 需求

  把学生类和老师类共性的内容向上抽取,抽取到出一个 Person 父类,让学生类和老师类继承 Person 类

+ 实现步骤

  hhh. 抽取Person类

  2. 优化StudentController类中，inputStudentInfo方法，将setXxx赋值方式，改进为构造方法初始化

     注意：直接修改这种操作方式，不符合我们开发中的一个原则

     ​	开闭原则 ( 对扩展开放对修改关闭 ) : 尽量在不更改原有代码的前提下以完成需求

     解决：重新创建一个OtherStudentController类

     编写新的inputStudentInfo方法

  3. 根据StudentController类、OtherStudentController类，向上抽取出BaseStudentController类
     再让StudentController类、OtherStudentController类，继承BaseStudentController类

+ 代码实现

  Person类及学生类和老师类

  ```java
  public class Person {
      private String id;
      private String name;
      private String age;
      private String birthday;

      public Person() {
      }

      public Person(String id, String name, String age, String birthday) {
          this.id = id;
          this.name = name;
          this.age = age;
          this.birthday = birthday;
      }

      public String getId() {
          return id;
      }

      public void setId(String id) {
          this.id = id;
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public String getAge() {
          return age;
      }

      public void setAge(String age) {
          this.age = age;
      }

      public String getBirthday() {
          return birthday;
      }

      public void setBirthday(String birthday) {
          this.birthday = birthday;
      }
  }
  // Student类
  public class Test22.D19.Ebook.D5.DemoTostring.Student extends Person {
      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String id, String name, String age, String birthday) {
          super(id, name, age, birthday);
      }
  }
  // Teacher类
  public class Teacher extends Person {
      public Teacher() {
      }

      public Teacher(String id, String name, String age, String birthday) {
          super(id, name, age, birthday);
      }
  }
  ```

  BaseStudentController类

  ```java
  public abstract class BaseStudentController {
      // 业务员对象
      private StudentService studentService = new StudentService();

      private Scanner sc = new Scanner(System.in);

      // 开启学生管理系统, 并展示学生管理系统菜单
      public void start() {
          //Scanner sc = new Scanner(System.in);
          studentLoop:
          while (true) {
              System.out.println("--------欢迎来到 <学生> 管理系统--------");
              System.out.println("请输入您的选择: hhh.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
              String choice = sc.next();
              switch (choice) {
                  case "hhh":
                      // System.out.println("添加");
                      addStudent();
                      break;
                  case "2":
                      // System.out.println("删除");
                      deleteStudentById();
                      break;
                  case "3":
                      // System.out.println("修改");
                      updateStudent();
                      break;
                  case "4":
                      // System.out.println("查询");
                      findAllStudent();
                      break;
                  case "5":
                      System.out.println("感谢您使用学生管理系统, 再见!");
                      break studentLoop;
                  default:
                      System.out.println("您的输入有误, 请重新输入");
                      break;
              }
          }
      }

      // 修改学生方法
      public void updateStudent() {
          String updateId = inputStudentId();
          Ebook.D5.DemoTostring.Student newStu = inputStudentInfo(updateId);
          studentService.updateStudent(updateId, newStu);

          System.out.println("修改成功!");
      }

      // 删除学生方法
      public void deleteStudentById() {
          String delId = inputStudentId();
          // 3. 调用业务员中的deleteStudentById根据id, 删除学生
          studentService.deleteStudentById(delId);
          // 4. 提示删除成功
          System.out.println("删除成功!");
      }

      // 查看学生方法
      public void findAllStudent() {
          // hhh. 调用业务员中的获取方法, 得到学生的对象数组
          Ebook.D5.DemoTostring.Student[] stus = studentService.findAllStudent();
          // 2. 判断数组的内存地址, 是否为null
          if (stus == null) {
              System.out.println("查无信息, 请添加后重试");
              return;
          }
          // 3. 遍历数组, 获取学生信息并打印在控制台
          System.out.println("学号\t\t姓名\t年龄\t生日");
          for (int i = 0; i < stus.length; i++) {
              Ebook.D5.DemoTostring.Student stu = stus[i];
              if (stu != null) {
                  System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
              }
          }
      }

      // 添加学生方法
      public void addStudent() {
          // StudentService studentService = new StudentService();
          // hhh. 键盘接收学生信息
          String id;
          while (true) {
              System.out.println("请输入学生id:");
              id = sc.next();
              boolean flag = studentService.isExists(id);
              if (flag) {
                  System.out.println("学号已被占用, 请重新输入");
              } else {
                  break;
              }
          }

          Ebook.D5.DemoTostring.Student stu = inputStudentInfo(id);

          // 3. 将学生对象,传递给StudentService(业务员)中的addStudent方法
          boolean result = studentService.addStudent(stu);
          // 4. 根据返回的boolean类型结果, 在控制台打印成功\失败
          if (result) {
              System.out.println("添加成功");
          } else {
              System.out.println("添加失败");
          }
      }

      // 键盘录入学生id
      public String inputStudentId() {
          String id;
          while (true) {
              System.out.println("请输入学生id:");
              id = sc.next();
              boolean exists = studentService.isExists(id);
              if (!exists) {
                  System.out.println("您输入的id不存在, 请重新输入:");
              } else {
                  break;
              }
          }
          return id;
      }

      // 键盘录入学生信息
      // 开闭原则: 对扩展内容开放, 对修改内容关闭
    public Ebook.D5.DemoTostring.Student inputStudentInfo(String id){
      return null;
    }
  }
  ```

  StudentController类

  ```java
  import Test22.D19.Ebook.D5.DemoTostring.Student;public class StudentController extends BaseStudentController {
  
      private Scanner sc = new Scanner(System.in);

    // 键盘录入学生信息
      // 开闭原则: 对扩展内容开放, 对修改内容关闭
      @Override
      public Ebook.D5.DemoTostring.Student inputStudentInfo(String id) {
          System.out.println("请输入学生姓名:");
          String name = sc.next();
          System.out.println("请输入学生年龄:");
          String age = sc.next();
          System.out.println("请输入学生生日:");
          String birthday = sc.next();
          Ebook.D5.DemoTostring.Student stu = new Ebook.D5.DemoTostring.Student();
          stu.setId(id);
          stu.setName(name);
          stu.setAge(age);
          stu.setBirthday(birthday);
          return stu;
      }
  }
  ```

  OtherStudentController类

  ```java
  import Test22.D19.Ebook.D5.DemoTostring.Student;public class OtherStudentController extends BaseStudentController {
  
      private Scanner sc = new Scanner(System.in);

    // 键盘录入学生信息
      // 开闭原则: 对扩展内容开放, 对修改内容关闭
      @Override
      public Ebook.D5.DemoTostring.Student inputStudentInfo(String id) {
          System.out.println("请输入学生姓名:");
          String name = sc.next();
          System.out.println("请输入学生年龄:");
          String age = sc.next();
          System.out.println("请输入学生生日:");
          String birthday = sc.next();
          Ebook.D5.DemoTostring.Student stu = new Ebook.D5.DemoTostring.Student(id,name,age,birthday);
          return stu;
      }
  }
  ```

## 3.抽象类

### 3.1抽象类的概述（理解）

​	当我们在做子类共性功能抽取时，有些方法在父类中并没有具体的体现，这个时候就需要抽象类了！

​	在Java中，一个没有方法体的方法应该定义为抽象方法，而类中如果有抽象方法，该类必须定义为抽象类！

### 3.2抽象类的特点（记忆）

- 抽象类和抽象方法必须使用 abstract 关键字修饰

  ```java
  //抽象类的定义
  public abstract class 类名 {}

  //抽象方法的定义
  public abstract void eat();
  ```

- 抽象类中不一定有抽象方法，有抽象方法的类一定是抽象类

- 抽象类不能实例化

- 抽象类可以有构造方法

- 抽象类的子类

  ​	要么重写抽象类中的所有抽象方法

  ​	要么是抽象类

### 3.3抽象类的案例（应用）

- 案例需求

  ​	定义猫类(Cat)和狗类(Dog)

  ​	猫类成员方法：eat（猫吃鱼）drink（喝水…）

  ​	狗类成员方法：eat（狗吃肉）drink（喝水…）

- 实现步骤

  hhh. 猫类和狗类中存在共性内容，应向上抽取出一个动物类（Animal）
  2. 父类Animal中，无法将 eat 方法具体实现描述清楚，所以定义为抽象方法
  3. 抽象方法需要存活在抽象类中，将Animal定义为抽象类
  4. 让 Cat 和 Dog 分别继承 Animal，重写eat方法
  5. 测试类中创建 Cat 和 Dog 对象，调用方法测试

- 代码实现

  - 动物类

  ```java
  public abstract class Animal {
      public void drink(){
          System.out.println("喝水");
      }

      public Animal(){

      }

      public abstract void eat();
  }
  ```

  - 猫类

  ```java
  public class Cat extends Animal {
      @Override
      public void eat() {
          System.out.println("猫吃鱼");
      }
  }
  ```

  - 狗类

  ```java
  public class Dog extends Animal {
      @Override
      public void eat() {
          System.out.println("狗吃肉");
      }
  }
  ```

  - 测试类

  ```java
  public static void main(String[] args) {
          Dog d = new Dog();
          d.eat();
          d.drink();

          Cat c = new Cat();
          c.drink();
          c.eat();

          //Animal a = new Animal();
          //a.eat();
      }
  ```

### 3.4模板设计模式

+ 设计模式

  设计模式（Design pattern）是一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结。
  使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性、程序的重用性。

+ 模板设计模式

  把抽象类整体就可以看做成一个模板，模板中不能决定的东西定义成抽象方法
  让使用模板的类（继承抽象类的类）去重写抽象方法实现需求

+ 模板设计模式的优势

  模板已经定义了通用结构，使用者只需要关心自己需要实现的功能即可

+ 示例代码

  模板类

  ```java
  /*
      作文模板类
   */
  public abstract class CompositionTemplate {

      public final void write(){
          System.out.println("<<我的爸爸>>");

          body();

          System.out.println("啊~ 这就是我的爸爸");

      }

      public abstract void body();
  }
  ```

  实现类A

  ```java
  public class Tom extends CompositionTemplate {

      @Override
      public void body() {
          System.out.println("那是一个秋天, 风儿那么缠绵,记忆中, " +
                  "那天爸爸骑车接我放学回家,我的脚卡在了自行车链当中, 爸爸蹬不动,他就站起来蹬...");
      }
  }
  ```

  实现类B

  ```java
  public class Tony extends CompositionTemplate {
      @Override
      public void body() {

      }

      /*public void write(){

      }*/
  }
  ```

  测试类

  ```java
  public class Test22 {
      public static void main(String[] args) {
          Tom t = new Tom();
          t.write();
      }
  }
  ```

### 3.5final（应用）

- fianl关键字的作用

  - final代表最终的意思，可以修饰成员方法，成员变量，类

- final修饰类、方法、变量的效果

  - fianl修饰类：该类不能被继承（不能有子类，但是可以有父类）

  - final修饰方法：该方法不能被重写

  - final修饰变量：表明该变量是一个常量，不能再次赋值

    + 变量是基本类型,不能改变的是值

    + 变量是引用类型,不能改变的是地址值,但地址里面的内容是可以改变的

    + 举例

      ```java
      public static void main(String[] args){
          final Test22.D19.Ebook.D5.DemoTostring.Student s = new Test22.D19.Ebook.D5.DemoTostring.Student(23);
        	s = new Test22.D19.Ebook.D5.DemoTostring.Student(24);  // 错误
       	s.setAge(24);  // 正确
      }
      ```

### 3.6黑马信息管理系统使用抽象类改进 (应用)

+ 需求

  hhh. 使用抽象类的思想，将BaseStudentController 中的 inputStudentInfo 方法，定义为抽象方法
  2. 将不希望子类重写的方法，使用 final 进行修饰

+ 代码实现

  BaseStudentController类

  ```java
  public abstract class BaseStudentController {
      // 业务员对象
      private StudentService studentService = new StudentService();

      private Scanner sc = new Scanner(System.in);

      // 开启学生管理系统, 并展示学生管理系统菜单
      public final void start() {
          //Scanner sc = new Scanner(System.in);
          studentLoop:
          while (true) {
              System.out.println("--------欢迎来到 <学生> 管理系统--------");
              System.out.println("请输入您的选择: hhh.添加学生  2.删除学生  3.修改学生  4.查看学生  5.退出");
              String choice = sc.next();
              switch (choice) {
                  case "hhh":
                      // System.out.println("添加");
                      addStudent();
                      break;
                  case "2":
                      // System.out.println("删除");
                      deleteStudentById();
                      break;
                  case "3":
                      // System.out.println("修改");
                      updateStudent();
                      break;
                  case "4":
                      // System.out.println("查询");
                      findAllStudent();
                      break;
                  case "5":
                      System.out.println("感谢您使用学生管理系统, 再见!");
                      break studentLoop;
                  default:
                      System.out.println("您的输入有误, 请重新输入");
                      break;
              }
          }
      }

      // 修改学生方法
      public final void updateStudent() {
          String updateId = inputStudentId();
          Ebook.D5.DemoTostring.Student newStu = inputStudentInfo(updateId);
          studentService.updateStudent(updateId, newStu);

          System.out.println("修改成功!");
      }

      // 删除学生方法
      public final void deleteStudentById() {
          String delId = inputStudentId();
          // 3. 调用业务员中的deleteStudentById根据id, 删除学生
          studentService.deleteStudentById(delId);
          // 4. 提示删除成功
          System.out.println("删除成功!");
      }

      // 查看学生方法
      public final void findAllStudent() {
          // hhh. 调用业务员中的获取方法, 得到学生的对象数组
          Ebook.D5.DemoTostring.Student[] stus = studentService.findAllStudent();
          // 2. 判断数组的内存地址, 是否为null
          if (stus == null) {
              System.out.println("查无信息, 请添加后重试");
              return;
          }
          // 3. 遍历数组, 获取学生信息并打印在控制台
          System.out.println("学号\t\t姓名\t年龄\t生日");
          for (int i = 0; i < stus.length; i++) {
              Ebook.D5.DemoTostring.Student stu = stus[i];
              if (stu != null) {
                  System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t\t" + stu.getBirthday());
              }
          }
      }

      // 添加学生方法
      public final void addStudent() {
          // StudentService studentService = new StudentService();
          // hhh. 键盘接收学生信息
          String id;
          while (true) {
              System.out.println("请输入学生id:");
              id = sc.next();
              boolean flag = studentService.isExists(id);
              if (flag) {
                  System.out.println("学号已被占用, 请重新输入");
              } else {
                  break;
              }
          }

          Ebook.D5.DemoTostring.Student stu = inputStudentInfo(id);

          // 3. 将学生对象,传递给StudentService(业务员)中的addStudent方法
          boolean result = studentService.addStudent(stu);
          // 4. 根据返回的boolean类型结果, 在控制台打印成功\失败
          if (result) {
              System.out.println("添加成功");
          } else {
              System.out.println("添加失败");
          }
      }

      // 键盘录入学生id
      public String inputStudentId() {
          String id;
          while (true) {
              System.out.println("请输入学生id:");
              id = sc.next();
              boolean exists = studentService.isExists(id);
              if (!exists) {
                  System.out.println("您输入的id不存在, 请重新输入:");
              } else {
                  break;
              }
          }
          return id;
      }

      // 键盘录入学生信息
      // 开闭原则: 对扩展内容开放, 对修改内容关闭
    public abstract Ebook.D5.DemoTostring.Student inputStudentInfo(String id);
  }
  ```

## 4.代码块

### 4.1代码块概述 (理解)

在Java中，使用 { } 括起来的代码被称为代码块

### 4.2代码块分类 (理解)

+ 局部代码块

  + 位置: 方法中定义

  + 作用: 限定变量的生命周期，及早释放，提高内存利用率

  + 示例代码

    ```java
    public class Test22 {
        /*
            局部代码块
                位置：方法中定义
                作用：限定变量的生命周期，及早释放，提高内存利用率
         */
        public static void main(String[] args) {
            {
                int a = 10;
                System.out.println(a);
            }

           // System.out.println(a);
        }
    }
    ```

+ 构造代码块

  + 位置: 类中方法外定义

  + 特点: 每次构造方法执行的时，都会执行该代码块中的代码，并且在构造方法执行前执行

  + 作用: 将多个构造方法中相同的代码，抽取到构造代码块中，提高代码的复用性

  + 示例代码

    ```java
    public class Test22 {
        /*
            构造代码块:
                位置：类中方法外定义
                特点：每次构造方法执行的时，都会执行该代码块中的代码，并且在构造方法执行前执行
                作用：将多个构造方法中相同的代码，抽取到构造代码块中，提高代码的复用性
         */
        public static void main(String[] args) {
            Test22.D19.Ebook.D5.DemoTostring.Student stu1 = new Test22.D19.Ebook.D5.DemoTostring.Student();
            Test22.D19.Ebook.D5.DemoTostring.Student stu2 = new Test22.D19.Ebook.D5.DemoTostring.Student(10);
        }
    }

    class Test22.D19.Ebook.D5.DemoTostring.Student {

        {
            System.out.println("好好学习");
        }

        public Test22.D19.Ebook.D5.DemoTostring.Student(){
            System.out.println("空参数构造方法");
        }

        public Test22.D19.Ebook.D5.DemoTostring.Student(int a){
            System.out.println("带参数构造方法...........");
        }
    }
    ```

+ 静态代码块

  + 位置: 类中方法外定义

  + 特点: 需要通过static关键字修饰，随着类的加载而加载，并且只执行一次

  + 作用: 在类加载的时候做一些数据初始化的操作

  + 示例代码

    ```java
    public class Test22 {
        /*
            静态代码块:
                位置：类中方法外定义
                特点：需要通过static关键字修饰，随着类的加载而加载，并且只执行一次
                作用：在类加载的时候做一些数据初始化的操作
         */
        public static void main(String[] args) {
            Person p1 = new Person();
            Person p2 = new Person(10);
        }
    }

    class Person {
        static {
            System.out.println("我是静态代码块, 我执行了");
        }

        public Person(){
            System.out.println("我是Person类的空参数构造方法");
        }

        public Person(int a){
            System.out.println("我是Person类的带...........参数构造方法");
        }
    }
    ```

### 4.3黑马信息管理系统使用代码块改进 (应用)

+ 需求

  使用静态代码块，初始化一些学生数据

+ 实现步骤

  hhh. 在StudentDao类中定义一个静态代码块，用来初始化一些学生数据
  2. 将初始化好的学生数据存储到学生数组中

+ 示例代码

  StudentDao类

  ```java
  public class StudentDao {
      // 创建学生对象数组
      private static Ebook.D5.DemoTostring.Student[] stus = new Ebook.D5.DemoTostring.Student[5];

      static {
          Ebook.D5.DemoTostring.Student stu1 = new Ebook.D5.DemoTostring.Student("heima001","张三","23","1999-11-11");
          Ebook.D5.DemoTostring.Student stu2 = new Ebook.D5.DemoTostring.Student("heima002","李四","24","2000-11-11");

          stus[0] = stu1;
          stus[hhh] = stu2;
      }

      // 添加学生方法
      public boolean addStudent(Ebook.D5.DemoTostring.Student stu) {

          // 2. 添加学生到数组
          //2.hhh 定义变量index为-hhh，假设数组已经全部存满，没有null的元素
          int index = -hhh;
          //2.2 遍历数组取出每一个元素，判断是否是null
          for (int i = 0; i < stus.length; i++) {
              Ebook.D5.DemoTostring.Student student = stus[i];
              if(student == null){
                  index = i;
                  //2.3 如果为null，让index变量记录当前索引位置，并使用break结束循环遍历
                  break;
              }
          }

          // 3. 返回是否添加成功的boolean类型状态
          if(index == -hhh){
              // 装满了
              return false;
          }else{
              // 没有装满, 正常添加, 返回true
              stus[index] = stu;
              return true;
          }
      }
      // 查看学生方法
      public Ebook.D5.DemoTostring.Student[] findAllStudent() {
          return stus;
      }

      public void deleteStudentById(String delId) {
          // hhh. 查找id在容器中所在的索引位置
          int index = getIndex(delId);
          // 2. 将该索引位置,使用null元素进行覆盖
          stus[index] = null;
      }

      public int getIndex(String id){
          int index = -hhh;
          for (int i = 0; i < stus.length; i++) {
              Ebook.D5.DemoTostring.Student stu = stus[i];
              if(stu != null && stu.getId().equals(id)){
                  index = i;
                  break;
              }
          }
          return index;
      }

      public void updateStudent(String updateId, Ebook.D5.DemoTostring.Student newStu) {
          // hhh. 查找updateId, 在容器中的索引位置
          int index = getIndex(updateId);
          // 2. 将该索引位置, 使用新的学生对象替换
          stus[index] = newStu;
      }
  }
  ```

  

# day04数组-接口和多态

## hhh.接口

### hhh.1黑马信息管理系统集合改进 (应用)

+ 使用数组容器的弊端

  hhh. 容器长度是固定的，不能根据添加功能自动增长
  2. 没有提供用于赠删改查的方法

+ 优化步骤

  hhh. 创建新的StudentDao类，OtherStudentDao

  2. 创建ArrayList集合容器对象

  3. OtherStudentDao中的方法声明，需要跟StudentDao保持一致

     注意：如果不一致，StudentService中的代码就需要进行修改

  4. 完善方法（添加、删除、修改、查看）

  5. 替换StudentService中的Dao对象

+ 代码实现

  OtherStudentDao类

  ```java
  public class OtherStudentDao {
      // 集合容器
      private static ArrayList<Ebook.D5.DemoTostring.Student> stus = new ArrayList<>();

      static {
          Ebook.D5.DemoTostring.Student stu1 = new Ebook.D5.DemoTostring.Student("heima001","张三","23","1999-11-11");
          Ebook.D5.DemoTostring.Student stu2 = new Ebook.D5.DemoTostring.Student("heima002","李四","24","2000-11-11");

          stus.add(stu1);
          stus.add(stu2);
      }

      // 添加学生方法
      public boolean addStudent(Ebook.D5.DemoTostring.Student stu) {
         stus.add(stu);
         return true;
      }

      // 查看学生方法
      public Ebook.D5.DemoTostring.Student[] findAllStudent() {

          Ebook.D5.DemoTostring.Student[] students = new Ebook.D5.DemoTostring.Student[stus.size()];

          for (int i = 0; i < students.length; i++) {
              students[i] = stus.get(i);
          }

          return students;
      }

      public void deleteStudentById(String delId) {
          // hhh. 查找id在容器中所在的索引位置
          int index = getIndex(delId);
          stus.remove(index);
      }

      public int getIndex(String id){
          int index = -hhh;
          for (int i = 0; i < stus.size(); i++) {
              Ebook.D5.DemoTostring.Student stu = stus.get(i);
              if(stu != null && stu.getId().equals(id)){
                  index = i;
                  break;
              }
          }
          return index;
      }

      public void updateStudent(String updateId, Ebook.D5.DemoTostring.Student newStu) {
          // hhh. 查找updateId, 在容器中的索引位置
          int index = getIndex(updateId);
          stus.set(index, newStu);
      }
  }
  ```

  StudentService类

  ```java
  public class StudentService {
      // 创建StudentDao (库管)
       private OtherStudentDao studentDao = new OtherStudentDao();
    	// 其他方法没有变化,此处省略...
  }
  ```

### hhh.2黑马信息管理系统抽取Dao (应用)

+ 优化步骤

  hhh. 将方法向上抽取，抽取出一个父类 （ BaseStudentDao ）
  2. 方法的功能实现在父类中无法给出具体明确，定义为抽象方法
  3. 让两个类分别继承 BaseStudentDao ，重写内部抽象方法

+ 代码实现

  BaseStudentDao类

  ```java
  public abstract class BaseStudentDao {
      // 添加学生方法
      public abstract boolean addStudent(Ebook.D5.DemoTostring.Student stu);
      // 查看学生方法
      public abstract Ebook.D5.DemoTostring.Student[] findAllStudent();
      // 删除学生方法
      public abstract void deleteStudentById(String delId);
      // 根据id找索引方法
      public abstract int getIndex(String id);
      // 修改学生方法
      public abstract void updateStudent(String updateId, Ebook.D5.DemoTostring.Student newStu);
  }
  ```

  StudentDao类

  ```java
  public class StudentDao extends BaseStudentDao {
    // 其他内容不变,此处省略
  }
  ```

  OtherStudentDao类

  ```java
  public class OtherStudentDao extends BaseStudentDao {
    // 其他内容不变,此处省略
  }
  ```

### hhh.3接口的概述（理解）

+ 接口就是一种公共的规范标准，只要符合规范标准，大家都可以通用。
+ Java中接口存在的两个意义
  hhh. 用来定义规范
  2. 用来做功能的拓展

### hhh.4接口的特点（记忆）

- 接口用关键字interface修饰

  ```java
  public interface 接口名 {}
  ```

- 类实现接口用implements表示

  ```java
  public class 类名 implements 接口名 {}
  ```

- 接口不能实例化

  ​	我们可以创建接口的实现类对象使用

- 接口的子类

  ​	要么重写接口中的所有抽象方法

  ​	要么子类也是抽象类

### hhh.5接口的成员特点（记忆）

- 成员特点

  - 成员变量

    ​	 只能是常量
    ​	 默认修饰符：public static final

  - 构造方法

    ​	没有，因为接口主要是扩展功能的，而没有具体存在

  - 成员方法

    ​	只能是抽象方法

    ​	默认修饰符：public abstract

    ​	关于接口中的方法，JDK8和JDK9中有一些新特性，后面再讲解

- 代码演示

  - 接口

  ```java
  public interface Inter {
      public static final int NUM = 10;

      public abstract void show();
  }
  ```

  - 实现类

  ```java
  class InterImpl implements Inter{

      public void method(){
          // NUM = 20;
          System.out.println(NUM);
      }

      public void show(){

      }
  }
  ```

  - 测试类

  ```java
  public class TestInterface {
      /*
          成员变量: 只能是常量 系统会默认加入三个关键字
                      public static final
          构造方法: 没有
          成员方法: 只能是抽象方法, 系统会默认加入两个关键字
                      public abstract
       */
      public static void main(String[] args) {
          System.out.println(Inter.NUM);
      }

  }
  ```

### hhh.6类和接口的关系（记忆）

- 类与类的关系

  ​	继承关系，只能单继承，但是可以多层继承

- 类与接口的关系

  ​	实现关系，可以单实现，也可以多实现，还可以在继承一个类的同时实现多个接口

- 接口与接口的关系

  ​	继承关系，可以单继承，也可以多继承

### hhh.7黑马信息管理系统使用接口改进 (应用)

+ 实现步骤

  hhh. 将 BaseStudentDao 改进为一个接口
  2. 让 StudentDao 和 OtherStudentDao 去实现这个接口

+ 代码实现

  BaseStudentDao接口

  ```java
  public interface BaseStudentDao {
      // 添加学生方法
      public abstract boolean addStudent(Ebook.D5.DemoTostring.Student stu);
      // 查看学生方法
      public abstract Ebook.D5.DemoTostring.Student[] findAllStudent();
      // 删除学生方法
      public abstract void deleteStudentById(String delId);
      // 根据id找索引方法
      public abstract int getIndex(String id);
      // 修改学生方法
      public abstract void updateStudent(String updateId, Ebook.D5.DemoTostring.Student newStu);
  }
  ```

  StudentDao类

  ```java
  public class StudentDao implements BaseStudentDao {
    // 其他内容不变,此处省略
  }
  ```

  OtherStudentDao类

  ```java
  public class OtherStudentDao implements BaseStudentDao {
    // 其他内容不变,此处省略
  }
  ```

### hhh.8黑马信息管理系统解耦合改进 (应用)

+ 实现步骤

  hhh. 创建factory包，创建 StudentDaoFactory（工厂类）
  2. 提供 static 修改的 getStudentDao 方法，该方法用于创建StudentDao对象并返回

+ 代码实现

  StudentDaoFactory类

  ```java
  public class StudentDaoFactory {
      public static OtherStudentDao getStudentDao(){
          return new OtherStudentDao();
      }
  }
  ```

  StudentService类

  ```java
  public class StudentService {
      // 创建StudentDao (库管)
      // private OtherStudentDao studentDao = new OtherStudentDao();

      // 通过学生库管工厂类, 获取库管对象
      private OtherStudentDao studentDao = StudentDaoFactory.getStudentDao();
  }
  ```

## 2.接口组成更新

### 2.1接口组成更新概述【理解】

- 常量

  public static final

- 抽象方法

  public abstract

- 默认方法(Java 8)

- 静态方法(Java 8)

- 私有方法(Java 9)

### 2.2接口中默认方法【应用】

- 格式

  public default 返回值类型 方法名(参数列表) {   }

- 作用

  解决接口升级的问题

- 范例

  ```java
  public default void show3() {
  }
  ```

- 注意事项

  - 默认方法不是抽象方法，所以不强制被重写。但是可以被重写，重写的时候去掉default关键字
  - public可以省略，default不能省略
  - 如果实现了多个接口，多个接口中存在相同的方法声明，子类就必须对该方法进行重写

### 2.3接口中静态方法【应用】

- 格式

  public static 返回值类型 方法名(参数列表) {   }

- 范例

  ```java
  public static void show() {
  }
  ```

- 注意事项

  - 静态方法只能通过接口名调用，不能通过实现类名或者对象名调用
  - public可以省略，static不能省略

### 2.4接口中私有方法【应用】

- 私有方法产生原因

  Java 9中新增了带方法体的私有方法，这其实在Java 8中就埋下了伏笔：Java 8允许在接口中定义带方法体的默认方法和静态方法。这样可能就会引发一个问题：当两个默认方法或者静态方法中包含一段相同的代码实现时，程序必然考虑将这段实现代码抽取成一个共性方法，而这个共性方法是不需要让别人使用的，因此用私有给隐藏起来，这就是Java 9增加私有方法的必然性

- 定义格式

  - 格式1

    private 返回值类型 方法名(参数列表) {   }

  - 范例1

    ```java
    private void show() {
    }
    ```

  - 格式2

    private static 返回值类型 方法名(参数列表) {   }

  - 范例2

    ```java
    private static void method() {
    }
    ```

- 注意事项

  - 默认方法可以调用私有的静态方法和非静态方法
  - 静态方法只能调用私有的静态方法

## 3.多态

### 3.1多态的概述（记忆）

- 什么是多态

  ​	同一个对象，在不同时刻表现出来的不同形态

- 多态的前提

  - 要有继承或实现关系
  - 要有方法的重写
  - 要有父类引用指向子类对象

- 代码演示

  ```java
  class Animal {
      public void eat(){
          System.out.println("动物吃饭");
      }
  }

  class Cat extends Animal {
      @Override
      public void eat() {
          System.out.println("猫吃鱼");
      }
  }

  public class Test1Polymorphic {
      /*
          多态的前提:

              hhh. 要有(继承 \ 实现)关系
              2. 要有方法重写
              3. 要有父类引用, 指向子类对象
       */
      public static void main(String[] args) {
          // 当前事物, 是一只猫
          Cat c = new Cat();
          // 当前事物, 是一只动物
          Animal a = new Cat();
          a.eat();

      }
  }
  ```

### 3.2多态中的成员访问特点（记忆）

- 成员访问特点

  - 成员变量

    ​	编译看父类，运行看父类

  - 成员方法

    ​	编译看父类，运行看子类

- 代码演示

  ```java
  class Fu {
      int num = 10;

      public void method(){
          System.out.println("Fu.. method");
      }
  }

  class Zi extends Fu {
      int num = 20;

      public void method(){
          System.out.println("Zi.. method");
      }
  }

  public class Test2Polymorpic {
      /*
           多态的成员访问特点:

                  成员变量: 编译看左边 (父类), 运行看左边 (父类)

                  成员方法: 编译看左边 (父类), 运行看右边 (子类)
       */
      public static void main(String[] args) {
          Fu f = new Zi();
          System.out.println(f.num);
          f.method();
      }
  }
  ```

### 3.3多态的好处和弊端（记忆）

- 好处

  ​	提高程序的扩展性。定义方法时候，使用父类型作为参数，在使用的时候，使用具体的子类型参与操作

- 弊端

  ​	不能使用子类的特有成员

### 3.4多态中的转型（应用）

- 向上转型

  ​	父类引用指向子类对象就是向上转型

- 向下转型

  ​	格式：子类型 对象名 = (子类型)父类引用;

- 代码演示

  ```java
  class Fu {
      public void show(){
          System.out.println("Fu..show...");
      }
  }

  class Zi extends Fu {
      @Override
      public void show() {
          System.out.println("Zi..show...");
      }

      public void method(){
          System.out.println("我是子类特有的方法, method");
      }
  }

  public class Test3Polymorpic {
      public static void main(String[] args) {
          // hhh. 向上转型 : 父类引用指向子类对象
          Fu f = new Zi();
          f.show();
          // 多态的弊端: 不能调用子类特有的成员
          // f.method();

          // A: 直接创建子类对象
          // B: 向下转型

          // 2. 向下转型 : 从父类类型, 转换回子类类型
          Zi z = (Zi) f;
          z.method();
      }
  }
  ```

### 3.5多态中转型存在的风险和解决方案 (应用)

+ 风险

  如果被转的引用类型变量,对应的实际类型和目标类型不是同一种类型,那么在转换的时候就会出现ClassCastException

+ 解决方案

  + 关键字

    instanceof

  + 使用格式

    变量名 instanceof 类型

    通俗的理解：判断关键字左边的变量，是否是右边的类型，返回boolean类型结果

+ 代码演示

  ```java
  abstract class Animal {
      public abstract void eat();
  }

  class Dog extends Animal {
      public void eat() {
          System.out.println("狗吃肉");
      }

      public void watchHome(){
          System.out.println("看家");
      }
  }

  class Cat extends Animal {
      public void eat() {
          System.out.println("猫吃鱼");
      }
  }

  public class Test4Polymorpic {
      public static void main(String[] args) {
          useAnimal(new Dog());
          useAnimal(new Cat());
      }

      public static void useAnimal(Animal a){  // Animal a = new Dog();
                                               // Animal a = new Cat();
          a.eat();
          //a.watchHome();

  //        Dog dog = (Dog) a;
  //        dog.watchHome();  // ClassCastException  类型转换异常

          // 判断a变量记录的类型, 是否是Dog
          if(a instanceof Dog){
              Dog dog = (Dog) a;
              dog.watchHome();
          }
      }

  }
  ```

### 3.6黑马信息管理系统多态改进 (应用)

+ 实现步骤

  hhh. StudentDaoFactory类中方法的返回值定义成父类类型BaseStudentDao
  2. StudentService中接收方法返回值的类型定义成父类类型BaseStudentDao

+ 代码实现

  StudentDaoFactory类

  ```java
  public class StudentDaoFactory {
      public static BaseStudentDao getStudentDao(){
          return new OtherStudentDao();
      }
  }
  ```

  StudentService类

  ```java
  public class StudentService {
      // 创建StudentDao (库管)
      // private OtherStudentDao studentDao = new OtherStudentDao();

      // 通过学生库管工厂类, 获取库管对象
      private BaseStudentDao studentDao = StudentDaoFactory.getStudentDao();
  }
  ```



# day05方法-内部类和Lambda表达式

## hhh.内部类

### hhh.hhh 内部类的基本使用（理解）

- 内部类概念

  - 在一个类中定义一个类。举例：在一个类A的内部定义一个类B，类B就被称为内部类

- 内部类定义格式

  - 格式&举例：

    ```java
    /*
    	格式：
        class 外部类名{
        	修饰符 class 内部类名{

        	}
        }
    */

    class Outer {
        public class Inner {

        }
    }
    ```

- 内部类的访问特点

  - 内部类可以直接访问外部类的成员，包括私有
  - 外部类要访问内部类的成员，必须创建对象

- 示例代码：

  ```java
  /*
      内部类访问特点：
          内部类可以直接访问外部类的成员，包括私有
          外部类要访问内部类的成员，必须创建对象
   */
  public class Outer {
      private int num = 10;
      public class Inner {
          public void show() {
              System.out.println(num);
          }
      }
      public void method() {
          Inner i = new Inner();
          i.show();
      }
  }
  ```

### hhh.2 成员内部类（理解）

- 成员内部类的定义位置

  - 在类中方法，跟成员变量是一个位置

- 外界创建成员内部类格式

  - 格式：外部类名.内部类名 对象名 = 外部类对象.内部类对象;
  - 举例：Outer.Inner oi = new Outer().new Inner();

- 私有成员内部类

  - 将一个类，设计为内部类的目的，大多数都是不想让外界去访问，所以内部类的定义应该私有化，私有化之后，再提供一个可以让外界调用的方法，方法内部创建内部类对象并调用。

  - 示例代码：

    ```java
    class Outer {
        private int num = 10;
        private class Inner {
            public void show() {
                System.out.println(num);
            }
        }
        public void method() {
            Inner i = new Inner();
            i.show();
        }
    }
    public class InnerDemo {
        public static void main(String[] args) {
    		//Outer.Inner oi = new Outer().new Inner();
    		//oi.show();
            Outer o = new Outer();
            o.method();
        }
    }
    ```

- 静态成员内部类

  + 静态成员内部类访问格式：外部类名.内部类名 对象名 = new 外部类名.内部类名();

  + 静态成员内部类中的静态方法：外部类名.内部类名.方法名();

  + 示例代码

    ```java
    class Outer {
        static class Inner {
            public void show(){
                System.out.println("inner..show");
            }

            public static void method(){
                System.out.println("inner..method");
            }
        }
    }

    public class Test3Innerclass {
        /*
            静态成员内部类演示
         */
        public static void main(String[] args) {
            // 外部类名.内部类名 对象名 = new 外部类名.内部类名();
            Outer.Inner oi = new Outer.Inner();
            oi.show();

            Outer.Inner.method();
        }
    }
    ```

### hhh.3 局部内部类（理解）

- 局部内部类定义位置

  - 局部内部类是在方法中定义的类

- 局部内部类方式方式

  - 局部内部类，外界是无法直接使用，需要在方法内部创建对象并使用
  - 该类可以直接访问外部类的成员，也可以访问方法内的局部变量

- 示例代码

  ```java
  class Outer {
      private int num = 10;
      public void method() {
          int num2 = 20;
          class Inner {
              public void show() {
                  System.out.println(num);
                  System.out.println(num2);
              }
          }
          Inner i = new Inner();
          i.show();
      }
  }
  public class OuterDemo {
      public static void main(String[] args) {
          Outer o = new Outer();
          o.method();
      }
  }

  ```

### hhh.4 匿名内部类（应用）

- 匿名内部类的前提

  - 存在一个类或者接口，这里的类可以是具体类也可以是抽象类

- 匿名内部类的格式

  - 格式：new 类名 ( ) {  重写方法 }    new  接口名 ( ) { 重写方法 }

  - 举例：

    ```java
    new Inter(){
        @Override
        public void method(){}
    }
    ```

- 匿名内部类的本质

  - 本质：是一个继承了该类或者实现了该接口的子类匿名对象

- 匿名内部类的细节

  - 匿名内部类可以通过多态的形式接受

    ```java
    Inter i = new Inter(){
      @Override
        public void method(){

        }
    }
    ```

- 匿名内部类直接调用方法

  ```java
  interface Inter{
      void method();
  }

  class Test22{
      public static void main(String[] args){
          new Inter(){
              @Override
              public void method(){
                  System.out.println("我是匿名内部类");
              }
          }.method();	// 直接调用方法
      }
  }
  ```

### hhh.5 匿名内部类在开发中的使用（应用）

- 匿名内部类在开发中的使用

  - 当发现某个方法需要，接口或抽象类的子类对象，我们就可以传递一个匿名内部类过去，来简化传统的代码

- 示例代码：

  ```java
  /*
      游泳接口
   */
  interface Swimming {
      void swim();
  }

  public class TestSwimming {
      public static void main(String[] args) {
          goSwimming(new Swimming() {
              @Override
              public void swim() {
                  System.out.println("铁汁, 我们去游泳吧");
              }
          });
      }

      /**
       * 使用接口的方法
       */
      public static void goSwimming(Swimming swimming){
          /*
              Swimming swim = new Swimming() {
                  @Override
                  public void swim() {
                      System.out.println("铁汁, 我们去游泳吧");
                  }
              }
           */
          swimming.swim();
      }
  }
  ```

## 2.Lambda表达式

### 2.1体验Lambda表达式【理解】

- 代码演示

  ```java
  /*
      游泳接口
   */
  interface Swimming {
      void swim();
  }

  public class TestSwimming {
      public static void main(String[] args) {
          // 通过匿名内部类实现
          goSwimming(new Swimming() {
              @Override
              public void swim() {
                  System.out.println("铁汁, 我们去游泳吧");
              }
          });

          /*  通过Lambda表达式实现
              理解: 对于Lambda表达式, 对匿名内部类进行了优化
           */
          goSwimming(() -> System.out.println("铁汁, 我们去游泳吧"));
      }

      /**
       * 使用接口的方法
       */
      public static void goSwimming(Swimming swimming) {
          swimming.swim();
      }
  }
  ```

- 函数式编程思想概述

  在数学中，函数就是有输入量、输出量的一套计算方案，也就是“拿数据做操作”

  面向对象思想强调“必须通过对象的形式来做事情”

  函数式思想则尽量忽略面向对象的复杂语法：“强调做什么，而不是以什么形式去做”

  而我们要学习的Lambda表达式就是函数式思想的体现

### 2.2Lambda表达式的标准格式【理解】

- 格式：

  ​	(形式参数) -> {代码块}

  - 形式参数：如果有多个参数，参数之间用逗号隔开；如果没有参数，留空即可
  - ->：由英文中画线和大于符号组成，固定写法。代表指向动作
  - 代码块：是我们具体要做的事情，也就是以前我们写的方法体内容

- 组成Lambda表达式的三要素：

  - 形式参数，箭头，代码块

### 2.3Lambda表达式练习1【应用】

- Lambda表达式的使用前提

  - 有一个接口
  - 接口中有且仅有一个抽象方法

- 练习描述

  ​	无参无返回值抽象方法的练习

- 操作步骤

  - 定义一个接口(Eatable)，里面定义一个抽象方法：void eat();
  - 定义一个测试类(EatableDemo)，在测试类中提供两个方法
    - 一个方法是：useEatable(Eatable e)
    - 一个方法是主方法，在主方法中调用useEatable方法

- 示例代码

  ```java
  //接口
  public interface Eatable {
      void eat();
  }
  //实现类
  public class EatableImpl implements Eatable {
      @Override
      public void eat() {
          System.out.println("一天一苹果，医生远离我");
      }
  }
  //测试类
  public class EatableDemo {
      public static void main(String[] args) {
          //在主方法中调用useEatable方法
          Eatable e = new EatableImpl();
          useEatable(e);

          //匿名内部类
          useEatable(new Eatable() {
              @Override
              public void eat() {
                  System.out.println("一天一苹果，医生远离我");
              }
          });

          //Lambda表达式
          useEatable(() -> {
              System.out.println("一天一苹果，医生远离我");
          });
      }

      private static void useEatable(Eatable e) {
          e.eat();
      }
  }
  ```

### 2.4Lambda表达式练习2【应用】

- 练习描述

  有参无返回值抽象方法的练习

- 操作步骤

  - 定义一个接口(Flyable)，里面定义一个抽象方法：void fly(String s);
  - 定义一个测试类(FlyableDemo)，在测试类中提供两个方法
    - 一个方法是：useFlyable(Flyable f)
    - 一个方法是主方法，在主方法中调用useFlyable方法

- 示例代码

  ```java
  public interface Flyable {
      void fly(String s);
  }

  public class FlyableDemo {
      public static void main(String[] args) {
          //在主方法中调用useFlyable方法
          //匿名内部类
          useFlyable(new Flyable() {
              @Override
              public void fly(String s) {
                  System.out.println(s);
                  System.out.println("飞机自驾游");
              }
          });
          System.out.println("--------");

          //Lambda
          useFlyable((String s) -> {
              System.out.println(s);
              System.out.println("飞机自驾游");
          });

      }

      private static void useFlyable(Flyable f) {
          f.fly("风和日丽，晴空万里");
      }
  }
  ```

### 2.5Lambda表达式练习3【应用】

- 练习描述

  有参有返回值抽象方法的练习

- 操作步骤

  - 定义一个接口(Addable)，里面定义一个抽象方法：int add(int x,int y);
  - 定义一个测试类(AddableDemo)，在测试类中提供两个方法
    - 一个方法是：useAddable(Addable a)
    - 一个方法是主方法，在主方法中调用useAddable方法

- 示例代码

  ```java
  public interface Addable {
      int add(int x,int y);
  }

  public class AddableDemo {
      public static void main(String[] args) {
          //在主方法中调用useAddable方法
          useAddable((int x,int y) -> {
              return x + y;
          });

      }

      private static void useAddable(Addable a) {
          int sum = a.add(10, 20);
          System.out.println(sum);
      }
  }
  ```

### 2.6Lambda表达式的省略模式【应用】

- 省略的规则

  - 参数类型可以省略。但是有多个参数的情况下，不能只省略一个
  - 如果参数有且仅有一个，那么小括号可以省略
  - 如果代码块的语句只有一条，可以省略大括号和分号，和return关键字

- 代码演示

  ```java
  public interface Addable {
      int add(int x, int y);
  }

  public interface Flyable {
      void fly(String s);
  }

  public class LambdaDemo {
      public static void main(String[] args) {
  //        useAddable((int x,int y) -> {
  //            return x + y;
  //        });
          //参数的类型可以省略
          useAddable((x, y) -> {
              return x + y;
          });

  //        useFlyable((String s) -> {
  //            System.out.println(s);
  //        });
          //如果参数有且仅有一个，那么小括号可以省略
  //        useFlyable(s -> {
  //            System.out.println(s);
  //        });

          //如果代码块的语句只有一条，可以省略大括号和分号
          useFlyable(s -> System.out.println(s));

          //如果代码块的语句只有一条，可以省略大括号和分号，如果有return，return也要省略掉
          useAddable((x, y) -> x + y);
      }

      private static void useFlyable(Flyable f) {
          f.fly("风和日丽，晴空万里");
      }

      private static void useAddable(Addable a) {
          int sum = a.add(10, 20);
          System.out.println(sum);
      }
  }
  ```

### 2.7Lambda表达式的使用前提【理解】

- 使用Lambda必须要有接口
- 并且要求接口中有且仅有一个抽象方法

### 2.8Lambda表达式和匿名内部类的区别【理解】

- 所需类型不同
  - 匿名内部类：可以是接口，也可以是抽象类，还可以是具体类
  - Lambda表达式：只能是接口
- 使用限制不同
  - 如果接口中有且仅有一个抽象方法，可以使用Lambda表达式，也可以使用匿名内部类
  - 如果接口中多于一个抽象方法，只能使用匿名内部类，而不能使用Lambda表达式
- 实现原理不同
  - 匿名内部类：编译之后，产生一个单独的.class字节码文件
  - Lambda表达式：编译之后，没有一个单独的.class字节码文件。对应的字节码会在运行的时候动态生成



# day06_Debug-常用API01

## hhh.API

### hhh.hhh API概述【理解】

- 什么是API

  ​	API (Application Programming Interface) ：应用程序编程接口

- java中的API

  ​	指的就是 JDK 中提供的各种功能的 Java类，这些类将底层的实现封装了起来，我们不需要关心这些类是如何实现的，只需要学习这些类如何使用即可，我们可以通过帮助文档来学习这些API如何使用。

### hhh.2 如何使用API帮助文档【应用】

- 打开帮助文档

![01](img\01.png)

- 找到索引选项卡中的输入框

![02](img\02.png)

- 在输入框中输入Random

![03](img\03.png)

- 看类在哪个包下

![04](img\04.png)

- 看类的描述

![05](img\05.png)

- 看构造方法

![06](img\06.png)

- 看成员方法

![07](img\07.png)

## 2.常用API

### 2.hhh Math（应用）

- hhh、Math类概述

  - Math 包含执行基本数字运算的方法

- 2、Math中方法的调用方式

  - Math类中无构造方法，但内部的方法都是静态的，则可以通过   **类名.进行调用**

- 3、Math类的常用方法

  | 方法名    方法名                               | 说明                         |
  | ---------------------------------------- | -------------------------- |
  | public static int   abs(int a)           | 返回参数的绝对值                   |
  | public static double ceil(double a)      | 返回大于或等于参数的最小double值，等于一个整数 |
  | public static double floor(double a)     | 返回小于或等于参数的最大double值，等于一个整数 |
  | public   static int round(float a)       | 按照四舍五入返回最接近参数的int          |
  | public static int   max(int a,int b)     | 返回两个int值中的较大值              |
  | public   static int min(int a,int b)     | 返回两个int值中的较小值              |
  | public   static double pow (double a,double b) | 返回a的b次幂的值                  |
  | public   static double random()          | 返回值为double的正值，[0.0,hhh.0)    |

### 2.2 System（应用）

- System类的常用方法
  | 方法名                                      | 说明                            |
  | ---------------------------------------- | ----------------------------- |
  | public   static void exit(int status)    | 终止当前运行的   Java   虚拟机，非零表示异常终止 |
  | public   static long currentTimeMillis() | 返回当前时间(以毫秒为单位)                |

- 示例代码

  - 需求：在控制台输出1-10000，计算这段代码执行了多少毫秒

  ```java
  public class SystemDemo {
      public static void main(String[] args) {
          // 获取开始的时间节点
          long start = System.currentTimeMillis();
          for (int i = hhh; i <= 10000; i++) {
              System.out.println(i);
          }
          // 获取代码运行结束后的时间节点
          long end = System.currentTimeMillis();
          System.out.println("共耗时：" + (end - start) + "毫秒");
      }
  }
  ```

### 2.3 Object类的toString方法（应用）

- Object类概述

  - Object 是类层次结构的根，每个类都可以将 Object 作为超类。所有类都直接或者间接的继承自该类，换句话说，该类所具备的方法，所有类都会有一份

- 查看方法源码的方式

  - 选中方法，按下Ctrl + B

- 重写toString方法的方式

  - hhh. Alt + Insert 选择toString
  - hhh. 在类的空白区域，右键 -> Generate -> 选择toString

- toString方法的作用：

  - 以良好的格式，更方便的展示对象中的属性值

- 示例代码：

  ```java
  class Test22.D19.Ebook.D5.DemoTostring.Student extends Object {
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  public class ObjectDemo {
      public static void main(String[] args) {
          Test22.D19.Ebook.D5.DemoTostring.Student s = new Test22.D19.Ebook.D5.DemoTostring.Student();
          s.setName("林青霞");
          s.setAge(30);
          System.out.println(s);
          System.out.println(s.toString());
      }
  }
  ```

- 运行结果：

  ```java
  Test22.D19.Ebook.D5.DemoTostring.Student{name='林青霞', age=30}
  Test22.D19.Ebook.D5.DemoTostring.Student{name='林青霞', age=30}
  ```

### 2.4 Object类的equals方法（应用）

- equals方法的作用

  - 用于对象之间的比较，返回true和false的结果
  - 举例：s1.equals(s2);    s1和s2是两个对象

- 重写equals方法的场景

  - 不希望比较对象的地址值，想要结合对象属性进行比较的时候。

- 重写equals方法的方式

  - hhh. alt + insert  选择equals() and hashCode()，IntelliJ Default，一路next，finish即可
  - hhh. 在类的空白区域，右键 -> Generate -> 选择equals() and hashCode()，后面的同上。

- 示例代码：

  ```java
  class Test22.D19.Ebook.D5.DemoTostring.Student {
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      @Override
      public boolean equals(Object o) {
          //this -- s1
          //o -- s2
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;

          Test22.D19.Ebook.D5.DemoTostring.Student student = (Test22.D19.Ebook.D5.DemoTostring.Student) o; //student -- s2

          if (age != student.age) return false;
          return name != null ? name.equals(student.name) : student.name == null;
      }
  }
  public class ObjectDemo {
      public static void main(String[] args) {
          Test22.D19.Ebook.D5.DemoTostring.Student s1 = new Test22.D19.Ebook.D5.DemoTostring.Student();
          s1.setName("林青霞");
          s1.setAge(30);

          Test22.D19.Ebook.D5.DemoTostring.Student s2 = new Test22.D19.Ebook.D5.DemoTostring.Student();
          s2.setName("林青霞");
          s2.setAge(30);

          //需求：比较两个对象的内容是否相同
          System.out.println(s1.equals(s2));
      }
  }

  ```

- 面试题

  ```java
  // 看程序,分析结果
  String s = “abc”;
  StringBuilder sb = new StringBuilder(“abc”);
  s.equals(sb);
  sb.equals(s);

  public class InterviewTest {
      public static void main(String[] args) {
          String s1 = "abc";
          StringBuilder sb = new StringBuilder("abc");
          //hhh.此时调用的是String类中的equals方法.
          //保证参数也是字符串,否则不会比较属性值而直接返回false
          //System.out.println(s1.equals(sb)); // false

          //StringBuilder类中是没有重写equals方法,用的就是Object类中的.
          System.out.println(sb.equals(s1)); // false
      }
  }
  ```

### 2.5 Objects (应用)

+ 常用方法

  | 方法名                                      | 说明               |
  | ---------------------------------------- | ---------------- |
  | public static String toString(对象)        | 返回参数中对象的字符串表示形式。 |
  | public static String toString(对象, 默认字符串) | 返回对象的字符串表示形式。    |
  | public static Boolean isNull(对象)         | 判断对象是否为空         |
  | public static Boolean nonNull(对象)        | 判断对象是否不为空        |

+ 示例代码

  学生类

  ```java
  class Test22.D19.Ebook.D5.DemoTostring.Student {
        private String name;
        private int age;

        public Test22.D19.Ebook.D5.DemoTostring.Student() {
        }

        public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

        @Override
        public String toString() {
            return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
  ```

  测试类

  ```java
  public class MyObjectsDemo {
            public static void main(String[] args) {
        //        public static String toString(对象): 返回参数中对象的字符串表示形式。
        //        Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student(Test22.D19.Student50);
        //        String result = Objects.toString(s);
        //        System.out.println(result);
        //        System.out.println(s);

        //        public static String toString(对象, 默认字符串): 返回对象的字符串表示形式。如果对象为空,那么返回第二个参数.
                //Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student("小花同学",23)Test22.D19.Ebook.D5.DemoTostring.Student   //        Ebook.D5.DemoTostring.Student s = null;
    Test22.D19.Ebook.D5.DemoTostring.Student       String result = Objects.toString(s, "随便写一个");
        //        System.out.println(result);

        //        public static Boolean isNull(对象): 判断对象是否为空
                //Ebook.D5.DemoTostring.Student s = null;
        //  Test22.D19.Studenttudent s = new Ebook.D5.DemoTostring.Student();
     Test22.D19.Ebook.D5.DemoTostring.Student      booTest.D19.Studentsult = Objects.isNull(s);
        //        System.out.println(result);

        //        public static Boolean nonNull(对象): 判断对象是否不为空
                //Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student();
             Test22.D19.Studentent sTest.D19.Ebook.D5.DemoTostring.Student;
                boolean result = Objects.nonNull(s);
                System.out.println(result);
            }
    }
  ```


### 2.6 BigDecimal (应用)

+ 作用

  可以用来进行精确计算


+ 构造方法

  | 方法名                    | 说明        |
  | ---------------------- | --------- |
  | BigDecimal(double val) | 参数为double |
  | BigDecimal(String val) | 参数为String |

+ 常用方法

  | 方法名                                      | 说明   |
  | ---------------------------------------- | ---- |
  | public BigDecimal add(另一个BigDecimal对象)   | 加法   |
  | public BigDecimal subtract (另一个BigDecimal对象) | 减法   |
  | public BigDecimal multiply (另一个BigDecimal对象) | 乘法   |
  | public BigDecimal divide (另一个BigDecimal对象) | 除法   |
  | public BigDecimal divide (另一个BigDecimal对象，精确几位，舍入模式) | 除法   |

+ 总结

  hhh. BigDecimal是用来进行精确计算的
  2. 创建BigDecimal的对象，构造方法使用参数类型为字符串的。
  3. 四则运算中的除法，如果除不尽请使用divide的三个参数的方法。

  代码示例：

  ```java
  BigDecimal divide = bd1.divide(参与运算的对象,小数点后精确到多少位,舍入模式);
  参数1 ，表示参与运算的BigDecimal 对象。
  参数2 ，表示小数点后面精确到多少位
  参数3 ，舍入模式
    BigDecimal.ROUND_UP  进一法
    BigDecimal.ROUND_FLOOR 去尾法
    BigDecimal.ROUND_HALF_UP 四舍五入
  ```

## 3.包装类

### 3.hhh 基本类型包装类（记忆）

- 基本类型包装类的作用

   将基本数据类型封装成对象的好处在于可以在对象中定义更多的功能方法操作该数据

   常用的操作之一：用于基本数据类型与字符串之间的转换

- 基本类型对应的包装类

  | 基本数据类型  | 包装类       |
  | ------- | --------- |
  | byte    | Byte      |
  | short   | Short     |
  | int     | Integer   |
  | long    | Long      |
  | float   | Float     |
  | double  | Double    |
  | char    | Character |
  | boolean | Boolean   |

### 3.2 Integer类（应用）

- Integer类概述

   包装一个对象中的原始类型 int 的值

- Integer类构造方法

  | 方法名                                     | 说明                           |
  | --------------------------------------- | ---------------------------- |
  | public Integer(int   value)             | 根据 int 值创建 Integer 对象(过时)    |
  | public Integer(String s)                | 根据 String 值创建 Integer 对象(过时) |
  | public static Integer valueOf(int i)    | 返回表示指定的 int 值的 Integer   实例  |
  | public static Integer valueOf(String s) | 返回一个保存指定值的 Integer 对象 String |

- 示例代码

  ```java
  public class IntegerDemo {
      public static void main(String[] args) {
          //public Integer(int value)：根据 int 值创建 Integer 对象(过时)
          Integer i1 = new Integer(100);
          System.out.println(i1);

          //public Integer(String s)：根据 String 值创建 Integer 对象(过时)
          Integer i2 = new Integer("100");
  //        Integer i2 = new Integer("abc"); //NumberFormatException
          System.out.println(i2);
          System.out.println("--------");

          //public static Integer valueOf(int i)：返回表示指定的 int 值的 Integer 实例
          Integer i3 = Integer.valueOf(100);
          System.out.println(i3);

          //public static Integer valueOf(String s)：返回一个保存指定值的Integer对象 String
          Integer i4 = Integer.valueOf("100");
          System.out.println(i4);
      }
  }
  ```

### 3.3 自动拆箱和自动装箱（理解）

- 自动装箱

  ​	把基本数据类型转换为对应的包装类类型

- 自动拆箱

  ​	把包装类类型转换为对应的基本数据类型

- 示例代码

  ```java
  Integer i = 100;  // 自动装箱
  i += 200;         // i = i + 200;  i + 200 自动拆箱；i = i + 200; 是自动装箱
  ```

### 3.4 int和String类型的相互转换（记忆）

- int转换为String

  - 转换方式

    - 方式一：直接在数字后加一个空字符串
    - 方式二：通过String类静态方法valueOf()

  - 示例代码

    ```java
    public class IntegerDemo {
        public static void main(String[] args) {
            //int --- String
            int number = 100;
            //方式1
            String s1 = number + "";
            System.out.println(s1);
            //方式2
            //public static String valueOf(int i)
            String s2 = String.valueOf(number);
            System.out.println(s2);
            System.out.println("--------");
        }
    }
    ```

- String转换为int

  - 转换方式

    - 方式一：先将字符串数字转成Integer，再调用valueOf()方法
    - 方式二：通过Integer静态方法parseInt()进行转换

  - 示例代码

    ```java
    public class IntegerDemo {
        public static void main(String[] args) {
            //String --- int
            String s = "100";
            //方式1：String --- Integer --- int
            Integer i = Integer.valueOf(s);
            //public int intValue()
            int x = i.intValue();
            System.out.println(x);
            //方式2
            //public static int parseInt(String s)
            int y = Integer.parseInt(s);
            System.out.println(y);
        }
    }
    ```

### 3.5 字符串数据排序案例（应用）

- 案例需求

  ​	有一个字符串：“91 27 46 38 50”，请写程序实现最终输出结果是：27 38 46 50 91

- 代码实现

  ```java
  public class IntegerTest {
      public static void main(String[] args) {
          //定义一个字符串
          String s = "91 27 46 38 50";

          //把字符串中的数字数据存储到一个int类型的数组中
          String[] strArray = s.split(" ");
  //        for(int i=0; i<strArray.length; i++) {
  //            System.out.println(strArray[i]);
  //        }

          //定义一个int数组，把 String[] 数组中的每一个元素存储到 int 数组中
          int[] arr = new int[strArray.length];
          for(int i=0; i<arr.length; i++) {
              arr[i] = Integer.parseInt(strArray[i]);
          }

          //对 int 数组进行排序
          Arrays.sort(arr);

        	for(int i=0; i<arr.length; i++){
           System.out.print(arr[i] + " ");
        	}
  }
  ```

## 4.递归

### 4.hhh 递归【应用】

- 递归的介绍

  - 以编程的角度来看，递归指的是方法定义中调用方法本身的现象
  - 把一个复杂的问题层层转化为一个与原问题相似的规模较小的问题来求解
  - 递归策略只需少量的程序就可描述出解题过程所需要的多次重复计算

- 递归的基本使用

  ```java
  public class MyFactorialDemo2 {
      public static void main(String[] args) {
          int sum = getSum(100);
          System.out.println(sum);
      }

      private static int getSum(int i) {
          //hhh- 100之间的和
              //100 + (hhh-99之间的和)
                      // 99 + (hhh- 98之间的和)
                          //....
                              //hhh
          //方法的作用: 求 hhh- i 之间和
          if(i == hhh){
              return hhh;
          }else{
              return i + getSum(i -hhh);
          }
      }
  }
  ```

- 递归的注意事项

  - 递归一定要有出口。否则内存溢出
  - 递归虽然有出口，但是递归的次数也不宜过多。否则内存溢出

### 4.2 递归求阶乘【应用】

- 案例需求

  ​	用递归求5的阶乘，并把结果在控制台输出

- 代码实现

  ```java
  public class DiGuiDemo01 {
      public static void main(String[] args) {
          //调用方法
          int result = jc(5);
          //输出结果
          System.out.println("5的阶乘是：" + result);
      }

      //定义一个方法，用于递归求阶乘，参数为一个int类型的变量
      public static int jc(int n) {
          //在方法内部判断该变量的值是否是1
          if(n == hhh) {
              //是：返回1
              return hhh;
          } else {
              //不是：返回n*(n-hhh)!
              return n*jc(n-hhh);
          }
      }
  }
  ```

- 内存图

  ![08_递归内存图](img\08_递归内存图.png)

## 5.数组的高级操作

### 5.hhh 二分查找 (理解)

+ 二分查找概述

  查找指定元素在数组中的位置时,以前的方式是通过遍历,逐个获取每个元素,看是否是要查找的元素,这种方式当数组元素较多时,查找的效率很低

  二分查找也叫折半查找,每次可以去掉一半的查找范围,从而提高查找的效率


+ 需求

  在数组{hhh,2,3,4,5,6,7,8,9,10}中,查找某个元素的位置

+ 实现步骤

  hhh. 定义两个变量，表示要查找的范围。默认min = 0 ，max = 最大索引
  2. 循环查找，但是min <= max
  3. 计算出mid的值
  4. 判断mid位置的元素是否为要查找的元素，如果是直接返回对应索引
  5. 如果要查找的值在mid的左半边，那么min值不变，max = mid -hhh.继续下次循环查找
  6. 如果要查找的值在mid的右半边，那么max值不变，min = mid + hhh.继续下次循环查找
  7. 当min > max 时，表示要查找的元素在数组中不存在，返回-hhh.

+ 代码实现

  ```java
  public class MyBinarySearchDemo {
      public static void main(String[] args) {
          int [] arr = {hhh,2,3,4,5,6,7,8,9,10};
          int number = 11;

          //hhh,我现在要干嘛? --- 二分查找
          //2.我干这件事情需要什么? --- 数组 元素
          //3,我干完了,要不要把结果返回调用者 --- 把索引返回给调用者
          int index = binarySearchForIndex(arr,number);
          System.out.println(index);
      }

      private static int binarySearchForIndex(int[] arr, int number) {
          //hhh,定义查找的范围
          int min = 0;
          int max = arr.length - hhh;
          //2.循环查找 min <= max
          while(min <= max){
              //3.计算出中间位置 mid
              int mid = (min + max) >> hhh;
              //mid指向的元素 > number
              if(arr[mid] > number){
                  //表示要查找的元素在左边.
                  max = mid -hhh;
              }else if(arr[mid] < number){
                  //mid指向的元素 < number
                  //表示要查找的元素在右边.
                  min = mid + hhh;
              }else{
                  //mid指向的元素 == number
                  return mid;
              }
          }
          //如果min大于了max就表示元素不存在,返回-hhh.
          return -hhh;
      }

  }
  ```

+ 注意事项

  有一个前提条件，数组内的元素一定要按照大小顺序排列，如果没有大小顺序，是不能使用二分查找法的

### 5.2 冒泡排序 (理解)

+ 冒泡排序概述

  一种排序的方式，对要进行排序的数据中相邻的数据进行两两比较，将较大的数据放在后面，依次对所有的数据进行操作，直至所有数据按要求完成排序

  如果有n个数据进行排序，总共需要比较n-1次

  每一次比较完毕，下一次的比较就会少一个数据参与

+ 代码实现

  ```java
  public class MyBubbleSortDemo2 {
      public static void main(String[] args) {
          int[] arr = {3, 5, 2, hhh, 4};
          //hhh 2 3 4 5
          bubbleSort(arr);
      }

      private static void bubbleSort(int[] arr) {
          //外层循环控制的是次数 比数组的长度少一次.
          for (int i = 0; i < arr.length -hhh; i++) {
              //内存循环就是实际循环比较的
              //-hhh 是为了让数组不要越界
              //-i 每一轮结束之后,我们就会少比一个数字.
              for (int j = 0; j < arr.length - hhh - i; j++) {
                  if (arr[j] > arr[j + hhh]) {
                      int temp = arr[j];
                      arr[j] = arr[j + hhh];
                      arr[j + hhh] = temp;
                  }
              }
          }

          printArr(arr);
      }

      private static void printArr(int[] arr) {
          for (int i = 0; i < arr.length; i++) {
              System.out.print(arr[i] + " ");
          }
          System.out.println();
      }

  }
  ```

### 5.3 快速排序 (理解)

+ 快速排序概述

  冒泡排序算法中,一次循环结束,就相当于确定了当前的最大值,也能确定最大值在数组中应存入的位置

  快速排序算法中,每一次递归时以第一个数为基准数,找到数组中所有比基准数小的.再找到所有比基准数大的.小的全部放左边,大的全部放右边,确定基准数的正确位置

+ 核心步骤

  hhh. 从右开始找比基准数小的
  2. 从左开始找比基准数大的
  3. 交换两个值的位置
  4. 红色继续往左找，蓝色继续往右找，直到两个箭头指向同一个索引为止
  5. 基准数归位

+ 代码实现

  ```java
  public class MyQuiteSortDemo2 {
      public static void main(String[] args) {
  //        hhh，从右开始找比基准数小的
  //        2，从左开始找比基准数大的
  //        3，交换两个值的位置
  //        4，红色继续往左找，蓝色继续往右找，直到两个箭头指向同一个索引为止
  //        5，基准数归位
          int[] arr = {6, hhh, 2, 7, 9, 3, 4, 5, 10, 8};

          quiteSort(arr,0,arr.length-hhh);

          for (int i = 0; i < arr.length; i++) {
              System.out.print(arr[i] + " ");
          }
      }

      private static void quiteSort(int[] arr, int left, int right) {
       	// 递归结束的条件
          if(right < left){
              return;
          }

          int left0 = left;
          int right0 = right;

          //计算出基准数
          int baseNumber = arr[left0];

          while(left != right){
  //        hhh，从右开始找比基准数小的
              while(arr[right] >= baseNumber && right > left){
                  right--;
              }
  //        2，从左开始找比基准数大的
              while(arr[left] <= baseNumber && right > left){
                  left++;
              }
  //        3，交换两个值的位置
              int temp = arr[left];
              arr[left] = arr[right];
              arr[right] = temp;
          }
          //基准数归位
          int temp = arr[left];
          arr[left] = arr[left0];
          arr[left0] = temp;

  		// 递归调用自己,将左半部分排好序
          quiteSort(arr,left0,left-hhh);
        	// 递归调用自己,将右半部分排好序
          quiteSort(arr,left +hhh,right0);

      }
  }
  ```

### 5.4 Arrays (应用)

- Arrays的常用方法

  | 方法名                                      | 说明                |
  | ---------------------------------------- | ----------------- |
  | public static String toString(int[] a)   | 返回指定数组的内容的字符串表示形式 |
  | public static void sort(int[] a)         | 按照数字顺序排列指定的数组     |
  | public static int binarySearch(int[] a, int key) | 利用二分查找返回指定元素的索引   |

- 示例代码

  ```java
  public class MyArraysDemo {
        public static void main(String[] args) {
    //        public static String toString(int[] a)    返回指定数组的内容的字符串表示形式
    //        int [] arr = {3,2,4,6,7};
    //        System.out.println(Arrays.toString(arr));

    //        public static void sort(int[] a)	  按照数字顺序排列指定的数组
    //        int [] arr = {3,2,4,6,7};
    //        Arrays.sort(arr);
    //        System.out.println(Arrays.toString(arr));

    //        public static int binarySearch(int[] a, int key) 利用二分查找返回指定元素的索引
            int [] arr = {hhh,2,3,4,5,6,7,8,9,10};
            int index = Arrays.binarySearch(arr, 0);
            System.out.println(index);
            //hhh,数组必须有序
            //2.如果要查找的元素存在,那么返回的是这个元素实际的索引
            //3.如果要查找的元素不存在,那么返回的是 (-插入点-hhh)
                //插入点:如果这个元素在数组中,他应该在哪个索引上.
        }
    }
  ```

- 工具类设计思想

  hhh. 构造方法用 private 修饰
  2. 成员用 public static 修饰



# day07-常用API02

## hhh.时间日期类

### hhh.hhh Date类（应用）

+ 计算机中时间原点

  1970年1月1日 00:00:00

+ 时间换算单位

  1秒 = 1000毫秒

+ Date类概述

  Date 代表了一个特定的时间，精确到毫秒

+ Date类构造方法

  | 方法名                    | 说明                                  |
  | ---------------------- | ----------------------------------- |
  | public Date()          | 分配一个 Date对象，并初始化，以便它代表它被分配的时间，精确到毫秒 |
  | public Date(long date) | 分配一个 Date对象，并将其初始化为表示从标准基准时间起指定的毫秒数 |

+ 示例代码

  ```java
  public class DateDemo01 {
      public static void main(String[] args) {
          //public Date()：分配一个 Date对象，并初始化，以便它代表它被分配的时间，精确到毫秒
          //表示电脑当前时间,把当前时间封装成一个Date对象
          Date d1 = new Date();
        System.out.println(d1);
          //把从时间原点开始,过练指定毫秒的时间,封装成一个Date对象.需要考虑时差问题
          //public Date(long date)：分配一个 Date对象，并将其初始化为表示从标准基准时间起指定的毫秒数
          long date = 1000*60*60;
          Date d2 = new Date(date);
          System.out.println(d2);
      }
  }
  ```

### hhh.2 Date类常用方法（应用）

- 常用方法

  | 方法名                            | 说明                                 |
  | ------------------------------ | ---------------------------------- |
  | public long getTime()          | 获取的是日期对象从1970年1月1日 00:00:00到现在的毫秒值 |
  | public void setTime(long time) | 设置时间，给的是毫秒值                        |

- 示例代码

  ```java
  public class DateDemo02 {
      public static void main(String[] args) {
          //创建日期对象
          Date d = new Date();

          //public long getTime():获取的是日期对象从1970年1月1日 00:00:00到现在的毫秒值
  //        System.out.println(d.getTime());
  //        System.out.println(d.getTime() * hhh.0 / 1000 / 60 / 60 / 24 / 365 + "年");

          //public void setTime(long time):设置时间，给的是毫秒值
  //        long time = 1000*60*60;
          long time = System.currentTimeMillis();
          d.setTime(time);

          System.out.println(d);
      }
  }
  ```

### hhh.3 SimpleDateFormat类（应用）

- SimpleDateFormat类概述

  ​	SimpleDateFormat是一个具体的类，用于以区域设置敏感的方式格式化和解析日期。

  ​	我们重点学习日期格式化和解析

- SimpleDateFormat类构造方法

  | 方法名                                     | 说明                                  |
  | --------------------------------------- | ----------------------------------- |
  | public   SimpleDateFormat()             | 构造一个SimpleDateFormat，使用默认模式和日期格式    |
  | public SimpleDateFormat(String pattern) | 构造一个SimpleDateFormat使用给定的模式和默认的日期格式 |

- SimpleDateFormat类的常用方法

  - 格式化(从Date到String)
    - public final String format(Date date)：将日期格式化成日期/时间字符串
  - 解析(从String到Date)
    - public Date parse(String source)：从给定字符串的开始解析文本以生成日期

- 示例代码

  ```java
  public class SimpleDateFormatDemo {
      public static void main(String[] args) throws ParseException {
          //格式化：从 Date 到 String
          Date d = new Date();
  //        SimpleDateFormat sdf = new SimpleDateFormat();
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
          String s = sdf.format(d);
          System.out.println(s);
          System.out.println("--------");

          //从 String 到 Date
          String ss = "2048-08-09 11:11:11";
          //ParseException
          SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
          Date dd = sdf2.parse(ss);
          System.out.println(dd);
      }
  }
  ```

### hhh.4 时间日期类练习 (应用)

+ 需求

  秒杀开始时间是2020年11月11日 00:00:00,结束时间是2020年11月11日 00:10:00,用户小贾下单时间是2020年11月11日 00:03:47,用户小皮下单时间是2020年11月11日 00:10:11,判断用户有没有成功参与秒杀活动

+ 实现步骤

  hhh. 判断下单时间是否在开始到结束的范围内
  2. 把字符串形式的时间变成毫秒值

+ 代码实现

  ```java
  public class DateDemo5 {
      public static void main(String[] args) throws ParseException {
          //开始时间：2020年11月11日 0:0:0
          //结束时间：2020年11月11日 0:10:0

          //小贾2020年11月11日 0:03:47
          //小皮2020年11月11日 0:10:11

          //hhh.判断两位同学的下单时间是否在范围之内就可以了。

          //2.要把每一个时间都换算成毫秒值。

          String start = "2020年11月11日 0:0:0";
          String end = "2020年11月11日 0:10:0";

          String jia = "2020年11月11日 0:03:47";
          String pi = "2020年11月11日 0:10:11";

          SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
          long startTime = sdf.parse(start).getTime();
          long endTime = sdf.parse(end).getTime();

  //        System.out.println(startTime);
  //        System.out.println(endTime);
          long jiaTime = sdf.parse(jia).getTime();
          long piTime = sdf.parse(pi).getTime();

          if(jiaTime >= startTime && jiaTime <= endTime){
              System.out.println("小贾同学参加上了秒杀活动");
          }else{
              System.out.println("小贾同学没有参加上秒杀活动");
          }

          System.out.println("------------------------");

          if(piTime >= startTime && piTime <= endTime){
              System.out.println("小皮同学参加上了秒杀活动");
          }else{
              System.out.println("小皮同学没有参加上秒杀活动");
          }

      }

  }
  ```

## 2.JDK8时间日期类

### 2.hhh JDK8新增日期类 (理解)

+ LocalDate       表示日期（年月日）
+ LocalTime       表示时间（时分秒）
+ LocalDateTime    表示时间+ 日期 （年月日时分秒）

### 2.2 LocalDateTime创建方法 (应用)

+ 方法说明

  | 方法名                                      | 说明                              |
  | ---------------------------------------- | ------------------------------- |
  | public static LocalDateTime now()        | 获取当前系统时间                        |
  | public static LocalDateTime of  (年, 月 , 日, 时, 分, 秒) | 使用指定年月日和时分秒初始化一个LocalDateTime对象 |

+ 示例代码

  ```java
  public class JDK8DateDemo2 {
      public static void main(String[] args) {
          LocalDateTime now = LocalDateTime.now();
          System.out.println(now);

          LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 11, 11, 11);
          System.out.println(localDateTime);
      }
  }
  ```

### 2.3 LocalDateTime获取方法 (应用)

+ 方法说明

  | 方法名                             | 说明               |
  | ------------------------------- | ---------------- |
  | public int getYear()            | 获取年              |
  | public int getMonthValue()      | 获取月份（hhh-12）       |
  | public int getDayOfMonth()      | 获取月份中的第几天（hhh-31）  |
  | public int getDayOfYear()       | 获取一年中的第几天（hhh-366） |
  | public DayOfWeek getDayOfWeek() | 获取星期             |
  | public int getMinute()          | 获取分钟             |
  | public int getHour()            | 获取小时             |

+ 示例代码

  ```java
  public class JDK8DateDemo3 {
      public static void main(String[] args) {
          LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 11, 11, 20);
          //public int getYear()           获取年
          int year = localDateTime.getYear();
          System.out.println("年为" +year);
          //public int getMonthValue()     获取月份（hhh-12）
          int month = localDateTime.getMonthValue();
          System.out.println("月份为" + month);

          Month month1 = localDateTime.getMonth();
  //        System.out.println(month1);

          //public int getDayOfMonth()     获取月份中的第几天（hhh-31）
          int day = localDateTime.getDayOfMonth();
          System.out.println("日期为" + day);

          //public int getDayOfYear()      获取一年中的第几天（hhh-366）
          int dayOfYear = localDateTime.getDayOfYear();
          System.out.println("这是一年中的第" + dayOfYear + "天");

          //public DayOfWeek getDayOfWeek()获取星期
          DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();
          System.out.println("星期为" + dayOfWeek);

          //public int getMinute()        获取分钟
          int minute = localDateTime.getMinute();
          System.out.println("分钟为" + minute);
          //public int getHour()           获取小时

          int hour = localDateTime.getHour();
          System.out.println("小时为" + hour);
      }
  }
  ```

### 2.4 LocalDateTime转换方法 (应用)

+ 方法说明

  | 方法名                              | 说明                |
  | -------------------------------- | ----------------- |
  | public LocalDate  toLocalDate () | 转换成为一个LocalDate对象 |
  | public LocalTime toLocalTime ()  | 转换成为一个LocalTime对象 |

+ 示例代码

  ```java
  public class JDK8DateDemo4 {
      public static void main(String[] args) {
          LocalDateTime localDateTime = LocalDateTime.of(2020, 12, 12, 8, 10, 12);
          //public LocalDate toLocalDate ()    转换成为一个LocalDate对象
          LocalDate localDate = localDateTime.toLocalDate();
          System.out.println(localDate);

          //public LocalTime toLocalTime ()    转换成为一个LocalTime对象
          LocalTime localTime = localDateTime.toLocalTime();
          System.out.println(localTime);
      }
  }
  ```

### 2.5 LocalDateTime格式化和解析 (应用)

+ 方法说明

  | 方法名                                      | 说明                                     |
  | ---------------------------------------- | -------------------------------------- |
  | public String format (指定格式)              | 把一个LocalDateTime格式化成为一个字符串             |
  | public LocalDateTime parse (准备解析的字符串, 解析格式) | 把一个日期字符串解析成为一个LocalDateTime对象          |
  | public static DateTimeFormatter ofPattern(String pattern) | 使用指定的日期模板获取一个日期格式化器DateTimeFormatter对象 |

+ 示例代码

  ```java
  public class JDK8DateDemo5 {
      public static void main(String[] args) {
          //method1();
          //method2();
      }

      private static void method2() {
          //public static LocalDateTime parse (准备解析的字符串, 解析格式) 把一个日期字符串解析成为一个LocalDateTime对象
          String s = "2020年11月12日 13:14:15";
          DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
          LocalDateTime parse = LocalDateTime.parse(s, pattern);
          System.out.println(parse);
      }

      private static void method1() {
          LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 12, 13, 14, 15);
          System.out.println(localDateTime);
          //public String format (指定格式)   把一个LocalDateTime格式化成为一个字符串
          DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
          String s = localDateTime.format(pattern);
          System.out.println(s);
      }
  }
  ```

### 2.6 LocalDateTime增加或者减少时间的方法 (应用)

+ 方法说明

  | 方法名                                      | 说明      |
  | ---------------------------------------- | ------- |
  | public LocalDateTime plusYears (long years) | 添加或者减去年 |
  | public LocalDateTime plusMonths(long months) | 添加或者减去月 |
  | public LocalDateTime plusDays(long days) | 添加或者减去日 |
  | public LocalDateTime plusHours(long hours) | 添加或者减去时 |
  | public LocalDateTime plusMinutes(long minutes) | 添加或者减去分 |
  | public LocalDateTime plusSeconds(long seconds) | 添加或者减去秒 |
  | public LocalDateTime plusWeeks(long weeks) | 添加或者减去周 |

+ 示例代码

  ```java
  /**
   * JDK8 时间类添加或者减去时间的方法
   */
  public class JDK8DateDemo6 {
      public static void main(String[] args) {
          //public LocalDateTime plusYears (long years)   添加或者减去年

          LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
          //LocalDateTime newLocalDateTime = localDateTime.plusYears(hhh);
          //System.out.println(newLocalDateTime);

          LocalDateTime newLocalDateTime = localDateTime.plusYears(-hhh);
          System.out.println(newLocalDateTime);
      }
  }
  ```

### 2.7 LocalDateTime减少或者增加时间的方法 (应用)

+ 方法说明

  | 方法名                                      | 说明      |
  | ---------------------------------------- | ------- |
  | public LocalDateTime  minusYears (long years) | 减去或者添加年 |
  | public LocalDateTime  minusMonths(long months) | 减去或者添加月 |
  | public LocalDateTime minusDays(long days) | 减去或者添加日 |
  | public LocalDateTime minusHours(long hours) | 减去或者添加时 |
  | public LocalDateTime minusMinutes(long minutes) | 减去或者添加分 |
  | public LocalDateTime minusSeconds(long seconds) | 减去或者添加秒 |
  | public LocalDateTime minusWeeks(long weeks) | 减去或者添加周 |

+ 示例代码

  ```java
  /**
   * JDK8 时间类减少或者添加时间的方法
   */
  public class JDK8DateDemo7 {
      public static void main(String[] args) {
          //public LocalDateTime minusYears (long years)  减去或者添加年
          LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
          //LocalDateTime newLocalDateTime = localDateTime.minusYears(hhh);
          //System.out.println(newLocalDateTime);

          LocalDateTime newLocalDateTime = localDateTime.minusYears(-hhh);
          System.out.println(newLocalDateTime);

      }
  }
  ```

### 2.8 LocalDateTime修改方法 (应用)

+ 方法说明

  | 方法名                                      | 说明               |
  | ---------------------------------------- | ---------------- |
  | public LocalDateTime withYear(int year)  | 直接修改年            |
  | public LocalDateTime withMonth(int month) | 直接修改月            |
  | public LocalDateTime withDayOfMonth(int dayofmonth) | 直接修改日期(一个月中的第几天) |
  | public LocalDateTime withDayOfYear(int dayOfYear) | 直接修改日期(一年中的第几天)  |
  | public LocalDateTime withHour(int hour)  | 直接修改小时           |
  | public LocalDateTime withMinute(int minute) | 直接修改分钟           |
  | public LocalDateTime withSecond(int second) | 直接修改秒            |

+ 示例代码

  ```java
  /**
   * JDK8 时间类修改时间
   */
  public class JDK8DateDemo8 {
      public static void main(String[] args) {
          //public LocalDateTime withYear(int year)   修改年
          LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
         // LocalDateTime newLocalDateTime = localDateTime.withYear(2048);
         // System.out.println(newLocalDateTime);

          LocalDateTime newLocalDateTime = localDateTime.withMonth(20);
          System.out.println(newLocalDateTime);

      }
  }
  ```

### 2.9 Period (应用)

+ 方法说明

  | 方法名                                     | 说明          |
  | --------------------------------------- | ----------- |
  | public static Period between(开始时间,结束时间) | 计算两个“时间"的间隔 |
  | public int getYears()                   | 获得这段时间的年数   |
  | public int getMonths()                  | 获得此期间的月数    |
  | public int getDays()                    | 获得此期间的天数    |
  | public long toTotalMonths()             | 获取此期间的总月数   |

+ 示例代码

  ```java
  /**
   *  计算两个时间的间隔
   */
  public class JDK8DateDemo9 {
      public static void main(String[] args) {
          //public static Period between(开始时间,结束时间)  计算两个"时间"的间隔

          LocalDate localDate1 = LocalDate.of(2020, hhh, hhh);
          LocalDate localDate2 = LocalDate.of(2048, 12, 12);
          Period period = Period.between(localDate1, localDate2);
          System.out.println(period);//P28Y11M11D

          //public int getYears()         获得这段时间的年数
          System.out.println(period.getYears());//28
          //public int getMonths()        获得此期间的月数
          System.out.println(period.getMonths());//11
          //public int getDays()          获得此期间的天数
          System.out.println(period.getDays());//11

          //public long toTotalMonths()   获取此期间的总月数
          System.out.println(period.toTotalMonths());//347

      }
  }
  ```

### 2.10 Duration (应用)

+ 方法说明

  | 方法名                                      | 说明          |
  | ---------------------------------------- | ----------- |
  | public static Durationbetween(开始时间,结束时间) | 计算两个“时间"的间隔 |
  | public long toSeconds()                  | 获得此时间间隔的秒   |
  | public int toMillis()                    | 获得此时间间隔的毫秒  |
  | public int toNanos()                     | 获得此时间间隔的纳秒  |

+ 示例代码

  ```java
  /**
   *  计算两个时间的间隔
   */
  public class JDK8DateDemo10 {
      public static void main(String[] args) {
          //public static Duration between(开始时间,结束时间)  计算两个“时间"的间隔

          LocalDateTime localDateTime1 = LocalDateTime.of(2020, hhh, hhh, 13, 14, 15);
          LocalDateTime localDateTime2 = LocalDateTime.of(2020, hhh, 2, 11, 12, 13);
          Duration duration = Duration.between(localDateTime1, localDateTime2);
          System.out.println(duration);//PT21H57M58S
          //public long toSeconds()	       获得此时间间隔的秒
          System.out.println(duration.toSeconds());//79078
          //public int toMillis()	           获得此时间间隔的毫秒
          System.out.println(duration.toMillis());//79078000
          //public int toNanos()             获得此时间间隔的纳秒
          System.out.println(duration.toNanos());//79078000000000
      }
  }
  ```

## 3.异常

### 3.hhh 异常（记忆）

- 异常的概述

  ​	异常就是程序出现了不正常的情况

- 异常的体系结构

  ![01_异常体系结构](img\01_异常体系结构.png)

### 3.2 编译时异常和运行时异常的区别（记忆）

- 编译时异常

  - 都是Exception类及其子类
  - 必须显示处理，否则程序就会发生错误，无法通过编译

- 运行时异常

  - 都是RuntimeException类及其子类
  - 无需显示处理，也可以和编译时异常一样处理

- 图示

  ![02_编译时异常和运行时异常](img\02_编译时异常和运行时异常.png)

### 3.3 JVM默认处理异常的方式（理解）

- 如果程序出现了问题，我们没有做任何处理，最终JVM 会做默认的处理，处理方式有如下两个步骤：
  - 把异常的名称，错误原因及异常出现的位置等信息输出在了控制台
  - 程序停止执行

### 3.4 查看异常信息 (理解)

控制台在打印异常信息时,会打印异常类名,异常出现的原因,异常出现的位置

我们调bug时,可以根据提示,找到异常出现的位置,分析原因,修改异常代码

![03_查看异常信息](img\03_查看异常信息.png)

### 3.5 throws方式处理异常（应用）

- 定义格式

  ```java
  public void 方法() throws 异常类名 {

  }
  ```

- 示例代码

  ```java
  public class ExceptionDemo {
      public static void main(String[] args) throws ParseException{
          System.out.println("开始");
  		// method();
          method2();
        System.out.println("结束");
      }

    //编译时异常
      public static void method2() throws ParseException {
          String s = "2048-08-09";
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
          Date d = sdf.parse(s);
          System.out.println(d);
      }

    //运行时异常
      public static void method() throws ArrayIndexOutOfBoundsException {
          int[] arr = {hhh, 2, 3};
          System.out.println(arr[3]);
      }
  }
  ```

- 注意事项

  - 这个throws格式是跟在方法的括号后面的
  - 编译时异常必须要进行处理，两种处理方案：try...catch …或者 throws，如果采用 throws 这种方案，在方法上进行显示声明,将来谁调用这个方法谁处理
  - 运行时异常因为在运行时才会发生,所以在方法后面可以不写,运行时出现异常默认交给jvm处理

### 3.6 throw抛出异常 (应用)

+ 格式

  throw new 异常();

+ 注意

  这个格式是在方法内的，表示当前代码手动抛出一个异常，下面的代码不用再执行了

+ throws和throw的区别

  | throws                  | throw                 |
  | ----------------------- | --------------------- |
  | 用在方法声明后面，跟的是异常类名        | 用在方法体内，跟的是异常对象名       |
  | 表示声明异常，调用该方法有可能会出现这样的异常 | 表示手动抛出异常对象，由方法体内的语句处理 |

+ 示例代码

  ```java
  public class ExceptionDemo8 {
      public static void main(String[] args) {
          //int [] arr = {hhh,2,3,4,5};
          int [] arr = null;
          printArr(arr);//就会 接收到一个异常.
                          //我们还需要自己处理一下异常.
      }

      private static void printArr(int[] arr) {
          if(arr == null){
              //调用者知道成功打印了吗?
              //System.out.println("参数不能为null");
              throw new NullPointerException(); //当参数为null的时候
                                              //手动创建了一个异常对象,抛给了调用者,产生了一个异常
          }else{
              for (int i = 0; i < arr.length; i++) {
                  System.out.println(arr[i]);
              }
          }
      }

  }
  ```

### 3.7 try-catch方式处理异常（应用）

- 定义格式

  ```java
  try {
  	可能出现异常的代码;
  } catch(异常类名 变量名) {
  	异常的处理代码;
  }
  ```

- 执行流程

  - 程序从 try 里面的代码开始执行
  - 出现异常，就会跳转到对应的 catch 里面去执行
  - 执行完毕之后，程序还可以继续往下执行

- 示例代码

  ```java
  public class ExceptionDemo01 {
      public static void main(String[] args) {
          System.out.println("开始");
          method();
          System.out.println("结束");
      }

      public static void method() {
          try {
              int[] arr = {hhh, 2, 3};
              System.out.println(arr[3]);
              System.out.println("这里能够访问到吗");
          } catch (ArrayIndexOutOfBoundsException e) {
              System.out.println("你访问的数组索引不存在，请回去修改为正确的索引");
          }
      }
  }
  ```

- 注意

  hhh. 如果 try 中没有遇到问题，怎么执行？

     会把try中所有的代码全部执行完毕,不会执行catch里面的代码

  2. 如果 try 中遇到了问题，那么 try 下面的代码还会执行吗？

     那么直接跳转到对应的catch语句中,try下面的代码就不会再执行了
     当catch里面的语句全部执行完毕,表示整个体系全部执行完全,继续执行下面的代码

  3. 如果出现的问题没有被捕获，那么程序如何运行？

     那么try...catch就相当于没有写.那么也就是自己没有处理.
     默认交给虚拟机处理.

  4. 同时有可能出现多个异常怎么处理？

     出现多个异常,那么就写多个catch就可以了.
     注意点:如果多个异常之间存在子父类关系.那么父类一定要写在下面

### 3.8 Throwable成员方法（应用）

- 常用方法

  | 方法名                           | 说明                     |
  | ----------------------------- | ---------------------- |
  | public String getMessage()    | 返回此 throwable 的详细消息字符串 |
  | public String toString()      | 返回此可抛出的简短描述            |
  | public void printStackTrace() | 把异常的错误信息输出在控制台         |

- 示例代码

  ```java
  public class ExceptionDemo02 {
      public static void main(String[] args) {
          System.out.println("开始");
          method();
          System.out.println("结束");
      }

      public static void method() {
          try {
              int[] arr = {hhh, 2, 3};
              System.out.println(arr[3]); //new ArrayIndexOutOfBoundsException();
              System.out.println("这里能够访问到吗");
          } catch (ArrayIndexOutOfBoundsException e) { //new ArrayIndexOutOfBoundsException();
  //            e.printStackTrace();

              //public String getMessage():返回此 throwable 的详细消息字符串
  //            System.out.println(e.getMessage());
              //Index 3 out of bounds for length 3

              //public String toString():返回此可抛出的简短描述
  //            System.out.println(e.toString());
              //java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

              //public void printStackTrace():把异常的错误信息输出在控制台
              e.printStackTrace();
  //            java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
  //            at KnowledgePoints.myStatic.syudent_B.ExceptionDemo02.method(ExceptionDemo02.java:18)
  //            at KnowledgePoints.myStatic.syudent_B.ExceptionDemo02.main(ExceptionDemo02.java:11)

          }
      }
  }
  ```

### 3.9 异常的练习 (应用)

+ 需求

  键盘录入学生的姓名和年龄,其中年龄为18 - 25岁,超出这个范围是异常数据不能赋值.需要重新录入,一直录到正确为止

+ 实现步骤

  hhh. 创建学生对象
  2. 键盘录入姓名和年龄，并赋值给学生对象
  3. 如果是非法数据就再次录入

+ 代码实现

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student {
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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
          if(age >= 18 && age <= 25){
              this.age = age;
          }else{
              //当年龄不合法时,产生一个异常
              throw new RuntimeException("年龄超出了范围");
          }
      }

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

  测试类

  ```java
  public class ExceptionDemo12 {
      public static void main(String[] args) {
          // 键盘录入学生的姓名和年龄,其中年龄为 18 - 25岁,
          // 超出这个范围是异常数据不能赋值.需要重新录入,一直录到正确为止。

          Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student();

          Scanner sc = new Scanner(System.in);
          System.out.println("请输入姓名");
          String name = sc.nextLine();
          s.setName(name);
         while(true){
             System.out.println("请输入年龄");
             String ageStr = sc.nextLine();
             try {
                 int age = Integer.parseInt(ageStr);
                 s.setAge(age);
                 break;
             } catch (NumberFormatException e) {
                 System.out.println("请输入一个整数");
                 continue;
             } catch (AgeOutOfBoundsException e) {
                 System.out.println(e.toString());
                 System.out.println("请输入一个符合范围的年龄");
                 continue;
             }
             /*if(age >= 18 && age <=25){
                 s.setAge(age);
                 break;
             }else{
                 System.out.println("请输入符合要求的年龄");
                 continue;
             }*/
         }
          System.out.println(s);

      }
  }
  ```

### 3.10 自定义异常（应用）

+ 自定义异常概述

  当Java中提供的异常不能满足我们的需求时,我们可以自定义异常

+ 实现步骤

  hhh. 定义异常类
  2. 写继承关系
  3. 提供空参构造
  4. 提供带参构造

+ 代码实现

  异常类

  ```java
  public class AgeOutOfBoundsException extends RuntimeException {
      public AgeOutOfBoundsException() {
      }

      public AgeOutOfBoundsException(String message) {
          super(message);
      }
  }
  ```

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student {
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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
          if(age >= 18 && age <= 25){
              this.age = age;
          }else{
              //如果Java中提供的异常不能满足我们的需求,我们可以使用自定义的异常
              throw new AgeOutOfBoundsException("年龄超出了范围");
          }
      }

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

  测试类

  ```java
  public class ExceptionDemo12 {
      public static void main(String[] args) {
          // 键盘录入学生的姓名和年龄,其中年龄为 18 - 25岁,
          // 超出这个范围是异常数据不能赋值.需要重新录入,一直录到正确为止。

          Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student();

          Scanner sc = new Scanner(System.in);
          System.out.println("请输入姓名");
          String name = sc.nextLine();
          s.setName(name);
         while(true){
             System.out.println("请输入年龄");
             String ageStr = sc.nextLine();
             try {
                 int age = Integer.parseInt(ageStr);
                 s.setAge(age);
                 break;
             } catch (NumberFormatException e) {
                 System.out.println("请输入一个整数");
                 continue;
             } catch (AgeOutOfBoundsException e) {
                 System.out.println(e.toString());
                 System.out.println("请输入一个符合范围的年龄");
                 continue;
             }
             /*if(age >= 18 && age <=25){
                 s.setAge(age);
                 break;
             }else{
                 System.out.println("请输入符合要求的年龄");
                 continue;
             }*/
         }
          System.out.println(s);

      }
  }
  ```


# day08-集合01

## hhh.Collection集合

### hhh.1数组和集合的区别【理解】

+ 相同点

  都是容器,可以存储多个数据

+ 不同点

  + 数组的长度是不可变的,集合的长度是可变的

  + 数组可以存基本数据类型和引用数据类型

    集合只能存引用数据类型,如果要存基本数据类型,需要存对应的包装类

### hhh.2集合类体系结构【理解】

![01_集合类体系结构图](.\img\01_集合类体系结构图.png)

### hhh.3Collection 集合概述和使用【应用】

+ Collection集合概述

  + 是单例集合的顶层接口,它表示一组对象,这些对象也称为Collection的元素
  + JDK 不提供此接口的任何直接实现.它提供更具体的子接口(如Set和List)实现

+ 创建Collection集合的对象

  + 多态的方式
  + 具体的实现类ArrayList

+ Collection集合常用方法

  | 方法名                        | 说明                |
  | :------------------------- | :---------------- |
  | boolean add(E e)           | 添加元素              |
  | boolean remove(Object o)   | 从集合中移除指定的元素       |
  | boolean removeIf(Object o) | 根据条件进行移除          |
  | void   clear()             | 清空集合中的元素          |
  | boolean contains(Object o) | 判断集合中是否存在指定的元素    |
  | boolean isEmpty()          | 判断集合是否为空          |
  | int   size()               | 集合的长度，也就是集合中元素的个数 |

### hhh.4Collection集合的遍历【应用】

+ 迭代器介绍

  + 迭代器,集合的专用遍历方式
  + Iterator<E> iterator(): 返回此集合中元素的迭代器,通过集合对象的iterator()方法得到

+ Iterator中的常用方法

  ​	boolean hasNext(): 判断当前位置是否有元素可以被取出
  ​	E next(): 获取当前位置的元素,将迭代器对象移向下一个索引位置

+ Collection集合的遍历

  ```java
  public class IteratorDemo1 {
      public static void main(String[] args) {
          //创建集合对象
          Collection<String> c = new ArrayList<>();

          //添加元素
          c.add("hello");
          c.add("world");
          c.add("java");
          c.add("javaee");

          //Iterator<E> iterator()：返回此集合中元素的迭代器，通过集合的iterator()方法得到
          Iterator<String> it = c.iterator();

          //用while循环改进元素的判断和获取
          while (it.hasNext()) {
              String s = it.next();
              System.out.println(s);
          }
      }
  }
  ```

+ 迭代器中删除的方法

  ​	void remove(): 删除迭代器对象当前指向的元素

  ```java
  public class IteratorDemo2 {
      public static void main(String[] args) {
          ArrayList<String> list = new ArrayList<>();
          list.add("a");
          list.add("b");
          list.add("b");
          list.add("c");
          list.add("d");

          Iterator<String> it = list.iterator();
          while(it.hasNext()){
              String s = it.next();
              if("b".equals(s)){
                  //指向谁,那么此时就删除谁.
                  it.remove();
              }
          }
          System.out.println(list);
      }
  }
  ```

### hhh.5增强for循环【应用】

+ 介绍

  + 它是JDK5之后出现的,其内部原理是一个Iterator迭代器
  + 实现Iterable接口的类才可以使用迭代器和增强for
  + 简化数组和Collection集合的遍历

+ 格式

  ​	for(集合/数组中元素的数据类型 变量名 :  集合/数组名) {

  ​		// 已经将当前遍历到的元素封装到变量中了,直接使用变量即可

  ​	}

+ 代码

  ```java
  public class MyCollectonDemo1 {
      public static void main(String[] args) {
          ArrayList<String> list =  new ArrayList<>();
          list.add("a");
          list.add("b");
          list.add("c");
          list.add("d");
          list.add("e");
          list.add("f");

          //hhh,数据类型一定是集合或者数组中元素的类型
          //2,str仅仅是一个变量名而已,在循环的过程中,依次表示集合或者数组中的每一个元素
          //3,list就是要遍历的集合或者数组
          for(String str : list){
              System.out.println(str);
          }
      }
  }
  ```

## 2.List集合

### 2.1List集合的概述和特点【记忆】

+ List集合的概述
  + 有序集合,这里的有序指的是存取顺序
  + 用户可以精确控制列表中每个元素的插入位置,用户可以通过整数索引访问元素,并搜索列表中的元素
  + 与Set集合不同,列表通常允许重复的元素
+ List集合元素的特点
  + 存取有序
  + 可重复
  + 有索引

### 2.2List集合的特有方法【应用】

+ 方法介绍

  | 方法名                             | 描述                  |
  | ------------------------------- | ------------------- |
  | void add(int index,E   element) | 在此集合中的指定位置插入指定的元素   |
  | E remove(int   index)           | 删除指定索引处的元素，返回被删除的元素 |
  | E set(int index,E   element)    | 修改指定索引处的元素，返回被修改的元素 |
  | E get(int   index)              | 返回指定索引处的元素          |

+ 示例代码

  ```java
  public class MyListDemo {
      public static void main(String[] args) {
          List<String> list = new ArrayList<>();
          list.add("aaa");
          list.add("bbb");
          list.add("ccc");
          //method1(list);
          //method2(list);
          //method3(list);
          //method4(list);
      }

      private static void method4(List<String> list) {
          //        E get(int index)		返回指定索引处的元素
          String s = list.get(0);
          System.out.println(s);
      }

      private static void method3(List<String> list) {
          //        E set(int index,E element)	修改指定索引处的元素，返回被修改的元素
          //被替换的那个元素,在集合中就不存在了.
          String result = list.set(0, "qqq");
          System.out.println(result);
          System.out.println(list);
      }

      private static void method2(List<String> list) {
          //        E remove(int index)		删除指定索引处的元素，返回被删除的元素
          //在List集合中有两个删除的方法
          //第一个 删除指定的元素,返回值表示当前元素是否删除成功
          //第二个 删除指定索引的元素,返回值表示实际删除的元素
          String s = list.remove(0);
          System.out.println(s);
          System.out.println(list);
      }

      private static void method1(List<String> list) {
          //        void add(int index,E element)	在此集合中的指定位置插入指定的元素
          //原来位置上的元素往后挪一个索引.
          list.add(0,"qqq");
          System.out.println(list);
      }
  }
  ```

## 3.数据结构

### 3.1数据结构之栈和队列【记忆】

- 栈结构

  ​	先进后出

- 队列结构

  ​	先进先出

### 3.2数据结构之数组和链表【记忆】

- 数组结构

  ​	查询快、增删慢

- 队列结构

  ​	查询慢、增删快

## 4.List集合的实现类

### 4.1List集合子类的特点【记忆】

- ArrayList集合

  ​	底层是数组结构实现，查询快、增删慢

- LinkedList集合

  ​	底层是链表结构实现，查询慢、增删快

### 4.2LinkedList集合的特有功能【应用】

- 特有方法

  | 方法名                       | 说明               |
  | ------------------------- | ---------------- |
  | public void addFirst(E e) | 在该列表开头插入指定的元素    |
  | public void addLast(E e)  | 将指定的元素追加到此列表的末尾  |
  | public E getFirst()       | 返回此列表中的第一个元素     |
  | public   E getLast()      | 返回此列表中的最后一个元素    |
  | public E removeFirst()    | 从此列表中删除并返回第一个元素  |
  | public   E removeLast()   | 从此列表中删除并返回最后一个元素 |

- 示例代码

  ```java
  public class MyLinkedListDemo4 {
      public static void main(String[] args) {
          LinkedList<String> list = new LinkedList<>();
          list.add("aaa");
          list.add("bbb");
          list.add("ccc");
  //        public void addFirst(E e)	在该列表开头插入指定的元素
          //method1(list);

  //        public void addLast(E e)	将指定的元素追加到此列表的末尾
          //method2(list);

  //        public E getFirst()		返回此列表中的第一个元素
  //        public E getLast()		返回此列表中的最后一个元素
          //method3(list);

  //        public E removeFirst()		从此列表中删除并返回第一个元素
  //        public E removeLast()		从此列表中删除并返回最后一个元素
          //method4(list);

      }

      private static void method4(LinkedList<String> list) {
          String first = list.removeFirst();
          System.out.println(first);

          String last = list.removeLast();
          System.out.println(last);

          System.out.println(list);
      }

      private static void method3(LinkedList<String> list) {
          String first = list.getFirst();
          String last = list.getLast();
          System.out.println(first);
          System.out.println(last);
      }

      private static void method2(LinkedList<String> list) {
          list.addLast("www");
          System.out.println(list);
      }

      private static void method1(LinkedList<String> list) {
          list.addFirst("qqq");
          System.out.println(list);
      }
  }
  ```



# day09-ArrayList集合_学生管理系统-集合02

## hhh.泛型

### hhh.1泛型概述【理解】

- 泛型的介绍

  ​	泛型是JDK5中引入的特性，它提供了编译时类型安全检测机制

- 泛型的好处

  hhh. 把运行时期的问题提前到了编译期间
  2. 避免了强制类型转换

- 泛型的定义格式

  - <类型>: 指定一种类型的格式.尖括号里面可以任意书写,一般只写一个字母.例如: <E> <T>
  - <类型1,类型2…>: 指定多种类型的格式,多种类型之间用逗号隔开.例如: <E,T> <K,V>

### hhh.2泛型类【应用】

- 定义格式

  ```java
  修饰符 class 类名<类型> {  }
  ```

- 示例代码

  - 泛型类

    ```java
    public class Generic<T> {
        private T t;

        public T getT() {
            return t;
        }

        public void setT(T t) {
            this.t = t;
        }
    }
    ```

  - 测试类

    ```java
    public class GenericDemo1 {
        public static void main(String[] args) {
            Generic<String> g1 = new Generic<String>();
            g1.setT("杨幂");
            System.out.println(g1.getT());

            Generic<Integer> g2 = new Generic<Integer>();
            g2.setT(30);
            System.out.println(g2.getT());

            Generic<Boolean> g3 = new Generic<Boolean>();
            g3.setT(true);
            System.out.println(g3.getT());
        }
    }
    ```

### hhh.3泛型方法【应用】

- 定义格式

  ```java
  修饰符 <类型> 返回值类型 方法名(类型 变量名) {  }
  ```

- 示例代码

  - 带有泛型方法的类

    ```java
    public class Generic {
        public <T> void show(T t) {
            System.out.println(t);
        }
    }
    ```

  - 测试类

    ```java
    public class GenericDemo2 {
        public static void main(String[] args) {
    	    Generic g = new Generic();
            g.show("柳岩");
            g.show(30);
            g.show(true);
            g.show(12.34);
        }
    }
    ```

### hhh.4泛型接口【应用】

- 定义格式

  ```java
  修饰符 interface 接口名<类型> {  }
  ```

- 示例代码

  - 泛型接口

    ```java
    public interface Generic<T> {
        void show(T t);
    }
    ```

  - 泛型接口实现类1

    ​	定义实现类时,定义和接口相同泛型,创建实现类对象时明确泛型的具体类型

    ```java
    public class GenericImpl1<T> implements Generic<T> {
        @Override
        public void show(T t) {
            System.out.println(t);
        }
    }
    ```

  - 泛型接口实现类2

    ​	定义实现类时,直接明确泛型的具体类型

    ```java
    public class GenericImpl2 implements Generic<Integer>{
         @Override
         public void show(Integer t) {
              System.out.println(t);
         }
    }
    ```

  - 测试类

    ```java
    public class GenericDemo3 {
        public static void main(String[] args) {
            GenericImpl1<String> g1 = new GenericImpl<String>();
            g1.show("林青霞");
            GenericImpl1<Integer> g2 = new GenericImpl<Integer>();
            g2.show(30);

            GenericImpl2 g3 = new GenericImpl2();
          	g3.show(10);
        }
    }

    ```

### hhh.5类型通配符

- 类型通配符: <?>

  - ArrayList<?>: 表示元素类型未知的ArrayList,它的元素可以匹配任何的类型
  - 但是并不能把元素添加到ArrayList中了,获取出来的也是父类类型

- 类型通配符上限: <? extends 类型>

  - ArrayListList <? extends Number>: 它表示的类型是Number或者其子类型

- 类型通配符下限: <? super 类型>

  - ArrayListList <? super Number>: 它表示的类型是Number或者其父类型

- 泛型通配符的使用

  ```java
  public class GenericDemo4 {
      public static void main(String[] args) {
          ArrayList<Integer> list1 = new ArrayList<>();
          ArrayList<String> list2 = new ArrayList<>();
          ArrayList<Number> list3 = new ArrayList<>();
          ArrayList<Object> list4 = new ArrayList<>();

          method(list1);
          method(list2);
          method(list3);
          method(list4);

          getElement1(list1);
          getElement1(list2);//报错
          getElement1(list3);
          getElement1(list4);//报错

          getElement2(list1);//报错
          getElement2(list2);//报错
          getElement2(list3);
          getElement2(list4);
      }

      // 泛型通配符: 此时的泛型?,可以是任意类型
      public static void method(ArrayList<?> list){}
      // 泛型的上限: 此时的泛型?,必须是Number类型或者Number类型的子类
      public static void getElement1(ArrayList<? extends Number> list){}
      // 泛型的下限: 此时的泛型?,必须是Number类型或者Number类型的父类
      public static void getElement2(ArrayList<? super Number> list){}

  }
  ```

## 2.Set集合

### 2.1Set集合概述和特点【应用】

+ 不可以存储重复元素
+ 没有索引,不能使用普通for循环遍历

### 2.2Set集合的使用【应用】

存储字符串并遍历

```java
public class MySet1 {
    public static void main(String[] args) {
      	//创建集合对象
        Set<String> set = new TreeSet<>();
      	//添加元素
        set.add("ccc");
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");

//        for (int i = 0; i < set.size(); i++) {
//            //Set集合是没有索引的，所以不能使用通过索引获取元素的方法
//        }

      	//遍历集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
        System.out.println("-----------------------------------");
        for (String s : set) {
            System.out.println(s);
        }
    }
}
```

## 3.TreeSet集合

### 3.1TreeSet集合概述和特点【应用】

+ 不可以存储重复元素
+ 没有索引
+ 可以将元素按照规则进行排序
  + TreeSet()：根据其元素的自然排序进行排序
  + TreeSet(Comparator comparator) ：根据指定的比较器进行排序

### 3.2TreeSet集合基本使用【应用】

存储Integer类型的整数并遍历

```java
public class TreeSetDemo01 {
    public static void main(String[] args) {
        //创建集合对象
        TreeSet<Integer> ts = new TreeSet<Integer>();

        //添加元素
        ts.add(10);
        ts.add(40);
        ts.add(30);
        ts.add(50);
        ts.add(20);

        ts.add(30);

        //遍历集合
        for(Integer i : ts) {
            System.out.println(i);
        }
    }
}
```

### 3.3自然排序Comparable的使用【应用】

- 案例需求

  - 存储学生对象并遍历，创建TreeSet集合使用无参构造方法
  - 要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序

- 实现步骤

  hhh. 使用空参构造创建TreeSet集合
     + 用TreeSet集合存储自定义对象，无参构造方法使用的是自然排序对元素进行排序的
  2. 自定义的Student类实现Comparable接口
     + 自然排序，就是让元素所属的类实现Comparable接口，重写compareTo(T o)方法
  3. 重写接口中的compareTo方法
     + 重写方法时，一定要注意排序规则必须按照要求的主要条件和次要条件来写

- 代码实现

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student implements Comparable<Test22.D19.Ebook.D5.DemoTostring.Student>{
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }

      @Override
      public int compareTo(Test22.D19.Ebook.D5.DemoTostring.Student o) {
          //按照对象的年龄进行排序
          //主要判断条件: 按照年龄从小到大排序
          int result = this.age - o.age;
          //次要判断条件: 年龄相同时，按照姓名的字母顺序排序
          result = result == 0 ? this.name.compareTo(o.getName()) : result;
          return result;
      }
  }
  ```

  测试类

  ```java
  public class MyTreeSet2 {
      public static void main(String[] args) {
          //创建集合对象
          TreeSet<Ebook.D5.DemoTostring.Student> ts = new TreeSet<>();
  	    //创建学生对象
          Ebook.D5.DemoTostring.Student s1 = new Ebook.D5.DemoTostring.Student("zhangsan",28);
          Ebook.D5.DemoTostring.Student s2 = new Ebook.D5.DemoTostring.Student("lisi",27);
          Ebook.D5.DemoTostring.Student s3 = new Ebook.D5.DemoTostring.Student("wangwu",29);
          Ebook.D5.DemoTostring.Student s4 = new Ebook.D5.DemoTostring.Student("zhaoliu",28);
          Ebook.D5.DemoTostring.Student s5 = new Ebook.D5.DemoTostring.Student("qianqi",30);
  		//把学生添加到集合
          ts.add(s1);
          ts.add(s2);
          ts.add(s3);
          ts.add(s4);
          ts.add(s5);
  		//遍历集合
          for (Ebook.D5.DemoTostring.Student student : ts) {
              System.out.println(student);
          }
      }
  }
  ```

### 3.4比较器排序Comparator的使用【应用】

- 案例需求

  - 存储老师对象并遍历，创建TreeSet集合使用带参构造方法
  - 要求：按照年龄从小到大排序，年龄相同时，按照姓名的字母顺序排序

- 实现步骤

  - 用TreeSet集合存储自定义对象，带参构造方法使用的是比较器排序对元素进行排序的
  - 比较器排序，就是让集合构造方法接收Comparator的实现类对象，重写compare(T o1,T o2)方法
  - 重写方法时，一定要注意排序规则必须按照要求的主要条件和次要条件来写

- 代码实现

  老师类

  ```java
  public class Teacher {
      private String name;
      private int age;

      public Teacher() {
      }

      public Teacher(String name, int age) {
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

      @Override
      public String toString() {
          return "Teacher{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

  测试类

  ```java
  public class MyTreeSet4 {
      public static void main(String[] args) {
        	//创建集合对象
          TreeSet<Teacher> ts = new TreeSet<>(new Comparator<Teacher>() {
              @Override
              public int compare(Teacher o1, Teacher o2) {
                  //o1表示现在要存入的那个元素
                  //o2表示已经存入到集合中的元素

                  //主要条件
                  int result = o1.getAge() - o2.getAge();
                  //次要条件
                  result = result == 0 ? o1.getName().compareTo(o2.getName()) : result;
                  return result;
              }
          });
  		//创建老师对象
          Teacher t1 = new Teacher("zhangsan",23);
          Teacher t2 = new Teacher("lisi",22);
          Teacher t3 = new Teacher("wangwu",24);
          Teacher t4 = new Teacher("zhaoliu",24);
  		//把老师添加到集合
          ts.add(t1);
          ts.add(t2);
          ts.add(t3);
          ts.add(t4);
  		//遍历集合
          for (Teacher teacher : ts) {
              System.out.println(teacher);
          }
      }
  }
  ```

### 3.5两种比较方式总结【理解】

+ 两种比较方式小结
  + 自然排序: 自定义类实现Comparable接口,重写compareTo方法,根据返回值进行排序
  + 比较器排序: 创建TreeSet对象的时候传递Comparator的实现类对象,重写compare方法,根据返回值进行排序
  + 在使用的时候,默认使用自然排序,当自然排序不满足现在的需求时,必须使用比较器排序
+ 两种方式中关于返回值的规则
  + 如果返回值为负数，表示当前存入的元素是较小值，存左边
  + 如果返回值为0，表示当前存入的元素跟集合中元素重复了，不存
  + 如果返回值为正数，表示当前存入的元素是较大值，存右边

## 4.数据结构

### 4.1二叉树【理解】

+ 二叉树的特点

  + 二叉树中,任意一个节点的度要小于等于2
    + 节点: 在树结构中,每一个元素称之为节点
    + 度: 每一个节点的子节点数量称之为度

+ 二叉树结构图

  ![01_二叉树结构图](.\img\01_二叉树结构图.png)

### 4.2二叉查找树【理解】

+ 二叉查找树的特点

  + 二叉查找树,又称二叉排序树或者二叉搜索树
  + 每一个节点上最多有两个子节点
  + 左子树上所有节点的值都小于根节点的值
  + 右子树上所有节点的值都大于根节点的值

+ 二叉查找树结构图

  ![02_二叉查找树结构图](.\img\02_二叉查找树结构图.png)

+ 二叉查找树和二叉树对比结构图

  ![03_二叉查找树和二叉树对比结构图](.\img\03_二叉查找树和二叉树对比结构图.png)

+ 二叉查找树添加节点规则

  + 小的存左边
  + 大的存右边
  + 一样的不存

  ![04_二叉查找树添加节点规则](.\img\04_二叉查找树添加节点规则.png)

### 4.3平衡二叉树【理解】

+ 平衡二叉树的特点

  + 二叉树左右两个子树的高度差不超过1
  + 任意节点的左右两个子树都是一颗平衡二叉树

+ 平衡二叉树旋转

  + 旋转触发时机

    + 当添加一个节点之后,该树不再是一颗平衡二叉树

  + 左旋

    + 就是将根节点的右侧往左拉,原先的右子节点变成新的父节点,并把多余的左子节点出让,给已经降级的根节点当右子节点

    ![05_平衡二叉树左旋01](.\img\05_平衡二叉树左旋01.png)

    ![05_平衡二叉树左旋02](.\img\05_平衡二叉树左旋02.png)

  + 右旋

    + 就是将根节点的左侧往右拉,左子节点变成了新的父节点,并把多余的右子节点出让,给已经降级根节点当左子节点

      ![06_平衡二叉树右旋01](.\img\06_平衡二叉树右旋01.png)

      ![06_平衡二叉树右旋02](.\img\06_平衡二叉树右旋02.png)

+ 平衡二叉树和二叉查找树对比结构图

  ![07_平衡二叉树和二叉查找树对比结构图](.\img\07_平衡二叉树和二叉查找树对比结构图.png)

+ 平衡二叉树旋转的四种情况

  + 左左

    + 左左: 当根节点左子树的左子树有节点插入,导致二叉树不平衡

    + 如何旋转: 直接对整体进行右旋即可

      ![08_平衡二叉树左左](.\img\08_平衡二叉树左左.png)

  + 左右

    + 左右: 当根节点左子树的右子树有节点插入,导致二叉树不平衡

    + 如何旋转: 先在左子树对应的节点位置进行左旋,在对整体进行右旋

      ![09_平衡二叉树左右](.\img\09_平衡二叉树左右.png)

  + 右右

    + 右右: 当根节点右子树的右子树有节点插入,导致二叉树不平衡

    + 如何旋转: 直接对整体进行左旋即可

      ![10_平衡二叉树右右](.\img\10_平衡二叉树右右.png)

  + 右左

    + 右左:当根节点右子树的左子树有节点插入,导致二叉树不平衡

    + 如何旋转: 先在右子树对应的节点位置进行右旋,在对整体进行左旋

      ![11_平衡二叉树右左](.\img\11_平衡二叉树右左.png)


# day10接口_多态-集合03

## hhh.红黑树

### hhh.1概述【理解】

- 红黑树的特点

  - 平衡二叉B树
  - 每一个节点可以是红或者黑
  - 红黑树不是高度平衡的,它的平衡是通过"自己的红黑规则"进行实现的

- 红黑树的红黑规则有哪些

  hhh. 每一个节点或是红色的,或者是黑色的

  2. 根节点必须是黑色

  3. 如果一个节点没有子节点或者父节点,则该节点相应的指针属性值为Nil,这些Nil视为叶节点,每个叶节点(Nil)是黑色的

  4. 如果某一个节点是红色,那么它的子节点必须是黑色(不能出现两个红色节点相连 的情况)

  5. 对每一个节点,从该节点到其所有后代叶节点的简单路径上,均包含相同数目的黑色节点

     ![12_红黑树结构图](.\img\12_红黑树结构图.png)

- 红黑树添加节点的默认颜色

  - 添加节点时,默认为红色,效率高

    ![13_红黑树添加节点颜色](.\img\13_红黑树添加节点颜色.png)

- 红黑树添加节点后如何保持红黑规则

  - 根节点位置
    - 直接变为黑色
  - 非根节点位置
    - 父节点为黑色
      - 不需要任何操作,默认红色即可
    - 父节点为红色
      - 叔叔节点为红色
        hhh. 将"父节点"设为黑色,将"叔叔节点"设为黑色
        2. 将"祖父节点"设为红色
        3. 如果"祖父节点"为根节点,则将根节点再次变成黑色
      - 叔叔节点为黑色
        hhh. 将"父节点"设为黑色
        2. 将"祖父节点"设为红色
        3. 以"祖父节点"为支点进行旋转

### hhh.2成绩排序案例【应用】

- 案例需求

  - 用TreeSet集合存储多个学生信息(姓名,语文成绩,数学成绩,英语成绩),并遍历该集合
  - 要求: 按照总分从高到低出现

- 代码实现

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student implements Comparable<Test22.D19.Ebook.D5.DemoTostring.Student> {
      private String name;
      private int chinese;
      private int math;
      private int english;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int chinese, int math, int english) {
          this.name = name;
          this.chinese = chinese;
          this.math = math;
          this.english = english;
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }

      public int getChinese() {
          return chinese;
      }

      public void setChinese(int chinese) {
          this.chinese = chinese;
      }

      public int getMath() {
          return math;
      }

      public void setMath(int math) {
          this.math = math;
      }

      public int getEnglish() {
          return english;
      }

      public void setEnglish(int english) {
          this.english = english;
      }

      public int getSum() {
          return this.chinese + this.math + this.english;
      }

      @Override
      public int compareTo(Test22.D19.Ebook.D5.DemoTostring.Student o) {
          // 主要条件: 按照总分进行排序
          int result = o.getSum() - this.getSum();
          // 次要条件: 如果总分一样,就按照语文成绩排序
          result = result == 0 ? o.getChinese() - this.getChinese() : result;
          // 如果语文成绩也一样,就按照数学成绩排序
          result = result == 0 ? o.getMath() - this.getMath() : result;
          // 如果总分一样,各科成绩也都一样,就按照姓名排序
          result = result == 0 ? o.getName().compareTo(this.getName()) : result;
          return result;
      }
  }
  ```

  测试类

  ```java
  public class TreeSetDemo {
      public static void main(String[] args) {
          //创建TreeSet集合对象，通过比较器排序进行排序
          TreeSet<Ebook.D5.DemoTostring.Student> ts = new TreeSet<Ebook.D5.DemoTostring.Student>();
          //创建学生对象
          Ebook.D5.DemoTostring.Student s1 = new Ebook.D5.DemoTostring.Student("jack", 98, 100, 95);
          Ebook.D5.DemoTostring.Student s2 = new Ebook.D5.DemoTostring.Student("rose", 95, 95, 95);
          Ebook.D5.DemoTostring.Student s3 = new Ebook.D5.DemoTostring.Student("sam", 100, 93, 98);
          //把学生对象添加到集合
          ts.add(s1);
          ts.add(s2);
          ts.add(s3);

          //遍历集合
          for (Ebook.D5.DemoTostring.Student s : ts) {
              System.out.println(s.getName() + "," + s.getChinese() + "," + s.getMath() + "," + s.getEnglish() + "," + s.getSum());
          }
      }
  }
  ```

## 2.HashSet集合

### 2.1HashSet集合概述和特点【应用】

- 底层数据结构是哈希表
- 存取无序
- 不可以存储重复元素
- 没有索引,不能使用普通for循环遍历

### 2.2HashSet集合的基本应用【应用】

存储字符串并遍历

```java
public class HashSetDemo {
    public static void main(String[] args) {
        //创建集合对象
        HashSet<String> set = new HashSet<String>();

        //添加元素
        set.add("hello");
        set.add("world");
        set.add("java");
        //不包含重复元素的集合
        set.add("world");

        //遍历
        for(String s : set) {
            System.out.println(s);
        }
    }
}
```

### 2.3哈希值【理解】

- 哈希值简介

  ​	是JDK根据对象的地址或者字符串或者数字算出来的int类型的数值

- 如何获取哈希值

  ​	Object类中的public int hashCode()：返回对象的哈希码值

- 哈希值的特点

  - 同一个对象多次调用hashCode()方法返回的哈希值是相同的
  - 默认情况下，不同对象的哈希值是不同的。而重写hashCode()方法，可以实现让不同对象的哈希值相同

### 2.4哈希表结构【理解】

- JDK1.8以前

  ​	数组 + 链表

  ![14_JKD8以前哈希表](.\img\14_JKD8以前哈希表.png)

- JDK1.8以后

  - 节点个数少于等于8个

    ​	数组 + 链表

  - 节点个数多于8个

    ​	数组 + 红黑树

  ![15_JKD8以后哈希表](.\img\15_JKD8以后哈希表.png)

### 2.5HashSet集合存储学生对象并遍历【应用】

- 案例需求

  - 创建一个存储学生对象的集合，存储多个学生对象，使用程序实现在控制台遍历该集合
  - 要求：学生对象的成员变量值相同，我们就认为是同一个对象

- 代码实现

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student {
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;

          Test22.D19.Ebook.D5.DemoTostring.Student student = (Test22.D19.Ebook.D5.DemoTostring.Student) o;

          if (age != student.age) return false;
          return name != null ? name.equals(student.name) : student.name == null;
      }

      @Override
      public int hashCode() {
          int result = name != null ? name.hashCode() : 0;
          result = 31 * result + age;
          return result;
      }
  }
  ```

  测试类

  ```java
  public class HashSetDemo02 {
      public static void main(String[] args) {
          //创建HashSet集合对象
          HashSet<Ebook.D5.DemoTostring.Student> hs = new HashSet<Ebook.D5.DemoTostring.Student>();

          //创建学生对象
          Ebook.D5.DemoTostring.Student s1 = new Ebook.D5.DemoTostring.Student("林青霞", 30);
          Ebook.D5.DemoTostring.Student s2 = new Ebook.D5.DemoTostring.Student("张曼玉", 35);
          Ebook.D5.DemoTostring.Student s3 = new Ebook.D5.DemoTostring.Student("王祖贤", 33);

          Ebook.D5.DemoTostring.Student s4 = new Ebook.D5.DemoTostring.Student("王祖贤", 33);

          //把学生添加到集合
          hs.add(s1);
          hs.add(s2);
          hs.add(s3);
          hs.add(s4);

          //遍历集合(增强for)
          for (Ebook.D5.DemoTostring.Student s : hs) {
              System.out.println(s.getName() + "," + s.getAge());
          }
      }
  }
  ```

- 总结

  ​	HashSet集合存储自定义类型元素,要想实现元素的唯一,要求必须重写hashCode方法和equals方法

## 3.Map集合

### 3.1Map集合概述和特点【理解】

- Map集合概述

  ```java
  interface Map<K,V>  K：键的类型；V：值的类型
  ```

- Map集合的特点

  - 双列集合,一个键对应一个值
  - 键不可以重复,值可以重复

- Map集合的基本使用

  ```java
  public class MapDemo01 {
      public static void main(String[] args) {
          //创建集合对象
          Map<String,String> map = new HashMap<String,String>();

          //V put(K key, V value) 将指定的值与该映射中的指定键相关联
          map.put("itheima001","林青霞");
          map.put("itheima002","张曼玉");
          map.put("itheima003","王祖贤");
          map.put("itheima003","柳岩");

          //输出集合对象
          System.out.println(map);
      }
  }
  ```

### 3.2Map集合的基本功能【应用】

- 方法介绍

  | 方法名                                 | 说明                 |
  | ----------------------------------- | ------------------ |
  | V   put(K key,V   value)            | 添加元素               |
  | V   remove(Object key)              | 根据键删除键值对元素         |
  | void   clear()                      | 移除所有的键值对元素         |
  | boolean containsKey(Object key)     | 判断集合是否包含指定的键       |
  | boolean containsValue(Object value) | 判断集合是否包含指定的值       |
  | boolean isEmpty()                   | 判断集合是否为空           |
  | int size()                          | 集合的长度，也就是集合中键值对的个数 |

- 示例代码

  ```java
  public class MapDemo02 {
      public static void main(String[] args) {
          //创建集合对象
          Map<String,String> map = new HashMap<String,String>();

          //V put(K key,V value)：添加元素
          map.put("张无忌","赵敏");
          map.put("郭靖","黄蓉");
          map.put("杨过","小龙女");

          //V remove(Object key)：根据键删除键值对元素
  //        System.out.println(map.remove("郭靖"));
  //        System.out.println(map.remove("郭襄"));

          //void clear()：移除所有的键值对元素
  //        map.clear();

          //boolean containsKey(Object key)：判断集合是否包含指定的键
  //        System.out.println(map.containsKey("郭靖"));
  //        System.out.println(map.containsKey("郭襄"));

          //boolean isEmpty()：判断集合是否为空
  //        System.out.println(map.isEmpty());

          //int size()：集合的长度，也就是集合中键值对的个数
          System.out.println(map.size());

          //输出集合对象
          System.out.println(map);
      }
  }
  ```

### 3.3Map集合的获取功能【应用】

- 方法介绍

  | 方法名                              | 说明           |
  | -------------------------------- | ------------ |
  | V   get(Object key)              | 根据键获取值       |
  | Set<K>   keySet()                | 获取所有键的集合     |
  | Collection<V>   values()         | 获取所有值的集合     |
  | Set<Map.Entry<K,V>>   entrySet() | 获取所有键值对对象的集合 |

- 示例代码

  ```java
  public class MapDemo03 {
      public static void main(String[] args) {
          //创建集合对象
          Map<String, String> map = new HashMap<String, String>();

          //添加元素
          map.put("张无忌", "赵敏");
          map.put("郭靖", "黄蓉");
          map.put("杨过", "小龙女");

          //V get(Object key):根据键获取值
  //        System.out.println(map.get("张无忌"));
  //        System.out.println(map.get("张三丰"));

          //Set<K> keySet():获取所有键的集合
  //        Set<String> keySet = map.keySet();
  //        for(String key : keySet) {
  //            System.out.println(key);
  //        }

          //Collection<V> values():获取所有值的集合
          Collection<String> values = map.values();
          for(String value : values) {
              System.out.println(value);
          }
      }
  }
  ```

### 3.4Map集合的遍历(方式1)【应用】

- 遍历思路

  - 我们刚才存储的元素都是成对出现的，所以我们把Map看成是一个夫妻对的集合
    - 把所有的丈夫给集中起来
    - 遍历丈夫的集合，获取到每一个丈夫
    - 根据丈夫去找对应的妻子

- 步骤分析

  - 获取所有键的集合。用keySet()方法实现
  - 遍历键的集合，获取到每一个键。用增强for实现
  - 根据键去找值。用get(Object key)方法实现

- 代码实现

  ```java
  public class MapDemo01 {
      public static void main(String[] args) {
          //创建集合对象
          Map<String, String> map = new HashMap<String, String>();

          //添加元素
          map.put("张无忌", "赵敏");
          map.put("郭靖", "黄蓉");
          map.put("杨过", "小龙女");

          //获取所有键的集合。用keySet()方法实现
          Set<String> keySet = map.keySet();
          //遍历键的集合，获取到每一个键。用增强for实现
          for (String key : keySet) {
              //根据键去找值。用get(Object key)方法实现
              String value = map.get(key);
              System.out.println(key + "," + value);
          }
      }
  }
  ```

### 3.5Map集合的遍历(方式2)【应用】

- 遍历思路

  - 我们刚才存储的元素都是成对出现的，所以我们把Map看成是一个夫妻对的集合
    - 获取所有结婚证的集合
    - 遍历结婚证的集合，得到每一个结婚证
    - 根据结婚证获取丈夫和妻子

- 步骤分析

  - 获取所有键值对对象的集合
    - Set<Map.Entry<K,V>> entrySet()：获取所有键值对对象的集合
  - 遍历键值对对象的集合，得到每一个键值对对象
    - 用增强for实现，得到每一个Map.Entry
  - 根据键值对对象获取键和值
    - 用getKey()得到键
    - 用getValue()得到值

- 代码实现

  ```java
  public class MapDemo02 {
      public static void main(String[] args) {
          //创建集合对象
          Map<String, String> map = new HashMap<String, String>();

          //添加元素
          map.put("张无忌", "赵敏");
          map.put("郭靖", "黄蓉");
          map.put("杨过", "小龙女");

          //获取所有键值对对象的集合
          Set<Map.Entry<String, String>> entrySet = map.entrySet();
          //遍历键值对对象的集合，得到每一个键值对对象
          for (Map.Entry<String, String> me : entrySet) {
              //根据键值对对象获取键和值
              String key = me.getKey();
              String value = me.getValue();
              System.out.println(key + "," + value);
          }
      }
  }
  ```

## 4.HashMap集合

### 4.1HashMap集合概述和特点【理解】

+ HashMap底层是哈希表结构的
+ 依赖hashCode方法和equals方法保证键的唯一
+ 如果键要存储的是自定义对象，需要重写hashCode和equals方法

### 4.2HashMap集合应用案例【应用】

- 案例需求

  - 创建一个HashMap集合，键是学生对象(Test22.D19.Ebook.D5.DemoTostring.Student)，值是居住地 (String)。存储多个元素，并遍历。
  - 要求保证键的唯一性：如果学生对象的成员变量值相同，我们就认为是同一个对象

- 代码实现

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student {
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      @Override
      public boolean equals(Object o) {
          if (this == o) return true;
          if (o == null || getClass() != o.getClass()) return false;

          Test22.D19.Ebook.D5.DemoTostring.Student student = (Test22.D19.Ebook.D5.DemoTostring.Student) o;

          if (age != student.age) return false;
          return name != null ? name.equals(student.name) : student.name == null;
      }

      @Override
      public int hashCode() {
          int result = name != null ? name.hashCode() : 0;
          result = 31 * result + age;
          return result;
      }
  }
  ```

  测试类

  ```java
  public class HashMapDemo {
      public static void main(String[] args) {
          //创建HashMap集合对象
          HashMap<Ebook.D5.DemoTostring.Student, String> hm = new HashMap<Ebook.D5.DemoTostring.Student, String>();

          //创建学生对象
          Ebook.D5.DemoTostring.Student s1 = new Ebook.D5.DemoTostring.Student("林青霞", 30);
          Ebook.D5.DemoTostring.Student s2 = new Ebook.D5.DemoTostring.Student("张曼玉", 35);
          Ebook.D5.DemoTostring.Student s3 = new Ebook.D5.DemoTostring.Student("王祖贤", 33);
          Ebook.D5.DemoTostring.Student s4 = new Ebook.D5.DemoTostring.Student("王祖贤", 33);

          //把学生添加到集合
          hm.put(s1, "西安");
          hm.put(s2, "武汉");
          hm.put(s3, "郑州");
          hm.put(s4, "北京");

          //遍历集合
          Set<Ebook.D5.DemoTostring.Student> keySet = hm.keySet();
          for (Ebook.D5.DemoTostring.Student key : keySet) {
              String value = hm.get(key);
              System.out.println(key.getName() + "," + key.getAge() + "," + value);
          }
      }
  }
  ```

## 5.TreeMap集合

### 5.1TreeMap集合概述和特点【理解】

+ TreeMap底层是红黑树结构
+ 依赖自然排序或者比较器排序,对键进行排序
+ 如果键存储的是自定义对象,需要实现Comparable接口或者在创建TreeMap对象时候给出比较器排序规则

### 5.2TreeMap集合应用案例【应用】

+ 案例需求

  + 创建一个TreeMap集合,键是学生对象(Test22.D19.Ebook.D5.DemoTostring.Student),值是籍贯(String),学生属性姓名和年龄,按照年龄进行排序并遍历
  + 要求按照学生的年龄进行排序,如果年龄相同则按照姓名进行排序

+ 代码实现

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student implements Comparable<Test22.D19.Ebook.D5.DemoTostring.Student>{
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }

      @Override
      public int compareTo(Test22.D19.Ebook.D5.DemoTostring.Student o) {
          //按照年龄进行排序
          int result = o.getAge() - this.getAge();
          //次要条件，按照姓名排序。
          result = result == 0 ? o.getName().compareTo(this.getName()) : result;
          return result;
      }
  }
  ```

  测试类

  ```java
  public class Test1 {
      public static void main(String[] args) {
        	// 创建TreeMap集合对象
          TreeMap<Ebook.D5.DemoTostring.Student,String> tm = new TreeMap<>();

  		// 创建学生对象
          Ebook.D5.DemoTostring.Student s1 = new Ebook.D5.DemoTostring.Student("xiaohei",23);
          Ebook.D5.DemoTostring.Student s2 = new Ebook.D5.DemoTostring.Student("dapang",22);
          Ebook.D5.DemoTostring.Student s3 = new Ebook.D5.DemoTostring.Student("xiaomei",22);

  		// 将学生对象添加到TreeMap集合中
          tm.put(s1,"江苏");
          tm.put(s2,"北京");
          tm.put(s3,"天津");

  		// 遍历TreeMap集合,打印每个学生的信息
          tm.forEach(
                  (Ebook.D5.DemoTostring.Student key, String value)->{
                      System.out.println(key + "---" + value);
                  }
          );
      }
  }
  ```


# day11-集合04

## hhh.可变参数

### hhh.1可变参数【应用】

- 可变参数介绍

  - 可变参数又称参数个数可变，用作方法的形参出现，那么方法参数个数就是可变的了
  - 方法的参数类型已经确定,个数不确定,我们可以使用可变参数

- 可变参数定义格式

  ```java
  修饰符 返回值类型 方法名(数据类型… 变量名) {  }
  ```

- 可变参数的注意事项

  - 这里的变量其实是一个数组
  - 如果一个方法有多个参数，包含可变参数，可变参数要放在最后

- 可变参数的基本使用

  ```java
  public class ArgsDemo01 {
      public static void main(String[] args) {
          System.out.println(sum(10, 20));
          System.out.println(sum(10, 20, 30));
          System.out.println(sum(10, 20, 30, 40));

          System.out.println(sum(10,20,30,40,50));
          System.out.println(sum(10,20,30,40,50,60));
          System.out.println(sum(10,20,30,40,50,60,70));
          System.out.println(sum(10,20,30,40,50,60,70,80,90,100));
      }

  //    public static int sum(int b,int... a) {
  //        return 0;
  //    }

      public static int sum(int... a) {
          int sum = 0;
          for(int i : a) {
              sum += i;
          }
          return sum;
      }
  }
  ```

### hhh.2创建不可变集合【理解】

- 方法介绍

  - 在List、Set、Map接口中,都存在of方法,可以创建一个不可变的集合
    - 这个集合不能添加,不能删除,不能修改
    - 但是可以结合集合的带参构造,实现集合的批量添加
  - 在Map接口中,还有一个ofEntries方法可以提高代码的阅读性
    - 首先会把键值对封装成一个Entry对象,再把这个Entry对象添加到集合当中

- 示例代码

  ```java
  public class MyVariableParameter4 {
      public static void main(String[] args) {
          // static <E>  List<E>  of(E…elements)  创建一个具有指定元素的List集合对象
          //static <E>  Set<E>  of(E…elements)    创建一个具有指定元素的Set集合对象
          //static <K , V>   Map<K，V>  of(E…elements) 创建一个具有指定元素的Map集合对象

          //method1();
          //method2();
          //method3();
          //method4();

      }

      private static void method4() {
          Map<String, String> map = Map.ofEntries(
                  Map.infoManager.entry("zhangsan", "江苏"),
                  Map.infoManager.entry("lisi", "北京"));
          System.out.println(map);
      }

      private static void method3() {
          Map<String, String> map = Map.of("zhangsan", "江苏", "lisi", "北京", "wangwu", "天津");
          System.out.println(map);
      }

      private static void method2() {
          //传递的参数当中，不能存在重复的元素。
          Set<String> set = Set.of("a", "b", "c", "d","a");
          System.out.println(set);
      }

      private static void method1() {
          List<String> list = List.of("a", "b", "c", "d");
          System.out.println(list);
          //list.add("Q");
          //list.remove("a");
          //list.set(0,"A");
          //System.out.println(list);

  //        ArrayList<String> list2 = new ArrayList<>();
  //        list2.add("aaa");
  //        list2.add("aaa");
  //        list2.add("aaa");
  //        list2.add("aaa");

          //集合的批量添加。
          //首先是通过调用List.of方法来创建一个不可变的集合，of方法的形参就是一个可变参数。
          //再创建一个ArrayList集合，并把这个不可变的集合中所有的数据，都添加到ArrayList中。
          ArrayList<String> list3 = new ArrayList<>(List.of("a", "b", "c", "d"));
          System.out.println(list3);
      }
  }
  ```

## 2.Stream流

### 2.1体验Stream流【理解】

- 案例需求

  按照下面的要求完成集合的创建和遍历

  - 创建一个集合，存储多个字符串元素
  - 把集合中所有以"张"开头的元素存储到一个新的集合
  - 把"张"开头的集合中的长度为3的元素存储到一个新的集合
  - 遍历上一步得到的集合

- 原始方式示例代码

  ```java
  public class MyStream1 {
      public static void main(String[] args) {
          //集合的批量添加
          ArrayList<String> list1 = new ArrayList<>(List.of("张三丰","张无忌","张翠山","王二麻子","张良","谢广坤"));
          //list.add()

          //遍历list1把以张开头的元素添加到list2中。
          ArrayList<String> list2 = new ArrayList<>();
          for (String s : list1) {
              if(s.startsWith("张")){
                  list2.add(s);
              }
          }
          //遍历list2集合，把其中长度为3的元素，再添加到list3中。
          ArrayList<String> list3 = new ArrayList<>();
          for (String s : list2) {
              if(s.length() == 3){
                  list3.add(s);
              }
          }
          for (String s : list3) {
              System.out.println(s);
          }
      }
  }
  ```

- 使用Stream流示例代码

  ```java
  public class StreamDemo {
      public static void main(String[] args) {
          //集合的批量添加
          ArrayList<String> list1 = new ArrayList<>(List.of("张三丰","张无忌","张翠山","王二麻子","张良","谢广坤"));

          //Stream流
          list1.stream().filter(s->s.startsWith("张"))
                  .filter(s->s.length() == 3)
                  .forEach(s-> System.out.println(s));
      }
  }
  ```

- Stream流的好处

  - 直接阅读代码的字面意思即可完美展示无关逻辑方式的语义：获取流、过滤姓张、过滤长度为3、逐一打印
  - Stream流把真正的函数式编程风格引入到Java中
  - 代码简洁

### 2.2Stream流的常见生成方式【应用】

- Stream流的思想

  ![01_Stream流思想](.\img\01_Stream流思想.png)

- Stream流的三类方法

  - 获取Stream流
    - 创建一条流水线,并把数据放到流水线上准备进行操作
  - 中间方法
    - 流水线上的操作
    - 一次操作完毕之后,还可以继续进行其他操作
  - 终结方法
    - 一个Stream流只能有一个终结方法
    - 是流水线上的最后一个操作

- 生成Stream流的方式

  - Collection体系集合

    使用默认方法stream()生成流， default Stream<E> stream()

  - Map体系集合

    把Map转成Set集合，间接的生成流

  - 数组

    通过Arrays中的静态方法stream生成流

  - 同种数据类型的多个数据

    通过Stream接口的静态方法of(T... values)生成流

- 代码演示

  ```java
  public class StreamDemo {
      public static void main(String[] args) {
          //Collection体系的集合可以使用默认方法stream()生成流
          List<String> list = new ArrayList<String>();
          Stream<String> listStream = list.stream();

          Set<String> set = new HashSet<String>();
          Stream<String> setStream = set.stream();

          //Map体系的集合间接的生成流
          Map<String,Integer> map = new HashMap<String, Integer>();
          Stream<String> keyStream = map.keySet().stream();
          Stream<Integer> valueStream = map.values().stream();
          Stream<Map.Entry<String, Integer>> entryStream = map.entrySet().stream();

          //数组可以通过Arrays中的静态方法stream生成流
          String[] strArray = {"hello","world","java"};
          Stream<String> strArrayStream = Arrays.stream(strArray);

        	//同种数据类型的多个数据可以通过Stream接口的静态方法of(T... values)生成流
          Stream<String> strArrayStream2 = Stream.of("hello", "world", "java");
          Stream<Integer> intStream = Stream.of(10, 20, 30);
      }
  }
  ```

### 2.3Stream流中间操作方法【应用】

- 概念

  中间操作的意思是,执行完此方法之后,Stream流依然可以继续执行其他操作

- 常见方法

  | 方法名                                      | 说明                                       |
  | ---------------------------------------- | ---------------------------------------- |
  | Stream<T> filter(Predicate predicate)    | 用于对流中的数据进行过滤                             |
  | Stream<T> limit(long maxSize)            | 返回此流中的元素组成的流，截取前指定参数个数的数据                |
  | Stream<T> skip(long n)                   | 跳过指定参数个数的数据，返回由该流的剩余元素组成的流               |
  | static <T> Stream<T> concat(Stream a, Stream b) | 合并a和b两个流为一个流                             |
  | Stream<T> distinct()                     | 返回由该流的不同元素（根据Object.equals(Object) ）组成的流 |

- filter代码演示

  ```java
  public class MyStream3 {
      public static void main(String[] args) {
  //        Stream<T> filter(Predicate predicate)：过滤
  //        Predicate接口中的方法	boolean test(T t)：对给定的参数进行判断，返回一个布尔值

          ArrayList<String> list = new ArrayList<>();
          list.add("张三丰");
          list.add("张无忌");
          list.add("张翠山");
          list.add("王二麻子");
          list.add("张良");
          list.add("谢广坤");

          //filter方法获取流中的 每一个数据.
          //而test方法中的s,就依次表示流中的每一个数据.
          //我们只要在test方法中对s进行判断就可以了.
          //如果判断的结果为true,则当前的数据留下
          //如果判断的结果为false,则当前数据就不要.
  //        list.stream().filter(
  //                new Predicate<String>() {
  //                    @Override
  //                    public boolean test(String s) {
  //                        boolean result = s.startsWith("张");
  //                        return result;
  //                    }
  //                }
  //        ).forEach(s-> System.out.println(s));

          //因为Predicate接口中只有一个抽象方法test
          //所以我们可以使用lambda表达式来简化
  //        list.stream().filter(
  //                (String s)->{
  //                    boolean result = s.startsWith("张");
  //                        return result;
  //                }
  //        ).forEach(s-> System.out.println(s));

          list.stream().filter(s ->s.startsWith("张")).forEach(s-> System.out.println(s));

      }
  }
  ```

- limit&skip代码演示

  ```java
  public class StreamDemo02 {
      public static void main(String[] args) {
          //创建一个集合，存储多个字符串元素
          ArrayList<String> list = new ArrayList<String>();

          list.add("林青霞");
          list.add("张曼玉");
          list.add("王祖贤");
          list.add("柳岩");
          list.add("张敏");
          list.add("张无忌");

          //需求1：取前3个数据在控制台输出
          list.stream().limit(3).forEach(s-> System.out.println(s));
          System.out.println("--------");

          //需求2：跳过3个元素，把剩下的元素在控制台输出
          list.stream().skip(3).forEach(s-> System.out.println(s));
          System.out.println("--------");

          //需求3：跳过2个元素，把剩下的元素中前2个在控制台输出
          list.stream().skip(2).limit(2).forEach(s-> System.out.println(s));
      }
  }
  ```

- concat&distinct代码演示

  ```java
  public class StreamDemo03 {
      public static void main(String[] args) {
          //创建一个集合，存储多个字符串元素
          ArrayList<String> list = new ArrayList<String>();

          list.add("林青霞");
          list.add("张曼玉");
          list.add("王祖贤");
          list.add("柳岩");
          list.add("张敏");
          list.add("张无忌");

          //需求1：取前4个数据组成一个流
          Stream<String> s1 = list.stream().limit(4);

          //需求2：跳过2个数据组成一个流
          Stream<String> s2 = list.stream().skip(2);

          //需求3：合并需求1和需求2得到的流，并把结果在控制台输出
  //        Stream.concat(s1,s2).forEach(s-> System.out.println(s));

          //需求4：合并需求1和需求2得到的流，并把结果在控制台输出，要求字符串元素不能重复
          Stream.concat(s1,s2).distinct().forEach(s-> System.out.println(s));
      }
  }
  ```

### 2.4Stream流终结操作方法【应用】

- 概念

  终结操作的意思是,执行完此方法之后,Stream流将不能再执行其他操作

- 常见方法

  | 方法名                           | 说明           |
  | ----------------------------- | ------------ |
  | void forEach(Consumer action) | 对此流的每个元素执行操作 |
  | long count()                  | 返回此流中的元素数    |

- 代码演示

  ```java
  public class MyStream5 {
      public static void main(String[] args) {
          ArrayList<String> list = new ArrayList<>();
          list.add("张三丰");
          list.add("张无忌");
          list.add("张翠山");
          list.add("王二麻子");
          list.add("张良");
          list.add("谢广坤");

          //method1(list);

  //        long count()：返回此流中的元素数
          long count = list.stream().count();
          System.out.println(count);
      }

      private static void method1(ArrayList<String> list) {
          //  void forEach(Consumer action)：对此流的每个元素执行操作
          //  Consumer接口中的方法void accept(T t)：对给定的参数执行此操作
          //在forEach方法的底层,会循环获取到流中的每一个数据.
          //并循环调用accept方法,并把每一个数据传递给accept方法
          //s就依次表示了流中的每一个数据.
          //所以,我们只要在accept方法中,写上处理的业务逻辑就可以了.
          list.stream().forEach(
                  new Consumer<String>() {
                      @Override
                      public void accept(String s) {
                          System.out.println(s);
                      }
                  }
          );

          System.out.println("====================");
          //lambda表达式的简化格式
          //是因为Consumer接口中,只有一个accept方法
          list.stream().forEach(
                  (String s)->{
                      System.out.println(s);
                  }
          );
          System.out.println("====================");
          //lambda表达式还是可以进一步简化的.
          list.stream().forEach(s->System.out.println(s));
      }
  }
  ```

### 2.5Stream流的收集操作【应用】

- 概念

  对数据使用Stream流的方式操作完毕后,可以把流中的数据收集到集合中

- 常用方法

  | 方法名                            | 说明        |
  | ------------------------------ | --------- |
  | R collect(Collector collector) | 把结果收集到集合中 |

- 工具类Collectors提供了具体的收集方式

  | 方法名                                      | 说明            |
  | ---------------------------------------- | ------------- |
  | public static <T> Collector toList()     | 把元素收集到List集合中 |
  | public static <T> Collector toSet()      | 把元素收集到Set集合中  |
  | public static  Collector toMap(Function keyMapper,Function valueMapper) | 把元素收集到Map集合中  |

- 代码演示

  ```java
  // toList和toSet方法演示
  public class MyStream7 {
      public static void main(String[] args) {
          ArrayList<Integer> list1 = new ArrayList<>();
          for (int i = hhh; i <= 10; i++) {
              list1.add(i);
          }

          list1.add(10);
          list1.add(10);
          list1.add(10);
          list1.add(10);
          list1.add(10);

          //filter负责过滤数据的.
          //collect负责收集数据.
                  //获取流中剩余的数据,但是他不负责创建容器,也不负责把数据添加到容器中.
          //Collectors.toList() : 在底层会创建一个List集合.并把所有的数据添加到List集合中.
          List<Integer> list = list1.stream().filter(number -> number % 2 == 0)
                  .collect(Collectors.toList());

          System.out.println(list);

      Set<Integer> set = list1.stream().filter(number -> number % 2 == 0)
              .collect(Collectors.toSet());
      System.out.println(set);
  }
  }
  /**
  Stream流的收集方法 toMap方法演示
  创建一个ArrayList集合，并添加以下字符串。字符串中前面是姓名，后面是年龄
  "zhangsan,23"
  "lisi,24"
  "wangwu,25"
  保留年龄大于等于24岁的人，并将结果收集到Map集合中，姓名为键，年龄为值
  */
  public class MyStream8 {
  	public static void main(String[] args) {
        	ArrayList<String> list = new ArrayList<>();
          list.add("zhangsan,23");
          list.add("lisi,24");
          list.add("wangwu,25");

          Map<String, Integer> map = list.stream().filter(
                  s -> {
                      String[] split = s.split(",");
                      int age = Integer.parseInt(split[hhh]);
                      return age >= 24;
                  }

           //   collect方法只能获取到流中剩余的每一个数据.
           //在底层不能创建容器,也不能把数据添加到容器当中

           //Collectors.toMap 创建一个map集合并将数据添加到集合当中

            // s 依次表示流中的每一个数据

            //第一个lambda表达式就是如何获取到Map中的键
            //第二个lambda表达式就是如何获取Map中的值
          ).collect(Collectors.toMap(
                  s -> s.split(",")[0],
                  s -> Integer.parseInt(s.split(",")[hhh]) ));

          System.out.println(map);
  	}
  }
  ```

### 5.6Stream流综合练习【应用】

- 案例需求

  现在有两个ArrayList集合，分别存储6名男演员名称和6名女演员名称，要求完成如下的操作

  - 男演员只要名字为3个字的前三人
  - 女演员只要姓林的，并且不要第一个
  - 把过滤后的男演员姓名和女演员姓名合并到一起
  - 把上一步操作后的元素作为构造方法的参数创建演员对象,遍历数据

  演员类Actor已经提供，里面有一个成员变量，一个带参构造方法，以及成员变量对应的get/set方法

- 代码实现

  演员类
  ```java
  public class Actor {
      private String name;

      public Actor(String name) {
          this.name = name;
      }

      public String getName() {
          return name;
      }

      public void setName(String name) {
          this.name = name;
      }
  }
  ```

  测试类

  ```java
  public class StreamTest {
      public static void main(String[] args) {
          //创建集合
          ArrayList<String> manList = new ArrayList<String>();
          manList.add("周润发");
          manList.add("成龙");
          manList.add("刘德华");
          manList.add("吴京");
          manList.add("周星驰");
          manList.add("李连杰");

          ArrayList<String> womanList = new ArrayList<String>();
          womanList.add("林心如");
          womanList.add("张曼玉");
          womanList.add("林青霞");
          womanList.add("柳岩");
          womanList.add("林志玲");
          womanList.add("王祖贤");

          //男演员只要名字为3个字的前三人
          Stream<String> manStream = manList.stream().filter(s -> s.length() == 3).limit(3);

          //女演员只要姓林的，并且不要第一个
          Stream<String> womanStream = womanList.stream().filter(s -> s.startsWith("林")).skip(hhh);

          //把过滤后的男演员姓名和女演员姓名合并到一起
          Stream<String> stream = Stream.concat(manStream, womanStream);

        	// 将流中的数据封装成Actor对象之后打印
        	stream.forEach(name -> {
              Actor actor = new Actor(name);
              System.out.println(actor);
          });
      }
  }
  ```



# day12-IO流

## hhh.File类

### hhh.1File类概述和构造方法【应用】

- File类介绍

  - 它是文件和目录路径名的抽象表示
  - 文件和目录是可以通过File封装成对象的
  - 对于File而言,其封装的并不是一个真正存在的文件,仅仅是一个路径名而已.它可以是存在的,也可以是不存在的.将来是要通过具体的操作把这个路径的内容转换为具体存在的

- File类的构造方法

  | 方法名                                 | 说明                               |
  | ----------------------------------- | -------------------------------- |
  | File(String   pathname)             | 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例 |
  | File(String   parent, String child) | 从父路径名字符串和子路径名字符串创建新的   File实例    |
  | File(File   parent, String child)   | 从父抽象路径名和子路径名字符串创建新的   File实例     |

- 示例代码

  ```java
  public class FileDemo01 {
      public static void main(String[] args) {
          //File(String pathname): 通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例
              File f1 = new File("E:\\itcast\\java.txt");
              System.out.println(f1);

          //File(String parent, String child): 从父路径名字符串和子路径名字符串创建新的 File实例
          File f2 = new File("E:\\itcast","java.txt");
          System.out.println(f2);

          //File(File parent, String child): 从父抽象路径名和子路径名字符串创建新的 File实例
          File f3 = new File("E:\\itcast");
          File f4 = new File(f3,"java.txt");
          System.out.println(f4);
      }
  }
  ```

### hhh.2绝对路径和相对路径【理解】

+ 绝对路径

  是一个完整的路径,从盘符开始

+ 相对路径

  是一个简化的路径,相对当前项目下的路径

+ 示例代码

  ```java
  public class FileDemo02 {
      public static void main(String[] args) {
          // 是一个完整的路径,从盘符开始
          File file1 = new File("D:\\KnowledgePoints.myInterface.interFalse\\a.txt");

          // 是一个简化的路径,从当前项目根目录开始
          File file2 = new File("a.txt");
          File file3 = new File("模块名\\a.txt");
      }
  }
  ```

### hhh.3File类创建功能【应用】

- 方法分类

  | 方法名                            | 说明                               |
  | ------------------------------ | -------------------------------- |
  | public boolean createNewFile() | 当具有该名称的文件不存在时，创建一个由该抽象路径名命名的新空文件 |
  | public boolean mkdir()         | 创建由此抽象路径名命名的目录                   |
  | public boolean mkdirs()        | 创建由此抽象路径名命名的目录，包括任何必需但不存在的父目录    |

- 示例代码

  ```java
  public class FileDemo02 {
      public static void main(String[] args) throws IOException {
          //需求1：我要在E:\\itcast目录下创建一个文件java.txt
          File f1 = new File("E:\\itcast\\java.txt");
          System.out.println(f1.createNewFile());
          System.out.println("--------");

          //需求2：我要在E:\\itcast目录下创建一个目录JavaSE
          File f2 = new File("E:\\itcast\\JavaSE");
          System.out.println(f2.mkdir());
          System.out.println("--------");

          //需求3：我要在E:\\itcast目录下创建一个多级目录JavaWEB\\HTML
          File f3 = new File("E:\\itcast\\JavaWEB\\HTML");
  //        System.out.println(f3.mkdir());
          System.out.println(f3.mkdirs());
          System.out.println("--------");

          //需求4：我要在E:\\itcast目录下创建一个文件javase.txt
          File f4 = new File("E:\\itcast\\javase.txt");
  //        System.out.println(f4.mkdir());
          System.out.println(f4.createNewFile());
      }
  }
  ```

### hhh.4File类删除功能【应用】

- 方法分类

  | 方法名                       | 说明                |
  | ------------------------- | ----------------- |
  | public boolean   delete() | 删除由此抽象路径名表示的文件或目录 |

- 示例代码

  ```java
  public class FileDemo03 {
      public static void main(String[] args) throws IOException {
  //        File f1 = new File("E:\\itcast\\java.txt");
          //需求1：在当前模块目录下创建java.txt文件
          File f1 = new File("myFile\\java.txt");
  //        System.out.println(f1.createNewFile());

          //需求2：删除当前模块目录下的java.txt文件
          System.out.println(f1.delete());
          System.out.println("--------");

          //需求3：在当前模块目录下创建itcast目录
          File f2 = new File("myFile\\itcast");
  //        System.out.println(f2.mkdir());

          //需求4：删除当前模块目录下的itcast目录
          System.out.println(f2.delete());
          System.out.println("--------");

          //需求5：在当前模块下创建一个目录itcast,然后在该目录下创建一个文件java.txt
          File f3 = new File("myFile\\itcast");
  //        System.out.println(f3.mkdir());
          File f4 = new File("myFile\\itcast\\java.txt");
  //        System.out.println(f4.createNewFile());

          //需求6：删除当前模块下的目录itcast
          System.out.println(f4.delete());
          System.out.println(f3.delete());
      }
  }
  ```

### hhh.5File类判断和获取功能【应用】

- 判断功能

  | 方法名                            | 说明                   |
  | ------------------------------ | -------------------- |
  | public   boolean isDirectory() | 测试此抽象路径名表示的File是否为目录 |
  | public   boolean isFile()      | 测试此抽象路径名表示的File是否为文件 |
  | public   boolean   exists()    | 测试此抽象路径名表示的File是否存在  |

- 获取功能

  | 方法名                               | 说明                            |
  | --------------------------------- | ----------------------------- |
  | public   String getAbsolutePath() | 返回此抽象路径名的绝对路径名字符串             |
  | public   String getPath()         | 将此抽象路径名转换为路径名字符串              |
  | public   String getName()         | 返回由此抽象路径名表示的文件或目录的名称          |
  | public   File[] listFiles()       | 返回此抽象路径名表示的目录中的文件和目录的File对象数组 |

- 示例代码

  ```java
  public class FileDemo04 {
      public static void main(String[] args) {
          //创建一个File对象
          File f = new File("myFile\\java.txt");

  //        public boolean isDirectory()：测试此抽象路径名表示的File是否为目录
  //        public boolean isFile()：测试此抽象路径名表示的File是否为文件
  //        public boolean exists()：测试此抽象路径名表示的File是否存在
          System.out.println(f.isDirectory());
          System.out.println(f.isFile());
          System.out.println(f.exists());

  //        public String getAbsolutePath()：返回此抽象路径名的绝对路径名字符串
  //        public String getPath()：将此抽象路径名转换为路径名字符串
  //        public String getName()：返回由此抽象路径名表示的文件或目录的名称
          System.out.println(f.getAbsolutePath());
          System.out.println(f.getPath());
          System.out.println(f.getName());
          System.out.println("--------");

  //        public File[] listFiles()：返回此抽象路径名表示的目录中的文件和目录的File对象数组
          File f2 = new File("E:\\itcast");
          File[] fileArray = f2.listFiles();
          for(File file : fileArray) {
  //            System.out.println(file);
  //            System.out.println(file.getName());
              if(file.isFile()) {
                  System.out.println(file.getName());
              }
          }
      }
  }
  ```

### hhh.6File类练习一【应用】

+ 案例需求

   在当前模块下的aaa文件夹中创建一个a.txt文件

+ 实现步骤

  + 创建File对象,指向aaa文件夹
  + 判断aaa文件夹是否存在,如果不存在则创建
  + 创建File对象,指向aaa文件夹下的a.txt文件
  + 创建这个文件

+ 代码实现

  ```java
  public class Test1 {
      public static void main(String[] args) throws IOException {
          //练习一：在当前模块下的aaa文件夹中创建一个a.txt文件
         /* File file = new File("filemodule\\aaa\\a.txt");
          file.createNewFile();*/
          //注意点:文件所在的文件夹必须要存在.

        	//hhh.创建File对象,指向aaa文件夹
          File file = new File("filemodule\\aaa");
        	//2.判断aaa文件夹是否存在,如果不存在则创建
          if(!file.exists()){
              //如果文件夹不存在,就创建出来
              file.mkdirs();
          }
        	//3.创建File对象,指向aaa文件夹下的a.txt文件
          File newFile = new File(file,"a.txt");
        	//4.创建这个文件
          newFile.createNewFile();
      }
  }
  ```

### hhh.7File类练习二【应用】

+ 案例需求

  删除一个多级文件夹

+ 实现步骤

  + 定义一个方法,接收一个File对象
  + 遍历这个File对象,获取它下边的每个文件和文件夹对象
  + 判断当前遍历到的File对象是文件还是文件夹
  + 如果是文件,直接删除
  + 如果是文件夹,递归调用自己,将当前遍历到的File对象当做参数传递
  + 参数传递过来的文件夹File对象已经处理完成,最后直接删除这个空文件夹

+ 代码实现

  ```java
  public class Test2 {
      public static void main(String[] args) {
          //练习二：删除一个多级文件夹
          //delete方法
          //只能删除文件和空文件夹.
          //如果现在要删除一个有内容的文件夹?
          //先删掉这个文件夹里面所有的内容.
          //最后再删除这个文件夹

          File src = new File("C:\\Users\\apple\\Desktop\\src");
          deleteDir(src);
      }

  	//hhh.定义一个方法,接收一个File对象
      private static void deleteDir(File src) {
          //先删掉这个文件夹里面所有的内容.
          //递归 方法在方法体中自己调用自己.
          //注意: 可以解决所有文件夹和递归相结合的题目
          //2.遍历这个File对象,获取它下边的每个文件和文件夹对象
          File[] files = src.listFiles();
          //3.判断当前遍历到的File对象是文件还是文件夹
          for (File file : files) {
              //4.如果是文件,直接删除
              if(file.isFile()){
                  file.delete();
              }else{
                  //5.如果是文件夹,递归调用自己,将当前遍历到的File对象当做参数传递
                  deleteDir(file);//参数一定要是src文件夹里面的文件夹File对象
              }
          }
          //6.参数传递过来的文件夹File对象已经处理完成,最后直接删除这个空文件夹
          src.delete();
      }

  }
  ```

### hhh.8File类练习三【应用】

+ 案例需求

  统计一个文件夹中每种文件的个数并打印

  打印格式如下：

    			txt:3个

    			doc:4个

    			jpg:6个

   			 …

+ 实现步骤

  + 定义一个方法,参数是HashMap集合用来统计次数和File对象要统计的文件夹
  + 遍历File对象,获取它下边的每一个文件和文件夹对象
  + 判断当前File对象是文件还是文件夹
  + 如果是文件,判断这种类型文件后缀名在HashMap集合中是否出现过
    + 没出现过,将这种类型文件的后缀名存入集合中,次数存1
    + 出现过,获取这种类型文件的后缀名出现的次数,对其+hhh,在存回集合中
  + 如果是文件夹,递归调用自己,HashMap集合就是参数集合,File对象是当前文件夹对象

+ 代码实现

  ```java
  public class Test3 {
      public static void main(String[] args) {
          //统计一个文件夹中,每种文件出现的次数.
          //统计 --- 定义一个变量用来统计. ---- 弊端:同时只能统计一种文件
          //利用map集合进行数据统计,键 --- 文件后缀名  值 ----  次数

          File file = new File("filemodule");
          HashMap<String, Integer> hm = new HashMap<>();
          getCount(hm, file);
          System.out.println(hm);
      }

  	//hhh.定义一个方法,参数是HashMap集合用来统计次数和File对象要统计的文件夹
      private static void getCount(HashMap<String, Integer> hm, File file) {
        	//2.遍历File对象,获取它下边的每一个文件和文件夹对象
          File[] files = file.listFiles();
          for (File f : files) {
            	//3.判断当前File对象是文件还是文件夹
              if(f.isFile()){
                	//如果是文件,判断这种类型文件后缀名在HashMap集合中是否出现过
                  String fileName = f.getName();
                  String[] fileNameArr = fileName.split("\\.");
                  if(fileNameArr.length == 2){
                      String fileEndName = fileNameArr[hhh];
                      if(hm.containsKey(fileEndName)){
                          //出现过,获取这种类型文件的后缀名出现的次数,对其+hhh,在存回集合中
                          Integer count = hm.get(fileEndName);
                          //这种文件又出现了一次.
                          count++;
                          //把已经出现的次数给覆盖掉.
                          hm.put(fileEndName,count);
                      }else{
                          // 没出现过,将这种类型文件的后缀名存入集合中,次数存1
                          hm.put(fileEndName,hhh);
                      }
                  }
              }else{
                //如果是文件夹,递归调用自己,HashMap集合就是参数集合,File对象是当前文件夹对象代码实现
                  getCount(hm,f);
              }
          }
      }

  }
  ```

## 2.字节流

### 2.hhh IO流概述和分类【理解】

- IO流介绍
  - IO：输入/输出(Input/Output)
  - 流：是一种抽象概念,是对数据传输的总称.也就是说数据在设备间的传输称为流,流的本质是数据传输
  - IO流就是用来处理设备间数据传输问题的.常见的应用: 文件复制; 文件上传; 文件下载
- IO流的分类
  - 按照数据的流向
    - 输入流：读数据
    - 输出流：写数据
  - 按照数据类型来分
    - 字节流
      - 字节输入流
      - 字节输出流
    - 字符流
      - 字符输入流
      - 字符输出流
- IO流的使用场景
  - 如果操作的是纯文本文件,优先使用字符流
  - 如果操作的是图片、视频、音频等二进制文件,优先使用字节流
  - 如果不确定文件类型,优先使用字节流.字节流是万能的流

### 2.2字节流写数据【应用】

- 字节流抽象基类

  - InputStream：这个抽象类是表示字节输入流的所有类的超类
  - OutputStream：这个抽象类是表示字节输出流的所有类的超类
  - 子类名特点：子类名称都是以其父类名作为子类名的后缀

- 字节输出流

  - FileOutputStream(String name)：创建文件输出流以指定的名称写入文件

- 使用字节输出流写数据的步骤

  - 创建字节输出流对象(调用系统功能创建了文件,创建字节输出流对象,让字节输出流对象指向文件)
  - 调用字节输出流对象的写数据方法
  - 释放资源(关闭此文件输出流并释放与此流相关联的任何系统资源)

- 示例代码

  ```java
  public class FileOutputStreamDemo01 {
      public static void main(String[] args) throws IOException {
          //创建字节输出流对象
        	/*
        		注意点:
        				hhh.如果文件不存在,会帮我们创建
        				2.如果文件存在,会把文件清空
        	*/
        	//FileOutputStream(String name)：创建文件输出流以指定的名称写入文件
          FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt");

          //void write(int b)：将指定的字节写入此文件输出流
          fos.write(97);
  //        fos.write(57);
  //        fos.write(55);

          //最后都要释放资源
          //void close()：关闭此文件输出流并释放与此流相关联的任何系统资源。
          fos.close();
      }
  }
  ```

### 2.3字节流写数据的三种方式【应用】

- 写数据的方法分类

  | 方法名                                      | 说明                                       |
  | ---------------------------------------- | ---------------------------------------- |
  | void   write(int b)                      | 将指定的字节写入此文件输出流   一次写一个字节数据               |
  | void   write(byte[] b)                   | 将 b.length字节从指定的字节数组写入此文件输出流   一次写一个字节数组数据 |
  | void   write(byte[] b, int off, int len) | 将 len字节从指定的字节数组开始，从偏移量off开始写入此文件输出流   一次写一个字节数组的部分数据 |

- 示例代码

  ```java
  public class FileOutputStreamDemo02 {
      public static void main(String[] args) throws IOException {
          //FileOutputStream(String name)：创建文件输出流以指定的名称写入文件
          FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt");
          //FileOutputStream(File file)：创建文件输出流以写入由指定的 File对象表示的文件
  //        FileOutputStream fos = new FileOutputStream(new File("myByteStream\\fos.txt"));

          //void write(int b)：将指定的字节写入此文件输出流
  //        fos.write(97);
  //        fos.write(98);
  //        fos.write(99);
  //        fos.write(100);
  //        fos.write(101);

  //        void write(byte[] b)：将 b.length字节从指定的字节数组写入此文件输出流
  //        byte[] bys = {97, 98, 99, 100, 101};
          //byte[] getBytes()：返回字符串对应的字节数组
          byte[] bys = "abcde".getBytes();
  //        fos.write(bys);

          //void write(byte[] b, int off, int len)：将 len字节从指定的字节数组开始，从偏移量off开始写入此文件输出流
  //        fos.write(bys,0,bys.length);
          fos.write(bys,hhh,3);

          //释放资源
          fos.close();
      }
  }
  ```

### 2.4字节流写数据的两个小问题【应用】

- 字节流写数据如何实现换行

  - windows:\r\n
  - linux:\n
  - mac:\r

- 字节流写数据如何实现追加写入

  - public FileOutputStream(String name,boolean append)
  - 创建文件输出流以指定的名称写入文件。如果第二个参数为true ，则字节将写入文件的末尾而不是开头

- 示例代码

  ```java
  public class FileOutputStreamDemo03 {
      public static void main(String[] args) throws IOException {
          //创建字节输出流对象
  //        FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt");
          FileOutputStream fos = new FileOutputStream("myByteStream\\fos.txt",true);

          //写数据
          for (int i = 0; i < 10; i++) {
              fos.write("hello".getBytes());
              fos.write("\r\n".getBytes());
          }

          //释放资源
          fos.close();
      }
  }
  ```

### 2.5字节流写数据加异常处理【应用】

- 异常处理格式

  - try-catch-finally

    ```java
    try{
    	可能出现异常的代码;
    }catch(异常类名 变量名){
    	异常的处理代码;
    }finally{
    	执行所有清除操作;
    }
    ```

  - finally特点

    - 被finally控制的语句一定会执行，除非JVM退出

- 示例代码

  ```java
  public class FileOutputStreamDemo04 {
      public static void main(String[] args) {
          //加入finally来实现释放资源
          FileOutputStream fos = null;
          try {
              fos = new FileOutputStream("myByteStream\\fos.txt");
              fos.write("hello".getBytes());
          } catch (IOException e) {
              e.printStackTrace();
          } finally {
              if(fos != null) {
                  try {
                      fos.close();
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
              }
          }
      }
  }
  ```

### 2.6字节流读数据(一次读一个字节数据)【应用】

- 字节输入流

  - FileInputStream(String name)：通过打开与实际文件的连接来创建一个FileInputStream,该文件由文件系统中的路径名name命名

- 字节输入流读取数据的步骤

  - 创建字节输入流对象
  - 调用字节输入流对象的读数据方法
  - 释放资源

- 示例代码

  ```java
  public class FileInputStreamDemo01 {
      public static void main(String[] args) throws IOException {
          //创建字节输入流对象
          //FileInputStream(String name)
          FileInputStream fis = new FileInputStream("myByteStream\\fos.txt");

          int by;
          /*
              fis.read()：读数据
              by=fis.read()：把读取到的数据赋值给by
              by != -hhh：判断读取到的数据是否是-hhh
           */
          while ((by=fis.read())!=-hhh) {
              System.out.print((char)by);
          }

          //释放资源
          fis.close();
      }
  }
  ```

### 2.7字节流复制文件【应用】

- 案例需求

  ​	把“E:\\itcast\\窗里窗外.txt”复制到模块目录下的“窗里窗外.txt”   (文件可以是任意文件)

- 实现步骤

  - 复制文本文件，其实就把文本文件的内容从一个文件中读取出来(数据源)，然后写入到另一个文件中(目的地)

  - 数据源：

    ​	E:\\itcast\\窗里窗外.txt --- 读数据 --- InputStream --- FileInputStream

  - 目的地：

    ​	myByteStream\\窗里窗外.txt --- 写数据 --- OutputStream --- FileOutputStream

- 代码实现

  ```java
  public class CopyTxtDemo {
      public static void main(String[] args) throws IOException {
          //根据数据源创建字节输入流对象
          FileInputStream fis = new FileInputStream("E:\\itcast\\窗里窗外.txt");
          //根据目的地创建字节输出流对象
          FileOutputStream fos = new FileOutputStream("myByteStream\\窗里窗外.txt");

          //读写数据，复制文本文件(一次读取一个字节，一次写入一个字节)
          int by;
          while ((by=fis.read())!=-hhh) {
              fos.write(by);
          }

          //释放资源
          fos.close();
          fis.close();
      }
  }
  ```

### 2.8字节流读数据(一次读一个字节数组数据)【应用】

- 一次读一个字节数组的方法

  - public int read(byte[] b)：从输入流读取最多b.length个字节的数据
  - 返回的是读入缓冲区的总字节数,也就是实际的读取字节个数

- 示例代码

  ```java
  public class FileInputStreamDemo02 {
      public static void main(String[] args) throws IOException {
          //创建字节输入流对象
          FileInputStream fis = new FileInputStream("myByteStream\\fos.txt");

          byte[] bys = new byte[1024]; //1024及其整数倍
          int len;
        	//循环读取
          while ((len=fis.read(bys))!=-hhh) {
              System.out.print(new String(bys,0,len));
          }

          //释放资源
          fis.close();
      }
  }
  ```

### 2.9字节流复制文件【应用】

- 案例需求

  ​	把“E:\\itcast\\mn.jpg”复制到模块目录下的“mn.jpg”  (文件可以是任意文件去)

- 实现步骤

  - 根据数据源创建字节输入流对象
  - 根据目的地创建字节输出流对象
  - 读写数据，复制图片(一次读取一个字节数组，一次写入一个字节数组)
  - 释放资源

- 代码实现

  ```java
  public class CopyJpgDemo {
      public static void main(String[] args) throws IOException {
          //根据数据源创建字节输入流对象
          FileInputStream fis = new FileInputStream("E:\\itcast\\mn.jpg");
          //根据目的地创建字节输出流对象
          FileOutputStream fos = new FileOutputStream("myByteStream\\mn.jpg");

          //读写数据，复制图片(一次读取一个字节数组，一次写入一个字节数组)
          byte[] bys = new byte[1024];
          int len;
          while ((len=fis.read(bys))!=-hhh) {
              fos.write(bys,0,len);
          }

          //释放资源
          fos.close();
          fis.close();
      }
  }
  ```

## 3.字节缓冲流

### 3.1字节缓冲流构造方法【应用】

- 字节缓冲流介绍

  - lBufferOutputStream：该类实现缓冲输出流.通过设置这样的输出流,应用程序可以向底层输出流写入字节,而不必为写入的每个字节导致底层系统的调用
  - lBufferedInputStream：创建BufferedInputStream将创建一个内部缓冲区数组.当从流中读取或跳过字节时,内部缓冲区将根据需要从所包含的输入流中重新填充,一次很多字节

- 构造方法：

  | 方法名                                    | 说明          |
  | -------------------------------------- | ----------- |
  | BufferedOutputStream(OutputStream out) | 创建字节缓冲输出流对象 |
  | BufferedInputStream(InputStream in)    | 创建字节缓冲输入流对象 |

- 示例代码

  ```java
  public class BufferStreamDemo {
      public static void main(String[] args) throws IOException {
          //字节缓冲输出流：BufferedOutputStream(OutputStream out)

          BufferedOutputStream bos = new BufferedOutputStream(new 				                                       FileOutputStream("myByteStream\\bos.txt"));
          //写数据
          bos.write("hello\r\n".getBytes());
          bos.write("world\r\n".getBytes());
          //释放资源
          bos.close();
  ```


          //字节缓冲输入流：BufferedInputStream(InputStream in)
          BufferedInputStream bis = new BufferedInputStream(new                                                          FileInputStream("myByteStream\\bos.txt"));
    
          //一次读取一个字节数据
  //        int by;
  //        while ((by=bis.read())!=-hhh) {
  //            System.out.print((char)by);
  //        }

          //一次读取一个字节数组数据
          byte[] bys = new byte[1024];
          int len;
          while ((len=bis.read(bys))!=-hhh) {
              System.out.print(new String(bys,0,len));
          }
    
          //释放资源
          bis.close();
      }
  }
  ```

### 3.2字节缓冲流复制视频【应用】

- 案例需求

  把“E:\\itcast\\字节流复制图片.avi”复制到模块目录下的“字节流复制图片.avi”

- 实现步骤

  - 根据数据源创建字节输入流对象
  - 根据目的地创建字节输出流对象
  - 读写数据，复制视频
  - 释放资源

- 代码实现

  ```java
  public class CopyAviDemo {
      public static void main(String[] args) throws IOException {

          //复制视频
  //        method1();
        	 method2();

      }

      //字节缓冲流一次读写一个字节数组
      public static void method2() throws IOException {
          BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\itcast\\字节流复制图片.avi"));
          BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myByteStream\\字节流复制图片.avi"));

          byte[] bys = new byte[1024];
          int len;
          while ((len=bis.read(bys))!=-hhh) {
              bos.write(bys,0,len);
          }

          bos.close();
          bis.close();
      }

      //字节缓冲流一次读写一个字节
      public static void method1() throws IOException {
          BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\itcast\\字节流复制图片.avi"));
          BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("myByteStream\\字节流复制图片.avi"));

          int by;
          while ((by=bis.read())!=-hhh) {
              bos.write(by);
          }

          bos.close();
          bis.close();
      }

  }
  ```




# day13-IO流

## hhh.字符流

### hhh.1为什么会出现字符流【理解】

- 字符流的介绍

  由于字节流操作中文不是特别的方便，所以Java就提供字符流

  字符流 = 字节流 + 编码表

- 中文的字节存储方式

  用字节流复制文本文件时，文本文件也会有中文，但是没有问题，原因是最终底层操作会自动进行字节拼接成中文，如何识别是中文的呢？

  汉字在存储的时候，无论选择哪种编码存储，第一个字节都是负数

### hhh.2编码表【理解】

- 什么是字符集

  是一个系统支持的所有字符的集合，包括各国家文字、标点符号、图形符号、数字等

  l计算机要准确的存储和识别各种字符集符号，就需要进行字符编码，一套字符集必然至少有一套字符编码。常见字符集有ASCII字符集、GBXXX字符集、Unicode字符集等

- 常见的字符集

  - ASCII字符集：

    lASCII：是基于拉丁字母的一套电脑编码系统，用于显示现代英语，主要包括控制字符(回车键、退格、换行键等)和可显示字符(英文大小写字符、阿拉伯数字和西文符号)

    基本的ASCII字符集，使用7位表示一个字符，共128字符。ASCII的扩展字符集使用8位表示一个字符，共256字符，方便支持欧洲常用字符。是一个系统支持的所有字符的集合，包括各国家文字、标点符号、图形符号、数字等

  - GBXXX字符集：

    GBK：最常用的中文码表。是在GB2312标准基础上的扩展规范，使用了双字节编码方案，共收录了21003个汉字，完全兼容GB2312标准，同时支持繁体汉字以及日韩汉字等

  - Unicode字符集：

    UTF-8编码：可以用来表示Unicode标准中任意字符，它是电子邮件、网页及其他存储或传送文字的应用 中，优先采用的编码。互联网工程工作小组（IETF）要求所有互联网协议都必须支持UTF-8编码。它使用一至四个字节为每个字符编码

    编码规则：

      128个US-ASCII字符，只需一个字节编码

      拉丁文等字符，需要二个字节编码

      大部分常用字（含中文），使用三个字节编码

      其他极少使用的Unicode辅助字符，使用四字节编码

### hhh.3字符串中的编码解码问题【应用】

- 相关方法

  | 方法名                                      | 说明                          |
  | ---------------------------------------- | --------------------------- |
  | byte[] getBytes()                        | 使用平台的默认字符集将该 String编码为一系列字节 |
  | byte[] getBytes(String charsetName)      | 使用指定的字符集将该 String编码为一系列字节   |
  | String(byte[] bytes)                     | 使用平台的默认字符集解码指定的字节数组来创建字符串   |
  | String(byte[] bytes, String charsetName) | 通过指定的字符集解码指定的字节数组来创建字符串     |

- 代码演示

  ```java
  public class StringDemo {
      public static void main(String[] args) throws UnsupportedEncodingException {
          //定义一个字符串
          String s = "中国";

          //byte[] bys = s.getBytes(); //[-28, -72, -83, -27, -101, -67]
          //byte[] bys = s.getBytes("UTF-8"); //[-28, -72, -83, -27, -101, -67]
          byte[] bys = s.getBytes("GBK"); //[-42, -48, -71, -6]
          System.out.println(Arrays.toString(bys));

          //String ss = new String(bys);
          //String ss = new String(bys,"UTF-8");
          String ss = new String(bys,"GBK");
          System.out.println(ss);
      }
  }
  ```

### hhh.4字符流写数据【应用】

- 介绍

  Writer: 用于写入字符流的抽象父类

  FileWriter: 用于写入字符流的常用子类


- 构造方法

  | 方法名                                      | 说明                                       |
  | ---------------------------------------- | ---------------------------------------- |
  | FileWriter(File file)                    | 根据给定的 File 对象构造一个 FileWriter 对象          |
  | FileWriter(File file, boolean append)    | 根据给定的 File 对象构造一个 FileWriter 对象          |
  | FileWriter(String fileName)              | 根据给定的文件名构造一个 FileWriter 对象               |
  | FileWriter(String fileName, boolean append) | 根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象 |


- 成员方法

  | 方法名                                      | 说明         |
  | ---------------------------------------- | ---------- |
  | void   write(int c)                      | 写一个字符      |
  | void   write(char[] cbuf)                | 写入一个字符数组   |
  | void write(char[] cbuf, int off, int len) | 写入字符数组的一部分 |
  | void write(String str)                   | 写一个字符串     |
  | void write(String str, int off, int len) | 写一个字符串的一部分 |

- 刷新和关闭的方法

  | 方法名     | 说明                                 |
  | ------- | ---------------------------------- |
  | flush() | 刷新流，之后还可以继续写数据                     |
  | close() | 关闭流，释放资源，但是在关闭之前会先刷新流。一旦关闭，就不能再写数据 |

- 代码演示

  ```java
  public class OutputStreamWriterDemo {
      public static void main(String[] args) throws IOException {
          FileWriter fw = new FileWriter("myCharStream\\a.txt");

          //void write(int c)：写一个字符
  //        fw.write(97);
  //        fw.write(98);
  //        fw.write(99);

          //void writ(char[] cbuf)：写入一个字符数组
          char[] chs = {'a', 'b', 'c', 'd', 'e'};
  //        fw.write(chs);

          //void write(char[] cbuf, int off, int len)：写入字符数组的一部分
  //        fw.write(chs, 0, chs.length);
  //        fw.write(chs, hhh, 3);

          //void write(String str)：写一个字符串
  //        fw.write("abcde");

          //void write(String str, int off, int len)：写一个字符串的一部分
  //        fw.write("abcde", 0, "abcde".length());
          fw.write("abcde", hhh, 3);

          //释放资源
          fw.close();
      }
  }
  ```

### hhh.5字符流读数据【应用】

+ 介绍

  Reader: 用于读取字符流的抽象父类

  FileReader: 用于读取字符流的常用子类


+ 构造方法

  | 方法名                         | 说明                                   |
  | --------------------------- | ------------------------------------ |
  | FileReader(File file)       | 在给定从中读取数据的 File 的情况下创建一个新 FileReader |
  | FileReader(String fileName) | 在给定从中读取数据的文件名的情况下创建一个新 FileReader    |

- 成员方法

  | 方法名                   | 说明          |
  | --------------------- | ----------- |
  | int read()            | 一次读一个字符数据   |
  | int read(char[] cbuf) | 一次读一个字符数组数据 |

- 代码演示

  ```java
  public class InputStreamReaderDemo {
      public static void main(String[] args) throws IOException {

          FileReader fr = new FileReader("myCharStream\\b.txt");

          //int read()：一次读一个字符数据
  //        int ch;
  //        while ((ch=fr.read())!=-hhh) {
  //            System.out.print((char)ch);
  //        }

          //int read(char[] cbuf)：一次读一个字符数组数据
          char[] chs = new char[1024];
          int len;
          while ((len = fr.read(chs)) != -hhh) {
              System.out.print(new String(chs, 0, len));
          }

          //释放资源
          fr.close();
      }
  }
  ```

### hhh.6字符流用户注册案例【应用】

- 案例需求

  将键盘录入的用户名和密码保存到本地实现永久化存储

- 实现步骤
  - 获取用户输入的用户名和密码
  - 将用户输入的用户名和密码写入到本地文件中
  - 关流,释放资源

- 代码实现

  ```java
  public class CharStreamDemo8 {
      public static void main(String[] args) throws IOException {
          //需求: 将键盘录入的用户名和密码保存到本地实现永久化存储
          //要求：用户名独占一行，密码独占一行

          //分析：
          //hhh，实现键盘录入，把用户名和密码录入进来
          Scanner sc = new Scanner(System.in);
          System.out.println("请录入用户名");
          String username = sc.next();
          System.out.println("请录入密码");
          String password = sc.next();

          //2.分别把用户名和密码写到本地文件。
          FileWriter fw = new FileWriter("charstream\\a.txt");
          //将用户名和密码写到文件中
          fw.write(username);
          //表示写出一个回车换行符 windows \r\n  MacOS \r  Linux \n
          fw.write("\r\n");
          fw.write(password);
          //刷新流
          fw.flush();
          //3.关流,释放资源
          fw.close();
      }
  }
  ```

### hhh.7字符缓冲流【应用】

- 字符缓冲流介绍

  - BufferedWriter：将文本写入字符输出流，缓冲字符，以提供单个字符，数组和字符串的高效写入，可以指定缓冲区大小，或者可以接受默认大小。默认值足够大，可用于大多数用途

  - BufferedReader：从字符输入流读取文本，缓冲字符，以提供字符，数组和行的高效读取，可以指定缓冲区大小，或者可以使用默认大小。 默认值足够大，可用于大多数用途

- 构造方法

  | 方法名                        | 说明          |
  | -------------------------- | ----------- |
  | BufferedWriter(Writer out) | 创建字符缓冲输出流对象 |
  | BufferedReader(Reader in)  | 创建字符缓冲输入流对象 |

- 代码演示

  ```java
  public class BufferedStreamDemo01 {
      public static void main(String[] args) throws IOException {
          //BufferedWriter(Writer out)
          BufferedWriter bw = new BufferedWriter(new                                                            FileWriter("myCharStream\\bw.txt"));
          bw.write("hello\r\n");
          bw.write("world\r\n");
          bw.close();

          //BufferedReader(Reader in)
          BufferedReader br = new BufferedReader(new                                                           FileReader("myCharStream\\bw.txt"));

          //一次读取一个字符数据
  //        int ch;
  //        while ((ch=br.read())!=-hhh) {
  //            System.out.print((char)ch);
  //        }

          //一次读取一个字符数组数据
          char[] chs = new char[1024];
          int len;
          while ((len=br.read(chs))!=-hhh) {
              System.out.print(new String(chs,0,len));
          }

          br.close();
      }
  }
  ```

### hhh.8字符缓冲流特有功能【应用】

- 方法介绍

  BufferedWriter：

  | 方法名            | 说明                     |
  | -------------- | ---------------------- |
  | void newLine() | 写一行行分隔符，行分隔符字符串由系统属性定义 |

  BufferedReader:

  | 方法名               | 说明                                       |
  | ----------------- | ---------------------------------------- |
  | String readLine() | 读一行文字。 结果包含行的内容的字符串，不包括任何行终止字符如果流的结尾已经到达，则为null |

- 代码演示

  ```java
  public class BufferedStreamDemo02 {
      public static void main(String[] args) throws IOException {

          //创建字符缓冲输出流
          BufferedWriter bw = new BufferedWriter(new                                                          FileWriter("myCharStream\\bw.txt"));

          //写数据
          for (int i = 0; i < 10; i++) {
              bw.write("hello" + i);
              //bw.write("\r\n");
              bw.newLine();
              bw.flush();
          }

          //释放资源
          bw.close();

          //创建字符缓冲输入流
          BufferedReader br = new BufferedReader(new                                                          FileReader("myCharStream\\bw.txt"));

          String line;
          while ((line=br.readLine())!=null) {
              System.out.println(line);
          }

          br.close();
      }
  }
  ```

### hhh.9字符缓冲流操作文件中数据排序案例【应用】

- 案例需求

  使用字符缓冲流读取文件中的数据，排序后再次写到本地文件

- 实现步骤

  - 将文件中的数据读取到程序中
  - 对读取到的数据进行处理
  - 将处理后的数据添加到集合中
  - 对集合中的数据进行排序
  - 将排序后的集合中的数据写入到文件中

- 代码实现

  ```java
  public class CharStreamDemo14 {
      public static void main(String[] args) throws IOException {
          //需求：读取文件中的数据，排序后再次写到本地文件
          //分析：
          //hhh.要把文件中的数据读取进来。
          BufferedReader br = new BufferedReader(new FileReader("charstream\\sort.txt"));
          //输出流一定不能写在这里，因为会清空文件中的内容
          //BufferedWriter bw = new BufferedWriter(new FileWriter("charstream\\sort.txt"));

          String line = br.readLine();
          System.out.println("读取到的数据为" + line);
          br.close();

          //2.按照空格进行切割
          String[] split = line.split(" ");//9 hhh 2 5 3 10 4 6 7 8
          //3.把字符串类型的数组变成int类型
          int [] arr = new int[split.length];
          //遍历split数组，可以进行类型转换。
          for (int i = 0; i < split.length; i++) {
              String smallStr = split[i];
              //类型转换
              int number = Integer.parseInt(smallStr);
              //把转换后的结果存入到arr中
              arr[i] = number;
          }
          //4.排序
          Arrays.sort(arr);
          System.out.println(Arrays.toString(arr));

          //5.把排序之后结果写回到本地 hhh 2 3 4...
          BufferedWriter bw = new BufferedWriter(new FileWriter("charstream\\sort.txt"));
          //写出
          for (int i = 0; i < arr.length; i++) {
              bw.write(arr[i] + " ");
              bw.flush();
          }
          //释放资源
          bw.close();

      }
  }
  ```

### hhh.10IO流小结【理解】

+ IO流小结

  ![01_IO流小结](.\img\01_IO流小结.png)


## 2.转换流

### 2.1字符流中和编码解码问题相关的两个类【理解】

- InputStreamReader：是从字节流到字符流的桥梁,父类是Reader

  ​	它读取字节，并使用指定的编码将其解码为字符

  ​	它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集

- OutputStreamWriter：是从字符流到字节流的桥梁,父类是Writer

  ​	是从字符流到字节流的桥梁，使用指定的编码将写入的字符编码为字节

  ​	它使用的字符集可以由名称指定，也可以被明确指定，或者可以接受平台的默认字符集

### 2.2转换流读写数据【应用】

+ 构造方法

  | 方法名                                      | 说明                              |
  | ---------------------------------------- | ------------------------------- |
  | InputStreamReader(InputStream in)        | 使用默认字符编码创建InputStreamReader对象   |
  | InputStreamReader(InputStream in,String chatset) | 使用指定的字符编码创建InputStreamReader对象  |
  | OutputStreamWriter(OutputStream out)     | 使用默认字符编码创建OutputStreamWriter对象  |
  | OutputStreamWriter(OutputStream out,String charset) | 使用指定的字符编码创建OutputStreamWriter对象 |

+ 代码演示

  ```java
  public class ConversionStreamDemo {
      public static void main(String[] args) throws IOException {
          //OutputStreamWriter osw = new OutputStreamWriter(new                                             FileOutputStream("myCharStream\\osw.txt"));
          OutputStreamWriter osw = new OutputStreamWriter(new                                              FileOutputStream("myCharStream\\osw.txt"),"GBK");
          osw.write("中国");
          osw.close();

          //InputStreamReader isr = new InputStreamReader(new 	                                         FileInputStream("myCharStream\\osw.txt"));
          InputStreamReader isr = new InputStreamReader(new                                                 FileInputStream("myCharStream\\osw.txt"),"GBK");
          //一次读取一个字符数据
          int ch;
          while ((ch=isr.read())!=-hhh) {
              System.out.print((char)ch);
          }
          isr.close();
      }
  }
  ```

## 3.对象操作流

### 3.1对象序列化流【应用】

- 对象序列化介绍

  - 对象序列化：就是将对象保存到磁盘中，或者在网络中传输对象
  - 这种机制就是使用一个字节序列表示一个对象，该字节序列包含：对象的类型、对象的数据和对象中存储的属性等信息
  - 字节序列写到文件之后，相当于文件中持久保存了一个对象的信息
  - 反之，该字节序列还可以从文件中读取回来，重构对象，对它进行反序列化

- 对象序列化流： ObjectOutputStream

  - 将Java对象的原始数据类型和图形写入OutputStream。 可以使用ObjectInputStream读取（重构）对象。 可以通过使用流的文件来实现对象的持久存储。 如果流是网络套接字流，则可以在另一个主机上或另一个进程中重构对象

- 构造方法

  | 方法名                                  | 说明                                       |
  | ------------------------------------ | ---------------------------------------- |
  | ObjectOutputStream(OutputStream out) | 创建一个写入指定的OutputStream的ObjectOutputStream |

- 序列化对象的方法

  | 方法名                          | 说明                         |
  | ---------------------------- | -------------------------- |
  | void writeObject(Object obj) | 将指定的对象写入ObjectOutputStream |

- 示例代码

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student implements Serializable {
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

  测试类

  ```java
  public class ObjectOutputStreamDemo {
      public static void main(String[] args) throws IOException {
          //ObjectOutputStream(OutputStream out)：创建一个写入指定的OutputStream的ObjectOutputStream
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myOtherStream\\oos.txt"));

          //创建对象
          Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student("佟丽娅",30);

          //void writeObject(Object obj)：将指定的对象写入ObjectOutputStream
          oos.writeObject(s);

          //释放资源
          oos.close();
      }
  }
  ```

- 注意事项

  - 一个对象要想被序列化，该对象所属的类必须必须实现Serializable 接口
  - Serializable是一个标记接口，实现该接口，不需要重写任何方法

### 3.2对象反序列化流【应用】

- 对象反序列化流： ObjectInputStream

  - ObjectInputStream反序列化先前使用ObjectOutputStream编写的原始数据和对象

- 构造方法

  | 方法名                               | 说明                                    |
  | --------------------------------- | ------------------------------------- |
  | ObjectInputStream(InputStream in) | 创建从指定的InputStream读取的ObjectInputStream |

- 反序列化对象的方法

  | 方法名                 | 说明                       |
  | ------------------- | ------------------------ |
  | Object readObject() | 从ObjectInputStream读取一个对象 |

- 示例代码

  ```java
  public class ObjectInputStreamDemo {
      public static void main(String[] args) throws IOException, ClassNotFoundException {
          //ObjectInputStream(InputStream in)：创建从指定的InputStream读取的ObjectInputStream
          ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myOtherStream\\oos.txt"));

          //Object readObject()：从ObjectInputStream读取一个对象
          Object obj = ois.readObject();

          Ebook.D5.DemoTostring.Student s = (Ebook.D5.DemoTostring.Student) obj;
          System.out.println(s.getName() + "," + s.getAge());

          ois.close();
      }
  }
  ```

### 3.3serialVersionUID&transient【应用】

- serialVersionUID

  - 用对象序列化流序列化了一个对象后，假如我们修改了对象所属的类文件，读取数据会不会出问题呢？
    - 会出问题，会抛出InvalidClassException异常
  - 如果出问题了，如何解决呢？
    - 重新序列化
    - 给对象所属的类加一个serialVersionUID
      - private static final long serialVersionUID = 42L;

- transient

  - 如果一个对象中的某个成员变量的值不想被序列化，又该如何实现呢？
    - 给该成员变量加transient关键字修饰，该关键字标记的成员变量不参与序列化过程

- 示例代码

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student implements Serializable {
      private static final long serialVersionUID = 42L;
      private String name;
  //    private int age;
      private transient int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

  //    @Override
  //    public String toString() {
  //        return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
  //                "name='" + name + '\'' +
  //                ", age=" + age +
  //                '}';
  //    }
  }
  ```

  测试类

  ```java
  public class ObjectStreamDemo {
      public static void main(String[] args) throws IOException, ClassNotFoundException {
  //        write();
          read();
      }

      //反序列化
      private static void read() throws IOException, ClassNotFoundException {
          ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myOtherStream\\oos.txt"));
          Object obj = ois.readObject();
          Ebook.D5.DemoTostring.Student s = (Ebook.D5.DemoTostring.Student) obj;
          System.out.println(s.getName() + "," + s.getAge());
          ois.close();
      }

      //序列化
      private static void write() throws IOException {
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myOtherStream\\oos.txt"));
          Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student("佟丽娅", 30);
          oos.writeObject(s);
          oos.close();
      }
  }
  ```

### 3.4对象操作流练习【应用】

- 案例需求

  创建多个学生类对象写到文件中,再次读取到内存中

- 实现步骤

  - 创建序列化流对象
  - 创建多个学生对象
  - 将学生对象添加到集合中
  - 将集合对象序列化到文件中
  - 创建反序列化流对象
  - 将文件中的对象数据,读取到内存中

- 代码实现

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student implements Serializable{

      private static final long serialVersionUID = 2L;

      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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
  }
  ```

  测试类

  ```java
  public class Demo03 {
      /**
       *  read():
       *      读取到文件末尾返回值是 -hhh
       *  readLine():
       *      读取到文件的末尾返回值 null
       *  readObject():
       *      读取到文件的末尾 直接抛出异常
       *  如果要序列化的对象有多个,不建议直接将多个对象序列化到文件中,因为反序列化时容易出异常
       *      建议: 将要序列化的多个对象存储到集合中,然后将集合序列化到文件中
       */
      public static void main(String[] args) throws Exception {
          /*// 序列化
          //hhh.创建序列化流对象
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myCode\\oos.txt"));
          ArrayList<Ebook.D5.DemoTostring.Student> arrayList = new ArrayLiTest.D19.Ebook.D5.DemoTostring.Student
          //2.创建多个学生对象
          Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student("佟丽娅",30);
   Test22.D19.StudentStudent sTest.D19.Studentw Ebook.D5.DemoTostring.Student("佟丽娅",30);
   Test22.D19.Ebook.D5.DemoTostring.Student//3.将学生对象添加Test.D19.Ebook.D5.DemoTostring.Student        arrayList.add(s);
          arrayList.add(s01);
          //4.将集合对象序列化到文件中
          oos.writeObject(arrayList);
          oos.close();*/

          // 反序列化
        	//5.创建反序列化流对象
          ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myCode\\oos.txt"));
        	//6.将文件中的对象数据,读取到内存中
          Object obj = ois.readObject();
          ArrayList<Ebook.D5.DemoTostring.Student> arrayList = (ArrayList<Ebook.D5.DemoTostring.Student>)obj;
          ois.close();
          for (Ebook.D5.DemoTostring.Student s : arrayList) {
              System.out.println(s.getName() + "," + s.getAge());
          }
      }
  }
  ```

## 4.Properties集合

### 4.1Properties作为Map集合的使用【应用】

- Properties介绍

  - 是一个Map体系的集合类
  - Properties可以保存到流中或从流中加载
  - 属性列表中的每个键及其对应的值都是一个字符串

- Properties基本使用

  ```java
  public class PropertiesDemo01 {
      public static void main(String[] args) {
          //创建集合对象
  //        Properties<String,String> prop = new Properties<String,String>(); //错误
          Properties prop = new Properties();

          //存储元素
          prop.put("itheima001", "佟丽娅");
          prop.put("itheima002", "赵丽颖");
          prop.put("itheima003", "刘诗诗");

          //遍历集合
          Set<Object> keySet = prop.keySet();
          for (Object key : keySet) {
              Object value = prop.get(key);
              System.out.println(key + "," + value);
          }
      }
  }
  ```

### 4.2Properties作为Map集合的特有方法【应用】

- 特有方法

  | 方法名                                      | 说明                                       |
  | ---------------------------------------- | ---------------------------------------- |
  | Object   setProperty(String key, String value) | 设置集合的键和值，都是String类型，底层调用   Hashtable方法 put |
  | String   getProperty(String key)         | 使用此属性列表中指定的键搜索属性                         |
  | Set<String>   stringPropertyNames()      | 从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串         |

- 示例代码

  ```java
  public class PropertiesDemo02 {
      public static void main(String[] args) {
          //创建集合对象
          Properties prop = new Properties();

          //Object setProperty(String key, String value)：设置集合的键和值，都是String类型
          prop.setProperty("itheima001", "佟丽娅");
          prop.setProperty("itheima002", "赵丽颖");
          prop.setProperty("itheima003", "刘诗诗");

          //String getProperty(String key)：使用此属性列表中指定的键搜索属性
  //        System.out.println(prop.getProperty("itheima001"));
  //        System.out.println(prop.getProperty("itheima0011"));

  //        System.out.println(prop);

          //Set<String> stringPropertyNames()：从该属性列表中返回一个不可修改的键集，其中键及其对应的值是字符串
          Set<String> names = prop.stringPropertyNames();
          for (String key : names) {
  //            System.out.println(key);
              String value = prop.getProperty(key);
              System.out.println(key + "," + value);
          }
      }
  }
  ```

### 4.3Properties和IO流相结合的方法【应用】

- 和IO流结合的方法

  | 方法名                                      | 说明                                       |
  | ---------------------------------------- | ---------------------------------------- |
  | void   load(Reader reader)               | 从输入字符流读取属性列表（键和元素对）                      |
  | void   store(Writer writer, String comments) | 将此属性列表（键和元素对）写入此   Properties表中，以适合使用   load(Reader)方法的格式写入输出字符流 |

- 示例代码

  ```java
  public class PropertiesDemo03 {
      public static void main(String[] args) throws IOException {
          //把集合中的数据保存到文件
  //        myStore();

          //把文件中的数据加载到集合
          myLoad();

      }

      private static void myLoad() throws IOException {
          Properties prop = new Properties();

          //void load(Reader reader)：
          FileReader fr = new FileReader("myOtherStream\\fw.txt");
          prop.load(fr);
          fr.close();

          System.out.println(prop);
      }

      private static void myStore() throws IOException {
          Properties prop = new Properties();

          prop.setProperty("itheima001","佟丽娅");
          prop.setProperty("itheima002","赵丽颖");
          prop.setProperty("itheima003","刘诗诗");

          //void store(Writer writer, String comments)：
          FileWriter fw = new FileWriter("myOtherStream\\fw.txt");
          prop.store(fw,null);
          fw.close();
      }
  }
  ```

### 4.4Properties集合练习【应用】

- 案例需求

  在Properties文件中手动写上姓名和年龄,读取到集合中,将该数据封装成学生对象,写到本地文件

- 实现步骤

  - 创建Properties集合,将本地文件中的数据加载到集合中
  - 获取集合中的键值对数据,封装到学生对象中
  - 创建序列化流对象,将学生对象序列化到本地文件中

- 代码实现

  学生类

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student implements Serializable {
      private static final long serialVersionUID = 1L;

      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  ```

  测试类

  ```java
  import Test22.D19.Ebook.D5.DemoTostring.Student;public class Test22 {
  
    public static void main(String[] args) throws IOException {
        	//hhh.创建Properties集合,将本地文件中的数据加载到集合中
          Properties prop = new Properties();
          FileReader fr = new FileReader("prop.properties");
          prop.load(fr);
          fr.close();
  		//2.获取集合中的键值对数据,封装到学生对象中
          String name = prop.getProperty("name");
          int age = Integer.parseInt(prop.getProperty("age"));
          Ebook.D5.DemoTostring.Student s = new Ebook.D5.DemoTostring.Student(name,age);
  		//3.创建序列化流对象,将学生对象序列化到本地文件中
          ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
          oos.writeObject(s);
          oos.close();
      }
  }
  ```




# day14-多线程01

## hhh.实现多线程

### hhh.1简单了解多线程【理解】

是指从软件或者硬件上实现多个线程并发执行的技术。
具有多线程能力的计算机因有硬件支持而能够在同一时间执行多个线程，提升性能。

![01_简单了解多线程](.\img\01_简单了解多线程.png)

### hhh.2并发和并行【理解】

+ 并行：在同一时刻，有多个指令在多个CPU上同时执行。

  ![02_并行](.\img\02_并行.png)

+ 并发：在同一时刻，有多个指令在单个CPU上交替执行。

  ![03_并发](.\img\03_并发.png)

### hhh.3进程和线程【理解】

- 进程：是正在运行的程序

  独立性：进程是一个能独立运行的基本单位，同时也是系统分配资源和调度的独立单位
  动态性：进程的实质是程序的一次执行过程，进程是动态产生，动态消亡的
  并发性：任何进程都可以同其他进程一起并发执行

- 线程：是进程中的单个顺序控制流，是一条执行路径

  ​	单线程：一个进程如果只有一条执行路径，则称为单线程程序

  ​	多线程：一个进程如果有多条执行路径，则称为多线程程序

  ​	![04_多线程示例](.\img\04_多线程示例.png)

### hhh.4实现多线程方式一：继承Thread类【应用】

- 方法介绍

  | 方法名          | 说明                         |
  | ------------ | -------------------------- |
  | void run()   | 在线程开启后，此方法将被调用执行           |
  | void start() | 使此线程开始执行，Java虚拟机会调用run方法() |

- 实现步骤
  - 定义一个类MyThread继承Thread类
  - 在MyThread类中重写run()方法
  - 创建MyThread类的对象
  - 启动线程

- 代码演示

  ```java
  public class MyThread extends Thread {
      @Override
      public void run() {
          for(int i=0; i<100; i++) {
              System.out.println(i);
          }
      }
  }
  public class MyThreadDemo {
      public static void main(String[] args) {
          MyThread my1 = new MyThread();
          MyThread my2 = new MyThread();

  //        my1.run();
  //        my2.run();

          //void start() 导致此线程开始执行; Java虚拟机调用此线程的run方法
          my1.start();
          my2.start();
      }
  }
  ```

- 两个小问题

  - 为什么要重写run()方法？

    因为run()是用来封装被线程执行的代码

  - run()方法和start()方法的区别？

    run()：封装线程执行的代码，直接调用，相当于普通方法的调用

    start()：启动线程；然后由JVM调用此线程的run()方法

### hhh.5实现多线程方式二：实现Runnable接口【应用】

- Thread构造方法

  | 方法名                                  | 说明             |
  | ------------------------------------ | -------------- |
  | Thread(Runnable target)              | 分配一个新的Thread对象 |
  | Thread(Runnable target, String name) | 分配一个新的Thread对象 |

- 实现步骤

  - 定义一个类MyRunnable实现Runnable接口
  - 在MyRunnable类中重写run()方法
  - 创建MyRunnable类的对象
  - 创建Thread类的对象，把MyRunnable对象作为构造方法的参数
  - 启动线程

- 代码演示

  ```java
  public class MyRunnable implements Runnable {
      @Override
      public void run() {
          for(int i=0; i<100; i++) {
              System.out.println(Thread.currentThread().getName()+":"+i);
          }
      }
  }
  public class MyRunnableDemo {
      public static void main(String[] args) {
          //创建MyRunnable类的对象
          MyRunnable my = new MyRunnable();

          //创建Thread类的对象，把MyRunnable对象作为构造方法的参数
          //Thread(Runnable target)
  //        Thread t1 = new Thread(my);
  //        Thread t2 = new Thread(my);
          //Thread(Runnable target, String name)
          Thread t1 = new Thread(my,"坦克");
          Thread t2 = new Thread(my,"飞机");

          //启动线程
          t1.start();
          t2.start();
      }
  }
  ```

### hhh.6实现多线程方式三: 实现Callable接口【应用】

+ 方法介绍

  | 方法名                              | 说明                                  |
  | -------------------------------- | ----------------------------------- |
  | V call()                         | 计算结果，如果无法计算结果，则抛出一个异常               |
  | FutureTask(Callable<V> callable) | 创建一个 FutureTask，一旦运行就执行给定的 Callable |
  | V get()                          | 如有必要，等待计算完成，然后获取其结果                 |

+ 实现步骤

  + 定义一个类MyCallable实现Callable接口
  + 在MyCallable类中重写call()方法
  + 创建MyCallable类的对象
  + 创建Future的实现类FutureTask对象，把MyCallable对象作为构造方法的参数
  + 创建Thread类的对象，把FutureTask对象作为构造方法的参数
  + 启动线程
  + 再调用get方法，就可以获取线程结束之后的结果。

+ 代码演示

  ```java
  public class MyCallable implements Callable<String> {
      @Override
      public String call() throws Exception {
          for (int i = 0; i < 100; i++) {
              System.out.println("跟女孩表白" + i);
          }
          //返回值就表示线程运行完毕之后的结果
          return "答应";
      }
  }
  public class Ebook.Demo {
      public static void main(String[] args) throws ExecutionException, InterruptedException {
          //线程开启之后需要执行里面的call方法
          MyCallable mc = new MyCallable();

          //Thread t1 = new Thread(mc);

          //可以获取线程执行完毕之后的结果.也可以作为参数传递给Thread对象
          FutureTask<String> ft = new FutureTask<>(mc);

          //创建线程对象
          Thread t1 = new Thread(ft);

          String s = ft.get();
          //开启线程
          t1.start();

          //String s = ft.get();
          System.out.println(s);
      }
  }
  ```

+ 三种实现方式的对比
  + 实现Runnable、Callable接口
    + 好处: 扩展性强，实现该接口的同时还可以继承其他的类
    + 缺点: 编程相对复杂，不能直接使用Thread类中的方法
  + 继承Thread类
    + 好处: 编程比较简单，可以直接使用Thread类中的方法
    + 缺点: 可以扩展性较差，不能再继承其他的类

### hhh.7设置和获取线程名称【应用】

- 方法介绍

  | 方法名                        | 说明                 |
  | -------------------------- | ------------------ |
  | void  setName(String name) | 将此线程的名称更改为等于参数name |
  | String  getName()          | 返回此线程的名称           |
  | Thread  currentThread()    | 返回对当前正在执行的线程对象的引用  |

- 代码演示

  ```java
  public class MyThread extends Thread {
      public MyThread() {}
      public MyThread(String name) {
          super(name);
      }

      @Override
      public void run() {
          for (int i = 0; i < 100; i++) {
              System.out.println(getName()+":"+i);
          }
      }
  }
  public class MyThreadDemo {
      public static void main(String[] args) {
          MyThread my1 = new MyThread();
          MyThread my2 = new MyThread();

          //void setName(String name)：将此线程的名称更改为等于参数 name
          my1.setName("高铁");
          my2.setName("飞机");

          //Thread(String name)
          MyThread my1 = new MyThread("高铁");
          MyThread my2 = new MyThread("飞机");

          my1.start();
          my2.start();

          //static Thread currentThread() 返回对当前正在执行的线程对象的引用
          System.out.println(Thread.currentThread().getName());
      }
  }
  ```

### hhh.8线程休眠【应用】

+ 相关方法

  | 方法名                            | 说明                       |
  | ------------------------------ | ------------------------ |
  | static void sleep(long millis) | 使当前正在执行的线程停留（暂停执行）指定的毫秒数 |

+ 代码演示

  ```java
  public class MyRunnable implements Runnable {
      @Override
      public void run() {
          for (int i = 0; i < 100; i++) {
              try {
                  Thread.sleep(100);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }

              System.out.println(Thread.currentThread().getName() + "---" + i);
          }
      }
  }
  public class Ebook.Demo {
      public static void main(String[] args) throws InterruptedException {
          /*System.out.println("睡觉前");
          Thread.sleep(3000);
          System.out.println("睡醒了");*/

          MyRunnable mr = new MyRunnable();

          Thread t1 = new Thread(mr);
          Thread t2 = new Thread(mr);

          t1.start();
          t2.start();
      }
  }
  ```

### hhh.9线程优先级【应用】

- 线程调度

  - 两种调度方式
    - 分时调度模型：所有线程轮流使用 CPU 的使用权，平均分配每个线程占用 CPU 的时间片
    - 抢占式调度模型：优先让优先级高的线程使用 CPU，如果线程的优先级相同，那么会随机选择一个，优先级高的线程获取的 CPU 时间片相对多一些

  - Java使用的是抢占式调度模型

  - 随机性

    假如计算机只有一个 CPU，那么 CPU 在某一个时刻只能执行一条指令，线程只有得到CPU时间片，也就是使用权，才可以执行指令。所以说多线程程序的执行是有随机性，因为谁抢到CPU的使用权是不一定的

    ![05_多线程示例图](.\img\05_多线程示例图.png)

- 优先级相关方法

  | 方法名                                     | 说明                                |
  | --------------------------------------- | --------------------------------- |
  | final int getPriority()                 | 返回此线程的优先级                         |
  | final void setPriority(int newPriority) | 更改此线程的优先级线程默认优先级是5；线程优先级的范围是：hhh-10 |

- 代码演示

  ```java
  public class MyCallable implements Callable<String> {
      @Override
      public String call() throws Exception {
          for (int i = 0; i < 100; i++) {
              System.out.println(Thread.currentThread().getName() + "---" + i);
          }
          return "线程执行完毕了";
      }
  }
  public class Ebook.Demo {
      public static void main(String[] args) {
          //优先级: hhh - 10 默认值:5
          MyCallable mc = new MyCallable();

          FutureTask<String> ft = new FutureTask<>(mc);

          Thread t1 = new Thread(ft);
          t1.setName("飞机");
          t1.setPriority(10);
          //System.out.println(t1.getPriority());//5
          t1.start();

          MyCallable mc2 = new MyCallable();

          FutureTask<String> ft2 = new FutureTask<>(mc2);

          Thread t2 = new Thread(ft2);
          t2.setName("坦克");
          t2.setPriority(hhh);
          //System.out.println(t2.getPriority());//5
          t2.start();
      }
  }
  ```

### hhh.10守护线程【应用】

- 相关方法

  | 方法名                        | 说明                                   |
  | -------------------------- | ------------------------------------ |
  | void setDaemon(boolean on) | 将此线程标记为守护线程，当运行的线程都是守护线程时，Java虚拟机将退出 |

- 代码演示

  ```java
  public class MyThread1 extends Thread {
      @Override
      public void run() {
          for (int i = 0; i < 10; i++) {
              System.out.println(getName() + "---" + i);
          }
      }
  }
  public class MyThread2 extends Thread {
      @Override
      public void run() {
          for (int i = 0; i < 100; i++) {
              System.out.println(getName() + "---" + i);
          }
      }
  }
  public class Ebook.Demo {
      public static void main(String[] args) {
          MyThread1 t1 = new MyThread1();
          MyThread2 t2 = new MyThread2();

          t1.setName("女神");
          t2.setName("备胎");

          //把第二个线程设置为守护线程
          //当普通线程执行完之后,那么守护线程也没有继续运行下去的必要了.
          t2.setDaemon(true);

          t1.start();
          t2.start();
      }
  }
  ```

## 2.线程同步

### 2.1卖票【应用】

- 案例需求

  某电影院目前正在上映国产大片，共有100张票，而它有3个窗口卖票，请设计一个程序模拟该电影院卖票

- 实现步骤

  - 定义一个类SellTicket实现Runnable接口，里面定义一个成员变量：private int tickets = 100;

  - 在SellTicket类中重写run()方法实现卖票，代码步骤如下

  - 判断票数大于0，就卖票，并告知是哪个窗口卖的
  - 卖了票之后，总票数要减1
  - 票卖没了，线程停止
  - 定义一个测试类SellTicketDemo，里面有main方法，代码步骤如下
  - 创建SellTicket类的对象
  - 创建三个Thread类的对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
  - 启动线程

- 代码实现

  ```java
  public class SellTicket implements Runnable {
      private int tickets = 100;
      //在SellTicket类中重写run()方法实现卖票，代码步骤如下
      @Override
      public void run() {
          while (true) {
              if(ticket <= 0){
                      //卖完了
                      break;
                  }else{
                      try {
                          Thread.sleep(100);
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      ticket--;
                      System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                  }
          }
      }
  }
  public class SellTicketDemo {
      public static void main(String[] args) {
          //创建SellTicket类的对象
          SellTicket st = new SellTicket();

          //创建三个Thread类的对象，把SellTicket对象作为构造方法的参数，并给出对应的窗口名称
          Thread t1 = new Thread(st,"窗口1");
          Thread t2 = new Thread(st,"窗口2");
          Thread t3 = new Thread(st,"窗口3");

          //启动线程
          t1.start();
          t2.start();
          t3.start();
      }
  }
  ```


### 2.2卖票案例的问题【理解】

- 卖票出现了问题

  - 相同的票出现了多次

  - 出现了负数的票

- 问题产生原因

  线程执行的随机性导致的,可能在卖票过程中丢失cpu的执行权,导致出现问题


### 2.3同步代码块解决数据安全问题【应用】

- 安全问题出现的条件

  - 是多线程环境

  - 有共享数据

  - 有多条语句操作共享数据

- 如何解决多线程安全问题呢?

  - 基本思想：让程序没有安全问题的环境

- 怎么实现呢?

  - 把多条语句操作共享数据的代码给锁起来，让任意时刻只能有一个线程执行即可

  - Java提供了同步代码块的方式来解决

- 同步代码块格式：

  ```java
  synchronized(任意对象) {
  	多条语句操作共享数据的代码
  }
  ```

  synchronized(任意对象)：就相当于给代码加锁了，任意对象就可以看成是一把锁

- 同步的好处和弊端

  - 好处：解决了多线程的数据安全问题

  - 弊端：当线程很多时，因为每个线程都会去判断同步上的锁，这是很耗费资源的，无形中会降低程序的运行效率

- 代码演示

  ```java
  public class SellTicket implements Runnable {
      private int tickets = 100;
      private Object obj = new Object();

      @Override
      public void run() {
          while (true) {
              synchronized (obj) { // 对可能有安全问题的代码加锁,多个线程必须使用同一把锁
                  //t1进来后，就会把这段代码给锁起来
                  if (tickets > 0) {
                      try {
                          Thread.sleep(100);
                          //t1休息100毫秒
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                      //窗口1正在出售第100张票
                      System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                      tickets--; //tickets = 99;
                  }
              }
              //t1出来了，这段代码的锁就被释放了
          }
      }
  }

  public class SellTicketDemo {
      public static void main(String[] args) {
          SellTicket st = new SellTicket();

          Thread t1 = new Thread(st, "窗口1");
          Thread t2 = new Thread(st, "窗口2");
          Thread t3 = new Thread(st, "窗口3");

          t1.start();
          t2.start();
          t3.start();
      }
  }
  ```

### 2.4同步方法解决数据安全问题【应用】

- 同步方法的格式

  同步方法：就是把synchronized关键字加到方法上

  ```java
  修饰符 synchronized 返回值类型 方法名(方法参数) {
  	方法体；
  }
  ```

  同步方法的锁对象是什么呢?

  ​	this

- 静态同步方法

  同步静态方法：就是把synchronized关键字加到静态方法上

  ```java
  修饰符 static synchronized 返回值类型 方法名(方法参数) {
  	方法体；
  }
  ```

  同步静态方法的锁对象是什么呢?

  ​	类名.class

- 代码演示

  ```java
  public class MyRunnable implements Runnable {
      private static int ticketCount = 100;

      @Override
      public void run() {
          while(true){
              if("窗口一".equals(Thread.currentThread().getName())){
                  //同步方法
                  boolean result = synchronizedMthod();
                  if(result){
                      break;
                  }
              }

              if("窗口二".equals(Thread.currentThread().getName())){
                  //同步代码块
                  synchronized (MyRunnable.class){
                      if(ticketCount == 0){
                         break;
                      }else{
                          try {
                              Thread.sleep(10);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                          ticketCount--;
                          System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticketCount + "张票");
                      }
                  }
              }

          }
      }

      private static synchronized boolean synchronizedMthod() {
          if(ticketCount == 0){
              return true;
          }else{
              try {
                  Thread.sleep(10);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              ticketCount--;
              System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticketCount + "张票");
              return false;
          }
      }
  }
  ```


  public class Ebook.Demo {
      public static void main(String[] args) {
          MyRunnable mr = new MyRunnable();

          Thread t1 = new Thread(mr);
          Thread t2 = new Thread(mr);
    
          t1.setName("窗口一");
          t2.setName("窗口二");
    
          t1.start();
          t2.start();
      }
  }
  ```


### 2.5Lock锁【应用】

虽然我们可以理解同步代码块和同步方法的锁对象问题，但是我们并没有直接看到在哪里加上了锁，在哪里释放了锁，为了更清晰的表达如何加锁和释放锁，JDK5以后提供了一个新的锁对象Lock

Lock是接口不能直接实例化，这里采用它的实现类ReentrantLock来实例化

- ReentrantLock构造方法

  | 方法名             | 说明                   |
  | --------------- | -------------------- |
  | ReentrantLock() | 创建一个ReentrantLock的实例 |

- 加锁解锁方法

  | 方法名           | 说明   |
  | ------------- | ---- |
  | void lock()   | 获得锁  |
  | void unlock() | 释放锁  |

- 代码演示

  ```java
  public class Ticket implements Runnable {
      //票的数量
      private int ticket = 100;
      private Object obj = new Object();
      private ReentrantLock lock = new ReentrantLock();

      @Override
      public void run() {
          while (true) {
              //synchronized (obj){//多个线程必须使用同一把锁.
              try {
                  lock.lock();
                  if (ticket <= 0) {
                      //卖完了
                      break;
                  } else {
                      Thread.sleep(100);
                      ticket--;
                      System.out.println(Thread.currentThread().getName() + "在卖票,还剩下" + ticket + "张票");
                  }
              } catch (InterruptedException e) {
                  e.printStackTrace();
              } finally {
                  lock.unlock();
              }
              // }
          }
      }
  }

  public class Ebook.Demo {
      public static void main(String[] args) {
          Ticket ticket = new Ticket();

          Thread t1 = new Thread(ticket);
          Thread t2 = new Thread(ticket);
          Thread t3 = new Thread(ticket);

          t1.setName("窗口一");
          t2.setName("窗口二");
          t3.setName("窗口三");

          t1.start();
          t2.start();
          t3.start();
      }
  }
  ```

### 2.6死锁【理解】

+ 概述

  线程死锁是指由于两个或者多个线程互相持有对方所需要的资源，导致这些线程处于等待状态，无法前往执行

+ 什么情况下会产生死锁

  hhh. 资源有限
  2. 同步嵌套

+ 代码演示

  ```java
  public class Ebook.Demo {
      public static void main(String[] args) {
          Object objA = new Object();
          Object objB = new Object();

          new Thread(()->{
              while(true){
                  synchronized (objA){
                      //线程一
                      synchronized (objB){
                          System.out.println("小康同学正在走路");
                      }
                  }
              }
          }).start();

          new Thread(()->{
              while(true){
                  synchronized (objB){
                      //线程二
                      synchronized (objA){
                          System.out.println("小薇同学正在走路");
                      }
                  }
              }
          }).start();
      }
  }
  ```

## 3.生产者消费者

### 3.1生产者和消费者模式概述【应用】

- 概述

  生产者消费者模式是一个十分经典的多线程协作的模式，弄懂生产者消费者问题能够让我们对多线程编程的理解更加深刻。

  所谓生产者消费者问题，实际上主要是包含了两类线程：

  ​	一类是生产者线程用于生产数据

  ​	一类是消费者线程用于消费数据

  为了解耦生产者和消费者的关系，通常会采用共享的数据区域，就像是一个仓库

  生产者生产数据之后直接放置在共享数据区中，并不需要关心消费者的行为

  消费者只需要从共享数据区中去获取数据，并不需要关心生产者的行为

- Object类的等待和唤醒方法

  | 方法名              | 说明                                       |
  | ---------------- | ---------------------------------------- |
  | void wait()      | 导致当前线程等待，直到另一个线程调用该对象的 notify()方法或 notifyAll()方法 |
  | void notify()    | 唤醒正在等待对象监视器的单个线程                         |
  | void notifyAll() | 唤醒正在等待对象监视器的所有线程                         |

### 3.2生产者和消费者案例【应用】

- 案例需求

  + 桌子类(Desk)：定义表示包子数量的变量,定义锁对象变量,定义标记桌子上有无包子的变量

  + 生产者类(Cooker)：实现Runnable接口，重写run()方法，设置线程任务

      hhh.判断是否有包子,决定当前线程是否执行

      2.如果有包子,就进入等待状态,如果没有包子,继续执行,生产包子

      3.生产包子之后,更新桌子上包子状态,唤醒消费者消费包子

  + 消费者类(Foodie)：实现Runnable接口，重写run()方法，设置线程任务

      hhh.判断是否有包子,决定当前线程是否执行

      2.如果没有包子,就进入等待状态,如果有包子,就消费包子

      3.消费包子后,更新桌子上包子状态,唤醒生产者生产包子

  + 测试类(Ebook.Demo)：里面有main方法，main方法中的代码步骤如下

      创建生产者线程和消费者线程对象

      分别开启两个线程

- 代码实现

  ```java
  public class Desk {

      //定义一个标记
      //true 就表示桌子上有汉堡包的,此时允许吃货执行
      //false 就表示桌子上没有汉堡包的,此时允许厨师执行
      public static boolean flag = false;

      //汉堡包的总数量
      public static int count = 10;

      //锁对象
      public static final Object lock = new Object();
  }

  public class Cooker extends Thread {
  //    生产者步骤：
  //            hhh，判断桌子上是否有汉堡包
  //    如果有就等待，如果没有才生产。
  //            2，把汉堡包放在桌子上。
  //            3，叫醒等待的消费者开吃。
      @Override
      public void run() {
          while(true){
              synchronized (Desk.lock){
                  if(Desk.count == 0){
                      break;
                  }else{
                      if(!Desk.flag){
                          //生产
                          System.out.println("厨师正在生产汉堡包");
                          Desk.flag = true;
                          Desk.lock.notifyAll();
                      }else{
                          try {
                              Desk.lock.wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  }
              }
          }
      }
  }

  public class Foodie extends Thread {
      @Override
      public void run() {
  //        hhh，判断桌子上是否有汉堡包。
  //        2，如果没有就等待。
  //        3，如果有就开吃
  //        4，吃完之后，桌子上的汉堡包就没有了
  //                叫醒等待的生产者继续生产
  //        汉堡包的总数量减一

          //套路:
              //hhh. while(true)死循环
              //2. synchronized 锁,锁对象要唯一
              //3. 判断,共享数据是否结束. 结束
              //4. 判断,共享数据是否结束. 没有结束
          while(true){
              synchronized (Desk.lock){
                  if(Desk.count == 0){
                      break;
                  }else{
                      if(Desk.flag){
                          //有
                          System.out.println("吃货在吃汉堡包");
                          Desk.flag = false;
                          Desk.lock.notifyAll();
                          Desk.count--;
                      }else{
                          //没有就等待
                          //使用什么对象当做锁,那么就必须用这个对象去调用等待和唤醒的方法.
                          try {
                              Desk.lock.wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  }
              }
          }

      }
  }

  public class Ebook.Demo {
      public static void main(String[] args) {
          /*消费者步骤：
          hhh，判断桌子上是否有汉堡包。
          2，如果没有就等待。
          3，如果有就开吃
          4，吃完之后，桌子上的汉堡包就没有了
                  叫醒等待的生产者继续生产
          汉堡包的总数量减一*/

          /*生产者步骤：
          hhh，判断桌子上是否有汉堡包
          如果有就等待，如果没有才生产。
          2，把汉堡包放在桌子上。
          3，叫醒等待的消费者开吃。*/

          Foodie f = new Foodie();
          Cooker c = new Cooker();

          f.start();
          c.start();

      }
  }
  ```

### 3.3生产者和消费者案例优化【应用】

+ 需求

  + 将Desk类中的变量,采用面向对象的方式封装起来
  + 生产者和消费者类中构造方法接收Desk类对象,之后在run方法中进行使用
  + 创建生产者和消费者线程对象,构造方法中传入Desk类对象
  + 开启两个线程

+ 代码实现

  ```java
  public class Desk {

      //定义一个标记
      //true 就表示桌子上有汉堡包的,此时允许吃货执行
      //false 就表示桌子上没有汉堡包的,此时允许厨师执行
      //public static boolean flag = false;
      private boolean flag;

      //汉堡包的总数量
      //public static int count = 10;
      //以后我们在使用这种必须有默认值的变量
     // private int count = 10;
      private int count;

      //锁对象
      //public static final Object lock = new Object();
      private final Object lock = new Object();

      public Desk() {
          this(false,10); // 在空参内部调用带参,对成员变量进行赋值,之后就可以直接使用成员变量了
      }

      public Desk(boolean flag, int count) {
          this.flag = flag;
          this.count = count;
      }

      public boolean isFlag() {
          return flag;
      }

      public void setFlag(boolean flag) {
          this.flag = flag;
      }

      public int getCount() {
          return count;
      }

      public void setCount(int count) {
          this.count = count;
      }

      public Object getLock() {
          return lock;
      }

      @Override
      public String toString() {
          return "Desk{" +
                  "flag=" + flag +
                  ", count=" + count +
                  ", lock=" + lock +
                  '}';
      }
  }

  public class Cooker extends Thread {

      private Desk desk;

      public Cooker(Desk desk) {
          this.desk = desk;
      }
  //    生产者步骤：
  //            hhh，判断桌子上是否有汉堡包
  //    如果有就等待，如果没有才生产。
  //            2，把汉堡包放在桌子上。
  //            3，叫醒等待的消费者开吃。

      @Override
      public void run() {
          while(true){
              synchronized (desk.getLock()){
                  if(desk.getCount() == 0){
                      break;
                  }else{
                      //System.out.println("验证一下是否执行了");
                      if(!desk.isFlag()){
                          //生产
                          System.out.println("厨师正在生产汉堡包");
                          desk.setFlag(true);
                          desk.getLock().notifyAll();
                      }else{
                          try {
                              desk.getLock().wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  }
              }
          }
      }
  }

  public class Foodie extends Thread {
      private Desk desk;

      public Foodie(Desk desk) {
          this.desk = desk;
      }

      @Override
      public void run() {
  //        hhh，判断桌子上是否有汉堡包。
  //        2，如果没有就等待。
  //        3，如果有就开吃
  //        4，吃完之后，桌子上的汉堡包就没有了
  //                叫醒等待的生产者继续生产
  //        汉堡包的总数量减一

          //套路:
              //hhh. while(true)死循环
              //2. synchronized 锁,锁对象要唯一
              //3. 判断,共享数据是否结束. 结束
              //4. 判断,共享数据是否结束. 没有结束
          while(true){
              synchronized (desk.getLock()){
                  if(desk.getCount() == 0){
                      break;
                  }else{
                      //System.out.println("验证一下是否执行了");
                      if(desk.isFlag()){
                          //有
                          System.out.println("吃货在吃汉堡包");
                          desk.setFlag(false);
                          desk.getLock().notifyAll();
                          desk.setCount(desk.getCount() - hhh);
                      }else{
                          //没有就等待
                          //使用什么对象当做锁,那么就必须用这个对象去调用等待和唤醒的方法.
                          try {
                              desk.getLock().wait();
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  }
              }
          }

      }
  }

  public class Ebook.Demo {
      public static void main(String[] args) {
          /*消费者步骤：
          hhh，判断桌子上是否有汉堡包。
          2，如果没有就等待。
          3，如果有就开吃
          4，吃完之后，桌子上的汉堡包就没有了
                  叫醒等待的生产者继续生产
          汉堡包的总数量减一*/

          /*生产者步骤：
          hhh，判断桌子上是否有汉堡包
          如果有就等待，如果没有才生产。
          2，把汉堡包放在桌子上。
          3，叫醒等待的消费者开吃。*/

          Desk desk = new Desk();

          Foodie f = new Foodie(desk);
          Cooker c = new Cooker(desk);

          f.start();
          c.start();

      }
  }
  ```

### 3.4阻塞队列基本使用【理解】

+ 阻塞队列继承结构

  ![06_阻塞队列继承结构](.\img\06_阻塞队列继承结构.png)


+ 常见BlockingQueue:

   ArrayBlockingQueue: 底层是数组,有界

   LinkedBlockingQueue: 底层是链表,无界.但不是真正的无界,最大为int的最大值

+ BlockingQueue的核心方法:

   put(anObject): 将参数放入队列,如果放不进去会阻塞

   take(): 取出第一个数据,取不到会阻塞

+ 代码示例

  ```java
  public class Demo02 {
      public static void main(String[] args) throws Exception {
          // 创建阻塞队列的对象,容量为 hhh
          ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<>(hhh);

          // 存储元素
          arrayBlockingQueue.put("汉堡包");

          // 取元素
          System.out.println(arrayBlockingQueue.take());
          System.out.println(arrayBlockingQueue.take()); // 取不到会阻塞

          System.out.println("程序结束了");
      }
  }
  ```

### 3.5阻塞队列实现等待唤醒机制【理解】

+ 案例需求

  + 生产者类(Cooker)：实现Runnable接口，重写run()方法，设置线程任务

      hhh.构造方法中接收一个阻塞队列对象

      2.在run方法中循环向阻塞队列中添加包子

      3.打印添加结果

  + 消费者类(Foodie)：实现Runnable接口，重写run()方法，设置线程任务

       hhh.构造方法中接收一个阻塞队列对象

       2.在run方法中循环获取阻塞队列中的包子

       3.打印获取结果

  + 测试类(Ebook.Demo)：里面有main方法，main方法中的代码步骤如下

      创建阻塞队列对象

      创建生产者线程和消费者线程对象,构造方法中传入阻塞队列对象

      分别开启两个线程

+ 代码实现

  ```java
  public class Cooker extends Thread {

      private ArrayBlockingQueue<String> bd;

      public Cooker(ArrayBlockingQueue<String> bd) {
          this.bd = bd;
      }
  //    生产者步骤：
  //            hhh，判断桌子上是否有汉堡包
  //    如果有就等待，如果没有才生产。
  //            2，把汉堡包放在桌子上。
  //            3，叫醒等待的消费者开吃。

      @Override
      public void run() {
          while (true) {
              try {
                  bd.put("汉堡包");
                  System.out.println("厨师放入一个汉堡包");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  }

  public class Foodie extends Thread {
      private ArrayBlockingQueue<String> bd;

      public Foodie(ArrayBlockingQueue<String> bd) {
          this.bd = bd;
      }

      @Override
      public void run() {
  //        hhh，判断桌子上是否有汉堡包。
  //        2，如果没有就等待。
  //        3，如果有就开吃
  //        4，吃完之后，桌子上的汉堡包就没有了
  //                叫醒等待的生产者继续生产
  //        汉堡包的总数量减一

          //套路:
          //hhh. while(true)死循环
          //2. synchronized 锁,锁对象要唯一
          //3. 判断,共享数据是否结束. 结束
          //4. 判断,共享数据是否结束. 没有结束
          while (true) {
              try {
                  String take = bd.take();
                  System.out.println("吃货将" + take + "拿出来吃了");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }

      }
  }

  public class Ebook.Demo {
      public static void main(String[] args) {
          ArrayBlockingQueue<String> bd = new ArrayBlockingQueue<>(hhh);

          Foodie f = new Foodie(bd);
          Cooker c = new Cooker(bd);

          f.start();
          c.start();
      }
  }
  ```

  



# day15-多线程02

## hhh.线程池

### hhh.hhh 线程状态介绍

当线程被创建并启动以后，它既不是一启动就进入了执行状态，也不是一直处于执行状态。线程对象在不同的时期有不同的状态。那么Java中的线程存在哪几种状态呢？Java中的线程

状态被定义在了java.lang.Thread.State枚举类中，State枚举类的源码如下：

```java
public class Thread {

    public enum State {

        /* 新建 */
        NEW ,

        /* 可运行状态 */
        RUNNABLE ,

        /* 阻塞状态 */
        BLOCKED ,

        /* 无限等待状态 */
        WAITING ,

        /* 计时等待 */
        TIMED_WAITING ,

        /* 终止 */
        TERMINATED;

	}

    // 获取当前线程的状态
    public State getState() {
        return jdk.internal.misc.VM.toThreadState(threadStatus);
    }

}
```

通过源码我们可以看到Java中的线程存在6种状态，每种线程状态的含义如下

| 线程状态          | 具体含义                                     |
| ------------- | ---------------------------------------- |
| NEW           | 一个尚未启动的线程的状态。也称之为初始状态、开始状态。线程刚被创建，但是并未启动。还没调用start方法。MyThread t = new MyThread()只有线程象，没有线程特征。 |
| RUNNABLE      | 当我们调用线程对象的start方法，那么此时线程对象进入了RUNNABLE状态。那么此时才是真正的在JVM进程中创建了一个线程，线程一经启动并不是立即得到执行，线程的运行与否要听令与CPU的调度，那么我们把这个中间状态称之为可执行状态(RUNNABLE)也就是说它具备执行的资格，但是并没有真正的执行起来而是在等待CPU的度。 |
| BLOCKED       | 当一个线程试图获取一个对象锁，而该对象锁被其他的线程持有，则该线程进入Blocked状态；当该线程持有锁时，该线程将变成Runnable状态。 |
| WAITING       | 一个正在等待的线程的状态。也称之为等待状态。造成线程等待的原因有两种，分别是调用Object.wait()、join()方法。处于等待状态的线程，正在等待其他线程去执行一个特定的操作。例如：因为wait()而等待的线程正在等待另一个线程去调用notify()或notifyAll()；一个因为join()而等待的线程正在等待另一个线程结束。 |
| TIMED_WAITING | 一个在限定时间内等待的线程的状态。也称之为限时等待状态。造成线程限时等待状态的原因有三种，分别是：Thread.sleep(long)，Object.wait(long)、join(long)。 |
| TERMINATED    | 一个完全运行完成的线程的状态。也称之为终止状态、结束状态             |

各个状态的转换，如下图所示：

![1591163781941](.\img\1591163781941.png)

### hhh.2 线程池-基本原理

**概述 :**

​	提到池，大家应该能想到的就是水池。水池就是一个容器，在该容器中存储了很多的水。那么什么是线程池呢？线程池也是可以看做成一个池子，在该池子中存储很多个线程。

线程池存在的意义：

​	系统创建一个线程的成本是比较高的，因为它涉及到与操作系统交互，当程序中需要创建大量生存期很短暂的线程时，频繁的创建和销毁线程对系统的资源消耗有可能大于业务处理是对系

​	统资源的消耗，这样就有点"舍本逐末"了。针对这一种情况，为了提高性能，我们就可以采用线程池。线程池在启动的时，会创建大量空闲线程，当我们向线程池提交任务的时，线程池就

​	会启动一个线程来执行该任务。等待任务执行完毕以后，线程并不会死亡，而是再次返回到线程池中称为空闲状态。等待下一次任务的执行。

**线程池的设计思路 :**

hhh. 准备一个任务容器
2. 一次性启动多个(2个)消费者线程
3. 刚开始任务容器是空的，所以线程都在wait
4. 直到一个外部线程向这个任务容器中扔了一个"任务"，就会有一个消费者线程被唤醒
5. 这个消费者线程取出"任务"，并且执行这个任务，执行完毕后，继续等待下一次任务的到来

### hhh.3 线程池-Executors默认线程池

概述 : JDK对线程池也进行了相关的实现，在真实企业开发中我们也很少去自定义线程池，而是使用JDK中自带的线程池。

我们可以使用Executors中所提供的**静态**方法来创建线程池

​	static ExecutorService newCachedThreadPool()   创建一个默认的线程池
​	static newFixedThreadPool(int nThreads)	    创建一个指定最多线程数量的线程池

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.mythreadpoolⅠ;


//static ExecutorService newCachedThreadPool()   创建一个默认的线程池
//static newFixedThreadPool(int nThreads)	    创建一个指定最多线程数量的线程池

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThreadPoolDemo {
  public static void main(String[] args) throws InterruptedException {

    //hhh,创建一个默认的线程池对象.池子中默认是空的.默认最多可以容纳int类型的最大值.
    ExecutorService executorService = Executors.newCachedThreadPool();
    //Executors --- 可以帮助我们创建线程池对象
    //ExecutorService --- 可以帮助我们控制线程池

    executorService.submit(() -> {
      System.out.println(Thread.currentThread().getName() + "在执行了");
    });

    //Thread.sleep(2000);

    executorService.submit(() -> {
      System.out.println(Thread.currentThread().getName() + "在执行了");
    });

    executorService.shutdown();
  }
}

```



### hhh.4 线程池-Executors创建指定上限的线程池

**使用Executors中所提供的静态方法来创建线程池**

​	static ExecutorService newFixedThreadPool(int nThreads) : 创建一个指定最多线程数量的线程池

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.mythreadpoolⅠ;

//static ExecutorService newFixedThreadPool(int nThreads)
//创建一个指定最多线程数量的线程池

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyThreadPoolDemo2 {
  public static void main(String[] args) {
    //参数不是初始值而是最大值
    ExecutorService executorService = Executors.newFixedThreadPool(10);

    ThreadPoolExecutor pool = (ThreadPoolExecutor) executorService;
    System.out.println(pool.getPoolSize());//0

    executorService.submit(() -> {
      System.out.println(Thread.currentThread().getName() + "在执行了");
    });

    executorService.submit(() -> {
      System.out.println(Thread.currentThread().getName() + "在执行了");
    });

    System.out.println(pool.getPoolSize());//2
//        executorService.shutdown();
  }
}

```



### hhh.5 线程池-ThreadPoolExecutor

**创建线程池对象 :**

ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(核心线程数量,最大线程数量,空闲线程最大存活时间,任务队列,创建线程工厂,任务的拒绝策略);

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.mythreadpoolⅠ;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPoolDemo3 {
  //    参数一：核心线程数量
//    参数二：最大线程数
//    参数三：空闲线程最大存活时间
//    参数四：时间单位
//    参数五：任务队列
//    参数六：创建线程工厂
//    参数七：任务的拒绝策略
  public static void main(String[] args) {
    ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 2, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
    pool.submit(new MyRunnable());
    pool.submit(new MyRunnable());

    pool.shutdown();
  }
}
```

### hhh.6 线程池-参数详解

![1591165506516](.\img\1591165506516.png)

```java
public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory,
                              RejectedExecutionHandler handler)

corePoolSize：   核心线程的最大值，不能小于0
maximumPoolSize：最大线程数，不能小于等于0，maximumPoolSize >= corePoolSize
keepAliveTime：  空闲线程最大存活时间,不能小于0
unit：           时间单位
workQueue：      任务队列，不能为null
threadFactory：  创建线程工厂,不能为null
handler：        任务的拒绝策略,不能为null
```



### hhh.7 线程池-非默认任务拒绝策略

RejectedExecutionHandler是jdk提供的一个任务拒绝策略接口，它下面存在4个子类。

```java
ThreadPoolExecutor.AbortPolicy: 		    丢弃任务并抛出RejectedExecutionException异常。是默认的策略。
ThreadPoolExecutor.DiscardPolicy： 		   丢弃任务，但是不抛出异常 这是不推荐的做法。
ThreadPoolExecutor.DiscardOldestPolicy：    抛弃队列中等待最久的任务 然后把当前任务加入队列中。
ThreadPoolExecutor.CallerRunsPolicy:        调用任务的run()方法绕过线程池直接执行。
```

注：明确线程池对多可执行的任务数 = 队列容量 + 最大线程数

**案例演示1**：演示ThreadPoolExecutor.AbortPolicy任务处理策略

```java
public class ThreadPoolExecutorDemo01 {

    public static void main(String[] args) {

        /**
         * 核心线程数量为1 ， 最大线程池数量为3, 任务容器的容量为1 ,空闲线程的最大存在时间为20s
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(hhh , 3 , 20 , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(hhh) , Executors.defaultThreadFactory() , new ThreadPoolExecutor.AbortPolicy()) ;

        // 提交5个任务，而该线程池最多可以处理4个任务，当我们使用AbortPolicy这个任务处理策略的时候，就会抛出异常
        for(int x = 0 ; x < 5 ; x++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "---->> 执行了任务");
            });
        }
    }
}
```

**控制台输出结果**

```java
pool-hhh-thread-hhh---->> 执行了任务
pool-hhh-thread-3---->> 执行了任务
pool-hhh-thread-2---->> 执行了任务
pool-hhh-thread-3---->> 执行了任务
```

控制台报错，仅仅执行了4个任务，有一个任务被丢弃了



**案例演示2**：演示ThreadPoolExecutor.DiscardPolicy任务处理策略

```java
public class ThreadPoolExecutorDemo02 {
    public static void main(String[] args) {
        /**
         * 核心线程数量为1 ， 最大线程池数量为3, 任务容器的容量为1 ,空闲线程的最大存在时间为20s
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(hhh , 3 , 20 , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(hhh) , Executors.defaultThreadFactory() , new ThreadPoolExecutor.DiscardPolicy()) ;

        // 提交5个任务，而该线程池最多可以处理4个任务，当我们使用DiscardPolicy这个任务处理策略的时候，控制台不会报错
        for(int x = 0 ; x < 5 ; x++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "---->> 执行了任务");
            });
        }
    }
}
```

**控制台输出结果**

```java
pool-hhh-thread-hhh---->> 执行了任务
pool-hhh-thread-hhh---->> 执行了任务
pool-hhh-thread-3---->> 执行了任务
pool-hhh-thread-2---->> 执行了任务
```

控制台没有报错，仅仅执行了4个任务，有一个任务被丢弃了



**案例演示3**：演示ThreadPoolExecutor.DiscardOldestPolicy任务处理策略

```java
public class ThreadPoolExecutorDemo02 {
    public static void main(String[] args) {
        /**
         * 核心线程数量为1 ， 最大线程池数量为3, 任务容器的容量为1 ,空闲线程的最大存在时间为20s
         */
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(hhh , 3 , 20 , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(hhh) , Executors.defaultThreadFactory() , new ThreadPoolExecutor.DiscardOldestPolicy());
        // 提交5个任务
        for(int x = 0 ; x < 5 ; x++) {
            // 定义一个变量，来指定指定当前执行的任务;这个变量需要被final修饰
            final int y = x ;
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "---->> 执行了任务" + y);
            });
        }
    }
}
```

**控制台输出结果**

```java
pool-hhh-thread-2---->> 执行了任务2
pool-hhh-thread-hhh---->> 执行了任务0
pool-hhh-thread-3---->> 执行了任务3
pool-hhh-thread-hhh---->> 执行了任务4
```

由于任务1在线程池中等待时间最长，因此任务1被丢弃。



**案例演示4**：演示ThreadPoolExecutor.CallerRunsPolicy任务处理策略

```java
public class ThreadPoolExecutorDemo04 {
    public static void main(String[] args) {

        /**
         * 核心线程数量为1 ， 最大线程池数量为3, 任务容器的容量为1 ,空闲线程的最大存在时间为20s
         */
        ThreadPoolExecutor threadPoolExecutor;
        threadPoolExecutor = new ThreadPoolExecutor(hhh , 3 , 20 , TimeUnit.SECONDS ,
                new ArrayBlockingQueue<>(hhh) , Executors.defaultThreadFactory() , new ThreadPoolExecutor.CallerRunsPolicy());

        // 提交5个任务
        for(int x = 0 ; x < 5 ; x++) {
            threadPoolExecutor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "---->> 执行了任务");
            });
        }
    }
}
```

**控制台输出结果**

```java
pool-hhh-thread-hhh---->> 执行了任务
pool-hhh-thread-3---->> 执行了任务
pool-hhh-thread-2---->> 执行了任务
pool-hhh-thread-hhh---->> 执行了任务
main---->> 执行了任务
```

通过控制台的输出，我们可以看到次策略没有通过线程池中的线程执行任务，而是直接调用任务的run()方法绕过线程池直接执行。

## 2. 原子性

### 2.hhh volatile-问题

**代码分析 :**

```java
package KnowledgePoints.myInterface.interFalse.myvolatileⅡ;

public class Ebook.Demo{
public static void main(String[]args){
        MyThread1 t1=new MyThread1();
        t1.setName("小路同学");
        t1.start();

        MyThread2 t2=new MyThread2();
        t2.setName("小皮同学");
        t2.start();
        }
        }
```

```java
package KnowledgePoints.myInterface.interFalse.myvolatileⅡ;

public class Money {
  public static int money = 100000;
}
```

```java
package KnowledgePoints.myInterface.interFalse.myvolatileⅡ;

public class MyThread1 extends Thread {
  @Override
  public void run() {
    while (Money.money == 100000) {

    }

    System.out.println("结婚基金已经不是十万了");
  }
}

```

```java
package KnowledgePoints.myInterface.interFalse.myvolatileⅡ;

public class MyThread2 extends Thread {
  @Override
  public void run() {
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Money.money = 90000;
  }
}

```

**程序问题 :**  女孩虽然知道结婚基金是十万，但是当基金的余额发生变化的时候，女孩无法知道最新的余额。



### 2.2 volatile解决

**以上案例出现的问题 :**

​	当A线程修改了共享数据时，B线程没有及时获取到最新的值，如果还在使用原先的值，就会出现问题

​	hhh，堆内存是唯一的，每一个线程都有自己的线程栈。

​	2 ，每一个线程在使用堆里面变量的时候，都会先拷贝一份到变量的副本中。

​	3 ，在线程中，每一次使用是从变量的副本中获取的。

**Volatile关键字 :** 强制线程每次在使用的时候，都会看一下共享区域最新的值

**代码实现 :** **使用volatile关键字解决**

```java
package KnowledgePoints.myInterface.interFalse.myvolatileⅡ;

public class Ebook.Demo{
public static void main(String[]args){
        MyThread1 t1=new MyThread1();
        t1.setName("小路同学");
        t1.start();

        MyThread2 t2=new MyThread2();
        t2.setName("小皮同学");
        t2.start();
        }
        }
```

```java
package KnowledgePoints.myInterface.interFalse.myvolatileⅡ;

public class Money {
  public static volatile int money = 100000;
}
```

```java
package KnowledgePoints.myInterface.interFalse.myvolatileⅡ;

public class MyThread1 extends Thread {
  @Override
  public void run() {
    while (Money.money == 100000) {

    }

    System.out.println("结婚基金已经不是十万了");
  }
}

```

```java
package KnowledgePoints.myInterface.interFalse.myvolatileⅡ;

public class MyThread2 extends Thread {
  @Override
  public void run() {
    try {
      Thread.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    Money.money = 90000;
  }
}

```



### 2.3 synchronized解决

**synchronized解决 :**

​	hhh ，线程获得锁

​	2 ，清空变量副本

​	3 ，拷贝共享变量最新的值到变量副本中

​	4 ，执行代码

​	5 ，将修改后变量副本中的值赋值给共享数据

​	6 ，释放锁

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.myvolatile2;

public class Ebook.Demo{
public static void main(String[]args){
        MyThread1 t1=new MyThread1();
        t1.setName("小路同学");
        t1.start();

        MyThread2 t2=new MyThread2();
        t2.setName("小皮同学");
        t2.start();
        }
        }
```

```java
package KnowledgePoints.myInterface.interFalse.myvolatile2;

public class Money {
  public static Object lock = new Object();
  public static volatile int money = 100000;
}
```

```java
package KnowledgePoints.myInterface.interFalse.myvolatile2;

public class MyThread1 extends Thread {
  @Override
  public void run() {
    while (true) {
      synchronized (Money.lock) {
        if (Money.money != 100000) {
          System.out.println("结婚基金已经不是十万了");
          break;
        }
      }
    }
  }
}
```

```java
package KnowledgePoints.myInterface.interFalse.myvolatile2;

public class MyThread2 extends Thread {
  @Override
  public void run() {
    synchronized (Money.lock) {
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      Money.money = 90000;
    }
  }
}
```



### 2.4 原子性

**概述 :** 所谓的原子性是指在一次操作或者多次操作中，要么所有的操作全部都得到了执行并且不会受到任何因素的干扰而中断，要么所有的操作都不执行，多个操作是一个不可以分割的整体。

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.threadatom;

public class AtomDemo {
  public static void main(String[] args) {
    MyAtomThread atom = new MyAtomThread();

    for (int i = 0; i < 100; i++) {
      new Thread(atom).start();
    }
  }
}

class MyAtomThread implements Runnable {
  private volatile int count = 0; //送冰淇淋的数量

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      //hhh,从共享数据中读取数据到本线程栈中.
      //2,修改本线程栈中变量副本的值
      //3,会把本线程栈中变量副本的值赋值给共享数据.
      count++;
      System.out.println("已经送了" + count + "个冰淇淋");
    }
  }
}
```

**代码总结 :** count++ 不是一个原子性操作, 他在执行的过程中,有可能被其他线程打断



### 2.5 volatile关键字不能保证原子性

解决方案 : 我们可以给count++操作添加锁，那么count++操作就是临界区中的代码，临界区中的代码一次只能被一个线程去执行，所以count++就变成了原子操作。

```java
package KnowledgePoints.myInterface.interFalse.threadatom2;

public class AtomDemo {
  public static void main(String[] args) {
    MyAtomThread atom = new MyAtomThread();

    for (int i = 0; i < 100; i++) {
      new Thread(atom).start();
    }
  }
}

class MyAtomThread implements Runnable {
  private volatile int count = 0; //送冰淇淋的数量
  private Object lock = new Object();

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      //hhh,从共享数据中读取数据到本线程栈中.
      //2,修改本线程栈中变量副本的值
      //3,会把本线程栈中变量副本的值赋值给共享数据.
      synchronized (lock) {
        count++;
        System.out.println("已经送了" + count + "个冰淇淋");
      }
    }
  }
}
```



### 2.6 原子性_AtomicInteger

概述：java从JDK1.5开始提供了java.util.concurrent.atomic包(简称Atomic包)，这个包中的原子操作类提供了一种用法简单，性能高效，线程安全地更新一个变量的方式。因为变

量的类型有很多种，所以在Atomic包里一共提供了13个类，属于4种类型的原子更新方式，分别是原子更新基本类型、原子更新数组、原子更新引用和原子更新属性(字段)。本次我们只讲解

使用原子的方式更新基本类型，使用原子的方式更新基本类型Atomic包提供了以下3个类：

AtomicBoolean： 原子更新布尔类型

AtomicInteger：   原子更新整型

AtomicLong：	原子更新长整型

以上3个类提供的方法几乎一模一样，所以本节仅以AtomicInteger为例进行讲解，AtomicInteger的常用方法如下：

```java
public AtomicInteger()：	   			    初始化一个默认值为0的原子型Integer
public AtomicInteger(int initialValue)：  初始化一个指定值的原子型Integer

int get():   			 				获取值
int getAndIncrement():      			 以原子方式将当前值加1，注意，这里返回的是自增前的值。
int incrementAndGet():     				 以原子方式将当前值加1，注意，这里返回的是自增后的值。
int addAndGet(int data):				 以原子方式将输入的数值与实例中的值（AtomicInteger里的value）相加，并返回结果。
int getAndSet(int value):   			 以原子方式设置为newValue的值，并返回旧值。
```

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.threadatom3;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomIntergerDemo1 {
  //    public AtomicInteger()：	               初始化一个默认值为0的原子型Integer
//    public AtomicInteger(int initialValue)： 初始化一个指定值的原子型Integer
  public static void main(String[] args) {
    AtomicInteger ac = new AtomicInteger();
    System.out.println(ac);

    AtomicInteger ac2 = new AtomicInteger(10);
    System.out.println(ac2);
  }

}
```

```java
package KnowledgePoints.myInterface.interFalse.threadatom3;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomIntergerDemo2 {
  //    int get():   		 		获取值
//    int getAndIncrement():     以原子方式将当前值加1，注意，这里返回的是自增前的值。
//    int incrementAndGet():     以原子方式将当前值加1，注意，这里返回的是自增后的值。
//    int addAndGet(int data):	 以原子方式将参数与对象中的值相加，并返回结果。
//    int getAndSet(int value):  以原子方式设置为newValue的值，并返回旧值。
  public static void main(String[] args) {
//        AtomicInteger ac1 = new AtomicInteger(10);
//        System.out.println(ac1.get());

//        AtomicInteger ac2 = new AtomicInteger(10);
//        int andIncrement = ac2.getAndIncrement();
//        System.out.println(andIncrement);
//        System.out.println(ac2.get());

//        AtomicInteger ac3 = new AtomicInteger(10);
//        int i = ac3.incrementAndGet();
//        System.out.println(i);//自增后的值
//        System.out.println(ac3.get());

//        AtomicInteger ac4 = new AtomicInteger(10);
//        int i = ac4.addAndGet(20);
//        System.out.println(i);
//        System.out.println(ac4.get());

    AtomicInteger ac5 = new AtomicInteger(100);
    int andSet = ac5.getAndSet(20);
    System.out.println(andSet);
    System.out.println(ac5.get());
  }
}
```



### 2.7 AtomicInteger-内存解析

**AtomicInteger原理 :** 自旋锁  + CAS 算法

**CAS算法：**

​	有3个操作数（内存值V， 旧的预期值A，要修改的值B）

​	当旧的预期值A == 内存值   此时修改成功，将V改为B

​	当旧的预期值A！=内存值   此时修改失败，不做任何操作

​	并重新获取现在的最新值（这个重新获取的动作就是自旋）

### 2.8 AtomicInteger-源码解析

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.threadatom4;

public class AtomDemo {
  public static void main(String[] args) {
    MyAtomThread atom = new MyAtomThread();

    for (int i = 0; i < 100; i++) {
      new Thread(atom).start();
    }
  }
}
```

```java
package KnowledgePoints.myInterface.interFalse.threadatom4;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomThread implements Runnable {
  //private volatile int count = 0; //送冰淇淋的数量
  //private Object lock = new Object();
  AtomicInteger ac = new AtomicInteger(0);

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      //hhh,从共享数据中读取数据到本线程栈中.
      //2,修改本线程栈中变量副本的值
      //3,会把本线程栈中变量副本的值赋值给共享数据.
      //synchronized (lock) {
//                count++;
//                ac++;
      int count = ac.incrementAndGet();
      System.out.println("已经送了" + count + "个冰淇淋");
      // }
    }
  }
}

```

**源码解析 :**

```java

//先自增，然后获取自增后的结果
public final int incrementAndGet() {
        //+ hhh 自增后的结果
        //this 就表示当前的atomicInteger（值）
        //hhh    自增一次
        return U.getAndAddInt(this, VALUE, hhh) + hhh;
}

public final int getAndAddInt(Object o, long offset, int delta) {
        //v 旧值
        int v;
        //自旋的过程
        do {
            //不断的获取旧值
            v = getIntVolatile(o, offset);
            //如果这个方法的返回值为false，那么继续自旋
            //如果这个方法的返回值为true，那么自旋结束
            //o 表示的就是内存值
            //v 旧值
            //v + delta 修改后的值
        } while (!weakCompareAndSetInt(o, offset, v, v + delta));
            //作用：比较内存中的值，旧值是否相等，如果相等就把修改后的值写到内存中，返回true。表示修改成功。
            //                                 如果不相等，无法把修改后的值写到内存中，返回false。表示修改失败。
            //如果修改失败，那么继续自旋。
        return v;
}
```



### 2.9 悲观锁和乐观锁

**synchronized和CAS的区别 :**

**相同点：**在多线程情况下，都可以保证共享数据的安全性。

**不同点：**synchronized总是从最坏的角度出发，认为每次获取数据的时候，别人都有可能修改。所以在每                       次操作共享数据之前，都会上锁。（悲观锁）

​	cas是从乐观的角度出发，假设每次获取数据别人都不会修改，所以不会上锁。只不过在修改共享数据的时候，会检查一下，别人有没有修改过这个数据。

​	如果别人修改过，那么我再次获取现在最新的值。

​	 如果别人没有修改过，那么我现在直接修改共享数据的值.(乐观锁）



## 3. 并发工具类

### 3.hhh 并发工具类-Hashtable

​	**Hashtable出现的原因 :** 在集合类中HashMap是比较常用的集合对象，但是HashMap是线程不安全的(多线程环境下可能会存在问题)。为了保证数据的安全性我们可以使用Hashtable，但是Hashtable的效率低下。

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.mymap;

import java.util.Hashtable;

public class MyHashtableDemo {
  public static void main(String[] args) throws InterruptedException {
    Hashtable<String, String> hm = new Hashtable<>();

    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 25; i++) {
        hm.put(i + "", i + "");
      }
    });


    Thread t2 = new Thread(() -> {
      for (int i = 25; i < 51; i++) {
        hm.put(i + "", i + "");
      }
    });

    t1.start();
    t2.start();

    System.out.println("----------------------------");
    //为了t1和t2能把数据全部添加完毕
    Thread.sleep(1000);

    //0-0 hhh-hhh ..... 50- 50

    for (int i = 0; i < 51; i++) {
      System.out.println(hm.get(i + ""));
    }//0 hhh 2 3 .... 50


  }
}
```



### 3.2 并发工具类-ConcurrentHashMap基本使用

​	**ConcurrentHashMap出现的原因 :** 在集合类中HashMap是比较常用的集合对象，但是HashMap是线程不安全的(多线程环境下可能会存在问题)。为了保证数据的安全性我们可以使用Hashtable，但是Hashtable的效率低下。

基于以上两个原因我们可以使用JDK1.5以后所提供的ConcurrentHashMap。

**体系结构 :**

![1591168965857](.\img\1591168965857.png)

**总结 :**

​	hhh ，HashMap是线程不安全的。多线程环境下会有数据安全问题

​	2 ，Hashtable是线程安全的，但是会将整张表锁起来，效率低下

​	3，ConcurrentHashMap也是线程安全的，效率较高。     在JDK7和JDK8中，底层原理不一样。

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.mymap;

import java.util.concurrent.ConcurrentHashMap;

public class MyConcurrentHashMapDemo {
  public static void main(String[] args) throws InterruptedException {
    ConcurrentHashMap<String, String> hm = new ConcurrentHashMap<>(100);

    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 25; i++) {
        hm.put(i + "", i + "");
      }
    });


    Thread t2 = new Thread(() -> {
      for (int i = 25; i < 51; i++) {
        hm.put(i + "", i + "");
      }
    });

    t1.start();
    t2.start();

    System.out.println("----------------------------");
    //为了t1和t2能把数据全部添加完毕
    Thread.sleep(1000);

    //0-0 hhh-hhh ..... 50- 50

    for (int i = 0; i < 51; i++) {
      System.out.println(hm.get(i + ""));
    }//0 hhh 2 3 .... 50
  }
}
```



### 3.3 并发工具类-ConcurrentHashMap1.7原理

![1591169254280](.\img\1591169254280.png)

### 3.4 并发工具类-ConcurrentHashMap1.8原理

![1591169338256](.\img\1591169338256.png)

**总结 :**

​	hhh，如果使用空参构造创建ConcurrentHashMap对象，则什么事情都不做。     在第一次添加元素的时候创建哈希表

​	2，计算当前元素应存入的索引。

​	3，如果该索引位置为null，则利用cas算法，将本结点添加到数组中。

​	4，如果该索引位置不为null，则利用volatile关键字获得当前位置最新的结点地址，挂在他下面，变成链表。

​	5，当链表的长度大于等于8时，自动转换成红黑树6，以链表或者红黑树头结点为锁对象，配合悲观锁保证多线程操作集合时数据的安全性

### 3.5 并发工具类-CountDownLatch

**CountDownLatch类 :**

| 方法                               | 解释               |
| -------------------------------- | ---------------- |
| public CountDownLatch(int count) | 参数传递线程数，表示等待线程数量 |
| public void await()              | 让线程等待            |
| public void countDown()          | 当前线程执行完毕         |

**使用场景：** 让某一条线程等待其他线程执行完毕之后再执行

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.mycountdownlatch;

import java.util.concurrent.CountDownLatch;

public class ChileThread1 extends Thread {

  private CountDownLatch countDownLatch;

  public ChileThread1(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    //hhh.吃饺子
    for (int i = hhh; i <= 10; i++) {
      System.out.println(getName() + "在吃第" + i + "个饺子");
    }
    //2.吃完说一声
    //每一次countDown方法的时候，就让计数器-hhh
    countDownLatch.countDown();
  }
}

```

```java
package KnowledgePoints.myInterface.interFalse.mycountdownlatch;

import java.util.concurrent.CountDownLatch;

public class ChileThread2 extends Thread {

  private CountDownLatch countDownLatch;

  public ChileThread2(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    //hhh.吃饺子
    for (int i = hhh; i <= 15; i++) {
      System.out.println(getName() + "在吃第" + i + "个饺子");
    }
    //2.吃完说一声
    //每一次countDown方法的时候，就让计数器-hhh
    countDownLatch.countDown();
  }
}

```

```java
package KnowledgePoints.myInterface.interFalse.mycountdownlatch;

import java.util.concurrent.CountDownLatch;

public class ChileThread3 extends Thread {

  private CountDownLatch countDownLatch;

  public ChileThread3(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    //hhh.吃饺子
    for (int i = hhh; i <= 20; i++) {
      System.out.println(getName() + "在吃第" + i + "个饺子");
    }
    //2.吃完说一声
    //每一次countDown方法的时候，就让计数器-hhh
    countDownLatch.countDown();
  }
}

```

```java
package KnowledgePoints.myInterface.interFalse.mycountdownlatch;

import java.util.concurrent.CountDownLatch;

public class MotherThread extends Thread {
  private CountDownLatch countDownLatch;

  public MotherThread(CountDownLatch countDownLatch) {
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run() {
    //hhh.等待
    try {
      //当计数器变成0的时候，会自动唤醒这里等待的线程。
      countDownLatch.await();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    //2.收拾碗筷
    System.out.println("妈妈在收拾碗筷");
  }
}

```

```java
package KnowledgePoints.myInterface.interFalse.mycountdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatchDemo {
  public static void main(String[] args) {
    //hhh.创建CountDownLatch的对象，需要传递给四个线程。
    //在底层就定义了一个计数器，此时计数器的值就是3
    CountDownLatch countDownLatch = new CountDownLatch(3);
    //2.创建四个线程对象并开启他们。
    MotherThread motherThread = new MotherThread(countDownLatch);
    motherThread.start();

    ChileThread1 t1 = new ChileThread1(countDownLatch);
    t1.setName("小明");

    ChileThread2 t2 = new ChileThread2(countDownLatch);
    t2.setName("小红");

    ChileThread3 t3 = new ChileThread3(countDownLatch);
    t3.setName("小刚");

    t1.start();
    t2.start();
    t3.start();
  }
}
```

**总结 :**

​	hhh. CountDownLatch(int count)：参数写等待线程的数量。并定义了一个计数器。

​	2. await()：让线程等待，当计数器为0时，会唤醒等待的线程

​	3. countDown()： 线程执行完毕时调用，会将计数器-hhh。

### 3.6 并发工具类-Semaphore

**使用场景 :**

​	可以控制访问特定资源的线程数量。

**实现步骤 :**

​	hhh，需要有人管理这个通道

​	2，当有车进来了，发通行许可证

​	3，当车出去了，收回通行许可证

​	4，如果通行许可证发完了，那么其他车辆只能等着

**代码实现 :**

```java
package KnowledgePoints.myInterface.interFalse.mysemaphore;

import java.util.concurrent.Semaphore;

public class MyRunnable implements Runnable {
  //hhh.获得管理员对象，
  private Semaphore semaphore = new Semaphore(2);

  @Override
  public void run() {
    //2.获得通行证
    try {
      semaphore.acquire();
      //3.开始行驶
      System.out.println("获得了通行证开始行驶");
      Thread.sleep(2000);
      System.out.println("归还通行证");
      //4.归还通行证
      semaphore.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}

```

```java
package KnowledgePoints.myInterface.interFalse.mysemaphore;

public class MySemaphoreDemo {
  public static void main(String[] args) {
    MyRunnable mr = new MyRunnable();

    for (int i = 0; i < 100; i++) {
      new Thread(mr).start();
    }
  }
}
```



# day16-网络编程

## hhh.网络编程入门

### hhh.hhh 网络编程概述【理解】

- 计算机网络

  是指将地理位置不同的具有独立功能的多台计算机及其外部设备，通过通信线路连接起来，在网络操作系统，网络管理软件及网络通信协议的管理和协调下，实现资源共享和信息传递的计算机系统

- 网络编程

  在网络通信协议下，不同计算机上运行的程序，可以进行数据传输

### hhh.2 网络编程三要素【理解】

- IP地址

  要想让网络中的计算机能够互相通信，必须为每台计算机指定一个标识号，通过这个标识号来指定要接收数据的计算机和识别发送的计算机，而IP地址就是这个标识号。也就是设备的标识

- 端口

  网络的通信，本质上是两个应用程序的通信。每台计算机都有很多的应用程序，那么在网络通信时，如何区分这些应用程序呢？如果说IP地址可以唯一标识网络中的设备，那么端口号就可以唯一标识设备中的应用程序了。也就是应用程序的标识

- 协议

  通过计算机网络可以使多台计算机实现连接，位于同一个网络中的计算机在进行连接和通信时需要遵守一定的规则，这就好比在道路中行驶的汽车一定要遵守交通规则一样。在计算机网络中，这些连接和通信的规则被称为网络通信协议，它对数据的传输格式、传输速率、传输步骤等做了统一规定，通信双方必须同时遵守才能完成数据交换。常见的协议有UDP协议和TCP协议

### hhh.3 IP地址【理解】

IP地址：是网络中设备的唯一标识

- IP地址分为两大类

  - IPv4：是给每个连接在网络上的主机分配一个32bit地址。按照TCP/IP规定，IP地址用二进制来表示，每个IP地址长32bit，也就是4个字节。例如一个采用二进制形式的IP地址是“11000000 10101000 00000001 01000010”，这么长的地址，处理起来也太费劲了。为了方便使用，IP地址经常被写成十进制的形式，中间使用符号“.”分隔不同的字节。于是，上面的IP地址可以表示为“192.168.hhh.66”。IP地址的这种表示法叫做“点分十进制表示法”，这显然比1和0容易记忆得多

  - IPv6：由于互联网的蓬勃发展，IP地址的需求量愈来愈大，但是网络地址资源有限，使得IP的分配越发紧张。为了扩大地址空间，通过IPv6重新定义地址空间，采用128位地址长度，每16个字节一组，分成8组十六进制数，这样就解决了网络地址资源数量不够的问题

- DOS常用命令：

  - ipconfig：查看本机IP地址

  - ping IP地址：检查网络是否连通

- 特殊IP地址：
  - 127.0.0.hhh：是回送地址，可以代表本机地址，一般用来测试使用

### hhh.4 InetAddress【应用】

InetAddress：此类表示Internet协议（IP）地址

- 相关方法

  | 方法名                                      | 说明                               |
  | ---------------------------------------- | -------------------------------- |
  | static InetAddress getByName(String host) | 确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址 |
  | String getHostName()                     | 获取此IP地址的主机名                      |
  | String getHostAddress()                  | 返回文本显示中的IP地址字符串                  |

- 代码演示

  ```java
  public class InetAddressDemo {
      public static void main(String[] args) throws UnknownHostException {
  		//InetAddress address = InetAddress.getByName("KnowledgePoints.myInterface.interFalse");
          InetAddress address = InetAddress.getByName("192.168.hhh.66");

          //public String getHostName()：获取此IP地址的主机名
          String name = address.getHostName();
          //public String getHostAddress()：返回文本显示中的IP地址字符串
          String ip = address.getHostAddress();

          System.out.println("主机名：" + name);
          System.out.println("IP地址：" + ip);
      }
  }
  ```


### hhh.5 端口和协议【理解】

- 端口

  - 设备上应用程序的唯一标识

- 端口号

  - 用两个字节表示的整数，它的取值范围是0~65535。其中，0~1023之间的端口号用于一些知名的网络服务和应用，普通的应用程序需要使用1024以上的端口号。如果端口号被另外一个服务或应用所占用，会导致当前程序启动失败

- 协议

  - 计算机网络中，连接和通信的规则被称为网络通信协议

- UDP协议
  - 用户数据报协议(User Datagram Protocol)
  - UDP是无连接通信协议，即在数据传输时，数据的发送端和接收端不建立逻辑连接。简单来说，当一台计算机向另外一台计算机发送数据时，发送端不会确认接收端是否存在，就会发出数据，同样接收端在收到数据时，也不会向发送端反馈是否收到数据。
  - 由于使用UDP协议消耗系统资源小，通信效率高，所以通常都会用于音频、视频和普通数据的传输
  - 例如视频会议通常采用UDP协议，因为这种情况即使偶尔丢失一两个数据包，也不会对接收结果产生太大影响。但是在使用UDP协议传送数据时，由于UDP的面向无连接性，不能保证数据的完整性，因此在传输重要数据时不建议使用UDP协议

- TCP协议

  - 传输控制协议 (Transmission Control Protocol)

  - TCP协议是面向连接的通信协议，即传输数据之前，在发送端和接收端建立逻辑连接，然后再传输数据，它提供了两台计算机之间可靠无差错的数据传输。在TCP连接中必须要明确客户端与服务器端，由客户端向服务端发出连接请求，每次连接的创建都需要经过“三次握手”

  - 三次握手：TCP协议中，在发送数据的准备阶段，客户端与服务器之间的三次交互，以保证连接的可靠

    第一次握手，客户端向服务器端发出连接请求，等待服务器确认

    第二次握手，服务器端向客户端回送一个响应，通知客户端收到了连接请求

    第三次握手，客户端再次向服务器端发送确认信息，确认连接

  - 完成三次握手，连接建立后，客户端和服务器就可以开始进行数据传输了。由于这种面向连接的特性，TCP协议可以保证传输数据的安全，所以应用十分广泛。例如上传文件、下载文件、浏览网页等

## 2.UDP通信程序

### 2.hhh UDP发送数据【应用】

- Java中的UDP通信
  - UDP协议是一种不可靠的网络协议，它在通信的两端各建立一个Socket对象，但是这两个Socket只是发送，接收数据的对象，因此对于基于UDP协议的通信双方而言，没有所谓的客户端和服务器的概念
  - Java提供了DatagramSocket类作为基于UDP协议的Socket

- 构造方法

  | 方法名                                      | 说明                           |
  | ---------------------------------------- | ---------------------------- |
  | DatagramSocket()                         | 创建数据报套接字并将其绑定到本机地址上的任何可用端口   |
  | DatagramPacket(byte[] buf,int len,InetAddress add,int port) | 创建数据包,发送长度为len的数据包到指定主机的指定端口 |

- 相关方法

  | 方法名                            | 说明          |
  | ------------------------------ | ----------- |
  | void send(DatagramPacket p)    | 发送数据报包      |
  | void close()                   | 关闭数据报套接字    |
  | void receive(DatagramPacket p) | 从此套接字接受数据报包 |

- 发送数据的步骤
  - 创建发送端的Socket对象(DatagramSocket)
  - 创建数据，并把数据打包
  - 调用DatagramSocket对象的方法发送数据
  - 关闭发送端

- 代码演示

  ```java
  public class SendDemo {
      public static void main(String[] args) throws IOException {
          //创建发送端的Socket对象(DatagramSocket)
          // DatagramSocket() 构造数据报套接字并将其绑定到本地主机上的任何可用端口
          DatagramSocket ds = new DatagramSocket();

          //创建数据，并把数据打包
          //DatagramPacket(byte[] buf, int length, InetAddress address, int port)
          //构造一个数据包，发送长度为 length的数据包到指定主机上的指定端口号。
          byte[] bys = "hello,udp,我来了".getBytes();

          DatagramPacket dp = new DatagramPacket(bys,bys.length,InetAddress.getByName("127.0.0.hhh"),10086);

          //调用DatagramSocket对象的方法发送数据
          //void send(DatagramPacket p) 从此套接字发送数据报包
          ds.send(dp);

          //关闭发送端
          //void close() 关闭此数据报套接字
          ds.close();
      }
  }
  ```

### 2.2UDP接收数据【应用】

- 接收数据的步骤
  - 创建接收端的Socket对象(DatagramSocket)
  - 创建一个数据包，用于接收数据
  - 调用DatagramSocket对象的方法接收数据
  - 解析数据包，并把数据在控制台显示
  - 关闭接收端

- 构造方法

  | 方法名                                 | 说明                               |
  | ----------------------------------- | -------------------------------- |
  | DatagramPacket(byte[] buf, int len) | 创建一个DatagramPacket用于接收长度为len的数据包 |

- 相关方法

  | 方法名               | 说明                   |
  | ----------------- | -------------------- |
  | byte[]  getData() | 返回数据缓冲区              |
  | int  getLength()  | 返回要发送的数据的长度或接收的数据的长度 |

- 示例代码

  ```java
  public class ReceiveDemo {
      public static void main(String[] args) throws IOException {
        	//创建接收端的Socket对象(DatagramSocket)
        	DatagramSocket ds = new DatagramSocket(12345);

        	//创建一个数据包，用于接收数据
        	byte[] bys = new byte[1024];
        	DatagramPacket dp = new DatagramPacket(bys, bys.length);

        	//调用DatagramSocket对象的方法接收数据
        	ds.receive(dp);

        	//解析数据包，并把数据在控制台显示
        	System.out.println("数据是：" + new String(dp.getData(), 0,                                             dp.getLength()));
          }
      }
  }
  ```

### 2.3UDP通信程序练习【应用】

- 案例需求

  UDP发送数据：数据来自于键盘录入，直到输入的数据是886，发送数据结束

  UDP接收数据：因为接收端不知道发送端什么时候停止发送，故采用死循环接收

- 代码实现

  ```java
  /*
      UDP发送数据：
          数据来自于键盘录入，直到输入的数据是886，发送数据结束
   */
  public class SendDemo {
      public static void main(String[] args) throws IOException {
          //创建发送端的Socket对象(DatagramSocket)
          DatagramSocket ds = new DatagramSocket();
          //键盘录入数据
          Scanner sc = new Scanner(System.in);
          while (true) {
            	String s = sc.nextLine();
              //输入的数据是886，发送数据结束
              if ("886".equals(s)) {
                  break;
              }
              //创建数据，并把数据打包
              byte[] bys = s.getBytes();
              DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("192.168.hhh.66"), 12345);

              //调用DatagramSocket对象的方法发送数据
              ds.send(dp);
          }
          //关闭发送端
          ds.close();
      }
  }

  /*
      UDP接收数据：
          因为接收端不知道发送端什么时候停止发送，故采用死循环接收
   */
  public class ReceiveDemo {
      public static void main(String[] args) throws IOException {
          //创建接收端的Socket对象(DatagramSocket)
          DatagramSocket ds = new DatagramSocket(12345);
          while (true) {
              //创建一个数据包，用于接收数据
              byte[] bys = new byte[1024];
              DatagramPacket dp = new DatagramPacket(bys, bys.length);
              //调用DatagramSocket对象的方法接收数据
              ds.receive(dp);
              //解析数据包，并把数据在控制台显示
              System.out.println("数据是：" + new String(dp.getData(), 0, dp.getLength()));
          }
          //关闭接收端
  //        ds.close();
      }
  }
  ```


### 2.4UDP三种通讯方式【理解】

+ 单播

  单播用于两个主机之间的端对端通信

+ 组播

  组播用于对一组特定的主机进行通信

+ 广播

  广播用于一个主机对整个局域网上所有主机上的数据通信

### 2.5UDP组播实现【理解】

+ 实现步骤

  + 发送端
    hhh. 创建发送端的Socket对象(DatagramSocket)
    2. 创建数据，并把数据打包(DatagramPacket)
    3. 调用DatagramSocket对象的方法发送数据(在单播中,这里是发给指定IP的电脑但是在组播当中,这里是发给组播地址)
    4. 释放资源
  + 接收端
    hhh. 创建接收端Socket对象(MulticastSocket)
    2. 创建一个箱子,用于接收数据
    3. 把当前计算机绑定一个组播地址
    4. 将数据接收到箱子中
    5. 解析数据包,并打印数据
    6. 释放资源

+ 代码实现

  ```java
  // 发送端
  public class ClinetDemo {
      public static void main(String[] args) throws IOException {
          // hhh. 创建发送端的Socket对象(DatagramSocket)
          DatagramSocket ds = new DatagramSocket();
          String s = "hello 组播";
          byte[] bytes = s.getBytes();
          InetAddress address = InetAddress.getByName("224.0.hhh.0");
          int port = 10000;
          // 2. 创建数据，并把数据打包(DatagramPacket)
          DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
          // 3. 调用DatagramSocket对象的方法发送数据(在单播中,这里是发给指定IP的电脑但是在组播当中,这里是发给组播地址)
          ds.send(dp);
          // 4. 释放资源
          ds.close();
      }
  }
  // 接收端
  public class ServerDemo {
      public static void main(String[] args) throws IOException {
          // hhh. 创建接收端Socket对象(MulticastSocket)
          MulticastSocket ms = new MulticastSocket(10000);
          // 2. 创建一个箱子,用于接收数据
          DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
          // 3. 把当前计算机绑定一个组播地址,表示添加到这一组中.
          ms.joinGroup(InetAddress.getByName("224.0.hhh.0"));
          // 4. 将数据接收到箱子中
          ms.receive(dp);
          // 5. 解析数据包,并打印数据
          byte[] data = dp.getData();
          int length = dp.getLength();
          System.out.println(new String(data,0,length));
          // 6. 释放资源
          ms.close();
      }
  }
  ```

### 2.6UDP广播实现【理解】

+ 实现步骤

  + 发送端
    hhh. 创建发送端Socket对象(DatagramSocket)
    2. 创建存储数据的箱子,将广播地址封装进去
    3. 发送数据
    4. 释放资源
  + 接收端
    hhh. 创建接收端的Socket对象(DatagramSocket)
    2. 创建一个数据包，用于接收数据
    3. 调用DatagramSocket对象的方法接收数据
    4. 解析数据包，并把数据在控制台显示
    5. 关闭接收端

+ 代码实现

  ```java
  // 发送端
  public class ClientDemo {
      public static void main(String[] args) throws IOException {
        	// hhh. 创建发送端Socket对象(DatagramSocket)
          DatagramSocket ds = new DatagramSocket();
  		// 2. 创建存储数据的箱子,将广播地址封装进去
          String s = "广播 hello";
          byte[] bytes = s.getBytes();
          InetAddress address = InetAddress.getByName("255.255.255.255");
          int port = 10000;
          DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);
  		// 3. 发送数据
          ds.send(dp);
  		// 4. 释放资源
          ds.close();
      }
  }
  // 接收端
  public class ServerDemo {
      public static void main(String[] args) throws IOException {
          // hhh. 创建接收端的Socket对象(DatagramSocket)
          DatagramSocket ds = new DatagramSocket(10000);
          // 2. 创建一个数据包，用于接收数据
          DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
          // 3. 调用DatagramSocket对象的方法接收数据
          ds.receive(dp);
          // 4. 解析数据包，并把数据在控制台显示
          byte[] data = dp.getData();
          int length = dp.getLength();
          System.out.println(new String(data,0,length));
          // 5. 关闭接收端
          ds.close();
      }
  }
  ```


## 3.TCP通信程序

### 3.1TCP发送数据【应用】

- Java中的TCP通信

  - Java对基于TCP协议的的网络提供了良好的封装，使用Socket对象来代表两端的通信端口，并通过Socket产生IO流来进行网络通信。
  - Java为客户端提供了Socket类，为服务器端提供了ServerSocket类

- 构造方法

  | 方法名                                  | 说明                      |
  | ------------------------------------ | ----------------------- |
  | Socket(InetAddress address,int port) | 创建流套接字并将其连接到指定IP指定端口号   |
  | Socket(String host, int port)        | 创建流套接字并将其连接到指定主机上的指定端口号 |

- 相关方法

  | 方法名                            | 说明         |
  | ------------------------------ | ---------- |
  | InputStream  getInputStream()  | 返回此套接字的输入流 |
  | OutputStream getOutputStream() | 返回此套接字的输出流 |

- 示例代码

  ```java
  public class ClientDemo {
      public static void main(String[] args) throws IOException {
          //创建客户端的Socket对象(Socket)
          //Socket(String host, int port) 创建流套接字并将其连接到指定主机上的指定端口号
          Socket s = new Socket("127.0.0.hhh",10000);

          //获取输出流，写数据
          //OutputStream getOutputStream() 返回此套接字的输出流
          OutputStream os = s.getOutputStream();
          os.write("hello,tcp,我来了".getBytes());

          //释放资源
          s.close();
      }
  }
  ```

### 3.2TCP接收数据【应用】

- 构造方法

  | 方法名                     | 说明               |
  | ----------------------- | ---------------- |
  | ServletSocket(int port) | 创建绑定到指定端口的服务器套接字 |

- 相关方法

  | 方法名             | 说明              |
  | --------------- | --------------- |
  | Socket accept() | 监听要连接到此的套接字并接受它 |

- 注意事项

  hhh. accept方法是阻塞的,作用就是等待客户端连接
  2. 客户端创建对象并连接服务器,此时是通过三次握手协议,保证跟服务器之间的连接
  3. 针对客户端来讲,是往外写的,所以是输出流
     针对服务器来讲,是往里读的,所以是输入流
  4. read方法也是阻塞的
  5. 客户端在关流的时候,还多了一个往服务器写结束标记的动作
  6. 最后一步断开连接,通过四次挥手协议保证连接终止

- 三次握手和四次挥手

  - 三次握手

    ![07_TCP三次握手](.\img\07_TCP三次握手.png)

  - 四次挥手

    ![08_TCP四次挥手](.\img\08_TCP四次挥手.png)


- 示例代码

  ```java
  public class ServerDemo {
      public static void main(String[] args) throws IOException {
          //创建服务器端的Socket对象(ServerSocket)
          //ServerSocket(int port) 创建绑定到指定端口的服务器套接字
          ServerSocket ss = new ServerSocket(10000);

          //Socket accept() 侦听要连接到此套接字并接受它
          Socket s = ss.accept();

          //获取输入流，读数据，并把数据显示在控制台
          InputStream is = s.getInputStream();
          byte[] bys = new byte[1024];
          int len = is.read(bys);
          String data = new String(bys,0,len);
          System.out.println("数据是：" + data);

          //释放资源
          s.close();
          ss.close();
      }
  }
  ```

### 3.3TCP程序练习【应用】

- 案例需求

  客户端：发送数据，接受服务器反馈

  服务器：收到消息后给出反馈

- 案例分析
  - 客户端创建对象，使用输出流输出数据
  - 服务端创建对象，使用输入流接受数据
  - 服务端使用输出流给出反馈数据
  - 客户端使用输入流接受反馈数据

- 代码实现

  ```java
  // 客户端
  public class ClientDemo {
      public static void main(String[] args) throws IOException {
          Socket socket = new Socket("127.0.0.hhh",10000);

          OutputStream os = socket.getOutputStream();
          os.write("hello".getBytes());
         // os.close();如果在这里关流,会导致整个socket都无法使用
          socket.shutdownOutput();//仅仅关闭输出流.并写一个结束标记,对socket没有任何影响

          BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          String line;
          while((line = br.readLine())!=null){
              System.out.println(line);
          }
          br.close();
          os.close();
          socket.close();
      }
  }
  // 服务器
  public class ServerDemo {
      public static void main(String[] args) throws IOException {
          ServerSocket ss = new ServerSocket(10000);

          Socket accept = ss.accept();

          InputStream is = accept.getInputStream();
          int b;
          while((b = is.read())!=-hhh){
              System.out.println((char) b);
          }

          System.out.println("看看我执行了吗?");

          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
          bw.write("你谁啊?");
          bw.newLine();
          bw.flush();

          bw.close();
          is.close();
          accept.close();
          ss.close();
      }
  }
  ```

### 3.4TCP程序文件上传练习【应用】

- 案例需求

  客户端：数据来自于本地文件，接收服务器反馈

  服务器：接收到的数据写入本地文件，给出反馈

- 案例分析
  - 创建客户端对象，创建输入流对象指向文件，每读一次数据就给服务器输出一次数据，输出结束后使用shutdownOutput()方法告知服务端传输结束
  - 创建服务器对象，创建输出流对象指向文件，每接受一次数据就使用输出流输出到文件中，传输结束后。使用输出流给客户端反馈信息
  - 客户端接受服务端的回馈信息

- 相关方法

  | 方法名                   | 说明                 |
  | --------------------- | ------------------ |
  | void shutdownInput()  | 将此套接字的输入流放置在“流的末尾” |
  | void shutdownOutput() | 禁止用此套接字的输出流        |

- 代码实现

  ```java
  // 客户端
  public class ClientDemo {
      public static void main(String[] args) throws IOException {
          Socket socket = new Socket("127.0.0.hhh",10000);

          //是本地的流,用来读取本地文件的.
          BufferedInputStream bis = new BufferedInputStream(new FileInputStream("socketmodule\\ClientDir\\hhh.jpg"));

          //写到服务器 --- 网络中的流
          OutputStream os = socket.getOutputStream();
          BufferedOutputStream bos = new BufferedOutputStream(os);

          int b;
          while((b = bis.read())!=-hhh){
              bos.write(b);//通过网络写到服务器中
          }
          bos.flush();
          //给服务器一个结束标记,告诉服务器文件已经传输完毕
          socket.shutdownOutput();

          BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
          String line;
          while((line = br.readLine()) !=null){
              System.out.println(line);
          }
          bis.close();
          socket.close();
      }
  }
  // 服务器
  public class ServerDemo {
      public static void main(String[] args) throws IOException {
          ServerSocket ss = new ServerSocket(10000);

          Socket accept = ss.accept();

          //网络中的流,从客户端读取数据的
          BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
          //本地的IO流,把数据写到本地中,实现永久化存储
          BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("socketmodule\\ServerDir\\copy.jpg"));

          int b;
          while((b = bis.read()) !=-hhh){
              bos.write(b);
          }

          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
          bw.write("上传成功");
          bw.newLine();
          bw.flush();

          bos.close();
          accept.close();
          ss.close();
      }
  }
  ```

### 3.5TCP程序服务器优化【应用】

- 优化方案一

  + 需求

    服务器只能处理一个客户端请求，接收完一个图片之后，服务器就关闭了。

  + 解决方案

    使用循环

  + 代码实现

    ```java
    // 服务器代码如下,客户端代码同上个案例,此处不再给出
    public class ServerDemo {
        public static void main(String[] args) throws IOException {
            ServerSocket ss = new ServerSocket(10000);

            while (true) {
                Socket accept = ss.accept();

                //网络中的流,从客户端读取数据的
                BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                //本地的IO流,把数据写到本地中,实现永久化存储
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("optimizeserver\\ServerDir\\copy.jpg"));

                int b;
                while((b = bis.read()) !=-hhh){
                    bos.write(b);
                }

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                bw.write("上传成功");
                bw.newLine();
                bw.flush();

                bos.close();
                accept.close();
            }
            //ss.close();

        }
    }
    ```

- 优化方案二

  + 需求

    第二次上传文件的时候，会把第一次的文件给覆盖。

  + 解决方案

    UUID. randomUUID()方法生成随机的文件名

  + 代码实现

    ```java
    // 服务器代码如下,客户端代码同上个案例,此处不再给出
    public class ServerDemo {
        public static void main(String[] args) throws IOException {
            ServerSocket ss = new ServerSocket(10000);

            while (true) {
                Socket accept = ss.accept();

                //网络中的流,从客户端读取数据的
                BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
                //本地的IO流,把数据写到本地中,实现永久化存储
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("optimizeserver\\ServerDir\\" + UUID.randomUUID().toString() + ".jpg"));

                int b;
                while((b = bis.read()) !=-hhh){
                    bos.write(b);
                }

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                bw.write("上传成功");
                bw.newLine();
                bw.flush();

                bos.close();
                accept.close();
            }
            //ss.close();

        }
    }
    ```

- 优化方案三

  - 需求

    使用循环虽然可以让服务器处理多个客户端请求。但是还是无法同时跟多个客户端进行通信。

  - 解决方案

    开启多线程处理

  - 代码实现

    ```java
    // 线程任务类
    public class ThreadSocket implements Runnable {
        private Socket acceptSocket;

        public ThreadSocket(Socket accept) {
            this.acceptSocket = accept;
        }

        @Override
        public void run() {
            BufferedOutputStream bos = null;
            try {
                //网络中的流,从客户端读取数据的
                BufferedInputStream bis = new BufferedInputStream(acceptSocket.getInputStream());
                //本地的IO流,把数据写到本地中,实现永久化存储
                bos = new BufferedOutputStream(new FileOutputStream("optimizeserver\\ServerDir\\" + UUID.randomUUID().toString() + ".jpg"));

                int b;
                while((b = bis.read()) !=-hhh){
                    bos.write(b);
                }

                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
                bw.write("上传成功");
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(bos != null){
                    try {
                        bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (acceptSocket != null){
                    try {
                        acceptSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    // 服务器代码
    public class ServerDemo {
        public static void main(String[] args) throws IOException {
            ServerSocket ss = new ServerSocket(10000);

            while (true) {
                Socket accept = ss.accept();
                ThreadSocket ts = new ThreadSocket(accept);
                new Thread(ts).start();
            }
            //ss.close();
        }
    }
    ```

- 优化方案四

  - 需求

    使用多线程虽然可以让服务器同时处理多个客户端请求。但是资源消耗太大。

  - 解决方案

    加入线程池

  - 代码实现

    ```java
    // 服务器代码如下,线程任务类代码同上,此处不再给出
    public class ServerDemo {
        public static void main(String[] args) throws IOException {
            ServerSocket ss = new ServerSocket(10000);
            ThreadPoolExecutor pool = new ThreadPoolExecutor(
                    3,//核心线程数量
                    10,   //线程池的总数量
                    60,   //临时线程空闲时间
                    TimeUnit.SECONDS, //临时线程空闲时间的单位
                    new ArrayBlockingQueue<>(5),//阻塞队列
                    Executors.defaultThreadFactory(),//创建线程的方式
                    new ThreadPoolExecutor.AbortPolicy()//任务拒绝策略
            );

            while (true) {
                Socket accept = ss.accept();
                ThreadSocket ts = new ThreadSocket(accept);
                //new Thread(ts).start();
                pool.submit(ts);
            }
            //ss.close();
        }
    }
    ```


# day17-基础加强

## hhh.类加载器

### hhh.1类加载器【理解】

+ 作用

  负责将.class文件（存储的物理文件）加载在到内存中

  ![01_类加载器](.\img\01_类加载器.png)

### hhh.2类加载的过程【理解】

+ 类加载时机

  + 创建类的实例（对象）
  + 调用类的类方法
  + 访问类或者接口的类变量，或者为该类变量赋值
  + 使用反射方式来强制创建某个类或接口对应的java.lang.Class对象
  + 初始化某个类的子类
  + 直接使用java.exe命令来运行某个主类

+ 类加载过程

  hhh. 加载

     + 通过包名 + 类名，获取这个类，准备用流进行传输
     + 在这个类加载到内存中
     + 加载完毕创建一个class对象

     ![02_类加载过程加载](.\img\02_类加载过程加载.png)

  2. 链接

     + 验证

       确保Class文件字节流中包含的信息符合当前虚拟机的要求，并且不会危害虚拟机自身安全

       (文件中的信息是否符合虚拟机规范有没有安全隐患)

     ![03_类加载过程验证](.\img\03_类加载过程验证.png)

     + 准备

       负责为类的类变量（被static修饰的变量）分配内存，并设置默认初始化值

       (初始化静态变量)

     ![04_类加载过程准备](.\img\04_类加载过程准备.png)

     + 解析

       将类的二进制数据流中的符号引用替换为直接引用

       (本类中如果用到了其他类，此时就需要找到对应的类)

     ![05_类加载过程解析](.\img\05_类加载过程解析.png)

  3. 初始化

     根据程序员通过程序制定的主观计划去初始化类变量和其他资源

     (静态变量赋值以及初始化其他资源)

     ![06_类加载过程初始化](.\img\06_类加载过程初始化.png)

+ 小结

  + 当一个类被使用的时候，才会加载到内存
  + 类加载的过程: 加载、验证、准备、解析、初始化

### hhh.3类加载的分类【理解】

+ 分类
  + Bootstrap class loader：虚拟机的内置类加载器，通常表示为null ，并且没有父null
  + Platform class loader：平台类加载器,负责加载JDK中一些特殊的模块
  + System class loader：系统类加载器,负责加载用户类路径上所指定的类库

+ 类加载器的继承关系

  + System的父加载器为Platform
  + Platform的父加载器为Bootstrap

+ 代码演示

  ```java
  public class ClassLoaderDemo1 {
      public static void main(String[] args) {
          //获取系统类加载器
          ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

          //获取系统类加载器的父加载器 --- 平台类加载器
          ClassLoader classLoader1 = systemClassLoader.getParent();

          //获取平台类加载器的父加载器 --- 启动类加载器
          ClassLoader classLoader2 = classLoader1.getParent();

          System.out.println("系统类加载器" + systemClassLoader);
          System.out.println("平台类加载器" + classLoader1);
          System.out.println("启动类加载器" + classLoader2);

      }
  }
  ```

### hhh.4双亲委派模型【理解】

+ 介绍

  如果一个类加载器收到了类加载请求，它并不会自己先去加载，而是把这个请求委托给父类的加载器去执行，如果父类加载器还存在其父类加载器，则进一步向上委托，依次递归，请求最终将到达顶层的启动类加载器，如果父类加载器可以完成类加载任务，就成功返回，倘若父类加载器无法完成此加载任务，子加载器才会尝试自己去加载，这就是双亲委派模式

  ![07_双亲委派模型](.\img\07_双亲委派模型.png)


### hhh.5ClassLoader 中的两个方法【应用】

- 方法介绍

  | 方法名                                      | 说明        |
  | ---------------------------------------- | --------- |
  | public static ClassLoader getSystemClassLoader() | 获取系统类加载器  |
  | public InputStream getResourceAsStream(String name) | 加载某一个资源文件 |

- 示例代码

  ```java
  public class ClassLoaderDemo2 {
      public static void main(String[] args) throws IOException {
          //static ClassLoader getSystemClassLoader() 获取系统类加载器
          //InputStream getResourceAsStream(String name)  加载某一个资源文件

          //获取系统类加载器
          ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

          //利用加载器去加载一个指定的文件
          //参数：文件的路径（放在src的根目录下，默认去那里加载）
          //返回值：字节流。
          InputStream is = systemClassLoader.getResourceAsStream("prop.properties");

          Properties prop = new Properties();
          prop.load(is);

          System.out.println(prop);

          is.close();
      }
  }
  ```

## 2.反射

### 2.1反射的概述【理解】

+ 反射机制

  是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
  对于任意一个对象，都能够调用它的任意属性和方法；
  这种动态获取信息以及动态调用对象方法的功能称为Java语言的反射机制。

### 2.2获取Class类对象的三种方式【应用】

+ 三种方式分类
  + 类名.class属性

  + 对象名.getClass()方法

  + Class.forName(全类名)方法

    

  ![08_获取Class对象的三种方式](.\img\08_获取Class对象的三种方式.png)

+ 示例代码

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student {
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
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

      public void study(){
          System.out.println("学生在学习");
      }

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }
  public class ReflectDemo5 {
      public static void main(String[] args) throws ClassNotFoundException {
          //hhh.Class类中的静态方法forName("全类名")
              //全类名:包名 + 类名
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect2.Test22.D19.Ebook.D5.DemoTostring.Student");
          System.out.println(clazz);

          //2.通过class属性来获取
          Class clazz2 = Test22.D19.Ebook.D5.DemoTostring.Student.class;
          System.out.println(clazz2);

          //3.利用对象的getClass方法来获取class对象
          //getClass方法是定义在Object类中.
          Test22.D19.Ebook.D5.DemoTostring.Student s = new Test22.D19.Ebook.D5.DemoTostring.Student();
          Class clazz3 = s.getClass();
          System.out.println(clazz3);

          System.out.println(clazz == clazz2);
          System.out.println(clazz2 == clazz3);
      }
  }
  ```

### 2.3反射获取构造方法并使用【应用】

#### 2.3.1Class类获取构造方法对象的方法

- 方法介绍

  | 方法名                                      | 说明              |
  | ---------------------------------------- | --------------- |
  | Constructor<?>[] getConstructors()       | 返回所有公共构造方法对象的数组 |
  | Constructor<?>[] getDeclaredConstructors() | 返回所有构造方法对象的数组   |
  | Constructor<T> getConstructor(Class<?>... parameterTypes) | 返回单个公共构造方法对象    |
  | Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) | 返回单个构造方法对象      |

- 示例代码

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student {
      private String name;
      private int age;

      //私有的有参构造方法
      private Test22.D19.Ebook.D5.DemoTostring.Student(String name) {
          System.out.println("name的值为:" + name);
          System.out.println("private...Test22.D19.Ebook.D5.DemoTostring.Student...有参构造方法");
      }

      //公共的无参构造方法
      public Test22.D19.Ebook.D5.DemoTostring.Student() {
          System.out.println("public...Test22.D19.Ebook.D5.DemoTostring.Student...无参构造方法");
      }

      //公共的有参构造方法
      public Test22.D19.Ebook.D5.DemoTostring.Student(String name, int age) {
          System.out.println("name的值为:" + name + "age的值为:" + age);
          System.out.println("public...Test22.D19.Ebook.D5.DemoTostring.Student...有参构造方法");
      }
  }
  public class ReflectDemo5 {
      public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
          //method1();
          //method2();
          //method3();
          //method4();
      }

      private static void method4() throws ClassNotFoundException, NoSuchMethodException {
          //        Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)：
  //                                      返回单个构造方法对象
          //hhh.获取Class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect3.Test22.D19.Ebook.D5.DemoTostring.Student");
          Constructor constructor = clazz.getDeclaredConstructor(String.class);
          System.out.println(constructor);
      }

      private static void method3() throws ClassNotFoundException, NoSuchMethodException {
          //        Constructor<T> getConstructor(Class<?>... parameterTypes)：
  //                                      返回单个公共构造方法对象
          //hhh.获取Class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect3.Test22.D19.Ebook.D5.DemoTostring.Student");
          //小括号中,一定要跟构造方法的形参保持一致.
          Constructor constructor1 = clazz.getConstructor();
          System.out.println(constructor1);

          Constructor constructor2 = clazz.getConstructor(String.class, int.class);
          System.out.println(constructor2);

          //因为Student类中,没有只有一个int的构造,所以这里会报错.
          Constructor constructor3 = clazz.getConstructor(int.class);
          System.out.println(constructor3);
      }

      private static void method2() throws ClassNotFoundException {
          //        Constructor<?>[] getDeclaredConstructors()：
  //                                      返回所有构造方法对象的数组
          //hhh.获取Class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect3.Test22.D19.Ebook.D5.DemoTostring.Student");

          Constructor[] constructors = clazz.getDeclaredConstructors();
          for (Constructor constructor : constructors) {
              System.out.println(constructor);
          }
      }

      private static void method1() throws ClassNotFoundException {
          //        Constructor<?>[] getConstructors()：
  //                                      返回所有公共构造方法对象的数组
          //hhh.获取Class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect3.Test22.D19.Ebook.D5.DemoTostring.Student");
          Constructor[] constructors = clazz.getConstructors();
          for (Constructor constructor : constructors) {
              System.out.println(constructor);
          }
      }
  }
  ```

#### 2.3.2Constructor类用于创建对象的方法

+ 方法介绍

  | 方法名                              | 说明               |
  | -------------------------------- | ---------------- |
  | T newInstance(Object...initargs) | 根据指定的构造方法创建对象    |
  | setAccessible(boolean flag)      | 设置为true,表示取消访问检查 |

+ 示例代码

  ```java
  // Student类同上一个示例,这里就不在重复提供了
  public class ReflectDemo2 {
      public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
          //T newInstance(Object... initargs)：根据指定的构造方法创建对象
          //method1();
          //method2();
          //method3();
          //method4();

      }

      private static void method4() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
          //获取一个私有的构造方法并创建对象
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect3.Ebook.D5.DemoTostring.Student");

          //2.获取Test.D19.Student造方法.
          Constructor constructor = clazz.getDeclaredConstructor(String.class);

          //被private修饰的成员,不能直接使用的
          //如果用反射强行获取并使用,需要临时取消访问检查
          constructor.setAccessible(true);

          //3.直接创建对象
          Ebook.D5.DemoTostring.Student student = (Ebook.D5.DemoTostring.Student) constructor.newInstance("zhangsan");

          System.out.println(student);
      }

      private static void method3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
          //简写格式
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect3.Ebook.D5.DemoTostring.Student");

          //2.在Class类中Test.D19.StudentInstance方法,可以利用空参直接创建一个对象
          Ebook.D5.DemoTostring.Student student = (Ebook.D5.DemoTostring.Student) clazz.newInstance();//这个方法现在已经过时了,了解一下

          System.out.println(student);
      }

      private static void method2() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect3.Ebook.D5.DemoTostring.Student");

          //2.获取构造方法对象Test.D19.Ebook.D5.DemoTostring.Student    Constructor constructor = clazz.getConstructor();

          //3.利用空参来创建Student的对象
          Ebook.D5.DemoTostring.Student student = (Ebook.D5.DemoTostring.Student) constructor.newInstance();

          System.out.println(student);
      }

      private static void method1() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect3.Ebook.D5.DemoTostring.Student");

          //2.获取构造方法对象Test.D19.Ebook.D5.DemoTostring.Student    Constructor constructor = clazz.getConstructor(String.class, int.class);

          //3.利用newInstance创建Student的对象
          Ebook.D5.DemoTostring.Student student = (Ebook.D5.DemoTostring.Student) constructor.newInstance("zhangsan", 23);

          System.out.println(student);
      }
  }
  ```

#### 2.3.3小结

+ 获取class对象

  三种方式: Class.forName(“全类名”), 类名.class, 对象名.getClass()

+ 获取里面的构造方法对象

  getConstructor (Class<?>... parameterTypes)
  getDeclaredConstructor (Class<?>... parameterTypes)

+ 如果是public的，直接创建对象

  newInstance(Object... initargs)

+ 如果是非public的，需要临时取消检查，然后再创建对象

  setAccessible(boolean)  暴力反射

### 2.4反射获取成员变量并使用【应用】

#### 2.4.1Class类获取成员变量对象的方法

- 方法分类

  | 方法名                                 | 说明              |
  | ----------------------------------- | --------------- |
  | Field[] getFields()                 | 返回所有公共成员变量对象的数组 |
  | Field[] getDeclaredFields()         | 返回所有成员变量对象的数组   |
  | Field getField(String name)         | 返回单个公共成员变量对象    |
  | Field getDeclaredField(String name) | 返回单个成员变量对象      |

- 示例代码

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student {

      public String name;

      public int age;

      public String gender;

      private int money = 300;

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "name='" + name + '\'' +
                  ", age=" + age +
                  ", gender='" + gender + '\'' +
                  ", money=" + money +
                  '}';
      }
  }
  public class ReflectDemo5 {
      public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
         // method1();
          //method2();
          //method3();
          //method4();

      }

      private static void method4() throws ClassNotFoundException, NoSuchFieldException {
          //        Field getDeclaredField(String name)：返回单个成员变量对象
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect4.Test22.D19.Ebook.D5.DemoTostring.Student");

          //2.获取money成员变量
          Field field = clazz.getDeclaredField("money");

          //3.打印一下
          System.out.println(field);
      }

      private static void method3() throws ClassNotFoundException, NoSuchFieldException {
          //        Field getField(String name)：返回单个公共成员变量对象
          //想要获取的成员变量必须是真实存在的
          //且必须是public修饰的.
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect4.Test22.D19.Ebook.D5.DemoTostring.Student");

          //2.获取name这个成员变量
          //Field field = clazz.getField("name");
          //Field field = clazz.getField("name1");
          Field field = clazz.getField("money");

          //3.打印一下
          System.out.println(field);
      }

      private static void method2() throws ClassNotFoundException {
          //        Field[] getDeclaredFields()：返回所有成员变量对象的数组
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect4.Test22.D19.Ebook.D5.DemoTostring.Student");

          //2.获取所有的Field对象
          Field[] fields = clazz.getDeclaredFields();

          //3.遍历
          for (Field field : fields) {
              System.out.println(field);
          }
      }

      private static void method1() throws ClassNotFoundException {
          //        Field[] getFields()：返回所有公共成员变量对象的数组

          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect4.Test22.D19.Ebook.D5.DemoTostring.Student");

          //2.获取Field对象.
          Field[] fields = clazz.getFields();

          //3.遍历
          for (Field field : fields) {
              System.out.println(field);
          }
      }
  }
  ```

#### 2.4.2Field类用于给成员变量赋值的方法

+ 方法介绍

  | 方法名                                | 说明   |
  | ---------------------------------- | ---- |
  | void set(Object obj, Object value) | 赋值   |
  | Object get(Object obj)             | 获取值  |

+ 示例代码

  ```java
  // Student类同上一个示例,这里就不在重复提供了
  public class ReflectDemo2 {
      public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
  //        Object get(Object obj) 返回由该 Field表示的字段在指定对象上的值。
          //method1();
          //method2();

      }

      private static void method2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect4.Ebook.D5.DemoTostring.Student");

          Test22.D19.Student员变量Field的对象
          Field field = clazz.getDeclaredField("money");

          //3.取消一下访问检查
          field.setAccessible(true);

          //4.调用get方法来获取值
          //4.1创建一个对象
          Ebook.D5.DemoTostring.Student student = (Ebook.D5.DemoTostring.Student) clazz.newInstance();
          //4.2获取指定对象的money的值
          Object o = field.get(student);

          //5.打印一下
          System.out.println(o);
      }

      private static void method1() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {
          //        void set(Object obj, Object value)：给obj对象的成员变量赋值为value
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect4.Ebook.D5.DemoTostring.Student");

          //2.获取name这个Test.D19.Ebook.D5.DemoTostring.Student
          Field field = clazz.getField("name");

          //3.利用set方法进行赋值.
          //3.1先创建一个Student对象
          Ebook.D5.DemoTostring.Student student = (Ebook.D5.DemoTostring.Student) clazz.newInstance();
          //3.2有了对象才可以给指定对象进行赋值
          field.set(student,"zhangsan");

          System.out.println(student);
      }
  }
  ```

### 2.5反射获取成员方法并使用【应用】

#### 2.5.1Class类获取成员方法对象的方法

- 方法分类

  | 方法名                                      | 说明                    |
  | ---------------------------------------- | --------------------- |
  | Method[] getMethods()                    | 返回所有公共成员方法对象的数组，包括继承的 |
  | Method[] getDeclaredMethods()            | 返回所有成员方法对象的数组，不包括继承的  |
  | Method getMethod(String name, Class<?>... parameterTypes) | 返回单个公共成员方法对象          |
  | Method getDeclaredMethod(String name, Class<?>... parameterTypes) | 返回单个成员方法对象            |

- 示例代码

  ```java
  public class Test22.D19.Ebook.D5.DemoTostring.Student {

      //私有的，无参无返回值
      private void show() {
          System.out.println("私有的show方法，无参无返回值");
      }

      //公共的，无参无返回值
      public void function1() {
          System.out.println("function1方法，无参无返回值");
      }

      //公共的，有参无返回值
      public void function2(String name) {
          System.out.println("function2方法，有参无返回值,参数为" + name);
      }

      //公共的，无参有返回值
      public String function3() {
          System.out.println("function3方法，无参有返回值");
          return "aaa";
      }

      //公共的，有参有返回值
      public String function4(String name) {
          System.out.println("function4方法，有参有返回值,参数为" + name);
          return "aaa";
      }
  }
  public class ReflectDemo5 {
      public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
          //method1();
          //method2();
          //method3();
          //method4();
          //method5();
      }

      private static void method5() throws ClassNotFoundException, NoSuchMethodException {
          //        Method getDeclaredMethod(String name, Class<?>... parameterTypes)：
  //                                返回单个成员方法对象
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect5.Test22.D19.Ebook.D5.DemoTostring.Student");
          //2.获取一个成员方法show
          Method method = clazz.getDeclaredMethod("show");
          //3.打印一下
          System.out.println(method);
      }

      private static void method4() throws ClassNotFoundException, NoSuchMethodException {
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect5.Test22.D19.Ebook.D5.DemoTostring.Student");
          //2.获取一个有形参的方法function2
          Method method = clazz.getMethod("function2", String.class);
          //3.打印一下
          System.out.println(method);
      }

      private static void method3() throws ClassNotFoundException, NoSuchMethodException {
          //        Method getMethod(String name, Class<?>... parameterTypes) ：
  //                                返回单个公共成员方法对象
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect5.Test22.D19.Ebook.D5.DemoTostring.Student");
          //2.获取成员方法function1
          Method method1 = clazz.getMethod("function1");
          //3.打印一下
          System.out.println(method1);
      }

      private static void method2() throws ClassNotFoundException {
          //        Method[] getDeclaredMethods()：
  //                                返回所有成员方法对象的数组，不包括继承的
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect5.Test22.D19.Ebook.D5.DemoTostring.Student");

          //2.获取Method对象
          Method[] methods = clazz.getDeclaredMethods();
          //3.遍历一下数组
          for (Method method : methods) {
              System.out.println(method);
          }
      }

      private static void method1() throws ClassNotFoundException {
          //        Method[] getMethods()：返回所有公共成员方法对象的数组，包括继承的
          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect5.Test22.D19.Ebook.D5.DemoTostring.Student");
          //2.获取成员方法对象
          Method[] methods = clazz.getMethods();
          //3.遍历
          for (Method method : methods) {
              System.out.println(method);
          }
      }
  }
  ```

#### 2.5.2Method类用于执行方法的方法

+ 方法介绍

  | 方法名                                      | 说明   |
  | ---------------------------------------- | ---- |
  | Object invoke(Object obj, Object... args) | 运行方法 |

  参数一: 用obj对象调用该方法

  参数二: 调用方法的传递的参数(如果没有就不写)

  返回值: 方法的返回值(如果没有就不写)

+ 示例代码

  ```java
  public class ReflectDemo2 {
      public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
  //        Object invoke(Object obj, Object... args)：运行方法
  //        参数一：用obj对象调用该方法
  //        参数二：调用方法的传递的参数（如果没有就不写）
  //        返回值：方法的返回值（如果没有就不写）

          //hhh.获取class对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myreflect5.Ebook.D5.DemoTostring.Student");
       Test22.D19.Student获取里面的Method对象  function4
          Method method = clazz.getMethod("function4", String.class);
          //3.运行function4方法就可以了
          //3.1创建一个Student对象,当做方法的调用者
          Ebook.D5.DemoTostring.Student student = (Ebook.D5.DemoTostring.Student) clazz.newInstance();
          //3.2运行方法
          Object result = method.invoke(student, "zhangsan");
          //4.打印一下返回值
          System.out.println(result);
      }
  }
  ```

# day18-基础加强02

## hhh.xml

### hhh.1概述【理解】

+ 万维网联盟(W3C)

  万维网联盟(W3C)创建于1994年，又称W3C理事会。1994年10月在麻省理工学院计算机科学实验室成立。
  建立者： Tim Berners-Lee (蒂姆·伯纳斯·李)。
  是Web技术领域最具权威和影响力的国际中立性技术标准机构。
  到目前为止，W3C已发布了200多项影响深远的Web技术标准及实施指南，

  + 如广为业界采用的超文本标记语言HTML（标准通用标记语言下的一个应用）、

  + 可扩展标记语言XML（标准通用标记语言下的一个子集）

  + 以及帮助残障人士有效获得Web信息的无障碍指南（WCAG）等

    ![01_w3c概述](.\img\01_w3c概述.png)

+ xml概述

  XML的全称为(EXtensible Markup Language)，是一种可扩展的标记语言
  标记语言: 通过标签来描述数据的一门语言(标签有时我们也将其称之为元素)
  可扩展：标签的名字是可以自定义的,XML文件是由很多标签组成的,而标签名是可以自定义的

+ 作用

  + 用于进行存储数据和传输数据
  + 作为软件的配置文件

+ 作为配置文件的优势

  + 可读性好
  + 可维护性高

### hhh.2标签的规则【应用】

+ 标签由一对尖括号和合法标识符组成

  ```java
  <student>
  ```

+ 标签必须成对出现

  ```java
  <student> </student>
  前边的是开始标签，后边的是结束标签
  ```

+ 特殊的标签可以不成对,但是必须有结束标记

  ```java
  <address/>
  ```

+ 标签中可以定义属性,属性和标签名空格隔开,属性值必须用引号引起来

  ```java
  <student id="hhh"> </student>
  ```

+ 标签需要正确的嵌套

  ```java
  这是正确的: <student id="hhh"> <name>张三</name> </student>
  这是错误的: <student id="hhh"><name>张三</student></name>
  ```

### hhh.3语法规则【应用】

+ 语法规则

  + XML文件的后缀名为：xml

  + 文档声明必须是第一行第一列

    <?xml version=“hhh.0” encoding=“UTF-8” standalone=“yes”?>
    version：该属性是必须存在的
    encoding：该属性不是必须的

    ​	打开当前xml文件的时候应该是使用什么字符编码表(一般取值都是UTF-8)

    standalone: 该属性不是必须的，描述XML文件是否依赖其他的xml文件，取值为yes/no

  + 必须存在一个根标签，有且只能有一个

  + XML文件中可以定义注释信息

  + XML文件中可以存在以下特殊字符

    ```java
    &lt; < 小于
    &gt; > 大于
    &amp; & 和号
    &apos; ' 单引号
    &quot; " 引号
    ```

  + XML文件中可以存在CDATA区

    <![CDATA[ …内容… ]]>

+ 示例代码

  ```xml
  <?xml version="hhh.0" encoding="UTF-8" ?>
  <!--注释的内容-->
  <!--本xml文件用来描述多个学生信息-->
  <students>

      <!--第一个学生信息-->
      <student id="hhh">
          <name>张三</name>
          <age>23</age>
          <info>学生&lt; &gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;的信息</info>
          <message> <![CDATA[内容 <<<<<< >>>>>> ]]]></message>
      </student>

      <!--第二个学生信息-->
      <student id="2">
          <name>李四</name>
          <age>24</age>
      </student>

  </students>
  ```

### hhh.4xml解析【应用】

+ 概述

  xml解析就是从xml中获取到数据

+ 常见的解析思想

  DOM(Document Object Model)文档对象模型:就是把文档的各个组成部分看做成对应的对象。
  会把xml文件全部加载到内存,在内存中形成一个树形结构,再获取对应的值

  ![02_dom解析概述](.\img\02_dom解析概述.png)

+ 常见的解析工具

  + JAXP: SUN公司提供的一套XML的解析的API
  + JDOM: 开源组织提供了一套XML的解析的API-jdom
  + DOM4J: 开源组织提供了一套XML的解析的API-dom4j,全称：Dom For Java
  + pull: 主要应用在Android手机端解析XML

+ 解析的准备工作

  hhh. 我们可以通过网站：https://dom4j.github.io/ 去下载dom4j

     今天的资料中已经提供,我们不用再单独下载了,直接使用即可

  2. 将提供好的dom4j-hhh.6.hhh.zip解压,找到里面的dom4j-hhh.6.hhh.jar

  3. 在idea中当前模块下新建一个libs文件夹,将jar包复制到文件夹中

  4. 选中jar包 -> 右键 -> 选择add as library即可

+ 需求

  + 解析提供好的xml文件
  + 将解析到的数据封装到学生对象中
  + 并将学生对象存储到ArrayList集合中
  + 遍历集合

+ 代码实现

  ```java
  <?xml version="hhh.0" encoding="UTF-8" ?>
  <!--注释的内容-->
  <!--本xml文件用来描述多个学生信息-->
  <students>

      <!--第一个学生信息-->
      <student id="hhh">
          <name>张三</name>
          <age>23</age>
      </student>

      <!--第二个学生信息-->
      <student id="2">
          <name>李四</name>
          <age>24</age>
      </student>

  </students>

  // 上边是已经准备好的student.xml文件
  public class Test22.D19.Ebook.D5.DemoTostring.Student {
      private String id;
      private String name;
      private int age;

      public Test22.D19.Ebook.D5.DemoTostring.Student() {
      }

      public Test22.D19.Ebook.D5.DemoTostring.Student(String id, String name, int age) {
          this.id = id;
          this.name = name;
          this.age = age;
      }

      public String getId() {
          return id;
      }

      public void setId(String id) {
          this.id = id;
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

      @Override
      public String toString() {
          return "Test22.D19.Ebook.D5.DemoTostring.Student{" +
                  "id='" + id + '\'' +
                  ", name='" + name + '\'' +
                  ", age=" + age +
                  '}';
      }
  }

  /**
   * 利用dom4j解析xml文件
   */
  public class XmlParse {
      public static void main(String[] args) throws DocumentException {
          //hhh.获取一个解析器对象
          SAXReader saxReader = new SAXReader();
          //2.利用解析器把xml文件加载到内存中,并返回一个文档对象
          Document document = saxReader.read(new File("myxml\\xml\\student.xml"));
          //3.获取到根标签
          Element rootElement = document.getRootElement();
          //4.通过根标签来获取student标签
          //elements():可以获取调用者所有的子标签.会把这些子标签放到一个集合中返回.
          //elements("标签名"):可以获取调用者所有的指定的子标签,会把这些子标签放到一个集合中并返回
          //List list = rootElement.elements();
          List<Element> studentElements = rootElement.elements("student");
          //System.out.println(list.size());

          //用来装学生对象
          ArrayList<Test22.D19.Ebook.D5.DemoTostring.Student> list = new ArrayList<>();

          //5.遍历集合,得到每一个student标签
          for (Element element : studentElements) {
              //element依次表示每一个student标签

              //获取id这个属性
              Attribute attribute = element.attribute("id");
              //获取id的属性值
              String id = attribute.getValue();

              //获取name标签
              //element("标签名"):获取调用者指定的子标签
              Element nameElement = element.element("name");
              //获取这个标签的标签体内容
              String name = nameElement.getText();

              //获取age标签
              Element ageElement = element.element("age");
              //获取age标签的标签体内容
              String age = ageElement.getText();

  //            System.out.println(id);
  //            System.out.println(name);
  //            System.out.println(age);

              Test22.D19.Ebook.D5.DemoTostring.Student s = new Test22.D19.Ebook.D5.DemoTostring.Student(id,name,Integer.parseInt(age));
              list.add(s);
          }
          //遍历操作
          for (Test22.D19.Ebook.D5.DemoTostring.Student student : list) {
              System.out.println(student);
          }
      }
  }
  ```

### hhh.5DTD约束【理解】

+ 什么是约束

  用来限定xml文件中可使用的标签以及属性

+ 约束的分类

  + DTD
  + schema

+ 编写DTD约束

  + 步骤

    hhh. 创建一个文件，这个文件的后缀名为.dtd

    2. 看xml文件中使用了哪些元素

       <!ELEMENT> 可以定义元素

    3. 判断元素是简单元素还是复杂元素

       简单元素：没有子元素。
       复杂元素：有子元素的元素；

  + 代码实现

    ```java
    <!ELEMENT persons (pojo.person)>
    <!ELEMENT pojo.person (name,age)>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT age (#PCDATA)>
    ```
  ```

  ```

+ 引入DTD约束

  + 引入DTD约束的三种方法

    + 引入本地dtd

      <!DOCTYPE 根元素名称 SYSTEM ‘DTD文件的路径'>

    + 在xml文件内部引入

      <!DOCTYPE 根元素名称 [ dtd文件内容 ]>

    + 引入网络dtd

      <!DOCTYPE 根元素的名称 PUBLIC "DTD文件名称" "DTD文档的URL">

  + 代码实现

    + 引入本地DTD约束

      ```xml
      // 这是persondtd.dtd文件中的内容,已经提前写好
      <!ELEMENT persons (pojo.person)>
      <!ELEMENT pojo.person (name,age)>
      <!ELEMENT name (#PCDATA)>
      <!ELEMENT age (#PCDATA)>

      // 在person1.xml文件中引入persondtd.dtd约束
      <?xml version="hhh.0" encoding="UTF-8" ?>
      <!DOCTYPE persons SYSTEM 'persondtd.dtd'>

      <persons>
          <pojo.person>
              <name>张三</name>
              <age>23</age>
          </pojo.person>

      </persons>
      ```

    + 在xml文件内部引入

      ```xml
      <?xml version="hhh.0" encoding="UTF-8" ?>
      <!DOCTYPE persons [
              <!ELEMENT persons (pojo.person)>
              <!ELEMENT pojo.person (name,age)>
              <!ELEMENT name (#PCDATA)>
              <!ELEMENT age (#PCDATA)>
              ]>

      <persons>
          <pojo.person>
              <name>张三</name>
              <age>23</age>
          </pojo.person>

      </persons>
      ```

    + 引入网络dtd

      ```xml
      <?xml version="hhh.0" encoding="UTF-8" ?>
      <!DOCTYPE persons PUBLIC "dtd文件的名称" "dtd文档的URL">

      <persons>
          <pojo.person>
              <name>张三</name>
              <age>23</age>
          </pojo.person>

      </persons>
      ```

+ DTD语法

  + 定义元素

    定义一个元素的格式为：<!ELEMENT 元素名 元素类型>
    简单元素：

    ​	EMPTY: 表示标签体为空

    ​	ANY: 表示标签体可以为空也可以不为空

    ​	PCDATA: 表示该元素的内容部分为字符串

    复杂元素：
    ​	直接写子元素名称. 多个子元素可以使用","或者"|"隔开；
    ​	","表示定义子元素的顺序 ; "|": 表示子元素只能出现任意一个
    ​	"?"零次或一次, "+"一次或多次, "*"零次或多次;如果不写则表示出现一次

    ![03_DTD语法定义元素](.\img\03_DTD语法定义元素.png)


  + 定义属性

    格式

    定义一个属性的格式为：<!ATTLIST 元素名称 属性名称 属性的类型 属性的约束>
    属性的类型：
    ​	CDATA类型：普通的字符串

    属性的约束:

    ​	// #REQUIRED： 必须的
    ​	// #IMPLIED： 属性不是必需的
    ​	// #FIXED value：属性值是固定的

  + 代码实现

    ```java
    <!ELEMENT persons (pojo.person+)>
    <!ELEMENT pojo.person (name,age)>
    <!ELEMENT name (#PCDATA)>
    <!ELEMENT age (#PCDATA)>
    <!ATTLIST pojo.person id CDATA #REQUIRED>

    <?xml version="hhh.0" encoding="UTF-8" ?>
    <!DOCTYPE persons SYSTEM 'persondtd.dtd'>

    <persons>
        <pojo.person id="001">
            <name>张三</name>
            <age>23</age>
        </pojo.person>

        <pojo.person id = "002">
            <name>张三</name>
            <age>23</age>
        </pojo.person>

    </persons>
    ​```
    ```

### hhh.6schema约束【理解】

+ schema和dtd的区别

  hhh. schema约束文件也是一个xml文件，符合xml的语法，这个文件的后缀名.xsd
  2. 一个xml中可以引用多个schema约束文件，多个schema使用名称空间区分（名称空间类似于java包名）
  3. dtd里面元素类型的取值比较单一常见的是PCDATA类型，但是在schema里面可以支持很多个数据类型
  4. schema 语法更加的复杂

  ![04_schema约束介绍](.\img\04_schema约束介绍.png)

+ 编写schema约束

  + 步骤

    hhh，创建一个文件，这个文件的后缀名为.xsd。
    2，定义文档声明
    3，schema文件的根标签为： <schema>
    4，在<schema>中定义属性：
    ​	xmlns=http://www.w3.org/2001/XMLSchema
    5，在<schema>中定义属性 ：
    ​	targetNamespace =唯一的url地址，指定当前这个schema文件的名称空间。
    6，在<schema>中定义属性 ：
    ​	elementFormDefault="qualified“，表示当前schema文件是一个质量良好的文件。
    7，通过element定义元素
    8，判断当前元素是简单元素还是复杂元素

    ![05_schema约束编写](.\img\05_schema约束编写.png)

  + 代码实现

    ```java
    <?xml version="hhh.0" encoding="UTF-8" ?>
    <schema
        xmlns="http://www.w3.org/2001/XMLSchema"
        targetNamespace="http://www.KnowledgePoints.myInterface.interFalse.cn/javase"
        elementFormDefault="qualified"
    >

        <!--定义persons复杂元素-->
        <element name="persons">
            <complexType>
                <sequence>
                    <!--定义person复杂元素-->
                    <element name = "pojo.person">
                        <complexType>
                            <sequence>
                                <!--定义name和age简单元素-->
                                <element name = "name" type = "string"></element>
                                <element name = "age" type = "string"></element>
                            </sequence>

                        </complexType>
                    </element>
                </sequence>
            </complexType>

        </element>

    </schema>

    ```

+ 引入schema约束

  + 步骤

    hhh，在根标签上定义属性xmlns="http://www.w3.org/2001/XMLSchema-instance"
    2，通过xmlns引入约束文件的名称空间
    3，给某一个xmlns属性添加一个标识，用于区分不同的名称空间
    ​	格式为: xmlns:标识=“名称空间地址” ,标识可以是任意的，但是一般取值都是xsi
    4，通过xsi:schemaLocation指定名称空间所对应的约束文件路径
    ​	格式为：xsi:schemaLocation = "名称空间url 文件路径“

  + 代码实现

    ```java
    <?xml version="hhh.0" encoding="UTF-8" ?>

    <persons
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.KnowledgePoints.myInterface.interFalse.cn/javase"
        xsi:schemaLocation="http://www.KnowledgePoints.myInterface.interFalse.cn/javase pojo.person.xsd"
    >
        <pojo.person>
            <name>张三</name>
            <age>23</age>
        </pojo.person>

    </persons>
    ​```
    ```

+ schema约束定义属性

  + 代码示例

    ```java
    <?xml version="hhh.0" encoding="UTF-8" ?>
    <schema
        xmlns="http://www.w3.org/2001/XMLSchema"
        targetNamespace="http://www.KnowledgePoints.myInterface.interFalse.cn/javase"
        elementFormDefault="qualified"
    >

        <!--定义persons复杂元素-->
        <element name="persons">
            <complexType>
                <sequence>
                    <!--定义person复杂元素-->
                    <element name = "pojo.person">
                        <complexType>
                            <sequence>
                                <!--定义name和age简单元素-->
                                <element name = "name" type = "string"></element>
                                <element name = "age" type = "string"></element>
                            </sequence>

                            <!--定义属性，required( 必须的)/optional( 可选的)-->
                            <attribute name="id" type="string" use="required"></attribute>
                        </complexType>

                    </element>
                </sequence>
            </complexType>
        </element>

    </schema>

    <?xml version="hhh.0" encoding="UTF-8" ?>
    <persons
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns="http://www.KnowledgePoints.myInterface.interFalse.cn/javase"
        xsi:schemaLocation="http://www.KnowledgePoints.myInterface.interFalse.cn/javase pojo.person.xsd"
    >
        <pojo.person id="001">
            <name>张三</name>
            <age>23</age>
        </pojo.person>

    </persons>
    ​```
    ```

## 2.枚举

### 2.1概述【理解】

为了间接的表示一些固定的值，Java就给我们提供了枚举
是指将变量的值一一列出来,变量的值只限于列举出来的值的范围内

### 2.2定义格式【应用】

+ 格式

  ```java
  public enum s {
  	枚举项1,枚举项2,枚举项3;
  }
  注意: 定义枚举类要用关键字enum
  ```

+ 示例代码

  ```java
  // 定义一个枚举类，用来表示春，夏，秋，冬这四个固定值
  public enum Season {
      SPRING,SUMMER,AUTUMN,WINTER;
  }
  ```

### 2.3枚举的特点【理解】

+ 特点

  + 所有枚举类都是Enum的子类

  + 我们可以通过"枚举类名.枚举项名称"去访问指定的枚举项

  + 每一个枚举项其实就是该枚举的一个对象

  + 枚举也是一个类，也可以去定义成员变量

  + 枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，但是如果枚举类有其他的东西，这个分号就不能省略。建议不要省略

  + 枚举类可以有构造器，但必须是private的，它默认的也是private的。

    枚举项的用法比较特殊：枚举("");

  + 枚举类也可以有抽象方法，但是枚举项必须重写该方法

+ 示例代码

  ```java
  public enum Season {

      SPRING("春"){

          //如果枚举类中有抽象方法
          //那么在枚举项中必须要全部重写
          @Override
          public void show() {
              System.out.println(this.name);
          }

      },

      SUMMER("夏"){
          @Override
          public void show() {
              System.out.println(this.name);
          }
      },

      AUTUMN("秋"){
          @Override
          public void show() {
              System.out.println(this.name);
          }
      },

      WINTER("冬"){
          @Override
          public void show() {
              System.out.println(this.name);
          }
      };

      public String name;

      //空参构造
      //private Season(){}

      //有参构造
      private Season(String name){
          this.name = name;
      }

      //抽象方法
      public abstract void show();
  }

  public class EnumDemo {
      public static void main(String[] args) {
          /*
          hhh.所有枚举类都是Enum的子类
          2.我们可以通过"枚举类名.枚举项名称"去访问指定的枚举项
          3.每一个枚举项其实就是该枚举的一个对象
          4.枚举也是一个类，也可以去定义成员变量
          5.枚举类的第一行上必须是枚举项，最后一个枚举项后的分号是可以省略的，
            但是如果枚举类有其他的东西，这个分号就不能省略。建议不要省略
          6.枚举类可以有构造器，但必须是private的，它默认的也是private的。
            枚举项的用法比较特殊：枚举("");
          7.枚举类也可以有抽象方法，但是枚举项必须重写该方法
      */

          //第二个特点的演示
          //我们可以通过"枚举类名.枚举项名称"去访问指定的枚举项
          System.out.println(Season.SPRING);
          System.out.println(Season.SUMMER);
          System.out.println(Season.AUTUMN);
          System.out.println(Season.WINTER);

          //第三个特点的演示
          //每一个枚举项其实就是该枚举的一个对象
          Season spring = Season.SPRING;
      }
  }
  ```

### 2.4枚举的方法【应用】

+ 方法介绍

  | 方法名                                      | 说明                 |
  | ---------------------------------------- | ------------------ |
  | String name()                            | 获取枚举项的名称           |
  | int ordinal()                            | 返回枚举项在枚举类中的索引值     |
  | int compareTo(E  o)                      | 比较两个枚举项，返回的是索引值的差值 |
  | String toString()                        | 返回枚举常量的名称          |
  | static <T> T  valueOf(Class<T> type,String  name) | 获取指定枚举类中的指定名称的枚举值  |
  | values()                                 | 获得所有的枚举项           |

+ 示例代码

  ```java
  public enum Season {
      SPRING,SUMMER,AUTUMN,WINTER;
  }

  public class EnumDemo {
      public static void main(String[] args) {
  //        String name() 获取枚举项的名称
          String name = Season.SPRING.name();
          System.out.println(name);
          System.out.println("-----------------------------");

  //        int ordinal() 返回枚举项在枚举类中的索引值
          int index1 = Season.SPRING.ordinal();
          int index2 = Season.SUMMER.ordinal();
          int index3 = Season.AUTUMN.ordinal();
          int index4 = Season.WINTER.ordinal();
          System.out.println(index1);
          System.out.println(index2);
          System.out.println(index3);
          System.out.println(index4);
          System.out.println("-----------------------------");

  //        int compareTo(E o) 比较两个枚举项，返回的是索引值的差值
          int result = Season.SPRING.compareTo(Season.WINTER);
          System.out.println(result);//-3
          System.out.println("-----------------------------");

  //        String toString()   返回枚举常量的名称
          String s = Season.SPRING.toString();
          System.out.println(s);
          System.out.println("-----------------------------");

  //        static <T> T valueOf(Class<T> type,String name)
  //        获取指定枚举类中的指定名称的枚举值
          Season spring = Enum.valueOf(Season.class, "SPRING");
          System.out.println(spring);
          System.out.println(Season.SPRING == spring);
          System.out.println("-----------------------------");

  //        values()       获得所有的枚举项
          Season[] values = Season.values();
          for (Season value : values) {
              System.out.println(value);
          }
      }
  }
  ```

## 3.注解

### 3.1概述【理解】

+ 概述

  对我们的程序进行标注和解释

+ 注解和注释的区别

  + 注释: 给程序员看的
  + 注解: 给编译器看的

+ 使用注解进行配置配置的优势

  代码更加简洁,方便

### 3.2自定义注解【理解】

+ 格式

  public @interface 注解名称 {

  ​	public 属性类型 属性名() default 默认值 ;

  }

+ 属性类型

  + 基本数据类型
  + String
  + Class
  + 注解
  + 枚举
  + 以上类型的一维数组

+ 代码演示

  ```java
  public @interface Anno2 {
  }

  public enum Season {
      SPRING,SUMMER,AUTUMN,WINTER;
  }

  public @interface Anno1 {

      //定义一个基本类型的属性
      int a () default 23;

      //定义一个String类型的属性
      public String name() default "KnowledgePoints.myInterface.interFalse";

      //定义一个Class类型的属性
      public Class clazz() default Anno2.class;

      //定义一个注解类型的属性
      public Anno2 anno() default @Anno2;

      //定义一个枚举类型的属性
      public Season season() default Season.SPRING;

      //以上类型的一维数组
      //int数组
      public int[] arr() default {hhh,2,3,4,5};

      //枚举数组
      public Season[] seasons() default {Season.SPRING,Season.SUMMER};

      //value。后期我们在使用注解的时候，如果我们只需要给注解的value属性赋值。
      //那么value就可以省略
      public String value();

  }

  //在使用注解的时候如果注解里面的属性没有指定默认值。
  //那么我们就需要手动给出注解属性的设置值。
  //@Anno1(name = "KnowledgePoints.myInterface.interFalse")
  @Anno1("abc")
  public class AnnoDemo {
  }
  ```

+ 注意

  如果只有一个属性需要赋值，并且属性的名称是value，则value可以省略，直接定义值即可

+ 自定义注解案例

  + 需求

    自定义一个注解@Test22,用于指定类的方法上,如果某一个类的方法上使用了该注解,就执行该方法

  + 实现步骤

    hhh. 自定义一个注解Test,并在类中的某几个方法上加上注解
    2. 在测试类中,获取注解所在的类的Class对象
    3. 获取类中所有的方法对象
    4. 遍历每一个方法对象,判断是否有对应的注解

  + 代码实现

    ```java
    //表示Test这个注解的存活时间
    @Retention(value = RetentionPolicy.RUNTIME)
    public @interface Test22 {
    }

    public class UseTest {

        //没有使用Test注解
        public void show(){
            System.out.println("UseTest....show....");
        }

        //使用Test注解
        @Test22
        public void method(){
            System.out.println("UseTest....method....");
        }

        //没有使用Test注解
        @Test22
        public void function(){
            System.out.println("UseTest....function....");
        }
    }

    public class AnnoDemo {
        public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
            //hhh.通过反射获取UseTest类的字节码文件对象
            Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myanno3.UseTest");

            //创建对象
            UseTest useTest = (UseTest) clazz.newInstance();

            //2.通过反射获取这个类里面所有的方法对象
            Method[] methods = clazz.getDeclaredMethods();

            //3.遍历数组，得到每一个方法对象
            for (Method method : methods) {
                //method依次表示每一个方法对象。
                //isAnnotationPresent(Class<? extends Annotation> annotationClass)
                //判断当前方法上是否有指定的注解。
                //参数：注解的字节码文件对象
                //返回值：布尔结果。  true 存在  false 不存在
                if(method.isAnnotationPresent(Test22.class)){
                    method.invoke(useTest);
                }
            }
        }
    }
    ```

### 3.3元注解【理解】

+ 概述

  元注解就是描述注解的注解

+ 元注解介绍

  | 元注解名        | 说明                    |
  | ----------- | --------------------- |
  | @Target     | 指定了注解能在哪里使用           |
  | @Retention  | 可以理解为保留时间(生命周期)       |
  | @Inherited  | 表示修饰的自定义注解可以被子类继承     |
  | @Documented | 表示该自定义注解，会出现在API文档里面。 |

+ 示例代码

  ```java
  @Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})  //指定注解使用的位置（成员变量，类，方法）
  @Retention(RetentionPolicy.RUNTIME) //指定该注解的存活时间
  //@Inherited //指定该注解可以被继承
  public @interface Anno {
  }

  @Anno
  public class Person {
  }

  public class Test22.D19.Ebook.D5.DemoTostring.Student extends Person {
      public void show(){
          System.out.println("student.......show..........");
      }
  }

  public class StudentDemo {
      public static void main(String[] args) throws ClassNotFoundException {
          //获取到Student类的字节码文件对象
          Class clazz = Class.forName("KnowledgePoints.myInterface.interFalse.myanno4.Test22.D19.Ebook.D5.DemoTostring.Student");

          //获取注解。
          boolean result = clazz.isAnnotationPresent(Anno.class);
          System.out.println(result);
      }
  }

  ```

# day19-基础加强03

## hhh.单元测试

### hhh.1概述【理解】

JUnit是一个 Java 编程语言的单元测试工具。JUnit 是一个非常重要的测试工具

### hhh.2特点【理解】

+ JUnit是一个开放源代码的测试工具。
+ 提供注解来识别测试方法。
+ JUnit测试可以让你编写代码更快，并能提高质量。
+ JUnit优雅简洁。没那么复杂，花费时间较少。
+ JUnit在一个条中显示进度。如果运行良好则是绿色；如果运行失败，则变成红色。

### hhh.3使用步骤【应用】

+ 使用步骤
  hhh. 将junit的jar包导入到工程中 junit-4.9.jar
  2. 编写测试方法该测试方法必须是公共的无参数无返回值的非静态方法
  3. 在测试方法上使用@Test注解标注该方法是一个测试方法
  4. 选中测试方法右键通过junit运行该方法

+ 代码示例

  ```java
  public class JunitDemo1 {
      @Test22
      public void add() {
          System.out.println(2 / 0);
          int a = 10;
          int b = 20;
          int sum = a + b;
          System.out.println(sum);
      }
  }
  ```

### hhh.4相关注解【应用】

+ 注解说明

  | 注解      | 含义        |
  | ------- | --------- |
  | @Test22   | 表示测试该方法   |
  | @Before | 在测试的方法前运行 |
  | @After  | 在测试的方法后运行 |

+ 代码示例

  ```java
  public class JunitDemo2 {
      @Before
      public void before() {
        	// 在执行测试代码之前执行，一般用于初始化操作
          System.out.println("before");
      }
      @Test22
      public void test() {
        	// 要执行的测试代码
          System.out.println("test");
      }
      @After
      public void after() {
        	// 在执行测试代码之后执行，一般用于释放资源
          System.out.println("after");
      }
  }
  ```

## 2.日志

### 2.1概述【理解】

+ 概述

  程序中的日志可以用来记录程序在运行的时候点点滴滴。并可以进行永久存储。

+ 日志与输出语句的区别

  |      | 输出语句          | 日志技术                 |
  | ---- | ------------- | -------------------- |
  | 取消日志 | 需要修改代码，灵活性比较差 | 不需要修改代码，灵活性比较好       |
  | 输出位置 | 只能是控制台        | 可以将日志信息写入到文件或者数据库中   |
  | 多线程  | 和业务代码处于一个线程中  | 多线程方式记录日志，不影响业务代码的性能 |

### 2.2日志体系结构和Log4J【理解】

+ 体系结构

  ![06_日志体系结构](.\img\06_日志体系结构.png)

+ Log4J

  Log4j是Apache的一个开源项目。

  通过使用Log4j，我们可以控制日志信息输送的目的地是控制台、文件等位置。

  我们也可以控制每一条日志的输出格式。

  通过定义每一条日志信息的级别，我们能够更加细致地控制日志的生成过程。

  最令人感兴趣的就是，这些可以通过一个配置文件来灵活地进行配置，而不需要修改应用的代码。

+ Apache基金会

  Apache软件基金会（也就是Apache Software Foundation，简称为ASF），为支持开源软件项目而办的一个非盈利性组织。

### 2.3入门案例【应用】

+ 使用步骤

  hhh. 导入log4j的相关jar包
  2. 编写log4j配置文件
  3. 在代码中获取日志的对象
  4. 按照级别设置记录日志信息

+ 代码示例

  ```java
  // log4j的配置文件,名字为log4j.properties, 放在src根目录下
  log4j.rootLogger=debug,my,fileAppender

  ### direct log messages to my ###
  log4j.appender.my=org.apache.log4j.ConsoleAppender
  log4j.appender.my.ImmediateFlush = true
  log4j.appender.my.Target=System.out
  log4j.appender.my.layout=org.apache.log4j.PatternLayout
  log4j.appender.my.layout.ConversionPattern=%d %t %5p %c{hhh}:%L - %m%n

  # fileAppender��ʾ
  log4j.appender.fileAppender=org.apache.log4j.FileAppender
  log4j.appender.fileAppender.ImmediateFlush = true
  log4j.appender.fileAppender.Append=true
  log4j.appender.fileAppender.File=D:/log4j-log.log
  log4j.appender.fileAppender.layout=org.apache.log4j.PatternLayout
  log4j.appender.fileAppender.layout.ConversionPattern=%d %5p %c{hhh}:%L - %m%n

  // 测试类
  public class Log4JTest01 {

      //使用log4j的api来获取日志的对象
      //弊端：如果以后我们更换日志的实现类，那么下面的代码就需要跟着改
      //不推荐使用
      //private static final Logger LOGGER = Logger.getLogger(Log4JTest01.class);

      //使用slf4j里面的api来获取日志的对象
      //好处：如果以后我们更换日志的实现类，那么下面的代码不需要跟着修改
      //推荐使用
      private static  final Logger LOGGER = LoggerFactory.getLogger(Log4JTest01.class);

      public static void main(String[] args) {
          //hhh.导入jar包
          //2.编写配置文件
          //3.在代码中获取日志的对象
          //4.按照日志级别设置日志信息
          LOGGER.debug("debug级别的日志");
          LOGGER.info("info级别的日志");
          LOGGER.warn("warn级别的日志");
          LOGGER.error("error级别的日志");
      }
  }
  ```

### 2.4配置文件详解【理解】

+ 三个核心

  + Loggers(记录器)        日志的级别

    Loggers组件在此系统中常见的五个级别：DEBUG、INFO、WARN、ERROR 和 FATAL。

    DEBUG < INFO < WARN < ERROR < FATAL。

    Log4j有一个规则：只输出级别不低于设定级别的日志信息。

  + Appenders(输出源)   日志要输出的地方

    把日志输出到不同的地方，如控制台（Console）、文件（Files）等。

    + org.apache.log4j.ConsoleAppender（控制台）
    + org.apache.log4j.FileAppender（文件）

  + Layouts(布局)             日志输出的格式

    可以根据自己的喜好规定日志输出的格式

    常用的布局管理器：

    ​		org.apache.log4j.PatternLayout（可以灵活地指定布局模式）

    ​          	org.apache.log4j.SimpleLayout（包含日志信息的级别和信息字符串）

     		org.apache.log4j.TTCCLayout（包含日志产生的时间、线程、类别等信息）

+ 配置根Logger

  + 格式

    log4j.rootLogger=日志级别，appenderName1，appenderName2，…

  + 日志级别

    OFF、FATAL、ERROR、WARN、INFO、DEBUG、ALL或者自定义的级别。

  + appenderName1

    就是指定日志信息要输出到哪里。可以同时指定多个输出目的地，用逗号隔开。

    例如：log4j.rootLogger＝INFO，ca，fa

+ ConsoleAppender常用的选项

  + ImmediateFlush=true

    表示所有消息都会被立即输出，设为false则不输出，默认值是true。

  + Target=System.err

    默认值是System.out。

+ FileAppender常用的选项

  + ImmediateFlush=true

    表示所有消息都会被立即输出。设为false则不输出，默认值是true

  + Append=false

    true表示将消息添加到指定文件中，原来的消息不覆盖。

    false则将消息覆盖指定的文件内容，默认值是true。

  + File=D:/logs/logging.log4j

    指定消息输出到logging.log4j文件中

+ PatternLayout常用的选项

  + ConversionPattern=%m%n

    设定以怎样的格式显示消息

    ![07_PatternLayout常用的选项](.\img\07_PatternLayout常用的选项.png)

### 2.5在项目中的应用【应用】

+ 步骤

  hhh. 导入相关的依赖
  2. 将资料中的properties配置文件复制到src目录下
  3. 在代码中获取日志的对象
  4. 按照级别设置记录日志信息

+ 代码实现

  ```java

  ```
