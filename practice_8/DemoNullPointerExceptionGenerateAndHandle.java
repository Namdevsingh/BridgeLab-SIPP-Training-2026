public class DemoNullPointerExceptionGenerateAndHandle {
    static void generate() {
        String text = null;
        System.out.print(text.length());
    }

    static void handle() {
        String text = null;
        try {
            System.out.print(text.length());
        } catch (NullPointerException e) {
            System.out.print("NullPointerException handled");
        } catch (RuntimeException e) {
            System.out.print("RuntimeException handled");
        }
    }

    public static void main(String[] args) {
        handle();
    }
}

