import java.util.*;

public class PositiveNegativeZeroCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (number > 0) {
            System.out.print("positive");
        } else if (number < 0) {
            System.out.print("negative");
        } else {
            System.out.print("zero");
        }
    }
}

