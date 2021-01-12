package KnowledgePoints.stringmethod;

import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入：");
        String s = sc.nextLine();
        int bigCount = 0;
        int smallCount = 0;
        int numCount = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (aChar >= 'A' && aChar <= 'C') {
                bigCount++;
            } else if (aChar >= 'a' && aChar <= 'z') {
                smallCount++;
            } else if (aChar >= '0' && aChar <= '9') {
                numCount++;
            }
        }
        System.out.println("大写字母字符:" + bigCount);
        System.out.println("小写字母字符:" + smallCount);
        System.out.println("数字字母字符:" + numCount);
    }
}
