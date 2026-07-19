import java.util.*;

public class PrintNumbersRecursive {
    static void printFromNTo1(int n) {
        if (n <= 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        printFromNTo1(n - 1);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n < 1) {
            System.out.print("Invalid");
            return;
        }
        printFromNTo1(n);
    }
}

