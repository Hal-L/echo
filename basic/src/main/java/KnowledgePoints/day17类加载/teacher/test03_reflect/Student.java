package KnowledgePoints.day17类加载.teacher.test03_reflect;

public class Student {
    //属性
    private String name = "张三";
    private int age = 23;
    //构造方法
    public Student() { }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //普通方法
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
