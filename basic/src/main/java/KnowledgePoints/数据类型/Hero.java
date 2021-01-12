package KnowledgePoints.数据类型;

public class Hero {// 英雄类

    private String name;// 引用数据类型声明成员变量  系统定义的类

    private Weapon wp;// 引用数据类型声明成员变量 自定义的类

    private FaShu faShu;// 引用数据类型声明成员变量   自定义的接口

    public Hero() {
    }

    public Hero(String name, Weapon wp,FaShu faShu) {
        this.name = name;
        this.wp = wp;
        this.faShu = faShu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWp() {
        return wp;
    }

    public void setWp(Weapon wp) {
        this.wp = wp;
    }

    public FaShu getFaShu() {
        return faShu;
    }

    public void setFaShu(FaShu faShu) {
        this.faShu = faShu;
    }

    // 成员方法,英雄发动法术,法术攻击
    public void startFaShu(){
        System.out.println("启动法术");

        faShu.faShuAttach();// 法术攻击

        System.out.println("结束法术");
    }
}
