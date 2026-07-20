package practice_41;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class LogEntry {
    int timestamp;
    String message;

    public LogEntry(int timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + message;
    }
}

public class Scenario6_MergeKSortedLogs {
    public static List<LogEntry> mergeKSortedLogs(List<List<LogEntry>> sources) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> sources.get(a[0]).get(a[1]).timestamp -
                       sources.get(b[0]).get(b[1]).timestamp
        );

        for (int i = 0; i < sources.size(); i++) {
            if (!sources.get(i).isEmpty()) {
                minHeap.offer(new int[]{i, 0});
            }
        }

        List<LogEntry> merged = new ArrayList<>();

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int sourceIdx = top[0];
            int elemIdx = top[1];

            merged.add(sources.get(sourceIdx).get(elemIdx));

            if (elemIdx + 1 < sources.get(sourceIdx).size()) {
                minHeap.offer(new int[]{sourceIdx, elemIdx + 1});
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        List<LogEntry> server1 = new ArrayList<>();
        server1.add(new LogEntry(100, "Server1: User login"));
        server1.add(new LogEntry(300, "Server1: DB query"));
        server1.add(new LogEntry(500, "Server1: Response sent"));

        List<LogEntry> server2 = new ArrayList<>();
        server2.add(new LogEntry(200, "Server2: Request received"));
        server2.add(new LogEntry(400, "Server2: Processing"));
        server2.add(new LogEntry(600, "Server2: Completed"));

        List<LogEntry> server3 = new ArrayList<>();
        server3.add(new LogEntry(150, "Server3: Health check"));
        server3.add(new LogEntry(350, "Server3: Cache refresh"));
        server3.add(new LogEntry(550, "Server3: Report generated"));

        List<List<LogEntry>> sources = new ArrayList<>();
        sources.add(server1);
        sources.add(server2);
        sources.add(server3);

        List<LogEntry> mergedLog = mergeKSortedLogs(sources);

        System.out.println("Merged timeline across all servers:");
        for (LogEntry entry : mergedLog) {
            System.out.println(entry);
        }
    }
}

