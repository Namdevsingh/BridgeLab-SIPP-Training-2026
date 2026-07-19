import java.util.*;

public class HospitalTriageMinHeap {

    static class Patient {
        int priority;
        String name;

        Patient(int priority, String name) {
            this.priority = priority;
            this.name = name;
        }
    }

    static class Triage {
        private PriorityQueue<Patient> pq;

        Triage() {
            pq = new PriorityQueue<>((a, b) -> a.priority - b.priority);
        }

        void admit(Patient p) {
            pq.offer(p);
        }

        Patient callNext() {
            return pq.poll();
        }
    }

    public static void main(String[] args) {
        Triage triage = new Triage();
        triage.admit(new Patient(3, "A"));
        triage.admit(new Patient(1, "B"));
        triage.admit(new Patient(2, "C"));

        Patient p1 = triage.callNext();
        Patient p2 = triage.callNext();
        Patient p3 = triage.callNext();

        System.out.print(p1.name + " " + p2.name + " " + p3.name);
    }
}

