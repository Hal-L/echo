package KnowledgePoints.stringmethod;

import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入对称字符串：");
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reverseStr = sb.toString();
        if (s.equals(reverseStr)) {
            System.out.println("是对称字符串");
        } else {
            System.out.println("不是对称字符串");
        }
    }
}
