import java.util.*;

public class BmiAllPersonsArrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int persons = input.nextInt();

        double[] weights = new double[persons];
        double[] heightsCm = new double[persons];
        double[] bmis = new double[persons];
        String[] status = new String[persons];

        for (int i = 0; i < persons; i++) {
            double weight = input.nextDouble();
            double height = input.nextDouble();

            while (weight < 0 || height < 0) {
                weight = input.nextDouble();
                height = input.nextDouble();
            }

            weights[i] = weight;
            heightsCm[i] = height;

            double heightM = height / 100.0;
            double bmi = weight / (heightM * heightM);
            bmis[i] = bmi;

            if (bmi < 18.5) status[i] = "Underweight";
            else if (bmi < 25.0) status[i] = "Normal";
            else if (bmi < 30.0) status[i] = "Overweight";
            else status[i] = "Obese";
        }

        for (int i = 0; i < persons; i++) {
            System.out.print("Person " + (i + 1) + ": Height=" + heightsCm[i] + " Weight=" + weights[i] + " BMI=" + bmis[i] + " Status=" + status[i]);
            if (i != persons - 1) System.out.print("\n");
        }
    }
}

