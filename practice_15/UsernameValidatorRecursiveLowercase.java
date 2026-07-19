import java.util.*;

public class UsernameValidatorRecursiveLowercase {
    static boolean isValid(String s, int index) {
        if (index == s.length()) return true;
        char c = s.charAt(index);
        if (c < 'a' || c > 'z') return false;
        return isValid(s, index + 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String username = input.next();
        System.out.print(isValid(username, 0));
    }
}

