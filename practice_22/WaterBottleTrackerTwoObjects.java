public class WaterBottleTrackerTwoObjects {
    static class WaterBottle {
        String ownerName;
        int dailyTarget;

        WaterBottle(String ownerName, int dailyTarget) {
            this.ownerName = ownerName;
            this.dailyTarget = dailyTarget;
        }

        void displayBottleInfo() {
            System.out.print("Owner: " + ownerName + "\nDaily Target: " + dailyTarget + " ml");
        }
    }

    public static void main(String[] args) {
        WaterBottle b1 = new WaterBottle("Rahul", 2000);
        WaterBottle b2 = new WaterBottle("Anita", 2500);

        b1.displayBottleInfo();
        System.out.print("\n---\n");
        b2.displayBottleInfo();
    }
}

