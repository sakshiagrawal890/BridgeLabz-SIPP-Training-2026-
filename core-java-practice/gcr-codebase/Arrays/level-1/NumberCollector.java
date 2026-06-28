import java.util.Scanner;

public class NumberCollector {
    public static void main(String[] args) {
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers (enter 0 or a negative number to stop):");
        while (true) {
            System.out.print("Number " + (index + 1) + ": ");
            double input = scanner.nextDouble();

            if (input <= 0 || index >= 10) {
                break;
            }

            numbers[index] = input;
            index++;
        }

        System.out.println("\nEntered numbers:");
        for (int i = 0; i < index; i++) {
            System.out.println(numbers[i]);
            total += numbers[i];
        }

        System.out.println("\nSum of all numbers: " + total);
        scanner.close();
    }
}
