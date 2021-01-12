package KnowledgePoints.泛型;

import java.util.TreeSet;

/**
 * @Author: fg
 * @Date: 2020/8/16 16:27
 */
public class Demo02 {
    /**
     * TreeSet对自定义类型的元素进行排序
     */
    public static void main(String[] args) {
        TreeSet<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student("diaoChan",28));
        treeSet.add(new Student("xiShi",27));
        treeSet.add(new Student("yangYuHuan",30));
        treeSet.add(new Student("fangJie",29)); // 这样的舔狗,喜欢吗?

        System.out.println(treeSet);
    }
}
