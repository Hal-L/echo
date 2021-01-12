package KnowledgePoints.DemoTostring;


public class DemoTostring {
    public static void main(String[] args) {
        Student s1 = new Student("赵灵儿", 18);
        Student s2 = new Student("赵灵儿", 18);
        System.out.println(s1);
        System.out.println(s1.toString());
        System.out.println(s1 == s2);
        // Object类中的equals方法,底层也是==号比较地址值,进行重写后只比较具体值
        System.out.println(s1.equals(s2));
    }
}
