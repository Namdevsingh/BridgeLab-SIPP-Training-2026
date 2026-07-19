import java.util.*;

public class DemoStringIndexOutOfBoundsException {
    static void generate(String s) {
        System.out.print(s.charAt(s.length()));
    }

    static void handle(String s) {
        try {
            System.out.print(s.charAt(s.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.print("StringIndexOutOfBoundsException handled");
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

