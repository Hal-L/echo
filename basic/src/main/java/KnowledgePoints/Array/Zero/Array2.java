package KnowledgePoints.Array.Zero;

import java.util.Scanner;

public class Array2 {
    public static void main(String[] args) {
//        定义一个求和变量
        int sum = 0;
//        动态初始化一个长度为5的int数据，准备存储键盘录入的数值
        int arr[] = new int[5];
//        创建键盘录入对象，准备键盘录入
        Scanner sc = new Scanner(System.in);
//        将键盘录入的数值存储到数组中
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数：");
            arr[i] = sc.nextInt();
        }
//        遍历数组，取出每一个元素，并求和
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
//        输出总和
        System.out.println("sum:" + sum);


    }
}
