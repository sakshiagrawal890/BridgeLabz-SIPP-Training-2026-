import java.util.Scanner;

public class FindFirstOccurrence {
    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;

            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter main string: ");
            String haystack = scanner.nextLine();

            System.out.print("Enter search string: ");
            String needle = scanner.nextLine();

            System.out.println("Index = " + strStr(haystack, needle));
        }
    }
}
