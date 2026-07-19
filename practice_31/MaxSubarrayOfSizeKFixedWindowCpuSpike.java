import java.util.*;

public class MaxSubarrayOfSizeKFixedWindowCpuSpike {

    static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];
            if (end >= k - 1) {
                if (windowSum > maxSum) maxSum = windowSum;
                windowSum -= cpuLoad[start];
                start++;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] cpu = new int[n];
        for (int i = 0; i < n; i++) cpu[i] = input.nextInt();
        int k = input.nextInt();
        System.out.print(maxSubarrayOfSizeK(cpu, k));
    }
}

