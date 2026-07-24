import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scenario2_VendingMachineChange {

    public static List<List<Integer>> makeChange(int[] coins, int target) {
        Arrays.sort(coins);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(coins, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int[] coins, int target, int start, int sum,
                                   List<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < coins.length; i++) {
            if (sum + coins[i] > target) break;

            path.add(coins[i]);
            backtrack(coins, target, i, sum + coins[i], path, result);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10};
        int target = 10;

        System.out.println("=== Vending Machine Change-Making ===\n");
        System.out.println("Denominations: " + Arrays.toString(denominations));
        System.out.println("Target Amount: " + target + "\n");

        List<List<Integer>> combinations = makeChange(denominations, target);

        System.out.println("Total ways to make change for " + target + ": " + combinations.size() + "\n");
        for (int i = 0; i < combinations.size(); i++) {
            System.out.println("Way " + (i + 1) + ": " + combinations.get(i));
        }

        System.out.println("\n=== Key Insights ===");
        System.out.println("1. Sorting allows early pruning (break when sum exceeds target)");
        System.out.println("2. Same index 'i' (not i+1) is passed because coins can be reused");
        System.out.println("3. The 'break' prunes all larger denominations once sum exceeds target");
    }
}
