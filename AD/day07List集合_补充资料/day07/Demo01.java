package com.demo42.day07;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Author: fg
 * @Date: 2020/8/14 16:51
 */
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("苍老师"); // 年龄太大的,删除
        arrayList.add("小泽老师");
        arrayList.add("三上悠亚"); // 一哭,二闹,三上悠亚

        Iterator<String> iterator = arrayList.iterator();
        /**
         * modCount = 3;
         * expectedModCount = 3;
         */
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("苍老师")) {
                arrayList.remove(s);
                // modCount++    modCount = 4;
            }
        }

        /**
         * ConcurrentModificationException: 并发修改异常
         */
        System.out.println(arrayList);
    }
}
