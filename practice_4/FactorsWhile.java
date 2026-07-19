import java.util.*;

public class FactorsWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number <= 0) {
            System.out.print("Invalid input");
            return;
        }

        int counter = 1;
        boolean first = true;
        while (counter < number) {
            if (number % counter == 0) {
                if (!first) {
                    System.out.print("\n");
                }
                System.out.print(counter);
                first = false;
            }
            counter++;
        }
    }
}

