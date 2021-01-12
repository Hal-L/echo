package KnowledgePoints.src.Teacher.test06_ArrayList_safe;

import java.util.concurrent.CopyOnWriteArrayList;

public class Test01 {

    public static void main(String[] args) throws InterruptedException {
        MyThread m1 = new MyThread();
        MyThread m2 = new MyThread();

        m1.start();
        m2.start();

        Thread.sleep(2000);

        System.out.println(MyThread.arr.size());
    }

}

class MyThread extends Thread{
    /*public  static ArrayList<Integer> arr = new ArrayList<>();*/
    public  static  CopyOnWriteArrayList arr = new CopyOnWriteArrayList();

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            arr.add(i);
        }
        System.out.println("添加完毕!");
    }
}
