import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nNumber analysis:");
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (number < 0) {
                System.out.println("Number " + number + " is negative.");
            } else if (number == 0) {
                System.out.println("Number " + number + " is zero.");
            } else {
                System.out.println("Number " + number + " is positive.");
                if (number % 2 == 0) {
                    System.out.println("It is even.");
                } else {
                    System.out.println("It is odd.");
                }
            }
        }

        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        System.out.println("\nComparison of first and last elements:");
        if (first == last) {
            System.out.println("First and last elements are equal.");
        } else if (first > last) {
            System.out.println("First element is greater than the last element.");
        } else {
            System.out.println("First element is less than the last element.");
        }

        scanner.close();
    }
}
