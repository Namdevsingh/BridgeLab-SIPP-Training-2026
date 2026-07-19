import java.util.*;

public class CustomExceptionInvalidAgeDemo {
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) throw new InvalidAgeException("Age must be 18 or above");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();
        try {
            validateAge(age);
            System.out.print("Access granted!");
        } catch (InvalidAgeException e) {
            System.out.print(e.getMessage());
        }
    }
}

