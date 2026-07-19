import java.util.*;

public class SmartLibrarySystem {
    static String[] books = {"Java", "Python", null, "C++"};

    static int getBookLength(int index) {
        try {
            String book = books[index];
            if (book == null) throw new NullPointerException();
            return book.length();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.print("Invalid index");
            return -1;
        } catch (NullPointerException e) {
            System.out.print("Book entry is null");
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();
        System.out.print("\nLength: " + getBookLength(index));
        int index2 = input.nextInt();
        System.out.print("\nLength: " + getBookLength(index2));
    }
}

