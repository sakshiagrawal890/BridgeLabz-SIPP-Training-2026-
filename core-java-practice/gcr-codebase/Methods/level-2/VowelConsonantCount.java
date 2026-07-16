import java.util.Scanner;

public class VowelConsonantCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();

        int[] counts = countVowelsAndConsonants(text);
        System.out.println("Vowels: " + counts[0]);
        System.out.println("Consonants: " + counts[1]);
        scanner.close();
    }

    private static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String result = checkCharType(text.charAt(i));
            if ("Vowel".equals(result)) {
                vowels++;
            } else if ("Consonant".equals(result)) {
                consonants++;
            }
        }
        return new int[] {vowels, consonants};
    }

    private static String checkCharType(char c) {
        if (c >= 'A' && c <= 'Z') {
            c = (char) (c + ('a' - 'A'));
        }
        if (c >= 'a' && c <= 'z') {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    return "Vowel";
                default:
                    return "Consonant";
            }
        }
        return "Not a Letter";
    }
}
