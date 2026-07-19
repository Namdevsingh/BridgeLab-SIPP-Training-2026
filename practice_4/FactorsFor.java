import java.util.*;

public class FactorsFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number <= 0) {
            System.out.print("Invalid input");
            return;
        }

        boolean first = true;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                if (!first) {
                    System.out.print("\n");
                }
                System.out.print(i);
                first = false;
            }
        }
    }
}

