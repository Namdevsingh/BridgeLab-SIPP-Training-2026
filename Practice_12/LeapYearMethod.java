import java.util.*;

public class LeapYearMethod {
    static boolean isLeapYear(int year) {
        if (year < 1582) return false;
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = input.nextInt();
        System.out.print("Year is a Leap Year: " + isLeapYear(year));
    }
}

