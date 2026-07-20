package practice_41;

import java.util.Arrays;

public class Scenario3_HeapSortSensorReadings {
    public static void siftDownMax(int[] arr, int i, int size) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < size && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            siftDownMax(arr, largest, size);
        }
    }

    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            siftDownMax(arr, i, n);
        }

        for (int end = n - 1; end > 0; end--) {
            int tmp = arr[0];
            arr[0] = arr[end];
            arr[end] = tmp;
            siftDownMax(arr, 0, end);
        }
    }

    public static void main(String[] args) {
        int[] readings = {72, 45, 89, 23, 56, 91, 34, 67, 12, 78};

        System.out.println("Original readings: " + Arrays.toString(readings));

        heapSort(readings);

        System.out.println("Sorted readings:   " + Arrays.toString(readings));

        for (int i = 1; i < readings.length; i++) {
            if (readings[i] < readings[i - 1]) {
                System.out.println("ERROR: Not sorted correctly!");
                return;
            }
        }
        System.out.println("Sorting verified: ascending order confirmed.");
    }
}

