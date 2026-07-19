import java.util.*;

public class MultiplicationTable6To9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        for (int i = 6; i <= 9; i++) {
            int result = number * i;
            System.out.print(number + " * " + i + " = " + result);
            if (i != 9) {
                System.out.print("\n");
            }
        }
    }
}

