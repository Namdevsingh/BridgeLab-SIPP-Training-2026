import java.util.*;

public class TotalPurchasePrice {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double unitPrice = input.nextDouble();
        double quantity = input.nextDouble();

        double totalPrice = unitPrice * quantity;

        System.out.print("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);
    }
}

