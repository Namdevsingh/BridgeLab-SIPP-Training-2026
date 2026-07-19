public class AirportSecurityManagementSystem {

    interface LuggageScanner {
        default void displaySecurityGuidelines() {
            System.out.print("Guideline: Liquids must be in small bottles\n");
        }
    }

    interface PassportVerifier {
        default void displaySecurityGuidelines() {
            System.out.print("Guideline: Passport must be valid and readable\n");
        }

        static boolean isPassportNumberValid(String passportNo) {
            return passportNo != null && passportNo.matches("[A-Z]{2}[0-9]{6}");
        }
    }

    static class AirportSecuritySystem implements LuggageScanner, PassportVerifier {
        boolean canBoard(String passportNo, String luggageStatus) {
            boolean passportOk = PassportVerifier.isPassportNumberValid(passportNo);
            boolean luggageOk = luggageStatus != null && luggageStatus.equalsIgnoreCase("safe");
            return passportOk && luggageOk;
        }

        void displayGuidelines() {
            displaySecurityGuidelines();
        }

        public void displaySecurityGuidelines() {
            LuggageScanner.super.displaySecurityGuidelines();
            PassportVerifier.super.displaySecurityGuidelines();
        }
    }

    public static void main(String[] args) {
        String[] passengerNames = {"Rahul", "Anita", "Kiran"};
        String[] passportNos = {"AB123456", "A1234567", "CD654321"};
        String[] luggage = {"safe", "unsafe", "safe"};

        AirportSecuritySystem sys = new AirportSecuritySystem();
        sys.displayGuidelines();

        for (int i = 0; i < passengerNames.length; i++) {
            boolean ok = sys.canBoard(passportNos[i], luggage[i]);
            System.out.println(passengerNames[i] + (ok ? " can board" : " cannot board"));
        }
    }
}

