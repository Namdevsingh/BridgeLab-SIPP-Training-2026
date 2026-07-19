import java.util.*;

public class CheckPositiveNegativeZero {
    static int sign(int number) {
        if (number > 0) return 1;
        if (number < 0) return -1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        int result = sign(number);
        System.out.print(result);
    }
}

