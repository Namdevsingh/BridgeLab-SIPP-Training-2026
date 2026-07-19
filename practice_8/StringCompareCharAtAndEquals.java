import java.util.*;

public class StringCompareCharAtAndEquals {
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
        String s1 = input.next();
        String s2 = input.next();

        boolean resultCharAt = compareByCharAt(s1, s2);
        boolean resultEquals = s1.equals(s2);

        System.out.print("charAt result: " + resultCharAt + " and equals result: " + resultEquals);
    }
}

