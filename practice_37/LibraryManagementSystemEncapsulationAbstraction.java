public class LibraryManagementSystemEncapsulationAbstraction {

    public static abstract class LibraryItem {
        private int itemId;
        private String title;
        private String author;

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public abstract int getLoanDuration();

        public void displayItemDetails() {
            System.out.println("ItemId: " + itemId);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("LoanDurationDays: " + getLoanDuration());
        }
    }

    public static class Book extends LibraryItem {
        public int getLoanDuration() {
            return 14;
        }
    }

    public static class Magazine extends LibraryItem {
        public int getLoanDuration() {
            return 7;
        }
    }

    public static class DVD extends LibraryItem {
        public int getLoanDuration() {
            return 3;
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setItemId(1);
        book.setTitle("Java Basics");
        book.setAuthor("Author A");

        Magazine magazine = new Magazine();
        magazine.setItemId(2);
        magazine.setTitle("Tech Monthly");
        magazine.setAuthor("Author B");

        DVD dvd = new DVD();
        dvd.setItemId(3);
        dvd.setTitle("Movie Disc");
        dvd.setAuthor("Studio C");

        System.out.println("--- Book ---");
        book.displayItemDetails();
        System.out.println("--- Magazine ---");
        magazine.displayItemDetails();
        System.out.println("--- DVD ---");
        dvd.displayItemDetails();
    }
}

