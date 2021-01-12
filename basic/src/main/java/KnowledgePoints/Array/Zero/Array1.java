package KnowledgePoints.Array.Zero;

public class Array1 {
    public static void main(String[] args) {
        int[] arr = {23, 34, 26, 87, 12};
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("max:" + max + "--------" + "min:" + min);
    }
}
