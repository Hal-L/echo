package KnowledgePoints.superThis继承抽象.demo9;

import java.util.ArrayList;

public class QunZhu extends User {

    public QunZhu() {
    }

    public QunZhu(String name, int leftMoney) {
        super(name, leftMoney);
    }


    /*
        方法: 发红包的方法  有返回值有参数的方法
            1.明确方法的返回值类型   ArrayList<Integer>集合
            2.明确方法的方法名      faHongBao
            3.明确方法的参数       2个   红包金额 int    红包个数 int count
            4.明确方法的方法体
                    把红包平均分成count等份,修改自己的余额
     */
    public ArrayList<Integer> faHongBao(int redMoney,int count){//10 3
        // 0.获取自己的余额
        int leftMoney = getLeftMoney();

        // 1. 判断余额是否够发红包
        if(leftMoney < redMoney){
        // 2.如果余额不够发红包,就返回null
            return null;
        }else{
            // 3.如果余额够发红包,就发
            // 4.计算平均每个红包的金额
            int avg = redMoney / count;

            // 5.计算除不尽剩余的金额
            int left = redMoney % count;

            // 6.把平均分好的红包放入集合中,需要把除不尽剩余的金额放入最后一个包中
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0 ;i<count-1;i++){
                list.add(avg);
            }
            list.add(avg + left);

            // 修改群主的余额
            setLeftMoney(leftMoney - redMoney);

            // 7.返回集合
            return list;
        }
    }
}
