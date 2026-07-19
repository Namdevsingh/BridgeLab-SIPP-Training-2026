import java.util.*;

public class AnagramCheckFrequency {
    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) return false;

        int[] freq = new int[256];
        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i)]++;
            freq[b.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1 = input.next();
        String s2 = input.next();

        System.out.print(isAnagram(s1, s2));
    }
}

