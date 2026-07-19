import java.util.*;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double celsius = input.nextDouble();
        double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
        System.out.print(fahrenheit);
    }
}

