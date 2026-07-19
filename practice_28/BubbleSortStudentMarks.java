import java.util.*;

public class BubbleSortStudentMarks {
    static void bubbleSort(int[] a) {
        boolean swapped;
        for (int i = 0; i < a.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] marks = new int[n];
        for (int i = 0; i < n; i++) marks[i] = input.nextInt();
        bubbleSort(marks);
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(marks[i]);
        }
    }
}

