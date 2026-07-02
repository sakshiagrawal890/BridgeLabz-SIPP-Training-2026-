import java.util.ArrayList;
import java.util.Scanner;

/**
 * Smart Parking Slot Manager
 * 
 * Uses an ArrayList<String> to store vehicle registration numbers
 * currently parked in the mall.
 * 
 * Operations:
 * 1. Add a vehicle when it enters the parking area.
 * 2. Remove a vehicle when it exits the parking area.
 * 3. Search for a vehicle using its registration number.
 * 4. Display all parked vehicles along with the total number of occupied parking slots.
 */
public class SmartParkingManager {

    // ArrayList to store vehicle registration numbers
    static ArrayList<String> parkedVehicles = new ArrayList<>();

    // ---- Add vehicle (Enter Parking) ----
    static void enterParking(Scanner sc) {
        System.out.print("Enter Vehicle Registration Number: ");
        String regNumber = sc.nextLine().trim().toUpperCase();

        if (parkedVehicles.contains(regNumber)) {
            System.out.println("Vehicle '" + regNumber + "' is already parked in the lot.");
        } else {
            parkedVehicles.add(regNumber);
            System.out.println("Vehicle '" + regNumber + "' has entered the parking area.");
        }
    }

    // ---- Remove vehicle (Exit Parking) ----
    static void exitParking(Scanner sc) {
        System.out.print("Enter Vehicle Registration Number to exit: ");
        String regNumber = sc.nextLine().trim().toUpperCase();

        if (parkedVehicles.remove(regNumber)) {
            System.out.println("Vehicle '" + regNumber + "' has exited the parking area.");
        } else {
            System.out.println("Vehicle '" + regNumber + "' is not found in the parking area.");
        }
    }

    // ---- Search for a vehicle ----
    static void searchVehicle(Scanner sc) {
        System.out.print("Enter Vehicle Registration Number to search: ");
        String regNumber = sc.nextLine().trim().toUpperCase();

        if (parkedVehicles.contains(regNumber)) {
            System.out.println("Vehicle '" + regNumber + "' is currently parked in the mall.");
        } else {
            System.out.println("Vehicle '" + regNumber + "' is NOT found in the parking area.");
        }
    }

    // ---- Display all parked vehicles ----
    static void displayAllVehicles() {
        if (parkedVehicles.isEmpty()) {
            System.out.println("No vehicles are currently parked.");
            return;
        }

        System.out.println("\n===== Currently Parked Vehicles =====");
        for (int i = 0; i < parkedVehicles.size(); i++) {
            System.out.println("Slot " + (i + 1) + ": " + parkedVehicles.get(i));
        }
        System.out.println("Total occupied parking slots: " + parkedVehicles.size());
        System.out.println("=====================================");
    }

    // ---- Main method with menu-driven interface ----
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("==========================================");
        System.out.println("      SMART PARKING SLOT MANAGER          ");
        System.out.println("==========================================");

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Vehicle Enter (Add to Parking)");
            System.out.println("2. Vehicle Exit (Remove from Parking)");
            System.out.println("3. Search Vehicle");
            System.out.println("4. Display All Parked Vehicles");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine().trim());

            switch (choice) {
                case 1:
                    enterParking(sc);
                    break;
                case 2:
                    exitParking(sc);
                    break;
                case 3:
                    searchVehicle(sc);
                    break;
                case 4:
                    displayAllVehicles();
                    break;
                case 5:
                    System.out.println("Exiting Smart Parking Manager. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
