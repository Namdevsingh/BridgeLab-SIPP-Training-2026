import java.util.*;

public class SubarraySumEqualsK_GenericLeetCode563Like {
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);
        int prefix = 0;
        int count = 0;

        for (int x : nums) {
            prefix += x;
            int need = prefix - k;
            if (freq.containsKey(need)) count += freq.get(need);
            freq.put(prefix, freq.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, -2, 5};
        int k = 3;
        System.out.print(subarraySum(nums, k));
    }
}

