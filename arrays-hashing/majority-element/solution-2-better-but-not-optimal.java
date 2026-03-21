// Majority Element - Better but not optimal
// Time: O(N) | Space: O(N)
// 

class Solution {
    //better than brute force but not than optimal
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            if(map.get(nums[i]) > nums.length/2)    return nums[i];
        }
        return -1;
        
        
    }
}