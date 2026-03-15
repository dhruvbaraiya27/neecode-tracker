// Contains Duplicate III - using map(TLE)
// Time: O(N^2) | Space: O(N)
// TLE

class Solution {
    //using map
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            for(int num : map.keySet()) {
                if(Math.abs(nums[i] - num) <= valueDiff && (i - map.get(num) <= indexDiff))
                {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}