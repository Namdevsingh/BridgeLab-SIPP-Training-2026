import java.io.*;

public class ProductInventoryChecker {
    public static void main(String[] args) {
        String fileName = "inventory.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("-");
                if (parts.length != 2) continue;

                String product = parts[0].trim();
                int qty = Integer.parseInt(parts[1].trim());

                if (qty <= 0) System.out.println(product + " is out of stock");
            }
        } catch (IOException e) {
            System.out.print("Error reading file");
        }
    }
}

