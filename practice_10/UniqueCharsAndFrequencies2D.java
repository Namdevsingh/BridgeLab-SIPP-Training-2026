import java.util.*;

public class UniqueCharsAndFrequencies2D {
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

    static char[] uniqueCharacters(String text) {
        int n = lengthWithoutLength(text);
        char[] temp = new char[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) temp[count++] = c;
        }

        char[] result = new char[count];
        for (int i = 0; i < count; i++) result[i] = temp[i];
        return result;
    }

    static String[][] frequenciesUsingUniques(String text) {
        int[] freq = new int[256];
        int n = lengthWithoutLength(text);
        for (int i = 0; i < n; i++) freq[text.charAt(i)]++;

        char[] uniques = uniqueCharacters(text);
        String[][] table = new String[uniques.length][2];

        for (int i = 0; i < uniques.length; i++) {
            table[i][0] = String.valueOf(uniques[i]);
            table[i][1] = String.valueOf(freq[uniques[i]]);
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();
        String[][] table = frequenciesUsingUniques(text);

        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][0] + "\t" + table[i][1]);
            if (i != table.length - 1) System.out.print("\n");
        }
    }
}

