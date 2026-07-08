import java.util.Arrays;

public class SelectionSortExamScores {

    public static int selectionSort(int[] scores, boolean trace) {
        int swaps = 0;
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
                swaps++;
            }

            if (trace) {
                System.out.println("After selecting for i=" + i + ": " + Arrays.toString(scores));
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] examScores = {76, 12, 45, 90, 25, 33};
        System.out.println("Original scores: " + Arrays.toString(examScores));
        int swaps = selectionSort(examScores, true);
        System.out.println("Sorted scores:   " + Arrays.toString(examScores));
        System.out.println("Total swaps: " + swaps);
    }
}

