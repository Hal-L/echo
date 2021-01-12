package day02.day02_多态_抽象类_接口;

/**
 * @Author: fg
 * @Date: 2020/8/7 14:57
 */
public class Demo02 {
    /**
     * 父类:
     *     动物:
     *          姓名,年龄
     * 子类:
     *      狗:
     *          姓名,年龄,       颜色
     */
    public static void main(String[] args) {
        // 空参创建对象,后面set方法赋值
        Dog dog = new Dog();
        dog.setName("旺财");
        dog.setAge(2);
        dog.setColor("屎黄色");
        // 带参创建对象
        Dog dog01 = new Dog("大黄",3,"屎黄色");
    }

}
