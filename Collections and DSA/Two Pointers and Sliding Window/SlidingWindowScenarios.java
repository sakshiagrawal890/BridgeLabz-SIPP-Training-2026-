import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindowScenarios {

    // Scenario 1: Pair Sum
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

    // Scenario 2: Triplets
    public List<List<Integer>> findTriplets(int[] jobs, int target) {
        Arrays.sort(jobs);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < jobs.length - 2; i++) {
            if (i > 0 && jobs[i] == jobs[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = jobs.length - 1;

            while (left < right) {
                int sum = jobs[i] + jobs[left] + jobs[right];
                if (sum == target) {
                    result.add(Arrays.asList(jobs[i], jobs[left], jobs[right]));

                    while (left < right && jobs[left] == jobs[left + 1]) {
                        left++;
                    }
                    while (left < right && jobs[right] == jobs[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    // Scenario 3: Fixed Window
    public int maxSubarrayOfSizeK(int[] cpuLoad, int k) {
        if (cpuLoad == null || cpuLoad.length < k) {
            throw new IllegalArgumentException("Invalid input");
        }

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {
            windowSum += cpuLoad[end];

            if (end >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }

    // Scenario 4: Minimum Window Substring
    public String minWindowSubstring(String s, String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int required = need.size();
        int formed = 0;

        int start = 0;
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;

        for (int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()) {
                formed++;
            }

            while (formed == required) {
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                char leftChar = s.charAt(start);
                window.put(leftChar, window.get(leftChar) - 1);

                if (need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)) {
                    formed--;
                }

                start++;
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

    // Scenario 5: Longest Subarray With At Most N Distinct Elements
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
        SlidingWindowScenarios app = new SlidingWindowScenarios();

        int[] transactions = {1, 2, 4, 6, 8, 10};
        System.out.println("Pair sum: " + Arrays.toString(app.findPairSum(transactions, 10)));

        int[] jobs = {0, -1, 2, -3, 1};
        System.out.println("Triplets: " + app.findTriplets(jobs, -1));

        int[] cpuLoad = {2, 1, 5, 1, 3, 2};
        System.out.println("Max window sum: " + app.maxSubarrayOfSizeK(cpuLoad, 3));

        System.out.println("Min window substring: " + app.minWindowSubstring("ADOBECODEBANC", "ABC"));

        int[] keyIds = {1, 2, 1, 2, 3};
        System.out.println("Longest subarray with at most 2 distinct: " + app.longestSubarrayWithAtMostNDistinct(keyIds, 2));
    }
}
