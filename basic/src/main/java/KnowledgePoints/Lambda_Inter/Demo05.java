package KnowledgePoints.Lambda_Inter;

public class Demo05 {
    public static void main(String[] args) {
//        1，从右开始找比基准数小的
//        2，从左开始找比基准数大的
//        3，交换两个值的位置
//        4，红色继续往左找，蓝色继续往右找，直到两个箭头指向同一个索引为止
//        5，基准数归位
        int[] arr = {6, 1, 2, 7, 9, 11, 3, 4, 5, 10, 14, 8};

        quiteSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quiteSort(int[] arr, int left, int right) {
        // 特例: 当left 大于 right  不需要排序了 (递归的出口)
        if (left > right) {
            return;
        }
        // left和right的值后边会发生变化, 先把他们的值记录下来,留着备用
        int left0 = left;
        int right0 = right;

        //计算出基准数
        int baseNumber = arr[left0];

        while (left != right) {
//        1，从右开始找比基准数小的
            // 循环什么时候会停? 右边的数 小于 基准数
            // 目前这个数需要给他换到左边
            while (arr[right] >= baseNumber && right > left) {
                right--;
            }
//        2，从左开始找比基准数大的
            // 什么时候停? 左边数 大于 基准数时会停 ,  左边这个数一会要把他换到右边
            while (arr[left] <= baseNumber && right > left) {
                left++;
            }
//        3，交换两个值的位置
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
        //基准数归位
        int temp = arr[left];
        arr[left] = arr[left0];
        arr[left0] = temp;

        // 处理左边(排序左边)
        quiteSort(arr, left0, left - 1);
        // 处理右边 (排序右边)
        quiteSort(arr, left + 1, right0);
    }
}

