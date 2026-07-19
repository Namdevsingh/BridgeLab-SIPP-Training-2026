import java.util.*;

public class LongestSubarrayAtMostNDistinctApiRateLimiter {

    static int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {
        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int maxLen = 0;

        for (int end = 0; end < keyIds.length; end++) {
            int val = keyIds[end];
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            while (freq.size() > n) {
                int leftVal = keyIds[start];
                int count = freq.get(leftVal) - 1;
                if (count == 0) freq.remove(leftVal);
                else freq.put(leftVal, count);
                start++;
            }

            int curLen = end - start + 1;
            if (curLen > maxLen) maxLen = curLen;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int[] keyIds = new int[m];
        for (int i = 0; i < m; i++) keyIds[i] = input.nextInt();
        int n = input.nextInt();
        System.out.print(longestSubarrayWithAtMostNDistinct(keyIds, n));
    }
}

