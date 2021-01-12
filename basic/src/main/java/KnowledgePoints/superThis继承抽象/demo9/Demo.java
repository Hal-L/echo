package KnowledgePoints.superThis继承抽象.demo9;

import java.util.ArrayList;

/*
综合案例：群主发普通红包

群主发普通红包。某群有多名成员，群主给成员发普通红包。普通红包的规则：
    1. 群主的一笔金额，从群主余额中扣除，平均分成n等份，让成员领取。
    2. 成员领取红包后，保存到成员余额中。

请根据描述，完成案例中所有类的定义以及指定类之间的继承关系，并完成发红包的操作。

思路:
    1.成员类:
        属性: 姓名  余额
        方法: 显示信息的方法

    2.群主类: 继承成员类
        方法: 发红包的方法  有返回值有参数的方法
            1.明确方法的返回值类型   ArrayList<Integer>集合
            2.明确方法的方法名      faHongBao
            3.明确方法的参数       2个   红包金额 int    红包个数 int count
            4.明确方法的方法体
                    把红包平均分成count等份,修改自己的余额

    3.群员类: 继承成员类
        方法: 抢红包的方法
            1.明确方法的返回值类型   void
            2.明确方法的方法名      qiangHongBao
            3.明确方法的参数       ArrayList<Integer>集合
            4.明确方法的方法体
                    随机抢红包,修改自己的余额

 */
public class Demo {
    public static void main(String[] args) {
        QunZhu qz = new QunZhu("群主",100);// 创建一个群主对象

        // 创建群员对象
        QunYuan qy1 = new QunYuan("群员1",0);
        QunYuan qy2 = new QunYuan("群员2",0);
        QunYuan qy3 = new QunYuan("群员3",0);

        // 群主发红包
        ArrayList<Integer> list = qz.faHongBao(10, 3);

        // 群员抢红包
        qy1.qiangHongBao(list);
        qy2.qiangHongBao(list);
        qy3.qiangHongBao(list);

        // 展示群员信息
        qy1.show();
        qy2.show();
        qy3.show();
        qz.show();

    }
}
