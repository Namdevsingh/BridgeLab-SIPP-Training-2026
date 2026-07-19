import java.util.*;

public class FactorsInArrayWithResize {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number <= 0) {
            System.out.print("Invalid input");
            return;
        }

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                if (index >= maxFactor) {
                    int newSize = maxFactor * 2;
                    int[] temp = new int[newSize];
                    for (int k = 0; k < maxFactor; k++) {
                        temp[k] = factors[k];
                    }
                    factors = temp;
                    maxFactor = newSize;
                }
                factors[index] = i;
                index++;
            }
        }

        for (int i = 0; i < index; i++) {
            System.out.print(factors[i]);
            if (i != index - 1) System.out.print(" ");
        }
    }
}

