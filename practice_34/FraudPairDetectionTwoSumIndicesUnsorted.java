import java.util.*;

public class FraudPairDetectionTwoSumIndicesUnsorted {

    static int[] findFraudPair(int[] amounts, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(amounts[i], i);
        }
        return new int[]{-1, -1};
    }

    static void print(int[] a) {
        System.out.print(a[0] + " " + a[1]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] amounts = new int[n];
        for (int i = 0; i < n; i++) amounts[i] = input.nextInt();
        int target = input.nextInt();
        int[] res = findFraudPair(amounts, target);
        print(res);
    }
}

