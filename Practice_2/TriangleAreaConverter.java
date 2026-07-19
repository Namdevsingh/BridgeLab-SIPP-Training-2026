import java.util.*;

public class TriangleAreaConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double base = input.nextDouble();
        double height = input.nextDouble();

        double areaSqCm = 0.5 * base * height;
        double areaSqIn = areaSqCm / (2.54 * 2.54);

        System.out.print("The Area of the triangle in sq in is " + areaSqIn + " and sq cm is " + areaSqCm);
    }
}

