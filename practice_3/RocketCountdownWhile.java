import java.util.*;

public class RocketCountdownWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = input.nextInt();

        while (counter >= 1) {
            System.out.print(counter);
            if (counter != 1) {
                System.out.print(" ");
            }
            counter--;
        }
    }
}

