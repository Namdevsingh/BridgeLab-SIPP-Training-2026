import java.util.*;

public class BankFraudDetectionCountSuspiciousPairs {
    static long countPairs(int[] a) {
        int n = a.length;
        int[] temp = new int[n];
        return sortCount(a, temp, 0, n - 1);
    }

    static long sortCount(int[] a, int[] temp, int l, int r) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        long cnt = sortCount(a, temp, l, m) + sortCount(a, temp, m + 1, r);

        int j = m + 1;
        for (int i = l; i <= m; i++) {
            while (j <= r && (long) a[i] > 3L * (long) a[j]) j++;
            cnt += (j - (m + 1));
        }

        int i = l, k = l;
        j = m + 1;
        while (i <= m && j <= r) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
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
        System.out.print(countPairs(a));
    }
}

