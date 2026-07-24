import java.util.ArrayList;
import java.util.List;

public class Scenario4_SensorPlacementNQueens {

    public static List<List<String>> placeSensors(int n) {
        List<List<String>> result = new ArrayList<>();
        int[] sensorCol = new int[n];
        backtrack(n, 0, sensorCol, result);
        return result;
    }

    private static void backtrack(int n, int row, int[] sensorCol, 
                                   List<List<String>> result) {
        if (row == n) {
            result.add(buildGrid(n, sensorCol));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, sensorCol)) {
                sensorCol[row] = col;
                backtrack(n, row + 1, sensorCol, result);
            }
        }
    }

    private static boolean isSafe(int row, int col, int[] sensorCol) {
        for (int r = 0; r < row; r++) {
            if (sensorCol[r] == col) return false;
            if (Math.abs(sensorCol[r] - col) == Math.abs(r - row)) return false;
        }
        return true;
    }

    private static List<String> buildGrid(int n, int[] sensorCol) {
        List<String> grid = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col < n; col++) {
                if (sensorCol[row] == col) {
                    sb.append("S");
                } else {
                    sb.append(".");
                }
            }
            grid.add(sb.toString());
        }
        return grid;
    }

    public static void main(String[] args) {
        int n = 4;
        
        System.out.println("=== Sensor Placement (N-Queens) on " + n + "×" + n + " Grid ===\n");
        System.out.println("Sensors placed per row (S = sensor, . = empty):\n");
        
        List<List<String>> placements = placeSensors(n);
        
        System.out.println("Total valid placements: " + placements.size() + "\n");
        
        for (int i = 0; i < placements.size(); i++) {
            System.out.println("Placement " + (i + 1) + ":");
            for (String row : placements.get(i)) {
                System.out.println("  " + row);
            }
            System.out.println();
        }
        
        System.out.println("=== Key Insights ===");
        System.out.println("1. One sensor per row avoids row conflicts automatically");
        System.out.println("2. Column check: sensorCol[r] == col → conflict");
        System.out.println("3. Diagonal check: |r - row| == |sensorCol[r] - col| → conflict");
        System.out.println("4. No explicit undo needed — for loop overwrites sensorCol[row]");
    }
}
