package KnowledgePoints.src.Teacher.test04_ThreadPool;

import java.util.concurrent.*;

public class Test01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();

        Future<Integer> f = service.submit(new MyCallable());

        Integer integer = f.get();//阻塞式

        System.out.println(integer);
    }
}

class MyCallable implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}