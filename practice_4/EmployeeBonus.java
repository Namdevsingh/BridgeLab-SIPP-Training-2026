import java.util.*;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double salary = input.nextDouble();
        int yearsOfService = input.nextInt();

        double bonusPercent = yearsOfService > 5 ? 5.0 : 0.0;
        double bonus = (salary * bonusPercent) / 100.0;

        System.out.print(bonus);
    }
}

