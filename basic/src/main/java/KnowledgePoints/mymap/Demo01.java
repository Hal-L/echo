package KnowledgePoints.mymap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: fg
 * @Date: 2020/8/20 9:06
 */
public class Demo01 {
    /**
     * 需求：
     *
     * 1.利用键盘录入，输入一个字符串,统计该字符串中各个字符的数量
     * 2.如用户输入字符串:"helloworld java",程序输出结果：
     *      h(1)e(1)l(3)o(2) (2)w(1)r(1)d(1)j(1)a(2)v(1)
     * 3.注：输出结果不要求顺序一致
     *
     * 如果是只统计一个字符出现的次数:
     *      1. 定义一个变量,用来记录指定字符出现的次数(计数器)
     *      2. 遍历字符串,获取的每一个字符
     *      3. 判断当前字符是不是要统计的字符,如果是,更新变量,更新计数器
     *      4. 出了循环,变量中的值,就是指定字符出现的次数
     * 如果要统计的字符有多个,每个字符和其对应的次数,是键值对的关系
     * HashMap<Character,Integer> hashMap = new HashMap<>();
     */
    public static void main(String[] args) {
        // 1.获取用户输入的字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String string = sc.next();
        // 2. 定义集合用来存储指定字符出现的次数
        HashMap<Character,Integer> hashMap = new HashMap<>();
        // 3. 遍历字符串,获取的每一个字符: 两种方式: 1. toCharArray, 2.charAt
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            // 4.判断当前字符是不是要统计的字符,如果是,更新变量,更新计数器
            // 4.1 判断当前的字符在集合中是否出现过,出现过,获取之前的次数,次数+1, 将次数存回去
            if (hashMap.containsKey(c)){
                /*Integer times = hashMap.get(c);
                times++;
                hashMap.put(c,times);*/
                hashMap.put(c,hashMap.get(c)+1); // 优化版本
            }else{
                // 4.2 判断当前的字符在集合中是否出现过,没出现过,存储次数为 1
                hashMap.put(c,1);
            }
        }
        // 5.出了循环,变量中的值,就是指定字符出现的次数
        Set<Character> keySet = hashMap.keySet();

        for (Character key : keySet) {
            Integer value = hashMap.get(key);
            System.out.print(key + "(" + value + ")");
        }
    }
}
