import java.util.*;

public class OddEvenArraysBetween1ToN {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number <= 0) {
            System.out.print("Error");
            return;
        }

        int size = number / 2 + 1;
        int[] even = new int[size];
        int[] odd = new int[size];
        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even[evenIndex] = i;
                evenIndex++;
            } else {
                odd[oddIndex] = i;
                oddIndex++;
            }
        }

        for (int i = 0; i < oddIndex; i++) {
            System.out.print(odd[i]);
            if (i != oddIndex - 1) System.out.print(" ");
        }
        System.out.print("\n");

        for (int i = 0; i < evenIndex; i++) {
            System.out.print(even[i]);
            if (i != evenIndex - 1) System.out.print(" ");
        }
    }
}

