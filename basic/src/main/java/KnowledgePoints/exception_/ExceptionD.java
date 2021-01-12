package KnowledgePoints.exception_;


import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ExceptionD {
    public static void main(String[] args) throws ParseException {
        //method1(); //此时调用者也没有处理.还是会交给虚拟机处理.
        //method2(); //还是继续交给调用者处理.而main方法的调用者是虚拟机还是会采取虚拟机默认处理异常的方法.


        //好处:为了能让代码继续往下运行.
        int [] arr = {1,2,3,4,5};
        //int [] arr = null;
        try{
            printArr(arr);//就会 接收到一个异常.
        }catch (NullPointerException e){
            //如果出现了这样的异常,那么我们进行的操作
            System.out.println("参数不能为null");
        }
        //我们还需要自己处理一下异常.



        System.out.println("家里有一个貌美如花的老婆");
        System.out.println("还有一个当官的兄弟");
        System.out.println("自己还有一个买卖");
        System.out.println("这样的生活你要不要?");
        throw new RuntimeException(); //当代码执行到这里,就创建一个异常对象
        //该异常创建之后,暂时没有手动处理.抛给了调用者处理
        //下面的代码不会再执行了.
        //System.out.println("武大郎的标准生活");



    }



    private static void printArr(int[] arr) {
        if(arr == null){
            //调用者知道成功打印了吗?
            //System.out.println("参数不能为null");
            throw new NullPointerException(); //当参数为null的时候
            //手动创建了一个异常对象,抛给了调用者.
        }else{
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }


    //告诉调用者,你调用我,有可能会出现这样的异常哦.
    //如果方法中没有出现异常,那么正常执行
    //如果方法中真的出现了异常,其实也是将这个异常交给了调用者处理.
    //如果声明的异常是一个运行时异常,那么声明的代码可以省略
    private static void method1() /*throws NullPointerException*/ {
        int [] arr = null;
        for (int i = 0; i < arr.length; i++) {//出现的空指针异常,还是由虚拟机创建出来的.
            System.out.println(arr[i]);
        }
    }

    //告诉调用者,你调用我,有可能会出现这样的异常哦.
    //如果方法中没有出现异常,那么正常执行
    //如果方法中真的出现了异常,其实也是将这个异常交给了调用者处理.
    //如果声明的异常是一个编译时异常,那么声明的代码必须要手动写出.
    private static void method2() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        sdf.parse("2048-10月10日");
    }
}
