import java.util.*;

public class SubstringCharAtAndSubstringMethodCompare {
    static String substringByCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    static boolean compareByCharAt(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();
        int start = input.nextInt();
        int end = input.nextInt();

        String s1 = substringByCharAt(text, start, end);
        String s2 = text.substring(start, end);

        boolean equal = compareByCharAt(s1, s2);

        System.out.print("charAt substring: " + s1 + "\nsubstring() result: " + s2 + "\nare they equal: " + equal);
    }
}

