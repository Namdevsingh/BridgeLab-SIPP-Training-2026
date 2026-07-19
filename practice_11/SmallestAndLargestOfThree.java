import java.util.*;

public class SmallestAndLargestOfThree {
    static int[] findSmallestAndLargest(int number1, int number2, int number3) {
        int smallest = Math.min(number1, Math.min(number2, number3));
        int largest = Math.max(number1, Math.max(number2, number3));
        return new int[]{smallest, largest};
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();
        int number3 = input.nextInt();

        int[] result = findSmallestAndLargest(number1, number2, number3);
        System.out.print("Smallest: " + result[0] + " and Largest: " + result[1]);
    }
}

