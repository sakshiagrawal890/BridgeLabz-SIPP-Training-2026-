import java.util.Scanner;

public class NestedTryCatchArrayDivision {
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

            try {
                int value = numbers[index];

                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                int result = value / divisor;
                System.out.println("Division result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            scanner.close();
        }
    }
}
