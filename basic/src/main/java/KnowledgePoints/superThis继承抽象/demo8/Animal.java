package KnowledgePoints.superThis继承抽象.demo8;

public abstract class Animal {
    // 抽象方法
    public abstract void eat();

    // 成员变量
    private int age;//10

    // 构造方法
    public Animal(){

    }

    public Animal(int age){//10
        this.age = age;
    }

    //set和get方法
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // 成员方法
    public void sleep(){
        System.out.println("正在睡觉");
        System.out.println("年龄是:"+age);//10
    }

    public static void method(){
        System.out.println("Animal类中的静态方法method");
    }


}
