import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DailyExpenseLogger {
    public static void main(String[] args) {
        String fileName = "expenses.txt";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter expense category: ");
            String category = scanner.nextLine();

            System.out.print("Enter amount: ");
            double amount = scanner.nextDouble();

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(category + " - " + amount);
                writer.newLine();
                System.out.println("Expense added to " + fileName);
            } catch (IOException e) {
                System.out.println("Error writing expense details");
            }
        }
    }
}
