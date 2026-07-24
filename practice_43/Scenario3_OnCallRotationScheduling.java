import java.util.ArrayList;
import java.util.List;

public class Scenario3_OnCallRotationScheduling {

    public static List<List<String>> generateSchedules(String[] engineers) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[engineers.length];
        backtrack(engineers, used, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String[] engineers, boolean[] used, 
                                   List<String> path, 
                                   List<List<String>> result) {
        if (path.size() == engineers.length) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < engineers.length; i++) {
            if (used[i]) continue;

            used[i] = true;
            path.add(engineers[i]);

            backtrack(engineers, used, path, result);

            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        String[] engineers = {"Alice", "Bob", "Charlie"};
        
        System.out.println("=== On-Call Rotation Scheduling ===\n");
        System.out.println("Engineers: [Alice, Bob, Charlie]\n");
        
        List<List<String>> schedules = generateSchedules(engineers);
        
        System.out.println("Total schedules: " + schedules.size() + " (expected: 3! = 6)\n");
        
        for (int i = 0; i < schedules.size(); i++) {
            System.out.println("Schedule " + (i + 1) + ": " + schedules.get(i));
        }
        
        System.out.println("\n=== Key Insights ===");
        System.out.println("1. Unlike subsets, order matters — we use a 'used[]' boolean array");
        System.out.println("2. At each step, we try ALL unused engineers (loop from 0..n-1)");
        System.out.println("3. A permutation is complete when path.size() == engineers.length");
    }
}
