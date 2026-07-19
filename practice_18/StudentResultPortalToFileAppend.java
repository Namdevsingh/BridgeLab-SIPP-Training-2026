import java.io.*;
import java.util.*;

public class StudentResultPortalToFileAppend {
    static double average(int[] marks) {
        int sum = 0;
        for (int m : marks) sum += m;
        return marks.length == 0 ? 0 : (double) sum / marks.length;
    }

    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "report_cards.txt";

        try {
            File in = new File(inputFile);
            if (!in.exists()) throw new FileNotFoundException();

            List<String> outputLines = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty()) continue;

                    String[] parts = line.split("\\s+");
                    String name = parts[0];
                    int[] marks = new int[parts.length - 1];
                    for (int i = 1; i < parts.length; i++) marks[i - 1] = Integer.parseInt(parts[i]);

                    double avg = average(marks);
                    outputLines.add("Name: " + name + "\nAverage: " + avg + "\n");
                }
            }

            try (FileWriter fw = new FileWriter(outputFile, true)) {
                for (String ol : outputLines) fw.write(ol);
            }

        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        } catch (IOException e) {
            System.out.print("IO error");
        } catch (Exception e) {
            System.out.print("Input error");
        }
    }
}

