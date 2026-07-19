import java.util.*;

public class StringLengthWithoutLength {
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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();

        int builtIn = text.length();
        int custom = lengthWithoutLength(text);

        System.out.print("Custom length is " + custom + " and built-in length is " + builtIn);
    }
}

