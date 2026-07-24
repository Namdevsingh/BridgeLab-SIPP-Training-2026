package practice_42;

import java.util.*;

public class Scenario6_DirectedCycleDetection {

    public static boolean hasCircularDependency(Map<Integer, List<Integer>> tasks, int n) {
        int[] state = new int[n];

        for (int v = 0; v < n; v++) {
            if (state[v] == 0) {
                if (dfsCycleCheck(tasks, v, state)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfsCycleCheck(Map<Integer, List<Integer>> tasks, int node, int[] state) {
        state[node] = 1;

        for (int dep : tasks.getOrDefault(node, Collections.emptyList())) {
            if (state[dep] == 1) {
                return true;
            }
            if (state[dep] == 0 && dfsCycleCheck(tasks, dep, state)) {
                return true;
            }
        }

        state[node] = 2;
        return false;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> tasksWithCycle = new HashMap<>();
        tasksWithCycle.put(0, Arrays.asList(1));
        tasksWithCycle.put(1, Arrays.asList(2));
        tasksWithCycle.put(2, Arrays.asList(0));

        System.out.println("Tasks with cycle has circular dependency? " + hasCircularDependency(tasksWithCycle, 3));

        Map<Integer, List<Integer>> tasksWithoutCycle = new HashMap<>();
        tasksWithoutCycle.put(0, Arrays.asList(1));
        tasksWithoutCycle.put(1, Arrays.asList(2));
        tasksWithoutCycle.put(2, Arrays.asList());

        System.out.println("Tasks without cycle has circular dependency? " + hasCircularDependency(tasksWithoutCycle, 3));
    }
}

