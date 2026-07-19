import java.util.*;

public class CharacterFrequencyAllChars2D {
    static int lengthWithoutLength(String s) {
        int count = 0;
        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    static String[][] frequency(String text) {
        int n = lengthWithoutLength(text);
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            freq[text.charAt(i)]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) uniqueCount++;
        }

        String[][] table = new String[uniqueCount][2];
        int idx = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                table[idx][0] = String.valueOf((char) i);
                table[idx][1] = String.valueOf(freq[i]);
                idx++;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();

        String[][] table = frequency(text);
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][0] + "\t" + table[i][1]);
            if (i != table.length - 1) System.out.print("\n");
        }
    }
}

