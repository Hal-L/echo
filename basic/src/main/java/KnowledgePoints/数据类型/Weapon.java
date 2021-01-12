package KnowledgePoints.数据类型;

public class Weapon {// 武器类

    private String nameCode;// 武器代号   引用数据类型声明成员变量  系统定义的类

    public Weapon() {
    }

    public Weapon(String nameCode) {
        this.nameCode = nameCode;
    }

    public String getNameCode() {
        return nameCode;
    }

    public void setNameCode(String nameCode) {
        this.nameCode = nameCode;
    }
}
