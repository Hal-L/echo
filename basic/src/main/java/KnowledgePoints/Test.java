package KnowledgePoints;

public class Test {
    {
        System.out.println("这里是通用构造器");

    }

    static {
        System.out.println("静态构造器");
    }

    public Test() {
        System.out.println("无参构造方法");
    }

    public static void pen() {
        System.out.println("还我钱");
    }

    public static void main(String[] args) {
        new Test();
        pen();
        //由于创建对象的过程实在静态内容家在完成之后，在静态方法和静态块里不能使用this
        //静态的内容使用类名去访问
        Test.pen();

    }
}
