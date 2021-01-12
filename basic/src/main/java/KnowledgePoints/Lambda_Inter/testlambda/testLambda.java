package KnowledgePoints.Lambda_Inter.testlambda;

public class testLambda {
    public static void main(String[] args) {
        useShowHandler(new ShowHandler() {
            @Override
            public void show(String msg) {
                System.out.println("匿名内部类中的show方法===="+msg);
            }
        });
    //    lambda实现
        useShowHandler((String msg) -> {
            System.out.println("lambda中的show方法....."+msg);
        });
    }

    /**
     * @ShowHand
     * @param showHandler
     */
    public static void useShowHandler(ShowHandler showHandler){// 要的时接口,给实现类对象
        showHandler.show("hello word");
    }
}
@FunctionalInterface
interface ShowHandler{
    void show(String msg);
}