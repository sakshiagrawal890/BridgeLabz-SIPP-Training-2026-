import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String first = scanner.next();
        System.out.print("Enter second string: ");
        String second = scanner.next();

        boolean manualResult = compareStringsWithCharAt(first, second);
        boolean builtInResult = first.equals(second);

        System.out.println("Manual charAt comparison: " + manualResult);
        System.out.println("Built-in equals() result: " + builtInResult);
        System.out.println("Results match: " + (manualResult == builtInResult));
        scanner.close();
    }

    private static boolean compareStringsWithCharAt(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return s1 == s2;
        }
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
