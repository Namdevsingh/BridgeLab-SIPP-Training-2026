public class PalindromeChecker {
    static class PalindromeCheckerClass {
        String text;

        PalindromeCheckerClass(String text) {
            this.text = text;
        }

        boolean isPalindrome() {
            if (text == null) return false;
            String s = text.replaceAll("\\s+", "").toLowerCase();
            int i = 0;
            int j = s.length() - 1;
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) return false;
                i++;
                j--;
            }
            return true;
        }

        void display() {
            System.out.print(isPalindrome() ? "Palindrome" : "Not Palindrome");
        }
    }

    public static void main(String[] args) {
        new PalindromeCheckerClass("madam").display();
    }
}

