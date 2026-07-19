import java.util.*;

public class PalindromeThreeLogics {
    static boolean isPalindromeLogic1(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindromeRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isPalindromeRecursive(s, start + 1, end - 1);
    }

    static boolean isPalindromeUsingCharArrays(String s) {
        char[] a = s.toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) b[i] = a[a.length - 1 - i];
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();

        boolean l1 = isPalindromeLogic1(s);
        boolean l2 = isPalindromeRecursive(s, 0, s.length() - 1);
        boolean l3 = isPalindromeUsingCharArrays(s);

        System.out.print("Logic1: " + l1 + "\nLogic2: " + l2 + "\nLogic3: " + l3);
    }
}

