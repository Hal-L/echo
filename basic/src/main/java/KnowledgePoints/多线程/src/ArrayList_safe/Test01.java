package KnowledgePoints.src.ArrayList_safe;

import java.util.ArrayList;

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


class MyThread extends Thread {
    public static ArrayList<Integer> arr = new ArrayList<>();

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {

        }
    }
}