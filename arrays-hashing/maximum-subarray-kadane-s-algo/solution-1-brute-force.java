// Maximum Subarray(Kadane's Algo) - Brute force
// Time: O(N^2) | Space: O(1)
// TLE

class Solution {
    //Kadane's Algo
    //Brute force
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;

            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }
}