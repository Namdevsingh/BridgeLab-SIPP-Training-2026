import java.util.*;

public class VowelConsonantCharacterType2D {
    static String charType(char ch) {
        int code = (int) ch;
        if (code >= 65 && code <= 90) ch = (char) (code + 32);

        if (ch < 'a' || ch > 'z') return "Not a Letter";
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') return "Vowel";
        return "Consonant";
    }

    static String[][] classify(String s) {
        String[][] table = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            table[i][0] = String.valueOf(s.charAt(i));
            table[i][1] = charType(s.charAt(i));
        }
        return table;
    }

    static void printTable(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.print(table[i][0] + "\t" + table[i][1]);
            if (i != table.length - 1) System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        String[][] table = classify(s);
        printTable(table);
    }
}

