import java.util.*;

public class DemoIllegalArgumentExceptionSubstring {
    static void generate(String s, int start, int end) {
        System.out.print(s.substring(start, end));
    }

    static void handle(String s, int start, int end) {
        try {
            System.out.print(s.substring(start, end));
        } catch (IllegalArgumentException e) {
            System.out.print("IllegalArgumentException handled");
        } catch (RuntimeException e) {
            System.out.print("RuntimeException handled");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();
        int start = input.nextInt();
        int end = input.nextInt();
        handle(text, start, end);
    }
}

