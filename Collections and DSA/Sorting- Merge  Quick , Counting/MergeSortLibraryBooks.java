import java.util.Arrays;
import java.util.Random;

public class MergeSortLibraryBooks {
    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] temp = new int[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, temp, left, mid);
        mergeSort(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    private static void merge(int[] array, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= right) {
            temp[k++] = array[j++];
        }
        for (int idx = left; idx <= right; idx++) {
            array[idx] = temp[idx];
        }
    }

    public static long timeMergeSort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        long start = System.nanoTime();
        mergeSort(copy);
        return System.nanoTime() - start;
    }

    public static int[] randomBookYears(int n) {
        Random random = new Random(123);
        int[] years = new int[n];
        for (int i = 0; i < n; i++) {
            years[i] = 1900 + random.nextInt(124); // years 1900..2023
        }
        return years;
    }

    public static void main(String[] args) {
        int[] sampleYears = {1998, 2005, 1899, 2020, 2015, 1950};
        System.out.println("Library book years before: " + Arrays.toString(sampleYears));
        mergeSort(sampleYears);
        System.out.println("Sorted years: " + Arrays.toString(sampleYears));
        System.out.println();

        int[] sizes = {100, 1000, 10000};
        for (int size : sizes) {
            int[] data = randomBookYears(size);
            long timeMs = timeMergeSort(data) / 1_000_000;
            System.out.printf("Merge Sort on %d book years: %d ms%n", size, timeMs);
        }
    }
}
