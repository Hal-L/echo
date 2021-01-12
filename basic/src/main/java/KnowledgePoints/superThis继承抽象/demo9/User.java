package KnowledgePoints.superThis继承抽象.demo9;

public class User {

    private String name;// 姓名

    private int leftMoney;// 余额

    public User() {
    }

    public User(String name, int leftMoney) {
        this.name = name;
        this.leftMoney = leftMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeftMoney() {
        return leftMoney;
    }

    public void setLeftMoney(int leftMoney) {
        this.leftMoney = leftMoney;
    }

    public void show(){
        System.out.println("我是:"+name+",我的余额是:"+leftMoney);
    }
}
