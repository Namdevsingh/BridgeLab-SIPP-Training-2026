import java.util.*;

public class BmiAll10Persons2DCharAtStyle {
    static String[][] computeAndReturn(double[][] wh) {
        int n = wh.length;
        String[][] result = new String[n][4];
        for (int i = 0; i < n; i++) {
            double weight = wh[i][0];
            double heightCm = wh[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);

            String status;
            if (bmi < 18.5) status = "Underweight";
            else if (bmi < 25.0) status = "Normal";
            else if (bmi < 30.0) status = "Overweight";
            else status = "Obese";

            result[i][0] = String.valueOf(i + 1);
            result[i][1] = String.valueOf(heightCm);
            result[i][2] = String.valueOf(weight);
            result[i][3] = status + " | BMI=" + bmi;
        }
        return result;
    }

    static void display(String[][] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print("Person " + data[i][0] + ": Height=" + data[i][1] + ", Weight=" + data[i][2] + ", " + data[i][3]);
            if (i != data.length - 1) System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int persons = 10;
        double[][] personData = new double[persons][2];

        for (int i = 0; i < persons; i++) {
            double weight = input.nextDouble();
            double height = input.nextDouble();
            while (weight < 0 || height < 0) {
                weight = input.nextDouble();
                height = input.nextDouble();
            }
            personData[i][0] = weight;
            personData[i][1] = height;
        }

        String[][] table = computeAndReturn(personData);
        display(table);
    }
}

