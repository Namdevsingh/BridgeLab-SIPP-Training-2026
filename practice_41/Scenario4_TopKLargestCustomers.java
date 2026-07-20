package practice_41;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Scenario4_TopKLargestCustomers {
    public static List<Integer> topKLargest(int[] transactions, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int amount : transactions) {
            if (minHeap.size() < k) {
                minHeap.offer(amount);
            } else if (amount > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(amount);
            }
        }

        return new ArrayList<>(minHeap);
    }

    public static void main(String[] args) {
        int[] transactions = {1200, 4500, 2300, 8900, 1500, 6700, 3400, 9100, 2800, 5600};
        int k = 3;

        List<Integer> top3 = topKLargest(transactions, k);

        System.out.println("Top " + k + " highest-spending customers (transaction amounts):");
        for (int amount : top3) {
            System.out.println("$" + amount);
        }

        top3.sort((a, b) -> b - a);
        System.out.println("Sorted descending: " + top3);
    }
}

