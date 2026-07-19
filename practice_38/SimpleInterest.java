import java.util.*;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double principal = input.nextDouble();
        double rate = input.nextDouble();
        double time = input.nextDouble();
        double simpleInterest = (principal * rate * time) / 100.0;
        System.out.print(simpleInterest);
    }
}

