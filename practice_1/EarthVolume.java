public class EarthVolume {
    public static void main(String[] args) {
        double rKm = 6378.0;
        double pi = 3.141592653589793;
        double volumeKm3 = (4.0 / 3.0) * pi * rKm * rKm * rKm;
        double rMiles = rKm * 0.625;
        double volumeMiles3 = (4.0 / 3.0) * pi * rMiles * rMiles * rMiles;
        System.out.print("The volume of earth in cubic kilometers is " + volumeKm3 + " and cubic miles is " + volumeMiles3);
    }
}

