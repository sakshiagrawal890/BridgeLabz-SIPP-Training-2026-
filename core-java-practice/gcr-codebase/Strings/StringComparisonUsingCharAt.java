// Problem 1: Compare two strings using charAt() method and verify with equals()

import java.util.Scanner;

public class StringComparisonUsingCharAt {
    
    // Method to compare two strings using charAt() method
    public static boolean compareStringsUsingCharAt(String str1, String str2) {
        // If lengths are different, strings are not equal
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Compare each character using charAt()
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== STRING COMPARISON PROGRAM ==========");
        System.out.println("This program compares two strings using charAt() method");
        System.out.println("and verifies with the built-in equals() method.\n");
        
        // Take user input for two strings
        System.out.print("Enter first string: ");
        String string1 = scanner.next();
        
        System.out.print("Enter second string: ");
        String string2 = scanner.next();
        
        // Compare using charAt() method
        boolean resultCharAt = compareStringsUsingCharAt(string1, string2);
        System.out.println("\n--- Results ---");
        System.out.println("Comparison using charAt() method: " + resultCharAt);
        
        // Compare using built-in equals() method
        boolean resultEquals = string1.equals(string2);
        System.out.println("Comparison using equals() method: " + resultEquals);
        
        // Check if both methods give the same result
        System.out.println("\n--- Verification ---");
        if (resultCharAt == resultEquals) {
            System.out.println("✓ Both methods returned the same result!");
            if (resultCharAt) {
                System.out.println("  Strings are EQUAL");
            } else {
                System.out.println("  Strings are NOT EQUAL");
            }
        } else {
            System.out.println("✗ Methods returned different results!");
        }
        
        // Additional details
        System.out.println("\n--- String Details ---");
        System.out.println("String 1: \"" + string1 + "\" (Length: " + string1.length() + ")");
        System.out.println("String 2: \"" + string2 + "\" (Length: " + string2.length() + ")");
        
        scanner.close();
    }
}
