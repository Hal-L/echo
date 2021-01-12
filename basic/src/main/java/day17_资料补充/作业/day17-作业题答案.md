# 			day22必做题答案

## 一 编程题【xml】

### 1.1 题目一

​    请定义xml文件，存储以下“图书”信息：

​    书名：《架构师成长之路》，出版社：黑马程序员，出版日期：2010-6-6，价格：125.00

​    书名：《JavaEE企业级开发》，出版社：黑马研究院，出版日期：2011-5-5，价格：115.80

​    书名：《Oracle指南》，出版社：清华计算机，出版日期：2012-7-7，价格：89.00

 

​    要求：

​    1). 使用：文档声明

​    2). “标签名”不可使用中文。

​    3). 文件名为：books.xml

​    4). 根元素为：<books>

~~~xml-dtd
<!ELEMENT books (book+)>
<!ELEMENT book (bookName,press,publicationDate,price)>
<!ELEMENT bookName (#PCDATA)>
<!ELEMENT press (#PCDATA)>
<!ELEMENT publicationDate (#PCDATA)>
<!ELEMENT price (#PCDATA)>
~~~

~~~xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE books SYSTEM "bookshelf.dtd">
<books>
    <book>
        <bookName>《架构师成长之路》</bookName>
        <press>黑马程序员</press>
        <publicationDate>2010-6-6</publicationDate>
        <price>125.00</price>
    </book>
    <book>
        <bookName>《JavaEE企业级开发》</bookName>
        <press>黑马研究院</press>
        <publicationDate>2011-5-5</publicationDate>
        <price>115.80</price>
    </book>
    <book>
        <bookName>《Oracle指南》</bookName>
        <press>清华计算机</press>
        <publicationDate>2012-7-7</publicationDate>
        <price>89.00</price>
    </book>
</books>
~~~



## 二 编程题【dom4j】

### 2.1 题目一

​    \1. 请将dom4j包导入到项目中。

​    \2. 使用dom4j读取1.1的books.xml文件，解析每条数据，并打印

~~~java

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

public class Demo {

    public static void main(String[] args) throws Exception {
        //（1）创建xml解析器对象
        SAXReader saxReader = new SAXReader();
        //（2）定位xml的位置
        InputStream is = new FileInputStream("homework/books.xml");//注意这里的文件定位，根据自己的文件位置来定义
        //（3）获取Document对象
        Document doc = saxReader.read(is);
        //（4）获取根元素
        Element root = doc.getRootElement();
        //（5）获取根元素下的所有book的元素
        List<Element> elements = root.elements();
        //（6）遍历所有的book元素
        if(elements!=null&&elements.size()!=0){//判断获取的子元素集合是否为空
            for (Element book : elements) {
                //（7）获取元素中各种内容
                String bookName = book.elementText("bookName");//获取该元素的子元素所对应的元素的文本内容
                String press = book.elementText("press");
                String publicationDate = book.elementText("publicationDate");
                String price = book.elementText("price");
                //（8）输出内容
                System.out.println("书名："+bookName+"，出版社："+press+
                        "，出版日期："+publicationDate+"，售价："+price);
            }
        }

    }
}

~~~

### 2.2 题目二

需求：有books.xml，请解析出图书信息，并打印。book.xml内容如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<books>
       <book id="01" 出版社="传智出版社">
            <name>Java编程思想</name>
            <author>James</author>
            <price>98.00</price>
            <body>库存：30</body>
       </book>
       <book id="02" 出版社="传智出版社">
            <name>JavaEE从入门到精通</name>
            <author>传智播客</author>
            <price>40.00</price>
            <body>库存：20</body>
       </book>
       <book id="03" 出版社="传智出版社">
            <name>Java开发手册</name>
            <author>阿里巴巴</author>
            <price>15.00</price>
            <body>库存：300</body>
       </book>
</books>
```

#### 训练目标

#### 训练提示

#### 参考方案

#### 操作步骤

#### 参考答案

```java
public class Test01 {
    public static void main(String[] args) throws Exception{
        fun();

    }
    public static  void fun() throws DocumentException {
        SAXReader saxReader  = new SAXReader();
        Document document  =  saxReader.read("book.xml");
        Element root = document.getRootElement();
        List<Element> bookList  = root.elements("book");
        for (Element  bookElement : bookList) {

           List<Element> elements = bookElement.elements();
            for (Element  element : elements) {
                String name = element.getName();
                String text = element.getText();
                System.out.println(name+":"+text);
            }
            System.out.println("=========");
        }
    }
}
```

