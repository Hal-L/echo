## EasyExcel

## 1. POI

先说`POI`，有过报表导入导出经验的同学，应该听过或者使用。（Office  word  ppt Excel读写）

`Apache POI`是Apache软件基金会的开源函式库，提供跨平台的`Java API`实现`Microsoft Office`格式档案读写。但是存在如下一些问题：

### 1.1 学习使用成本较高

以单元格为单位进行读写，代码冗余繁杂。

样式控制麻烦，大量重复代码。

`SAX`解析内存消耗小，但是学习成本高。



### 1.2 POI的内存消耗较大

`userModel`模式简单易上手，但是代码量大，且内存消耗巨大。读写大文件耗费内存较大，容易OOM



## 2. EasyExcel

1. 在数据模型层面对`POI`进行了封装，**使用简单**
2. 重写了07版本的Excel的解析代码，降低内存消耗，能有效避免OOM
3. 只能操作Excel
4. 不能读取图片
5. 使用程序读写excel，数据在excel文件、程序<实体类、Map>这两个载体中间相互流转。



## 3. 快速入门--QuickStart

### 0、导入依赖坐标

如果项目中已经导入了`POI`的坐标，建议注释掉，避免依赖冲突。

```xml
<!-- EasyExcel -->
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>easyexcel</artifactId>
    <version>2.1.6</version>
</dependency>
```



### 1、最简单的读

#### 1.1、需求、准备工作

```java
/**
 * 需求：单实体导入
 * 导入Excel学员信息到系统。
 * 包含如下列：姓名、性别、出生日期
 * 模板详见：模拟在线202003班学员信息.xls
 */
```

```java
// 模拟在线202003班学员信息.xls文件
```



#### 1.2、编写导出数据的实体

```java
// 基于lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
public class D5.DemoTostring.Student {
    /**
     * 学生姓名
     */
    private String name;
    /**
     * 学生性别
     */
    private String gender;

    /**
     * 学生出生日期
     */
    private Date birthday;
    /**
     * id
     */
    private String id;
}
```



#### 1.3、 读取`Excel`文件

调用`EasyExcel`的`API`读取的`Excel`文件的测试类`StudentReadDemo`

```java
package net.sunxiaowei.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
impoima.D5.DemoTostring.Student;
import net.sunxiaowei.listener.StudentReadListener;

import java.io.FileNotFoundException;

/**
 * @Author Vsunks.v
 * @Date 2020
 * @Description:
 */
public class StudentReadDemo {
    public static void main(String[] args) throws FileNotFoundException {
        // 读取文件，读取完之后会自动关闭
        /*
        	pathName  		文件路径；"d:\\模拟在线202003班学员信息.xls"
        	head			每行数据对应的实体；D5.DemoTostring.Student.class
        	readListener	读监听器，每读一样就会调用一次该监听器的invoke方法
        
        	sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字，不传默认为0
        */
        // 封装工作簿对象
        ExcelReaderBuilder workBook = EasyExcel.read
                ("d:\\模拟在线202003班学员信息.xls", D5.DemoTostring.Student.class, new StudentReadListener());

        // 封装工作表
        ExcelReaderSheetBuilder sheet1 = workBook.sheet();
        // 读取
        sheet1.doRead();
    }
}

```

读取Excel的监听器，用于处理读取产生的数据

```java
package net.sunxiaowei.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import net.sunxiaowei.D5.DemoTostring.Student;

/**
 * @Author Vsunks.v
 * @Date
 * @Description:
 */
public class StudentReadListener extends AnalysisEventListener<D5.DemoTostring.Student> {
    // 每读一样，会调用该invoke方法一次
    @Override
    public void invoke(D5.DemoTostring.Student data, AnalysisContext context) {
        System.out.println("data = " + data);
        log.info(data + "保存成功");
    }

    // 全部读完之后，会调用该方法
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // TODO......
    }
}
```



### 2、最简单的写

#### 2.1 需求、准备工作

```java
/**
 * 需求：单实体导出
 * 导出多个学生对象到Excel表格
 * 包含如下列：姓名、性别、出生日期
 * 模板详见：模拟在线202003班学员信息.xlsx
 */
```



#### 2.2、编写导出数据的实体

```java
// 见1.2
```



#### 2.3、 准备数据并写入到文件

