import java.util.Scanner;

public class ShortestLongestWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine();

        String[] words = splitTextToWords(text);
        String[][] wordLengths = buildWordLengthsTable(words);
        int[] minMaxIndexes = findShortestAndLongest(wordLengths);

        if (words.length == 0) {
            System.out.println("No words found.");
        } else {
            int shortestIndex = minMaxIndexes[0];
            int longestIndex = minMaxIndexes[1];
            System.out.println("Shortest word: " + wordLengths[shortestIndex][0] + " (" + wordLengths[shortestIndex][1] + ")");
            System.out.println("Longest word: " + wordLengths[longestIndex][0] + " (" + wordLengths[longestIndex][1] + ")");
        }
        scanner.close();
    }

    private static String[] splitTextToWords(String text) {
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return new String[0];
        }

        int wordCount = 0;
        boolean inWord = false;
        for (int i = 0; i < trimmed.length(); i++) {
            char c = trimmed.charAt(i);
            if (c == ' ') {
                inWord = false;
            } else if (!inWord) {
                inWord = true;
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int wordIndex = 0;
        int start = 0;
        inWord = false;
        for (int i = 0; i < trimmed.length(); i++) {
            char c = trimmed.charAt(i);
            if (c == ' ') {
                if (inWord) {
                    words[wordIndex++] = trimmed.substring(start, i);
                    inWord = false;
                }
            } else if (!inWord) {
                inWord = true;
                start = i;
            }
        }
        if (inWord) {
            words[wordIndex] = trimmed.substring(start);
        }

        return words;
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

    private static String[][] buildWordLengthsTable(String[] words) {
        String[][] table = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            table[i][0] = words[i];
            table[i][1] = String.valueOf(lengthWithoutMethod(words[i]));
        }
        return table;
    }

    private static int[] findShortestAndLongest(String[][] table) {
        if (table.length == 0) {
            return new int[] {-1, -1};
        }
        int shortestIndex = 0;
        int longestIndex = 0;
        for (int i = 1; i < table.length; i++) {
            int length = Integer.parseInt(table[i][1]);
            int shortestLength = Integer.parseInt(table[shortestIndex][1]);
            int longestLength = Integer.parseInt(table[longestIndex][1]);
            if (length < shortestLength) {
                shortestIndex = i;
            }
            if (length > longestLength) {
                longestIndex = i;
            }
        }
        return new int[] {shortestIndex, longestIndex};
    }
}
