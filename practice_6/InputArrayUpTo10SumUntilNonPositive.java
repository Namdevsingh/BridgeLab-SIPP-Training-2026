import java.util.*;

public class InputArrayUpTo10SumUntilNonPositive {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            double value = input.nextDouble();
            if (value <= 0) {
                break;
            }
            if (index >= 10) {
                break;
            }
            values[index] = value;
            index++;
        }

        for (int i = 0; i < index; i++) {
            total += values[i];
        }

        for (int i = 0; i < index; i++) {
            System.out.print(values[i]);
            if (i != index - 1) System.out.print(" ");
        }
        System.out.print("\n");
        System.out.print(total);
    }
}

