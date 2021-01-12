package KnowledgePoints.Array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Array {
    /*
    array(数组) 数组的定义格式：
        1：数据类型[] 数组名；
        2：数据类型 数组名[]；
     */
    // 1.定义求和变量，准备记录最终累加结果
    //static int sum = 0;




    int[] arr1 = {11, 22, 33, 44};
    int[] arr = {23, 34, 26, 87, 12};
    int[][] arrArr = {arr1, arr};

    //动态初始化一个长度为6的int数据，准备存储键盘录入的数值
    int[] arrZero = new int[6];
    //创建键盘录入对象，准备键盘录入
    Scanner sc = new Scanner(System.in);
    int[] arrScore = new int[6];
    Random r = new Random();
    // 1.定义求和变量，准备记录最终累加结果
    int sum = 0;
    int num = 0;

    public static void main(String[] args) {
        int[] arr1 = {11, 22, 33, 44};
        int[] arr = {23, 34, 26, 87, 12};
        int[][] arrArr = {arr1, arr};
        //动态初始化一个长度为6的int数据，准备存储键盘录入的数值
        int[] arrZero = new int[6];
        //创建键盘录入对象，准备键盘录入
        Scanner sc = new Scanner(System.in);
        int[] arrScore = new int[6];
        Random r = new Random();
        // 1.定义求和变量，准备记录最终累加结果
        int sum = 0;
        int num = 0;
        arr();


        // arraycopy(数据源数组,起始索引,目的地数组,起始索引,拷贝个数)

        int [] arr3 = {1,2,3,4,5};
        int [] arr2 = new int[10];

        System.arraycopy(arr3,2,arr2,5,3);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        //arrMaxMin(arr);

        //数组求和
        //arrSum(arrZero,sum,sc);

        //定义一个数组，用动态初始化完成数组元素的初始化，长度为6
        //arrTest1(arrZero,score,arrScore,sc);

        //二维数组
        //arrArr(sum,arrArr);

        //random随机数
        //random(r,num,arrZero);

        //Arrays.toString
        //ArrayToString(arrArr);

        //System.currentTimeMillis();时间,毫秒
        //endStart();

        // 空指针异常
        //arrayException(arrZero);
    }
    public void arrayException(int[] arrZero) {
        System.out.println(arrZero[2]);
        // 空指针异常
        arrZero = null; // 空值
        System.out.println(arrZero[0]);
    }

    private static void endStart() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }

    private static void ArrayToString(int[][] arrArr) {
        System.out.println(Arrays.toString(arrArr[0]));
        System.out.println(Arrays.toString(arrArr));
        System.out.println(arrArr);
    }

    private static void random(Random r,int num,int[] arrZero) {
        for (int i = 0; i < 10; i++) {
            num = r.nextInt(865) + 22;
//    10代表的是一个范围，如果括号写10，产生的随机数就是0-9，括号写20，参数的随机数则是0-19
            arrZero[i] = num;
            System.out.println(num);
        }

        for (int i = 0; i < arrZero.length; i++) {
            if (arrZero[i] % 3 == 0) {
                System.out.println("num:" + arrZero[i]);
            }
        }
    }

    private static void arrArr(int sum,int[][] arrArr) {
        System.out.println(arrArr[0][2]);
        //遍历二维数组，取出里面每一个一维数组
        for (int i = 0; i < arrArr.length; i++) {
            //2.在遍历的过程中，对每一个一维数组继续完成遍历，获取内部存储的每一个元素
            for (int j = 0; j < arrArr[i].length; j++) {
                System.out.println(arrArr[i][j]);
                sum += arrArr[i][j];
            }
        }
        // 3.输出最终结果
        System.out.println(sum);
    }

    private static void arr() {
        // 数据类型[] 数组名;
        int[] array0 = new int[10];
        System.out.println(array0);
        byte[] array1 = new byte[10];
        System.out.println(array1);
        short[] array2 = new short[10];
        System.out.println(array2);
    }

    private static void arrTest1(int[] arrSc,int score,int[] arrScore,Scanner sc) {
        for (int i = 0; i < arrSc.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个评委的打分：");
            if (score >= 0 && score <= 100) {
                arrSc[i] = score;
            } else {
                System.out.println("您的打分输入有误，请检查是否是0-100之间的");
                i--;
            }
        }
        for (int i = 0; i < arrSc.length; i++) {
            System.out.println(arrSc[i]);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入您的分数：");
            arrScore[i] = sc.nextInt();
            if (arrScore[i] < 0 || arrScore[i] > 100) {
                System.out.println("您输入的分数有误,请重新输入");
                i--;
            }
        }
        int max = arrScore[0];
        for (int i = 1; i < arrScore.length; i++) {
            if (max < arrScore[i]) {
                max = arrScore[i];
            }
        }
        System.out.println("max:" + max);
        int min = arrScore[0];
        for (int i = 1; i < arrScore.length; i++) {
            if (min > arrScore[i]) {
                min = arrScore[i];
            }
        }
        System.out.println("min:" + min);
        int sum = 0;
        for (int i = 0; i < arrScore.length; i++) {
            sum += arrScore[i];
        }
        int avg = (sum - max - min) / 4;
        System.out.println("sum:" + avg);
    }

    private static void arrSum(int[] arrSc,int sum,Scanner sc) {
//        将键盘录入的数值存储到数组中
        for (int i = 0; i < arrSc.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个整数：");
            arrSc[i] = sc.nextInt();
        }
//        遍历数组，取出每一个元素，并求和
        for (int i = 0; i < arrSc.length; i++) {
            sum += arrSc[i];
        }
//        输出总和
        System.out.println("sum:" + sum);
    }

    private static void arrMaxMin(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("max:" + max + "--------" + "min:" + min);
    }
}
