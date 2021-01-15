package com.itheima.utils;

import java.util.UUID;

/**
 * @Author Vsunks.v
 * @Date 2020/8/25 16:04
 * @Description: 为上传的文件随机生成文件名和目录
 */
public class FIleUtil {

    public static String getPath(){

        // 生成一个UUID的随机文件名
        String str = UUID.randomUUID().toString();
        str = str.replaceAll("-", "");
        System.out.println("str = " + str);

        // 生成一个多级目录
        char c1 = str.charAt(0);  //16个
        char c2 = str.charAt(1);  //16个
        char c3 = str.charAt(2);  //16个

        String path = new StringBuilder().append(c1).append("/")
                .append(c2).append("/").append(c3).append("/").append(str).toString();
        return  path;  //c/a/0/uuid
    }
}
