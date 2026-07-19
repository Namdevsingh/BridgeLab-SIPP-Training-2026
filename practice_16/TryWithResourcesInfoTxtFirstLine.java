import java.io.*;

public class TryWithResourcesInfoTxtFirstLine {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("info.txt"))) {
            String line = br.readLine();
            if (line != null) System.out.print(line);
        } catch (IOException e) {
            System.out.print("Error reading file");
        }
    }
}