```java
package net.sunxiaowei.demo;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import net.sunxiaowei.D5.DemoTostring.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Vsunks.v
 * @Date 2020
 * @Description:
 */
public class StudentWriteDemo {
    public static void main(String[] args) {

        List<D5.DemoTostring.Student> students = initData();
        /*
            String pathName 写入文件的路径
            Class head      写入文件的对象类型
            默认写入到07的xlsx中，如果想要写入xls，可以指定类型
         */
        ExcelWriterBuilder workBook = EasyExcel.write("d:\\模拟学员表.xlsx", D5.DemoTostring.Student.class);

        // sheet方法参数： 工作表的顺序号（从0开始）或者工作表的名字
        workBook.sheet().doWrite(students);
    }

    private static List<D5.DemoTostring.Student> initData() {
        ArrayList<D5.DemoTostring.Student> students = new ArrayList<D5.DemoTostring.Student>();
        D5.DemoTostring.Student data = new D5.DemoTostring.Student();
        for (int i = 0; i < 10; i++) {
            data.setName("模拟学号0" + i);
            data.setBirthday(new Date());
            data.setGender("男");
            students.add(data);
        }
        return students;
    }
}
```



## 4. 填充

### 4.1 准备模板

Excel表格中用`{.} `来表示包裹要填充的变量，如果单元格文本中本来就有`{`、`}`左右大括号，需要在括号前面使用斜杠转义`\{`  、`\}`。

代码中被填充数据的实体对象的成员变量名或被填充map集合的key需要和Excel中被{}包裹的变量名称一致。









### 4.2 代码填充

准备数据并填充到文件

```java
/**
 *
 *
 * @Author Vsunks.v
 * @Date 2020/8/26 15:19
 * @Description: 测试Easyexcel
 */
public class EasyExcelTest {


    /**
     * 工作簿：一个Excel文件对应的就是一个工作簿
     * 工作表：对应就是Excel文件中的sheet，一个工作簿可以包含多个工作表
     *
     * EasyExcel中有一个核心的类
     */

    @Test22
    public void test01() {

        // 创建工作簿对象
        // Maven项目，如果直接写入一个文件名而没有任何目录层级，他会写入到当前模块的根目录。也可以指定一个绝对路径
        ExcelWriterBuilder workBook = EasyExcel.write(new File("d:\\测试.xlsx"), Question.class);

        // 使用模板
        // 配置文件、模板文件一般都会放在mian/resources里面，他会被自动复制到target/classes(类路径)里面
        // Java项目(无web环境)  从类路径下读取一个文件 this.getClass().getClassLoader().getResourceAsStream
        // ("类路径下文件名")
        workBook.withTemplate(this.getClass().getClassLoader().getResourceAsStream("template" +
                ".xlsx"));


        // 创建工作表对象
        ExcelWriterSheetBuilder sheet = workBook.sheet();


        // 查出所有题目
        QuestionDao questionDao = MybatisUtil.getMapper(QuestionDao.class);
        List<Question> questions = questionDao.findAll();

        // 实体类对象或者实体类对象的集合或者map
        // 直接写入文件（填充文件）
        sheet.doFill(questions);

    }
}
```





### 5.  案例整合

### 5.1 `Question\list.jsp`中添加

```jsp
<button type="button" class="btn btn-default" title="导出题目"                        onclick=location.href="${ctx}/store/question?operation=downloadReport"> 
    <i class="fa fa-download"></i>
    导出题目
</button>
```





### 5.2 `QuestionServlet`请求分发

```java
// 使用抽取的BaseServlet完成自动分发
```





### 5.3 `QuestionServlet`中`downloadReport`方法

```java
/**
 * 生成所有题目的报表
 *
 * @param request
 * @param response
 * @throws IOException
 */

private void downloadReport(HttpServletRequest request, HttpServletResponse response) throws IOException {


    // 设置响应内容的格式，告诉浏览器我响应的是一个xlsx格式的文件
    response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    // 设置一个文件名并指定编码
    String fileName = URLEncoder.encode("测试文件", "utf-8");

    // 告诉浏览器以下载的方式处理响应的内容
    response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + fileName +
            ".xlsx");

    //5.设置响应对象输出响应正文时的字符集
    // response.setContentType("text/html;charset=UTF-8");


    // 创建工作簿对象
    ExcelWriterBuilder workBook = EasyExcel.write(response.getOutputStream(), Question.class);

    // 使用模板
    InputStream is = Resources.getResourceAsStream("template.xlsx");
    workBook.withTemplate(is);


    // 创建工作表对象
    ExcelWriterSheetBuilder sheet = workBook.sheet();


    // 查出所有题目
    List<Question> questions = questionService.findAll();

    // 实体类对象或者实体类对象的集合或者map
    // 直接写入文件（填充文件）
    sheet.doFill(questions);
}
```

