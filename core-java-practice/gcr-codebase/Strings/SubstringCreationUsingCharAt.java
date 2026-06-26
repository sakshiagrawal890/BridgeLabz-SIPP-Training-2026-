// Problem 2: Create substring using charAt() method and verify with substring()

import java.util.Scanner;

public class SubstringCreationUsingCharAt {
    
    // Method to create substring using charAt() method
    public static String createSubstringUsingCharAt(String str, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > str.length() || startIndex > endIndex) {
            throw new IllegalArgumentException("Invalid indices!");
        }
        
        StringBuilder substrBuilder = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            substrBuilder.append(str.charAt(i));
        }
        return substrBuilder.toString();
    }
    
    // Method to compare two strings using charAt() method
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========== SUBSTRING CREATION PROGRAM ==========");
        System.out.println("This program creates substring using charAt() method");
        System.out.println("and verifies with the built-in substring() method.\n");
        
        // Take user input
        System.out.print("Enter a string: ");
        String text = scanner.next();
        
        System.out.print("Enter start index: ");
        int startIndex = scanner.nextInt();
        
        System.out.print("Enter end index (exclusive): ");
        int endIndex = scanner.nextInt();
        
        System.out.println("\n--- Processing ---");
        
        try {
            // Create substring using charAt() method
            String substrCharAt = createSubstringUsingCharAt(text, startIndex, endIndex);
            System.out.println("Substring using charAt(): \"" + substrCharAt + "\"");
            
            // Create substring using built-in substring() method
            String substrBuiltIn = text.substring(startIndex, endIndex);
            System.out.println("Substring using substring(): \"" + substrBuiltIn + "\"");
            
            // Compare both substrings
            System.out.println("\n--- Comparison ---");
            boolean isEqual = compareStrings(substrCharAt, substrBuiltIn);
            System.out.println("Are both substrings equal? " + isEqual);
            
            if (isEqual) {
                System.out.println("✓ Both methods produced the same result!");
            } else {
                System.out.println("✗ Methods produced different results!");
            }
            
            // Additional details
            System.out.println("\n--- Details ---");
            System.out.println("Original String: \"" + text + "\"");
            System.out.println("String Length: " + text.length());
            System.out.println("Start Index: " + startIndex);
            System.out.println("End Index: " + endIndex);
            System.out.println("Substring Length: " + (endIndex - startIndex));
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: String index out of bounds!");
        }
        
        scanner.close();
    }
}
