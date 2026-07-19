import java.util.*;

public class MaxHandshakes {
    static long calculateHandshakes(int numberOfStudents) {
        return (long) numberOfStudents * (numberOfStudents - 1) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfStudents = input.nextInt();

        long handshakes = calculateHandshakes(numberOfStudents);
        System.out.print(handshakes);
    }
}

