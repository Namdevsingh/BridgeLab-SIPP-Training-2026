package practice_41;

import java.util.PriorityQueue;

public class Scenario5_KthLargestAdmissionCutoff {
    public static int findKthLargest(int[] scores, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int score : scores) {
            if (minHeap.size() < k) {
                minHeap.offer(score);
            } else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] scores = {88, 92, 75, 95, 83, 97, 70, 89, 91, 78, 94, 85, 96, 80, 87};
        int k = 5;

        int cutoff = findKthLargest(scores, k);

        System.out.println("Applicant scores: " + java.util.Arrays.toString(scores));
        System.out.println("The " + k + "th largest score (admission cutoff): " + cutoff);

        int admitted = 0;
        for (int score : scores) {
            if (score >= cutoff) admitted++;
        }
        System.out.println("Number of applicants scoring >= " + cutoff + ": " + admitted);
    }
}

