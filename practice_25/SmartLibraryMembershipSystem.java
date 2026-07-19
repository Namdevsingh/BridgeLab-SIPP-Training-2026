public class SmartLibraryMembershipSystem {

    static class LibraryMember {
        String memberName;
        String memberId;

        LibraryMember(String memberName, String memberId) {
            this.memberName = memberName;
            this.memberId = memberId;
        }

        double calculateFine(int overdueDays) {
            return overdueDays * 1.0;
        }

        void displayDetails() {
            System.out.print("Member: " + memberName + "\nID: " + memberId);
        }
    }

    static class StudentMember extends LibraryMember {
        StudentMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        double calculateFine(int overdueDays) {
            return overdueDays * 0.5;
        }
    }

    static class FacultyMember extends LibraryMember {
        FacultyMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        double calculateFine(int overdueDays) {
            return overdueDays * 0.2;
        }
    }

    static class GuestMember extends LibraryMember {
        GuestMember(String memberName, String memberId) {
            super(memberName, memberId);
        }

        double calculateFine(int overdueDays) {
            return overdueDays * 2.0;
        }
    }

    static void printMemberDetails(LibraryMember[] members) {
        for (LibraryMember m : members) {
            System.out.print("\n---\n");
            m.displayDetails();
        }
    }

    static void findById(LibraryMember[] members, String id, int overdueDays) {
        for (LibraryMember m : members) {
            if (m.memberId.equals(id)) {
                System.out.print("\nFound Member:\n");
                m.displayDetails();
                System.out.print("\nFine for " + overdueDays + " days: " + m.calculateFine(overdueDays));
                return;
            }
        }
        System.out.print("\nNo member found with ID " + id);
    }

    public static void main(String[] args) {
        LibraryMember[] members = new LibraryMember[5];
        members[0] = new StudentMember("Alice", "S-1");
        members[1] = new FacultyMember("Dr. Bob", "F-2");
        members[2] = new GuestMember("Carl", "G-3");
        members[3] = new StudentMember("Dina", "S-4");
        members[4] = new GuestMember("Evan", "G-5");

        printMemberDetails(members);
        findById(members, "F-2", 10);
    }
}

