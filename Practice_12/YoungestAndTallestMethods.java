import java.util.*;

public class YoungestAndTallestMethods {
    static int findYoungest(int[] ages) {
        int min = ages[0];
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < min) min = ages[i];
        }
        return min;
    }

    static double findTallest(double[] heights) {
        double max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) max = heights[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) ages[i] = input.nextInt();
        for (int i = 0; i < 3; i++) heights[i] = input.nextDouble();

        int youngest = findYoungest(ages);
        double tallest = findTallest(heights);

        System.out.print("Youngest friend age is " + youngest + " and tallest friend height is " + tallest);
    }
}

