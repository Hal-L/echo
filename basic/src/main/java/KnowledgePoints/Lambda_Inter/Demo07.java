package KnowledgePoints.Lambda_Inter;

public class Demo07 {
    // 递归: 方法中自己调用自己
    public static void main(String[] args) {
        int sum = getSum(100);
        System.out.println(sum); // 5050
    }

    // 方法: 完成某个功能的若干代码的集合
    // 功能: 获取 i 和 前边所有数相加的和
    private static int getSum(int i) {
        System.out.println("刚进入方法时: i = " + i);
        // 特例: 1和前边所有数相加的结果就是 1
        if (i == 1) {
            return 1;
        }
        // 进入方法i是100, 需求: 求出100 和前边所有数相加的和, 手里有100 , 缺 99 和前边所有数相加的和
        // 需求: 求出 99 和 前边所有数相加的和  ?  这个事情谁可以做 ? 自己可以做: 参数传 99 = i-1
        // 后续进入方法,以此类推 ....
        int result = i + getSum(i - 1);
        System.out.println("方法结束时: i = " + i);
        return result;
        // 递归的使用场景: 在方法中,发现要做的事恰巧自己可以做,调用自己
    }
}
