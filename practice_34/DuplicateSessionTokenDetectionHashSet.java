import java.util.*;

public class DuplicateSessionTokenDetectionHashSet {

    static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] tokens = new String[n];
        for (int i = 0; i < n; i++) tokens[i] = input.next();
        System.out.print(hasDuplicateToken(tokens));
    }
}

