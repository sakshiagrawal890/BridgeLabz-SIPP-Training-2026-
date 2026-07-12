import java.util.Scanner;

public class CountingSortGenreCodes {
    public static void countingSort(int[] array, int minValue, int maxValue) {
        if (array == null || array.length == 0) {
            return;
        }
        int range = maxValue - minValue + 1;
        int[] count = new int[range];
        for (int value : array) {
            count[value - minValue]++;
        }
        int index = 0;
        for (int i = 0; i < range; i++) {
            while (count[i] > 0) {
                array[index++] = i + minValue;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] genres = new int[n];
        for (int i = 0; i < n; i++) {
            genres[i] = scanner.nextInt();
        }
        countingSort(genres, 1, 20);
        for (int i = 0; i < genres.length; i++) {
            System.out.print(genres[i]);
            if (i < genres.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        scanner.close();
    }
}
