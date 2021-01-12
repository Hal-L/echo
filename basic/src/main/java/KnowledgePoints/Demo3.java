package KnowledgePoints;

public class Demo3 {
    // 递归:方法中自己调用自己
    public static void main(String[] args) {
        int sum = getSum(100);
        System.out.println(sum);

        int sum1 = getSum1(1);
        System.out.println(sum1);
    }

    private static int getSum(int i) {
        if (i == 1) {
            return 1;
        }
        int result = i + getSum(i - 1);
        return result;
    }

    private static int getSum1(int i) {
        if (i == 100) {
            return 100;
        }
        int result = i + getSum1(i + 1);
        return result;
    }
}

