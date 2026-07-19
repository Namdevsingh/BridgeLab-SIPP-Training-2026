import java.util.*;

public class MostFrequentErrorCodeFrequencyMap {

    static int mostFrequentErrorCode(int[] codes) {
        Map<Integer, Integer> freq = new HashMap<>();
        int bestCode = codes[0];
        int bestCount = 0;

        for (int code : codes) {
            int count = freq.merge(code, 1, Integer::sum);
            if (count > bestCount) {
                bestCount = count;
                bestCode = code;
            }
        }

        return bestCode;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] codes = new int[n];
        for (int i = 0; i < n; i++) codes[i] = input.nextInt();
        System.out.print(mostFrequentErrorCode(codes));
    }
}

