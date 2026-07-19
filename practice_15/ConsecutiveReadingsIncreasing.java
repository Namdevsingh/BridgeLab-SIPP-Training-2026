import java.util.*;

public class ConsecutiveReadingsIncreasing {
    static boolean strictlyIncreasing(int[] arr, int index) {
        if (index >= arr.length - 1) return true;
        if (arr[index] >= arr[index + 1]) return false;
        return strictlyIncreasing(arr, index + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();
        System.out.print(strictlyIncreasing(arr, 0));
    }
}

