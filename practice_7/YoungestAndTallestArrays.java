import java.util.*;

public class YoungestAndTallestArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            ages[i] = input.nextInt();
        }
        for (int i = 0; i < 3; i++) {
            heights[i] = input.nextDouble();
        }

        int youngest = ages[0];
        for (int i = 1; i < 3; i++) {
            if (ages[i] < youngest) youngest = ages[i];
        }

        double tallest = heights[0];
        for (int i = 1; i < 3; i++) {
            if (heights[i] > tallest) tallest = heights[i];
        }

        System.out.print("Youngest friend age is " + youngest + " and tallest friend height is " + tallest);
    }
}

