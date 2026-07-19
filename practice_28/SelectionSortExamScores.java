import java.util.*;

public class SelectionSortExamScores {
    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int t = a[i];
                a[i] = a[minIdx];
                a[minIdx] = t;
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = input.nextInt();
        selectionSort(scores);
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(scores[i]);
        }
    }
}

