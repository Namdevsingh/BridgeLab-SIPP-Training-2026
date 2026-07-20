package practice_41;

import java.util.Arrays;

public class Scenario2_HeapifyBatchImport {
    public static void buildHeap(int[] priorities) {
        int n = priorities.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDown(priorities, i, n);
        }
    }

    public static void siftDown(int[] arr, int i, int size) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] < arr[smallest]) {
            smallest = left;
        }
        if (right < size && arr[right] < arr[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            int tmp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = tmp;
            siftDown(arr, smallest, size);
        }
    }

    public static boolean isMinHeap(int[] arr) {
        int n = arr.length;
        for (int i = 0; i <= n / 2 - 1; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < n && arr[left] < arr[i]) return false;
            if (right < n && arr[right] < arr[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] priorities = {45, 12, 78, 3, 56, 23, 89, 14, 67, 34};

        System.out.println("Original array: " + Arrays.toString(priorities));

        buildHeap(priorities);

        System.out.println("Min-heap array: " + Arrays.toString(priorities));
        System.out.println("Valid min-heap: " + isMinHeap(priorities));
    }
}

