package KnowledgePoints.src.Teacher.test05_atomic_Integer;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketRunnable implements Runnable {
    private AtomicInteger tickets = new AtomicInteger(100);
    @Override
    public void run() {

        while (true){
            if (tickets.get() <= 0){
                break;
            }else {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tickets.decrementAndGet();
                System.out.println(Thread.currentThread().getName() + "还剩"+tickets.get()+"张票");
            }
        }

    }
}
