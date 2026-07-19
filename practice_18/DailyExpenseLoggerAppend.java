import java.io.*;
import java.util.*;

public class DailyExpenseLoggerAppend {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String fileName = "expenses.txt";

        for (int i = 0; i < 3; i++) {
            String category = input.next();
            double amount = input.nextDouble();

            try (FileWriter fw = new FileWriter(fileName, true)) {
                fw.write(category + " - " + (int) amount + System.lineSeparator());
            } catch (IOException e) {
                System.out.print("Error writing file");
                return;
            }
        }
    }
}

