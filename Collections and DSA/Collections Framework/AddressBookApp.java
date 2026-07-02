import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Address Book Application
 * 
 * Uses:
 * - ArrayList<Contact> for ordered storage of contacts
 * - HashMap<String, Contact> for fast name-based lookup
 * - HashSet<String> to prevent duplicate phone numbers
 * 
 * Operations: Add, Search, Delete, Display sorted by name
 */
public class AddressBookApp {

    // ---- Inner class to represent a Contact ----
    static class Contact {
        String name;
        String phone;
        String email;

        Contact(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Name: " + name + " | Phone: " + phone + " | Email: " + email;
        }
    }

    // Data structures
    static ArrayList<Contact> contactList = new ArrayList<>();       // ordered storage
    static HashMap<String, Contact> contactMap = new HashMap<>();    // fast name lookup
    static HashSet<String> phoneSet = new HashSet<>();               // unique phone numbers

    // ---- Add a new contact ----
    static void addContact(Scanner sc) {
        System.out.print("Enter Name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter Phone: ");
        String phone = sc.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = sc.nextLine().trim();

        // Check for duplicate phone number using HashSet
        if (phoneSet.contains(phone)) {
            System.out.println("ERROR: A contact with phone number '" + phone + "' already exists. Duplicate not allowed.");
            return;
        }

        // Check for duplicate name in HashMap
        if (contactMap.containsKey(name)) {
            System.out.println("ERROR: A contact with name '" + name + "' already exists.");
            return;
        }

        Contact contact = new Contact(name, phone, email);
        contactList.add(contact);       // ArrayList
        contactMap.put(name, contact);  // HashMap
        phoneSet.add(phone);            // HashSet

        System.out.println("Contact added successfully!");
    }

    // ---- Search contact by name (fast lookup via HashMap) ----
    static void searchContact(Scanner sc) {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine().trim();

        Contact contact = contactMap.get(name);  // O(1) lookup
        if (contact != null) {
            System.out.println("Contact Found -> " + contact);
        } else {
            System.out.println("No contact found with name '" + name + "'.");
        }
    }

    // ---- Delete a contact by name ----
    static void deleteContact(Scanner sc) {
        System.out.print("Enter Name to delete: ");
        String name = sc.nextLine().trim();

        Contact contact = contactMap.get(name);
        if (contact != null) {
            contactList.remove(contact);       // remove from ArrayList
            contactMap.remove(name);           // remove from HashMap
            phoneSet.remove(contact.phone);    // remove phone from HashSet

            System.out.println("Contact '" + name + "' deleted successfully!");
        } else {
            System.out.println("No contact found with name '" + name + "'.");
        }
    }

    // ---- Display all contacts sorted by name using Collections.sort() ----
    static void displaySorted() {
        if (contactList.isEmpty()) {
            System.out.println("Address book is empty.");
            return;
        }

        // Sort using Collections.sort() with a Comparator on name
        Collections.sort(contactList, new Comparator<Contact>() {
            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareToIgnoreCase(c2.name);
            }
        });

        System.out.println("\n===== Contacts (Sorted by Name) =====");
        for (Contact c : contactList) {
            System.out.println(c);
        }
        System.out.println("Total contacts: " + contactList.size());
        System.out.println("=====================================");
    }

    // ---- Main method with menu-driven interface ----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("========================================");
        System.out.println("       ADDRESS BOOK APPLICATION         ");
        System.out.println("========================================");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact by Name");
            System.out.println("3. Delete Contact by Name");
            System.out.println("4. Display All Contacts (Sorted by Name)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    addContact(sc);
                    break;
                case 2:
                    searchContact(sc);
                    break;
                case 3:
                    deleteContact(sc);
                    break;
                case 4:
                    displaySorted();
                    break;
                case 5:
                    System.out.println("Exiting Address Book. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
