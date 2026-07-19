public class ZeroFilledSubarrays_2348 {
    public static long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        long run = 0;
        for (int x : nums) {
            if (x == 0) {
                run++;
            } else {
                ans += run * (run + 1) / 2;
                run = 0;
            }
        }
        ans += run * (run + 1) / 2;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 0, 0, 2, 0};
        System.out.print(zeroFilledSubarray(nums));
    }
}

