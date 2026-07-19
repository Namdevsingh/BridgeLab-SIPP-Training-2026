import java.util.*;

public class KilometersToMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double km = input.nextDouble();
        double miles = km * 0.621371;
        System.out.print(miles);
    }
}

