package KnowledgePoints.superThis继承抽象.demo6;

public class Zi extends Fu{

    public Zi(){
//        super();
        System.out.println("Zi 类中的空参构造方法");
    }

    public Zi(int num,String name){// 10,"黑马程序员"
        // Zi类的有参构造方法中调用父类的有参构造
        super(num,name);
        System.out.println("Zi 类中的有参构造方法");
    }

/*
    public Zi(){

    }

    public Zi(int num){
        super(num);
    }
*/

}
