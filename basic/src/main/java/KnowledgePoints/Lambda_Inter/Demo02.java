package KnowledgePoints.Lambda_Inter;

import java.util.ArrayList;

/**
 * @Author: fg
 * @Date: 2020/8/11 11:51
 */
public class Demo02 {
    /**
     * 装箱:
     * 将基本类型变成包装类
     * 拆箱:
     * 将包装类变成基本类型
     * 自动拆装箱:
     * JDK1.5之后推出的一个套路,根据场景自动进行拆装箱
     */
    public static void main(String[] args) {
        // 直接写一个 10, int 类型, 基本类型
        // 基本类型 -> 包装类
        Integer integer = new Integer(10);
        Integer integer02 = Integer.valueOf(20);
        // 包装类 -> 基本类型
        int a = integer.intValue();
        int b = integer02.intValue();

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(new Integer(10));
        arrayList.add(Integer.valueOf(20));
        arrayList.add(30); // 自动装箱

        Integer integer03 = arrayList.get(0);
        int c = arrayList.get(0); // 自动拆箱


    }
}
