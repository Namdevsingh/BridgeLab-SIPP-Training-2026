import java.util.*;

public class VoteCheckRandomAgesArrayAndTable {
    static int[] generateAges(int n, int seed) {
        Random r = new Random(seed);
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = r.nextInt(90);
        }
        return ages;
    }

    static String[][] canVoteTable(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];
            if (age < 0) {
                table[i][0] = String.valueOf(age);
                table[i][1] = "Cannot vote";
            } else if (age >= 18) {
                table[i][0] = String.valueOf(age);
                table[i][1] = "Can vote";
            } else {
                table[i][0] = String.valueOf(age);
                table[i][1] = "Cannot vote";
            }
        }
        return table;
    }

    static void printTable(String[][] table) {
        for (int i = 0; i < table.length; i++) {
            System.out.print("Student " + (i + 1) + ": Age=" + table[i][0] + ", " + table[i][1]);
            if (i != table.length - 1) System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] ages = generateAges(n, 12345);
        String[][] table = canVoteTable(ages);
        printTable(table);
    }
}

