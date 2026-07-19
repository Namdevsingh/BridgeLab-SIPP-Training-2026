import java.util.*;

public class SplitWordsWithLengths2D {
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

    static String[] splitByCharAt(String text) {
        int n = lengthWithoutLength(text);
        int wordCount = 0;
        boolean inWord = false;

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c != ' ') {
                if (!inWord) {
                    wordCount++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int i = 0;

        while (i < n) {
            while (i < n && text.charAt(i) == ' ') i++;
            if (i >= n) break;
            int start = i;
            while (i < n && text.charAt(i) != ' ') i++;
            int end = i;

            StringBuilder sb = new StringBuilder();
            for (int k = start; k < end; k++) sb.append(text.charAt(k));

            words[wordIndex] = sb.toString();
            wordIndex++;
        }

        return words;
    }

    static String[][] wordsWithLengths(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(lengthWithoutLength(words[i]));
        }
        return table;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        String[] words = splitByCharAt(text);
        String[][] table = wordsWithLengths(words);

        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][0] + "\t" + table[i][1]);
            if (i != table.length - 1) System.out.print("\n");
        }
    }
}

