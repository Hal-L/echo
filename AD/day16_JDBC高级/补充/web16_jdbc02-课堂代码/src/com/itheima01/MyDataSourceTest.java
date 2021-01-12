package com.itheima01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MyDataSourceTest {
    public static void main(String[] args) throws Exception{
        //1.创建连接池对象
        MyDataSource dataSource = new MyDataSource();

        System.out.println("使用之前的数量：" + dataSource.getSize());

        //2.通过连接池对象获取连接对象
        Connection con = dataSource.getConnection();
        // class com.mysql.jdbc.JDBC4Connection
        System.out.println(con.getClass());

        //3.查询学生表的全部信息
        String sql = "SELECT * FROM student";
        PreparedStatement pst = con.prepareStatement(sql);

        //4.执行sql语句，接收结果集
        ResultSet rs = pst.executeQuery();

        //5.处理结果集
        while(rs.next()) {
            System.out.println(rs.getInt("sid") + "\t" + rs.getString("name") + "\t" + rs.getInt("age") + "\t" + rs.getDate("birthday"));
        }

        //6.释放资源
        rs.close();
        pst.close();
        con.close();    // 用完以后，关闭连接
        //dataSource.close(con);


        // 归还思路：
        /*
            1. 为MyDataSource添加一个归还的方法，传递连接这个参数，实现归还 dataSource.close(con);

            上面做法可以实现，但是编码规范不完美，我们要做的是使用connection自己的close方法，
            方法的实现由原来的释放资源，变成归还链接本身，接下来要做的就是增强(修改)close()

            class com.mysql.jdbc.JDBC4Connection是mysql的jar包中提供的类，他的close方法已经写死了，不能修改！

            2. 自己写一个connection类，继承JDBC4Connection，可以继承并增强close方法
            3. 自己写一个connection类，直接实现Connection接口，自己写close方法，实现归还逻辑
            4. 自己写一个connection类，想办法只实现close方法，其他的方法我们继续调用JDBC4Connection的方法（静态代理）
            5. 动态代理


         */


        System.out.println("使用之后的数量：" + dataSource.getSize());
    }
}
