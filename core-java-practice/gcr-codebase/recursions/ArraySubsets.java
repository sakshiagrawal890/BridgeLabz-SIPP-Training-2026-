import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArraySubsets {
    static void generateSubsets(int[] array, int index, int targetSize, List<Integer> current) {
        if (current.size() == targetSize) {
            System.out.println(formatSubset(current));
            return;
        }

        if (index == array.length) {
            return;
        }

        current.add(array[index]);
        generateSubsets(array, index + 1, targetSize, current);
        current.remove(current.size() - 1);

        generateSubsets(array, index + 1, targetSize, current);
    }

    static String formatSubset(List<Integer> subset) {
        if (subset.isEmpty()) {
            return "[]";
        }

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < subset.size(); i++) {
            result.append(subset.get(i));
            if (i < subset.size() - 1) {
                result.append(",");
            }
        }
        result.append("]");

        return result.toString();
    }

    static int[] parseArray(String text) {
        text = text.replace("[", " ").replace("]", " ").replace(",", " ");
        text = text.trim();
        if (text.isEmpty()) {
            return new int[0];
        }

        String[] values = text.split("\\s+");
        int[] array = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            array[i] = Integer.parseInt(values[i]);
        }

        return array;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String text = input.nextLine();
        int[] array = parseArray(text);

        for (int size = 0; size <= array.length; size++) {
            generateSubsets(array, 0, size, new ArrayList<>());
        }

        input.close();
    }
}
