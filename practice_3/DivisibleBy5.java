import java.util.*;

public class DivisibleBy5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        boolean divisible = number % 5 == 0;
        System.out.print("Is the number " + number + " divisible by 5? " + divisible);
    }
}

