package KnowledgePoints.myFinal.demo2;

public class Teacher {
    final int NUM = 10;// 显示赋值

    // 必须保证所有构造方法都会给该常量赋值
    final  int AGE;

    public Teacher(){
        this.AGE = 20;
    }

    public Teacher(int age){

        this.AGE = age;
    }

}
