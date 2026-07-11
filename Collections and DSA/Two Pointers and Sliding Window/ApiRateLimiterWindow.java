import java.util.HashMap;
import java.util.Map;

public class ApiRateLimiterWindow {
    public int longestSubarrayWithAtMostNDistinct(int[] keyIds, int n) {
        if (keyIds == null || keyIds.length == 0) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < keyIds.length; end++) {
            freq.put(keyIds[end], freq.getOrDefault(keyIds[end], 0) + 1);

            while (freq.size() > n) {
                int leftKey = keyIds[start];
                freq.put(leftKey, freq.get(leftKey) - 1);
                if (freq.get(leftKey) == 0) {
                    freq.remove(leftKey);
                }
                start++;
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        ApiRateLimiterWindow app = new ApiRateLimiterWindow();
        int[] keyIds = {1, 2, 1, 2, 3};
        System.out.println("Longest subarray with at most 2 distinct: " + app.longestSubarrayWithAtMostNDistinct(keyIds, 2));
    }
}
