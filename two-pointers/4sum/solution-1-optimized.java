// 4sum - Optimized
// Time: O(N^3) | Space: O(1)
// 

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // skip duplicate value for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {
                // skip duplicate value for j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    /*
                     IMPORTANT NOTE:
                     Do NOT write:
                     long sum = (long)(nums[i] + nums[j] + nums[left] + nums[right]);

                     Why wrong?
                     - nums[...] are int
                     - Java first adds all of them as int
                     - overflow can happen before casting

                     Example:
                     1000000000 + 1000000000 + 1000000000 + 1000000000
                     = 4000000000 (too large for int)
                     int overflows to a wrong negative value

                     Correct:
                     cast one number first, so whole expression becomes long
                    */
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        left++;
                        right--;

                        // skip duplicate values for left
                        while (left < right && nums[left] == nums[left - 1]) left++;

                        // skip duplicate values for right
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } 
                    else if (sum < target) {
                        left++;
                    } 
                    else {
                        right--;
                    }
                }
            }
        }

        return result;
    }
}