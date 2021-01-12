package com.heima.test02_classLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClassLoaderDemo2 {
    public static void main(String[] args) throws IOException {
        //static ClassLoader getSystemClassLoader() 获取系统类加载器
        //InputStream getResourceAsStream(String name)  加载某一个资源文件

        //方式一:通过本类获取类加载器,然后再获取流
        //InputStream is = ClassLoaderDemo2.class.getClassLoader().getResourceAsStream("prop.properties");

        //方式二:通过线程获取类加载,然后再获取流
        //InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("prop.properties");

        //方式三:获取系统类加载器,然后再获取流
        //InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("prop.properties");

        //方式四:直接使用类加载获取流
        InputStream is = ClassLoader.getSystemResourceAsStream("prop.properties");

        Properties prop = new Properties();
        prop.load(is);

        System.out.println(prop);

        is.close();
    }
}
