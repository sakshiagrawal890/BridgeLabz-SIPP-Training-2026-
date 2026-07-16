import java.util.Arrays;
import java.util.Scanner;

public class ToCharArrayManual {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.next();

        char[] manualChars = toCharArrayManual(text);
        char[] builtInChars = text.toCharArray();
        boolean arraysEqual = compareCharArrays(manualChars, builtInChars);

        System.out.println("Manual char array: " + Arrays.toString(manualChars));
        System.out.println("Built-in char array: " + Arrays.toString(builtInChars));
        System.out.println("Arrays match: " + arraysEqual);
        scanner.close();
    }

    private static char[] toCharArrayManual(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    private static boolean compareCharArrays(char[] array1, char[] array2) {
        if (array1 == null || array2 == null) {
            return array1 == array2;
        }
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }
}
