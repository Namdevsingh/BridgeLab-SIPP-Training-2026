import java.util.*;

public class TrimLeadingTrailingSpaces {
    static int[] trimIndexes(String s) {
        int n = s.length();
        int start = 0;
        while (start < n && s.charAt(start) == ' ') start++;

        int end = n - 1;
        while (end >= 0 && s.charAt(end) == ' ') end--;

        int[] res = new int[2];
        res[0] = start;
        res[1] = end + 1;
        return res;
    }

    static String substringByCharAt(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) sb.append(s.charAt(i));
        return sb.toString();
    }

    static boolean compare(String a, String b) {
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();

        int[] idx = trimIndexes(s);
        String custom = substringByCharAt(s, idx[0], idx[1]);
        String builtIn = s.trim();

        System.out.print(custom + "\n" + builtIn + "\nEqual: " + compare(custom, builtIn));
    }
}

