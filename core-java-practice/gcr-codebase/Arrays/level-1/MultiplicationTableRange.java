import java.util.Scanner;

public class MultiplicationTableRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Enter a number between 6 and 9: ");
            number = scanner.nextInt();
        } while (number < 6 || number > 9);

        int[] multiplicationResult = new int[10];
        for (int i = 1; i <= 10; i++) {
            multiplicationResult[i - 1] = number * i;
        }

        System.out.println("\nMultiplication table of " + number + ":");
        for (int i = 0; i < multiplicationResult.length; i++) {
            System.out.println(number + " * " + (i + 1) + " = " + multiplicationResult[i]);
        }

        scanner.close();
    }
}
