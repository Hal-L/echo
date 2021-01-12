package KnowledgePoints.Lambda_Inter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @Author: fg
 * @Date: 2020/8/11 10:22
 */
public class Demo08 {
    public static void main(String[] args) {
        /**
         * Scanner类有没有重写toString?
         *      假设没有重写,打印的格式应该是: 地址值
         *   Scanner类重写了toString
         */
        Scanner sc = new Scanner(System.in);
        System.out.println(sc); // java.util.Scanner[delimiters=\p{javaWhitespace}+]

        // Random类没有重写toString
        Random r = new Random();
        System.out.println(r); // java.util.Random@6cc4c815

        // ArrayList类重写了toString
        ArrayList<String> arrayList = new ArrayList<>();
        System.out.println(arrayList); // []
    }
}
