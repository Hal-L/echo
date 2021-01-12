package KnowledgePoints.mEnum.test;

public class Test {
    public static void main(String[] args) {
        Student s = new Student("李四海", 22, six.boy);
        System.out.println(s);

        int result = six.boy.compareTo(six.girl);
        System.out.println(result);

        String name = six.boy.name();
        System.out.println(name);

        six[] values = six.values();
        System.out.println(values);


    }
}
