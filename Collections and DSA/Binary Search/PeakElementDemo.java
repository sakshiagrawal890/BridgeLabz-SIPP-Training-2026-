public class PeakElementDemo {
    static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] peakArr = {1, 2, 3, 1};
        System.out.println("Peak element: " + findPeakElement(peakArr));
    }
}
