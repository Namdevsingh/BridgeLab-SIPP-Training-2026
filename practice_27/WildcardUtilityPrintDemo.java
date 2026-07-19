import java.util.*;

public class WildcardUtilityPrintDemo {
    static void printList(List<?> list) {
        for (Object x : list) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("one", "two", "three");
        List<Integer> b = Arrays.asList(1, 2, 3);
        printList(a);
        System.out.println("---");
        printList(b);
    }
}

