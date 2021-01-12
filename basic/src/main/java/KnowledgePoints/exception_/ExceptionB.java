package KnowledgePoints.exception_;


import KnowledgePoints.exception_.exce.AgeOutOfBoundsException;

import java.util.Scanner;

public class ExceptionB {
    public static void main(String[] args) {
        // 键盘录入学生的姓名和年龄,其中年龄为 18 - 25岁,
        // 超出这个范围是异常数据不能赋值.需要重新录入,一直录到正确为止。

        KnowledgePoints.exception_.exce.Student s = new KnowledgePoints.exception_.exce.Student();

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = sc.nextLine();
        s.setName(name);
       while(true){
           System.out.println("请输入年龄");
           String ageStr = sc.nextLine();
           try {
               int age = Integer.parseInt(ageStr);
               s.setAge(age);
               break;
           } catch (NumberFormatException e) {
               System.out.println("请输入一个整数");
               continue;
           } catch (AgeOutOfBoundsException e) {
               System.out.println(e.toString());
               System.out.println("请输入一个符合范围的年龄");
               continue;
           }
           /*if(age >= 18 && age <=25){
               s.setAge(age);
               break;
           }else{
               System.out.println("请输入符合要求的年龄");
               continue;
           }*/
       }
        System.out.println(s);

    }
}


class Student {
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
        if(age >= 18 && age <= 25){
            this.age = age;
        }else{
            //自定义异常的目的:为了让异常信息更加的见名知意
            //throw new RuntimeException("年龄超出了范围");
            throw new AgeOutOfBoundsException("年龄超出了范围");
        }
    }

    @Override
    public String toString() {
        return "D5.DemoTostring.Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
