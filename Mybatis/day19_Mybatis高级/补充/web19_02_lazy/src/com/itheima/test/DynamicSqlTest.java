package com.itheima.test;

import com.itheima.dao.OrderDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DynamicSqlTest {

    SqlSession session;
    UserDao userDao;
    OrderDao orderDao;

    @Before
    public void before() throws IOException {
        // 指定配置文件位置
        String resource = "mybatis-config.xml";
        // 获取配置文件的输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 根据配置文件生成sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession(true);
        orderDao = session.getMapper(OrderDao.class);
        userDao = session.getMapper(UserDao.class);
    }

    @After
    public void after() {
        session.close();
    }


    // 需求5：查询所有用户，并在使用到用户订单信息的时候查询订单。
    @Test
    public void test05() {
        // 下面两行没有查询orders，因为没有使用到对应的数据
        List<User> users = userDao.findAllUserLazyOrders();
        System.out.println("users = " + users.toString());
        System.out.println("已经成功查询出所有用户");

        // 下面两行并没有查询orders这个表，因为没有使用到对应的数据
        System.out.println("只使用user自己的属性");
        System.out.println("users.get(1).getUsername() = " + users.get(1).getUsername());

        // 下面两行开始查询orders表（user的id是1），因为你用到了第一个用户的所有orders（订单）
        System.out.println("开始使用order的属性");
        System.out.println("users.get(0).getOrderList() = " + users.get(0).getOrderList());


        // 下面两行也要查询orders表（user的id是2），因为你用到了第二个用户的所有orders（订单）
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

}
