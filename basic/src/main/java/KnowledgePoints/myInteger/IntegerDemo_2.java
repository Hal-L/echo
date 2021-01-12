package KnowledgePoints.myInteger;

import java.util.Arrays;

/*
    int和String的相互转换
 */
public class IntegerDemo_2 {
    public static void main(String[] args) {
        //int --- String
        int number = 100;
        //方式1
        String s1 = number + "";
        System.out.println(s1);
        //方式2
        //public static String valueOf​(int i)
        String s2 = String.valueOf(number);
        System.out.println(s2);
        System.out.println("--------");

        //String --- int
        String s = "100";
        //方式1：String --- Integer --- int
        Integer i = Integer.valueOf(s);
        //public int intValue​()
        int x = i.intValue();
        System.out.println(x);
        //方式2
        //public static int parseInt​(String s)
        int y = Integer.parseInt(s);
        System.out.println(y);


        integerTest();
    }

    private static void integerTest() {
    /*
        需求：
            有一个字符串：“91 27 46 38 50”，请写程序实现最终输出结果是：“27 38 46 50 91”

        思路：
            1:定义一个字符串
            2:把字符串中的数字数据存储到一个int类型的数组中
                得到字符串中每一个数字数据？
                    public String[] split(String regex)
                定义一个int数组，把 String[] 数组中的每一个元素存储到 int 数组中
                    public static int parseInt​(String s)
            3:对 int 数组进行排序
            4:把排序后的int数组中的元素进行拼接得到一个字符串，这里拼接采用StringBuilder来实现
            5:输出结果
     */
        //定义一个字符串
        String s = "91 27 46 38 50";

        //把字符串中的数字数据存储到一个int类型的数组中
        String[] strArray = s.split(" ");
//        for(int i=0; i<strArray.length; i++) {
//            System.out.println(strArray[i]);
//        }

        //定义一个int数组，把 String[] 数组中的每一个元素存储到 int 数组中
        int[] arr = new int[strArray.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArray[i]);
        }

        //对 int 数组进行排序
        Arrays.sort(arr);

        //把排序后的int数组中的元素进行拼接得到一个字符串，这里拼接采用StringBuilder来实现
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                sb.append(arr[i]);
            } else {
                sb.append(arr[i]).append(" ");
            }
        }
        String result = sb.toString();

        //输出结果
        System.out.println(result);
    }


}
