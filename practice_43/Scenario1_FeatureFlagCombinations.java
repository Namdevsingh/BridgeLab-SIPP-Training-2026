import java.util.ArrayList;
import java.util.List;

public class Scenario1_FeatureFlagCombinations {

    public static List<List<String>> generateFlagCombinations(String[] flags) {
        List<List<String>> result = new ArrayList<>();
        backtrack(flags, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String[] flags, int index, 
                                   List<String> current, 
                                   List<List<String>> result) {
        if (index == flags.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(flags[index]);
        backtrack(flags, index + 1, current, result);

        current.remove(current.size() - 1);

        backtrack(flags, index + 1, current, result);
    }

    public static void main(String[] args) {
        String[] featureFlags = {"dark_mode", "new_checkout", "beta_search"};
        
        System.out.println("=== Feature Flag Combinations ===\n");
        System.out.println("Feature Flags: [dark_mode, new_checkout, beta_search]\n");
        
        List<List<String>> combinations = generateFlagCombinations(featureFlags);
        
        System.out.println("Total combinations: " + combinations.size() + " (expected: 2^3 = 8)\n");
        
        for (int i = 0; i < combinations.size(); i++) {
            List<String> combo = combinations.get(i);
            System.out.println("Combination " + (i + 1) + ": " + 
                (combo.isEmpty() ? "[none enabled]" : combo));
        }
        
        System.out.println("\n=== Explanation ===");
        System.out.println("Each flag has 2 choices (ON/OFF), giving 2^3 = 8 total combinations.");
        System.out.println("The backtracking approach explores both branches at each index,");
        System.out.println("recording the combination when all flags are processed.");
    }
}
