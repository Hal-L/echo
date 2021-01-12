package KnowledgePoints.Array;

import java.util.Arrays;

public class DemoArrays {
    public static void main(String[] args) {
        /*
        Arrays:
              public static String toString(int[] a) ：返回指定数组内容的字符串表示形式。
              public static void sort(int[] a) ：对指定的 int 型数组按数字升序进行排序
         */
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(arr);

        String str = Arrays.toString(arr);
        System.out.println(str);// [1, 2, 3, 4, 5, 6, 7]

        int[] arr1 = {81,24,3,84,95,16,27};
        Arrays.sort(arr1);// 对arr数组进行升序排序
        System.out.println(Arrays.toString(arr1));// 把arr1数组转换为字符串打印输出

        /*
        static <T> void  sort(T[] a, Comparator<? super T> c)
              根据指定比较器产生的顺序对指定对象数组进行排序。
         */

/*        Integer[] arr2 = {81,24,3,84,95,16,27};
        Arrays.sort(arr2,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                // 前减后 升序
                // 后减前 降序
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr2));*/
    }
}
