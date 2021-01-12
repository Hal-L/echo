package com.heima.test02_xmlParse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class Test01 {
    public static void main(String[] args) throws DocumentException {
        //创建一个解析器对象
        SAXReader reader = new SAXReader();
        //将xml文件加载到内存,得到一个文档对象
        Document document = reader.read(new File("day17/xml/student.xml"));

        //绝对路径
        //获取的是一个集合
        List<Node> list = document.selectNodes("/students/student/name");
        for (Node node : list) {
            System.out.println(node.getText());
        }

        //获取的默认是第一个元素
        Node node = document.selectSingleNode("/students/student/name");
        System.out.println(node.getText());


        //相对路径
        Node node1 = document.selectSingleNode("/students/student");//获取的是student标签
        Node node2 = node1.selectSingleNode("name");//相对上一个节点
        System.out.println(node2.getText());

        //全文检索
        List<Node> list1 = document.selectNodes("//age");
        for (Node node3 : list1) {
            System.out.println(node3.getText());
        }

    }
}
