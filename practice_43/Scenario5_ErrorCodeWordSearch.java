public class Scenario5_ErrorCodeWordSearch {

    public static boolean exists(char[][] grid, String word) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (backtrack(grid, word, 0, r, c, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] grid, String word, int idx, 
                                      int r, int c, boolean[][] visited) {
        if (idx == word.length()) return true;

        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return false;

        if (visited[r][c] || grid[r][c] != word.charAt(idx)) return false;

        visited[r][c] = true;

        boolean found = backtrack(grid, word, idx + 1, r + 1, c, visited)
                     || backtrack(grid, word, idx + 1, r - 1, c, visited)
                     || backtrack(grid, word, idx + 1, r, c + 1, visited)
                     || backtrack(grid, word, idx + 1, r, c - 1, visited);

        visited[r][c] = false;

        return found;
    }

    public static void main(String[] args) {
        char[][] logGrid = {
            {'E', 'R', 'R', 'O', 'R'},
            {'A', 'B', 'C', 'D', 'E'},
            {'R', 'F', 'G', 'H', 'I'},
            {'R', 'J', 'K', 'L', 'M'},
            {'O', 'N', 'O', 'P', 'Q'},
            {'R', 'S', 'T', 'U', 'V'}
        };

        System.out.println("=== Error Code Word Search in Log Grid ===\n");
        
        System.out.println("Log Grid:");
        for (char[] row : logGrid) {
            System.out.print("  ");
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }

        String[] errorCodes = {"ERROR", "ERR", "EEROR", "XYZ"};

        for (String code : errorCodes) {
            boolean found = exists(logGrid, code);
            System.out.println("\nError code '" + code + "': " + 
                (found ? "FOUND ✓" : "NOT FOUND ✗"));
        }

        System.out.println("\n=== Key Insights ===");
        System.out.println("1. visited[][] prevents re-using cells within the same path");
        System.out.println("2. Four failure checks: bounds, visited, char mismatch, then success");
        System.out.println("3. After checking all 4 directions, unmark the cell (backtrack)");
        System.out.println("4. The OR (||) short-circuits as soon as one path succeeds");
    }
}
