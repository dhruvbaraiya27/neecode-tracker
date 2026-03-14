// Contains Duplicate - Brute force
// Time: O(n^2) | Space: O(1)
// Time limit exceeds

class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}