import java.util.Scanner;

public class SubstringWithCharAt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        if (start < 0 || end > text.length() || start > end) {
            System.out.println("Invalid indices. Please enter values between 0 and " + text.length());
            scanner.close();
            return;
        }

        String manualSubstring = substringWithCharAt(text, start, end);
        String builtInSubstring = text.substring(start, end);

        System.out.println("Manual substring: " + manualSubstring);
        System.out.println("Built-in substring: " + builtInSubstring);
        System.out.println("Substrings match: " + manualSubstring.equals(builtInSubstring));
        scanner.close();
    }

    private static String substringWithCharAt(String text, int start, int end) {
        StringBuilder builder = new StringBuilder();
        for (int i = start; i < end; i++) {
            builder.append(text.charAt(i));
        }
        return builder.toString();
    }
}
