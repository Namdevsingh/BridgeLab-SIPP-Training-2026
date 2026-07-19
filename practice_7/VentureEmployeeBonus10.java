import java.util.*;

public class VentureEmployeeBonus10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = 10;
        double[] salary = new double[n];
        double[] years = new double[n];
        double[] newSalary = new double[n];
        double[] bonus = new double[n];

        double totalBonus = 0.0;
        double totalOldSalary = 0.0;
        double totalNewSalary = 0.0;

        int index = 0;
        while (index < n) {
            double s = input.nextDouble();
            double y = input.nextDouble();

            if (s < 0 || y < 0) {
                continue;
            }

            salary[index] = s;
            years[index] = y;
            index++;
        }

        for (int i = 0; i < n; i++) {
            double bonusPercent = years[i] > 5 ? 5.0 : 2.0;
            bonus[i] = (salary[i] * bonusPercent) / 100.0;
            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.print("Total bonus payout is " + totalBonus + " and total old salary is " + totalOldSalary + " and total new salary is " + totalNewSalary);
    }
}

