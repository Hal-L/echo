package KnowledgePoints.src.Teacher.test02_customer02;

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

    public static boolean flag = false;//定义一个标记.false表示没有汉堡包,true代表有汉堡包
}

class Cooker extends Thread{
    @Override
    public void run() {
        while (true) {
            synchronized (Desk.obj) {
                if (Desk.count == 0) {
                    break;
                } else {
                    if (Desk.flag == false) {
                        System.out.print("厨师正在");
                        System.out.print("生产汉堡包");
                        System.out.print("\r\n");

                        Desk.flag = true;
                        Desk.obj.notifyAll();

                    }else{
                        try {
                            Desk.obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
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
                    if (Desk.flag == true) {
                        System.out.print("吃货正在");
                        System.out.print("吃汉堡包");
                        System.out.print("\r\n");
                        Desk.count--;

                        Desk.flag = false;
                        Desk.obj.notifyAll();
                    }else {
                        try {
                            Desk.obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
