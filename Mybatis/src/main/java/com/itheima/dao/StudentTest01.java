package com.itheima.dao;

import com.itheima.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class StudentTest01 {
    /*
        删除功能
     */
    @Test
    public void delete() throws Exception{
        //1.加载核心配置文件,返回一个字节输入流对象.
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂对象获取SqlSession对象(SqlSession对象:真正能执行功能的对象)
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //4.执行映射配置文件中的sql语句，并接收结果
        int result = sqlSession.delete("StudentMapper.delete",5);

        //5.提交事务
        sqlSession.commit();

        //6.处理结果
        System.out.println(result);

        //7.释放资源
        sqlSession.close();
        is.close();
    }

    /*
        修改功能
     */
    @Test
    public void update() throws Exception{
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //4.执行映射配置文件中的sql语句，并接收结果
        Student stu = new Student(5,"周七",37);
        int result = sqlSession.update("StudentMapper.update",stu);

        //5.提交事务
        sqlSession.commit();

        //6.处理结果
        System.out.println(result);

        //7.释放资源
        sqlSession.close();
        is.close();
    }

    /*
        新增功能
     */
    @Test
    public void insert() throws Exception{
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂对象获取SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //4.执行映射配置文件中的sql语句，并接收结果
        Student stu = new Student(5,"周七",27);
        int result = sqlSession.insert("StudentMapper.insert", stu);

        //5.提交事务
        //sqlSession.commit();

        //6.处理结果
        System.out.println(result);

        //7.释放资源
        sqlSession.close();
        is.close();
    }

    /*
        根据id查询
     */
    @Test
    public void selectById() throws Exception{
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.执行映射配置文件中的sql语句，并接收结果
        Student stu = sqlSession.selectOne("StudentMapper.selectById", 3);

        //5.处理结果
        System.out.println(stu);

        //6.释放资源
        sqlSession.close();
        is.close();
    }

    /*
        查询全部
     */
    @Test
    public void selectAll() throws Exception{
        //1.加载核心配置文件
        //Resources工具类
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");
        //InputStream is = StudentTest01.class.getClassLoader().getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        //SqlSessionFactoryBuilder:获取SqlSessionFactory工厂对象的功能类,核心方法build(InputStream is),通过指定资源SqlSession工厂对象,返回值类型为SqlSessionFactory
        //SqlSessionFactory:获取SqlSeion构建者对象的工厂接口,核心方法openSession(),获取SqlSesion构建者对象,并开启手动提交事务,返回值类型为SqlSession;核心方法openSesion(boolean autoCommit),获取SqlSession构建者对象,如果参数为true,则开启自动提交事务。
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过SqlSession工厂对象获取SqlSession对象
        //SqlSession:构建者对象接口。用于执行SQL、管理事务、接口代理。
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.执行映射配置文件中的sql语句，并接收结果(selectList查询所有,传入的参数为映射文件SudentMapper.xml文件里的名称空间点.上id)
        List<Student> list = sqlSession.selectList("StudentMapper.selectAll");

        //5.处理结果
        for (Student stu : list) {
            System.out.println("stu = " + stu);
        }

        //6.释放资源
        sqlSession.close();
        is.close();
    }
}
