import java.util.*;

public class MultiplicationTableFrom6To9InArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int[] multiplicationResult = new int[4];
        int idx = 0;

        for (int i = 6; i <= 9; i++) {
            multiplicationResult[idx] = number * i;
            idx++;
        }

        int[] factors = {6, 7, 8, 9};
        for (int i = 0; i < 4; i++) {
            System.out.print(number + " * " + factors[i] + " = " + multiplicationResult[i]);
            if (i != 3) System.out.print("\n");
        }
    }
}

