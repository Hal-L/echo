package KnowledgePoints.泛型;

/**
 * @Author: fg
 * @Date: 2020/8/16 16:28
 */
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public int compareTo(Student o) {
        System.out.println("this = " + this.name + ", o = " + o.name);
        // 升序
        int result = this.age - o.age;
        return result;
    }
}
