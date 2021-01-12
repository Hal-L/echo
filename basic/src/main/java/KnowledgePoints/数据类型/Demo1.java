package KnowledgePoints.数据类型;

import java.util.ArrayList;
import java.util.List;

/*
数据类型:
    基本数据类型: byte short int long    float double  char   boolean
            局部变量
            成员变量
            方法的参数
            方法的返回值

    引用数据类型:
            类,数组,接口,...

            局部变量
            成员变量
            方法的参数
            方法的返回值

 interface作为方法参数和返回值类型

 */
public class Demo1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(22);
        list.add(21);
        list.add(32);
        list.add(42);
        list.add(27);

        ArrayList<Integer> list2 = getNum(list);// 把list集合传入getNum方法中,返回一个偶数集合
        System.out.println(list2);

        List<Integer> list3 = getNum1(list);
        System.out.println(list3);
    }
    //案例: 获取所有偶数的集合
    //  接口作为方法参数和返回值类型
    // 从源码可看出List是一个接口,同时可以看出ArrayList类实现了List接口
    // 使用List接口作为方法的参数,可以接收ArrayList类的对象(因为ArrayList是List接口的实现类)
    // 使用List接口作为方法的返回值类型,可以返回一个ArrayList类的对象(因为ArrayList是List接口的实现类)
    public static List<Integer> getNum1(List<Integer> list) {
         /*
        思路:
            1.创建一个集合,用来存储原集合中的所有偶数
            2.遍历原始集合,获取每一个元素
            3.判断元素是否是偶数,如果是就存储到集合中
            4.返回偶数集合
         */
        ArrayList<Integer> list1 = new ArrayList<>();// 创建一个用来存储偶数的集合
        for(int i = 0;i<list.size();i++){
            // 获取list集合中的元素
            int num = list.get(i);
            // 判断
            if(num % 2 == 0){
                list1.add(num);
            }
        }

        return list1;

    }


    // 类作为方法的参数和返回值类型
    public static ArrayList<Integer> getNum(ArrayList<Integer> list){
        /*
        思路:
            1.创建一个集合,用来存储原集合中的所有偶数
            2.遍历原始集合,获取每一个元素
            3.判断元素是否是偶数,如果是就存储到集合中
            4.返回偶数集合
         */
        ArrayList<Integer> list1 = new ArrayList<>();// 创建一个用来存储偶数的集合
        for(int i = 0;i<list.size();i++){
            // 获取list集合中的元素
            int num = list.get(i);
            // 判断
            if(num % 2 == 0){
                list1.add(num);
            }
        }

        return list1;
    }

    private static void method02() {
        Weapon wp = new Weapon("大宝剑");// 创建武器

        FaShu faShu = new FaShu() {
            @Override
            public void faShuAttach() {
                System.out.println("我的法术是:德玛西亚正义");
            }
        };// 创建法术

        Hero hero = new Hero("盖伦",wp,faShu);// 创建英雄对象,该英雄具备武器,具备法术

        System.out.println("我叫:"+hero.getName()+",我的武器是:"+hero.getWp().getNameCode());


        hero.startFaShu();// 英雄启动法术


//        String name; // 引用数据类型来声明局部变量  系统定义的类
//        Person p;// 引用数据类型声明局部变量   自定义的类
    }

}
