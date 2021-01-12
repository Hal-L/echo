package KnowledgePoints.Lambda_Inter;

/**
 * @Author: fg
 * @Date: 2020/8/11 16:51
 */
public class Demo04 {
    public static void main(String[] args) {
        int result = getJc(3);
        System.out.println(result);
    }

    // 功能: 求出 n 和前边所有数相乘的结果
    public static int getJc(int n) {
        // 特例: 1和前边所有数相乘的结果就是 1
        if (n == 1) {
            return 1;
        }

        // 手里只有n, 前边所有数相乘的结果没有
        // 需求: 求出 n-1 和前边所有数相乘的结果  和 手里的n 相乘
        int result = n * getJc(n - 1);

        return result;
    }
}
