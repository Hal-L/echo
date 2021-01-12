package KnowledgePoints.Lambda_Inter;

import java.util.ArrayList;

/**
 * @Author: fg
 * @Date: 2020/8/10 10:38
 */
public class Demo01 {
    /**
     * 匿名对象:
     *      没有名字的对象, 省略了对象名
     * 特点:
     *      只能使用一次,一个对象只能使用一次,只能调用一次方法
     * 使用场景:
     *      当一个对象只使用一次时可以使用匿名对象
     * 匿名内部类:
     *      没有名字的内部类,省略了类名
     *  格式:
     *      new 类名/接口名(){
     *          // 重写的方法
     *      }
     *  本质:
     *      是某一个父类或者父接口的子类对象
     *  特点:
     *      只能使用一次,一个类只能使用,只能创建一次对象
     *  使用场景:
     *      当一个类只使用一次时可以使用匿名内部类
     */
    public static void main(String[] args) {
        ArrayList<Student> arrayList = new ArrayList<>();
        Student student01 = new Student("杨幂",33); // 我老公呢
        student01.setName("大幂幂");
        student01.setAge(34);
        arrayList.add(student01);
        arrayList.add(new Student("迪丽热巴",25));

        new Student("古力娜扎",25).setName("扎扎");
        new Student("古力娜扎",25).setAge(26); // 又new了一次,这是另外一个人了
        System.out.println("-------------------------------------------------------------");

        // 3.Inter 说明后边的没有名字的子类是 Inter的子类
        // 4. new 说明当前要创建对象,创建的是Inter的没有名字的子类的对象
        // 5.Inter inter = : =号左边是Inter类型,右边是没有名字的子类对象,这是多态的标准格式
        Inter inter = new Inter() {
            // 1.show是一个方法,只有类中才可以写方法,说明当前所在位置是一个类
            // 2.@Override 说明当前的show方法,是一个重写的方法,说明当前所在的类是一个子类
            @Override
            public void show() {
                System.out.println("这是匿名内部类重写的show方法");
            }
        };
        // 6.inter.show() 多态中方法调用,编译看左,运行看右
        inter.show();
        inter.show();
        System.out.println("-------------------");
        // 这种写法,既是匿名对象,又是匿名内部类
        new Inter(){
            @Override
            public void show() {
                System.out.println("这是我又一次重写了show方法");
            }
        }.show();

        new Inter(){
            @Override
            public void show() {
                System.out.println("这是我第三次重写了show方法");
            }
        }.show();

    }
}
