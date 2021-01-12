package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Student stu = new Student();
        /*stu.eat("米饭");
        stu.study();*/

        /*
            要求：在不改动Student类中任何的代码的前提下，通过study方法输出一句话：来黑马学习
            类加载器：和被代理对象使用相同的类加载器
            接口类型Class数组：和被代理对象使用相同接口
            代理规则：完成代理增强的功能
         */
        StudentInterface proxyStu =
                (StudentInterface) Proxy.newProxyInstance(
                        stu.getClass().getClassLoader(),
                        new Class[]{StudentInterface.class},
                        new InvocationHandler() {
            /*
                执行Student类中所有的方法都会经过invoke方法
                对method方法进行判断
                    如果是study，则对其增强（修改）
                    如果不是，还调用学生对象原有的功能即可
             */

            /**
             *
             * @param proxy     代理对象，这个位置的代理对象是给系统使用
             * @param method    目标方法的封装对象
             * @param args      调用目标方法传递的实参
             * @return          表示目标方法的返回值，一定要在该方法内部，把调用目标方法获得的返回值return出去，否则外界无法获取该值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("study")) {
                    System.out.println("来黑马学习");
                    return null;
                }else {
                    // 通过反射调用指定方法（student中非study的方法）
                    return method.invoke(stu,args);
                }
            }
        });

        proxyStu.eat("米饭");
        proxyStu.study();

    }
}
