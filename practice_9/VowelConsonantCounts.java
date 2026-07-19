import java.util.*;

public class VowelConsonantCounts {
    static String charType(char ch) {
        int code = (int) ch;
        if (code >= 65 && code <= 90) {
            ch = (char) (code + 32);
        }

        if (ch < 'a' || ch > 'z') return "Not a Letter";
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
        return "Consonant";
    }

    static int[] vowelConsonantCount(String s) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < s.length(); i++) {
            String type = charType(s.charAt(i));
            if (type.equals("Vowel")) vowels++;
            else if (type.equals("Consonant")) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();

        int[] counts = vowelConsonantCount(s);
        System.out.print("Vowels: " + counts[0] + " and Consonants: " + counts[1]);
    }
}

