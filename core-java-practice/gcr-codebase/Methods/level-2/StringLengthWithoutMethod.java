import java.util.Scanner;

public class StringLengthWithoutMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();

        int manualLength = lengthWithoutMethod(text);
        int builtInLength = text.length();

        System.out.println("Manual length: " + manualLength);
        System.out.println("Built-in length: " + builtInLength);
        System.out.println("Lengths match: " + (manualLength == builtInLength));
        scanner.close();
    }

    private static int lengthWithoutMethod(String text) {
        int count = 0;
        while (true) {
            try {
                text.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }
}
