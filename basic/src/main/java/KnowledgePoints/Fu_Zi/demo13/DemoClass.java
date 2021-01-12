package KnowledgePoints.Fu_Zi.demo13;
/*
进行描述笔记本类，实现笔记本使用USB鼠标、USB键盘

- USB接口，包含开启功能、关闭功能
- 笔记本类，包含运行功能、关机功能、使用USB设备功能
- 鼠标类，要实现USB接口，并具备点击的方法
- 键盘类，要实现USB接口，具备敲击的方法

 */
public class DemoClass {
    public static void main(String[] args) {
        // 创建一台笔记本电脑
        Laptop lt = new Laptop();

        // 创建鼠标和键盘
        Mouse mouse = new Mouse();
        Keyboard kb = new Keyboard();

        // 开启笔记本电脑
        lt.run();

        // 使用鼠标
        lt.useUsb(mouse);

        System.out.println("====================");

        // 使用键盘
        lt.useUsb(kb);

        // 关闭笔记本
        lt.shutDown();

    }
}
