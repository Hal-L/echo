package KnowledgePoints.DuoTai;

public class Cat extends Animal {

    public Cat() {
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }


    public void playGame() {
        System.out.println("猫捉迷藏");
    }
}
