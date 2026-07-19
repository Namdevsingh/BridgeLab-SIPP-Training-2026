import java.util.*;

public class WebsiteResponseAnalysisInversions {

    static long countInversions(int[] a) {
        int n = a.length;
        int[] temp = new int[n];
        return mergeSortCount(a, temp, 0, n - 1);
    }

    static long mergeSortCount(int[] a, int[] temp, int l, int r) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        long cnt = mergeSortCount(a, temp, l, m) + mergeSortCount(a, temp, m + 1, r);

        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else {
                cnt += (m - i + 1);
                temp[k++] = a[j++];
            }
        }
        while (i <= m) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];
        for (int x = l; x <= r; x++) a[x] = temp[x];

        return cnt;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = input.nextInt();
        System.out.print(countInversions(a));
    }
}

