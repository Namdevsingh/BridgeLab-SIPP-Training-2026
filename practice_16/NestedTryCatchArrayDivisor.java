import java.util.*;

public class NestedTryCatchArrayDivisor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = input.nextInt();

        int index = input.nextInt();
        int divisor = input.nextInt();

        try {
            int element = arr[index];
            try {
                System.out.print(element / divisor);
            } catch (ArithmeticException e) {
                System.out.print("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Invalid array index!");
        }
    }
}

