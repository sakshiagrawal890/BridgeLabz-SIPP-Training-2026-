public class NullPointerDemo {
    public static void main(String[] args) {
        System.out.println("1. Generate NullPointerException:");
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Caught in main: " + e.getMessage());
        }

        System.out.println("\n2. Handle NullPointerException in a method:");
        handleNullPointer();
    }

    private static void generateException() {
        String text = null;
        System.out.println("About to call length() on a null string...");
        System.out.println("Length: " + text.length());
    }

    private static void handleNullPointer() {
        String text = null;
        try {
            System.out.println("About to call length() on a null string inside try/catch...");
            System.out.println("Length: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("Handled NullPointerException: " + e.getMessage());
        }
    }
}
