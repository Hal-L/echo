package KnowledgePoints.Array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ZEROmethod {
    public static void main(String[] args) {
        while (true) {
            System.out.println(
                    "1.常量优化。\r\n2.%取余，/取商。\r\n3.定义方法,能完成比较三个数最大值,最大值打印,三个数使用键盘录入。\r\n4.定义方法,要求方。\r\n5.定义方法 ,完成对。\r\n6.定义方法,完成对数组的。\r\n7.定义方法,用于计算数.\r\n8.拓展题。\r\n如果想要结束检查，请输入数字9!");
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你需要检阅的题目:(1-8)");
            int i = sc.nextInt();
            switch (i) {
                case 9:
                    System.exit(0);
                    break;
                case 1:
                    test01();
                    break;
                case 2:
                    test02();
                    break;
                case 3:
                    test03();
                    break;
                case 4:
                    test04();
                    break;
                case 5:
                    test05();
                    break;
                case 6:
                    test06();
                    break;
                case 7:
                    test07();
                    break;
                case 8:
                    test08();
                    break;
                default:
                    System.out.println("你输入的选择有误,请重新输入：");
                    System.out.println("");
                    break;
            }
        }
    }

    private static void test01() {
        int a = 3; // 3
        // 4 4 +6 + 4 + 4
        int b = ++a + a++ + 6 + --a + a--;

        System.out.println(b);
        System.out.println(a);
    }

    private static void test08() {
        Scanner sc = new Scanner(System.in);
        tuo:
        while (true) {
            System.out.println();
            System.out.println("------------");
            System.out.println("请输入拓展题题号:(1-5)");
            System.out.println("输入数字0结束拓展题检阅!");
            int k = sc.nextInt();
            switch (k) {
                case 0:
                    break tuo;
                case 1:
                    testSeven();
                    break;
                case 2:
                    testRabbit();
                    break;
                case 3:
                    testArr();
                    break;
                case 4:
                    testCompareArr();
                    break;
                case 5:
                    testGetIndex();
                    break;
                default:
                    System.out.println("你的输入有误,请输入(1-5)");
                    break;
            }
        }
    }

    private static void testGetIndex() {
        int[] arr = {19, 28, 37, 46, 50};
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.toString(arr));
        System.out.println("请输入你需要查找的数据:");
        int i = sc.nextInt();
        int index = getIndex(arr, i);
        System.out.println(i + "的索引是:" + index);
    }

    private static int getIndex(int[] arr, int i) {
        int index = -1;
        for (int k = 0; k < arr.length; k++) {
            if (arr[k] == i) {
                index = k;
            }
        }
        return index;
    }

    private static void testCompareArr() {
        int[] arr1 = {11, 22, 33, 44, 55};
        int[] arr2 = {11, 22, 33, 44, 55};
        boolean flag = compareArr(arr1, arr2);
        System.out.println(flag);
    }

    private static boolean compareArr(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == arr2[i]) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    private static void testArr() {
        int[] arr = {68, 27, 95, 88, 171, 996, 51, 210};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 10 != 7 && arr[i] / 10 % 10 != 7 && arr[i] % 2 == 0) {
                sum += arr[i];
            }
        }
        System.out.println("数组中满足条件的元素和为:" + sum);
    }

    private static void testRabbit() {
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        System.out.println("第20个月兔子数量是:" + arr[19] + "对");
    }

    private static void testSeven() {
        System.out.print("1-100之间逢7的数字有:");
        for (int i = 1; i < 100; i++) {
            if (i % 10 == 7 || i / 10 % 10 == 7 || i % 7 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static void test07() {
        int[] arr = {123, 745, 925, 649, 925, 745, 835, 275, 115, 218, 164};
        int[] getMaxAndMin = getMaxAndMin(arr);
        System.out.println("这个数组中最大数:" + getMaxAndMin[0]);
        System.out.println("这个数组中最小数:" + getMaxAndMin[1]);
    }

    private static int[] getMaxAndMin(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int[] getMaxAndMin = {max, min};
        return getMaxAndMin;
    }

    private static void test06() {
        int[] arr = new int[10];
        chushihuaArr(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void chushihuaArr(int[] arr) {
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100) + 1;
        }
    }

    private static void test05() {
        int[] arr = {11, 22, 33, 44, 55};
        System.out.println("数组{11, 22, 33, 44, 55}的最小值是:" + getMinArr(arr));
    }

    private static int getMinArr(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    private static void test04() {
        int[] arr = {11, 22, 33, 44, 55};
        System.out.println("打印格式:");
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    private static void test03() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入第一个整数:");
        int a = sc.nextInt();
        System.out.println("请输入第二个整数:");
        int b = sc.nextInt();
        System.out.println("请输入第3个整数:");
        int c = sc.nextInt();
        int max = getMax(a, b, c);
        System.out.println("最大值是:" + max);
    }

    private static int getMax(int a, int b, int c) {
        return (a > b ? a : b) > c ? (a > b ? a : b) : c;
    }

    private static void test02() {
        int i = 10;
		/*
			i+=10;  == i=i+10
			i/=10; 	== i=i/10
			i+=i*=i/=i-=2;  ==  i = i+(i*=i/=i-=2)
			                ==  i = i+(i=i*(i/=i-=2))
			                == i = i+(i=i*(i = i/(i-=2)))
			                == i = i+(i=i*(i = i/(i=i-2)))
		*/
        i += i *= i /= i -= 2;
        System.out.println(i);
        System.out.println("2.定义方法 完成对传入的两个 数的最小值的返回");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        /*
         * byte a = 10; byte b = 20;
         */
        /*
         * doube a = 10.0; doube b = 20.0;
         */
        /*
         * long a = 1000000000; long b = 100000000;
         */
        // short,long,byte
        int min = getMin(a, b);
        System.out.println("最小值是:" + min);
    }

    private static int getMin(int a, int b) {
        return a < b ? a : b;
    }

    private static byte getMin(byte a, byte b) {
        return a < b ? a : b;
    }

    private static double getMin(double a, double b) {
        return a < b ? a : b;
    }

    private static long getMin(long a, long b) {
        return a < b ? a : b;
    }

}
