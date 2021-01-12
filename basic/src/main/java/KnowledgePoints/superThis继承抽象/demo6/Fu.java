package KnowledgePoints.superThis继承抽象.demo6;

public class Fu {

    public int num;//10

    private String name;//"黑马程序员"

    public Fu() {
        System.out.println("Fu 类的空参构造方法");
    }

    public Fu(int num,String name) {// 10,"黑马程序员"
        this.num = num;
        this.name = name;
        System.out.println("Fu 类的有参构造方法");
    }

    public void show(){
        System.out.println("name的值是:"+name);
    }
}
