package KnowledgePoints.day17类加载.teacher.test04_reflectTest;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class Test01 {
    /*
    创建一个ArrayList<Integer>的对象,在这个集合中添加一个"abc",如何实现(泛型只在编译的时候有效,运行的时候失效)
     */
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(111);
        list.add(222);

        /*list.add("abc");*/

        //获取list的Class对象
        Class clazz = list.getClass();

        //获取add方法对象
        Method addMethod = clazz.getMethod("add", Object.class);

        //反向调用add方法
        addMethod.invoke(list,"abc");

        //打印
        System.out.println(list);

    }
}
