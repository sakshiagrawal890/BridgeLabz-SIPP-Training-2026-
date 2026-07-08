import java.util.Arrays;

public class SortingScenarioQuestions {

    private static class BubbleResult {
        int totalSwaps;
        boolean alreadySortedBestCase;
    }

    private static class InsertionResult {
        int totalMoves;
        boolean alreadySortedBestCase;
    }

    private static BubbleResult bubbleSortWithTrace(int[] arr, boolean tracePasses) {
        BubbleResult res = new BubbleResult();
        res.totalSwaps = 0;

        boolean anySwapInPass1 = false;

        int n = arr.length;
        for (int pass = 0; pass < n - 1; pass++) {
            boolean swappedInThisPass = false;

            for (int j = 0; j < n - 1 - pass; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    res.totalSwaps++;
                    swappedInThisPass = true;
                }
            }

            if (pass == 0 && swappedInThisPass) {
                anySwapInPass1 = true;
            }

            if (tracePasses) {
                System.out.println("Bubble pass " + (pass + 1) + ": " + Arrays.toString(arr));
            }

            if (!swappedInThisPass) {
                // no swaps in this pass => array already sorted from here
                break;
            }
        }

        // Best-case for bubble sort: already sorted => no swaps on first traversal
        res.alreadySortedBestCase = !anySwapInPass1;
        return res;
    }

    private static InsertionResult insertionSortWithTrace(int[] arr, boolean tracePasses) {
        InsertionResult res = new InsertionResult();
        res.totalMoves = 0;

        boolean anyMoveInFirstOuterIteration = false;

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            boolean movedThisIteration = false;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                res.totalMoves++;
                movedThisIteration = true;
            }
            arr[j + 1] = key;

            if (i == 1 && movedThisIteration) {
                anyMoveInFirstOuterIteration = true;
            }

            if (tracePasses) {
                System.out.println("Insertion step i=" + i + ": " + Arrays.toString(arr));
            }
        }

        // Best-case for insertion sort: already sorted => first insertion doesn't move anything
        res.alreadySortedBestCase = !anyMoveInFirstOuterIteration;
        return res;
    }

    private static int[] topKMedalists(int[] scores, int k) {
        // Medalists are top scores; medals: 1st highest, etc.
        // Tie-break: higher score first; if same score, lower athlete index first.
        int n = scores.length;

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        Arrays.sort(indices, (a, b) -> {
            if (scores[b] != scores[a]) return Integer.compare(scores[b], scores[a]); // desc score
            return Integer.compare(a, b); // asc index
        });

        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            // athlete id here = index + 1 for readability
            topK[i] = indices[i] + 1;
        }
        return topK;
    }

    public static void main(String[] args) {
        // Scenario: 50 athletes with scores (sample data)
        int[] scores = {
                88, 76, 95, 67, 90,
                82, 79, 94, 85, 71,
                99, 60, 73, 88, 92,
                81, 77, 89, 93, 65,
                74, 91, 86, 80, 69,
                97, 72, 84, 66, 78,
                98, 63, 70, 87, 75,
                83, 96, 68, 61, 82,
                90, 64, 95, 59, 73,
                91, 87, 92, 88, 84
        };

        int k = 3;
        int[] medalists = topKMedalists(scores, k);
        System.out.println("Top-" + k + " medalists (athleteId=index+1) by score:");
        System.out.println(Arrays.toString(medalists));
        System.out.println();

        // Trace for array [64, 25, 12, 22, 11]
        int[] base = {64, 25, 12, 22, 11};

        System.out.println("--- Bubble Sort on [64, 25, 12, 22, 11] ---");
        int[] bubbleArr = Arrays.copyOf(base, base.length);
        BubbleResult bRes = bubbleSortWithTrace(bubbleArr, true);
        System.out.println("Total swaps: " + bRes.totalSwaps);
        System.out.println("Already sorted (best case)?: " + bRes.alreadySortedBestCase);
        System.out.println("Sorted array: " + Arrays.toString(bubbleArr));
        System.out.println();

        System.out.println("--- Insertion Sort on [64, 25, 12, 22, 11] ---");
        int[] insArr = Arrays.copyOf(base, base.length);
        InsertionResult iRes = insertionSortWithTrace(insArr, true);
        System.out.println("Total moves/shifts: " + iRes.totalMoves);
        System.out.println("Already sorted (best case)?: " + iRes.alreadySortedBestCase);
        System.out.println("Sorted array: " + Arrays.toString(insArr));
    }
}

