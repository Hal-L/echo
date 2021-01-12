package KnowledgePoints.Lambda_Inter;

/**
 * @Author: fg
 * @Date: 2020/8/10 16:31
 */
public class Demo03 {
    /**
     * Lambda: 可以推导的就是可以省略的
     *
     * 使用Lambda表达式的前提:
     *      1. 必须有函数式接口:
     *              接口中有且只有一个抽象方法
     *      2. 必须有上下文推断
     *          Lambda表达式作为方法的参数,算是有上下文推断环境
     *          Lambda表达式作为方法的局部变量,算是有上下文推断环境
     *          Lambda表达式作为方法的返回值,算是有上下文推断环境
     */
    public static void main(String[] args) {

        // Lambda表达式作为方法的参数,算是有上下文推断环境
        accept(() -> {
            System.out.println("如今的现在,早已不是曾经说好的以后");
        });
        // Lambda表达式作为方法的局部变量,算是有上下文推断环境
        Inter inter = () -> {
            System.out.println("如今的现在,早已不是曾经说好的以后");
        };
    }
    public static void accept(Inter inter){
        inter.show();
    }

    public static Inter getInter(){
        /*Inter inter = new Inter(){
            @Override
            public void show() {
                System.out.println("三里清风,三里路,步步风里步步你");
            }
        };
        return inter;*/
        /*return new Inter(){
            @Override
            public void show() {
                System.out.println("三里清风,三里路,步步风里步步你");
            }
        };*/
        /*Inter inter = ()->{
            System.out.println("天在下雨,我在想你~");
        };
        return inter;*/

        // Lambda表达式作为方法的返回值,算是有上下文推断环境
        return ()->{
            System.out.println("天在下雨,我在想你~");
        };
    }
}

