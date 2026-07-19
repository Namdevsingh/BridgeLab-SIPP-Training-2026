import java.util.*;

public class SpringSeasonMethod {
    static boolean isSpring(int month, int day) {
        if (month == 3) return day >= 20;
        if (month == 4) return true;
        if (month == 5) return true;
        if (month == 6) return day <= 20;
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int day = input.nextInt();

        System.out.print(isSpring(month, day) ? "Its a Spring Season" : "Not a Spring Season");
    }
}

