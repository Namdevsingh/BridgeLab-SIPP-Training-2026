import java.util.*;

public class EventEntryVerificationSystem {

    static class EventSystem {
        HashSet<String> participants;

        EventSystem() {
            participants = new HashSet<>();
        }

        void register(String email) {
            if (participants.add(email)) {
                System.out.println("Registered: " + email);
            } else {
                System.out.println("Duplicate rejected: " + email);
            }
        }

        void displayParticipants() {
            System.out.println("Unique participants:");
            for (String p : participants) System.out.println(p);
            System.out.println("Total attendees eligible: " + participants.size());
        }
    }

    public static void main(String[] args) {
        EventSystem es = new EventSystem();
        es.register("a@mail.com");
        es.register("b@mail.com");
        es.register("a@mail.com");
        es.register("c@mail.com");
        es.displayParticipants();
    }
}

