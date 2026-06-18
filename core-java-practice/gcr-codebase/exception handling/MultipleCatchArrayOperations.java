import java.util.Scanner;

public class MultipleCatchArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter array size: ");
            int size = scanner.nextInt();

            int[] numbers = new int[size];
            System.out.println("Enter " + size + " array elements:");

            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }

            System.out.print("Enter index: ");
            int index = scanner.nextInt();

            System.out.println("Value at index " + index + ": " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } finally {
            scanner.close();
        }
    }
}
