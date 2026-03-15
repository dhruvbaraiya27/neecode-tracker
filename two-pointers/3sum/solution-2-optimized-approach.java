// 3Sum - Optimized Approach
// Time: O(N^2) | Space: O(1)
// 

class Solution {
    //Optimized Approach
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(i!=0 && nums[i]==nums[i-1])  continue;
            int left = i+1, right = nums.length-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(sum==0) {
                    while(left < right && nums[left]==nums[left+1]) left++;
                    while(left < right && nums[right]==nums[right-1])   right--;
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }
                else if(sum <0) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}