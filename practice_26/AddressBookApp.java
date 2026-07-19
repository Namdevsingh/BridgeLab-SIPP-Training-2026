import java.util.*;

public class AddressBookApp {
    static class Contact {
        String name;
        String phone;
        String email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        public String toString() {
            return "Name: " + name + "\nPhone: " + phone + "\nEmail: " + email;
        }
    }

    static class AddressBook {
        ArrayList<Contact> contacts;
        HashMap<String, Contact> byName;
        HashSet<String> phones;

        AddressBook() {
            contacts = new ArrayList<>();
            byName = new HashMap<>();
            phones = new HashSet<>();
        }

        void add(Contact c) {
            if (byName.containsKey(c.name)) {
                System.out.print("Contact with name already exists");
                return;
            }
            if (phones.contains(c.phone)) {
                System.out.print("Duplicate phone not allowed");
                return;
            }
            contacts.add(c);
            byName.put(c.name, c);
            phones.add(c.phone);
            System.out.print("Added");
        }

        Contact searchByName(String name) {
            return byName.get(name);
        }

        void deleteByName(String name) {
            Contact c = byName.get(name);
            if (c == null) {
                System.out.print("Not found");
                return;
            }
            byName.remove(name);
            phones.remove(c.phone);
            contacts.removeIf(x -> x.name.equals(name));
            System.out.print("Deleted");
        }

        void displaySortedByName() {
            Collections.sort(contacts, (a, b) -> a.name.compareToIgnoreCase(b.name));
            for (Contact c : contacts) {
                System.out.print("\n---\n" + c);
            }
        }
    }

    public static void main(String[] args) {
        AddressBook book = new AddressBook();
        book.add(new Contact("Rahul", "9001", "rahul@mail.com"));
        book.add(new Contact("Anita", "9002", "anita@mail.com"));
        book.add(new Contact("Kiran", "9003", "kiran@mail.com"));

        System.out.print("\nSearch Rahul:\n" + book.searchByName("Rahul"));
        book.deleteByName("Anita");
        System.out.print("\n\nSorted Contacts:");
        book.displaySortedByName();
    }
}

