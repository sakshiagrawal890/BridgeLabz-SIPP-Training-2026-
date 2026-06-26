// Problem 4: Demonstrate and handle NullPointerException

import java.util.Scanner;

public class NullPointerExceptionDemo {
    
    // Method to GENERATE NullPointerException
    public static void generateNullPointerException() {
        System.out.println("\n--- Attempting to GENERATE NullPointerException ---");
        System.out.println("Initializing text variable to null...");
        
        String text = null;
        
        try {
            System.out.println("Calling length() method on null string...");
            int length = text.length(); // This will throw NullPointerException
            System.out.println("String length: " + length);
        } catch (NullPointerException e) {
            System.out.println("❌ NullPointerException CAUGHT!");
            System.out.println("Exception Message: " + e.getMessage());
            System.out.println("Exception Class: " + e.getClass().getName());
        }
    }
    
    // Method to DEMONSTRATE NullPointerException with try-catch
    public static void demonstrateNullPointerException() {
        System.out.println("\n--- DEMONSTRATING NullPointerException Handling ---");
        System.out.println("This method shows how to handle NullPointerException gracefully.\n");
        
        String text = null;
        
        try {
            System.out.println("Initializing text to null...");
            System.out.println("Text value: " + text);
            
            // This will throw NullPointerException
            System.out.println("Attempting to call charAt(0) on null string...");
            char firstChar = text.charAt(0);
            System.out.println("First character: " + firstChar);
            
        } catch (NullPointerException e) {
            System.out.println("✓ NullPointerException caught and handled!");
            System.out.println("Details:");
            System.out.println("  - Exception Type: " + e.getClass().getSimpleName());
            System.out.println("  - Message: " + (e.getMessage() != null ? e.getMessage() : "No message"));
            System.out.println("  - Cause: Attempted to invoke method on null object reference");
            
        } catch (Exception e) {
            System.out.println("General Exception caught: " + e.getClass().getName());
            
        } finally {
            System.out.println("Finally block executed - Cleanup completed!");
        }
    }
    
    // Additional demonstration with various String methods
    public static void demonstrateVariousMethods() {
        System.out.println("\n--- Demonstrating NullPointerException with Different String Methods ---");
        
        String[] methodTests = {
            "length()", "charAt()", "substring()", "toUpperCase()", "trim()"
        };
        
        for (String method : methodTests) {
            System.out.println("\nTesting method: " + method);
            String text = null;
            
            try {
                switch(method) {
                    case "length()":
                        text.length();
                        break;
                    case "charAt()":
                        text.charAt(0);
                        break;
                    case "substring()":
                        text.substring(0, 1);
                        break;
                    case "toUpperCase()":
                        text.toUpperCase();
                        break;
                    case "trim()":
                        text.trim();
                        break;
                }
            } catch (NullPointerException e) {
                System.out.println("  ✓ Caught NullPointerException when calling " + method);
            }
        }
    }
    
    // Interactive demonstration
    public static void interactiveDemonstration() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n========== INTERACTIVE NULL POINTER EXCEPTION DEMO ==========");
        System.out.println("\nEnter a string (or 'null' to create NullPointerException): ");
        String userInput = scanner.next();
        
        try {
            String text;
            
            if (userInput.equals("null")) {
                text = null;
            } else {
                text = userInput;
            }
            
            System.out.println("Attempting to get length of: " + (text == null ? "null" : "\"" + text + "\""));
            
            if (text != null) {
                int length = text.length();
                System.out.println("✓ Length: " + length);
                System.out.println("✓ Uppercase: " + text.toUpperCase());
                System.out.println("✓ Lowercase: " + text.toLowerCase());
            } else {
                // Attempt to call method on null - will throw exception
                int length = text.length();
            }
            
        } catch (NullPointerException e) {
            System.out.println("❌ NullPointerException Caught!");
            System.out.println("Cannot invoke methods on null reference.");
            System.out.println("Check if variable is null before using it!");
            
        } finally {
            scanner.close();
        }
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════╗");
        System.out.println("║   NULLPOINTEREXCEPTION DEMONSTRATION PROGRAM      ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
        
        // 1. Generate the exception
        generateNullPointerException();
        
        // 2. Demonstrate proper handling
        demonstrateNullPointerException();
        
        // 3. Test various methods
        demonstrateVariousMethods();
        
        // 4. Interactive demonstration
        interactiveDemonstration();
        
        System.out.println("\n╔════════════════════════════════════════════════════╗");
        System.out.println("║            PROGRAM COMPLETED SUCCESSFULLY         ║");
        System.out.println("╚════════════════════════════════════════════════════╝");
    }
}
