package KnowledgePoints.src.Teacher.test01_customer01;

public class Test01 {

    public static void main(String[] args) {
        Cooker c = new Cooker();
        Foodie f = new Foodie();

        c.start();
        f.start();
    }
}

class Desk {
    public static  int count = 10;//每日供应汉堡包的数量

    public static final Object obj = new Object();//锁对象
}

class Cooker extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.obj) {
                if (Desk.count == 0) {
                    break;
                } else {
                    System.out.print("厨师正在");
                    System.out.print("生产汉堡包");
                    System.out.print("\r\n");
                }
            }
        }
    }
}

class Foodie extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.obj) {
                if (Desk.count == 0) {
                    break;
                } else {
                    System.out.print("吃货正在");
                    System.out.print("吃汉堡包");
                    System.out.print("\r\n");
                    Desk.count--;
                }
            }
        }
    }
}
