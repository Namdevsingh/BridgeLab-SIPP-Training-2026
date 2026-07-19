import java.util.*;

public class BubbleSortSwapCount {
    static long bubbleSortAndCount(int[] a) {
        long swaps = 0;
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return swaps;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = input.nextInt();
        System.out.print(bubbleSortAndCount(nums));
    }
}

