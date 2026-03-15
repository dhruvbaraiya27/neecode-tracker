// Longest Subarray with Sum K(Postives, Zeroes, Negatives) - Optimized Approach
// Time: O(N) | Space: O(N)
// we can do better if we only have positives and zeros.

// User function Template for Java

class Solution {
    
    //if it has positives, negatices and zeros
    public int longestSubarray(int[] arr, int k) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            // if subarray from 0 to i has sum k
            if (sum == k) {
                maxLen = i + 1;
            }

            // if there was a previous prefix sum = sum - k
            if (map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }

            // store first occurrence only just for maximize
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return maxLen;
    }
}
