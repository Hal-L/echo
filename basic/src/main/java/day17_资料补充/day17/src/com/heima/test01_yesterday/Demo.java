package com.heima.test01_yesterday;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Properties;

public class Demo {
    public static void main(String[] args) throws Exception{
        //加载配置文件
        Properties p = new Properties();
        InputStream is = ClassLoader.getSystemResourceAsStream("animal.properties");
        p.load(is);
        //获取数据
        String className = p.getProperty("className");
        String methodName = p.getProperty("methodName");
        //获取Class对象
        Class clazz = Class.forName(className);
        //获取Method对象
        Method method = clazz.getMethod(methodName);

        //反向创建对象
        Constructor c = clazz.getConstructor();
        Object o = c.newInstance();

        //反向调用方法
        method.invoke(o);
    }
}
