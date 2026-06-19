import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ProductInventoryChecker {
    public static void main(String[] args) {
        String fileName = "inventory.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("-");

                if (data.length != 2) {
                    continue;
                }

                String productName = data[0].trim();
                int quantity = Integer.parseInt(data[1].trim());

                if (quantity == 0) {
                    System.out.println(productName + " is out of stock");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading inventory file");
        } catch (NumberFormatException e) {
            System.out.println("Inventory quantity should be a number");
        }
    }
}
