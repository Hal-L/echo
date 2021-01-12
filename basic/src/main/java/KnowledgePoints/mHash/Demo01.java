package KnowledgePoints.mHash;

import java.util.HashSet;

/**
 * 哈希值:
 *      一串十进制的整数
 * 如何计算出来的:
 *       根据对象的地址值或者是根据对象的属性值计算出来的
 * 如何获取哈希值:
 *       通过Object类的hashCode方法得到的,根据地址值算出来的
 *       重写Object类的hashCode方法得到的,根据属性值算出来的
 *  HashSet去除重复的原理:
 *      先比较哈希值,如果哈希值不一样,直接存储
 *      先比较哈希值,如果哈希值一样,比较属性值,如果属性值不一样,直接存储
 *      先比较哈希值,如果哈希值一样,比较属性值,如果属性值也一样,认为是重复元素,不存储
 *  对于我们来讲,存储自定义类型元素:
 *      要求: 必须重写hashCode和equals方法
 */
public class Demo01 {
    public static void main(String[] args) {
       Student s1 = new Student("xiaozhi",23);
        Student s2 = new Student("xiaomei",23);

        //因为在Object类中，是根据对象的地址值计算出来的哈希值。
        System.out.println(s1.hashCode());//1060830840
        System.out.println(s1.hashCode());//1060830840


        System.out.println(s2.hashCode());//2137211482
        // 重写重写了hashCode方法,按照属性值去算,属性值不一样,哈希值应该也不一样
        // 属于特殊情况, 恰巧一样了, 不常见 (哈希冲突)
        int h1 = "重地".hashCode();
        int h2 = "通话".hashCode();
        System.out.println("h1 = " + h1 + ", h2 = " + h2);
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("重地");
        hashSet.add("通话");
        System.out.println(hashSet);
    }
}
