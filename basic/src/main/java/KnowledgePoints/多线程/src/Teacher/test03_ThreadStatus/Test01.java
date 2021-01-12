package KnowledgePoints.src.Teacher.test03_ThreadStatus;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(()->{
            System.out.println("2:创建的t线程,执行start方法后,线程的状态:"+Thread.currentThread().getState());//Runnable

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("4:创建的t线程执行sleep方法后,线程的状态:"+Thread.currentThread().getState());//RUNNABLE
        });

        System.out.println("1:创建了t线程,但是没有调用start方法的线程的状态:"+t.getState());//new
        t.start();

        Thread.sleep(50);//主线程休眠50毫秒

        System.out.println("3:创建的t线程在执行sleep方法的时候,线程的状态:"+t.getState());//Timed waiting

        Thread.sleep(200);//主线程休眠200毫秒

        System.out.println("5:创建的t线程在执行完毕之后的时候,线程的状态:"+t.getState());//Terminated

    }
}
