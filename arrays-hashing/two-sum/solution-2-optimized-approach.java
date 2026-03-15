// Two Sum - Optimized Approach
// Time: O(N) | Space: O(N)
// 

class Solution {
    //Optimized Approach
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i< nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }
}