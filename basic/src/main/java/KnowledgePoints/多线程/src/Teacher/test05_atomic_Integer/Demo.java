package KnowledgePoints.src.Teacher.test05_atomic_Integer;

public class Demo {
    public static void main(String[] args) {
        TicketRunnable tr = new TicketRunnable();

        //创建三个线程
        Thread t1 = new Thread(tr,"班长");
        Thread t2 = new Thread(tr,"班花");
        Thread t3 = new Thread(tr,"班草");

        //卖票
        t1.start();
        t2.start();
        t3.start();
    }
}
