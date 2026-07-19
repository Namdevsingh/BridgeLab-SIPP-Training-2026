import java.util.*;

public class CharacterFrequencyNestedLoops1DCharsFreq {
    static String[] frequencies(String text) {
        char[] chars = text.toCharArray();
        int n = chars.length;

        int[] freq = new int[n];
        for (int i = 0; i < n; i++) freq[i] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (chars[i] != '\0' && chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '\0';
                }
            }
        }

        int uniqueCount = 0;
        for (int i = 0; i < n; i++) if (chars[i] != '\0') uniqueCount++;

        String[] result = new String[uniqueCount * 2];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] != '\0') {
                result[idx++] = String.valueOf(chars[i]);
                result[idx++] = String.valueOf(freq[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();

        String[] arr = frequencies(text);
        for (int i = 0; i < arr.length; i += 2) {
            System.out.print(arr[i] + "\t" + arr[i + 1]);
            if (i + 2 < arr.length) System.out.print("\n");
        }
    }
}

