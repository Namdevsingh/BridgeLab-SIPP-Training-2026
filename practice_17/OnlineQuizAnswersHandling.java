import java.util.*;

public class OnlineQuizAnswersHandling {
    public static void main(String[] args) {
        String answers[] = {"A", "B", "C", "D"};

        for (int i = 0; i < answers.length; i++) {
            try {
                if (answers[i].equals("A")) {
                    System.out.println(i + ": match");
                } else {
                    System.out.println(i + ": no match");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Invalid index");
            } catch (NullPointerException e) {
                System.out.println("Answer is null");
            }
        }

        try {
            System.out.println(answers[5].equals("A"));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index");
        } catch (NullPointerException e) {
            System.out.println("Answer is null");
        }
    }
}

