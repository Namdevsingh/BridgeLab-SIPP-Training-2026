import java.util.*;

public class VolumeOfCylinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double radius = input.nextDouble();
        double height = input.nextDouble();
        double volume = Math.PI * radius * radius * height;
        System.out.print(volume);
    }
}

