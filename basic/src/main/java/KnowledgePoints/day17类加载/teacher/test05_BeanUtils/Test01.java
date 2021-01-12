package KnowledgePoints.day17类加载.teacher.test05_BeanUtils;


import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Test01 {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
    /*
    static void	setProperty(Object bean, String name, Object value)给指定的javaBean对象的属性赋值
    static String	getProperty(Object bean, String name) 获取指定的javaBean对象的属性的值
    static void	populate(Object bean, Map properties) 批量的为对象的属性赋值
     */
        Student s = new Student();
        //赋值
        BeanUtils.setProperty(s,"name","zs");
        System.out.println(s);

        //取值
        String name = BeanUtils.getProperty(s, "name");
        System.out.println(name);

        //创建一个HashMap
        HashMap<String,Object> hm = new HashMap<>();
        hm.put("name","lisi");
        hm.put("age",24);

        BeanUtils.populate(s,hm);
        System.out.println(s);
    }

}
