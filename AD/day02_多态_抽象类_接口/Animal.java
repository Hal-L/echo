package day02.day02_多态_抽象类_接口;

/**
 * @Author: fg
 * @Date: 2020/8/7 14:57
 */
public class Animal {
    // 标准四样
    // 1. 所有成员变量私有
    private String name;
    private int age;

    // 3.空参构造
    public Animal() {
    }
    // 4.带参构造
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 2.私有成员变量对应set/get
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
