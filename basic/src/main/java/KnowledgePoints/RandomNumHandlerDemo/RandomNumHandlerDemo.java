package KnowledgePoints.RandomNumHandlerDemo;

import java.util.Random;

interface RandomNumHandler {
    int getNumber();
}
// 匿名内部类:编译之后,产生一个单独的.class 字节码文件
class RandImpl implements RandomNumHandler {
    @Override
    public int getNumber() {
        Random r1 = new Random();
        int i = r1.nextInt(20) + 6;
        return i;
    }
}

public class RandomNumHandlerDemo {
    public static void main(String[] args) {
        // 匿名内部类
        useRandomNumHandler(new RandomNumHandler() {
            @Override
            public int getNumber() {
                Random r = new Random();
                int num = r.nextInt(10) + 1;
                return num;
            }
        });
        // lambda表达式
        useRandomNumHandler(() -> {
            Random r = new Random();
            int num = r.nextInt(10) + 1;
            return num;
        });
    }

    public static void useRandomNumHandler(RandomNumHandler randomNumHandler) {
        int result = randomNumHandler.getNumber();
        System.out.println(result);
    }
}

