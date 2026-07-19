import java.util.*;

public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double avg = (a + b + c) / 3.0;
        System.out.print(avg);
    }
}

