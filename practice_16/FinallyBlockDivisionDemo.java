import java.util.*;

public class FinallyBlockDivisionDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        try {
            System.out.print(a / b);
        } catch (ArithmeticException e) {
            System.out.print("Division by zero");
        } finally {
            System.out.print("\nOperation completed");
        }
    }
}

