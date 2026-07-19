import java.util.*;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();

        if (year >= 1582) {
            boolean isLeap = (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
            System.out.print("Year is a Leap Year: " + isLeap);
        } else {
            System.out.print("Year is a Leap Year: false");
        }
    }
}

