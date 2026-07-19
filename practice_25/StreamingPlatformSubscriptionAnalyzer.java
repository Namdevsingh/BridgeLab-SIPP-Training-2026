public class StreamingPlatformSubscriptionAnalyzer {

    static class Subscription {
        String subscriberName;
        String subscriptionId;

        Subscription(String subscriberName, String subscriptionId) {
            this.subscriberName = subscriberName;
            this.subscriptionId = subscriptionId;
        }

        double calculateMonthlyCharge() {
            return 0;
        }

        String getType() {
            return "Subscription";
        }
    }

    static class BasicPlan extends Subscription {
        BasicPlan(String subscriberName, String subscriptionId) {
            super(subscriberName, subscriptionId);
        }

        double calculateMonthlyCharge() {
            return 9.99;
        }

        String getType() {
            return "BasicPlan";
        }
    }

    static class PremiumPlan extends Subscription {
        PremiumPlan(String subscriberName, String subscriptionId) {
            super(subscriberName, subscriptionId);
        }

        double calculateMonthlyCharge() {
            return 19.99;
        }

        String getType() {
            return "PremiumPlan";
        }
    }

    static class FamilyPlan extends Subscription {
        FamilyPlan(String subscriberName, String subscriptionId) {
            super(subscriberName, subscriptionId);
        }

        double calculateMonthlyCharge() {
            return 29.99;
        }

        String getType() {
            return "FamilyPlan";
        }
    }

    static Subscription searchById(Subscription[] subs, String id) {
        for (Subscription s : subs) if (s.subscriptionId.equals(id)) return s;
        return null;
    }

    static void displaySubscribersStartingWith(Subscription[] subs, char letter) {
        char L = Character.toLowerCase(letter);
        for (Subscription s : subs) {
            if (s.subscriberName != null && !s.subscriberName.isEmpty()) {
                char first = Character.toLowerCase(s.subscriberName.charAt(0));
                if (first == L) {
                    System.out.println("Subscriber: " + s.subscriberName + " | ID: " + s.subscriptionId + " | Plan: " + s.getType());
                }
            }
        }
    }

    static double calculateTotalRevenue(Subscription[] subs) {
        double sum = 0;
        for (Subscription s : subs) sum += s.calculateMonthlyCharge();
        return sum;
    }

    static Subscription mostExpensive(Subscription[] subs) {
        Subscription best = null;
        double max = -1;
        for (Subscription s : subs) {
            double c = s.calculateMonthlyCharge();
            if (c > max) {
                max = c;
                best = s;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        Subscription[] subs = new Subscription[6];
        subs[0] = new BasicPlan("Alice", "SUB-1");
        subs[1] = new PremiumPlan("Bob", "SUB-2");
        subs[2] = new FamilyPlan("Charlie", "SUB-3");
        subs[3] = new PremiumPlan("Ariana", "SUB-4");
        subs[4] = new BasicPlan("Daniel", "SUB-5");
        subs[5] = new FamilyPlan("Brandon", "SUB-6");

        Subscription found = searchById(subs, "SUB-3");
        System.out.println("Search by ID: " + (found == null ? "Not found" : found.subscriberName + " | " + found.getType()));

        System.out.println("\nSubscribers starting with 'A':");
        displaySubscribersStartingWith(subs, 'A');

        System.out.println("\nTotal Monthly Revenue: " + calculateTotalRevenue(subs));

        Subscription best = mostExpensive(subs);
        System.out.println("\nMost Expensive Subscription: " + best.subscriberName + " | " + best.getType() + " | Monthly: " + best.calculateMonthlyCharge());
    }
}

