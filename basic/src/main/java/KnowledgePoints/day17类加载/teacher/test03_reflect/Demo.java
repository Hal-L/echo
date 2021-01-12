package KnowledgePoints.day17类加载.teacher.test03_reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {

    }
    //6,使用方法对象反向调用方法(带参)
    public void test06() throws Exception{
        //获取Class对象
        Class clazz = Class.forName("com.heima.test03_reflect.Student");
        //获取Method对象
        Method getNameMethod = clazz.getMethod("setName", String.class);//传递方法名称

        //反向创建对象
        Constructor c = clazz.getConstructor();
        Object o = c.newInstance();

        //调用getNameMethod方法
        getNameMethod.invoke(o,"赵六");
        System.out.println(o);
    }

    //5,使用方法对象反向调用方法(无参)
    public void test05() throws Exception{
        //获取Class对象
        Class clazz = Class.forName("com.heima.test03_reflect.Student");
        //获取Method对象
        Method getNameMethod = clazz.getMethod("getName");//传递方法名称

        //反向创建对象
        Constructor c = clazz.getConstructor();
        Object o = c.newInstance();

        //调用getNameMethod方法
        Object name = getNameMethod.invoke(o);
        System.out.println(name);
    }

    //4,使用字段对象获取对象的属性的值
    public void test04() throws Exception{
        //获取Class对象
        Class clazz = Class.forName("com.heima.test03_reflect.Student");
        //获取name字段对象
        Field nameField = clazz.getDeclaredField("name");
        System.out.println(nameField);

        //反向创建对象
        Constructor c = clazz.getConstructor();
        Object o = c.newInstance();

        //反向获取对象属性的值
        nameField.setAccessible(true);//取消访问检查
        Object name = nameField.get(o);
        System.out.println(name);
    }

    //3,使用字段对象设置对象的属性
    public void test03() throws Exception{
        //获取Class对象
        Class clazz = Class.forName("com.heima.test03_reflect.Student");
        //获取name字段对象
        Field nameField = clazz.getDeclaredField("name");
        System.out.println(nameField);

        //反向创建对象
        Constructor c = clazz.getConstructor();
        Object o = c.newInstance();

        //反向设置对象属性的值
        nameField.setAccessible(true);//取消访问检查
        nameField.set(o,"王五");
        System.out.println(o);
    }

    //2,使用无参的构造反向创建对象
    public void test02() throws Exception{
        //获取Class对象
        Class clazz = Class.forName("com.heima.test03_reflect.Student");

        //获取构造器对象
        Constructor c = clazz.getConstructor(String.class,int.class);

        //反向创建对象
        Object o = c.newInstance("李四",24);
        System.out.println(o);
    }

    //1,使用无参的构造反向创建对象
    public void test01() throws Exception{
        //获取Class对象
        Class clazz = Class.forName("com.heima.test03_reflect.Student");

        //获取构造器对象
        Constructor c = clazz.getConstructor();

        //反向创建对象
        Object o = c.newInstance();
        System.out.println(o);
    }
}
