import java.util.*;

public class RocketCountdownFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = input.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.print(i);
            if (i != 1) {
                System.out.print(" ");
            }
        }
    }
}

