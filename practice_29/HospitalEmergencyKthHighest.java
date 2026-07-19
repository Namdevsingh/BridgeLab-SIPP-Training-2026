import java.util.*;

public class HospitalEmergencyKthHighest {
    static int kthHighest(int[] priorities, int k) {
        for (int i = 0; i < priorities.length - 1; i++) {
            for (int j = 0; j < priorities.length - 1 - i; j++) {
                if (priorities[j] < priorities[j + 1]) {
                    int t = priorities[j];
                    priorities[j] = priorities[j + 1];
                    priorities[j + 1] = t;
                }
            }
        }
        return priorities[k - 1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = input.nextInt();
        int k = input.nextInt();
        System.out.print(kthHighest(p, k));
    }
}

