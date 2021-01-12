package KnowledgePoints.superThis继承抽象.demo8;

public class Dog extends Animal {
    public Dog() {
    }

    public Dog(int age) {//10
        super(age);
    }

    @Override
    public void eat() {
        System.out.println("吃骨头");
    }
}
