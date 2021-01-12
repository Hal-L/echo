package KnowledgePoints.mEnum.test;

public class Student {
    private String name;
    private int age;
    private six six;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", six=" + six +
                '}';
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

    public KnowledgePoints.mEnum.test.six getSix() {
        return six;
    }

    public void setSix(KnowledgePoints.mEnum.test.six six) {
        this.six = six;
    }

    public Student(String name, int age, KnowledgePoints.mEnum.test.six six) {
        this.name = name;
        this.age = age;
        this.six = six;
    }

    public Student() {
    }
}
