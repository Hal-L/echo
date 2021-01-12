package KnowledgePoints.泛型;

import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * @Author: fg
 * @Date: 2020/8/16 16:27
 */
public class Demo03 {
    /**
     *  Set:
     *     不可以重复
     *     没有索引(不可以使用普通for循环遍历)
     *  TreeSet:
     *      可以排序
     *  HashSet:
     *      存取无序
     *  LinkedHashSet:
     *      存取有序
     *  HashSet去除重复元素:
     *      要求: 元素类必须重写hashCode和equals方法
     */
    public static void main(String[] args) {
        HashSet<Teacher> hashSet = new HashSet<>();
        hashSet.add(new Teacher("黄老邪",55));
        hashSet.add(new Teacher("欧阳锋",63));
        hashSet.add(new Teacher("洪七公",75));
        hashSet.add(new Teacher("欧阳锋",63));

        for (Teacher teacher : hashSet) {
            System.out.println(teacher);
        }
        System.out.println("-------------");
        LinkedHashSet<Teacher> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(new Teacher("黄老邪",55));
        linkedHashSet.add(new Teacher("欧阳锋",63));
        linkedHashSet.add(new Teacher("洪七公",75));
        linkedHashSet.add(new Teacher("欧阳锋",63));

        for (Teacher teacher : linkedHashSet) {
            System.out.println(teacher);
        }
    }
}
