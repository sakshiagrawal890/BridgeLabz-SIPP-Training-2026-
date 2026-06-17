import java.util.Scanner;

public class ReverseString {
    static String reverse(String text) {
        if (text.length() <= 1) {
            return text;
        }

        return reverse(text.substring(1)) + text.charAt(0);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        System.out.println(reverse(text));
        input.close();
    }
}
