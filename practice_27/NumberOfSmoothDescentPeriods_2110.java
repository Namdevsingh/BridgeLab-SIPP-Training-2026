public class NumberOfSmoothDescentPeriods_2110 {
    public static long getDescentPeriods(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] - 1) {
                len++;
            } else {
                len = 1;
            }
            ans += len;
            if (len > 0) {
                if (nums[i] < nums[i - 1]) {
                    ans += 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        System.out.print(getDescentPeriods(nums));
    }
}

