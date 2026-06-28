import java.util.Scanner;

public class VotingEligibility {
    public static void main(String[] args) {
        int[] ages = new int[10];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < ages.length; i++) {
            System.out.print("Student " + (i + 1) + " age: ");
            ages[i] = scanner.nextInt();
        }

        System.out.println("\nVoting check:");
        for (int i = 0; i < ages.length; i++) {
            int age = ages[i];

            if (age < 0) {
                System.out.println("Student " + (i + 1) + " has invalid age: " + age);
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }

        scanner.close();
    }
}
