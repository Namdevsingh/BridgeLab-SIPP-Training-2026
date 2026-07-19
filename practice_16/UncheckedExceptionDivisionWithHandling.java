import java.util.*;

public class UncheckedExceptionDivisionWithHandling {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {
            double num1 = input.nextDouble();
            double num2 = input.nextDouble();
            if (num2 == 0) {
                throw new ArithmeticException();
            }
            double result = num1 / num2;
            System.out.print(result);
        } catch (ArithmeticException e) {
            System.out.print("Denominator cannot be zero");
        } catch (InputMismatchException e) {
            System.out.print("Invalid input");
        }
    }
}

