import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SchoolResultPortal {
    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "report_cards.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile, true))) {

            writer.write("----- Report Cards -----");
            writer.newLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 2) {
                    continue;
                }

                String name = data[0].trim();
                int total = 0;

                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i].trim());
                }

                double average = (double) total / (data.length - 1);

                writer.write("Name: " + name);
                writer.newLine();
                writer.write("Total Marks: " + total);
                writer.newLine();
                writer.write("Average Marks: " + average);
                writer.newLine();
                writer.write("------------------------");
                writer.newLine();
            }

            System.out.println("Report cards appended to " + outputFile);
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
            System.out.println("Create students.txt with data like: Rahul,80,75,90");
        } catch (IOException e) {
            System.out.println("Error while reading or writing file");
        } catch (NumberFormatException e) {
            System.out.println("Marks should contain only numbers");
        }
    }
}
