import java.util.*;

public class SearchInRotatedSortedArrayFirstLastMin {

    static int findMin(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) left = mid + 1;
            else right = mid;
        }
        return arr[left];
    }

    static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    static int[] firstLastOccurrenceInSorted(int[] sorted, int target) {
        int first = bound(sorted, target, true);
        int last = bound(sorted, target, false);
        return new int[]{first, last};
    }

    static int bound(int[] nums, int target, boolean first) {
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                if (first) right = mid - 1;
                else left = mid + 1;
            } else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();
        int target = input.nextInt();

        int minVal = findMin(arr);
        int idx = search(arr, target);

        int[] sorted = arr.clone();
        Arrays.sort(sorted);
        int[] fl = firstLastOccurrenceInSorted(sorted, target);

        System.out.println(minVal);
        System.out.println(idx);
        System.out.println(fl[0] + " " + fl[1]);
    }
}

