import java.util.Scanner;

public class StringPermutations {
    static void generatePermutations(String prefix, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < remaining.length(); i++) {
            String nextPrefix = prefix + remaining.charAt(i);
            String nextRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
            generatePermutations(nextPrefix, nextRemaining);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();

        generatePermutations("", text);
        input.close();
    }
}
