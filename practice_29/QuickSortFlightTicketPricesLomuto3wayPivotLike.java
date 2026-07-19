import java.util.*;

public class QuickSortFlightTicketPricesLomuto3wayPivotLike {

    static void quickSort(int[] a, int l, int r) {
        if (l >= r) return;
        int pivot = a[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (a[j] <= pivot) {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
                i++;
            }
        }
        int t = a[i];
        a[i] = a[r];
        a[r] = t;

        quickSort(a, l, i - 1);
        quickSort(a, i + 1, r);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) prices[i] = input.nextInt();
        quickSort(prices, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(prices[i]);
        }
    }
}

