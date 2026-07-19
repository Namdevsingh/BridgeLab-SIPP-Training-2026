import java.util.*;

public class SmartClassroomAttendanceTracker {

    static class AttendanceSystem {
        HashMap<String, ArrayList<String>> attendance;

        AttendanceSystem() {
            attendance = new HashMap<>();
        }

        void markAttendance(String subject, String student) {
            attendance.putIfAbsent(subject, new ArrayList<>());
            ArrayList<String> list = attendance.get(subject);
            if (!list.contains(student)) list.add(student);
        }

        void displayAttendance() {
            int totalAll = 0;
            for (Map.Entry<String, ArrayList<String>> e : attendance.entrySet()) {
                System.out.println("\nSubject: " + e.getKey());
                ArrayList<String> list = e.getValue();
                for (String s : list) System.out.println(s);
                totalAll += list.size();
            }
            System.out.println("\nTotal students present in every subject (sum across subjects): " + totalAll);
        }

        void displayTotalInEachSubject() {
            for (Map.Entry<String, ArrayList<String>> e : attendance.entrySet()) {
                System.out.println(e.getKey() + " -> " + e.getValue().size());
            }
        }
    }

    public static void main(String[] args) {
        AttendanceSystem sys = new AttendanceSystem();
        sys.markAttendance("Math", "Rahul");
        sys.markAttendance("Math", "Rahul");
        sys.markAttendance("Science", "Anita");
        sys.markAttendance("Science", "Rahul");
        sys.markAttendance("Math", "Kiran");

        sys.displayAttendance();
        System.out.println("\nTotal in each subject:");
        sys.displayTotalInEachSubject();
    }
}

