import java.util.*;

public class SplitCompareWords {
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
            while (i < n && text.charAt(i) == ' ') {
                i++;
            }
            if (i >= n) break;

            int start = i;
            while (i < n && text.charAt(i) != ' ') {
                i++;
            }
            int end = i;

            StringBuilder sb = new StringBuilder();
            for (int k = start; k < end; k++) {
                sb.append(text.charAt(k));
            }
            words[wordIndex] = sb.toString();
            wordIndex++;
        }

        return words;
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        String[] builtIn = text.trim().split("\\s+");
        String[] custom = splitByCharAt(text);

        boolean same = compareArrays(custom, builtIn);
        System.out.print(same);
    }
}

