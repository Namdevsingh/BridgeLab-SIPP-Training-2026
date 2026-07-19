import java.util.*;

public class MultiplicationTableArray1To10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int[] table = new int[11];

        for (int i = 1; i <= 10; i++) {
            table[i] = number * i;
        }

        for (int i = 1; i <= 10; i++) {
            System.out.print(number + " * " + i + " = " + table[i]);
            if (i != 10) System.out.print("\n");
        }
    }
}

