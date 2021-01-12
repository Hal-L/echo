package KnowledgePoints.多线程.mythreadpool.src.com.itheima.mythreadpool;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "在执行了");
    }
}
