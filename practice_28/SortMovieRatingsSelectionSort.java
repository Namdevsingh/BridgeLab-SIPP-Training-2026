import java.util.*;

public class SortMovieRatingsSelectionSort {
    static void selectionSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) min = j;
            }
            int t = a[i];
            a[i] = a[min];
            a[min] = t;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) ratings[i] = input.nextInt();
        selectionSort(ratings);
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(ratings[i]);
        }
    }
}

