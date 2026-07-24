package practice_42;

import java.util.*;

public class Scenario1_SparseFriendGraph {
    private Map<Integer, Set<Integer>> friendGraph;

    public Scenario1_SparseFriendGraph() {
        friendGraph = new HashMap<>();
    }

    public void addFriendship(int u, int v) {
        friendGraph.computeIfAbsent(u, k -> new HashSet<>()).add(v);
        friendGraph.computeIfAbsent(v, k -> new HashSet<>()).add(u);
    }

    public boolean isFriend(int u, int v) {
        return friendGraph.getOrDefault(u, Collections.emptySet()).contains(v);
    }

    public static void main(String[] args) {
        Scenario1_SparseFriendGraph graph = new Scenario1_SparseFriendGraph();

        graph.addFriendship(1, 2);
        graph.addFriendship(1, 3);
        graph.addFriendship(2, 4);
        graph.addFriendship(3, 5);
        graph.addFriendship(4, 5);

        System.out.println("Is 1 friend of 2? " + graph.isFriend(1, 2));
        System.out.println("Is 1 friend of 4? " + graph.isFriend(1, 4));
        System.out.println("Is 3 friend of 5? " + graph.isFriend(3, 5));
        System.out.println("Is 2 friend of 5? " + graph.isFriend(2, 5));

        System.out.println("\nAll friends of user 1: " + graph.friendGraph.get(1));
        System.out.println("All friends of user 5: " + graph.friendGraph.get(5));
    }
}

