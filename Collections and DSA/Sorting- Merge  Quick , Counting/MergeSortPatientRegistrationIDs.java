import java.util.Scanner;

public class MergeSortPatientRegistrationIDs {
    public static void mergeSort(long[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        long[] temp = new long[array.length];
        mergeSort(array, temp, 0, array.length - 1);
    }

    private static void mergeSort(long[] array, long[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(array, temp, left, mid);
        mergeSort(array, temp, mid + 1, right);
        merge(array, temp, left, mid, right);
    }

    private static void merge(long[] array, long[] temp, int left, int mid, int right) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] ids = new long[n];
        for (int i = 0; i < n; i++) {
            ids[i] = scanner.nextLong();
        }
        mergeSort(ids);
        System.out.print("[");
        for (int i = 0; i < ids.length; i++) {
            System.out.print(ids[i]);
            if (i < ids.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println("]");
        scanner.close();
    }
}
