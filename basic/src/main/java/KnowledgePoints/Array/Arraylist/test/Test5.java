package KnowledgePoints.Array.Arraylist.test;

import KnowledgePoints.Array.Arraylist.domain.Student;

import java.util.ArrayList;

public class Test5 {
    /*
        需求：定义一个方法，方法接收一个集合对象（泛型为Student）
            方法内部将年龄低于18的学生对象找出
            并存入新集合对象，方法返回新集合。

        思路：
            1. 定义方法，方法的形参定义为ArrayList<Student> list
            2. 方法内部定义新集合，准备存储筛选出的学生对象 ArrayList<Student> newList
            3. 遍历原集合，获取每一个学生对象
            4. 通过学生对象调用getAge方法获取年龄，并判断年龄是否低于18
            5. 将年龄低于18的学生对象存入新集合
            6. 返回新集合
            7. main方法中测试该方法
     */
    public static void main(String[] args) {
        // 7. main方法中测试该方法
        ArrayList<Student> list = new ArrayList<>();
        Student stu1 = new Student("张三1", 10);
        Student stu2 = new Student("张三2", 10);
        Student stu3 = new Student("张三3", 20);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);

        ArrayList<Student> newList = getList(list);
        for (int i = 0; i < newList.size(); i++) {
            Student stu = newList.get(i);
            System.out.println(stu.getName() + "..." + stu.getAge());
        }

    }

    // 1. 定义方法，方法的形参定义为ArrayList<Student> list
    public static ArrayList<Student> getList(ArrayList<Student> list) {
        // 2. 方法内部定义新集合，准备存储筛选出的学生对象 ArrayList<Student> newList
        ArrayList<Student> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            int age = stu.getAge();
            if (age < 18) {
                list1.add(stu);
            }
        }
        return list1;
        /*ArrayList<Student> newList = new ArrayList<>();
        // 3. 遍历原集合，获取每一个学生对象
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            // 4. 通过学生对象调用getAge方法获取年龄，并判断年龄是否低于18
            int age = stu.getAge();
            if (age < 18) {
                //  5. 将年龄低于18的学生对象存入新集合
                newList.add(stu);
            }
        }
        // 6. 返回新集合
        return newList;*/
    }
}
