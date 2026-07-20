package practice_41;

import java.util.PriorityQueue;

class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (severity=" + severity + ")";
    }
}

public class Scenario1_ERTriageQueue {
    private PriorityQueue<Patient> triageQueue;

    public Scenario1_ERTriageQueue() {
        triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);
    }

    public void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }

    public Patient peekNext() {
        return triageQueue.peek();
    }

    public static void main(String[] args) {
        Scenario1_ERTriageQueue er = new Scenario1_ERTriageQueue();

        er.addPatient(new Patient("Alice", 3));
        er.addPatient(new Patient("Bob", 5));
        er.addPatient(new Patient("Charlie", 2));
        er.addPatient(new Patient("Diana", 8));
        er.addPatient(new Patient("Eve", 1));

        System.out.println("Treating patients in order of severity:");
        Patient next = er.treatNext();
        while (next != null) {
            System.out.println("Treating: " + next);
            next = er.treatNext();
        }
    }
}

