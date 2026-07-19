import java.util.*;

public class FootballTeamHeightStats {
    static int sumHeights(int[] heights) {
        int sum = 0;
        for (int h : heights) sum += h;
        return sum;
    }

    static double meanHeight(int[] heights) {
        return (double) sumHeights(heights) / heights.length;
    }

    static int shortestHeight(int[] heights) {
        int min = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] < min) min = heights[i];
        }
        return min;
    }

    static int tallestHeight(int[] heights) {
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > max) max = heights[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] heights = new int[11];

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + r.nextInt(101);
        }

        int sum = sumHeights(heights);
        double mean = meanHeight(heights);
        int shortest = shortestHeight(heights);
        int tallest = tallestHeight(heights);

        System.out.print("Shortest=" + shortest + " Tallest=" + tallest + " Mean=" + mean);
    }
}

