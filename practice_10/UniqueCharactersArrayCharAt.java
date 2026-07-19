import java.util.*;

public class UniqueCharactersArrayCharAt {
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

    static char[] uniqueCharacters(String text) {
        int n = lengthWithoutLength(text);
        char[] uniquesTemp = new char[n];
        int uCount = 0;

        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            boolean unique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == c) {
                    unique = false;
                    break;
                }
            }
            if (unique) {
                uniquesTemp[uCount] = c;
                uCount++;
            }
        }

        char[] result = new char[uCount];
        for (int i = 0; i < uCount; i++) result[i] = uniquesTemp[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();

        char[] custom = uniqueCharacters(text);
        char[] builtInArr = text.toCharArray();

        boolean same = true;
        if (custom.length != builtInArr.length) same = false;
        else {
            for (int i = 0; i < custom.length; i++) {
                boolean found = false;
                for (int j = 0; j < builtInArr.length; j++) {
                    if (custom[i] == builtInArr[j]) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    same = false;
                    break;
                }
            }
        }

        System.out.print("Custom unique count: " + custom.length + " and built-in length: " + builtInArr.length + " and comparison: " + same);
        System.out.print("\nUnique characters:");
        for (int i = 0; i < custom.length; i++) {
            System.out.print(custom[i]);
            if (i != custom.length - 1) System.out.print(" ");
        }
    }
}

