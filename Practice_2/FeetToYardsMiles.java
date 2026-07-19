import java.util.*;

public class FeetToYardsMiles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double distanceInFeet = input.nextDouble();

        double distanceInYards = distanceInFeet / 3.0;
        double distanceInMiles = distanceInYards / 1760.0;

        System.out.print("The distance in yards is " + distanceInYards + " while the distance in miles is " + distanceInMiles);
    }
}

