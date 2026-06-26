// Problem 3: Convert string to char array and compare with toCharArray()

import java.util.Scanner;

public class CharArrayConversion {
    
    // Method to return characters in a string without using toCharArray()
    public static char[] getCharArrayUsingCharAt(String str) {
        char[] charArray = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }
        return charArray;
    }
    
    // Method to compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        // If lengths are different, arrays are not equal
        if (arr1.length != arr2.length) {
            return false;
        }
        
        // Compare each element
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
    
    // Method to display character array
    public static void displayCharArray(char[] arr, String name) {
        System.out.print(name + ": [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("'" + arr[i] + "'");
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== CHARACTER ARRAY CONVERSION PROGRAM ==========");
        System.out.println("This program converts string to char array using charAt()");
        System.out.println("and compares with the built-in toCharArray() method.\n");
        
        // Take user input
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.println("\n--- Processing ---");
        
        // Get char array using charAt() method
        char[] charArrayUsingCharAt = getCharArrayUsingCharAt(text);
        System.out.println("Created char array using charAt() method");
        displayCharArray(charArrayUsingCharAt, "User-defined method result");
        
        // Get char array using built-in toCharArray() method
        char[] charArrayBuiltIn = text.toCharArray();
        System.out.println("\nCreated char array using toCharArray() method");
        displayCharArray(charArrayBuiltIn, "Built-in method result");
        
        // Compare both arrays
        System.out.println("\n--- Comparison ---");
        boolean areEqual = compareCharArrays(charArrayUsingCharAt, charArrayBuiltIn);
        System.out.println("Are both arrays equal? " + areEqual);
        
        if (areEqual) {
            System.out.println("✓ Both methods produced the same character array!");
        } else {
            System.out.println("✗ Methods produced different arrays!");
        }
        
        // Additional details
        System.out.println("\n--- Details ---");
        System.out.println("Original String: \"" + text + "\"");
        System.out.println("String Length: " + text.length());
        System.out.println("Character Array Length: " + charArrayBuiltIn.length);
        
        System.out.println("\nCharacter Breakdown:");
        for (int i = 0; i < charArrayBuiltIn.length; i++) {
            System.out.println("  Index " + i + ": '" + charArrayBuiltIn[i] + "' (ASCII: " + 
                             (int)charArrayBuiltIn[i] + ")");
        }
        
        scanner.close();
    }
}
