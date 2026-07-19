import java.io.*;

public class EmailDomainCounter {
    public static void main(String[] args) {
        String fileName = "emails.txt";

        String[] domains = {"gmail.com", "yahoo.com"};
        int[] counts = new int[domains.length];

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                int at = line.indexOf('@');
                if (at == -1) continue;
                String domain = line.substring(at + 1);

                for (int i = 0; i < domains.length; i++) {
                    if (domain.equalsIgnoreCase(domains[i])) counts[i]++;
                }
            }

            for (int i = 0; i < domains.length; i++) {
                System.out.print(domains[i] + " = " + counts[i]);
                if (i != domains.length - 1) System.out.print("\n");
            }
        } catch (IOException e) {
            System.out.print("Error reading file");
        }
    }
}

