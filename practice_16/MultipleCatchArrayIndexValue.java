import java.util.*;

public class MultipleCatchArrayIndexValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String hasArray = input.next();

        int[] arr = null;
        if (hasArray.equalsIgnoreCase("yes")) {
            int n = input.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = input.nextInt();
        }

        int index = input.nextInt();

        try {
            int value = arr[index];
            System.out.print("Value at index " + index + ": " + value);
        } catch (NullPointerException e) {
            System.out.print("Array is not initialized!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Invalid index!");
        }
    }
}

