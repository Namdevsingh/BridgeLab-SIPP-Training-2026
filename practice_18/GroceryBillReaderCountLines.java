import java.io.*;

public class GroceryBillReaderCountLines {
    public static void main(String[] args) {
        String fileName = "bill.txt";
        int lines = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                lines++;
            }
            System.out.print("\nTotal lines = " + lines);
        } catch (FileNotFoundException e) {
            System.out.print("File not found");
        } catch (IOException e) {
            System.out.print("Error reading file");
        }
    }
}

