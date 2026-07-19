import java.util.*;

public class TwoSumTargetPairFraudDetectionSorted {

    static int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;
        while (left < right) {
            int sum = transactions[left] + transactions[right];
            if (sum == target) return new int[]{left, right};
            if (sum < target) left++;
            else right--;
        }
        return new int[]{-1, -1};
    }

    static void printIntArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(arr[i]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] transactions = new int[n];
        for (int i = 0; i < n; i++) transactions[i] = input.nextInt();
        int target = input.nextInt();
        int[] res = findPairSum(transactions, target);
        printIntArray(res);
    }
}

