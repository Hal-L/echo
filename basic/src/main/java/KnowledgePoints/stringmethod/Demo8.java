package KnowledgePoints.stringmethod;

import java.util.Scanner;

public class Demo8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生信息：");
        String stuInfo = sc.nextLine();
        String[] sArr = stuInfo.split(",");
        /*
        Student stu = new Student(sArr[0],sArr[1]);
        System.out.println(stu.getName() + "..." + stu.getAge());
        */
    }
}
