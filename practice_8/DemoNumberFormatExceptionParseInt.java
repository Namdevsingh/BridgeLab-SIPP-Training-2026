import java.util.*;

public class DemoNumberFormatExceptionParseInt {
    static void generate(String text) {
        System.out.print(Integer.parseInt(text));
    }

    static void handle(String text) {
        try {
            System.out.print(Integer.parseInt(text));
        } catch (NumberFormatException e) {
            System.out.print("NumberFormatException handled");
        } catch (RuntimeException e) {
            System.out.print("RuntimeException handled");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.next();
        handle(text);
    }
}

