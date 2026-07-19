import java.util.*;

public class PrintQueueDequeRushSupport {

    static class PrintServer {
        private Deque<Integer> q = new ArrayDeque<>();

        void addLastJob(int jobId) {
            q.addLast(jobId);
        }

        void addFirstJob(int jobId) {
            q.addFirst(jobId);
        }

        int removeFirstJob() {
            return q.removeFirst();
        }
    }

    public static void main(String[] args) {
        PrintServer server = new PrintServer();
        server.addLastJob(10);
        server.addLastJob(20);
        server.addFirstJob(99);

        System.out.print(server.removeFirstJob() + " " + server.removeFirstJob() + " " + server.removeFirstJob());
    }
}

