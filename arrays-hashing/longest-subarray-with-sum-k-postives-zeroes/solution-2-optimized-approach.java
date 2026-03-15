// Longest Subarray with Sum K(Postives, Zeroes) - Optimized Approach
// Time: O(N) | Space: O(1)
// 

public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int left = 0;        // left pointer of the sliding window
        long sum = 0;         // current window sum
        int maxLen = 0;      // store the maximum length found

        // expand the window by moving the right pointer
        for (int right = 0; right < a.length; right++) {

            // add current element to the window sum
            sum += a[right];

            /*
             If sum becomes greater than k,
             shrink the window from the left
             because all numbers are positive.
             Removing elements will reduce the sum.
            */
            while (sum > k && left <= right) {
                sum -= a[left];  // remove left element from sum
                left++;             // move left pointer forward
            }

            /*
             If sum equals k, we found a valid subarray
             calculate its length
            */
            if (sum == k) {
                int length = right - left + 1;
                maxLen = Math.max(maxLen, length);
            }
        }

        // return longest length found
        return maxLen;
    }
}