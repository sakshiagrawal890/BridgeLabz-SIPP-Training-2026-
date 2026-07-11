import java.util.Arrays;

public class PairSumFraudDetection {
    public int[] findPairSum(int[] transactions, int target) {
        int left = 0;
        int right = transactions.length - 1;

        while (left < right) {
            int sum = transactions[left] + transactions[right];
            if (sum == target) {
                return new int[]{transactions[left], transactions[right]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        PairSumFraudDetection app = new PairSumFraudDetection();
        int[] transactions = {1, 2, 4, 6, 8, 10};
        System.out.println("Pair sum: " + Arrays.toString(app.findPairSum(transactions, 10)));
    }
}
