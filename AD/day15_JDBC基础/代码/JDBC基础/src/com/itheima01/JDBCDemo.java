package com.itheima01;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://192.168.23.129:3306/db2", "root", "arch@mysql");

        // con.createArrayOf()
    }
}
