// Contains Duplicate III - Brute force
// Time: O(N^2) | Space: O(1)
// TLE

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length && j-i <=indexDiff; j++) {
                if((Math.abs((long)nums[j] - (long)nums[i])) <= valueDiff)
                {
                    return true;
                }
            }
        }
        return false;
    }
}