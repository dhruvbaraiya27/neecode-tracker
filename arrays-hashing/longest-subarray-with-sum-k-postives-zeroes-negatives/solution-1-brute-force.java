// Longest Subarray with Sum K(Postives, Zeroes, Negatives) - Brute force
// Time: O(N^2) | Space: O(1)
// 

// User function Template for Java

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int maxLength = 0;
        for(int i=0; i<arr.length; i++) {
            int sum=0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
                if(sum == k) {
                    maxLength = Math.max(j-i+1, maxLength);
                }
            }
        }
        return maxLength;
    }
}