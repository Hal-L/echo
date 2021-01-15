package com.itheima.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 用于生成dao接口代理实现类的工厂
 *
 * @author 黑马程序员
 * @Company http://www.itheima.com
 */
public class MybatisUtil {

    private static SqlSessionFactory factory;
    private static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();

    static {
        InputStream in = null;
        try {
            //1.读取mybatis主配置文件
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.创建构建者对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            //3.使用构建者创建SqlSessionFactory工厂
            factory = builder.build(in);
        } catch (Exception e) {
            //打印异常信息到控制台
            e.printStackTrace();
            //抛出错误提示程序终止执行
            throw new ExceptionInInitializerError("初始化SqlSessionFactory失败");
        } finally {
            //释放流对象
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取SqlSession对象
     *
     * @return 保留此方法是为了后面对业务层方法增强，利用AOP添加事务
     */
    public static SqlSession getSqlSession() {
        return factory.openSession(false);
    }

    /**
     * mybatis自带生成的Dao接口的代理实现类，把接口 + SQL语句整合在一起了，但是没有管理事务 mapper
     * 我们要做的就是在现有接口实现类的基础上再代理一层，增强事务相关的内容
     *
     * @param daoClass dao接口字节码
     * @return
     */
    public static <T> T getMapper(Class<T> daoClass) {
        // 获取SQLsession对象
        SqlSession sqlSession = getSqlSession();

        //1.判断传入的SqlSession是否为null
        if (sqlSession == null) {
            return null;
        }
        //2.不为null，创建代理实现类
        T mapper = sqlSession.getMapper(daoClass);

        // 3. 对生成的mapper进行事务相关的代理增强
        // 目标对象  mapper
        // 目标方法  mapper中的所有方法

        T proxyInstance = (T) Proxy.newProxyInstance(
                // 参数1：类加载器，使用目标对象的类加载
                mapper.getClass().getClassLoader(),
                // 参数2：目标对象实现的所有接口
                new Class[]{daoClass},
                // 参数3：调用处理器，完成增强的代码
                new InvocationHandler() {
                    /**
                     * 在InvocationHandler实现类的invoke方法中，完整增强逻辑和目标方法的调用
                     * @param proxy     生成后的代理对象，一般不用
                     * @param method    目标方法封装的method对象
                     * @param args      目标方法调用时传递的参数列表
                     * @return 目标方法的返回值（如果有）
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 调用目标方法
                        Object returnValue = null;
                        try {
                            // 开启事务 获取的SQLsession默认是不自动提交的，已经开启了事务
                            returnValue = method.invoke(mapper, args);

                            // 提交事务
                            sqlSession.commit();
                        } catch (Exception e) {
                            // 回滚事务
                            sqlSession.rollback();
                            e.printStackTrace();
                        } finally {
                            // 释放连接
                            if (sqlSession != null) {
                                sqlSession.close();
                            }
                        }


                        // 手动调用目标方法获得的返回值必须return出去，否则外界无法获取该值
                        return returnValue;
                    }
                }
        );

        // 返回代理之后的对象，这个对象增强了目标对象mapper
        return proxyInstance;
    }
}
