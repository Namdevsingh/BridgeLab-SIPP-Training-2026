import java.util.*;

public class StringCharsCompareToCharArray {
    static char[] charsByCharAt(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        return arr;
    }

    static boolean compareCharArrays(char[] a, char[] b) {
        if (a == null || b == null) return false;
        if (a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();

        char[] a1 = charsByCharAt(text);
        char[] a2 = text.toCharArray();

        System.out.print(compareCharArrays(a1, a2));
    }
}

