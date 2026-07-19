import java.io.*;

public class CustomerFeedbackAnalyzerCountGood {
    public static void main(String[] args) {
        String inputFile = "feedback.txt";
        int goodCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            for (int i = 0; i < 5; i++) {
                String line = br.readLine();
                if (line == null) break;
                String[] words = line.split("\\s+");
                for (String w : words) {
                    String cleaned = w.replaceAll("[^a-zA-Z]", "");
                    if (cleaned.equalsIgnoreCase("good")) goodCount++;
                }
            }

            System.out.print("Good Feedback Count = " + goodCount);
        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        } catch (IOException e) {
            System.out.print("Error reading file");
        }
    }
}

