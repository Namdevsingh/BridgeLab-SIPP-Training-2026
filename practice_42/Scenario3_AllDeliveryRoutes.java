package practice_42;

import java.util.*;

public class Scenario3_AllDeliveryRoutes {

    public static void allRoutes(Map<Integer, List<Integer>> roads, int current, int target,
                                  List<Integer> path, Set<Integer> visited,
                                  List<List<Integer>> allRoutesList) {
        path.add(current);
        visited.add(current);

        if (current == target) {
            allRoutesList.add(new ArrayList<>(path));
        } else {
            for (int next : roads.getOrDefault(current, Collections.emptyList())) {
                if (!visited.contains(next)) {
                    allRoutes(roads, next, target, path, visited, allRoutesList);
                }
            }
        }

        path.remove(path.size() - 1);
        visited.remove(current);
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> roads = new HashMap<>();
        roads.put(0, Arrays.asList(1, 2));
        roads.put(1, Arrays.asList(0, 3, 4));
        roads.put(2, Arrays.asList(0, 5));
        roads.put(3, Arrays.asList(1, 6));
        roads.put(4, Arrays.asList(1, 6));
        roads.put(5, Arrays.asList(2, 6));
        roads.put(6, Arrays.asList(3, 4, 5));

        int warehouse = 0;
        int store = 6;

        List<Integer> path = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> allRoutesList = new ArrayList<>();

        allRoutes(roads, warehouse, store, path, visited, allRoutesList);

        System.out.println("All delivery routes from warehouse " + warehouse + " to store " + store + ":");
        for (int i = 0; i < allRoutesList.size(); i++) {
            System.out.println("Route " + (i + 1) + ": " + allRoutesList.get(i));
        }
        System.out.println("Total distinct routes: " + allRoutesList.size());
    }
}

