import java.util.*;

public class FirstNonRepeatingCharacter {
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

    static char firstNonRepeating(String text) {
        int n = lengthWithoutLength(text);
        int[] freq = new int[256];

        for (int i = 0; i < n; i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (freq[c] == 1) return c;
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();

        char ch = firstNonRepeating(text);
        if (ch == '\0') System.out.print("No non-repeating character");
        else System.out.print(ch);
    }
}

