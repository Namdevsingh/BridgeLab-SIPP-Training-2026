public class LibraryBookAuthorInheritance {

    static class Book {
        String title;
        int publicationYear;

        Book(String title, int publicationYear) {
            this.title = title;
            this.publicationYear = publicationYear;
        }

        String displayInfo() {
            return "Book{title='" + title + "', publicationYear=" + publicationYear + "}";
        }
    }

    static class Author extends Book {
        String name;
        String bio;

        Author(String title, int publicationYear, String name, String bio) {
            super(title, publicationYear);
            this.name = name;
            this.bio = bio;
        }

        String displayInfo() {
            return "Book{title='" + title + "', publicationYear=" + publicationYear + "}\nAuthor{name='" + name + "', bio='" + bio + "'}";
        }
    }

    public static void main(String[] args) {
        Author a = new Author("Clean Code", 2008, "Robert C. Martin", "Software engineer and author");
        System.out.print(a.displayInfo());
    }
}

