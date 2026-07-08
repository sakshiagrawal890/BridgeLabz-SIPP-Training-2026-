import java.util.Arrays;

public class InsertionSortEmployeeIds {

    public static int insertionSort(int[] ids, boolean trace) {
        int moves = 0;
        int n = ids.length;

        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
                moves++;
            }
            ids[j + 1] = key;

            if (trace) {
                System.out.println("After i=" + i + ": " + Arrays.toString(ids));
            }
        }

        return moves;
    }

    public static void main(String[] args) {
        int[] employeeIds = {1045, 9801, 1200, 7600, 1010};
        System.out.println("Original IDs: " + Arrays.toString(employeeIds));
        int moves = insertionSort(employeeIds, true);
        System.out.println("Sorted IDs:   " + Arrays.toString(employeeIds));
        System.out.println("Total moves/shifts: " + moves);
    }
}

