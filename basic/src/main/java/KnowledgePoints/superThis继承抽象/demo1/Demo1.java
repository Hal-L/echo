package KnowledgePoints.superThis继承抽象.demo1;
/*
    String类:
        构造方法:
            String()
            String(byte[] bys)
            String(char[] chs)
            String(String str)
        成员方法:
            获取功能
                charAt(int index)
                indexOf(char ch)
                lastIndexOf(char ch)
                length()
                .....
            判断功能
                equals(Object o)
                ...
            截取功能
                substring(int beginIndex)
                substring(int beginIndex,int endIndex)
                ....
            其他功能
                ....
   static关键字: 被static修饰的成员,是直接属于类的,而不是单单属于某个对象的
        1.修饰成员变量
            该变量会变成一个静态变量,该变量就会被该类的所有对象共享,也就是说该类的所有对象使用的是同一份数据
             类名.成员变量名  访问
        2.修饰成员方法
            被修饰的成员会变成一个静态方法, 类名.成员方法名()  访问

            注意:
                1.静态方法中 不能写this
                2.静态方法中 只能直接访问静态成员

   Arrays类:
        1.String toString(int[] arr)
        2.sort(int[] arr); 默认升序
   Math类:
       1.double PI
       2.abs(int num)
       3.round(double d)  四舍五入
       4.ceil(double d)   大于参数的最小整数
       5.floor(double d)  小于参数的最大整数
       6.max(int num1,int num2)
       7.min(int num1,int num2)
 */
public class Demo1 {
    public static void main(String[] args) {

    }
}
