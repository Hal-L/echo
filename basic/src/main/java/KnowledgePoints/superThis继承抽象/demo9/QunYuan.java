package KnowledgePoints.superThis继承抽象.demo9;

import java.util.ArrayList;
import java.util.Random;

public class QunYuan extends User {

    public QunYuan() {
    }

    public QunYuan(String name, int leftMoney) {
        super(name, leftMoney);
    }

/*    方法: 抢红包的方法
            1.明确方法的返回值类型   void
            2.明确方法的方法名      qiangHongBao
            3.明确方法的参数       ArrayList<Integer>集合
            4.明确方法的方法体
                     随机抢红包,修改自己的余额*/
    public void qiangHongBao(ArrayList<Integer> list){
        // 1.生成一个list集合随机索引
//        int index = new Random().nextInt(list.size());
        Random r = new Random();
        int index = r.nextInt(list.size());// 0---list.size()-1

        // 2.根据索引去集合中拿红包,集合就减少一个红包
        Integer redMoney = list.get(index);
        list.remove(index);

        // 3.存入余额
        int leftMoney = getLeftMoney();
        setLeftMoney(leftMoney + redMoney); // 修改余额

    }
}
