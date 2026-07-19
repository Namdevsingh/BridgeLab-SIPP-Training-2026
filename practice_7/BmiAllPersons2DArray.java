import java.util.*;

public class BmiAllPersons2DArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int persons = input.nextInt();

        double[][] personData = new double[persons][3];
        String[] weightStatus = new String[persons];

        for (int i = 0; i < persons; i++) {
            double weight = input.nextDouble();
            double height = input.nextDouble();

            while (weight < 0 || height < 0) {
                weight = input.nextDouble();
                height = input.nextDouble();
            }

            personData[i][0] = height;
            personData[i][1] = weight;

            double heightM = height / 100.0;
            double bmi = weight / (heightM * heightM);
            personData[i][2] = bmi;

            if (bmi < 18.5) weightStatus[i] = "Underweight";
            else if (bmi < 25.0) weightStatus[i] = "Normal";
            else if (bmi < 30.0) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        for (int i = 0; i < persons; i++) {
            System.out.print("Person " + (i + 1) + ": Height=" + personData[i][0] + " Weight=" + personData[i][1] + " BMI=" + personData[i][2] + " Status=" + weightStatus[i]);
            if (i != persons - 1) System.out.print("\n");
        }
    }
}

