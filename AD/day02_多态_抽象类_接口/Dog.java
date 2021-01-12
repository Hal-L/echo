package day02.day02_多态_抽象类_接口;

/**
 * @Author: fg
 * @Date: 2020/8/7 14:59
 */
public class Dog extends Animal{

    private String color;

    // 在子类的空参中,访问父类的空参
    public Dog() {
        super();
    }

    // 在子类的带参中,访问父类的带参
    public Dog(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
