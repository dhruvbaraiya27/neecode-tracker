// Contains Duplicate II - Brute Force
// Time: O(N*k) | Space: O(1)
// 

class Solution {
    //Brute force
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)    return false;
        for(int i=0; i< nums.length; i++) {
            for(int j=i+1; j<nums.length && j - i <= k; j++) {
                if(nums[i] == nums[j])  return true;
            }
        }
        return false;
    }
}