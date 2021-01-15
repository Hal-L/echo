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
 * @Author Vsunks.v
 * @Date 2020/8/23 15:08
 * @Description:
 */
public class MybatisUtil {


    private static SqlSessionFactory factory;

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
        SqlSession sqlSession = factory.openSession(false);
        return sqlSession;
    }


    /**
     * 通过动态代理增强mapper，实现事务的自动管理
     * <p>
     * SqlSessionFactory  整个系统只需要一个就可以了
     * SqlSession         这个可以有N个
     *
     * @param daoClass dao层接口的字节码对象
     * @param <T>
     * @return
     */


    public static <T> T getMapper(Class<T> daoClass) {

        // 获取SQLSession对象
        SqlSession sqlSession = getSqlSession();
        T mapper = sqlSession.getMapper(daoClass);

        // 使用动态代理增强mapper，mapper是通过动态代理增强的，
        // 如果想获取他实现的所有接口，不能直接getInterfaces，需要自己手动new一个他实现的所有接口的字节码数组对象
        T mapperProxy = (T) Proxy.newProxyInstance(daoClass.getClassLoader(),
                new Class[]{daoClass},
                new InvocationHandler() {


                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 调用目标方法
                        Object returnValue = null;
                        try {
                            //开启事务，获取的链接本身都是开启事务的，所以什么都不需要做

                            returnValue = method.invoke(mapper, args);

                            //提交事务
                            sqlSession.commit();

                        } catch (Exception e) {
                            // 回滚事务
                            sqlSession.rollback();
                            e.printStackTrace();
                        } finally {
                            // 关闭SQLSession连接
                            if (sqlSession != null) {
                                sqlSession.close();
                            }
                        }


                        return returnValue;
                    }
                });


        return mapperProxy;
    }

}
