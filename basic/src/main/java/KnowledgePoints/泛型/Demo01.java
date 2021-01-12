package KnowledgePoints.泛型;

import java.util.ArrayList;

/**
 * @Author: fg
 * @Date: 2020/8/16 10:02
 */
public class Demo01 {
    /**
     * 泛型我们到底要掌握到什么程度? 清楚以下三个问题,就ok了?
     *  1. 为什么我们之前用ArrayList集合时,需要写<>,需要在里面写上一个引用类型 ?
     *          是因为sun公司程序员在写ArrayList类时,在类上定义泛型了,我们在使用这个类时,就要明确泛型的具体类型
     *  2. 不指定具体类型可以不可以 ?
     *          可以,默认是Object类型
     *  3. 指定了有什么好处 ?
     *          1). 将运行期的异常提前到了编译期
     *          2). 避免了强制类型转换
     */
    public static void main(String[] args) {
        // 测试上限限定<? extends E>
        ArrayList<Integer> arrayList01 = new ArrayList<>();
        ArrayList<Number> arrayList02 = new ArrayList<>();
        ArrayList<Object> arrayList03 = new ArrayList<>();
        printArrayList01(arrayList01); // 可以,Integer是Number的子类
        printArrayList01(arrayList02); // 可以,是Number本身
       // printArrayList01(arrayList03); // 不可以,Object是Number的父类

        // 测试下限限定<? super E>
        ArrayList<Integer> arrayList04 = new ArrayList<>();
        ArrayList<Number> arrayList05 = new ArrayList<>();
        ArrayList<Object> arrayList06 = new ArrayList<>();
       //  printArrayList02(arrayList04); // 不可以,Integer是Number的子类
        printArrayList02(arrayList05); // 可以,是Number本身
        printArrayList02(arrayList06); // 可以,Object是Number的父类

        ArrayList<String> arrayList = new ArrayList<>();
        printArrayList(arrayList);
        ArrayList<Integer> arrayListInteger = new ArrayList<>();
        // 方法需要的是操作String的集合, 我们这个是操作Integer的集合
       // printArrayList(arrayListInteger);

    }
    // 泛型通配符上限限定
    public static void printArrayList01(ArrayList<? extends Number> arrayList){
        for (Object o : arrayList) {
            System.out.println(o);
        }
    }
    // 泛型通配符下限限定
    public static void printArrayList02(ArrayList<? super Number> arrayList){
        for (Object o : arrayList) {
            System.out.println(o);
        }
    }
    // 功能: 遍历集合,打印每个元素
    public static void printArrayList(ArrayList<String> arrayList){
        for (Object s : arrayList) {
            System.out.println(s);
        }
    }

}
