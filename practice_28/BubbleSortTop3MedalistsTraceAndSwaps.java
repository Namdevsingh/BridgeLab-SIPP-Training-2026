public class BubbleSortTop3MedalistsTraceAndSwaps {

    static long bubbleSortCountSwaps(int[] a) {
        long swaps = 0;
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        return swaps;
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
    }

    static void insertionSortCountPassTrace(int[] a) {
        long swaps = 0;
        boolean alreadySorted = true;
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            if (a[j] > key) alreadySorted = false;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                swaps++;
                j--;
            }
            a[j + 1] = key;
            System.out.print("Pass " + i + ": ");
            printArray(a);
            System.out.println();
        }
        System.out.print("Insertion sort swaps/moves count: " + swaps);
        System.out.println();
        System.out.print("Best case already sorted flag: " + alreadySorted);
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("Trace array [64,25,12,22,11] - Bubble Sort passes:");
        int[] b = arr.clone();
        long swaps = 0;
        for (int i = 0; i < b.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < b.length - 1 - i; j++) {
                if (b[j] > b[j + 1]) {
                    int t = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = t;
                    swaps++;
                    swapped = true;
                }
            }
            System.out.print("Pass " + (i + 1) + ": ");
            printArray(b);
            System.out.println();
            if (!swapped) break;
        }

        System.out.println("Total swaps in Bubble Sort: " + swaps);

        int[] sorted = b;
        System.out.println("Top-3 medalists (highest scores):");
        System.out.println(sorted[sorted.length - 1] + " (Gold)");
        System.out.println(sorted[sorted.length - 2] + " (Silver)");
        System.out.println(sorted[sorted.length - 3] + " (Bronze)");

        System.out.println("\nInsertion Sort trace passes (on original array):");
        int[] ins = arr.clone();
        insertionSortCountPassTrace(ins);
    }
}

