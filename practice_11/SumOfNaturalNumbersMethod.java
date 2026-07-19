import java.util.*;

public class SumOfNaturalNumbersMethod {
    static long sumNatural(int n) {
        long sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        System.out.print(sumNatural(n));
    }
}

