import java.util.Arrays;

public class BubbleSortStudentMarks {

    public static int bubbleSort(int[] marks, boolean trace) {
        int swaps = 0;
        int n = marks.length;

        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - pass; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (trace) {
                System.out.println("Pass " + (pass + 1) + ": " + Arrays.toString(marks));
            }

            if (!swapped) break;
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] marks = {55, 12, 88, 33, 21, 70};
        System.out.println("Original marks: " + Arrays.toString(marks));
        int swaps = bubbleSort(marks, true);
        System.out.println("Sorted marks:   " + Arrays.toString(marks));
        System.out.println("Total swaps: " + swaps);
    }
}

