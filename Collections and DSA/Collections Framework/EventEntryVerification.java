import java.util.HashSet;
import java.util.Scanner;

/**
 * Event Entry Verification System
 * 
 * Uses a HashSet<String> to store unique participant email IDs.
 * 
 * Operations:
 * 1. Register new participants using their email IDs.
 * 2. Prevent duplicate registrations automatically.
 * 3. Display all unique registered participants.
 * 4. Show the total number of attendees eligible to enter the conference.
 */
public class EventEntryVerification {

    // HashSet to store unique participant email IDs
    static HashSet<String> registeredParticipants = new HashSet<>();

    // ---- Register a new participant ----
    static void registerParticipant(Scanner sc) {
        System.out.print("Enter Participant Email ID: ");
        String email = sc.nextLine().trim().toLowerCase();

        // HashSet.add() returns false if the element already exists
        if (registeredParticipants.add(email)) {
            System.out.println("Registration successful for '" + email + "'.");
        } else {
            System.out.println("REJECTED: '" + email + "' is already registered. Duplicate entry not allowed.");
        }
    }

    // ---- Display all unique registered participants ----
    static void displayParticipants() {
        if (registeredParticipants.isEmpty()) {
            System.out.println("No participants have registered yet.");
            return;
        }

        System.out.println("\n===== Registered Participants =====");
        int count = 1;
        for (String email : registeredParticipants) {
            System.out.println(count + ". " + email);
            count++;
        }
        System.out.println("===================================");
    }

    // ---- Show total number of eligible attendees ----
    static void showTotalAttendees() {
        System.out.println("Total number of attendees eligible to enter the conference: " + registeredParticipants.size());
    }

    // ---- Main method with menu-driven interface ----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("==========================================");
        System.out.println("    EVENT ENTRY VERIFICATION SYSTEM       ");
        System.out.println("==========================================");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Register Participant");
            System.out.println("2. Display All Registered Participants");
            System.out.println("3. Show Total Eligible Attendees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    registerParticipant(sc);
                    break;
                case 2:
                    displayParticipants();
                    break;
                case 3:
                    showTotalAttendees();
                    break;
                case 4:
                    System.out.println("Exiting Event Entry Verification. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
