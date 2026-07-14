import java.util.Arrays;

public class FirstLastOccurrenceDemo {
    static int[] firstAndLastOccurrence(int[] arr, int target) {
        int first = -1, last = -1;

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                first = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return new int[]{first, last};
    }

    public static void main(String[] args) {
        int[] repeated = {1, 2, 2, 2, 3, 4, 5};
        System.out.println("First/last occurrence: " + Arrays.toString(firstAndLastOccurrence(repeated, 2)));
    }
}
