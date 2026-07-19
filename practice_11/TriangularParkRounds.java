import java.util.*;

public class TriangularParkRounds {
    static int roundsForDistance(double side1, double side2, double side3, double distanceKm) {
        double perimeter = side1 + side2 + side3;
        double distanceMeters = distanceKm * 1000.0;
        return (int) Math.ceil(distanceMeters / perimeter);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        int rounds = roundsForDistance(a, b, c, 5.0);
        System.out.print(rounds);
    }
}

