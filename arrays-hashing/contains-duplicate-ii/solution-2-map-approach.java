// Contains Duplicate II - Map Approach
// Time: O(N) | Space: O(N)
// track last index of each element and verify

class Solution {
    //Brute force
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0)    return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i - map.get(nums[i]) <= k)   return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}