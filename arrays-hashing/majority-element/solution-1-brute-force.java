// Majority Element - Brute force
// Time: O(N^2) | Space: O(1)
// 

class Solution {
    //Brute force
    public int majorityElement(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int count =0;
            for(int j=0;j<nums.length;j++) {
                if(nums[j]==nums[i])    count++;
            }
            if(count > nums.length/2)   return nums[i];
        }
        return -1;
        
    }
}