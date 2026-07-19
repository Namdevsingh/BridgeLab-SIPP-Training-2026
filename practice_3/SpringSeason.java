import java.util.*;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int month = input.nextInt();
        int day = input.nextInt();

        boolean spring = (month == 3 && day >= 20) ||
                (month == 4) ||
                (month == 5) ||
                (month == 6 && day <= 20);

        if (spring) {
            System.out.print("Its a Spring Season");
        } else {
            System.out.print("Not a Spring Season");
        }
    }
}

