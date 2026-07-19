public class CouponValidatorShoppingCart {

    interface CouponValidator {
        boolean validateCoupon(String code);

        static boolean isLengthValid(String code) {
            return code != null && code.length() >= 6 && code.length() <= 12;
        }
    }

    static class ShoppingCart implements CouponValidator {
        public boolean validateCoupon(String code) {
            return CouponValidator.isLengthValid(code) && code.startsWith("SAVE");
        }
    }

    public static void main(String[] args) {
        String[] coupons = {"SAVE100", "SAVE1", "DISCOUNT10", "SAVE2500", "SAVE12"};
        ShoppingCart cart = new ShoppingCart();

        for (String c : coupons) {
            if (cart.validateCoupon(c)) System.out.println(c + " is valid");
            else System.out.println(c + " is invalid");
        }
    }
}

