import java.util.*;

public class AddDigitsLeetCode {
    static int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        System.out.print(addDigits(num));
    }
}

