import java.util.*;

public class SquareSideFromPerimeter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double perimeter = input.nextDouble();
        double side = perimeter / 4.0;
        System.out.print("The length of the side is " + side + " whose perimeter is " + perimeter);
    }
}

