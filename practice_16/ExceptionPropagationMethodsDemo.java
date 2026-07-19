import java.util.*;

public class ExceptionPropagationMethodsDemo {
    static void method1() {
        int x = 10 / 0;
    }

    static void method2() {
        method1();
    }

    public static void main(String[] args) {
        try {
            method2();
        } catch (ArithmeticException e) {
            System.out.print("Handled exception in main");
        }
    }
}

