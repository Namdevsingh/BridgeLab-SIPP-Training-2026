import java.util.*;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int ageAmar = input.nextInt();
        int ageAkbar = input.nextInt();
        int ageAnthony = input.nextInt();

        double heightAmar = input.nextDouble();
        double heightAkbar = input.nextDouble();
        double heightAnthony = input.nextDouble();

        int youngest = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        double tallest = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));

        System.out.print(youngest + "\n" + tallest);
    }
}

