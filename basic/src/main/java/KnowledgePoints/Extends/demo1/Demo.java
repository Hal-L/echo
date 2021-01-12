package KnowledgePoints.Extends.demo1;
/*
   继承:
        格式:
            public class 类A extends 类B{

            }

            类A:子类
            类B:父类

        1.不要为了继承而继承
                例如: 狗类: 姓名,年龄,吃喝拉撒的方法
                     人类: 姓名,年龄,吃喝拉撒的方法
        2.子类继承父类之后,拥有父类的非私有属性和非私有方法

   抽象类: 用abstract修饰的类就是一个抽象类
        1.抽象类不能创建对象,只能通过创建其子类对象来使用
        2.抽象类仅仅只是比普通类多了抽象方法
        3.有抽象方法的类一定是抽象类,但是抽象类不一定有抽象方法

    super:代表父类
    this: 代表当前对象


    发红包的案例:
            思路:
                1.找类
                2.分析类中有什么
                3.代码实现类中的成员
                4.创建对象,完成项目需求
           0.成员类:
                属性: 姓名,余额
                方法: 显示信息的方法

           1.群主类  继承成员类
                行为:
                    发红包的方法
                    1.定义的方法
                    public ArrayList<Integer>  send(int totalMoney,int count){
                        1.获取自己的余额
                        2.判断是否够发红包
                        3.如果要发的红包金额大于余额,那就不发红包,返回null
                        4.如果要发的红包金额小于等于余额,就发红包
                        5.把红包金额平均分成count等份
                        6.求出除不尽的余额,把这个剩余的金额放入最后一个红包
                        7.修改群主余额
                        8.返回集合

                    }

           2.群员类   继承成员类
               行为:
                    抢红包的方法
                    public void receive(ArrayList<Integer> list){
                        1.随机生成list集合的一个索引
                        2.根据索引获取红包
                        3.list红包集合要删除一个红包
                        4.修改余额
                    }

           3.测试类

 */
public class Demo {
    public static void main(String[] args) {

    }

}
