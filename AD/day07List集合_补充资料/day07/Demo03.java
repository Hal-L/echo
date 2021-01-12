package com.demo42.day07;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @Author: fg
 * @Date: 2020/8/14 16:51
 */
public class Demo03 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("苍老师"); // 年龄太大的,删除
        arrayList.add("小泽老师");
        arrayList.add("三上悠亚"); // 一哭,二闹,三上悠亚

        // 获取特有迭代器
        ListIterator<String> listIterator = arrayList.listIterator();

        while (listIterator.hasNext()) {
            String s = listIterator.next();
            if (s.equals("苍老师")) {
                listIterator.remove();
            }
        }
        System.out.println(arrayList);

        System.out.println("----------------------");
        // 上边是正着遍历,迭代器内部的指针已经在最后了,此时可以倒着遍历,将指针推回去
        while (listIterator.hasPrevious()) {
            String s = listIterator.previous();
            System.out.println("倒着遍历元素为: " + s);
        }

    }
}
